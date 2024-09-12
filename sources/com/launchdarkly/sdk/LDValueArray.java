package com.launchdarkly.sdk;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@JsonAdapter(LDValueTypeAdapter.class)
final class LDValueArray extends LDValue {
    private static final LDValueArray EMPTY = new LDValueArray(Collections.emptyList());
    private final List<LDValue> list;

    static LDValueArray fromList(List<LDValue> list2) {
        return (list2 == null || list2.isEmpty()) ? EMPTY : new LDValueArray(list2);
    }

    private LDValueArray(List<LDValue> list2) {
        this.list = Collections.unmodifiableList(list2);
    }

    public LDValueType getType() {
        return LDValueType.ARRAY;
    }

    public int size() {
        return this.list.size();
    }

    public Iterable<LDValue> values() {
        return this.list;
    }

    public LDValue get(int i) {
        if (i < 0 || i >= this.list.size()) {
            return ofNull();
        }
        return this.list.get(i);
    }

    /* access modifiers changed from: package-private */
    public void write(JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginArray();
        for (LDValue write : this.list) {
            write.write(jsonWriter);
        }
        jsonWriter.endArray();
    }
}
