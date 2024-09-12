package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonObjectReader;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectWriter;
import io.sentry.SentryIntegrationPackageStorage;
import io.sentry.SentryLevel;
import io.sentry.protocol.SentryPackage;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public final class SdkVersion implements JsonUnknown, JsonSerializable {
    /* access modifiers changed from: private */
    public Set<String> deserializedIntegrations;
    /* access modifiers changed from: private */
    public Set<SentryPackage> deserializedPackages;
    private String name;
    private Map<String, Object> unknown;
    private String version;

    public static final class JsonKeys {
        public static final String INTEGRATIONS = "integrations";
        public static final String NAME = "name";
        public static final String PACKAGES = "packages";
        public static final String VERSION = "version";
    }

    public SdkVersion(String str, String str2) {
        this.name = (String) Objects.requireNonNull(str, "name is required.");
        this.version = (String) Objects.requireNonNull(str2, "version is required.");
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = (String) Objects.requireNonNull(str, "version is required.");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = (String) Objects.requireNonNull(str, "name is required.");
    }

    public void addPackage(String str, String str2) {
        SentryIntegrationPackageStorage.getInstance().addPackage(str, str2);
    }

    public void addIntegration(String str) {
        SentryIntegrationPackageStorage.getInstance().addIntegration(str);
    }

    @Deprecated
    public List<SentryPackage> getPackages() {
        Set<SentryPackage> set = this.deserializedPackages;
        if (set == null) {
            set = SentryIntegrationPackageStorage.getInstance().getPackages();
        }
        return new CopyOnWriteArrayList(set);
    }

    public Set<SentryPackage> getPackageSet() {
        Set<SentryPackage> set = this.deserializedPackages;
        return set != null ? set : SentryIntegrationPackageStorage.getInstance().getPackages();
    }

    @Deprecated
    public List<String> getIntegrations() {
        Set<String> set = this.deserializedIntegrations;
        if (set == null) {
            set = SentryIntegrationPackageStorage.getInstance().getIntegrations();
        }
        return new CopyOnWriteArrayList(set);
    }

    public Set<String> getIntegrationSet() {
        Set<String> set = this.deserializedIntegrations;
        return set != null ? set : SentryIntegrationPackageStorage.getInstance().getIntegrations();
    }

    public static SdkVersion updateSdkVersion(SdkVersion sdkVersion, String str, String str2) {
        Objects.requireNonNull(str, "name is required.");
        Objects.requireNonNull(str2, "version is required.");
        if (sdkVersion == null) {
            return new SdkVersion(str, str2);
        }
        sdkVersion.setName(str);
        sdkVersion.setVersion(str2);
        return sdkVersion;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SdkVersion sdkVersion = (SdkVersion) obj;
        if (!this.name.equals(sdkVersion.name) || !this.version.equals(sdkVersion.version)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(this.name, this.version);
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        objectWriter.name("name").value(this.name);
        objectWriter.name("version").value(this.version);
        Set<SentryPackage> packageSet = getPackageSet();
        Set<String> integrationSet = getIntegrationSet();
        if (!packageSet.isEmpty()) {
            objectWriter.name(JsonKeys.PACKAGES).value(iLogger, packageSet);
        }
        if (!integrationSet.isEmpty()) {
            objectWriter.name(JsonKeys.INTEGRATIONS).value(iLogger, integrationSet);
        }
        Map<String, Object> map = this.unknown;
        if (map != null) {
            for (String next : map.keySet()) {
                objectWriter.name(next).value(iLogger, this.unknown.get(next));
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<SdkVersion> {
        public SdkVersion deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            jsonObjectReader.beginObject();
            String str = null;
            String str2 = null;
            HashMap hashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case 3373707:
                        if (nextName.equals("name")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 351608024:
                        if (nextName.equals("version")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 750867693:
                        if (nextName.equals(JsonKeys.PACKAGES)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 1487029535:
                        if (nextName.equals(JsonKeys.INTEGRATIONS)) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        str = jsonObjectReader.nextString();
                        break;
                    case 1:
                        str2 = jsonObjectReader.nextString();
                        break;
                    case 2:
                        List nextListOrNull = jsonObjectReader.nextListOrNull(iLogger, new SentryPackage.Deserializer());
                        if (nextListOrNull == null) {
                            break;
                        } else {
                            arrayList.addAll(nextListOrNull);
                            break;
                        }
                    case 3:
                        List list = (List) jsonObjectReader.nextObjectOrNull();
                        if (list == null) {
                            break;
                        } else {
                            arrayList2.addAll(list);
                            break;
                        }
                    default:
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        jsonObjectReader.nextUnknown(iLogger, hashMap, nextName);
                        break;
                }
            }
            jsonObjectReader.endObject();
            if (str == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Missing required field \"name\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"name\"", (Throwable) illegalStateException);
                throw illegalStateException;
            } else if (str2 != null) {
                SdkVersion sdkVersion = new SdkVersion(str, str2);
                Set unused = sdkVersion.deserializedPackages = new CopyOnWriteArraySet(arrayList);
                Set unused2 = sdkVersion.deserializedIntegrations = new CopyOnWriteArraySet(arrayList2);
                sdkVersion.setUnknown(hashMap);
                return sdkVersion;
            } else {
                IllegalStateException illegalStateException2 = new IllegalStateException("Missing required field \"version\"");
                iLogger.log(SentryLevel.ERROR, "Missing required field \"version\"", (Throwable) illegalStateException2);
                throw illegalStateException2;
            }
        }
    }
}
