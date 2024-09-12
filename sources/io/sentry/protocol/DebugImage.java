package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonObjectReader;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectWriter;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class DebugImage implements JsonUnknown, JsonSerializable {
    public static final String JVM = "jvm";
    public static final String PROGUARD = "proguard";
    /* access modifiers changed from: private */
    public String arch;
    /* access modifiers changed from: private */
    public String codeFile;
    /* access modifiers changed from: private */
    public String codeId;
    /* access modifiers changed from: private */
    public String debugFile;
    /* access modifiers changed from: private */
    public String debugId;
    /* access modifiers changed from: private */
    public String imageAddr;
    /* access modifiers changed from: private */
    public Long imageSize;
    /* access modifiers changed from: private */
    public String type;
    private Map<String, Object> unknown;
    /* access modifiers changed from: private */
    public String uuid;

    public static final class JsonKeys {
        public static final String ARCH = "arch";
        public static final String CODE_FILE = "code_file";
        public static final String CODE_ID = "code_id";
        public static final String DEBUG_FILE = "debug_file";
        public static final String DEBUG_ID = "debug_id";
        public static final String IMAGE_ADDR = "image_addr";
        public static final String IMAGE_SIZE = "image_size";
        public static final String TYPE = "type";
        public static final String UUID = "uuid";
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getDebugId() {
        return this.debugId;
    }

    public void setDebugId(String str) {
        this.debugId = str;
    }

    public String getDebugFile() {
        return this.debugFile;
    }

    public void setDebugFile(String str) {
        this.debugFile = str;
    }

    public String getCodeFile() {
        return this.codeFile;
    }

    public void setCodeFile(String str) {
        this.codeFile = str;
    }

    public String getImageAddr() {
        return this.imageAddr;
    }

    public void setImageAddr(String str) {
        this.imageAddr = str;
    }

    public Long getImageSize() {
        return this.imageSize;
    }

    public void setImageSize(Long l) {
        this.imageSize = l;
    }

    public void setImageSize(long j) {
        this.imageSize = Long.valueOf(j);
    }

    public String getArch() {
        return this.arch;
    }

    public void setArch(String str) {
        this.arch = str;
    }

    public String getCodeId() {
        return this.codeId;
    }

    public void setCodeId(String str) {
        this.codeId = str;
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.uuid != null) {
            objectWriter.name("uuid").value(this.uuid);
        }
        if (this.type != null) {
            objectWriter.name("type").value(this.type);
        }
        if (this.debugId != null) {
            objectWriter.name(JsonKeys.DEBUG_ID).value(this.debugId);
        }
        if (this.debugFile != null) {
            objectWriter.name(JsonKeys.DEBUG_FILE).value(this.debugFile);
        }
        if (this.codeId != null) {
            objectWriter.name(JsonKeys.CODE_ID).value(this.codeId);
        }
        if (this.codeFile != null) {
            objectWriter.name(JsonKeys.CODE_FILE).value(this.codeFile);
        }
        if (this.imageAddr != null) {
            objectWriter.name("image_addr").value(this.imageAddr);
        }
        if (this.imageSize != null) {
            objectWriter.name(JsonKeys.IMAGE_SIZE).value((Number) this.imageSize);
        }
        if (this.arch != null) {
            objectWriter.name(JsonKeys.ARCH).value(this.arch);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String next : map.keySet()) {
                objectWriter.name(next).value(iLogger, this.unknown.get(next));
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<DebugImage> {
        public DebugImage deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            DebugImage debugImage = new DebugImage();
            jsonObjectReader.beginObject();
            HashMap hashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case -1840639000:
                        if (nextName.equals(JsonKeys.DEBUG_FILE)) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1443345323:
                        if (nextName.equals("image_addr")) {
                            c = 1;
                            break;
                        }
                        break;
                    case -1442803611:
                        if (nextName.equals(JsonKeys.IMAGE_SIZE)) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1127437170:
                        if (nextName.equals(JsonKeys.CODE_FILE)) {
                            c = 3;
                            break;
                        }
                        break;
                    case 3002454:
                        if (nextName.equals(JsonKeys.ARCH)) {
                            c = 4;
                            break;
                        }
                        break;
                    case 3575610:
                        if (nextName.equals("type")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 3601339:
                        if (nextName.equals("uuid")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 547804807:
                        if (nextName.equals(JsonKeys.DEBUG_ID)) {
                            c = 7;
                            break;
                        }
                        break;
                    case 941842605:
                        if (nextName.equals(JsonKeys.CODE_ID)) {
                            c = 8;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        String unused = debugImage.debugFile = jsonObjectReader.nextStringOrNull();
                        break;
                    case 1:
                        String unused2 = debugImage.imageAddr = jsonObjectReader.nextStringOrNull();
                        break;
                    case 2:
                        Long unused3 = debugImage.imageSize = jsonObjectReader.nextLongOrNull();
                        break;
                    case 3:
                        String unused4 = debugImage.codeFile = jsonObjectReader.nextStringOrNull();
                        break;
                    case 4:
                        String unused5 = debugImage.arch = jsonObjectReader.nextStringOrNull();
                        break;
                    case 5:
                        String unused6 = debugImage.type = jsonObjectReader.nextStringOrNull();
                        break;
                    case 6:
                        String unused7 = debugImage.uuid = jsonObjectReader.nextStringOrNull();
                        break;
                    case 7:
                        String unused8 = debugImage.debugId = jsonObjectReader.nextStringOrNull();
                        break;
                    case 8:
                        String unused9 = debugImage.codeId = jsonObjectReader.nextStringOrNull();
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
            debugImage.setUnknown(hashMap);
            return debugImage;
        }
    }
}
