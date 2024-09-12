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
import java.util.HashMap;
import java.util.Map;

public final class Mechanism implements JsonUnknown, JsonSerializable {
    /* access modifiers changed from: private */
    public Map<String, Object> data;
    /* access modifiers changed from: private */
    public String description;
    /* access modifiers changed from: private */
    public Boolean handled;
    /* access modifiers changed from: private */
    public String helpLink;
    /* access modifiers changed from: private */
    public Map<String, Object> meta;
    /* access modifiers changed from: private */
    public Boolean synthetic;
    private final transient Thread thread;
    /* access modifiers changed from: private */
    public String type;
    private Map<String, Object> unknown;

    public static final class JsonKeys {
        public static final String DATA = "data";
        public static final String DESCRIPTION = "description";
        public static final String HANDLED = "handled";
        public static final String HELP_LINK = "help_link";
        public static final String META = "meta";
        public static final String SYNTHETIC = "synthetic";
        public static final String TYPE = "type";
    }

    public Mechanism() {
        this((Thread) null);
    }

    public Mechanism(Thread thread2) {
        this.thread = thread2;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getHelpLink() {
        return this.helpLink;
    }

    public void setHelpLink(String str) {
        this.helpLink = str;
    }

    public Boolean isHandled() {
        return this.handled;
    }

    public void setHandled(Boolean bool) {
        this.handled = bool;
    }

    public Map<String, Object> getMeta() {
        return this.meta;
    }

    public void setMeta(Map<String, Object> map) {
        this.meta = CollectionUtils.newHashMap(map);
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public void setData(Map<String, Object> map) {
        this.data = CollectionUtils.newHashMap(map);
    }

    /* access modifiers changed from: package-private */
    public Thread getThread() {
        return this.thread;
    }

    public Boolean getSynthetic() {
        return this.synthetic;
    }

    public void setSynthetic(Boolean bool) {
        this.synthetic = bool;
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.type != null) {
            objectWriter.name("type").value(this.type);
        }
        if (this.description != null) {
            objectWriter.name("description").value(this.description);
        }
        if (this.helpLink != null) {
            objectWriter.name(JsonKeys.HELP_LINK).value(this.helpLink);
        }
        if (this.handled != null) {
            objectWriter.name(JsonKeys.HANDLED).value(this.handled);
        }
        if (this.meta != null) {
            objectWriter.name(JsonKeys.META).value(iLogger, this.meta);
        }
        if (this.data != null) {
            objectWriter.name("data").value(iLogger, this.data);
        }
        if (this.synthetic != null) {
            objectWriter.name(JsonKeys.SYNTHETIC).value(this.synthetic);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String next : map.keySet()) {
                objectWriter.name(next).value(iLogger, this.unknown.get(next));
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<Mechanism> {
        public Mechanism deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            Mechanism mechanism = new Mechanism();
            jsonObjectReader.beginObject();
            HashMap hashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case -1724546052:
                        if (nextName.equals("description")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3076010:
                        if (nextName.equals("data")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 3347973:
                        if (nextName.equals(JsonKeys.META)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 3575610:
                        if (nextName.equals("type")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 692803388:
                        if (nextName.equals(JsonKeys.HANDLED)) {
                            c = 4;
                            break;
                        }
                        break;
                    case 989128517:
                        if (nextName.equals(JsonKeys.SYNTHETIC)) {
                            c = 5;
                            break;
                        }
                        break;
                    case 1297152568:
                        if (nextName.equals(JsonKeys.HELP_LINK)) {
                            c = 6;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        String unused = mechanism.description = jsonObjectReader.nextStringOrNull();
                        break;
                    case 1:
                        Map unused2 = mechanism.data = CollectionUtils.newConcurrentHashMap((Map) jsonObjectReader.nextObjectOrNull());
                        break;
                    case 2:
                        Map unused3 = mechanism.meta = CollectionUtils.newConcurrentHashMap((Map) jsonObjectReader.nextObjectOrNull());
                        break;
                    case 3:
                        String unused4 = mechanism.type = jsonObjectReader.nextStringOrNull();
                        break;
                    case 4:
                        Boolean unused5 = mechanism.handled = jsonObjectReader.nextBooleanOrNull();
                        break;
                    case 5:
                        Boolean unused6 = mechanism.synthetic = jsonObjectReader.nextBooleanOrNull();
                        break;
                    case 6:
                        String unused7 = mechanism.helpLink = jsonObjectReader.nextStringOrNull();
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
            mechanism.setUnknown(hashMap);
            return mechanism;
        }
    }
}
