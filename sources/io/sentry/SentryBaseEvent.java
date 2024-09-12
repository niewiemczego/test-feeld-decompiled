package io.sentry;

import io.sentry.Breadcrumb;
import io.sentry.exception.ExceptionMechanismException;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.DebugMeta;
import io.sentry.protocol.Request;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import io.sentry.util.CollectionUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.CharUtils;

public abstract class SentryBaseEvent {
    public static final String DEFAULT_PLATFORM = "java";
    /* access modifiers changed from: private */
    public List<Breadcrumb> breadcrumbs;
    /* access modifiers changed from: private */
    public final Contexts contexts;
    /* access modifiers changed from: private */
    public DebugMeta debugMeta;
    /* access modifiers changed from: private */
    public String dist;
    /* access modifiers changed from: private */
    public String environment;
    /* access modifiers changed from: private */
    public SentryId eventId;
    /* access modifiers changed from: private */
    public Map<String, Object> extra;
    /* access modifiers changed from: private */
    public String platform;
    /* access modifiers changed from: private */
    public String release;
    /* access modifiers changed from: private */
    public Request request;
    /* access modifiers changed from: private */
    public SdkVersion sdk;
    /* access modifiers changed from: private */
    public String serverName;
    /* access modifiers changed from: private */
    public Map<String, String> tags;
    protected transient Throwable throwable;
    /* access modifiers changed from: private */
    public User user;

    public static final class JsonKeys {
        public static final String BREADCRUMBS = "breadcrumbs";
        public static final String CONTEXTS = "contexts";
        public static final String DEBUG_META = "debug_meta";
        public static final String DIST = "dist";
        public static final String ENVIRONMENT = "environment";
        public static final String EVENT_ID = "event_id";
        public static final String EXTRA = "extra";
        public static final String PLATFORM = "platform";
        public static final String RELEASE = "release";
        public static final String REQUEST = "request";
        public static final String SDK = "sdk";
        public static final String SERVER_NAME = "server_name";
        public static final String TAGS = "tags";
        public static final String USER = "user";
    }

    protected SentryBaseEvent(SentryId sentryId) {
        this.contexts = new Contexts();
        this.eventId = sentryId;
    }

    protected SentryBaseEvent() {
        this(new SentryId());
    }

    public SentryId getEventId() {
        return this.eventId;
    }

    public void setEventId(SentryId sentryId) {
        this.eventId = sentryId;
    }

    public Contexts getContexts() {
        return this.contexts;
    }

    public SdkVersion getSdk() {
        return this.sdk;
    }

    public void setSdk(SdkVersion sdkVersion) {
        this.sdk = sdkVersion;
    }

    public Request getRequest() {
        return this.request;
    }

    public void setRequest(Request request2) {
        this.request = request2;
    }

    public Throwable getThrowable() {
        Throwable th = this.throwable;
        return th instanceof ExceptionMechanismException ? ((ExceptionMechanismException) th).getThrowable() : th;
    }

    public Throwable getThrowableMechanism() {
        return this.throwable;
    }

    public void setThrowable(Throwable th) {
        this.throwable = th;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public void setTags(Map<String, String> map) {
        this.tags = CollectionUtils.newHashMap(map);
    }

    public void removeTag(String str) {
        Map<String, String> map = this.tags;
        if (map != null) {
            map.remove(str);
        }
    }

    public String getTag(String str) {
        Map<String, String> map = this.tags;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public void setTag(String str, String str2) {
        if (this.tags == null) {
            this.tags = new HashMap();
        }
        this.tags.put(str, str2);
    }

    public String getRelease() {
        return this.release;
    }

    public void setRelease(String str) {
        this.release = str;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public void setEnvironment(String str) {
        this.environment = str;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public String getServerName() {
        return this.serverName;
    }

    public void setServerName(String str) {
        this.serverName = str;
    }

    public String getDist() {
        return this.dist;
    }

    public void setDist(String str) {
        this.dist = str;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user2) {
        this.user = user2;
    }

    public List<Breadcrumb> getBreadcrumbs() {
        return this.breadcrumbs;
    }

    public void setBreadcrumbs(List<Breadcrumb> list) {
        this.breadcrumbs = CollectionUtils.newArrayList(list);
    }

    public void addBreadcrumb(Breadcrumb breadcrumb) {
        if (this.breadcrumbs == null) {
            this.breadcrumbs = new ArrayList();
        }
        this.breadcrumbs.add(breadcrumb);
    }

    public DebugMeta getDebugMeta() {
        return this.debugMeta;
    }

    public void setDebugMeta(DebugMeta debugMeta2) {
        this.debugMeta = debugMeta2;
    }

    public Map<String, Object> getExtras() {
        return this.extra;
    }

    public void setExtras(Map<String, Object> map) {
        this.extra = CollectionUtils.newHashMap(map);
    }

    public void setExtra(String str, Object obj) {
        if (this.extra == null) {
            this.extra = new HashMap();
        }
        this.extra.put(str, obj);
    }

    public void removeExtra(String str) {
        Map<String, Object> map = this.extra;
        if (map != null) {
            map.remove(str);
        }
    }

    public Object getExtra(String str) {
        Map<String, Object> map = this.extra;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public void addBreadcrumb(String str) {
        addBreadcrumb(new Breadcrumb(str));
    }

    public static final class Serializer {
        public void serialize(SentryBaseEvent sentryBaseEvent, ObjectWriter objectWriter, ILogger iLogger) throws IOException {
            if (sentryBaseEvent.eventId != null) {
                objectWriter.name("event_id").value(iLogger, sentryBaseEvent.eventId);
            }
            objectWriter.name("contexts").value(iLogger, sentryBaseEvent.contexts);
            if (sentryBaseEvent.sdk != null) {
                objectWriter.name("sdk").value(iLogger, sentryBaseEvent.sdk);
            }
            if (sentryBaseEvent.request != null) {
                objectWriter.name("request").value(iLogger, sentryBaseEvent.request);
            }
            if (sentryBaseEvent.tags != null && !sentryBaseEvent.tags.isEmpty()) {
                objectWriter.name("tags").value(iLogger, sentryBaseEvent.tags);
            }
            if (sentryBaseEvent.release != null) {
                objectWriter.name("release").value(sentryBaseEvent.release);
            }
            if (sentryBaseEvent.environment != null) {
                objectWriter.name("environment").value(sentryBaseEvent.environment);
            }
            if (sentryBaseEvent.platform != null) {
                objectWriter.name("platform").value(sentryBaseEvent.platform);
            }
            if (sentryBaseEvent.user != null) {
                objectWriter.name("user").value(iLogger, sentryBaseEvent.user);
            }
            if (sentryBaseEvent.serverName != null) {
                objectWriter.name(JsonKeys.SERVER_NAME).value(sentryBaseEvent.serverName);
            }
            if (sentryBaseEvent.dist != null) {
                objectWriter.name(JsonKeys.DIST).value(sentryBaseEvent.dist);
            }
            if (sentryBaseEvent.breadcrumbs != null && !sentryBaseEvent.breadcrumbs.isEmpty()) {
                objectWriter.name(JsonKeys.BREADCRUMBS).value(iLogger, sentryBaseEvent.breadcrumbs);
            }
            if (sentryBaseEvent.debugMeta != null) {
                objectWriter.name(JsonKeys.DEBUG_META).value(iLogger, sentryBaseEvent.debugMeta);
            }
            if (sentryBaseEvent.extra != null && !sentryBaseEvent.extra.isEmpty()) {
                objectWriter.name("extra").value(iLogger, sentryBaseEvent.extra);
            }
        }
    }

    public static final class Deserializer {
        public boolean deserializeValue(SentryBaseEvent sentryBaseEvent, String str, JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1840434063:
                    if (str.equals(JsonKeys.DEBUG_META)) {
                        c = 0;
                        break;
                    }
                    break;
                case -758770169:
                    if (str.equals(JsonKeys.SERVER_NAME)) {
                        c = 1;
                        break;
                    }
                    break;
                case -567312220:
                    if (str.equals("contexts")) {
                        c = 2;
                        break;
                    }
                    break;
                case -85904877:
                    if (str.equals("environment")) {
                        c = 3;
                        break;
                    }
                    break;
                case -51457840:
                    if (str.equals(JsonKeys.BREADCRUMBS)) {
                        c = 4;
                        break;
                    }
                    break;
                case 113722:
                    if (str.equals("sdk")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3083686:
                    if (str.equals(JsonKeys.DIST)) {
                        c = 6;
                        break;
                    }
                    break;
                case 3552281:
                    if (str.equals("tags")) {
                        c = 7;
                        break;
                    }
                    break;
                case 3599307:
                    if (str.equals("user")) {
                        c = 8;
                        break;
                    }
                    break;
                case 96965648:
                    if (str.equals("extra")) {
                        c = 9;
                        break;
                    }
                    break;
                case 278118624:
                    if (str.equals("event_id")) {
                        c = 10;
                        break;
                    }
                    break;
                case 1090594823:
                    if (str.equals("release")) {
                        c = 11;
                        break;
                    }
                    break;
                case 1095692943:
                    if (str.equals("request")) {
                        c = 12;
                        break;
                    }
                    break;
                case 1874684019:
                    if (str.equals("platform")) {
                        c = CharUtils.CR;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    DebugMeta unused = sentryBaseEvent.debugMeta = (DebugMeta) jsonObjectReader.nextOrNull(iLogger, new DebugMeta.Deserializer());
                    return true;
                case 1:
                    String unused2 = sentryBaseEvent.serverName = jsonObjectReader.nextStringOrNull();
                    return true;
                case 2:
                    sentryBaseEvent.contexts.putAll(new Contexts.Deserializer().deserialize(jsonObjectReader, iLogger));
                    return true;
                case 3:
                    String unused3 = sentryBaseEvent.environment = jsonObjectReader.nextStringOrNull();
                    return true;
                case 4:
                    List unused4 = sentryBaseEvent.breadcrumbs = jsonObjectReader.nextListOrNull(iLogger, new Breadcrumb.Deserializer());
                    return true;
                case 5:
                    SdkVersion unused5 = sentryBaseEvent.sdk = (SdkVersion) jsonObjectReader.nextOrNull(iLogger, new SdkVersion.Deserializer());
                    return true;
                case 6:
                    String unused6 = sentryBaseEvent.dist = jsonObjectReader.nextStringOrNull();
                    return true;
                case 7:
                    Map unused7 = sentryBaseEvent.tags = CollectionUtils.newConcurrentHashMap((Map) jsonObjectReader.nextObjectOrNull());
                    return true;
                case 8:
                    User unused8 = sentryBaseEvent.user = (User) jsonObjectReader.nextOrNull(iLogger, new User.Deserializer());
                    return true;
                case 9:
                    Map unused9 = sentryBaseEvent.extra = CollectionUtils.newConcurrentHashMap((Map) jsonObjectReader.nextObjectOrNull());
                    return true;
                case 10:
                    SentryId unused10 = sentryBaseEvent.eventId = (SentryId) jsonObjectReader.nextOrNull(iLogger, new SentryId.Deserializer());
                    return true;
                case 11:
                    String unused11 = sentryBaseEvent.release = jsonObjectReader.nextStringOrNull();
                    return true;
                case 12:
                    Request unused12 = sentryBaseEvent.request = (Request) jsonObjectReader.nextOrNull(iLogger, new Request.Deserializer());
                    return true;
                case 13:
                    String unused13 = sentryBaseEvent.platform = jsonObjectReader.nextStringOrNull();
                    return true;
                default:
                    return false;
            }
        }
    }
}
