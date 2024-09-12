package io.sentry;

import io.sentry.vendor.gson.stream.JsonReader;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public final class JsonObjectReader extends JsonReader {
    public JsonObjectReader(Reader reader) {
        super(reader);
    }

    public String nextStringOrNull() throws IOException {
        if (peek() != JsonToken.NULL) {
            return nextString();
        }
        nextNull();
        return null;
    }

    public Double nextDoubleOrNull() throws IOException {
        if (peek() != JsonToken.NULL) {
            return Double.valueOf(nextDouble());
        }
        nextNull();
        return null;
    }

    public Float nextFloatOrNull() throws IOException {
        if (peek() != JsonToken.NULL) {
            return nextFloat();
        }
        nextNull();
        return null;
    }

    public Float nextFloat() throws IOException {
        return Float.valueOf((float) nextDouble());
    }

    public Long nextLongOrNull() throws IOException {
        if (peek() != JsonToken.NULL) {
            return Long.valueOf(nextLong());
        }
        nextNull();
        return null;
    }

    public Integer nextIntegerOrNull() throws IOException {
        if (peek() != JsonToken.NULL) {
            return Integer.valueOf(nextInt());
        }
        nextNull();
        return null;
    }

    public Boolean nextBooleanOrNull() throws IOException {
        if (peek() != JsonToken.NULL) {
            return Boolean.valueOf(nextBoolean());
        }
        nextNull();
        return null;
    }

    public void nextUnknown(ILogger iLogger, Map<String, Object> map, String str) {
        try {
            map.put(str, nextObjectOrNull());
        } catch (Exception e) {
            iLogger.log(SentryLevel.ERROR, e, "Error deserializing unknown key: %s", str);
        }
    }

    public <T> List<T> nextListOrNull(ILogger iLogger, JsonDeserializer<T> jsonDeserializer) throws IOException {
        if (peek() == JsonToken.NULL) {
            nextNull();
            return null;
        }
        beginArray();
        ArrayList arrayList = new ArrayList();
        if (hasNext()) {
            do {
                try {
                    arrayList.add(jsonDeserializer.deserialize(this, iLogger));
                } catch (Exception e) {
                    iLogger.log(SentryLevel.WARNING, "Failed to deserialize object in list.", (Throwable) e);
                }
            } while (peek() == JsonToken.BEGIN_OBJECT);
        }
        endArray();
        return arrayList;
    }

    public <T> Map<String, T> nextMapOrNull(ILogger iLogger, JsonDeserializer<T> jsonDeserializer) throws IOException {
        if (peek() == JsonToken.NULL) {
            nextNull();
            return null;
        }
        beginObject();
        HashMap hashMap = new HashMap();
        if (hasNext()) {
            while (true) {
                try {
                    hashMap.put(nextName(), jsonDeserializer.deserialize(this, iLogger));
                } catch (Exception e) {
                    iLogger.log(SentryLevel.WARNING, "Failed to deserialize object in map.", (Throwable) e);
                }
                if (peek() != JsonToken.BEGIN_OBJECT && peek() != JsonToken.NAME) {
                    break;
                }
            }
        }
        endObject();
        return hashMap;
    }

    public <T> Map<String, List<T>> nextMapOfListOrNull(ILogger iLogger, JsonDeserializer<T> jsonDeserializer) throws IOException {
        if (peek() == JsonToken.NULL) {
            nextNull();
            return null;
        }
        HashMap hashMap = new HashMap();
        beginObject();
        if (hasNext()) {
            while (true) {
                String nextName = nextName();
                List<T> nextListOrNull = nextListOrNull(iLogger, jsonDeserializer);
                if (nextListOrNull != null) {
                    hashMap.put(nextName, nextListOrNull);
                }
                if (peek() != JsonToken.BEGIN_OBJECT && peek() != JsonToken.NAME) {
                    break;
                }
            }
        }
        endObject();
        return hashMap;
    }

    public <T> T nextOrNull(ILogger iLogger, JsonDeserializer<T> jsonDeserializer) throws Exception {
        if (peek() != JsonToken.NULL) {
            return jsonDeserializer.deserialize(this, iLogger);
        }
        nextNull();
        return null;
    }

    public Date nextDateOrNull(ILogger iLogger) throws IOException {
        if (peek() != JsonToken.NULL) {
            return dateOrNull(nextString(), iLogger);
        }
        nextNull();
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000f, code lost:
        r4.log(io.sentry.SentryLevel.ERROR, "Error when deserializing millis timestamp format.", (java.lang.Throwable) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000d, code lost:
        return io.sentry.DateUtils.getDateTimeWithMillisPrecision(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0009 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date dateOrNull(java.lang.String r3, io.sentry.ILogger r4) {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.util.Date r3 = io.sentry.DateUtils.getDateTime((java.lang.String) r3)     // Catch:{ Exception -> 0x0009 }
            return r3
        L_0x0009:
            java.util.Date r3 = io.sentry.DateUtils.getDateTimeWithMillisPrecision(r3)     // Catch:{ Exception -> 0x000e }
            return r3
        L_0x000e:
            r3 = move-exception
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.ERROR
            java.lang.String r2 = "Error when deserializing millis timestamp format."
            r4.log((io.sentry.SentryLevel) r1, (java.lang.String) r2, (java.lang.Throwable) r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.JsonObjectReader.dateOrNull(java.lang.String, io.sentry.ILogger):java.util.Date");
    }

    public TimeZone nextTimeZoneOrNull(ILogger iLogger) throws IOException {
        if (peek() == JsonToken.NULL) {
            nextNull();
            return null;
        }
        try {
            return TimeZone.getTimeZone(nextString());
        } catch (Exception e) {
            iLogger.log(SentryLevel.ERROR, "Error when deserializing TimeZone", (Throwable) e);
            return null;
        }
    }

    public Object nextObjectOrNull() throws IOException {
        return new JsonObjectDeserializer().deserialize(this);
    }
}
