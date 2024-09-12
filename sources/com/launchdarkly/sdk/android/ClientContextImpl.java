package com.launchdarkly.sdk.android;

import com.launchdarkly.logging.LDLogger;
import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.android.subsystems.ClientContext;
import com.launchdarkly.sdk.android.subsystems.DataSourceUpdateSink;
import com.launchdarkly.sdk.android.subsystems.HttpConfiguration;
import com.launchdarkly.sdk.internal.events.DiagnosticStore;

final class ClientContextImpl extends ClientContext {
    private final DiagnosticStore diagnosticStore;
    private final FeatureFetcher fetcher;
    private final PlatformState platformState;
    private final TaskExecutor taskExecutor;

    ClientContextImpl(ClientContext clientContext, DiagnosticStore diagnosticStore2, FeatureFetcher featureFetcher, PlatformState platformState2, TaskExecutor taskExecutor2) {
        super(clientContext);
        this.diagnosticStore = diagnosticStore2;
        this.fetcher = featureFetcher;
        this.platformState = platformState2;
        this.taskExecutor = taskExecutor2;
    }

    static ClientContextImpl fromConfig(LDConfig lDConfig, String str, String str2, FeatureFetcher featureFetcher, LDContext lDContext, LDLogger lDLogger, PlatformState platformState2, TaskExecutor taskExecutor2) {
        LDConfig lDConfig2 = lDConfig;
        boolean z = platformState2 != null && !platformState2.isForeground();
        String str3 = str;
        LDLogger lDLogger2 = lDLogger;
        LDConfig lDConfig3 = lDConfig;
        String str4 = str2;
        LDContext lDContext2 = lDContext;
        boolean z2 = z;
        boolean z3 = z;
        ClientContext clientContext = r0;
        ClientContext clientContext2 = new ClientContext(str3, lDConfig2.applicationInfo, lDLogger2, lDConfig3, (DataSourceUpdateSink) null, str4, lDConfig.isEvaluationReasons(), lDContext2, (HttpConfiguration) null, z2, (Boolean) null, lDConfig2.serviceEndpoints, lDConfig.isOffline());
        ClientContext clientContext3 = new ClientContext(str3, lDConfig2.applicationInfo, lDLogger2, lDConfig3, (DataSourceUpdateSink) null, str4, lDConfig.isEvaluationReasons(), lDContext2, lDConfig2.http.build(clientContext), z3, (Boolean) null, lDConfig2.serviceEndpoints, lDConfig.isOffline());
        DiagnosticStore diagnosticStore2 = null;
        if (!lDConfig.getDiagnosticOptOut()) {
            diagnosticStore2 = new DiagnosticStore(EventUtil.makeDiagnosticParams(clientContext3));
        }
        return new ClientContextImpl(clientContext3, diagnosticStore2, featureFetcher, platformState2, taskExecutor2);
    }

    public static ClientContextImpl get(ClientContext clientContext) {
        if (clientContext instanceof ClientContextImpl) {
            return (ClientContextImpl) clientContext;
        }
        return new ClientContextImpl(clientContext, (DiagnosticStore) null, (FeatureFetcher) null, (PlatformState) null, (TaskExecutor) null);
    }

    public static ClientContextImpl forDataSource(ClientContext clientContext, DataSourceUpdateSink dataSourceUpdateSink, LDContext lDContext, boolean z, Boolean bool) {
        ClientContextImpl clientContextImpl = get(clientContext);
        return new ClientContextImpl(new ClientContext(clientContext.getMobileKey(), clientContext.getApplicationInfo(), clientContext.getBaseLogger(), clientContext.getConfig(), dataSourceUpdateSink, clientContext.getEnvironmentName(), clientContext.isEvaluationReasons(), lDContext, clientContext.getHttp(), z, bool, clientContext.getServiceEndpoints(), false), clientContextImpl.getDiagnosticStore(), clientContextImpl.getFetcher(), clientContextImpl.getPlatformState(), clientContextImpl.getTaskExecutor());
    }

    public DiagnosticStore getDiagnosticStore() {
        return this.diagnosticStore;
    }

    public FeatureFetcher getFetcher() {
        return this.fetcher;
    }

    public PlatformState getPlatformState() {
        return (PlatformState) throwExceptionIfNull(this.platformState);
    }

    public TaskExecutor getTaskExecutor() {
        return (TaskExecutor) throwExceptionIfNull(this.taskExecutor);
    }

    private static <T> T throwExceptionIfNull(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Attempted to use an SDK component without the necessary dependencies from LDClient;  this should never happen unless an application has tried to construct the component directly outside of normal SDK usage");
    }
}
