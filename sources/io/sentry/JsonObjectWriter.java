package io.sentry;

import io.sentry.vendor.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;

public final class JsonObjectWriter implements ObjectWriter {
    private final JsonObjectSerializer jsonObjectSerializer;
    private final JsonWriter jsonWriter;

    public JsonObjectWriter(Writer writer, int i) {
        this.jsonWriter = new JsonWriter(writer);
        this.jsonObjectSerializer = new JsonObjectSerializer(i);
    }

    public JsonObjectWriter beginArray() throws IOException {
        this.jsonWriter.beginArray();
        return this;
    }

    public JsonObjectWriter endArray() throws IOException {
        this.jsonWriter.endArray();
        return this;
    }

    public JsonObjectWriter beginObject() throws IOException {
        this.jsonWriter.beginObject();
        return this;
    }

    public JsonObjectWriter endObject() throws IOException {
        this.jsonWriter.endObject();
        return this;
    }

    public JsonObjectWriter name(String str) throws IOException {
        this.jsonWriter.name(str);
        return this;
    }

    public JsonObjectWriter value(String str) throws IOException {
        this.jsonWriter.value(str);
        return this;
    }

    public JsonObjectWriter nullValue() throws IOException {
        this.jsonWriter.nullValue();
        return this;
    }

    public JsonObjectWriter value(boolean z) throws IOException {
        this.jsonWriter.value(z);
        return this;
    }

    public JsonObjectWriter value(Boolean bool) throws IOException {
        this.jsonWriter.value(bool);
        return this;
    }

    public JsonObjectWriter value(double d) throws IOException {
        this.jsonWriter.value(d);
        return this;
    }

    public JsonObjectWriter value(long j) throws IOException {
        this.jsonWriter.value(j);
        return this;
    }

    public JsonObjectWriter value(Number number) throws IOException {
        this.jsonWriter.value(number);
        return this;
    }

    public JsonObjectWriter value(ILogger iLogger, Object obj) throws IOException {
        this.jsonObjectSerializer.serialize(this, iLogger, obj);
        return this;
    }

    public void setIndent(String str) {
        this.jsonWriter.setIndent(str);
    }
}
