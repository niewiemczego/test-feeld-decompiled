package io.sentry;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;

final class NoOpSerializer implements ISerializer {
    private static final NoOpSerializer instance = new NoOpSerializer();

    public <T> T deserialize(Reader reader, Class<T> cls) {
        return null;
    }

    public <T, R> T deserializeCollection(Reader reader, Class<T> cls, JsonDeserializer<R> jsonDeserializer) {
        return null;
    }

    public SentryEnvelope deserializeEnvelope(InputStream inputStream) {
        return null;
    }

    public String serialize(Map<String, Object> map) throws Exception {
        return "";
    }

    public void serialize(SentryEnvelope sentryEnvelope, OutputStream outputStream) throws Exception {
    }

    public <T> void serialize(T t, Writer writer) throws IOException {
    }

    public static NoOpSerializer getInstance() {
        return instance;
    }

    private NoOpSerializer() {
    }
}
