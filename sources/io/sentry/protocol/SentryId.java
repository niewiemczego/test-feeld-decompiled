package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonObjectReader;
import io.sentry.JsonSerializable;
import io.sentry.ObjectWriter;
import io.sentry.util.StringUtils;
import java.io.IOException;
import java.util.UUID;

public final class SentryId implements JsonSerializable {
    public static final SentryId EMPTY_ID = new SentryId(new UUID(0, 0));
    private final UUID uuid;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SentryId() {
        this((UUID) null);
        UUID uuid2 = null;
    }

    public SentryId(UUID uuid2) {
        this.uuid = uuid2 == null ? UUID.randomUUID() : uuid2;
    }

    public SentryId(String str) {
        this.uuid = fromStringSentryId(StringUtils.normalizeUUID(str));
    }

    public String toString() {
        return StringUtils.normalizeUUID(this.uuid.toString()).replace("-", "");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.uuid.compareTo(((SentryId) obj).uuid) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.uuid.hashCode();
    }

    private UUID fromStringSentryId(String str) {
        if (str.length() == 32) {
            str = new StringBuilder(str).insert(8, "-").insert(13, "-").insert(18, "-").insert(23, "-").toString();
        }
        if (str.length() == 36) {
            return UUID.fromString(str);
        }
        throw new IllegalArgumentException("String representation of SentryId has either 32 (UUID no dashes) or 36 characters long (completed UUID). Received: " + str);
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.value(toString());
    }

    public static final class Deserializer implements JsonDeserializer<SentryId> {
        public SentryId deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            return new SentryId(jsonObjectReader.nextString());
        }
    }
}
