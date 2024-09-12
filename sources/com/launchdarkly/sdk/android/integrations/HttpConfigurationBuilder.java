package com.launchdarkly.sdk.android.integrations;

import com.launchdarkly.sdk.android.LDHeaderUpdater;
import com.launchdarkly.sdk.android.subsystems.ComponentConfigurer;
import com.launchdarkly.sdk.android.subsystems.HttpConfiguration;

public abstract class HttpConfigurationBuilder implements ComponentConfigurer<HttpConfiguration> {
    public static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 10000;
    protected int connectTimeoutMillis = 10000;
    protected LDHeaderUpdater headerTransform;
    protected boolean useReport;
    protected String wrapperName;
    protected String wrapperVersion;

    public HttpConfigurationBuilder connectTimeoutMillis(int i) {
        if (i <= 0) {
            i = 10000;
        }
        this.connectTimeoutMillis = i;
        return this;
    }

    public HttpConfigurationBuilder headerTransform(LDHeaderUpdater lDHeaderUpdater) {
        this.headerTransform = lDHeaderUpdater;
        return this;
    }

    public HttpConfigurationBuilder useReport(boolean z) {
        this.useReport = z;
        return this;
    }

    public HttpConfigurationBuilder wrapper(String str, String str2) {
        this.wrapperName = str;
        this.wrapperVersion = str2;
        return this;
    }
}
