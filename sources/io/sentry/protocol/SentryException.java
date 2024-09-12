package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonObjectReader;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectWriter;
import io.sentry.protocol.Mechanism;
import io.sentry.protocol.SentryStackTrace;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class SentryException implements JsonUnknown, JsonSerializable {
    /* access modifiers changed from: private */
    public Mechanism mechanism;
    /* access modifiers changed from: private */
    public String module;
    /* access modifiers changed from: private */
    public SentryStackTrace stacktrace;
    /* access modifiers changed from: private */
    public Long threadId;
    /* access modifiers changed from: private */
    public String type;
    private Map<String, Object> unknown;
    /* access modifiers changed from: private */
    public String value;

    public static final class JsonKeys {
        public static final String MECHANISM = "mechanism";
        public static final String MODULE = "module";
        public static final String STACKTRACE = "stacktrace";
        public static final String THREAD_ID = "thread_id";
        public static final String TYPE = "type";
        public static final String VALUE = "value";
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getModule() {
        return this.module;
    }

    public void setModule(String str) {
        this.module = str;
    }

    public Long getThreadId() {
        return this.threadId;
    }

    public void setThreadId(Long l) {
        this.threadId = l;
    }

    public SentryStackTrace getStacktrace() {
        return this.stacktrace;
    }

    public void setStacktrace(SentryStackTrace sentryStackTrace) {
        this.stacktrace = sentryStackTrace;
    }

    public Mechanism getMechanism() {
        return this.mechanism;
    }

    public void setMechanism(Mechanism mechanism2) {
        this.mechanism = mechanism2;
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.type != null) {
            objectWriter.name("type").value(this.type);
        }
        if (this.value != null) {
            objectWriter.name("value").value(this.value);
        }
        if (this.module != null) {
            objectWriter.name("module").value(this.module);
        }
        if (this.threadId != null) {
            objectWriter.name("thread_id").value((Number) this.threadId);
        }
        if (this.stacktrace != null) {
            objectWriter.name("stacktrace").value(iLogger, this.stacktrace);
        }
        if (this.mechanism != null) {
            objectWriter.name(JsonKeys.MECHANISM).value(iLogger, this.mechanism);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String next : map.keySet()) {
                objectWriter.name(next).value(iLogger, this.unknown.get(next));
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<SentryException> {
        public SentryException deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            SentryException sentryException = new SentryException();
            jsonObjectReader.beginObject();
            HashMap hashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case -1562235024:
                        if (nextName.equals("thread_id")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1068784020:
                        if (nextName.equals("module")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 3575610:
                        if (nextName.equals("type")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 111972721:
                        if (nextName.equals("value")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 1225089881:
                        if (nextName.equals(JsonKeys.MECHANISM)) {
                            c = 4;
                            break;
                        }
                        break;
                    case 2055832509:
                        if (nextName.equals("stacktrace")) {
                            c = 5;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        Long unused = sentryException.threadId = jsonObjectReader.nextLongOrNull();
                        break;
                    case 1:
                        String unused2 = sentryException.module = jsonObjectReader.nextStringOrNull();
                        break;
                    case 2:
                        String unused3 = sentryException.type = jsonObjectReader.nextStringOrNull();
                        break;
                    case 3:
                        String unused4 = sentryException.value = jsonObjectReader.nextStringOrNull();
                        break;
                    case 4:
                        Mechanism unused5 = sentryException.mechanism = (Mechanism) jsonObjectReader.nextOrNull(iLogger, new Mechanism.Deserializer());
                        break;
                    case 5:
                        SentryStackTrace unused6 = sentryException.stacktrace = (SentryStackTrace) jsonObjectReader.nextOrNull(iLogger, new SentryStackTrace.Deserializer());
                        break;
                    default:
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        jsonObjectReader.nextUnknown(iLogger, hashMap, nextName);
                        break;
                }
            }
            jsonObjectReader.endObject();
            sentryException.setUnknown(hashMap);
            return sentryException;
        }
    }
}
