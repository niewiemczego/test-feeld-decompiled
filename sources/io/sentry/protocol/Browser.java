package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonObjectReader;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectWriter;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Browser implements JsonUnknown, JsonSerializable {
    public static final String TYPE = "browser";
    /* access modifiers changed from: private */
    public String name;
    private Map<String, Object> unknown;
    /* access modifiers changed from: private */
    public String version;

    public static final class JsonKeys {
        public static final String NAME = "name";
        public static final String VERSION = "version";
    }

    public Browser() {
    }

    Browser(Browser browser) {
        this.name = browser.name;
        this.version = browser.version;
        this.unknown = CollectionUtils.newConcurrentHashMap(browser.unknown);
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

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Browser browser = (Browser) obj;
        if (!Objects.equals(this.name, browser.name) || !Objects.equals(this.version, browser.version)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(this.name, this.version);
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.name != null) {
            objectWriter.name("name").value(this.name);
        }
        if (this.version != null) {
            objectWriter.name("version").value(this.version);
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

    public static final class Deserializer implements JsonDeserializer<Browser> {
        public Browser deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            jsonObjectReader.beginObject();
            Browser browser = new Browser();
            ConcurrentHashMap concurrentHashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                if (nextName.equals("name")) {
                    String unused = browser.name = jsonObjectReader.nextStringOrNull();
                } else if (!nextName.equals("version")) {
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    jsonObjectReader.nextUnknown(iLogger, concurrentHashMap, nextName);
                } else {
                    String unused2 = browser.version = jsonObjectReader.nextStringOrNull();
                }
            }
            browser.setUnknown(concurrentHashMap);
            jsonObjectReader.endObject();
            return browser;
        }
    }
}
