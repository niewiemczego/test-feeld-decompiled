package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonObjectReader;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectWriter;
import io.sentry.SentryLevel;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class MeasurementValue implements JsonUnknown, JsonSerializable {
    public static final String KEY_APP_START_COLD = "app_start_cold";
    public static final String KEY_APP_START_WARM = "app_start_warm";
    public static final String KEY_FRAMES_DELAY = "frames_delay";
    public static final String KEY_FRAMES_FROZEN = "frames_frozen";
    public static final String KEY_FRAMES_SLOW = "frames_slow";
    public static final String KEY_FRAMES_TOTAL = "frames_total";
    public static final String KEY_TIME_TO_FULL_DISPLAY = "time_to_full_display";
    public static final String KEY_TIME_TO_INITIAL_DISPLAY = "time_to_initial_display";
    private final String unit;
    private Map<String, Object> unknown;
    private final Number value;

    public static final class JsonKeys {
        public static final String UNIT = "unit";
        public static final String VALUE = "value";
    }

    public MeasurementValue(Number number, String str) {
        this.value = number;
        this.unit = str;
    }

    public MeasurementValue(Number number, String str, Map<String, Object> map) {
        this.value = number;
        this.unit = str;
        this.unknown = map;
    }

    public Number getValue() {
        return this.value;
    }

    public String getUnit() {
        return this.unit;
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        objectWriter.name("value").value(this.value);
        if (this.unit != null) {
            objectWriter.name("unit").value(this.unit);
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

    public static final class Deserializer implements JsonDeserializer<MeasurementValue> {
        public MeasurementValue deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            jsonObjectReader.beginObject();
            Number number = null;
            String str = null;
            ConcurrentHashMap concurrentHashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                if (nextName.equals("unit")) {
                    str = jsonObjectReader.nextStringOrNull();
                } else if (!nextName.equals("value")) {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    jsonObjectReader.nextUnknown(iLogger, concurrentHashMap, nextName);
                } else {
                    number = (Number) jsonObjectReader.nextObjectOrNull();
                }
            }
            jsonObjectReader.endObject();
            if (number != null) {
                MeasurementValue measurementValue = new MeasurementValue(number, str);
                measurementValue.setUnknown(concurrentHashMap);
                return measurementValue;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"value\"");
            iLogger.log(SentryLevel.ERROR, "Missing required field \"value\"", (Throwable) illegalStateException);
            throw illegalStateException;
        }
    }
}
