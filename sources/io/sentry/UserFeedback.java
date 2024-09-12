package io.sentry;

import io.sentry.protocol.SentryId;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class UserFeedback implements JsonUnknown, JsonSerializable {
    private String comments;
    private String email;
    private final SentryId eventId;
    private String name;
    private Map<String, Object> unknown;

    public static final class JsonKeys {
        public static final String COMMENTS = "comments";
        public static final String EMAIL = "email";
        public static final String EVENT_ID = "event_id";
        public static final String NAME = "name";
    }

    public UserFeedback(SentryId sentryId) {
        this(sentryId, (String) null, (String) null, (String) null);
    }

    public UserFeedback(SentryId sentryId, String str, String str2, String str3) {
        this.eventId = sentryId;
        this.name = str;
        this.email = str2;
        this.comments = str3;
    }

    public SentryId getEventId() {
        return this.eventId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String str) {
        this.comments = str;
    }

    public String toString() {
        return "UserFeedback{eventId=" + this.eventId + ", name='" + this.name + '\'' + ", email='" + this.email + '\'' + ", comments='" + this.comments + '\'' + '}';
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        objectWriter.name("event_id");
        this.eventId.serialize(objectWriter, iLogger);
        if (this.name != null) {
            objectWriter.name("name").value(this.name);
        }
        if (this.email != null) {
            objectWriter.name("email").value(this.email);
        }
        if (this.comments != null) {
            objectWriter.name(JsonKeys.COMMENTS).value(this.comments);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String next : map.keySet()) {
                objectWriter.name(next).value(iLogger, this.unknown.get(next));
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<UserFeedback> {
        public UserFeedback deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            jsonObjectReader.beginObject();
            SentryId sentryId = null;
            String str = null;
            String str2 = null;
            String str3 = null;
            HashMap hashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case -602415628:
                        if (nextName.equals(JsonKeys.COMMENTS)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3373707:
                        if (nextName.equals("name")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 96619420:
                        if (nextName.equals("email")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 278118624:
                        if (nextName.equals("event_id")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        str3 = jsonObjectReader.nextStringOrNull();
                        break;
                    case 1:
                        str = jsonObjectReader.nextStringOrNull();
                        break;
                    case 2:
                        str2 = jsonObjectReader.nextStringOrNull();
                        break;
                    case 3:
                        sentryId = new SentryId.Deserializer().deserialize(jsonObjectReader, iLogger);
                        break;
                    default:
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        jsonObjectReader.nextUnknown(iLogger, hashMap, nextName);
                        break;
                }
            }
            jsonObjectReader.endObject();
            if (sentryId != null) {
                UserFeedback userFeedback = new UserFeedback(sentryId, str, str2, str3);
                userFeedback.setUnknown(hashMap);
                return userFeedback;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"event_id\"");
            iLogger.log(SentryLevel.ERROR, "Missing required field \"event_id\"", (Throwable) illegalStateException);
            throw illegalStateException;
        }
    }
}
