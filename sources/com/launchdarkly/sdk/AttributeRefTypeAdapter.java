package com.launchdarkly.sdk;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

final class AttributeRefTypeAdapter extends TypeAdapter<AttributeRef> {
    AttributeRefTypeAdapter() {
    }

    public AttributeRef read(JsonReader jsonReader) throws IOException {
        return AttributeRef.fromPath(Helpers.readNonNullableString(jsonReader));
    }

    public void write(JsonWriter jsonWriter, AttributeRef attributeRef) throws IOException {
        jsonWriter.value(attributeRef.toString());
    }
}
