package io.sentry.profilemeasurements;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonObjectReader;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectWriter;
import io.sentry.profilemeasurements.ProfileMeasurementValue;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ProfileMeasurement implements JsonUnknown, JsonSerializable {
    public static final String ID_CPU_USAGE = "cpu_usage";
    public static final String ID_FROZEN_FRAME_RENDERS = "frozen_frame_renders";
    public static final String ID_MEMORY_FOOTPRINT = "memory_footprint";
    public static final String ID_MEMORY_NATIVE_FOOTPRINT = "memory_native_footprint";
    public static final String ID_SCREEN_FRAME_RATES = "screen_frame_rates";
    public static final String ID_SLOW_FRAME_RENDERS = "slow_frame_renders";
    public static final String ID_UNKNOWN = "unknown";
    public static final String UNIT_BYTES = "byte";
    public static final String UNIT_HZ = "hz";
    public static final String UNIT_NANOSECONDS = "nanosecond";
    public static final String UNIT_PERCENT = "percent";
    public static final String UNIT_UNKNOWN = "unknown";
    /* access modifiers changed from: private */
    public String unit;
    private Map<String, Object> unknown;
    /* access modifiers changed from: private */
    public Collection<ProfileMeasurementValue> values;

    public static final class JsonKeys {
        public static final String UNIT = "unit";
        public static final String VALUES = "values";
    }

    public ProfileMeasurement() {
        this("unknown", new ArrayList());
    }

    public ProfileMeasurement(String str, Collection<ProfileMeasurementValue> collection) {
        this.unit = str;
        this.values = collection;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ProfileMeasurement profileMeasurement = (ProfileMeasurement) obj;
        if (!Objects.equals(this.unknown, profileMeasurement.unknown) || !this.unit.equals(profileMeasurement.unit) || !new ArrayList(this.values).equals(new ArrayList(profileMeasurement.values))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(this.unknown, this.unit, this.values);
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        objectWriter.name("unit").value(iLogger, this.unit);
        objectWriter.name("values").value(iLogger, this.values);
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

    public String getUnit() {
        return this.unit;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public void setUnit(String str) {
        this.unit = str;
    }

    public Collection<ProfileMeasurementValue> getValues() {
        return this.values;
    }

    public void setValues(Collection<ProfileMeasurementValue> collection) {
        this.values = collection;
    }

    public static final class Deserializer implements JsonDeserializer<ProfileMeasurement> {
        public ProfileMeasurement deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            jsonObjectReader.beginObject();
            ProfileMeasurement profileMeasurement = new ProfileMeasurement();
            ConcurrentHashMap concurrentHashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                if (nextName.equals("values")) {
                    List nextListOrNull = jsonObjectReader.nextListOrNull(iLogger, new ProfileMeasurementValue.Deserializer());
                    if (nextListOrNull != null) {
                        Collection unused = profileMeasurement.values = nextListOrNull;
                    }
                } else if (!nextName.equals("unit")) {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    jsonObjectReader.nextUnknown(iLogger, concurrentHashMap, nextName);
                } else {
                    String nextStringOrNull = jsonObjectReader.nextStringOrNull();
                    if (nextStringOrNull != null) {
                        String unused2 = profileMeasurement.unit = nextStringOrNull;
                    }
                }
            }
            profileMeasurement.setUnknown(concurrentHashMap);
            jsonObjectReader.endObject();
            return profileMeasurement;
        }
    }
}
