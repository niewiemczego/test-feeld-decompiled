package com.launchdarkly.sdk.internal.events;

import com.google.gson.stream.JsonWriter;
import com.launchdarkly.sdk.AttributeRef;
import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.LDValue;
import com.launchdarkly.sdk.LDValueType;
import com.launchdarkly.sdk.internal.GsonHelpers;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

class EventContextFormatter {
    private final boolean allAttributesPrivate;
    private final AttributeRef[] globalPrivateAttributes;

    EventContextFormatter(boolean z, AttributeRef[] attributeRefArr) {
        this.allAttributesPrivate = z;
        this.globalPrivateAttributes = attributeRefArr == null ? new AttributeRef[0] : attributeRefArr;
    }

    public void write(LDContext lDContext, JsonWriter jsonWriter) throws IOException {
        if (lDContext.isMultiple()) {
            jsonWriter.beginObject();
            jsonWriter.name("kind").value("multi");
            for (int i = 0; i < lDContext.getIndividualContextCount(); i++) {
                LDContext individualContext = lDContext.getIndividualContext(i);
                jsonWriter.name(individualContext.getKind().toString());
                writeSingleKind(individualContext, jsonWriter, false);
            }
            jsonWriter.endObject();
            return;
        }
        writeSingleKind(lDContext, jsonWriter, true);
    }

    private void writeSingleKind(LDContext lDContext, JsonWriter jsonWriter, boolean z) throws IOException {
        jsonWriter.beginObject();
        if (z) {
            jsonWriter.name("kind").value(lDContext.getKind().toString());
        }
        jsonWriter.name("key").value(lDContext.getKey());
        boolean z2 = true;
        if (lDContext.isAnonymous()) {
            jsonWriter.name("anonymous").value(true);
        }
        List<String> list = null;
        if (lDContext.getName() != null) {
            if (isAttributeEntirelyPrivate(lDContext, "name")) {
                list = addOrCreate((List) null, "name");
            } else {
                jsonWriter.name("name").value(lDContext.getName());
            }
        }
        List<String> list2 = list;
        for (String next : lDContext.getCustomAttributeNames()) {
            list2 = writeOrRedactAttribute(jsonWriter, lDContext, next, lDContext.getValue(next), list2);
        }
        if (list2 == null || list2.isEmpty()) {
            z2 = false;
        }
        if (z2) {
            jsonWriter.name("_meta").beginObject();
            jsonWriter.name("redactedAttributes").beginArray();
            for (String value : list2) {
                jsonWriter.value(value);
            }
            jsonWriter.endArray();
            jsonWriter.endObject();
        }
        jsonWriter.endObject();
    }

    private boolean isAttributeEntirelyPrivate(LDContext lDContext, String str) {
        if (this.allAttributesPrivate) {
            return true;
        }
        AttributeRef findPrivateRef = findPrivateRef(lDContext, 1, str, (AttributeRef) null);
        if (findPrivateRef == null || findPrivateRef.getDepth() != 1) {
            return false;
        }
        return true;
    }

    private List<String> writeOrRedactAttribute(JsonWriter jsonWriter, LDContext lDContext, String str, LDValue lDValue, List<String> list) throws IOException {
        if (this.allAttributesPrivate) {
            return addOrCreate(list, str);
        }
        return writeRedactedValue(jsonWriter, lDContext, 0, str, lDValue, (AttributeRef) null, list);
    }

    private List<String> writeRedactedValue(JsonWriter jsonWriter, LDContext lDContext, int i, String str, LDValue lDValue, AttributeRef attributeRef, List<String> list) throws IOException {
        int i2 = i + 1;
        AttributeRef findPrivateRef = findPrivateRef(lDContext, i2, str, attributeRef);
        if (findPrivateRef != null && findPrivateRef.getDepth() == i2) {
            return addOrCreate(list, findPrivateRef.toString());
        }
        if (findPrivateRef == null || lDValue.getType() != LDValueType.OBJECT) {
            writeNameAndValue(jsonWriter, str, lDValue);
            return list;
        }
        jsonWriter.name(str).beginObject();
        List<String> list2 = list;
        for (String next : lDValue.keys()) {
            list2 = writeRedactedValue(jsonWriter, lDContext, i2, next, lDValue.get(next), findPrivateRef, list2);
        }
        jsonWriter.endObject();
        return list2;
    }

    private AttributeRef findPrivateRef(LDContext lDContext, int i, String str, AttributeRef attributeRef) {
        AttributeRef[] attributeRefArr = this.globalPrivateAttributes;
        AttributeRef attributeRef2 = null;
        if (attributeRefArr.length != 0) {
            for (AttributeRef attributeRef3 : attributeRefArr) {
                if (matchPrivateRef(attributeRef3, i, str, attributeRef)) {
                    if (attributeRef3.getDepth() == i) {
                        return attributeRef3;
                    }
                    attributeRef2 = attributeRef3;
                }
            }
        }
        for (int i2 = 0; i2 < lDContext.getPrivateAttributeCount(); i2++) {
            AttributeRef privateAttribute = lDContext.getPrivateAttribute(i2);
            if (matchPrivateRef(privateAttribute, i, str, attributeRef)) {
                if (privateAttribute.getDepth() == i) {
                    return privateAttribute;
                }
                attributeRef2 = privateAttribute;
            }
        }
        return attributeRef2;
    }

    private static boolean matchPrivateRef(AttributeRef attributeRef, int i, String str, AttributeRef attributeRef2) {
        if (attributeRef.getDepth() < i) {
            return false;
        }
        int i2 = 0;
        while (true) {
            int i3 = i - 1;
            if (i2 >= i3) {
                return attributeRef.getComponent(i3).equals(str);
            }
            if (!attributeRef.getComponent(i2).equals(attributeRef2.getComponent(i2))) {
                return false;
            }
            i2++;
        }
    }

    private static void writeNameAndValue(JsonWriter jsonWriter, String str, LDValue lDValue) throws IOException {
        jsonWriter.name(str);
        GsonHelpers.gsonInstance().toJson((Object) lDValue, (Type) LDValue.class, jsonWriter);
    }

    private static <T> List<T> addOrCreate(List<T> list, T t) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(t);
        return list;
    }
}
