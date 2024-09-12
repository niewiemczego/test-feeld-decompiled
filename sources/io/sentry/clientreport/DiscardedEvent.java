package io.sentry.clientreport;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonObjectReader;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectWriter;
import io.sentry.SentryLevel;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class DiscardedEvent implements JsonUnknown, JsonSerializable {
    private final String category;
    private final Long quantity;
    private final String reason;
    private Map<String, Object> unknown;

    public static final class JsonKeys {
        public static final String CATEGORY = "category";
        public static final String QUANTITY = "quantity";
        public static final String REASON = "reason";
    }

    public DiscardedEvent(String str, String str2, Long l) {
        this.reason = str;
        this.category = str2;
        this.quantity = l;
    }

    public String getReason() {
        return this.reason;
    }

    public String getCategory() {
        return this.category;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public String toString() {
        return "DiscardedEvent{reason='" + this.reason + '\'' + ", category='" + this.category + '\'' + ", quantity=" + this.quantity + '}';
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        objectWriter.name(JsonKeys.REASON).value(this.reason);
        objectWriter.name("category").value(this.category);
        objectWriter.name("quantity").value((Number) this.quantity);
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String next : map.keySet()) {
                objectWriter.name(next).value(iLogger, this.unknown.get(next));
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<DiscardedEvent> {
        public DiscardedEvent deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            jsonObjectReader.beginObject();
            String str = null;
            String str2 = null;
            Long l = null;
            HashMap hashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case -1285004149:
                        if (nextName.equals("quantity")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -934964668:
                        if (nextName.equals(JsonKeys.REASON)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 50511102:
                        if (nextName.equals("category")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        l = jsonObjectReader.nextLongOrNull();
                        break;
                    case 1:
                        str = jsonObjectReader.nextStringOrNull();
                        break;
                    case 2:
                        str2 = jsonObjectReader.nextStringOrNull();
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
            if (str == null) {
                throw missingRequiredFieldException(JsonKeys.REASON, iLogger);
            } else if (str2 == null) {
                throw missingRequiredFieldException("category", iLogger);
            } else if (l != null) {
                DiscardedEvent discardedEvent = new DiscardedEvent(str, str2, l);
                discardedEvent.setUnknown(hashMap);
                return discardedEvent;
            } else {
                throw missingRequiredFieldException("quantity", iLogger);
            }
        }

        private Exception missingRequiredFieldException(String str, ILogger iLogger) {
            String str2 = "Missing required field \"" + str + "\"";
            IllegalStateException illegalStateException = new IllegalStateException(str2);
            iLogger.log(SentryLevel.ERROR, str2, (Throwable) illegalStateException);
            return illegalStateException;
        }
    }
}
