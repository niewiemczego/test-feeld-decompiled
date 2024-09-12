package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonObjectReader;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectWriter;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.protocol.Geo;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class User implements JsonUnknown, JsonSerializable {
    /* access modifiers changed from: private */
    public Map<String, String> data;
    /* access modifiers changed from: private */
    public String email;
    /* access modifiers changed from: private */
    public Geo geo;
    /* access modifiers changed from: private */
    public String id;
    /* access modifiers changed from: private */
    public String ipAddress;
    /* access modifiers changed from: private */
    public String name;
    /* access modifiers changed from: private */
    public String segment;
    private Map<String, Object> unknown;
    /* access modifiers changed from: private */
    public String username;

    public static final class JsonKeys {
        public static final String DATA = "data";
        public static final String EMAIL = "email";
        public static final String GEO = "geo";
        public static final String ID = "id";
        public static final String IP_ADDRESS = "ip_address";
        public static final String NAME = "name";
        public static final String OTHER = "other";
        public static final String SEGMENT = "segment";
        public static final String USERNAME = "username";
    }

    public User() {
    }

    public User(User user) {
        this.email = user.email;
        this.username = user.username;
        this.id = user.id;
        this.ipAddress = user.ipAddress;
        this.segment = user.segment;
        this.name = user.name;
        this.geo = user.geo;
        this.data = CollectionUtils.newConcurrentHashMap(user.data);
        this.unknown = CollectionUtils.newConcurrentHashMap(user.unknown);
    }

    public static User fromMap(Map<String, Object> map, SentryOptions sentryOptions) {
        Map<String, String> map2;
        User user = new User();
        ConcurrentHashMap concurrentHashMap = null;
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            String str = (String) next.getKey();
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -265713450:
                    if (str.equals("username")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3355:
                    if (str.equals("id")) {
                        c = 1;
                        break;
                    }
                    break;
                case 102225:
                    if (str.equals(JsonKeys.GEO)) {
                        c = 2;
                        break;
                    }
                    break;
                case 3076010:
                    if (str.equals("data")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3373707:
                    if (str.equals("name")) {
                        c = 4;
                        break;
                    }
                    break;
                case 96619420:
                    if (str.equals("email")) {
                        c = 5;
                        break;
                    }
                    break;
                case 106069776:
                    if (str.equals("other")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1480014044:
                    if (str.equals("ip_address")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1973722931:
                    if (str.equals("segment")) {
                        c = 8;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    user.username = value instanceof String ? (String) value : null;
                    break;
                case 1:
                    user.id = value instanceof String ? (String) value : null;
                    break;
                case 2:
                    Map map3 = value instanceof Map ? (Map) value : null;
                    if (map3 == null) {
                        break;
                    } else {
                        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                        for (Map.Entry entry : map3.entrySet()) {
                            if (!(entry.getKey() instanceof String) || entry.getValue() == null) {
                                sentryOptions.getLogger().log(SentryLevel.WARNING, "Invalid key type in gep map.", new Object[0]);
                            } else {
                                concurrentHashMap2.put((String) entry.getKey(), entry.getValue());
                            }
                        }
                        user.geo = Geo.fromMap(concurrentHashMap2);
                        break;
                    }
                case 3:
                    Map map4 = value instanceof Map ? (Map) value : null;
                    if (map4 == null) {
                        break;
                    } else {
                        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                        for (Map.Entry entry2 : map4.entrySet()) {
                            if (!(entry2.getKey() instanceof String) || entry2.getValue() == null) {
                                sentryOptions.getLogger().log(SentryLevel.WARNING, "Invalid key or null value in data map.", new Object[0]);
                            } else {
                                concurrentHashMap3.put((String) entry2.getKey(), entry2.getValue().toString());
                            }
                        }
                        user.data = concurrentHashMap3;
                        break;
                    }
                    break;
                case 4:
                    user.name = value instanceof String ? (String) value : null;
                    break;
                case 5:
                    user.email = value instanceof String ? (String) value : null;
                    break;
                case 6:
                    Map map5 = value instanceof Map ? (Map) value : null;
                    if (map5 != null && ((map2 = user.data) == null || map2.isEmpty())) {
                        ConcurrentHashMap concurrentHashMap4 = new ConcurrentHashMap();
                        for (Map.Entry entry3 : map5.entrySet()) {
                            if (!(entry3.getKey() instanceof String) || entry3.getValue() == null) {
                                sentryOptions.getLogger().log(SentryLevel.WARNING, "Invalid key or null value in other map.", new Object[0]);
                            } else {
                                concurrentHashMap4.put((String) entry3.getKey(), entry3.getValue().toString());
                            }
                        }
                        user.data = concurrentHashMap4;
                        break;
                    }
                    break;
                case 7:
                    user.ipAddress = value instanceof String ? (String) value : null;
                    break;
                case 8:
                    user.segment = value instanceof String ? (String) value : null;
                    break;
                default:
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap();
                    }
                    concurrentHashMap.put((String) next.getKey(), next.getValue());
                    break;
            }
        }
        user.unknown = concurrentHashMap;
        return user;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String getSegment() {
        return this.segment;
    }

    public void setSegment(String str) {
        this.segment = str;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setIpAddress(String str) {
        this.ipAddress = str;
    }

    @Deprecated
    public Map<String, String> getOthers() {
        return getData();
    }

    @Deprecated
    public void setOthers(Map<String, String> map) {
        setData(map);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public Geo getGeo() {
        return this.geo;
    }

    public void setGeo(Geo geo2) {
        this.geo = geo2;
    }

    public Map<String, String> getData() {
        return this.data;
    }

    public void setData(Map<String, String> map) {
        this.data = CollectionUtils.newConcurrentHashMap(map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        if (!Objects.equals(this.email, user.email) || !Objects.equals(this.id, user.id) || !Objects.equals(this.username, user.username) || !Objects.equals(this.segment, user.segment) || !Objects.equals(this.ipAddress, user.ipAddress)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(this.email, this.id, this.username, this.segment, this.ipAddress);
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.email != null) {
            objectWriter.name("email").value(this.email);
        }
        if (this.id != null) {
            objectWriter.name("id").value(this.id);
        }
        if (this.username != null) {
            objectWriter.name("username").value(this.username);
        }
        if (this.segment != null) {
            objectWriter.name("segment").value(this.segment);
        }
        if (this.ipAddress != null) {
            objectWriter.name("ip_address").value(this.ipAddress);
        }
        if (this.name != null) {
            objectWriter.name("name").value(this.name);
        }
        if (this.geo != null) {
            objectWriter.name(JsonKeys.GEO);
            this.geo.serialize(objectWriter, iLogger);
        }
        if (this.data != null) {
            objectWriter.name("data").value(iLogger, this.data);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String next : map.keySet()) {
                Object obj = this.unknown.get(next);
                objectWriter.name(next);
                objectWriter.value(iLogger, obj);
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<User> {
        public User deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            jsonObjectReader.beginObject();
            User user = new User();
            ConcurrentHashMap concurrentHashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case -265713450:
                        if (nextName.equals("username")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3355:
                        if (nextName.equals("id")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 102225:
                        if (nextName.equals(JsonKeys.GEO)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 3076010:
                        if (nextName.equals("data")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 3373707:
                        if (nextName.equals("name")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 96619420:
                        if (nextName.equals("email")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 106069776:
                        if (nextName.equals("other")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 1480014044:
                        if (nextName.equals("ip_address")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 1973722931:
                        if (nextName.equals("segment")) {
                            c = 8;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        String unused = user.username = jsonObjectReader.nextStringOrNull();
                        break;
                    case 1:
                        String unused2 = user.id = jsonObjectReader.nextStringOrNull();
                        break;
                    case 2:
                        Geo unused3 = user.geo = new Geo.Deserializer().deserialize(jsonObjectReader, iLogger);
                        break;
                    case 3:
                        Map unused4 = user.data = CollectionUtils.newConcurrentHashMap((Map) jsonObjectReader.nextObjectOrNull());
                        break;
                    case 4:
                        String unused5 = user.name = jsonObjectReader.nextStringOrNull();
                        break;
                    case 5:
                        String unused6 = user.email = jsonObjectReader.nextStringOrNull();
                        break;
                    case 6:
                        if (user.data != null && !user.data.isEmpty()) {
                            break;
                        } else {
                            Map unused7 = user.data = CollectionUtils.newConcurrentHashMap((Map) jsonObjectReader.nextObjectOrNull());
                            break;
                        }
                    case 7:
                        String unused8 = user.ipAddress = jsonObjectReader.nextStringOrNull();
                        break;
                    case 8:
                        String unused9 = user.segment = jsonObjectReader.nextStringOrNull();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        jsonObjectReader.nextUnknown(iLogger, concurrentHashMap, nextName);
                        break;
                }
            }
            user.setUnknown(concurrentHashMap);
            jsonObjectReader.endObject();
            return user;
        }
    }
}
