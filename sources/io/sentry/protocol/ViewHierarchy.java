package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonObjectReader;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectWriter;
import io.sentry.protocol.ViewHierarchyNode;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ViewHierarchy implements JsonUnknown, JsonSerializable {
    private final String renderingSystem;
    private Map<String, Object> unknown;
    private final List<ViewHierarchyNode> windows;

    public static final class JsonKeys {
        public static final String RENDERING_SYSTEM = "rendering_system";
        public static final String WINDOWS = "windows";
    }

    public ViewHierarchy(String str, List<ViewHierarchyNode> list) {
        this.renderingSystem = str;
        this.windows = list;
    }

    public String getRenderingSystem() {
        return this.renderingSystem;
    }

    public List<ViewHierarchyNode> getWindows() {
        return this.windows;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.renderingSystem != null) {
            objectWriter.name("rendering_system").value(this.renderingSystem);
        }
        if (this.windows != null) {
            objectWriter.name(JsonKeys.WINDOWS).value(iLogger, this.windows);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String next : map.keySet()) {
                objectWriter.name(next).value(iLogger, this.unknown.get(next));
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

    public static final class Deserializer implements JsonDeserializer<ViewHierarchy> {
        public ViewHierarchy deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            jsonObjectReader.beginObject();
            String str = null;
            List list = null;
            HashMap hashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                if (nextName.equals("rendering_system")) {
                    str = jsonObjectReader.nextStringOrNull();
                } else if (!nextName.equals(JsonKeys.WINDOWS)) {
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    jsonObjectReader.nextUnknown(iLogger, hashMap, nextName);
                } else {
                    list = jsonObjectReader.nextListOrNull(iLogger, new ViewHierarchyNode.Deserializer());
                }
            }
            jsonObjectReader.endObject();
            ViewHierarchy viewHierarchy = new ViewHierarchy(str, list);
            viewHierarchy.setUnknown(hashMap);
            return viewHierarchy;
        }
    }
}
