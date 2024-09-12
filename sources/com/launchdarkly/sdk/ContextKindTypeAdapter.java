package com.launchdarkly.sdk;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class ContextKindTypeAdapter extends TypeAdapter<ContextKind> {
    ContextKindTypeAdapter() {
    }

    public ContextKind read(JsonReader jsonReader) throws IOException {
        return ContextKind.of(Helpers.readNonNullableString(jsonReader));
    }

    public void write(JsonWriter jsonWriter, ContextKind contextKind) throws IOException {
        jsonWriter.value(contextKind.toString());
    }
}
