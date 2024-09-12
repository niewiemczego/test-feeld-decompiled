package com.launchdarkly.sdk.android;

import com.launchdarkly.logging.LDLogger;
import com.launchdarkly.sdk.ContextKind;
import com.launchdarkly.sdk.android.subsystems.PersistentDataStore;
import com.launchdarkly.sdk.internal.GsonHelpers;
import com.launchdarkly.sdk.json.SerializationException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

final class PersistentDataStoreWrapper {
    private static final String ANON_CONTEXT_KEY_PREFIX = "anonKey_";
    private static final String ENVIRONMENT_CONTEXT_DATA_KEY_PREFIX = "flags_";
    private static final String ENVIRONMENT_LAST_FAILURE_KEY = "lastFailure";
    private static final String ENVIRONMENT_LAST_FAILURE_TIME_KEY = "lastFailedConnection";
    private static final String ENVIRONMENT_LAST_SUCCESS_TIME_KEY = "lastSuccessfulConnection";
    private static final String ENVIRONMENT_METADATA_KEY = "index";
    private static final String GLOBAL_NAMESPACE = "LaunchDarkly";
    private static final String NAMESPACE_PREFIX = "LaunchDarkly_";
    private final AtomicBoolean loggedStorageError = new AtomicBoolean(false);
    private final LDLogger logger;
    private final PersistentDataStore persistentStore;
    private final Object storeLock = new Object();

    static class SavedConnectionInfo {
        final LDFailure lastFailure;
        final Long lastFailureTime;
        final Long lastSuccessTime;

        SavedConnectionInfo(Long l, Long l2, LDFailure lDFailure) {
            this.lastSuccessTime = l;
            this.lastFailureTime = l2;
            this.lastFailure = lDFailure;
        }
    }

    public PersistentDataStoreWrapper(PersistentDataStore persistentDataStore, LDLogger lDLogger) {
        this.persistentStore = persistentDataStore;
        this.logger = lDLogger;
    }

    public PerEnvironmentData perEnvironmentData(String str) {
        return new PerEnvironmentData(str);
    }

    public String getGeneratedContextKey(ContextKind contextKind) {
        return tryGetValue(GLOBAL_NAMESPACE, ANON_CONTEXT_KEY_PREFIX + contextKind.toString());
    }

    public void setGeneratedContextKey(ContextKind contextKind, String str) {
        trySetValue(GLOBAL_NAMESPACE, ANON_CONTEXT_KEY_PREFIX + contextKind.toString(), str);
    }

    final class PerEnvironmentData {
        private final String environmentNamespace;

        PerEnvironmentData(String str) {
            this.environmentNamespace = PersistentDataStoreWrapper.NAMESPACE_PREFIX + LDUtil.urlSafeBase64Hash(str);
        }

        public EnvironmentData getContextData(String str) {
            PersistentDataStoreWrapper persistentDataStoreWrapper = PersistentDataStoreWrapper.this;
            String access$100 = persistentDataStoreWrapper.tryGetValue(this.environmentNamespace, persistentDataStoreWrapper.keyForContextId(str));
            if (access$100 == null) {
                return null;
            }
            try {
                return EnvironmentData.fromJson(access$100);
            } catch (SerializationException unused) {
                return null;
            }
        }

        public void setContextData(String str, EnvironmentData environmentData) {
            PersistentDataStoreWrapper persistentDataStoreWrapper = PersistentDataStoreWrapper.this;
            persistentDataStoreWrapper.trySetValue(this.environmentNamespace, persistentDataStoreWrapper.keyForContextId(str), environmentData.toJson());
        }

        public void removeContextData(String str) {
            PersistentDataStoreWrapper persistentDataStoreWrapper = PersistentDataStoreWrapper.this;
            persistentDataStoreWrapper.trySetValue(this.environmentNamespace, persistentDataStoreWrapper.keyForContextId(str), (String) null);
        }

        public ContextIndex getIndex() {
            String access$100 = PersistentDataStoreWrapper.this.tryGetValue(this.environmentNamespace, "index");
            if (access$100 != null) {
                return ContextIndex.fromJson(access$100);
            }
            try {
                return new ContextIndex();
            } catch (SerializationException unused) {
                return null;
            }
        }

        public void setIndex(ContextIndex contextIndex) {
            PersistentDataStoreWrapper.this.trySetValue(this.environmentNamespace, "index", contextIndex.toJson());
        }

        public SavedConnectionInfo getConnectionInfo() {
            LDFailure lDFailure;
            Long access$300 = PersistentDataStoreWrapper.this.tryGetValueAsLong(this.environmentNamespace, PersistentDataStoreWrapper.ENVIRONMENT_LAST_SUCCESS_TIME_KEY);
            Long access$3002 = PersistentDataStoreWrapper.this.tryGetValueAsLong(this.environmentNamespace, PersistentDataStoreWrapper.ENVIRONMENT_LAST_FAILURE_TIME_KEY);
            String access$100 = PersistentDataStoreWrapper.this.tryGetValue(this.environmentNamespace, PersistentDataStoreWrapper.ENVIRONMENT_LAST_FAILURE_KEY);
            if (access$100 != null) {
                try {
                    lDFailure = (LDFailure) GsonHelpers.gsonInstance().fromJson(access$100, LDFailure.class);
                } catch (Exception unused) {
                }
                return new SavedConnectionInfo(access$300, access$3002, lDFailure);
            }
            lDFailure = null;
            return new SavedConnectionInfo(access$300, access$3002, lDFailure);
        }

        public void setConnectionInfo(SavedConnectionInfo savedConnectionInfo) {
            HashMap hashMap = new HashMap();
            String str = null;
            hashMap.put(PersistentDataStoreWrapper.ENVIRONMENT_LAST_SUCCESS_TIME_KEY, savedConnectionInfo.lastSuccessTime == null ? null : String.valueOf(savedConnectionInfo.lastSuccessTime));
            hashMap.put(PersistentDataStoreWrapper.ENVIRONMENT_LAST_FAILURE_TIME_KEY, savedConnectionInfo.lastFailureTime == null ? null : String.valueOf(savedConnectionInfo.lastFailureTime));
            if (savedConnectionInfo.lastFailure != null) {
                str = GsonHelpers.gsonInstance().toJson((Object) savedConnectionInfo.lastFailure);
            }
            hashMap.put(PersistentDataStoreWrapper.ENVIRONMENT_LAST_FAILURE_KEY, str);
            PersistentDataStoreWrapper.this.trySetValues(this.environmentNamespace, hashMap);
        }
    }

    /* access modifiers changed from: private */
    public String keyForContextId(String str) {
        return ENVIRONMENT_CONTEXT_DATA_KEY_PREFIX + str;
    }

    /* access modifiers changed from: private */
    public String tryGetValue(String str, String str2) {
        String value;
        try {
            synchronized (this.storeLock) {
                value = this.persistentStore.getValue(str, str2);
            }
            return value;
        } catch (Exception e) {
            maybeLogStoreError(e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void trySetValue(String str, String str2, String str3) {
        try {
            synchronized (this.storeLock) {
                this.persistentStore.setValue(str, str2, str3);
            }
        } catch (Exception e) {
            maybeLogStoreError(e);
        }
    }

    /* access modifiers changed from: private */
    public void trySetValues(String str, Map<String, String> map) {
        try {
            synchronized (this.storeLock) {
                this.persistentStore.setValues(str, map);
            }
        } catch (Exception e) {
            maybeLogStoreError(e);
        }
    }

    private void maybeLogStoreError(Exception exc) {
        if (!this.loggedStorageError.getAndSet(true)) {
            LDUtil.logExceptionAtErrorLevel(this.logger, exc, "Failure in persistent data store", new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public Long tryGetValueAsLong(String str, String str2) {
        String tryGetValue = tryGetValue(str, str2);
        if (tryGetValue == null) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(tryGetValue));
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
