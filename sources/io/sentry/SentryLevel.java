package io.sentry;

import java.io.IOException;
import java.util.Locale;

public enum SentryLevel implements JsonSerializable {
    DEBUG,
    INFO,
    WARNING,
    ERROR,
    FATAL;

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.value(name().toLowerCase(Locale.ROOT));
    }

    static final class Deserializer implements JsonDeserializer<SentryLevel> {
        Deserializer() {
        }

        public SentryLevel deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            return SentryLevel.valueOf(jsonObjectReader.nextString().toUpperCase(Locale.ROOT));
        }
    }
}
