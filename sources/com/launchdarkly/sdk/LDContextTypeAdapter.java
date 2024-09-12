package com.launchdarkly.sdk;

import com.facebook.appevents.UserDataStore;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class LDContextTypeAdapter extends TypeAdapter<LDContext> {
    private static final String JSON_PROP_META = "_meta";
    private static final String JSON_PROP_OLD_CUSTOM = "custom";
    private static final String JSON_PROP_OLD_PRIVATE = "privateAttributeNames";
    private static final String JSON_PROP_PRIVATE = "privateAttributes";

    LDContextTypeAdapter() {
    }

    public void write(JsonWriter jsonWriter, LDContext lDContext) throws IOException {
        if (!lDContext.isValid()) {
            throw new JsonIOException("tried to serialize invalid LDContext: " + lDContext.getError());
        } else if (lDContext.isMultiple()) {
            jsonWriter.beginObject();
            jsonWriter.name("kind").value(ContextKind.MULTI.toString());
            for (LDContext lDContext2 : lDContext.multiContexts) {
                jsonWriter.name(lDContext2.getKind().toString());
                writeSingleKind(jsonWriter, lDContext2, false);
            }
            jsonWriter.endObject();
        } else {
            writeSingleKind(jsonWriter, lDContext, true);
        }
    }

    private void writeSingleKind(JsonWriter jsonWriter, LDContext lDContext, boolean z) throws IOException {
        jsonWriter.beginObject();
        if (z) {
            jsonWriter.name("kind").value(lDContext.getKind().toString());
        }
        jsonWriter.name("key").value(lDContext.getKey());
        if (lDContext.getName() != null) {
            jsonWriter.name("name").value(lDContext.getName());
        }
        if (lDContext.isAnonymous()) {
            jsonWriter.name("anonymous").value(lDContext.isAnonymous());
        }
        if (lDContext.attributes != null) {
            for (Map.Entry next : lDContext.attributes.entrySet()) {
                jsonWriter.name((String) next.getKey());
                LDValueTypeAdapter.INSTANCE.write(jsonWriter, (LDValue) next.getValue());
            }
        }
        if (lDContext.getPrivateAttributeCount() != 0) {
            jsonWriter.name(JSON_PROP_META).beginObject();
            jsonWriter.name(JSON_PROP_PRIVATE).beginArray();
            for (AttributeRef attributeRef : lDContext.privateAttributes) {
                jsonWriter.value(attributeRef.toString());
            }
            jsonWriter.endArray();
            jsonWriter.endObject();
        }
        jsonWriter.endObject();
    }

    public LDContext read(JsonReader jsonReader) throws IOException {
        ContextKind contextKind;
        LDContext lDContext;
        LDValue requireValueType = requireValueType(LDValueTypeAdapter.INSTANCE.read(jsonReader), LDValueType.OBJECT, false, (String) null);
        Iterator<String> it = requireValueType.keys().iterator();
        while (true) {
            if (!it.hasNext()) {
                contextKind = null;
                break;
            }
            String next = it.next();
            if (next.equals("kind")) {
                contextKind = ContextKind.of(requireValueType(requireValueType.get(next), LDValueType.STRING, false, "kind").stringValue());
                break;
            }
        }
        if (contextKind == null) {
            lDContext = readOldUser(requireValueType);
        } else if (contextKind.equals(ContextKind.MULTI)) {
            ContextMultiBuilder multiBuilder = LDContext.multiBuilder();
            for (String next2 : requireValueType.keys()) {
                if (!next2.equals("kind")) {
                    multiBuilder.add(readSingleKind(requireValueType.get(next2), ContextKind.of(next2)));
                }
            }
            lDContext = multiBuilder.build();
        } else {
            lDContext = readSingleKind(requireValueType, (ContextKind) null);
        }
        if (lDContext.isValid()) {
            return lDContext;
        }
        throw new JsonParseException("invalid LDContext: " + lDContext.getError());
    }

    private static LDValue requireValueType(LDValue lDValue, LDValueType lDValueType, boolean z, String str) throws JsonParseException {
        String str2;
        if (lDValue.getType() == lDValueType || (z && lDValue.isNull())) {
            return lDValue;
        }
        StringBuilder append = new StringBuilder().append("expected ").append(lDValueType).append(", found ").append(lDValue.getType());
        if (str == null) {
            str2 = "";
        } else {
            str2 = " for " + str;
        }
        throw new JsonParseException(append.append(str2).toString());
    }

    private static LDContext readOldUser(LDValue lDValue) throws JsonParseException {
        requireValueType(lDValue, LDValueType.OBJECT, false, (String) null);
        ContextBuilder builder = LDContext.builder((String) null);
        builder.setAllowEmptyKey(true);
        for (String next : lDValue.keys()) {
            LDValue lDValue2 = lDValue.get(next);
            next.hashCode();
            char c = 65535;
            switch (next.hashCode()) {
                case -2095811475:
                    if (next.equals("anonymous")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1459599807:
                    if (next.equals("lastName")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1405959847:
                    if (next.equals("avatar")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1349088399:
                    if (next.equals("custom")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3367:
                    if (next.equals("ip")) {
                        c = 4;
                        break;
                    }
                    break;
                case 106079:
                    if (next.equals("key")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3373707:
                    if (next.equals("name")) {
                        c = 6;
                        break;
                    }
                    break;
                case 96619420:
                    if (next.equals("email")) {
                        c = 7;
                        break;
                    }
                    break;
                case 132835675:
                    if (next.equals("firstName")) {
                        c = 8;
                        break;
                    }
                    break;
                case 663359087:
                    if (next.equals(JSON_PROP_OLD_PRIVATE)) {
                        c = 9;
                        break;
                    }
                    break;
                case 957831062:
                    if (next.equals(UserDataStore.COUNTRY)) {
                        c = 10;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    builder.anonymous(requireValueType(lDValue2, LDValueType.BOOLEAN, true, next).booleanValue());
                    break;
                case 1:
                case 2:
                case 4:
                case 7:
                case 8:
                case 10:
                    builder.set(next, requireValueType(lDValue2, LDValueType.STRING, true, next));
                    break;
                case 3:
                    for (String next2 : requireValueType(lDValue2, LDValueType.OBJECT, true, "custom").keys()) {
                        builder.set(next2, lDValue2.get(next2));
                    }
                    break;
                case 5:
                    builder.key(requireValueType(lDValue2, LDValueType.STRING, false, next).stringValue());
                    break;
                case 6:
                    builder.name(requireValueType(lDValue2, LDValueType.STRING, true, next).stringValue());
                    break;
                case 9:
                    for (LDValue requireValueType : requireValueType(lDValue2, LDValueType.ARRAY, true, JSON_PROP_OLD_PRIVATE).values()) {
                        builder.privateAttributes(AttributeRef.fromLiteral(requireValueType(requireValueType, LDValueType.STRING, false, JSON_PROP_PRIVATE).stringValue()));
                    }
                    break;
            }
        }
        return builder.build();
    }

    private static LDContext readSingleKind(LDValue lDValue, ContextKind contextKind) throws JsonParseException {
        requireValueType(lDValue, LDValueType.OBJECT, false, contextKind == null ? null : contextKind.toString());
        ContextBuilder kind = LDContext.builder("").kind(contextKind);
        boolean z = contextKind != null;
        for (String next : lDValue.keys()) {
            LDValue lDValue2 = lDValue.get(next);
            next.hashCode();
            char c = 65535;
            switch (next.hashCode()) {
                case -2095811475:
                    if (next.equals("anonymous")) {
                        c = 0;
                        break;
                    }
                    break;
                case 106079:
                    if (next.equals("key")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3292052:
                    if (next.equals("kind")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3373707:
                    if (next.equals("name")) {
                        c = 3;
                        break;
                    }
                    break;
                case 91082468:
                    if (next.equals(JSON_PROP_META)) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    kind.anonymous(requireValueType(lDValue2, LDValueType.BOOLEAN, true, next).booleanValue());
                    break;
                case 1:
                    kind.key(requireValueType(lDValue2, LDValueType.STRING, false, next).stringValue());
                    break;
                case 2:
                    String stringValue = requireValueType(lDValue2, LDValueType.STRING, false, next).stringValue();
                    if (stringValue.isEmpty()) {
                        break;
                    } else {
                        kind.kind(stringValue);
                        z = true;
                        break;
                    }
                case 3:
                    kind.name(requireValueType(lDValue2, LDValueType.STRING, true, next).stringValue());
                    break;
                case 4:
                    for (LDValue requireValueType : requireValueType(requireValueType(lDValue2, LDValueType.OBJECT, true, next).get(JSON_PROP_PRIVATE), LDValueType.ARRAY, true, JSON_PROP_PRIVATE).values()) {
                        kind.privateAttributes(AttributeRef.fromPath(requireValueType(requireValueType, LDValueType.STRING, false, JSON_PROP_PRIVATE).stringValue()));
                    }
                    break;
                default:
                    kind.set(next, lDValue2);
                    break;
            }
        }
        if (!z) {
            return LDContext.failed("context kind must not be empty in JSON");
        }
        return kind.build();
    }
}
