package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.proto.AtProtobuf;
import io.sentry.clientreport.DiscardedEvent;
import java.io.IOException;

public final class AutoProtoEncoderDoNotUseEncoder implements Configurator {
    public static final int CODEGEN_VERSION = 2;
    public static final Configurator CONFIG = new AutoProtoEncoderDoNotUseEncoder();

    private AutoProtoEncoderDoNotUseEncoder() {
    }

    public void configure(EncoderConfig<?> encoderConfig) {
        encoderConfig.registerEncoder((Class<U>) ProtoEncoderDoNotUse.class, (ObjectEncoder<? super U>) ProtoEncoderDoNotUseEncoder.INSTANCE);
        encoderConfig.registerEncoder((Class<U>) ClientMetrics.class, (ObjectEncoder<? super U>) ClientMetricsEncoder.INSTANCE);
        encoderConfig.registerEncoder((Class<U>) TimeWindow.class, (ObjectEncoder<? super U>) TimeWindowEncoder.INSTANCE);
        encoderConfig.registerEncoder((Class<U>) LogSourceMetrics.class, (ObjectEncoder<? super U>) LogSourceMetricsEncoder.INSTANCE);
        encoderConfig.registerEncoder((Class<U>) LogEventDropped.class, (ObjectEncoder<? super U>) LogEventDroppedEncoder.INSTANCE);
        encoderConfig.registerEncoder((Class<U>) GlobalMetrics.class, (ObjectEncoder<? super U>) GlobalMetricsEncoder.INSTANCE);
        encoderConfig.registerEncoder((Class<U>) StorageMetrics.class, (ObjectEncoder<? super U>) StorageMetricsEncoder.INSTANCE);
    }

    private static final class ProtoEncoderDoNotUseEncoder implements ObjectEncoder<ProtoEncoderDoNotUse> {
        private static final FieldDescriptor CLIENTMETRICS_DESCRIPTOR = FieldDescriptor.of("clientMetrics");
        static final ProtoEncoderDoNotUseEncoder INSTANCE = new ProtoEncoderDoNotUseEncoder();

        private ProtoEncoderDoNotUseEncoder() {
        }

        public void encode(ProtoEncoderDoNotUse protoEncoderDoNotUse, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(CLIENTMETRICS_DESCRIPTOR, (Object) protoEncoderDoNotUse.getClientMetrics());
        }
    }

    private static final class ClientMetricsEncoder implements ObjectEncoder<ClientMetrics> {
        private static final FieldDescriptor APPNAMESPACE_DESCRIPTOR = FieldDescriptor.builder("appNamespace").withProperty(AtProtobuf.builder().tag(4).build()).build();
        private static final FieldDescriptor GLOBALMETRICS_DESCRIPTOR = FieldDescriptor.builder("globalMetrics").withProperty(AtProtobuf.builder().tag(3).build()).build();
        static final ClientMetricsEncoder INSTANCE = new ClientMetricsEncoder();
        private static final FieldDescriptor LOGSOURCEMETRICS_DESCRIPTOR = FieldDescriptor.builder("logSourceMetrics").withProperty(AtProtobuf.builder().tag(2).build()).build();
        private static final FieldDescriptor WINDOW_DESCRIPTOR = FieldDescriptor.builder("window").withProperty(AtProtobuf.builder().tag(1).build()).build();

        private ClientMetricsEncoder() {
        }

        public void encode(ClientMetrics clientMetrics, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(WINDOW_DESCRIPTOR, (Object) clientMetrics.getWindowInternal());
            objectEncoderContext.add(LOGSOURCEMETRICS_DESCRIPTOR, (Object) clientMetrics.getLogSourceMetricsList());
            objectEncoderContext.add(GLOBALMETRICS_DESCRIPTOR, (Object) clientMetrics.getGlobalMetricsInternal());
            objectEncoderContext.add(APPNAMESPACE_DESCRIPTOR, (Object) clientMetrics.getAppNamespace());
        }
    }

    private static final class TimeWindowEncoder implements ObjectEncoder<TimeWindow> {
        private static final FieldDescriptor ENDMS_DESCRIPTOR = FieldDescriptor.builder("endMs").withProperty(AtProtobuf.builder().tag(2).build()).build();
        static final TimeWindowEncoder INSTANCE = new TimeWindowEncoder();
        private static final FieldDescriptor STARTMS_DESCRIPTOR = FieldDescriptor.builder("startMs").withProperty(AtProtobuf.builder().tag(1).build()).build();

        private TimeWindowEncoder() {
        }

        public void encode(TimeWindow timeWindow, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(STARTMS_DESCRIPTOR, timeWindow.getStartMs());
            objectEncoderContext.add(ENDMS_DESCRIPTOR, timeWindow.getEndMs());
        }
    }

    private static final class LogSourceMetricsEncoder implements ObjectEncoder<LogSourceMetrics> {
        static final LogSourceMetricsEncoder INSTANCE = new LogSourceMetricsEncoder();
        private static final FieldDescriptor LOGEVENTDROPPED_DESCRIPTOR = FieldDescriptor.builder("logEventDropped").withProperty(AtProtobuf.builder().tag(2).build()).build();
        private static final FieldDescriptor LOGSOURCE_DESCRIPTOR = FieldDescriptor.builder("logSource").withProperty(AtProtobuf.builder().tag(1).build()).build();

        private LogSourceMetricsEncoder() {
        }

        public void encode(LogSourceMetrics logSourceMetrics, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(LOGSOURCE_DESCRIPTOR, (Object) logSourceMetrics.getLogSource());
            objectEncoderContext.add(LOGEVENTDROPPED_DESCRIPTOR, (Object) logSourceMetrics.getLogEventDroppedList());
        }
    }

    private static final class LogEventDroppedEncoder implements ObjectEncoder<LogEventDropped> {
        private static final FieldDescriptor EVENTSDROPPEDCOUNT_DESCRIPTOR = FieldDescriptor.builder("eventsDroppedCount").withProperty(AtProtobuf.builder().tag(1).build()).build();
        static final LogEventDroppedEncoder INSTANCE = new LogEventDroppedEncoder();
        private static final FieldDescriptor REASON_DESCRIPTOR = FieldDescriptor.builder(DiscardedEvent.JsonKeys.REASON).withProperty(AtProtobuf.builder().tag(3).build()).build();

        private LogEventDroppedEncoder() {
        }

        public void encode(LogEventDropped logEventDropped, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(EVENTSDROPPEDCOUNT_DESCRIPTOR, logEventDropped.getEventsDroppedCount());
            objectEncoderContext.add(REASON_DESCRIPTOR, (Object) logEventDropped.getReason());
        }
    }

    private static final class GlobalMetricsEncoder implements ObjectEncoder<GlobalMetrics> {
        static final GlobalMetricsEncoder INSTANCE = new GlobalMetricsEncoder();
        private static final FieldDescriptor STORAGEMETRICS_DESCRIPTOR = FieldDescriptor.builder("storageMetrics").withProperty(AtProtobuf.builder().tag(1).build()).build();

        private GlobalMetricsEncoder() {
        }

        public void encode(GlobalMetrics globalMetrics, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(STORAGEMETRICS_DESCRIPTOR, (Object) globalMetrics.getStorageMetricsInternal());
        }
    }

    private static final class StorageMetricsEncoder implements ObjectEncoder<StorageMetrics> {
        private static final FieldDescriptor CURRENTCACHESIZEBYTES_DESCRIPTOR = FieldDescriptor.builder("currentCacheSizeBytes").withProperty(AtProtobuf.builder().tag(1).build()).build();
        static final StorageMetricsEncoder INSTANCE = new StorageMetricsEncoder();
        private static final FieldDescriptor MAXCACHESIZEBYTES_DESCRIPTOR = FieldDescriptor.builder("maxCacheSizeBytes").withProperty(AtProtobuf.builder().tag(2).build()).build();

        private StorageMetricsEncoder() {
        }

        public void encode(StorageMetrics storageMetrics, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(CURRENTCACHESIZEBYTES_DESCRIPTOR, storageMetrics.getCurrentCacheSizeBytes());
            objectEncoderContext.add(MAXCACHESIZEBYTES_DESCRIPTOR, storageMetrics.getMaxCacheSizeBytes());
        }
    }
}
