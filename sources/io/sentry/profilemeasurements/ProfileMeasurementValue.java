package io.sentry.profilemeasurements;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonObjectReader;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectWriter;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ProfileMeasurementValue implements JsonUnknown, JsonSerializable {
    /* access modifiers changed from: private */
    public String relativeStartNs;
    private Map<String, Object> unknown;
    /* access modifiers changed from: private */
    public double value;

    public static final class JsonKeys {
        public static final String START_NS = "elapsed_since_start_ns";
        public static final String VALUE = "value";
    }

    public ProfileMeasurementValue() {
        this(0L, 0);
    }

    public ProfileMeasurementValue(Long l, Number number) {
        this.relativeStartNs = l.toString();
        this.value = number.doubleValue();
    }

    public double getValue() {
        return this.value;
    }

    public String getRelativeStartNs() {
        return this.relativeStartNs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ProfileMeasurementValue profileMeasurementValue = (ProfileMeasurementValue) obj;
        if (!Objects.equals(this.unknown, profileMeasurementValue.unknown) || !this.relativeStartNs.equals(profileMeasurementValue.relativeStartNs) || this.value != profileMeasurementValue.value) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(this.unknown, this.relativeStartNs, Double.valueOf(this.value));
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        objectWriter.name("value").value(iLogger, Double.valueOf(this.value));
        objectWriter.name(JsonKeys.START_NS).value(iLogger, this.relativeStartNs);
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

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public static final class Deserializer implements JsonDeserializer<ProfileMeasurementValue> {
        public ProfileMeasurementValue deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            jsonObjectReader.beginObject();
            ProfileMeasurementValue profileMeasurementValue = new ProfileMeasurementValue();
            ConcurrentHashMap concurrentHashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                if (nextName.equals(JsonKeys.START_NS)) {
                    String nextStringOrNull = jsonObjectReader.nextStringOrNull();
                    if (nextStringOrNull != null) {
                        String unused = profileMeasurementValue.relativeStartNs = nextStringOrNull;
                    }
                } else if (!nextName.equals("value")) {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    jsonObjectReader.nextUnknown(iLogger, concurrentHashMap, nextName);
                } else {
                    Double nextDoubleOrNull = jsonObjectReader.nextDoubleOrNull();
                    if (nextDoubleOrNull != null) {
                        double unused2 = profileMeasurementValue.value = nextDoubleOrNull.doubleValue();
                    }
                }
            }
            profileMeasurementValue.setUnknown(concurrentHashMap);
            jsonObjectReader.endObject();
            return profileMeasurementValue;
        }
    }
}
