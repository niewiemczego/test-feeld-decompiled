package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonObjectReader;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectWriter;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Geo implements JsonUnknown, JsonSerializable {
    /* access modifiers changed from: private */
    public String city;
    /* access modifiers changed from: private */
    public String countryCode;
    /* access modifiers changed from: private */
    public String region;
    private Map<String, Object> unknown;

    public static final class JsonKeys {
        public static final String CITY = "city";
        public static final String COUNTRY_CODE = "country_code";
        public static final String REGION = "region";
    }

    public Geo() {
    }

    public Geo(Geo geo) {
        this.city = geo.city;
        this.countryCode = geo.countryCode;
        this.region = geo.region;
    }

    public static Geo fromMap(Map<String, Object> map) {
        Geo geo = new Geo();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            String str = (String) next.getKey();
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -934795532:
                    if (str.equals("region")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3053931:
                    if (str.equals(JsonKeys.CITY)) {
                        c = 1;
                        break;
                    }
                    break;
                case 1481071862:
                    if (str.equals(JsonKeys.COUNTRY_CODE)) {
                        c = 2;
                        break;
                    }
                    break;
            }
            String str2 = null;
            switch (c) {
                case 0:
                    if (value instanceof String) {
                        str2 = (String) value;
                    }
                    geo.region = str2;
                    break;
                case 1:
                    if (value instanceof String) {
                        str2 = (String) value;
                    }
                    geo.city = str2;
                    break;
                case 2:
                    if (value instanceof String) {
                        str2 = (String) value;
                    }
                    geo.countryCode = str2;
                    break;
            }
        }
        return geo;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String str) {
        this.region = str;
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.city != null) {
            objectWriter.name(JsonKeys.CITY).value(this.city);
        }
        if (this.countryCode != null) {
            objectWriter.name(JsonKeys.COUNTRY_CODE).value(this.countryCode);
        }
        if (this.region != null) {
            objectWriter.name("region").value(this.region);
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

    public static final class Deserializer implements JsonDeserializer<Geo> {
        public Geo deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            jsonObjectReader.beginObject();
            Geo geo = new Geo();
            ConcurrentHashMap concurrentHashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case -934795532:
                        if (nextName.equals("region")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3053931:
                        if (nextName.equals(JsonKeys.CITY)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 1481071862:
                        if (nextName.equals(JsonKeys.COUNTRY_CODE)) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        String unused = geo.region = jsonObjectReader.nextStringOrNull();
                        break;
                    case 1:
                        String unused2 = geo.city = jsonObjectReader.nextStringOrNull();
                        break;
                    case 2:
                        String unused3 = geo.countryCode = jsonObjectReader.nextStringOrNull();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        jsonObjectReader.nextUnknown(iLogger, concurrentHashMap, nextName);
                        break;
                }
            }
            geo.setUnknown(concurrentHashMap);
            jsonObjectReader.endObject();
            return geo;
        }
    }
}
