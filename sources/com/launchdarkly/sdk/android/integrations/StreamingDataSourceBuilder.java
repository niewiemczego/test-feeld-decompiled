package com.launchdarkly.sdk.android.integrations;

import com.launchdarkly.sdk.android.LDConfig;
import com.launchdarkly.sdk.android.subsystems.ComponentConfigurer;
import com.launchdarkly.sdk.android.subsystems.DataSource;

public abstract class StreamingDataSourceBuilder implements ComponentConfigurer<DataSource> {
    public static final int DEFAULT_INITIAL_RECONNECT_DELAY_MILLIS = 1000;
    protected int backgroundPollIntervalMillis = LDConfig.DEFAULT_BACKGROUND_POLL_INTERVAL_MILLIS;
    protected int initialReconnectDelayMillis = 1000;
    protected boolean streamEvenInBackground = false;

    public StreamingDataSourceBuilder backgroundPollIntervalMillis(int i) {
        if (i < 900000) {
            i = 900000;
        }
        this.backgroundPollIntervalMillis = i;
        return this;
    }

    public StreamingDataSourceBuilder initialReconnectDelayMillis(int i) {
        if (i <= 0) {
            i = 0;
        }
        this.initialReconnectDelayMillis = i;
        return this;
    }

    public StreamingDataSourceBuilder streamEvenInBackground(boolean z) {
        this.streamEvenInBackground = z;
        return this;
    }
}
