package com.launchdarkly.sdk.android;

import com.launchdarkly.logging.LDLogLevel;
import com.launchdarkly.logging.LDLogger;
import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.android.DataModel;
import com.launchdarkly.sdk.android.LDFailure;
import com.launchdarkly.sdk.android.PersistentDataStoreWrapper;
import com.launchdarkly.sdk.android.subsystems.Callback;
import com.launchdarkly.sdk.android.subsystems.ClientContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

final class ContextDataManager {
    static final ContextHasher HASHER = new ContextHasher();
    private final CopyOnWriteArrayList<LDAllFlagsListener> allFlagsListeners = new CopyOnWriteArrayList<>();
    private volatile LDContext currentContext;
    private final PersistentDataStoreWrapper.PerEnvironmentData environmentStore;
    private volatile EnvironmentData flags = new EnvironmentData();
    private volatile String flagsContextId = null;
    private volatile ContextIndex index = null;
    private final ConcurrentHashMap<String, Set<FeatureFlagChangeListener>> listeners = new ConcurrentHashMap<>();
    private final LDLogger logger;
    private final int maxCachedContexts;
    private final TaskExecutor taskExecutor;
    private final Object writerLock = new Object();

    ContextDataManager(ClientContext clientContext, PersistentDataStoreWrapper.PerEnvironmentData perEnvironmentData, int i) {
        this.currentContext = clientContext.getEvaluationContext();
        this.environmentStore = perEnvironmentData;
        this.maxCachedContexts = i;
        this.taskExecutor = ClientContextImpl.get(clientContext).getTaskExecutor();
        this.logger = clientContext.getBaseLogger();
    }

    public LDContext getCurrentContext() {
        return this.currentContext;
    }

    public void setCurrentContext(LDContext lDContext) {
        this.currentContext = lDContext;
    }

    public EnvironmentData getStoredData(LDContext lDContext) {
        return this.environmentStore.getContextData(hashedContextId(lDContext));
    }

    public void initData(LDContext lDContext, EnvironmentData environmentData) {
        this.logger.debug("Initializing with new flag data for this context");
        initDataInternal(lDContext, environmentData, true);
    }

    public boolean initFromStoredData(LDContext lDContext) {
        EnvironmentData storedData = getStoredData(lDContext);
        if (storedData == null) {
            this.logger.debug("No stored flag data is available for this context");
            return false;
        }
        this.logger.debug("Using stored flag data for this context");
        initDataInternal(lDContext, storedData, false);
        return true;
    }

    private void initDataInternal(LDContext lDContext, EnvironmentData environmentData, boolean z) {
        EnvironmentData environmentData2;
        ContextIndex prune;
        ArrayList<String> arrayList = new ArrayList<>();
        String hashedContextId = hashedContextId(lDContext);
        synchronized (this.writerLock) {
            this.currentContext = lDContext;
            environmentData2 = this.flags;
            this.flags = environmentData;
            if (this.index == null) {
                this.index = this.environmentStore.getIndex();
            }
            prune = this.index.updateTimestamp(hashedContextId, System.currentTimeMillis()).prune(this.maxCachedContexts, arrayList);
            this.index = prune;
            this.flagsContextId = hashedContextId;
        }
        for (String str : arrayList) {
            this.environmentStore.removeContextData(str);
            this.logger.debug("Removed flag data for context {} from persistent store", (Object) str);
        }
        if (z && this.maxCachedContexts != 0) {
            this.environmentStore.setContextData(hashedContextId, environmentData);
            this.logger.debug("Updated flag data for context {} in persistent store", (Object) hashedContextId);
        }
        if (this.logger.isEnabled(LDLogLevel.DEBUG)) {
            this.logger.debug("Stored context index is now: {}", (Object) prune.toJson());
        }
        this.environmentStore.setIndex(prune);
        HashSet hashSet = new HashSet();
        for (DataModel.Flag next : environmentData.values()) {
            DataModel.Flag flag = environmentData2.getFlag(next.getKey());
            if (flag == null || !flag.getValue().equals(next.getValue())) {
                hashSet.add(next.getKey());
            }
        }
        for (DataModel.Flag next2 : environmentData2.values()) {
            if (environmentData.getFlag(next2.getKey()) == null) {
                hashSet.add(next2.getKey());
            }
        }
        notifyAllFlagsListeners(hashSet);
        notifyFlagListeners(hashSet);
    }

    public void initDataFromJson(LDContext lDContext, String str, Callback<Void> callback) {
        try {
            initData(this.currentContext, EnvironmentData.fromJson(str));
            callback.onSuccess(null);
        } catch (Exception e) {
            this.logger.debug("Received invalid JSON flag data: {}", (Object) str);
            callback.onError(new LDFailure("Invalid JSON received from flags endpoint", e, LDFailure.FailureType.INVALID_RESPONSE_BODY));
        }
    }

    public DataModel.Flag getNonDeletedFlag(String str) {
        DataModel.Flag flag = this.flags.getFlag(str);
        if (flag == null || flag.isDeleted()) {
            return null;
        }
        return flag;
    }

    public EnvironmentData getAllNonDeleted() {
        EnvironmentData environmentData = this.flags;
        for (DataModel.Flag isDeleted : environmentData.values()) {
            if (isDeleted.isDeleted()) {
                HashMap hashMap = new HashMap();
                for (DataModel.Flag next : environmentData.values()) {
                    if (!next.isDeleted()) {
                        hashMap.put(next.getKey(), next);
                    }
                }
                return EnvironmentData.usingExistingFlagsMap(hashMap);
            }
        }
        return environmentData;
    }

    public boolean upsert(DataModel.Flag flag) {
        synchronized (this.writerLock) {
            DataModel.Flag flag2 = this.flags.getFlag(flag.getKey());
            if (flag2 != null && flag2.getVersion() >= flag.getVersion()) {
                return false;
            }
            EnvironmentData withFlagUpdatedOrAdded = this.flags.withFlagUpdatedOrAdded(flag);
            this.flags = withFlagUpdatedOrAdded;
            String str = this.flagsContextId;
            this.environmentStore.setContextData(str, withFlagUpdatedOrAdded);
            List singletonList = Collections.singletonList(flag.getKey());
            notifyAllFlagsListeners(singletonList);
            notifyFlagListeners(singletonList);
            return true;
        }
    }

    public void registerListener(String str, FeatureFlagChangeListener featureFlagChangeListener) {
        Set newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        newSetFromMap.add(featureFlagChangeListener);
        Set putIfAbsent = this.listeners.putIfAbsent(str, newSetFromMap);
        if (putIfAbsent != null) {
            putIfAbsent.add(featureFlagChangeListener);
            this.logger.debug("Added listener. Total count: [{}]", (Object) Integer.valueOf(putIfAbsent.size()));
            return;
        }
        this.logger.debug("Added listener. Total count: 1");
    }

    public void unregisterListener(String str, FeatureFlagChangeListener featureFlagChangeListener) {
        Set set = this.listeners.get(str);
        if (set != null && set.remove(featureFlagChangeListener)) {
            this.logger.debug("Removing listener for key: [{}]", (Object) str);
        }
    }

    public void registerAllFlagsListener(LDAllFlagsListener lDAllFlagsListener) {
        this.allFlagsListeners.add(lDAllFlagsListener);
    }

    public void unregisterAllFlagsListener(LDAllFlagsListener lDAllFlagsListener) {
        this.allFlagsListeners.remove(lDAllFlagsListener);
    }

    public Collection<FeatureFlagChangeListener> getListenersByKey(String str) {
        Set set = this.listeners.get(str);
        return set == null ? new HashSet() : set;
    }

    public static String hashedContextId(LDContext lDContext) {
        return HASHER.hash(lDContext.getFullyQualifiedKey());
    }

    private void notifyFlagListeners(Collection<String> collection) {
        if (collection != null && !collection.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (String next : collection) {
                Set set = this.listeners.get(next);
                if (set != null && !set.isEmpty()) {
                    hashMap.put(next, set);
                }
            }
            if (!hashMap.isEmpty()) {
                this.taskExecutor.executeOnMainThread(new ContextDataManager$$ExternalSyntheticLambda1(hashMap));
            }
        }
    }

    static /* synthetic */ void lambda$notifyFlagListeners$0(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            for (FeatureFlagChangeListener onFeatureFlagChange : (Set) entry.getValue()) {
                onFeatureFlagChange.onFeatureFlagChange((String) entry.getKey());
            }
        }
    }

    private void notifyAllFlagsListeners(Collection<String> collection) {
        if (collection != null && !collection.isEmpty() && !this.allFlagsListeners.isEmpty()) {
            this.taskExecutor.executeOnMainThread(new ContextDataManager$$ExternalSyntheticLambda0(this, new ArrayList(collection)));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$notifyAllFlagsListeners$1$com-launchdarkly-sdk-android-ContextDataManager  reason: not valid java name */
    public /* synthetic */ void m450lambda$notifyAllFlagsListeners$1$comlaunchdarklysdkandroidContextDataManager(List list) {
        Iterator<LDAllFlagsListener> it = this.allFlagsListeners.iterator();
        while (it.hasNext()) {
            it.next().onChange(list);
        }
    }
}
