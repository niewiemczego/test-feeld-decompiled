package com.launchdarkly.sdk.android;

import com.launchdarkly.sdk.android.ComponentsImpl;
import com.launchdarkly.sdk.android.integrations.ApplicationInfoBuilder;
import com.launchdarkly.sdk.android.integrations.EventProcessorBuilder;
import com.launchdarkly.sdk.android.integrations.HttpConfigurationBuilder;
import com.launchdarkly.sdk.android.integrations.PollingDataSourceBuilder;
import com.launchdarkly.sdk.android.integrations.ServiceEndpointsBuilder;
import com.launchdarkly.sdk.android.integrations.StreamingDataSourceBuilder;
import com.launchdarkly.sdk.android.subsystems.ComponentConfigurer;
import com.launchdarkly.sdk.android.subsystems.EventProcessor;

public abstract class Components {
    private Components() {
    }

    public static ApplicationInfoBuilder applicationInfo() {
        return new ApplicationInfoBuilder();
    }

    public static HttpConfigurationBuilder httpConfiguration() {
        return new ComponentsImpl.HttpConfigurationBuilderImpl();
    }

    public static ComponentConfigurer<EventProcessor> noEvents() {
        return ComponentsImpl.NULL_EVENT_PROCESSOR_FACTORY;
    }

    public static PollingDataSourceBuilder pollingDataSource() {
        return new ComponentsImpl.PollingDataSourceBuilderImpl();
    }

    public static EventProcessorBuilder sendEvents() {
        return new ComponentsImpl.EventProcessorBuilderImpl();
    }

    public static ServiceEndpointsBuilder serviceEndpoints() {
        return new ComponentsImpl.ServiceEndpointsBuilderImpl();
    }

    public static StreamingDataSourceBuilder streamingDataSource() {
        return new ComponentsImpl.StreamingDataSourceBuilderImpl();
    }
}
