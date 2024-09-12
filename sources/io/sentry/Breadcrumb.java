package io.sentry;

import androidx.core.app.NotificationCompat;
import app.notifee.core.event.LogEvent;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.messaging.Constants;
import io.sentry.SentryLevel;
import io.sentry.protocol.Response;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.util.UrlUtils;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Breadcrumb implements JsonUnknown, JsonSerializable {
    /* access modifiers changed from: private */
    public String category;
    /* access modifiers changed from: private */
    public Map<String, Object> data;
    /* access modifiers changed from: private */
    public SentryLevel level;
    /* access modifiers changed from: private */
    public String message;
    private final Date timestamp;
    /* access modifiers changed from: private */
    public String type;
    private Map<String, Object> unknown;

    public static final class JsonKeys {
        public static final String CATEGORY = "category";
        public static final String DATA = "data";
        public static final String LEVEL = "level";
        public static final String MESSAGE = "message";
        public static final String TIMESTAMP = "timestamp";
        public static final String TYPE = "type";
    }

    public Breadcrumb(Date date) {
        this.data = new ConcurrentHashMap();
        this.timestamp = date;
    }

    Breadcrumb(Breadcrumb breadcrumb) {
        this.data = new ConcurrentHashMap();
        this.timestamp = breadcrumb.timestamp;
        this.message = breadcrumb.message;
        this.type = breadcrumb.type;
        this.category = breadcrumb.category;
        Map<String, Object> newConcurrentHashMap = CollectionUtils.newConcurrentHashMap(breadcrumb.data);
        if (newConcurrentHashMap != null) {
            this.data = newConcurrentHashMap;
        }
        this.unknown = CollectionUtils.newConcurrentHashMap(breadcrumb.unknown);
        this.level = breadcrumb.level;
    }

    public static Breadcrumb fromMap(Map<String, Object> map, SentryOptions sentryOptions) {
        Date dateOrNull;
        Date currentDateTime = DateUtils.getCurrentDateTime();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        String str = null;
        String str2 = null;
        String str3 = null;
        SentryLevel sentryLevel = null;
        ConcurrentHashMap concurrentHashMap2 = null;
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            String str4 = (String) next.getKey();
            str4.hashCode();
            char c = 65535;
            switch (str4.hashCode()) {
                case 3076010:
                    if (str4.equals("data")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3575610:
                    if (str4.equals("type")) {
                        c = 1;
                        break;
                    }
                    break;
                case 50511102:
                    if (str4.equals("category")) {
                        c = 2;
                        break;
                    }
                    break;
                case 55126294:
                    if (str4.equals("timestamp")) {
                        c = 3;
                        break;
                    }
                    break;
                case 102865796:
                    if (str4.equals("level")) {
                        c = 4;
                        break;
                    }
                    break;
                case 954925063:
                    if (str4.equals("message")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    Map map2 = value instanceof Map ? (Map) value : null;
                    if (map2 == null) {
                        break;
                    } else {
                        for (Map.Entry entry : map2.entrySet()) {
                            if (!(entry.getKey() instanceof String) || entry.getValue() == null) {
                                sentryOptions.getLogger().log(SentryLevel.WARNING, "Invalid key or null value in data map.", new Object[0]);
                            } else {
                                concurrentHashMap.put((String) entry.getKey(), entry.getValue());
                            }
                        }
                        break;
                    }
                    break;
                case 1:
                    if (!(value instanceof String)) {
                        str2 = null;
                        break;
                    } else {
                        str2 = (String) value;
                        break;
                    }
                case 2:
                    if (!(value instanceof String)) {
                        str3 = null;
                        break;
                    } else {
                        str3 = (String) value;
                        break;
                    }
                case 3:
                    if ((value instanceof String) && (dateOrNull = JsonObjectReader.dateOrNull((String) value, sentryOptions.getLogger())) != null) {
                        currentDateTime = dateOrNull;
                        break;
                    }
                case 4:
                    String str5 = value instanceof String ? (String) value : null;
                    if (str5 == null) {
                        break;
                    } else {
                        try {
                            sentryLevel = SentryLevel.valueOf(str5.toUpperCase(Locale.ROOT));
                            break;
                        } catch (Exception unused) {
                            break;
                        }
                    }
                case 5:
                    if (!(value instanceof String)) {
                        str = null;
                        break;
                    } else {
                        str = (String) value;
                        break;
                    }
                default:
                    if (concurrentHashMap2 == null) {
                        concurrentHashMap2 = new ConcurrentHashMap();
                    }
                    concurrentHashMap2.put((String) next.getKey(), next.getValue());
                    break;
            }
        }
        Breadcrumb breadcrumb = new Breadcrumb(currentDateTime);
        breadcrumb.message = str;
        breadcrumb.type = str2;
        breadcrumb.data = concurrentHashMap;
        breadcrumb.category = str3;
        breadcrumb.level = sentryLevel;
        breadcrumb.setUnknown(concurrentHashMap2);
        return breadcrumb;
    }

    public static Breadcrumb http(String str, String str2) {
        Breadcrumb breadcrumb = new Breadcrumb();
        UrlUtils.UrlDetails parse = UrlUtils.parse(str);
        breadcrumb.setType("http");
        breadcrumb.setCategory("http");
        if (parse.getUrl() != null) {
            breadcrumb.setData("url", parse.getUrl());
        }
        breadcrumb.setData("method", str2.toUpperCase(Locale.ROOT));
        if (parse.getQuery() != null) {
            breadcrumb.setData(SpanDataConvention.HTTP_QUERY_KEY, parse.getQuery());
        }
        if (parse.getFragment() != null) {
            breadcrumb.setData(SpanDataConvention.HTTP_FRAGMENT_KEY, parse.getFragment());
        }
        return breadcrumb;
    }

    public static Breadcrumb http(String str, String str2, Integer num) {
        Breadcrumb http = http(str, str2);
        if (num != null) {
            http.setData(Response.JsonKeys.STATUS_CODE, num);
        }
        return http;
    }

    public static Breadcrumb graphqlOperation(String str, String str2, String str3) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType("graphql");
        if (str != null) {
            breadcrumb.setData("operation_name", str);
        }
        if (str2 != null) {
            breadcrumb.setData("operation_type", str2);
            breadcrumb.setCategory(str2);
        } else {
            breadcrumb.setCategory("graphql.operation");
        }
        if (str3 != null) {
            breadcrumb.setData("operation_id", str3);
        }
        return breadcrumb;
    }

    public static Breadcrumb graphqlDataFetcher(String str, String str2, String str3, String str4) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType("graphql");
        breadcrumb.setCategory("graphql.fetcher");
        if (str != null) {
            breadcrumb.setData(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, str);
        }
        if (str2 != null) {
            breadcrumb.setData("field", str2);
        }
        if (str3 != null) {
            breadcrumb.setData("type", str3);
        }
        if (str4 != null) {
            breadcrumb.setData("object_type", str4);
        }
        return breadcrumb;
    }

    public static Breadcrumb graphqlDataLoader(Iterable<?> iterable, Class<?> cls, Class<?> cls2, String str) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType("graphql");
        breadcrumb.setCategory("graphql.data_loader");
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            arrayList.add(obj.toString());
        }
        breadcrumb.setData("keys", arrayList);
        if (cls != null) {
            breadcrumb.setData("key_type", cls.getName());
        }
        if (cls2 != null) {
            breadcrumb.setData("value_type", cls2.getName());
        }
        if (str != null) {
            breadcrumb.setData("name", str);
        }
        return breadcrumb;
    }

    public static Breadcrumb navigation(String str, String str2) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setCategory(NotificationCompat.CATEGORY_NAVIGATION);
        breadcrumb.setType(NotificationCompat.CATEGORY_NAVIGATION);
        breadcrumb.setData(Constants.MessagePayloadKeys.FROM, str);
        breadcrumb.setData("to", str2);
        return breadcrumb;
    }

    public static Breadcrumb transaction(String str) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType(com.facebook.hermes.intl.Constants.COLLATION_DEFAULT);
        breadcrumb.setCategory("sentry.transaction");
        breadcrumb.setMessage(str);
        return breadcrumb;
    }

    public static Breadcrumb debug(String str) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType(LogEvent.LEVEL_DEBUG);
        breadcrumb.setMessage(str);
        breadcrumb.setLevel(SentryLevel.DEBUG);
        return breadcrumb;
    }

    public static Breadcrumb error(String str) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType("error");
        breadcrumb.setMessage(str);
        breadcrumb.setLevel(SentryLevel.ERROR);
        return breadcrumb;
    }

    public static Breadcrumb info(String str) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType(LogEvent.LEVEL_INFO);
        breadcrumb.setMessage(str);
        breadcrumb.setLevel(SentryLevel.INFO);
        return breadcrumb;
    }

    public static Breadcrumb query(String str) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType(SearchIntents.EXTRA_QUERY);
        breadcrumb.setMessage(str);
        return breadcrumb;
    }

    public static Breadcrumb ui(String str, String str2) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType(com.facebook.hermes.intl.Constants.COLLATION_DEFAULT);
        breadcrumb.setCategory("ui." + str);
        breadcrumb.setMessage(str2);
        return breadcrumb;
    }

    public static Breadcrumb user(String str, String str2) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType("user");
        breadcrumb.setCategory(str);
        breadcrumb.setMessage(str2);
        return breadcrumb;
    }

    public static Breadcrumb userInteraction(String str, String str2, String str3) {
        return userInteraction(str, str2, str3, Collections.emptyMap());
    }

    public static Breadcrumb userInteraction(String str, String str2, String str3, String str4, Map<String, Object> map) {
        Breadcrumb breadcrumb = new Breadcrumb();
        breadcrumb.setType("user");
        breadcrumb.setCategory("ui." + str);
        if (str2 != null) {
            breadcrumb.setData("view.id", str2);
        }
        if (str3 != null) {
            breadcrumb.setData("view.class", str3);
        }
        if (str4 != null) {
            breadcrumb.setData("view.tag", str4);
        }
        for (Map.Entry next : map.entrySet()) {
            breadcrumb.getData().put((String) next.getKey(), next.getValue());
        }
        breadcrumb.setLevel(SentryLevel.INFO);
        return breadcrumb;
    }

    public static Breadcrumb userInteraction(String str, String str2, String str3, Map<String, Object> map) {
        return userInteraction(str, str2, str3, (String) null, map);
    }

    public Breadcrumb() {
        this(DateUtils.getCurrentDateTime());
    }

    public Breadcrumb(String str) {
        this();
        this.message = str;
    }

    public Date getTimestamp() {
        return (Date) this.timestamp.clone();
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public Object getData(String str) {
        return this.data.get(str);
    }

    public void setData(String str, Object obj) {
        this.data.put(str, obj);
    }

    public void removeData(String str) {
        this.data.remove(str);
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public SentryLevel getLevel() {
        return this.level;
    }

    public void setLevel(SentryLevel sentryLevel) {
        this.level = sentryLevel;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Breadcrumb breadcrumb = (Breadcrumb) obj;
        if (this.timestamp.getTime() != breadcrumb.timestamp.getTime() || !Objects.equals(this.message, breadcrumb.message) || !Objects.equals(this.type, breadcrumb.type) || !Objects.equals(this.category, breadcrumb.category) || this.level != breadcrumb.level) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(this.timestamp, this.message, this.type, this.category, this.level);
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        objectWriter.name("timestamp").value(iLogger, this.timestamp);
        if (this.message != null) {
            objectWriter.name("message").value(this.message);
        }
        if (this.type != null) {
            objectWriter.name("type").value(this.type);
        }
        objectWriter.name("data").value(iLogger, this.data);
        if (this.category != null) {
            objectWriter.name("category").value(this.category);
        }
        if (this.level != null) {
            objectWriter.name("level").value(iLogger, this.level);
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

    public static final class Deserializer implements JsonDeserializer<Breadcrumb> {
        public Breadcrumb deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            jsonObjectReader.beginObject();
            Date currentDateTime = DateUtils.getCurrentDateTime();
            Map concurrentHashMap = new ConcurrentHashMap();
            String str = null;
            String str2 = null;
            String str3 = null;
            SentryLevel sentryLevel = null;
            ConcurrentHashMap concurrentHashMap2 = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case 3076010:
                        if (nextName.equals("data")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3575610:
                        if (nextName.equals("type")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 50511102:
                        if (nextName.equals("category")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 55126294:
                        if (nextName.equals("timestamp")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 102865796:
                        if (nextName.equals("level")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 954925063:
                        if (nextName.equals("message")) {
                            c = 5;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        Map newConcurrentHashMap = CollectionUtils.newConcurrentHashMap((Map) jsonObjectReader.nextObjectOrNull());
                        if (newConcurrentHashMap == null) {
                            break;
                        } else {
                            concurrentHashMap = newConcurrentHashMap;
                            break;
                        }
                    case 1:
                        str2 = jsonObjectReader.nextStringOrNull();
                        break;
                    case 2:
                        str3 = jsonObjectReader.nextStringOrNull();
                        break;
                    case 3:
                        Date nextDateOrNull = jsonObjectReader.nextDateOrNull(iLogger);
                        if (nextDateOrNull == null) {
                            break;
                        } else {
                            currentDateTime = nextDateOrNull;
                            break;
                        }
                    case 4:
                        try {
                            sentryLevel = new SentryLevel.Deserializer().deserialize(jsonObjectReader, iLogger);
                            break;
                        } catch (Exception e) {
                            iLogger.log(SentryLevel.ERROR, e, "Error when deserializing SentryLevel", new Object[0]);
                            break;
                        }
                    case 5:
                        str = jsonObjectReader.nextStringOrNull();
                        break;
                    default:
                        if (concurrentHashMap2 == null) {
                            concurrentHashMap2 = new ConcurrentHashMap();
                        }
                        jsonObjectReader.nextUnknown(iLogger, concurrentHashMap2, nextName);
                        break;
                }
            }
            Breadcrumb breadcrumb = new Breadcrumb(currentDateTime);
            String unused = breadcrumb.message = str;
            String unused2 = breadcrumb.type = str2;
            Map unused3 = breadcrumb.data = concurrentHashMap;
            String unused4 = breadcrumb.category = str3;
            SentryLevel unused5 = breadcrumb.level = sentryLevel;
            breadcrumb.setUnknown(concurrentHashMap2);
            jsonObjectReader.endObject();
            return breadcrumb;
        }
    }
}
