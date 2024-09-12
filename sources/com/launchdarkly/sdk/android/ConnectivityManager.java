package com.launchdarkly.sdk.android;

import com.launchdarkly.logging.LDLogger;
import com.launchdarkly.logging.LogValues;
import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.android.ConnectionInformation;
import com.launchdarkly.sdk.android.DataModel;
import com.launchdarkly.sdk.android.LDFailure;
import com.launchdarkly.sdk.android.PersistentDataStoreWrapper;
import com.launchdarkly.sdk.android.PlatformState;
import com.launchdarkly.sdk.android.subsystems.Callback;
import com.launchdarkly.sdk.android.subsystems.ClientContext;
import com.launchdarkly.sdk.android.subsystems.ComponentConfigurer;
import com.launchdarkly.sdk.android.subsystems.DataSource;
import com.launchdarkly.sdk.android.subsystems.DataSourceUpdateSink;
import com.launchdarkly.sdk.android.subsystems.EventProcessor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

class ConnectivityManager {
    private static final long MAX_RETRY_TIME_MS = 60000;
    private static final long RETRY_TIME_MS = 1000;
    private final boolean backgroundUpdatingDisabled;
    private final ClientContext baseClientContext;
    private final AtomicBoolean closed;
    /* access modifiers changed from: private */
    public final ConnectionInformationState connectionInformation;
    private final PlatformState.ConnectivityChangeListener connectivityChangeListener;
    /* access modifiers changed from: private */
    public final ContextDataManager contextDataManager;
    private final AtomicReference<DataSource> currentDataSource;
    /* access modifiers changed from: private */
    public final AtomicReference<LDContext> currentEvaluationContext;
    private final ComponentConfigurer<DataSource> dataSourceFactory;
    private final DataSourceUpdateSink dataSourceUpdateSink;
    private final PersistentDataStoreWrapper.PerEnvironmentData environmentStore;
    private final EventProcessor eventProcessor;
    private final AtomicBoolean forcedOffline;
    private final PlatformState.ForegroundChangeListener foregroundListener;
    /* access modifiers changed from: private */
    public volatile boolean initialized;
    /* access modifiers changed from: private */
    public final LDLogger logger;
    private final PlatformState platformState;
    private final Debounce pollDebouncer = new Debounce();
    private final AtomicReference<Boolean> previouslyInBackground;
    private final AtomicBoolean started;
    private final List<WeakReference<LDStatusListener>> statusListeners = new ArrayList();
    private final TaskExecutor taskExecutor;

    private class DataSourceUpdateSinkImpl implements DataSourceUpdateSink {
        private final AtomicReference<ConnectionInformation.ConnectionMode> connectionMode;
        private final AtomicReference<LDFailure> lastFailure;

        private DataSourceUpdateSinkImpl() {
            this.connectionMode = new AtomicReference<>((Object) null);
            this.lastFailure = new AtomicReference<>((Object) null);
        }

        public void init(Map<String, DataModel.Flag> map) {
            ConnectivityManager.this.contextDataManager.initData((LDContext) ConnectivityManager.this.currentEvaluationContext.get(), EnvironmentData.usingExistingFlagsMap(map));
        }

        public void upsert(DataModel.Flag flag) {
            ConnectivityManager.this.contextDataManager.upsert(flag);
        }

        public void setStatus(ConnectionInformation.ConnectionMode connectionMode2, Throwable th) {
            boolean z;
            LDFailure lDFailure = null;
            ConnectionInformation.ConnectionMode andSet = connectionMode2 == null ? null : this.connectionMode.getAndSet(connectionMode2);
            if (th != null) {
                if (th instanceof LDFailure) {
                    lDFailure = (LDFailure) th;
                } else {
                    lDFailure = new LDFailure("Unknown failure", th, LDFailure.FailureType.UNKNOWN_ERROR);
                }
                this.lastFailure.set(lDFailure);
            }
            boolean z2 = true;
            if (connectionMode2 == null || andSet == connectionMode2) {
                z = false;
            } else {
                if (lDFailure == null && connectionMode2.isConnectionActive()) {
                    ConnectivityManager.this.connectionInformation.setLastSuccessfulConnection(Long.valueOf(System.currentTimeMillis()));
                }
                ConnectivityManager.this.connectionInformation.setConnectionMode(connectionMode2);
                z = true;
            }
            if (lDFailure != null) {
                ConnectivityManager.this.connectionInformation.setLastFailedConnection(Long.valueOf(System.currentTimeMillis()));
                ConnectivityManager.this.connectionInformation.setLastFailure(lDFailure);
            } else {
                z2 = z;
            }
            if (z2) {
                try {
                    ConnectivityManager.this.saveConnectionInformation();
                } catch (Exception e) {
                    LDUtil.logExceptionAtErrorLevel(ConnectivityManager.this.logger, e, "Error saving connection information", new Object[0]);
                }
                ConnectivityManager connectivityManager = ConnectivityManager.this;
                connectivityManager.updateStatusListeners(connectivityManager.connectionInformation);
                if (lDFailure != null) {
                    ConnectivityManager.this.updateListenersOnFailure(lDFailure);
                }
            }
        }

        public void shutDown() {
            ConnectivityManager.this.shutDown();
            setStatus(ConnectionInformation.ConnectionMode.SHUTDOWN, (Throwable) null);
        }
    }

    ConnectivityManager(ClientContext clientContext, ComponentConfigurer<DataSource> componentConfigurer, EventProcessor eventProcessor2, ContextDataManager contextDataManager2, PersistentDataStoreWrapper.PerEnvironmentData perEnvironmentData) {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        this.forcedOffline = atomicBoolean;
        this.started = new AtomicBoolean();
        this.closed = new AtomicBoolean();
        this.currentDataSource = new AtomicReference<>();
        AtomicReference<LDContext> atomicReference = new AtomicReference<>();
        this.currentEvaluationContext = atomicReference;
        this.previouslyInBackground = new AtomicReference<>();
        this.initialized = false;
        this.baseClientContext = clientContext;
        this.dataSourceFactory = componentConfigurer;
        this.dataSourceUpdateSink = new DataSourceUpdateSinkImpl();
        PlatformState platformState2 = ClientContextImpl.get(clientContext).getPlatformState();
        this.platformState = platformState2;
        this.eventProcessor = eventProcessor2;
        this.contextDataManager = contextDataManager2;
        this.environmentStore = perEnvironmentData;
        this.taskExecutor = ClientContextImpl.get(clientContext).getTaskExecutor();
        this.logger = clientContext.getBaseLogger();
        atomicReference.set(clientContext.getEvaluationContext());
        atomicBoolean.set(clientContext.isSetOffline());
        LDConfig config = clientContext.getConfig();
        this.connectionInformation = new ConnectionInformationState();
        readStoredConnectionState();
        this.backgroundUpdatingDisabled = config.isDisableBackgroundPolling();
        ConnectivityManager$$ExternalSyntheticLambda0 connectivityManager$$ExternalSyntheticLambda0 = new ConnectivityManager$$ExternalSyntheticLambda0(this);
        this.connectivityChangeListener = connectivityManager$$ExternalSyntheticLambda0;
        platformState2.addConnectivityChangeListener(connectivityManager$$ExternalSyntheticLambda0);
        ConnectivityManager$$ExternalSyntheticLambda1 connectivityManager$$ExternalSyntheticLambda1 = new ConnectivityManager$$ExternalSyntheticLambda1(this);
        this.foregroundListener = connectivityManager$$ExternalSyntheticLambda1;
        platformState2.addForegroundChangeListener(connectivityManager$$ExternalSyntheticLambda1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-launchdarkly-sdk-android-ConnectivityManager  reason: not valid java name */
    public /* synthetic */ void m448lambda$new$0$comlaunchdarklysdkandroidConnectivityManager(boolean z) {
        updateDataSource(false, LDUtil.noOpCallback());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$1$com-launchdarkly-sdk-android-ConnectivityManager  reason: not valid java name */
    public /* synthetic */ void m449lambda$new$1$comlaunchdarklysdkandroidConnectivityManager(boolean z) {
        DataSource dataSource = this.currentDataSource.get();
        if (dataSource == null || dataSource.needsRefresh(!z, this.currentEvaluationContext.get())) {
            updateDataSource(true, LDUtil.noOpCallback());
        }
    }

    /* access modifiers changed from: package-private */
    public void setEvaluationContext(LDContext lDContext, Callback<Void> callback) {
        DataSource dataSource = this.currentDataSource.get();
        LDContext andSet = this.currentEvaluationContext.getAndSet(lDContext);
        if (andSet == lDContext || andSet.equals(lDContext)) {
            callback.onSuccess(null);
        } else if (dataSource == null || dataSource.needsRefresh(!this.platformState.isForeground(), lDContext)) {
            updateDataSource(true, callback);
        } else {
            callback.onSuccess(null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean updateDataSource(boolean r9, final com.launchdarkly.sdk.android.subsystems.Callback<java.lang.Void> r10) {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.started
            boolean r0 = r0.get()
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            java.util.concurrent.atomic.AtomicBoolean r0 = r8.forcedOffline
            boolean r0 = r0.get()
            com.launchdarkly.sdk.android.PlatformState r2 = r8.platformState
            boolean r2 = r2.isNetworkAvailable()
            com.launchdarkly.sdk.android.PlatformState r3 = r8.platformState
            boolean r3 = r3.isForeground()
            r4 = 1
            r3 = r3 ^ r4
            java.util.concurrent.atomic.AtomicReference<com.launchdarkly.sdk.LDContext> r5 = r8.currentEvaluationContext
            java.lang.Object r5 = r5.get()
            com.launchdarkly.sdk.LDContext r5 = (com.launchdarkly.sdk.LDContext) r5
            com.launchdarkly.sdk.android.subsystems.EventProcessor r6 = r8.eventProcessor
            if (r0 != 0) goto L_0x002f
            if (r2 != 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            r7 = r1
            goto L_0x0030
        L_0x002f:
            r7 = r4
        L_0x0030:
            r6.setOffline(r7)
            com.launchdarkly.sdk.android.subsystems.EventProcessor r6 = r8.eventProcessor
            r6.setInBackground(r3)
            r6 = 0
            if (r0 == 0) goto L_0x004c
            com.launchdarkly.logging.LDLogger r9 = r8.logger
            java.lang.String r0 = "Initialized in offline mode"
            r9.debug(r0)
            r8.initialized = r4
            com.launchdarkly.sdk.android.subsystems.DataSourceUpdateSink r9 = r8.dataSourceUpdateSink
            com.launchdarkly.sdk.android.ConnectionInformation$ConnectionMode r0 = com.launchdarkly.sdk.android.ConnectionInformation.ConnectionMode.SET_OFFLINE
            r9.setStatus(r0, r6)
            goto L_0x0063
        L_0x004c:
            if (r2 != 0) goto L_0x0056
            com.launchdarkly.sdk.android.subsystems.DataSourceUpdateSink r9 = r8.dataSourceUpdateSink
            com.launchdarkly.sdk.android.ConnectionInformation$ConnectionMode r0 = com.launchdarkly.sdk.android.ConnectionInformation.ConnectionMode.OFFLINE
            r9.setStatus(r0, r6)
            goto L_0x0063
        L_0x0056:
            if (r3 == 0) goto L_0x0066
            boolean r0 = r8.backgroundUpdatingDisabled
            if (r0 == 0) goto L_0x0066
            com.launchdarkly.sdk.android.subsystems.DataSourceUpdateSink r9 = r8.dataSourceUpdateSink
            com.launchdarkly.sdk.android.ConnectionInformation$ConnectionMode r0 = com.launchdarkly.sdk.android.ConnectionInformation.ConnectionMode.BACKGROUND_DISABLED
            r9.setStatus(r0, r6)
        L_0x0063:
            r0 = r1
            r9 = r4
            goto L_0x0067
        L_0x0066:
            r0 = r4
        L_0x0067:
            if (r9 == 0) goto L_0x0081
            java.util.concurrent.atomic.AtomicReference<com.launchdarkly.sdk.android.subsystems.DataSource> r9 = r8.currentDataSource
            java.lang.Object r9 = r9.getAndSet(r6)
            com.launchdarkly.sdk.android.subsystems.DataSource r9 = (com.launchdarkly.sdk.android.subsystems.DataSource) r9
            if (r9 == 0) goto L_0x0081
            com.launchdarkly.logging.LDLogger r2 = r8.logger
            java.lang.String r7 = "Stopping current data source"
            r2.debug(r7)
            com.launchdarkly.sdk.android.subsystems.Callback r2 = com.launchdarkly.sdk.android.LDUtil.noOpCallback()
            r9.stop(r2)
        L_0x0081:
            if (r0 == 0) goto L_0x00c6
            java.util.concurrent.atomic.AtomicReference<com.launchdarkly.sdk.android.subsystems.DataSource> r9 = r8.currentDataSource
            java.lang.Object r9 = r9.get()
            if (r9 == 0) goto L_0x008c
            goto L_0x00c6
        L_0x008c:
            com.launchdarkly.logging.LDLogger r9 = r8.logger
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
            java.lang.String r1 = "Creating data source (background={})"
            r9.debug((java.lang.String) r1, (java.lang.Object) r0)
            com.launchdarkly.sdk.android.subsystems.ClientContext r9 = r8.baseClientContext
            com.launchdarkly.sdk.android.subsystems.DataSourceUpdateSink r0 = r8.dataSourceUpdateSink
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r1 = r8.previouslyInBackground
            java.lang.Object r1 = r1.get()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            com.launchdarkly.sdk.android.ClientContextImpl r9 = com.launchdarkly.sdk.android.ClientContextImpl.forDataSource(r9, r0, r5, r3, r1)
            com.launchdarkly.sdk.android.subsystems.ComponentConfigurer<com.launchdarkly.sdk.android.subsystems.DataSource> r0 = r8.dataSourceFactory
            java.lang.Object r9 = r0.build(r9)
            com.launchdarkly.sdk.android.subsystems.DataSource r9 = (com.launchdarkly.sdk.android.subsystems.DataSource) r9
            java.util.concurrent.atomic.AtomicReference<com.launchdarkly.sdk.android.subsystems.DataSource> r0 = r8.currentDataSource
            r0.set(r9)
            java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> r0 = r8.previouslyInBackground
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r3)
            r0.set(r1)
            com.launchdarkly.sdk.android.ConnectivityManager$1 r0 = new com.launchdarkly.sdk.android.ConnectivityManager$1
            r0.<init>(r10)
            r9.start(r0)
            return r4
        L_0x00c6:
            r10.onSuccess(r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.sdk.android.ConnectivityManager.updateDataSource(boolean, com.launchdarkly.sdk.android.subsystems.Callback):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean isInitialized() {
        return this.initialized;
    }

    /* access modifiers changed from: package-private */
    public void registerStatusListener(LDStatusListener lDStatusListener) {
        if (lDStatusListener != null) {
            synchronized (this.statusListeners) {
                this.statusListeners.add(new WeakReference(lDStatusListener));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void unregisterStatusListener(LDStatusListener lDStatusListener) {
        if (lDStatusListener != null) {
            synchronized (this.statusListeners) {
                Iterator<WeakReference<LDStatusListener>> it = this.statusListeners.iterator();
                while (it.hasNext()) {
                    LDStatusListener lDStatusListener2 = (LDStatusListener) it.next().get();
                    if (lDStatusListener2 == null || lDStatusListener2 == lDStatusListener) {
                        it.remove();
                    }
                }
            }
        }
    }

    private void readStoredConnectionState() {
        PersistentDataStoreWrapper.SavedConnectionInfo connectionInfo = this.environmentStore.getConnectionInfo();
        Long l = connectionInfo.lastSuccessTime;
        Long l2 = connectionInfo.lastFailureTime;
        Long l3 = null;
        this.connectionInformation.setLastSuccessfulConnection((l == null || l.longValue() == 0) ? null : Long.valueOf(l.longValue()));
        ConnectionInformationState connectionInformationState = this.connectionInformation;
        if (!(l2 == null || l2.longValue() == 0)) {
            l3 = Long.valueOf(l2.longValue());
        }
        connectionInformationState.setLastFailedConnection(l3);
        this.connectionInformation.setLastFailure(connectionInfo.lastFailure);
    }

    /* access modifiers changed from: private */
    public synchronized void saveConnectionInformation() {
        this.environmentStore.setConnectionInfo(new PersistentDataStoreWrapper.SavedConnectionInfo(this.connectionInformation.getLastSuccessfulConnection(), this.connectionInformation.getLastFailedConnection(), this.connectionInformation.getLastFailure()));
    }

    /* access modifiers changed from: private */
    public void updateStatusListeners(ConnectionInformation connectionInformation2) {
        synchronized (this.statusListeners) {
            Iterator<WeakReference<LDStatusListener>> it = this.statusListeners.iterator();
            while (it.hasNext()) {
                LDStatusListener lDStatusListener = (LDStatusListener) it.next().get();
                if (lDStatusListener == null) {
                    it.remove();
                } else {
                    this.taskExecutor.scheduleTask(new ConnectivityManager$$ExternalSyntheticLambda2(lDStatusListener, connectionInformation2), 0);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void updateListenersOnFailure(LDFailure lDFailure) {
        synchronized (this.statusListeners) {
            Iterator<WeakReference<LDStatusListener>> it = this.statusListeners.iterator();
            while (it.hasNext()) {
                LDStatusListener lDStatusListener = (LDStatusListener) it.next().get();
                if (lDStatusListener == null) {
                    it.remove();
                } else {
                    this.taskExecutor.scheduleTask(new ConnectivityManager$$ExternalSyntheticLambda3(lDStatusListener, lDFailure), 0);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean startUp(com.launchdarkly.sdk.android.subsystems.Callback<java.lang.Void> r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.closed     // Catch:{ all -> 0x002b }
            boolean r0 = r0.get()     // Catch:{ all -> 0x002b }
            r1 = 0
            if (r0 != 0) goto L_0x0029
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.started     // Catch:{ all -> 0x002b }
            r2 = 1
            boolean r0 = r0.getAndSet(r2)     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0014
            goto L_0x0029
        L_0x0014:
            r3.initialized = r1     // Catch:{ all -> 0x002b }
            com.launchdarkly.sdk.android.ContextDataManager r0 = r3.contextDataManager     // Catch:{ all -> 0x002b }
            java.util.concurrent.atomic.AtomicReference<com.launchdarkly.sdk.LDContext> r1 = r3.currentEvaluationContext     // Catch:{ all -> 0x002b }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x002b }
            com.launchdarkly.sdk.LDContext r1 = (com.launchdarkly.sdk.LDContext) r1     // Catch:{ all -> 0x002b }
            r0.initFromStoredData(r1)     // Catch:{ all -> 0x002b }
            boolean r4 = r3.updateDataSource(r2, r4)     // Catch:{ all -> 0x002b }
            monitor-exit(r3)
            return r4
        L_0x0029:
            monitor-exit(r3)
            return r1
        L_0x002b:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.sdk.android.ConnectivityManager.startUp(com.launchdarkly.sdk.android.subsystems.Callback):boolean");
    }

    /* access modifiers changed from: package-private */
    public void shutDown() {
        if (!this.closed.getAndSet(true)) {
            DataSource andSet = this.currentDataSource.getAndSet((Object) null);
            if (andSet != null) {
                andSet.stop(LDUtil.noOpCallback());
            }
            this.platformState.removeForegroundChangeListener(this.foregroundListener);
            this.platformState.removeConnectivityChangeListener(this.connectivityChangeListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void setForceOffline(boolean z) {
        if (z != this.forcedOffline.getAndSet(z)) {
            updateDataSource(false, LDUtil.noOpCallback());
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isForcedOffline() {
        return this.forcedOffline.get();
    }

    /* access modifiers changed from: package-private */
    public synchronized ConnectionInformation getConnectionInformation() {
        return this.connectionInformation;
    }

    static void fetchAndSetData(FeatureFetcher featureFetcher, final LDContext lDContext, final DataSourceUpdateSink dataSourceUpdateSink2, final Callback<Boolean> callback, final LDLogger lDLogger) {
        featureFetcher.fetch(lDContext, new Callback<String>() {
            public void onSuccess(String str) {
                try {
                    dataSourceUpdateSink2.init(EnvironmentData.fromJson(str).getAll());
                    callback.onSuccess(true);
                } catch (Exception e) {
                    LDLogger.this.debug("Received invalid JSON flag data: {}", (Object) str);
                    callback.onError(new LDFailure("Invalid JSON received from flags endpoint", e, LDFailure.FailureType.INVALID_RESPONSE_BODY));
                }
            }

            public void onError(Throwable th) {
                LDLogger.this.error("Error when attempting to get flag data: [{}] [{}]: {}", LDUtil.base64Url(lDContext), lDContext, LogValues.exceptionSummary(th));
                callback.onError(th);
            }
        });
    }
}
