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

public final class Gpu implements JsonUnknown, JsonSerializable {
    public static final String TYPE = "gpu";
    /* access modifiers changed from: private */
    public String apiType;
    /* access modifiers changed from: private */
    public Integer id;
    /* access modifiers changed from: private */
    public Integer memorySize;
    /* access modifiers changed from: private */
    public Boolean multiThreadedRendering;
    /* access modifiers changed from: private */
    public String name;
    /* access modifiers changed from: private */
    public String npotSupport;
    private Map<String, Object> unknown;
    /* access modifiers changed from: private */
    public String vendorId;
    /* access modifiers changed from: private */
    public String vendorName;
    /* access modifiers changed from: private */
    public String version;

    public static final class JsonKeys {
        public static final String API_TYPE = "api_type";
        public static final String ID = "id";
        public static final String MEMORY_SIZE = "memory_size";
        public static final String MULTI_THREADED_RENDERING = "multi_threaded_rendering";
        public static final String NAME = "name";
        public static final String NPOT_SUPPORT = "npot_support";
        public static final String VENDOR_ID = "vendor_id";
        public static final String VENDOR_NAME = "vendor_name";
        public static final String VERSION = "version";
    }

    public Gpu() {
    }

    Gpu(Gpu gpu) {
        this.name = gpu.name;
        this.id = gpu.id;
        this.vendorId = gpu.vendorId;
        this.vendorName = gpu.vendorName;
        this.memorySize = gpu.memorySize;
        this.apiType = gpu.apiType;
        this.multiThreadedRendering = gpu.multiThreadedRendering;
        this.version = gpu.version;
        this.npotSupport = gpu.npotSupport;
        this.unknown = CollectionUtils.newConcurrentHashMap(gpu.unknown);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public String getVendorId() {
        return this.vendorId;
    }

    public void setVendorId(String str) {
        this.vendorId = str;
    }

    public String getVendorName() {
        return this.vendorName;
    }

    public void setVendorName(String str) {
        this.vendorName = str;
    }

    public Integer getMemorySize() {
        return this.memorySize;
    }

    public void setMemorySize(Integer num) {
        this.memorySize = num;
    }

    public String getApiType() {
        return this.apiType;
    }

    public void setApiType(String str) {
        this.apiType = str;
    }

    public Boolean isMultiThreadedRendering() {
        return this.multiThreadedRendering;
    }

    public void setMultiThreadedRendering(Boolean bool) {
        this.multiThreadedRendering = bool;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getNpotSupport() {
        return this.npotSupport;
    }

    public void setNpotSupport(String str) {
        this.npotSupport = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Gpu gpu = (Gpu) obj;
        if (!Objects.equals(this.name, gpu.name) || !Objects.equals(this.id, gpu.id) || !Objects.equals(this.vendorId, gpu.vendorId) || !Objects.equals(this.vendorName, gpu.vendorName) || !Objects.equals(this.memorySize, gpu.memorySize) || !Objects.equals(this.apiType, gpu.apiType) || !Objects.equals(this.multiThreadedRendering, gpu.multiThreadedRendering) || !Objects.equals(this.version, gpu.version) || !Objects.equals(this.npotSupport, gpu.npotSupport)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(this.name, this.id, this.vendorId, this.vendorName, this.memorySize, this.apiType, this.multiThreadedRendering, this.version, this.npotSupport);
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.name != null) {
            objectWriter.name("name").value(this.name);
        }
        if (this.id != null) {
            objectWriter.name("id").value((Number) this.id);
        }
        if (this.vendorId != null) {
            objectWriter.name(JsonKeys.VENDOR_ID).value(this.vendorId);
        }
        if (this.vendorName != null) {
            objectWriter.name(JsonKeys.VENDOR_NAME).value(this.vendorName);
        }
        if (this.memorySize != null) {
            objectWriter.name("memory_size").value((Number) this.memorySize);
        }
        if (this.apiType != null) {
            objectWriter.name(JsonKeys.API_TYPE).value(this.apiType);
        }
        if (this.multiThreadedRendering != null) {
            objectWriter.name(JsonKeys.MULTI_THREADED_RENDERING).value(this.multiThreadedRendering);
        }
        if (this.version != null) {
            objectWriter.name("version").value(this.version);
        }
        if (this.npotSupport != null) {
            objectWriter.name(JsonKeys.NPOT_SUPPORT).value(this.npotSupport);
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

    public static final class Deserializer implements JsonDeserializer<Gpu> {
        public Gpu deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            jsonObjectReader.beginObject();
            Gpu gpu = new Gpu();
            ConcurrentHashMap concurrentHashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case -1421884745:
                        if (nextName.equals(JsonKeys.NPOT_SUPPORT)) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1085970574:
                        if (nextName.equals(JsonKeys.VENDOR_ID)) {
                            c = 1;
                            break;
                        }
                        break;
                    case -1009234244:
                        if (nextName.equals(JsonKeys.MULTI_THREADED_RENDERING)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 3355:
                        if (nextName.equals("id")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 3373707:
                        if (nextName.equals("name")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 59480866:
                        if (nextName.equals(JsonKeys.VENDOR_NAME)) {
                            c = 5;
                            break;
                        }
                        break;
                    case 351608024:
                        if (nextName.equals("version")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 967446079:
                        if (nextName.equals(JsonKeys.API_TYPE)) {
                            c = 7;
                            break;
                        }
                        break;
                    case 1418777727:
                        if (nextName.equals("memory_size")) {
                            c = 8;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        String unused = gpu.npotSupport = jsonObjectReader.nextStringOrNull();
                        break;
                    case 1:
                        String unused2 = gpu.vendorId = jsonObjectReader.nextStringOrNull();
                        break;
                    case 2:
                        Boolean unused3 = gpu.multiThreadedRendering = jsonObjectReader.nextBooleanOrNull();
                        break;
                    case 3:
                        Integer unused4 = gpu.id = jsonObjectReader.nextIntegerOrNull();
                        break;
                    case 4:
                        String unused5 = gpu.name = jsonObjectReader.nextStringOrNull();
                        break;
                    case 5:
                        String unused6 = gpu.vendorName = jsonObjectReader.nextStringOrNull();
                        break;
                    case 6:
                        String unused7 = gpu.version = jsonObjectReader.nextStringOrNull();
                        break;
                    case 7:
                        String unused8 = gpu.apiType = jsonObjectReader.nextStringOrNull();
                        break;
                    case 8:
                        Integer unused9 = gpu.memorySize = jsonObjectReader.nextIntegerOrNull();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        jsonObjectReader.nextUnknown(iLogger, concurrentHashMap, nextName);
                        break;
                }
            }
            gpu.setUnknown(concurrentHashMap);
            jsonObjectReader.endObject();
            return gpu;
        }
    }
}
