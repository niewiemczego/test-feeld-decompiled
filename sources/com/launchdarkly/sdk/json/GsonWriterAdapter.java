package com.launchdarkly.sdk.json;

import com.google.gson.stream.JsonWriter;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.Writer;

abstract class GsonWriterAdapter extends JsonWriter {
    /* access modifiers changed from: protected */
    public abstract void beginArrayInternal() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void beginObjectInternal() throws IOException;

    public void close() throws IOException {
    }

    /* access modifiers changed from: protected */
    public abstract void endArrayInternal() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void endObjectInternal() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void jsonValueInternal(String str) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void nameInternal(String str) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void valueInternalBool(boolean z) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void valueInternalDouble(double d) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void valueInternalLong(long j) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void valueInternalNull() throws IOException;

    /* access modifiers changed from: protected */
    public abstract void valueInternalString(String str) throws IOException;

    GsonWriterAdapter() {
        super(makeStubWriter());
    }

    private static final Writer makeStubWriter() {
        return new CharArrayWriter(0);
    }

    public JsonWriter beginArray() throws IOException {
        beginArrayInternal();
        return this;
    }

    public JsonWriter beginObject() throws IOException {
        beginObjectInternal();
        return this;
    }

    public JsonWriter endArray() throws IOException {
        endArrayInternal();
        return this;
    }

    public JsonWriter endObject() throws IOException {
        endObjectInternal();
        return this;
    }

    public JsonWriter jsonValue(String str) throws IOException {
        jsonValueInternal(str);
        return this;
    }

    public JsonWriter name(String str) throws IOException {
        nameInternal(str);
        return this;
    }

    public JsonWriter nullValue() throws IOException {
        valueInternalNull();
        return this;
    }

    public JsonWriter value(boolean z) throws IOException {
        valueInternalBool(z);
        return this;
    }

    public JsonWriter value(Boolean bool) throws IOException {
        if (bool == null) {
            valueInternalNull();
        } else {
            valueInternalBool(bool.booleanValue());
        }
        return this;
    }

    public JsonWriter value(double d) throws IOException {
        long j = (long) d;
        if (d == ((double) j)) {
            valueInternalLong(j);
        } else {
            valueInternalDouble(d);
        }
        return this;
    }

    public JsonWriter value(long j) throws IOException {
        valueInternalLong(j);
        return this;
    }

    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            valueInternalNull();
        } else {
            value(number.doubleValue());
        }
        return this;
    }

    public JsonWriter value(String str) throws IOException {
        valueInternalString(str);
        return this;
    }
}
