package com.launchdarkly.sdk;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

@JsonAdapter(LDValueTypeAdapter.class)
final class LDValueObject extends LDValue {
    private static final LDValueObject EMPTY = new LDValueObject(Collections.emptyMap());
    private final Map<String, LDValue> map;

    static LDValueObject fromMap(Map<String, LDValue> map2) {
        return map2.isEmpty() ? EMPTY : new LDValueObject(map2);
    }

    private LDValueObject(Map<String, LDValue> map2) {
        this.map = map2;
    }

    public LDValueType getType() {
        return LDValueType.OBJECT;
    }

    public int size() {
        return this.map.size();
    }

    public Iterable<String> keys() {
        return this.map.keySet();
    }

    public Iterable<LDValue> values() {
        return this.map.values();
    }

    public LDValue get(String str) {
        LDValue lDValue = this.map.get(str);
        return lDValue == null ? ofNull() : lDValue;
    }

    /* access modifiers changed from: package-private */
    public void write(JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginObject();
        for (Map.Entry next : this.map.entrySet()) {
            jsonWriter.name((String) next.getKey());
            ((LDValue) next.getValue()).write(jsonWriter);
        }
        jsonWriter.endObject();
    }
}
