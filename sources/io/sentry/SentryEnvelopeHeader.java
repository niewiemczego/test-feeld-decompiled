package io.sentry;

import io.sentry.TraceContext;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryId;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class SentryEnvelopeHeader implements JsonSerializable, JsonUnknown {
    private final SentryId eventId;
    private final SdkVersion sdkVersion;
    private Date sentAt;
    private final TraceContext traceContext;
    private Map<String, Object> unknown;

    public static final class JsonKeys {
        public static final String EVENT_ID = "event_id";
        public static final String SDK = "sdk";
        public static final String SENT_AT = "sent_at";
        public static final String TRACE = "trace";
    }

    public SentryEnvelopeHeader(SentryId sentryId, SdkVersion sdkVersion2) {
        this(sentryId, sdkVersion2, (TraceContext) null);
    }

    public SentryEnvelopeHeader(SentryId sentryId, SdkVersion sdkVersion2, TraceContext traceContext2) {
        this.eventId = sentryId;
        this.sdkVersion = sdkVersion2;
        this.traceContext = traceContext2;
    }

    public SentryEnvelopeHeader(SentryId sentryId) {
        this(sentryId, (SdkVersion) null);
    }

    public SentryEnvelopeHeader() {
        this(new SentryId());
    }

    public SentryId getEventId() {
        return this.eventId;
    }

    public SdkVersion getSdkVersion() {
        return this.sdkVersion;
    }

    public TraceContext getTraceContext() {
        return this.traceContext;
    }

    public Date getSentAt() {
        return this.sentAt;
    }

    public void setSentAt(Date date) {
        this.sentAt = date;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.eventId != null) {
            objectWriter.name("event_id").value(iLogger, this.eventId);
        }
        if (this.sdkVersion != null) {
            objectWriter.name("sdk").value(iLogger, this.sdkVersion);
        }
        if (this.traceContext != null) {
            objectWriter.name("trace").value(iLogger, this.traceContext);
        }
        if (this.sentAt != null) {
            objectWriter.name(JsonKeys.SENT_AT).value(iLogger, DateUtils.getTimestamp(this.sentAt));
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.unknown.get(next);
                objectWriter.name(next);
                objectWriter.value(iLogger, obj);
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<SentryEnvelopeHeader> {
        public SentryEnvelopeHeader deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            jsonObjectReader.beginObject();
            SentryId sentryId = null;
            SdkVersion sdkVersion = null;
            TraceContext traceContext = null;
            Date date = null;
            HashMap hashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case 113722:
                        if (nextName.equals("sdk")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 110620997:
                        if (nextName.equals("trace")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 278118624:
                        if (nextName.equals("event_id")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 1980389946:
                        if (nextName.equals(JsonKeys.SENT_AT)) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        sdkVersion = (SdkVersion) jsonObjectReader.nextOrNull(iLogger, new SdkVersion.Deserializer());
                        break;
                    case 1:
                        traceContext = (TraceContext) jsonObjectReader.nextOrNull(iLogger, new TraceContext.Deserializer());
                        break;
                    case 2:
                        sentryId = (SentryId) jsonObjectReader.nextOrNull(iLogger, new SentryId.Deserializer());
                        break;
                    case 3:
                        date = jsonObjectReader.nextDateOrNull(iLogger);
                        break;
                    default:
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        jsonObjectReader.nextUnknown(iLogger, hashMap, nextName);
                        break;
                }
            }
            SentryEnvelopeHeader sentryEnvelopeHeader = new SentryEnvelopeHeader(sentryId, sdkVersion, traceContext);
            sentryEnvelopeHeader.setSentAt(date);
            sentryEnvelopeHeader.setUnknown(hashMap);
            jsonObjectReader.endObject();
            return sentryEnvelopeHeader;
        }
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }
}