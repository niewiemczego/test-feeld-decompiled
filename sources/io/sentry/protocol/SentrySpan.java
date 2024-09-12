package io.sentry.protocol;

import io.sentry.DateUtils;
import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectWriter;
import io.sentry.SentryLevel;
import io.sentry.Span;
import io.sentry.SpanId;
import io.sentry.SpanStatus;
import io.sentry.metrics.LocalMetricsAggregator;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class SentrySpan implements JsonUnknown, JsonSerializable {
    private final Map<String, Object> data;
    private final String description;
    private final Map<String, MeasurementValue> measurements;
    private final Map<String, List<MetricSummary>> metricsSummaries;
    private final String op;
    private final String origin;
    private final SpanId parentSpanId;
    private final SpanId spanId;
    private final Double startTimestamp;
    private final SpanStatus status;
    private final Map<String, String> tags;
    private final Double timestamp;
    private final SentryId traceId;
    private Map<String, Object> unknown;

    public static final class JsonKeys {
        public static final String DATA = "data";
        public static final String DESCRIPTION = "description";
        public static final String MEASUREMENTS = "measurements";
        public static final String METRICS_SUMMARY = "_metrics_summary";
        public static final String OP = "op";
        public static final String ORIGIN = "origin";
        public static final String PARENT_SPAN_ID = "parent_span_id";
        public static final String SPAN_ID = "span_id";
        public static final String START_TIMESTAMP = "start_timestamp";
        public static final String STATUS = "status";
        public static final String TAGS = "tags";
        public static final String TIMESTAMP = "timestamp";
        public static final String TRACE_ID = "trace_id";
    }

    public SentrySpan(Span span) {
        this(span, span.getData());
    }

    public SentrySpan(Span span, Map<String, Object> map) {
        Double d;
        Objects.requireNonNull(span, "span is required");
        this.description = span.getDescription();
        this.op = span.getOperation();
        this.spanId = span.getSpanId();
        this.parentSpanId = span.getParentSpanId();
        this.traceId = span.getTraceId();
        this.status = span.getStatus();
        this.origin = span.getSpanContext().getOrigin();
        Map<String, String> newConcurrentHashMap = CollectionUtils.newConcurrentHashMap(span.getTags());
        this.tags = newConcurrentHashMap == null ? new ConcurrentHashMap<>() : newConcurrentHashMap;
        Map<String, MeasurementValue> newConcurrentHashMap2 = CollectionUtils.newConcurrentHashMap(span.getMeasurements());
        this.measurements = newConcurrentHashMap2 == null ? new ConcurrentHashMap<>() : newConcurrentHashMap2;
        if (span.getFinishDate() == null) {
            d = null;
        } else {
            d = Double.valueOf(DateUtils.nanosToSeconds(span.getStartDate().laterDateNanosTimestampByDiff(span.getFinishDate())));
        }
        this.timestamp = d;
        this.startTimestamp = Double.valueOf(DateUtils.nanosToSeconds(span.getStartDate().nanoTimestamp()));
        this.data = map;
        LocalMetricsAggregator localMetricsAggregator = span.getLocalMetricsAggregator();
        if (localMetricsAggregator != null) {
            this.metricsSummaries = localMetricsAggregator.getSummaries();
        } else {
            this.metricsSummaries = null;
        }
    }

    public SentrySpan(Double d, Double d2, SentryId sentryId, SpanId spanId2, SpanId spanId3, String str, String str2, SpanStatus spanStatus, String str3, Map<String, String> map, Map<String, MeasurementValue> map2, Map<String, List<MetricSummary>> map3, Map<String, Object> map4) {
        this.startTimestamp = d;
        this.timestamp = d2;
        this.traceId = sentryId;
        this.spanId = spanId2;
        this.parentSpanId = spanId3;
        this.op = str;
        this.description = str2;
        this.status = spanStatus;
        this.origin = str3;
        this.tags = map;
        this.measurements = map2;
        this.metricsSummaries = map3;
        this.data = map4;
    }

    public boolean isFinished() {
        return this.timestamp != null;
    }

    public Double getStartTimestamp() {
        return this.startTimestamp;
    }

    public Double getTimestamp() {
        return this.timestamp;
    }

    public SentryId getTraceId() {
        return this.traceId;
    }

    public SpanId getSpanId() {
        return this.spanId;
    }

    public SpanId getParentSpanId() {
        return this.parentSpanId;
    }

    public String getOp() {
        return this.op;
    }

    public String getDescription() {
        return this.description;
    }

    public SpanStatus getStatus() {
        return this.status;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public String getOrigin() {
        return this.origin;
    }

    public Map<String, MeasurementValue> getMeasurements() {
        return this.measurements;
    }

    public Map<String, List<MetricSummary>> getMetricsSummaries() {
        return this.metricsSummaries;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        objectWriter.name("start_timestamp").value(iLogger, doubleToBigDecimal(this.startTimestamp));
        if (this.timestamp != null) {
            objectWriter.name("timestamp").value(iLogger, doubleToBigDecimal(this.timestamp));
        }
        objectWriter.name("trace_id").value(iLogger, this.traceId);
        objectWriter.name("span_id").value(iLogger, this.spanId);
        if (this.parentSpanId != null) {
            objectWriter.name("parent_span_id").value(iLogger, this.parentSpanId);
        }
        objectWriter.name("op").value(this.op);
        if (this.description != null) {
            objectWriter.name("description").value(this.description);
        }
        if (this.status != null) {
            objectWriter.name("status").value(iLogger, this.status);
        }
        if (this.origin != null) {
            objectWriter.name("origin").value(iLogger, this.origin);
        }
        if (!this.tags.isEmpty()) {
            objectWriter.name("tags").value(iLogger, this.tags);
        }
        if (this.data != null) {
            objectWriter.name("data").value(iLogger, this.data);
        }
        if (!this.measurements.isEmpty()) {
            objectWriter.name("measurements").value(iLogger, this.measurements);
        }
        Map<String, List<MetricSummary>> map = this.metricsSummaries;
        if (map != null && !map.isEmpty()) {
            objectWriter.name("_metrics_summary").value(iLogger, this.metricsSummaries);
        }
        Map<String, Object> map2 = this.unknown;
        if (map2 != null) {
            for (String next : map2.keySet()) {
                Object obj = this.unknown.get(next);
                objectWriter.name(next);
                objectWriter.value(iLogger, obj);
            }
        }
        objectWriter.endObject();
    }

    private BigDecimal doubleToBigDecimal(Double d) {
        return BigDecimal.valueOf(d.doubleValue()).setScale(6, RoundingMode.DOWN);
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public static final class Deserializer implements JsonDeserializer<SentrySpan> {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: io.sentry.SpanId} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: io.sentry.SpanStatus} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: java.util.Map} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.util.Map} */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ed, code lost:
            r13 = r18;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ef, code lost:
            r12 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f1, code lost:
            r11 = r20;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f3, code lost:
            r9 = r21;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public io.sentry.protocol.SentrySpan deserialize(io.sentry.JsonObjectReader r24, io.sentry.ILogger r25) throws java.lang.Exception {
            /*
                r23 = this;
                r0 = r23
                r1 = r24
                r2 = r25
                r24.beginObject()
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                r16 = 0
                r17 = 0
            L_0x0019:
                io.sentry.vendor.gson.stream.JsonToken r3 = r24.peek()
                io.sentry.vendor.gson.stream.JsonToken r0 = io.sentry.vendor.gson.stream.JsonToken.NAME
                r18 = r13
                java.lang.String r13 = "trace_id"
                r19 = r12
                java.lang.String r12 = "op"
                r20 = r11
                java.lang.String r11 = "start_timestamp"
                r21 = r9
                java.lang.String r9 = "span_id"
                if (r3 != r0) goto L_0x018e
                java.lang.String r0 = r24.nextName()
                r0.hashCode()
                r3 = -1
                int r22 = r0.hashCode()
                switch(r22) {
                    case -2011840976: goto L_0x00ce;
                    case -1757797477: goto L_0x00c3;
                    case -1724546052: goto L_0x00b8;
                    case -1526966919: goto L_0x00af;
                    case -1008619738: goto L_0x00a4;
                    case -892481550: goto L_0x0099;
                    case -682561045: goto L_0x008e;
                    case -362243017: goto L_0x0083;
                    case 3553: goto L_0x0078;
                    case 3076010: goto L_0x006a;
                    case 3552281: goto L_0x005c;
                    case 55126294: goto L_0x004e;
                    case 1270300245: goto L_0x0042;
                    default: goto L_0x0040;
                }
            L_0x0040:
                goto L_0x00d6
            L_0x0042:
                boolean r9 = r0.equals(r13)
                if (r9 != 0) goto L_0x004a
                goto L_0x00d6
            L_0x004a:
                r3 = 12
                goto L_0x00d6
            L_0x004e:
                java.lang.String r9 = "timestamp"
                boolean r9 = r0.equals(r9)
                if (r9 != 0) goto L_0x0058
                goto L_0x00d6
            L_0x0058:
                r3 = 11
                goto L_0x00d6
            L_0x005c:
                java.lang.String r9 = "tags"
                boolean r9 = r0.equals(r9)
                if (r9 != 0) goto L_0x0066
                goto L_0x00d6
            L_0x0066:
                r3 = 10
                goto L_0x00d6
            L_0x006a:
                java.lang.String r9 = "data"
                boolean r9 = r0.equals(r9)
                if (r9 != 0) goto L_0x0074
                goto L_0x00d6
            L_0x0074:
                r3 = 9
                goto L_0x00d6
            L_0x0078:
                boolean r9 = r0.equals(r12)
                if (r9 != 0) goto L_0x0080
                goto L_0x00d6
            L_0x0080:
                r3 = 8
                goto L_0x00d6
            L_0x0083:
                java.lang.String r9 = "measurements"
                boolean r9 = r0.equals(r9)
                if (r9 != 0) goto L_0x008c
                goto L_0x00d6
            L_0x008c:
                r3 = 7
                goto L_0x00d6
            L_0x008e:
                java.lang.String r9 = "_metrics_summary"
                boolean r9 = r0.equals(r9)
                if (r9 != 0) goto L_0x0097
                goto L_0x00d6
            L_0x0097:
                r3 = 6
                goto L_0x00d6
            L_0x0099:
                java.lang.String r9 = "status"
                boolean r9 = r0.equals(r9)
                if (r9 != 0) goto L_0x00a2
                goto L_0x00d6
            L_0x00a2:
                r3 = 5
                goto L_0x00d6
            L_0x00a4:
                java.lang.String r9 = "origin"
                boolean r9 = r0.equals(r9)
                if (r9 != 0) goto L_0x00ad
                goto L_0x00d6
            L_0x00ad:
                r3 = 4
                goto L_0x00d6
            L_0x00af:
                boolean r9 = r0.equals(r11)
                if (r9 != 0) goto L_0x00b6
                goto L_0x00d6
            L_0x00b6:
                r3 = 3
                goto L_0x00d6
            L_0x00b8:
                java.lang.String r9 = "description"
                boolean r9 = r0.equals(r9)
                if (r9 != 0) goto L_0x00c1
                goto L_0x00d6
            L_0x00c1:
                r3 = 2
                goto L_0x00d6
            L_0x00c3:
                java.lang.String r9 = "parent_span_id"
                boolean r9 = r0.equals(r9)
                if (r9 != 0) goto L_0x00cc
                goto L_0x00d6
            L_0x00cc:
                r3 = 1
                goto L_0x00d6
            L_0x00ce:
                boolean r9 = r0.equals(r9)
                if (r9 != 0) goto L_0x00d5
                goto L_0x00d6
            L_0x00d5:
                r3 = 0
            L_0x00d6:
                switch(r3) {
                    case 0: goto L_0x017f;
                    case 1: goto L_0x016c;
                    case 2: goto L_0x0163;
                    case 3: goto L_0x014c;
                    case 4: goto L_0x0147;
                    case 5: goto L_0x0138;
                    case 6: goto L_0x012e;
                    case 7: goto L_0x0124;
                    case 8: goto L_0x011f;
                    case 9: goto L_0x0116;
                    case 10: goto L_0x010e;
                    case 11: goto L_0x00f7;
                    case 12: goto L_0x00e4;
                    default: goto L_0x00d9;
                }
            L_0x00d9:
                if (r15 != 0) goto L_0x00e0
                java.util.concurrent.ConcurrentHashMap r15 = new java.util.concurrent.ConcurrentHashMap
                r15.<init>()
            L_0x00e0:
                r1.nextUnknown(r2, r15, r0)
                goto L_0x00ed
            L_0x00e4:
                io.sentry.protocol.SentryId$Deserializer r0 = new io.sentry.protocol.SentryId$Deserializer
                r0.<init>()
                io.sentry.protocol.SentryId r7 = r0.deserialize((io.sentry.JsonObjectReader) r1, (io.sentry.ILogger) r2)
            L_0x00ed:
                r13 = r18
            L_0x00ef:
                r12 = r19
            L_0x00f1:
                r11 = r20
            L_0x00f3:
                r9 = r21
                goto L_0x018a
            L_0x00f7:
                java.lang.Double r6 = r24.nextDoubleOrNull()     // Catch:{ NumberFormatException -> 0x00fc }
                goto L_0x00ed
            L_0x00fc:
                java.util.Date r0 = r24.nextDateOrNull(r25)
                if (r0 == 0) goto L_0x010c
                double r11 = io.sentry.DateUtils.dateToSeconds(r0)
                java.lang.Double r0 = java.lang.Double.valueOf(r11)
                r6 = r0
                goto L_0x00ed
            L_0x010c:
                r6 = 0
                goto L_0x00ed
            L_0x010e:
                java.lang.Object r0 = r24.nextObjectOrNull()
                r4 = r0
                java.util.Map r4 = (java.util.Map) r4
                goto L_0x00ed
            L_0x0116:
                java.lang.Object r0 = r24.nextObjectOrNull()
                r17 = r0
                java.util.Map r17 = (java.util.Map) r17
                goto L_0x00ed
            L_0x011f:
                java.lang.String r10 = r24.nextStringOrNull()
                goto L_0x00ed
            L_0x0124:
                io.sentry.protocol.MeasurementValue$Deserializer r0 = new io.sentry.protocol.MeasurementValue$Deserializer
                r0.<init>()
                java.util.Map r14 = r1.nextMapOrNull(r2, r0)
                goto L_0x00ed
            L_0x012e:
                io.sentry.protocol.MetricSummary$Deserializer r0 = new io.sentry.protocol.MetricSummary$Deserializer
                r0.<init>()
                java.util.Map r16 = r1.nextMapOfListOrNull(r2, r0)
                goto L_0x00ed
            L_0x0138:
                io.sentry.SpanStatus$Deserializer r0 = new io.sentry.SpanStatus$Deserializer
                r0.<init>()
                java.lang.Object r0 = r1.nextOrNull(r2, r0)
                r12 = r0
                io.sentry.SpanStatus r12 = (io.sentry.SpanStatus) r12
                r13 = r18
                goto L_0x00f1
            L_0x0147:
                java.lang.String r13 = r24.nextStringOrNull()
                goto L_0x00ef
            L_0x014c:
                java.lang.Double r5 = r24.nextDoubleOrNull()     // Catch:{ NumberFormatException -> 0x0151 }
                goto L_0x00ed
            L_0x0151:
                java.util.Date r0 = r24.nextDateOrNull(r25)
                if (r0 == 0) goto L_0x0161
                double r11 = io.sentry.DateUtils.dateToSeconds(r0)
                java.lang.Double r0 = java.lang.Double.valueOf(r11)
                r5 = r0
                goto L_0x00ed
            L_0x0161:
                r5 = 0
                goto L_0x00ed
            L_0x0163:
                java.lang.String r11 = r24.nextStringOrNull()
                r13 = r18
                r12 = r19
                goto L_0x00f3
            L_0x016c:
                io.sentry.SpanId$Deserializer r0 = new io.sentry.SpanId$Deserializer
                r0.<init>()
                java.lang.Object r0 = r1.nextOrNull(r2, r0)
                r9 = r0
                io.sentry.SpanId r9 = (io.sentry.SpanId) r9
                r13 = r18
                r12 = r19
                r11 = r20
                goto L_0x018a
            L_0x017f:
                io.sentry.SpanId$Deserializer r0 = new io.sentry.SpanId$Deserializer
                r0.<init>()
                io.sentry.SpanId r8 = r0.deserialize((io.sentry.JsonObjectReader) r1, (io.sentry.ILogger) r2)
                goto L_0x00ed
            L_0x018a:
                r0 = r23
                goto L_0x0019
            L_0x018e:
                if (r5 == 0) goto L_0x01d5
                if (r7 == 0) goto L_0x01ce
                if (r8 == 0) goto L_0x01c7
                if (r10 == 0) goto L_0x01c0
                if (r4 != 0) goto L_0x019e
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                goto L_0x019f
            L_0x019e:
                r0 = r4
            L_0x019f:
                if (r14 != 0) goto L_0x01a7
                java.util.HashMap r2 = new java.util.HashMap
                r2.<init>()
                goto L_0x01a8
            L_0x01a7:
                r2 = r14
            L_0x01a8:
                io.sentry.protocol.SentrySpan r3 = new io.sentry.protocol.SentrySpan
                r4 = r3
                r9 = r21
                r11 = r20
                r12 = r19
                r13 = r18
                r14 = r0
                r0 = r15
                r15 = r2
                r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
                r3.setUnknown(r0)
                r24.endObject()
                return r3
            L_0x01c0:
                r0 = r23
                java.lang.Exception r1 = r0.missingRequiredFieldException(r12, r2)
                throw r1
            L_0x01c7:
                r0 = r23
                java.lang.Exception r1 = r0.missingRequiredFieldException(r9, r2)
                throw r1
            L_0x01ce:
                r0 = r23
                java.lang.Exception r1 = r0.missingRequiredFieldException(r13, r2)
                throw r1
            L_0x01d5:
                r0 = r23
                java.lang.Exception r1 = r0.missingRequiredFieldException(r11, r2)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.protocol.SentrySpan.Deserializer.deserialize(io.sentry.JsonObjectReader, io.sentry.ILogger):io.sentry.protocol.SentrySpan");
        }

        private Exception missingRequiredFieldException(String str, ILogger iLogger) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            iLogger.log(SentryLevel.ERROR, str2, (Throwable) illegalStateException);
            return illegalStateException;
        }
    }
}
