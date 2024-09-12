package io.sentry;

public interface JsonDeserializer<T> {
    T deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception;
}
