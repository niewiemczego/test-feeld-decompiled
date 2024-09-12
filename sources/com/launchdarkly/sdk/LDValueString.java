package com.launchdarkly.sdk;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

@JsonAdapter(LDValueTypeAdapter.class)
final class LDValueString extends LDValue {
    private static final LDValueString EMPTY = new LDValueString("");
    private final String value;

    public boolean isString() {
        return true;
    }

    static LDValueString fromString(String str) {
        return str.isEmpty() ? EMPTY : new LDValueString(str);
    }

    private LDValueString(String str) {
        this.value = str;
    }

    public LDValueType getType() {
        return LDValueType.STRING;
    }

    public String stringValue() {
        return this.value;
    }

    /* access modifiers changed from: package-private */
    public void write(JsonWriter jsonWriter) throws IOException {
        jsonWriter.value(this.value);
    }
}
