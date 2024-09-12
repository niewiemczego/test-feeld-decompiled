package com.launchdarkly.sdk.android.integrations;

import com.launchdarkly.sdk.android.LDConfig;
import com.launchdarkly.sdk.android.subsystems.ComponentConfigurer;
import com.launchdarkly.sdk.android.subsystems.DataSource;

public abstract class PollingDataSourceBuilder implements ComponentConfigurer<DataSource> {
    public static final int DEFAULT_POLL_INTERVAL_MILLIS = 300000;
    protected int backgroundPollIntervalMillis = LDConfig.DEFAULT_BACKGROUND_POLL_INTERVAL_MILLIS;
    protected int pollIntervalMillis = 300000;

    public PollingDataSourceBuilder backgroundPollIntervalMillis(int i) {
        if (i < 900000) {
            i = 900000;
        }
        this.backgroundPollIntervalMillis = i;
        return this;
    }

    public PollingDataSourceBuilder pollIntervalMillis(int i) {
        if (i <= 300000) {
            i = 300000;
        }
        this.pollIntervalMillis = i;
        return this;
    }
}
