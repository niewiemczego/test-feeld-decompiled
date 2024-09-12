package io.sentry;

import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class MonitorSchedule implements JsonUnknown, JsonSerializable {
    private String type;
    private String unit;
    private Map<String, Object> unknown;
    private String value;

    public static final class JsonKeys {
        public static final String TYPE = "type";
        public static final String UNIT = "unit";
        public static final String VALUE = "value";
    }

    public static MonitorSchedule crontab(String str) {
        return new MonitorSchedule(MonitorScheduleType.CRONTAB.apiName(), str, (String) null);
    }

    public static MonitorSchedule interval(Integer num, MonitorScheduleUnit monitorScheduleUnit) {
        return new MonitorSchedule(MonitorScheduleType.INTERVAL.apiName(), num.toString(), monitorScheduleUnit.apiName());
    }

    public MonitorSchedule(String str, String str2, String str3) {
        this.type = str;
        this.value = str2;
        this.unit = str3;
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

    public void setValue(Integer num) {
        this.value = num.toString();
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String str) {
        this.unit = str;
    }

    public void setUnit(MonitorScheduleUnit monitorScheduleUnit) {
        this.unit = monitorScheduleUnit == null ? null : monitorScheduleUnit.apiName();
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        objectWriter.name("type").value(this.type);
        if (MonitorScheduleType.INTERVAL.apiName().equalsIgnoreCase(this.type)) {
            try {
                objectWriter.name("value").value((Number) Integer.valueOf(this.value));
            } catch (Throwable unused) {
                iLogger.log(SentryLevel.ERROR, "Unable to serialize monitor schedule value: %s", this.value);
            }
        } else {
            objectWriter.name("value").value(this.value);
        }
        if (this.unit != null) {
            objectWriter.name("unit").value(this.unit);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String next : map.keySet()) {
                objectWriter.name(next).value(iLogger, this.unknown.get(next));
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<MonitorSchedule> {
        public MonitorSchedule deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            jsonObjectReader.beginObject();
            String str = null;
            String str2 = null;
            String str3 = null;
            HashMap hashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case 3575610:
                        if (nextName.equals("type")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3594628:
                        if (nextName.equals("unit")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 111972721:
                        if (nextName.equals("value")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        str = jsonObjectReader.nextStringOrNull();
                        break;
                    case 1:
                        str3 = jsonObjectReader.nextStringOrNull();
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
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"type\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"type\"", (Throwable) illegalStateException);
                throw illegalStateException;
            } else if (str2 != null) {
                MonitorSchedule monitorSchedule = new MonitorSchedule(str, str2, str3);
                monitorSchedule.setUnknown(hashMap);
                return monitorSchedule;
            } else {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"value\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"value\"", (Throwable) illegalStateException2);
                throw illegalStateException2;
            }
        }
    }
}
