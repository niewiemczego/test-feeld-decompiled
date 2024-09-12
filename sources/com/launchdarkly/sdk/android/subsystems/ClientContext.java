package com.launchdarkly.sdk.android.subsystems;

import com.launchdarkly.logging.LDLogger;
import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.android.LDConfig;
import com.launchdarkly.sdk.android.interfaces.ServiceEndpoints;

public class ClientContext {
    private final ApplicationInfo applicationInfo;
    private final LDLogger baseLogger;
    private final LDConfig config;
    private final DataSourceUpdateSink dataSourceUpdateSink;
    private final String environmentName;
    private final LDContext evaluationContext;
    private final boolean evaluationReasons;
    private final HttpConfiguration http;
    private final boolean inBackground;
    private final String mobileKey;
    private final Boolean previouslyInBackground;
    private final ServiceEndpoints serviceEndpoints;
    private final boolean setOffline;

    public ClientContext(String str, ApplicationInfo applicationInfo2, LDLogger lDLogger, LDConfig lDConfig, DataSourceUpdateSink dataSourceUpdateSink2, String str2, boolean z, LDContext lDContext, HttpConfiguration httpConfiguration, boolean z2, Boolean bool, ServiceEndpoints serviceEndpoints2, boolean z3) {
        this.mobileKey = str;
        this.applicationInfo = applicationInfo2;
        this.baseLogger = lDLogger;
        this.config = lDConfig;
        this.dataSourceUpdateSink = dataSourceUpdateSink2;
        this.environmentName = str2;
        this.evaluationReasons = z;
        this.evaluationContext = lDContext;
        this.http = httpConfiguration;
        this.inBackground = z2;
        this.previouslyInBackground = bool;
        this.serviceEndpoints = serviceEndpoints2;
        this.setOffline = z3;
    }

    @Deprecated
    public ClientContext(String str, LDLogger lDLogger, LDConfig lDConfig, DataSourceUpdateSink dataSourceUpdateSink2, String str2, boolean z, LDContext lDContext, HttpConfiguration httpConfiguration, boolean z2, Boolean bool, ServiceEndpoints serviceEndpoints2, boolean z3) {
        this(str, (ApplicationInfo) null, lDLogger, lDConfig, dataSourceUpdateSink2, str2, z, lDContext, httpConfiguration, z2, bool, serviceEndpoints2, z3);
    }

    @Deprecated
    public ClientContext(String str, LDLogger lDLogger, LDConfig lDConfig, DataSourceUpdateSink dataSourceUpdateSink2, String str2, boolean z, LDContext lDContext, HttpConfiguration httpConfiguration, boolean z2, ServiceEndpoints serviceEndpoints2, boolean z3) {
        this(str, (ApplicationInfo) null, lDLogger, lDConfig, dataSourceUpdateSink2, str2, z, lDContext, httpConfiguration, z2, (Boolean) null, serviceEndpoints2, z3);
    }

    protected ClientContext(ClientContext clientContext) {
        this(clientContext.mobileKey, clientContext.applicationInfo, clientContext.baseLogger, clientContext.config, clientContext.dataSourceUpdateSink, clientContext.environmentName, clientContext.evaluationReasons, clientContext.evaluationContext, clientContext.http, clientContext.inBackground, clientContext.previouslyInBackground, clientContext.serviceEndpoints, clientContext.setOffline);
    }

    public ApplicationInfo getApplicationInfo() {
        return this.applicationInfo;
    }

    public LDLogger getBaseLogger() {
        return this.baseLogger;
    }

    public LDConfig getConfig() {
        return this.config;
    }

    public DataSourceUpdateSink getDataSourceUpdateSink() {
        return this.dataSourceUpdateSink;
    }

    public String getEnvironmentName() {
        return this.environmentName;
    }

    public boolean isEvaluationReasons() {
        return this.evaluationReasons;
    }

    public HttpConfiguration getHttp() {
        return this.http;
    }

    public LDContext getEvaluationContext() {
        return this.evaluationContext;
    }

    public boolean isInBackground() {
        return this.inBackground;
    }

    public String getMobileKey() {
        return this.mobileKey;
    }

    public Boolean getPreviouslyInBackground() {
        return this.previouslyInBackground;
    }

    public ServiceEndpoints getServiceEndpoints() {
        return this.serviceEndpoints;
    }

    public boolean isSetOffline() {
        return this.setOffline;
    }
}
