package io.sentry;

import io.sentry.SpanId;
import io.sentry.SpanStatus;
import io.sentry.protocol.SentryId;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SpanContext implements JsonUnknown, JsonSerializable {
    public static final String TYPE = "trace";
    protected String description;
    protected String op;
    protected String origin;
    private final SpanId parentSpanId;
    private transient TracesSamplingDecision samplingDecision;
    private final SpanId spanId;
    protected SpanStatus status;
    protected Map<String, String> tags;
    private final SentryId traceId;
    private Map<String, Object> unknown;

    public static final class JsonKeys {
        public static final String DESCRIPTION = "description";
        public static final String OP = "op";
        public static final String ORIGIN = "origin";
        public static final String PARENT_SPAN_ID = "parent_span_id";
        public static final String SPAN_ID = "span_id";
        public static final String STATUS = "status";
        public static final String TAGS = "tags";
        public static final String TRACE_ID = "trace_id";
    }

    public SpanContext(String str, TracesSamplingDecision tracesSamplingDecision) {
        this(new SentryId(), new SpanId(), str, (SpanId) null, tracesSamplingDecision);
    }

    public SpanContext(String str) {
        this(new SentryId(), new SpanId(), str, (SpanId) null, (TracesSamplingDecision) null);
    }

    public SpanContext(SentryId sentryId, SpanId spanId2, String str, SpanId spanId3, TracesSamplingDecision tracesSamplingDecision) {
        this(sentryId, spanId2, spanId3, str, (String) null, tracesSamplingDecision, (SpanStatus) null, "manual");
    }

    public SpanContext(SentryId sentryId, SpanId spanId2, SpanId spanId3, String str, String str2, TracesSamplingDecision tracesSamplingDecision, SpanStatus spanStatus, String str3) {
        this.tags = new ConcurrentHashMap();
        this.origin = "manual";
        this.traceId = (SentryId) Objects.requireNonNull(sentryId, "traceId is required");
        this.spanId = (SpanId) Objects.requireNonNull(spanId2, "spanId is required");
        this.op = (String) Objects.requireNonNull(str, "operation is required");
        this.parentSpanId = spanId3;
        this.samplingDecision = tracesSamplingDecision;
        this.description = str2;
        this.status = spanStatus;
        this.origin = str3;
    }

    public SpanContext(SpanContext spanContext) {
        this.tags = new ConcurrentHashMap();
        this.origin = "manual";
        this.traceId = spanContext.traceId;
        this.spanId = spanContext.spanId;
        this.parentSpanId = spanContext.parentSpanId;
        this.samplingDecision = spanContext.samplingDecision;
        this.op = spanContext.op;
        this.description = spanContext.description;
        this.status = spanContext.status;
        Map<String, String> newConcurrentHashMap = CollectionUtils.newConcurrentHashMap(spanContext.tags);
        if (newConcurrentHashMap != null) {
            this.tags = newConcurrentHashMap;
        }
    }

    public void setOperation(String str) {
        this.op = (String) Objects.requireNonNull(str, "operation is required");
    }

    public void setTag(String str, String str2) {
        Objects.requireNonNull(str, "name is required");
        Objects.requireNonNull(str2, "value is required");
        this.tags.put(str, str2);
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setStatus(SpanStatus spanStatus) {
        this.status = spanStatus;
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

    public String getOperation() {
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

    public TracesSamplingDecision getSamplingDecision() {
        return this.samplingDecision;
    }

    public Boolean getSampled() {
        TracesSamplingDecision tracesSamplingDecision = this.samplingDecision;
        if (tracesSamplingDecision == null) {
            return null;
        }
        return tracesSamplingDecision.getSampled();
    }

    public Boolean getProfileSampled() {
        TracesSamplingDecision tracesSamplingDecision = this.samplingDecision;
        if (tracesSamplingDecision == null) {
            return null;
        }
        return tracesSamplingDecision.getProfileSampled();
    }

    public void setSampled(Boolean bool) {
        if (bool == null) {
            setSamplingDecision((TracesSamplingDecision) null);
        } else {
            setSamplingDecision(new TracesSamplingDecision(bool));
        }
    }

    public void setSampled(Boolean bool, Boolean bool2) {
        if (bool == null) {
            setSamplingDecision((TracesSamplingDecision) null);
        } else if (bool2 == null) {
            setSamplingDecision(new TracesSamplingDecision(bool));
        } else {
            setSamplingDecision(new TracesSamplingDecision(bool, (Double) null, bool2, (Double) null));
        }
    }

    public void setSamplingDecision(TracesSamplingDecision tracesSamplingDecision) {
        this.samplingDecision = tracesSamplingDecision;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String str) {
        this.origin = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpanContext)) {
            return false;
        }
        SpanContext spanContext = (SpanContext) obj;
        if (!this.traceId.equals(spanContext.traceId) || !this.spanId.equals(spanContext.spanId) || !Objects.equals(this.parentSpanId, spanContext.parentSpanId) || !this.op.equals(spanContext.op) || !Objects.equals(this.description, spanContext.description) || this.status != spanContext.status) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(this.traceId, this.spanId, this.parentSpanId, this.op, this.description, this.status);
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        objectWriter.name("trace_id");
        this.traceId.serialize(objectWriter, iLogger);
        objectWriter.name("span_id");
        this.spanId.serialize(objectWriter, iLogger);
        if (this.parentSpanId != null) {
            objectWriter.name("parent_span_id");
            this.parentSpanId.serialize(objectWriter, iLogger);
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
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String next : map.keySet()) {
                objectWriter.name(next).value(iLogger, this.unknown.get(next));
            }
        }
        objectWriter.endObject();
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public static final class Deserializer implements JsonDeserializer<SpanContext> {
        public SpanContext deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            jsonObjectReader.beginObject();
            String str = null;
            SentryId sentryId = null;
            SpanId spanId = null;
            SpanId spanId2 = null;
            ConcurrentHashMap concurrentHashMap = null;
            String str2 = null;
            SpanStatus spanStatus = null;
            String str3 = null;
            Map<String, String> map = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case -2011840976:
                        if (nextName.equals("span_id")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1757797477:
                        if (nextName.equals("parent_span_id")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -1724546052:
                        if (nextName.equals("description")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1008619738:
                        if (nextName.equals("origin")) {
                            c = 3;
                            break;
                        }
                        break;
                    case -892481550:
                        if (nextName.equals("status")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 3553:
                        if (nextName.equals("op")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 3552281:
                        if (nextName.equals("tags")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 1270300245:
                        if (nextName.equals("trace_id")) {
                            c = 7;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        spanId = new SpanId.Deserializer().deserialize(jsonObjectReader, iLogger);
                        break;
                    case 1:
                        spanId2 = (SpanId) jsonObjectReader.nextOrNull(iLogger, new SpanId.Deserializer());
                        break;
                    case 2:
                        str2 = jsonObjectReader.nextString();
                        break;
                    case 3:
                        str3 = jsonObjectReader.nextString();
                        break;
                    case 4:
                        spanStatus = (SpanStatus) jsonObjectReader.nextOrNull(iLogger, new SpanStatus.Deserializer());
                        break;
                    case 5:
                        str = jsonObjectReader.nextString();
                        break;
                    case 6:
                        map = CollectionUtils.newConcurrentHashMap((Map) jsonObjectReader.nextObjectOrNull());
                        break;
                    case 7:
                        sentryId = new SentryId.Deserializer().deserialize(jsonObjectReader, iLogger);
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        jsonObjectReader.nextUnknown(iLogger, concurrentHashMap, nextName);
                        break;
                }
            }
            if (sentryId == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"trace_id\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"trace_id\"", (Throwable) illegalStateException);
                throw illegalStateException;
            } else if (spanId != null) {
                SpanContext spanContext = new SpanContext(sentryId, spanId, str == null ? "" : str, spanId2, (TracesSamplingDecision) null);
                spanContext.setDescription(str2);
                spanContext.setStatus(spanStatus);
                spanContext.setOrigin(str3);
                if (map != null) {
                    spanContext.tags = map;
                }
                spanContext.setUnknown(concurrentHashMap);
                jsonObjectReader.endObject();
                return spanContext;
            } else {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"span_id\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"span_id\"", (Throwable) illegalStateException2);
                throw illegalStateException2;
            }
        }
    }
}
