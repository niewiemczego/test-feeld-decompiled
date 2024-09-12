package com.launchdarkly.sdk;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

@JsonAdapter(LDValueTypeAdapter.class)
final class LDValueNull extends LDValue {
    static final LDValueNull INSTANCE = new LDValueNull();

    public boolean isNull() {
        return true;
    }

    public String toJsonString() {
        return "null";
    }

    LDValueNull() {
    }

    public LDValueType getType() {
        return LDValueType.NULL;
    }

    /* access modifiers changed from: package-private */
    public void write(JsonWriter jsonWriter) throws IOException {
        jsonWriter.nullValue();
    }
}
