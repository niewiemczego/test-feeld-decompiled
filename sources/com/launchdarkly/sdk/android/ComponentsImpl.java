package com.launchdarkly.sdk.android;

import com.launchdarkly.sdk.EvaluationReason;
import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.LDValue;
import com.launchdarkly.sdk.android.ConnectionInformation;
import com.launchdarkly.sdk.android.integrations.EventProcessorBuilder;
import com.launchdarkly.sdk.android.integrations.HttpConfigurationBuilder;
import com.launchdarkly.sdk.android.integrations.PollingDataSourceBuilder;
import com.launchdarkly.sdk.android.integrations.ServiceEndpointsBuilder;
import com.launchdarkly.sdk.android.integrations.StreamingDataSourceBuilder;
import com.launchdarkly.sdk.android.interfaces.ServiceEndpoints;
import com.launchdarkly.sdk.android.subsystems.ClientContext;
import com.launchdarkly.sdk.android.subsystems.ComponentConfigurer;
import com.launchdarkly.sdk.android.subsystems.DataSource;
import com.launchdarkly.sdk.android.subsystems.DataSourceUpdateSink;
import com.launchdarkly.sdk.android.subsystems.DiagnosticDescription;
import com.launchdarkly.sdk.android.subsystems.EventProcessor;
import com.launchdarkly.sdk.android.subsystems.HttpConfiguration;
import com.launchdarkly.sdk.internal.events.DefaultEventProcessor;
import com.launchdarkly.sdk.internal.events.DefaultEventSender;
import com.launchdarkly.sdk.internal.events.Event;
import com.launchdarkly.sdk.internal.events.EventContextDeduplicator;
import com.launchdarkly.sdk.internal.events.EventsConfiguration;
import java.io.IOException;
import java.util.HashMap;

abstract class ComponentsImpl {
    static final ComponentConfigurer<EventProcessor> NULL_EVENT_PROCESSOR_FACTORY = new ComponentConfigurer<EventProcessor>() {
        public EventProcessor build(ClientContext clientContext) {
            return NullEventProcessor.INSTANCE;
        }
    };

    interface DataSourceRequiresFeatureFetcher {
    }

    private ComponentsImpl() {
    }

    static final class ServiceEndpointsBuilderImpl extends ServiceEndpointsBuilder {
        ServiceEndpointsBuilderImpl() {
        }

        public ServiceEndpoints createServiceEndpoints() {
            if (this.streamingBaseUri == null && this.pollingBaseUri == null && this.eventsBaseUri == null) {
                return new ServiceEndpoints(StandardEndpoints.DEFAULT_STREAMING_BASE_URI, StandardEndpoints.DEFAULT_POLLING_BASE_URI, StandardEndpoints.DEFAULT_EVENTS_BASE_URI);
            }
            return new ServiceEndpoints(this.streamingBaseUri, this.pollingBaseUri, this.eventsBaseUri);
        }
    }

    static final class NullEventProcessor implements EventProcessor {
        static final NullEventProcessor INSTANCE = new NullEventProcessor();

        public void blockingFlush() {
        }

        public void close() {
        }

        public void flush() {
        }

        public void recordCustomEvent(LDContext lDContext, String str, LDValue lDValue, Double d) {
        }

        public void recordEvaluationEvent(LDContext lDContext, String str, int i, int i2, LDValue lDValue, EvaluationReason evaluationReason, LDValue lDValue2, boolean z, Long l) {
        }

        public void recordIdentifyEvent(LDContext lDContext) {
        }

        public void setInBackground(boolean z) {
        }

        public void setOffline(boolean z) {
        }

        private NullEventProcessor() {
        }
    }

    static final class EventProcessorBuilderImpl extends EventProcessorBuilder implements DiagnosticDescription {
        EventProcessorBuilderImpl() {
        }

        public EventProcessor build(ClientContext clientContext) {
            EventsConfiguration eventsConfiguration = r2;
            EventsConfiguration eventsConfiguration2 = new EventsConfiguration(this.allAttributesPrivate, this.capacity, (EventContextDeduplicator) null, (long) this.diagnosticRecordingIntervalMillis, ClientContextImpl.get(clientContext).getDiagnosticStore(), new DefaultEventSender(LDUtil.makeHttpProperties(clientContext), "/mobile/events/bulk", "/mobile/events/diagnostic", 0, clientContext.getBaseLogger()), 1, clientContext.getServiceEndpoints().getEventsBaseUri(), (long) this.flushIntervalMillis, clientContext.isInBackground(), true, this.privateAttributes);
            return new DefaultEventProcessorWrapper(new DefaultEventProcessor(eventsConfiguration, EventUtil.makeEventsTaskExecutor(), 5, clientContext.getBaseLogger()));
        }

        public LDValue describeConfiguration(ClientContext clientContext) {
            return LDValue.buildObject().put("allAttributesPrivate", this.allAttributesPrivate).put("diagnosticRecordingIntervalMillis", this.diagnosticRecordingIntervalMillis).put("eventsCapacity", this.capacity).put("diagnosticRecordingIntervalMillis", this.diagnosticRecordingIntervalMillis).put("eventsFlushIntervalMillis", this.flushIntervalMillis).build();
        }

        private final class DefaultEventProcessorWrapper implements EventProcessor {
            private final DefaultEventProcessor eventProcessor;

            DefaultEventProcessorWrapper(DefaultEventProcessor defaultEventProcessor) {
                this.eventProcessor = defaultEventProcessor;
            }

            public void recordEvaluationEvent(LDContext lDContext, String str, int i, int i2, LDValue lDValue, EvaluationReason evaluationReason, LDValue lDValue2, boolean z, Long l) {
                DefaultEventProcessor defaultEventProcessor = this.eventProcessor;
                Event.FeatureRequest featureRequest = r2;
                Event.FeatureRequest featureRequest2 = new Event.FeatureRequest(System.currentTimeMillis(), str, lDContext, i, i2, lDValue, lDValue2, evaluationReason, (String) null, z, l, false);
                defaultEventProcessor.sendEvent(featureRequest);
            }

            public void recordIdentifyEvent(LDContext lDContext) {
                this.eventProcessor.sendEvent(new Event.Identify(System.currentTimeMillis(), lDContext));
            }

            public void recordCustomEvent(LDContext lDContext, String str, LDValue lDValue, Double d) {
                this.eventProcessor.sendEvent(new Event.Custom(System.currentTimeMillis(), str, lDContext, lDValue, d));
            }

            public void setInBackground(boolean z) {
                this.eventProcessor.setInBackground(z);
            }

            public void setOffline(boolean z) {
                this.eventProcessor.setOffline(z);
            }

            public void flush() {
                this.eventProcessor.flushAsync();
            }

            public void blockingFlush() {
                this.eventProcessor.flushBlocking();
            }

            public void close() throws IOException {
                this.eventProcessor.close();
            }
        }
    }

    static final class HttpConfigurationBuilderImpl extends HttpConfigurationBuilder implements DiagnosticDescription {
        HttpConfigurationBuilderImpl() {
        }

        public HttpConfiguration build(ClientContext clientContext) {
            clientContext.getBaseLogger();
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", "api_key " + clientContext.getMobileKey());
            hashMap.put("User-Agent", "AndroidClient/4.2.3");
            if (clientContext.getApplicationInfo() != null) {
                String applicationTagHeader = LDUtil.applicationTagHeader(clientContext.getApplicationInfo(), clientContext.getBaseLogger());
                if (!applicationTagHeader.isEmpty()) {
                    hashMap.put("X-LaunchDarkly-Tags", applicationTagHeader);
                }
            }
            if (this.wrapperName != null) {
                hashMap.put("X-LaunchDarkly-Wrapper", this.wrapperVersion == null ? this.wrapperName : this.wrapperName + "/" + this.wrapperVersion);
            }
            return new HttpConfiguration(this.connectTimeoutMillis, hashMap, this.headerTransform, this.useReport);
        }

        public LDValue describeConfiguration(ClientContext clientContext) {
            return LDValue.buildObject().put("connectTimeoutMillis", this.connectTimeoutMillis).put("useReport", this.useReport).build();
        }
    }

    static final class PollingDataSourceBuilderImpl extends PollingDataSourceBuilder implements DiagnosticDescription, DataSourceRequiresFeatureFetcher {
        PollingDataSourceBuilderImpl() {
        }

        public DataSource build(ClientContext clientContext) {
            ConnectionInformation.ConnectionMode connectionMode;
            int i;
            DataSourceUpdateSink dataSourceUpdateSink = clientContext.getDataSourceUpdateSink();
            if (clientContext.isInBackground()) {
                connectionMode = ConnectionInformation.ConnectionMode.BACKGROUND_POLLING;
            } else {
                connectionMode = ConnectionInformation.ConnectionMode.POLLING;
            }
            dataSourceUpdateSink.setStatus(connectionMode, (Throwable) null);
            if (clientContext.isInBackground()) {
                i = this.backgroundPollIntervalMillis;
            } else {
                i = this.pollIntervalMillis;
            }
            int i2 = i;
            int i3 = (!clientContext.isInBackground() || !Boolean.FALSE.equals(clientContext.getPreviouslyInBackground())) ? 0 : this.backgroundPollIntervalMillis;
            ClientContextImpl clientContextImpl = ClientContextImpl.get(clientContext);
            return new PollingDataSource(clientContext.getEvaluationContext(), clientContext.getDataSourceUpdateSink(), i3, i2, clientContextImpl.getFetcher(), clientContextImpl.getPlatformState(), clientContextImpl.getTaskExecutor(), clientContext.getBaseLogger());
        }

        public LDValue describeConfiguration(ClientContext clientContext) {
            return LDValue.buildObject().put("streamingDisabled", true).put("backgroundPollingIntervalMillis", this.backgroundPollIntervalMillis).put("pollingIntervalMillis", this.pollIntervalMillis).build();
        }

        public PollingDataSourceBuilder backgroundPollIntervalMillisNoMinimum(int i) {
            this.backgroundPollIntervalMillis = i;
            return this;
        }

        public PollingDataSourceBuilder pollIntervalMillisNoMinimum(int i) {
            this.pollIntervalMillis = i;
            return this;
        }
    }

    static final class StreamingDataSourceBuilderImpl extends StreamingDataSourceBuilder implements DiagnosticDescription, DataSourceRequiresFeatureFetcher {
        StreamingDataSourceBuilderImpl() {
        }

        public DataSource build(ClientContext clientContext) {
            if (clientContext.isInBackground() && !this.streamEvenInBackground) {
                return (DataSource) Components.pollingDataSource().backgroundPollIntervalMillis(this.backgroundPollIntervalMillis).pollIntervalMillis(this.backgroundPollIntervalMillis).build(clientContext);
            }
            clientContext.getDataSourceUpdateSink().setStatus(ConnectionInformation.ConnectionMode.STREAMING, (Throwable) null);
            return new StreamingDataSource(clientContext, clientContext.getEvaluationContext(), clientContext.getDataSourceUpdateSink(), ClientContextImpl.get(clientContext).getFetcher(), this.initialReconnectDelayMillis, this.streamEvenInBackground);
        }

        public LDValue describeConfiguration(ClientContext clientContext) {
            return LDValue.buildObject().put("streamingDisabled", false).put("backgroundPollingIntervalMillis", this.backgroundPollIntervalMillis).put("reconnectTimeMillis", this.initialReconnectDelayMillis).build();
        }
    }
}
