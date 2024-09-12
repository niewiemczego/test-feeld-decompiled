package io.sentry;

import com.google.android.gms.common.Scopes;
import io.sentry.cache.EnvelopeCache;
import io.sentry.clientreport.ClientReport;
import io.sentry.protocol.SentryTransaction;
import java.io.IOException;
import java.util.Locale;

public enum SentryItemType implements JsonSerializable {
    Session(EnvelopeCache.PREFIX_CURRENT_SESSION_FILE),
    Event("event"),
    UserFeedback("user_report"),
    Attachment("attachment"),
    Transaction("transaction"),
    Profile(Scopes.PROFILE),
    ClientReport("client_report"),
    ReplayEvent("replay_event"),
    ReplayRecording("replay_recording"),
    CheckIn("check_in"),
    Statsd("statsd"),
    Unknown("__unknown__");
    
    private final String itemType;

    public static SentryItemType resolve(Object obj) {
        if (obj instanceof SentryEvent) {
            return Event;
        }
        if (obj instanceof SentryTransaction) {
            return Transaction;
        }
        if (obj instanceof Session) {
            return Session;
        }
        if (obj instanceof ClientReport) {
            return ClientReport;
        }
        return Attachment;
    }

    private SentryItemType(String str) {
        this.itemType = str;
    }

    public String getItemType() {
        return this.itemType;
    }

    public static SentryItemType valueOfLabel(String str) {
        for (SentryItemType sentryItemType : values()) {
            if (sentryItemType.itemType.equals(str)) {
                return sentryItemType;
            }
        }
        return Unknown;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.value(this.itemType);
    }

    static final class Deserializer implements JsonDeserializer<SentryItemType> {
        Deserializer() {
        }

        public SentryItemType deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            return SentryItemType.valueOfLabel(jsonObjectReader.nextString().toLowerCase(Locale.ROOT));
        }
    }
}
