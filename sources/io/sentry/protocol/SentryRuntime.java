package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonObjectReader;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectWriter;
import io.sentry.util.CollectionUtils;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class SentryRuntime implements JsonUnknown, JsonSerializable {
    public static final String TYPE = "runtime";
    /* access modifiers changed from: private */
    public String name;
    /* access modifiers changed from: private */
    public String rawDescription;
    private Map<String, Object> unknown;
    /* access modifiers changed from: private */
    public String version;

    public static final class JsonKeys {
        public static final String NAME = "name";
        public static final String RAW_DESCRIPTION = "raw_description";
        public static final String VERSION = "version";
    }

    public SentryRuntime() {
    }

    SentryRuntime(SentryRuntime sentryRuntime) {
        this.name = sentryRuntime.name;
        this.version = sentryRuntime.version;
        this.rawDescription = sentryRuntime.rawDescription;
        this.unknown = CollectionUtils.newConcurrentHashMap(sentryRuntime.unknown);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getRawDescription() {
        return this.rawDescription;
    }

    public void setRawDescription(String str) {
        this.rawDescription = str;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.name != null) {
            objectWriter.name("name").value(this.name);
        }
        if (this.version != null) {
            objectWriter.name("version").value(this.version);
        }
        if (this.rawDescription != null) {
            objectWriter.name("raw_description").value(this.rawDescription);
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

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public static final class Deserializer implements JsonDeserializer<SentryRuntime> {
        public SentryRuntime deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            jsonObjectReader.beginObject();
            SentryRuntime sentryRuntime = new SentryRuntime();
            ConcurrentHashMap concurrentHashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case -339173787:
                        if (nextName.equals("raw_description")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3373707:
                        if (nextName.equals("name")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 351608024:
                        if (nextName.equals("version")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        String unused = sentryRuntime.rawDescription = jsonObjectReader.nextStringOrNull();
                        break;
                    case 1:
                        String unused2 = sentryRuntime.name = jsonObjectReader.nextStringOrNull();
                        break;
                    case 2:
                        String unused3 = sentryRuntime.version = jsonObjectReader.nextStringOrNull();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        jsonObjectReader.nextUnknown(iLogger, concurrentHashMap, nextName);
                        break;
                }
            }
            sentryRuntime.setUnknown(concurrentHashMap);
            jsonObjectReader.endObject();
            return sentryRuntime;
        }
    }
}
