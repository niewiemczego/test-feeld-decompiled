package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonObjectReader;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectWriter;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class App implements JsonUnknown, JsonSerializable {
    public static final String TYPE = "app";
    /* access modifiers changed from: private */
    public String appBuild;
    /* access modifiers changed from: private */
    public String appIdentifier;
    /* access modifiers changed from: private */
    public String appName;
    /* access modifiers changed from: private */
    public Date appStartTime;
    /* access modifiers changed from: private */
    public String appVersion;
    /* access modifiers changed from: private */
    public String buildType;
    /* access modifiers changed from: private */
    public String deviceAppHash;
    /* access modifiers changed from: private */
    public Boolean inForeground;
    /* access modifiers changed from: private */
    public Map<String, String> permissions;
    private Map<String, Object> unknown;
    private List<String> viewNames;

    public static final class JsonKeys {
        public static final String APP_BUILD = "app_build";
        public static final String APP_IDENTIFIER = "app_identifier";
        public static final String APP_NAME = "app_name";
        public static final String APP_PERMISSIONS = "permissions";
        public static final String APP_START_TIME = "app_start_time";
        public static final String APP_VERSION = "app_version";
        public static final String BUILD_TYPE = "build_type";
        public static final String DEVICE_APP_HASH = "device_app_hash";
        public static final String IN_FOREGROUND = "in_foreground";
        public static final String VIEW_NAMES = "view_names";
    }

    public App() {
    }

    App(App app2) {
        this.appBuild = app2.appBuild;
        this.appIdentifier = app2.appIdentifier;
        this.appName = app2.appName;
        this.appStartTime = app2.appStartTime;
        this.appVersion = app2.appVersion;
        this.buildType = app2.buildType;
        this.deviceAppHash = app2.deviceAppHash;
        this.permissions = CollectionUtils.newConcurrentHashMap(app2.permissions);
        this.inForeground = app2.inForeground;
        this.viewNames = CollectionUtils.newArrayList(app2.viewNames);
        this.unknown = CollectionUtils.newConcurrentHashMap(app2.unknown);
    }

    public String getAppIdentifier() {
        return this.appIdentifier;
    }

    public void setAppIdentifier(String str) {
        this.appIdentifier = str;
    }

    public Date getAppStartTime() {
        Date date = this.appStartTime;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public void setAppStartTime(Date date) {
        this.appStartTime = date;
    }

    public String getDeviceAppHash() {
        return this.deviceAppHash;
    }

    public void setDeviceAppHash(String str) {
        this.deviceAppHash = str;
    }

    public String getBuildType() {
        return this.buildType;
    }

    public void setBuildType(String str) {
        this.buildType = str;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public String getAppBuild() {
        return this.appBuild;
    }

    public void setAppBuild(String str) {
        this.appBuild = str;
    }

    public Map<String, String> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(Map<String, String> map) {
        this.permissions = map;
    }

    public Boolean getInForeground() {
        return this.inForeground;
    }

    public void setInForeground(Boolean bool) {
        this.inForeground = bool;
    }

    public List<String> getViewNames() {
        return this.viewNames;
    }

    public void setViewNames(List<String> list) {
        this.viewNames = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        App app2 = (App) obj;
        if (!Objects.equals(this.appIdentifier, app2.appIdentifier) || !Objects.equals(this.appStartTime, app2.appStartTime) || !Objects.equals(this.deviceAppHash, app2.deviceAppHash) || !Objects.equals(this.buildType, app2.buildType) || !Objects.equals(this.appName, app2.appName) || !Objects.equals(this.appVersion, app2.appVersion) || !Objects.equals(this.appBuild, app2.appBuild) || !Objects.equals(this.permissions, app2.permissions) || !Objects.equals(this.inForeground, app2.inForeground) || !Objects.equals(this.viewNames, app2.viewNames)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(this.appIdentifier, this.appStartTime, this.deviceAppHash, this.buildType, this.appName, this.appVersion, this.appBuild, this.permissions, this.inForeground, this.viewNames);
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        if (this.appIdentifier != null) {
            objectWriter.name(JsonKeys.APP_IDENTIFIER).value(this.appIdentifier);
        }
        if (this.appStartTime != null) {
            objectWriter.name(JsonKeys.APP_START_TIME).value(iLogger, this.appStartTime);
        }
        if (this.deviceAppHash != null) {
            objectWriter.name(JsonKeys.DEVICE_APP_HASH).value(this.deviceAppHash);
        }
        if (this.buildType != null) {
            objectWriter.name(JsonKeys.BUILD_TYPE).value(this.buildType);
        }
        if (this.appName != null) {
            objectWriter.name("app_name").value(this.appName);
        }
        if (this.appVersion != null) {
            objectWriter.name(JsonKeys.APP_VERSION).value(this.appVersion);
        }
        if (this.appBuild != null) {
            objectWriter.name(JsonKeys.APP_BUILD).value(this.appBuild);
        }
        Map<String, String> map = this.permissions;
        if (map != null && !map.isEmpty()) {
            objectWriter.name("permissions").value(iLogger, this.permissions);
        }
        if (this.inForeground != null) {
            objectWriter.name(JsonKeys.IN_FOREGROUND).value(this.inForeground);
        }
        if (this.viewNames != null) {
            objectWriter.name(JsonKeys.VIEW_NAMES).value(iLogger, this.viewNames);
        }
        Map<String, Object> map2 = this.unknown;
        if (map2 != null) {
            for (String next : map2.keySet()) {
                objectWriter.name(next).value(iLogger, this.unknown.get(next));
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<App> {
        public App deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            jsonObjectReader.beginObject();
            App app2 = new App();
            ConcurrentHashMap concurrentHashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case -1898053579:
                        if (nextName.equals(JsonKeys.DEVICE_APP_HASH)) {
                            c = 0;
                            break;
                        }
                        break;
                    case -1524619986:
                        if (nextName.equals(JsonKeys.VIEW_NAMES)) {
                            c = 1;
                            break;
                        }
                        break;
                    case -901870406:
                        if (nextName.equals(JsonKeys.APP_VERSION)) {
                            c = 2;
                            break;
                        }
                        break;
                    case -650544995:
                        if (nextName.equals(JsonKeys.IN_FOREGROUND)) {
                            c = 3;
                            break;
                        }
                        break;
                    case -470395285:
                        if (nextName.equals(JsonKeys.BUILD_TYPE)) {
                            c = 4;
                            break;
                        }
                        break;
                    case 746297735:
                        if (nextName.equals(JsonKeys.APP_IDENTIFIER)) {
                            c = 5;
                            break;
                        }
                        break;
                    case 791585128:
                        if (nextName.equals(JsonKeys.APP_START_TIME)) {
                            c = 6;
                            break;
                        }
                        break;
                    case 1133704324:
                        if (nextName.equals("permissions")) {
                            c = 7;
                            break;
                        }
                        break;
                    case 1167648233:
                        if (nextName.equals("app_name")) {
                            c = 8;
                            break;
                        }
                        break;
                    case 1826866896:
                        if (nextName.equals(JsonKeys.APP_BUILD)) {
                            c = 9;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        String unused = app2.deviceAppHash = jsonObjectReader.nextStringOrNull();
                        break;
                    case 1:
                        List list = (List) jsonObjectReader.nextObjectOrNull();
                        if (list == null) {
                            break;
                        } else {
                            app2.setViewNames(list);
                            break;
                        }
                    case 2:
                        String unused2 = app2.appVersion = jsonObjectReader.nextStringOrNull();
                        break;
                    case 3:
                        Boolean unused3 = app2.inForeground = jsonObjectReader.nextBooleanOrNull();
                        break;
                    case 4:
                        String unused4 = app2.buildType = jsonObjectReader.nextStringOrNull();
                        break;
                    case 5:
                        String unused5 = app2.appIdentifier = jsonObjectReader.nextStringOrNull();
                        break;
                    case 6:
                        Date unused6 = app2.appStartTime = jsonObjectReader.nextDateOrNull(iLogger);
                        break;
                    case 7:
                        Map unused7 = app2.permissions = CollectionUtils.newConcurrentHashMap((Map) jsonObjectReader.nextObjectOrNull());
                        break;
                    case 8:
                        String unused8 = app2.appName = jsonObjectReader.nextStringOrNull();
                        break;
                    case 9:
                        String unused9 = app2.appBuild = jsonObjectReader.nextStringOrNull();
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        jsonObjectReader.nextUnknown(iLogger, concurrentHashMap, nextName);
                        break;
                }
            }
            app2.setUnknown(concurrentHashMap);
            jsonObjectReader.endObject();
            return app2;
        }
    }
}
