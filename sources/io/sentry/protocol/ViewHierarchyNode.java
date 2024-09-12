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
import java.util.List;
import java.util.Map;

public final class ViewHierarchyNode implements JsonUnknown, JsonSerializable {
    /* access modifiers changed from: private */
    public Double alpha;
    /* access modifiers changed from: private */
    public List<ViewHierarchyNode> children;
    /* access modifiers changed from: private */
    public Double height;
    /* access modifiers changed from: private */
    public String identifier;
    /* access modifiers changed from: private */
    public String renderingSystem;
    /* access modifiers changed from: private */
    public String tag;
    /* access modifiers changed from: private */
    public String type;
    private Map<String, Object> unknown;
    /* access modifiers changed from: private */
    public String visibility;
    /* access modifiers changed from: private */
    public Double width;
    /* access modifiers changed from: private */
    public Double x;
    /* access modifiers changed from: private */
    public Double y;

    public static final class JsonKeys {
        public static final String ALPHA = "alpha";
        public static final String CHILDREN = "children";
        public static final String HEIGHT = "height";
        public static final String IDENTIFIER = "identifier";
        public static final String RENDERING_SYSTEM = "rendering_system";
        public static final String TAG = "tag";
        public static final String TYPE = "type";
        public static final String VISIBILITY = "visibility";
        public static final String WIDTH = "width";
        public static final String X = "x";
        public static final String Y = "y";
    }

    public void setRenderingSystem(String str) {
        this.renderingSystem = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setWidth(Double d) {
        this.width = d;
    }

    public void setHeight(Double d) {
        this.height = d;
    }

    public void setX(Double d) {
        this.x = d;
    }

    public void setY(Double d) {
        this.y = d;
    }

    public void setVisibility(String str) {
        this.visibility = str;
    }

    public void setAlpha(Double d) {
        this.alpha = d;
    }

    public void setChildren(List<ViewHierarchyNode> list) {
        this.children = list;
    }

    public String getRenderingSystem() {
        return this.renderingSystem;
    }

    public String getType() {
        return this.type;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getTag() {
        return this.tag;
    }

    public Double getWidth() {
        return this.width;
    }

    public Double getHeight() {
        return this.height;
    }

    public Double getX() {
        return this.x;
    }

    public Double getY() {
        return this.y;
    }

    public String getVisibility() {
        return this.visibility;
    }

    public Double getAlpha() {
        return this.alpha;
    }

    public List<ViewHierarchyNode> getChildren() {
        return this.children;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.renderingSystem != null) {
            objectWriter.name("rendering_system").value(this.renderingSystem);
        }
        if (this.type != null) {
            objectWriter.name("type").value(this.type);
        }
        if (this.identifier != null) {
            objectWriter.name(JsonKeys.IDENTIFIER).value(this.identifier);
        }
        if (this.tag != null) {
            objectWriter.name("tag").value(this.tag);
        }
        if (this.width != null) {
            objectWriter.name("width").value((Number) this.width);
        }
        if (this.height != null) {
            objectWriter.name("height").value((Number) this.height);
        }
        if (this.x != null) {
            objectWriter.name(JsonKeys.X).value((Number) this.x);
        }
        if (this.y != null) {
            objectWriter.name(JsonKeys.Y).value((Number) this.y);
        }
        if (this.visibility != null) {
            objectWriter.name("visibility").value(this.visibility);
        }
        if (this.alpha != null) {
            objectWriter.name(JsonKeys.ALPHA).value((Number) this.alpha);
        }
        List<ViewHierarchyNode> list = this.children;
        if (list != null && !list.isEmpty()) {
            objectWriter.name(JsonKeys.CHILDREN).value(iLogger, this.children);
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

    public static final class Deserializer implements JsonDeserializer<ViewHierarchyNode> {
        public ViewHierarchyNode deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            ViewHierarchyNode viewHierarchyNode = new ViewHierarchyNode();
            jsonObjectReader.beginObject();
            HashMap hashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case -1784982718:
                        if (nextName.equals("rendering_system")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1618432855:
                        if (nextName.equals(JsonKeys.IDENTIFIER)) {
                            c = 1;
                            break;
                        }
                        break;
                    case -1221029593:
                        if (nextName.equals("height")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 120:
                        if (nextName.equals(JsonKeys.X)) {
                            c = 3;
                            break;
                        }
                        break;
                    case 121:
                        if (nextName.equals(JsonKeys.Y)) {
                            c = 4;
                            break;
                        }
                        break;
                    case 114586:
                        if (nextName.equals("tag")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 3575610:
                        if (nextName.equals("type")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 92909918:
                        if (nextName.equals(JsonKeys.ALPHA)) {
                            c = 7;
                            break;
                        }
                        break;
                    case 113126854:
                        if (nextName.equals("width")) {
                            c = 8;
                            break;
                        }
                        break;
                    case 1659526655:
                        if (nextName.equals(JsonKeys.CHILDREN)) {
                            c = 9;
                            break;
                        }
                        break;
                    case 1941332754:
                        if (nextName.equals("visibility")) {
                            c = 10;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        String unused = viewHierarchyNode.renderingSystem = jsonObjectReader.nextStringOrNull();
                        break;
                    case 1:
                        String unused2 = viewHierarchyNode.identifier = jsonObjectReader.nextStringOrNull();
                        break;
                    case 2:
                        Double unused3 = viewHierarchyNode.height = jsonObjectReader.nextDoubleOrNull();
                        break;
                    case 3:
                        Double unused4 = viewHierarchyNode.x = jsonObjectReader.nextDoubleOrNull();
                        break;
                    case 4:
                        Double unused5 = viewHierarchyNode.y = jsonObjectReader.nextDoubleOrNull();
                        break;
                    case 5:
                        String unused6 = viewHierarchyNode.tag = jsonObjectReader.nextStringOrNull();
                        break;
                    case 6:
                        String unused7 = viewHierarchyNode.type = jsonObjectReader.nextStringOrNull();
                        break;
                    case 7:
                        Double unused8 = viewHierarchyNode.alpha = jsonObjectReader.nextDoubleOrNull();
                        break;
                    case 8:
                        Double unused9 = viewHierarchyNode.width = jsonObjectReader.nextDoubleOrNull();
                        break;
                    case 9:
                        List unused10 = viewHierarchyNode.children = jsonObjectReader.nextListOrNull(iLogger, this);
                        break;
                    case 10:
                        String unused11 = viewHierarchyNode.visibility = jsonObjectReader.nextStringOrNull();
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
            viewHierarchyNode.setUnknown(hashMap);
            return viewHierarchyNode;
        }
    }
}
