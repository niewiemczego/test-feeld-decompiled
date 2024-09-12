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

public final class OperatingSystem implements JsonUnknown, JsonSerializable {
    public static final String TYPE = "os";
    /* access modifiers changed from: private */
    public String build;
    /* access modifiers changed from: private */
    public String kernelVersion;
    /* access modifiers changed from: private */
    public String name;
    /* access modifiers changed from: private */
    public String rawDescription;
    /* access modifiers changed from: private */
    public Boolean rooted;
    private Map<String, Object> unknown;
    /* access modifiers changed from: private */
    public String version;

    public static final class JsonKeys {
        public static final String BUILD = "build";
        public static final String KERNEL_VERSION = "kernel_version";
        public static final String NAME = "name";
        public static final String RAW_DESCRIPTION = "raw_description";
        public static final String ROOTED = "rooted";
        public static final String VERSION = "version";
    }

    public OperatingSystem() {
    }

    OperatingSystem(OperatingSystem operatingSystem) {
        this.name = operatingSystem.name;
        this.version = operatingSystem.version;
        this.rawDescription = operatingSystem.rawDescription;
        this.build = operatingSystem.build;
        this.kernelVersion = operatingSystem.kernelVersion;
        this.rooted = operatingSystem.rooted;
        this.unknown = CollectionUtils.newConcurrentHashMap(operatingSystem.unknown);
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

    public String getBuild() {
        return this.build;
    }

    public void setBuild(String str) {
        this.build = str;
    }

    public String getKernelVersion() {
        return this.kernelVersion;
    }

    public void setKernelVersion(String str) {
        this.kernelVersion = str;
    }

    public Boolean isRooted() {
        return this.rooted;
    }

    public void setRooted(Boolean bool) {
        this.rooted = bool;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OperatingSystem operatingSystem = (OperatingSystem) obj;
        if (!Objects.equals(this.name, operatingSystem.name) || !Objects.equals(this.version, operatingSystem.version) || !Objects.equals(this.rawDescription, operatingSystem.rawDescription) || !Objects.equals(this.build, operatingSystem.build) || !Objects.equals(this.kernelVersion, operatingSystem.kernelVersion) || !Objects.equals(this.rooted, operatingSystem.rooted)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(this.name, this.version, this.rawDescription, this.build, this.kernelVersion, this.rooted);
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
        if (this.build != null) {
            objectWriter.name(JsonKeys.BUILD).value(this.build);
        }
        if (this.kernelVersion != null) {
            objectWriter.name(JsonKeys.KERNEL_VERSION).value(this.kernelVersion);
        }
        if (this.rooted != null) {
            objectWriter.name(JsonKeys.ROOTED).value(this.rooted);
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

    public static final class Deserializer implements JsonDeserializer<OperatingSystem> {
        public OperatingSystem deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            jsonObjectReader.beginObject();
            OperatingSystem operatingSystem = new OperatingSystem();
            ConcurrentHashMap concurrentHashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case -925311743:
                        if (nextName.equals(JsonKeys.ROOTED)) {
                            c = 0;
                            break;
                        }
                        break;
                    case -339173787:
                        if (nextName.equals("raw_description")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 3373707:
                        if (nextName.equals("name")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 94094958:
                        if (nextName.equals(JsonKeys.BUILD)) {
                            c = 3;
                            break;
                        }
                        break;
                    case 351608024:
                        if (nextName.equals("version")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 2015527638:
                        if (nextName.equals(JsonKeys.KERNEL_VERSION)) {
                            c = 5;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        Boolean unused = operatingSystem.rooted = jsonObjectReader.nextBooleanOrNull();
                        break;
                    case 1:
                        String unused2 = operatingSystem.rawDescription = jsonObjectReader.nextStringOrNull();
                        break;
                    case 2:
                        String unused3 = operatingSystem.name = jsonObjectReader.nextStringOrNull();
                        break;
                    case 3:
                        String unused4 = operatingSystem.build = jsonObjectReader.nextStringOrNull();
                        break;
                    case 4:
                        String unused5 = operatingSystem.version = jsonObjectReader.nextStringOrNull();
                        break;
                    case 5:
                        String unused6 = operatingSystem.kernelVersion = jsonObjectReader.nextStringOrNull();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        jsonObjectReader.nextUnknown(iLogger, concurrentHashMap, nextName);
                        break;
                }
            }
            operatingSystem.setUnknown(concurrentHashMap);
            jsonObjectReader.endObject();
            return operatingSystem;
        }
    }
}
