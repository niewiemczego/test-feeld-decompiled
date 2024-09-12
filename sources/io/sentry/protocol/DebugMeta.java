package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonObjectReader;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectWriter;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.SdkInfo;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DebugMeta implements JsonUnknown, JsonSerializable {
    /* access modifiers changed from: private */
    public List<DebugImage> images;
    /* access modifiers changed from: private */
    public SdkInfo sdkInfo;
    private Map<String, Object> unknown;

    public static final class JsonKeys {
        public static final String IMAGES = "images";
        public static final String SDK_INFO = "sdk_info";
    }

    public List<DebugImage> getImages() {
        return this.images;
    }

    public void setImages(List<DebugImage> list) {
        this.images = list != null ? new ArrayList(list) : null;
    }

    public SdkInfo getSdkInfo() {
        return this.sdkInfo;
    }

    public void setSdkInfo(SdkInfo sdkInfo2) {
        this.sdkInfo = sdkInfo2;
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.sdkInfo != null) {
            objectWriter.name(JsonKeys.SDK_INFO).value(iLogger, this.sdkInfo);
        }
        if (this.images != null) {
            objectWriter.name(JsonKeys.IMAGES).value(iLogger, this.images);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String next : map.keySet()) {
                objectWriter.name(next).value(iLogger, this.unknown.get(next));
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<DebugMeta> {
        public DebugMeta deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            DebugMeta debugMeta = new DebugMeta();
            jsonObjectReader.beginObject();
            HashMap hashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                if (nextName.equals(JsonKeys.IMAGES)) {
                    List unused = debugMeta.images = jsonObjectReader.nextListOrNull(iLogger, new DebugImage.Deserializer());
                } else if (!nextName.equals(JsonKeys.SDK_INFO)) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    jsonObjectReader.nextUnknown(iLogger, hashMap, nextName);
                } else {
                    SdkInfo unused2 = debugMeta.sdkInfo = (SdkInfo) jsonObjectReader.nextOrNull(iLogger, new SdkInfo.Deserializer());
                }
            }
            jsonObjectReader.endObject();
            debugMeta.setUnknown(hashMap);
            return debugMeta;
        }
    }
}
