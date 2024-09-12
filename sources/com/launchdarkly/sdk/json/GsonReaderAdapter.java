package com.launchdarkly.sdk.json;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;

abstract class GsonReaderAdapter extends JsonReader {
    private static final JsonToken[] TOKEN_VALUES = JsonToken.values();

    public abstract void beginArray() throws IOException;

    public abstract void beginObject() throws IOException;

    public abstract void endArray() throws IOException;

    public abstract void endObject() throws IOException;

    public abstract boolean hasNext() throws IOException;

    public abstract boolean nextBoolean() throws IOException;

    public abstract double nextDouble() throws IOException;

    public abstract int nextInt() throws IOException;

    public abstract long nextLong() throws IOException;

    public abstract String nextName() throws IOException;

    public abstract void nextNull() throws IOException;

    public abstract String nextString() throws IOException;

    /* access modifiers changed from: protected */
    public abstract int peekInternal() throws IOException;

    public abstract void skipValue() throws IOException;

    GsonReaderAdapter() {
        super(makeStubReader());
    }

    private static final Reader makeStubReader() {
        return new CharArrayReader(new char[0]);
    }

    public JsonToken peek() throws IOException {
        return TOKEN_VALUES[peekInternal()];
    }
}
