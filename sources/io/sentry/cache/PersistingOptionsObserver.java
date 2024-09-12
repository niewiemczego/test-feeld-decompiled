package io.sentry.cache;

import io.sentry.IOptionsObserver;
import io.sentry.JsonDeserializer;
import io.sentry.SentryOptions;
import io.sentry.protocol.SdkVersion;
import java.util.Map;

public final class PersistingOptionsObserver implements IOptionsObserver {
    public static final String DIST_FILENAME = "dist.json";
    public static final String ENVIRONMENT_FILENAME = "environment.json";
    public static final String OPTIONS_CACHE = ".options-cache";
    public static final String PROGUARD_UUID_FILENAME = "proguard-uuid.json";
    public static final String RELEASE_FILENAME = "release.json";
    public static final String SDK_VERSION_FILENAME = "sdk-version.json";
    public static final String TAGS_FILENAME = "tags.json";
    private final SentryOptions options;

    public PersistingOptionsObserver(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    public void setRelease(String str) {
        if (str == null) {
            delete(RELEASE_FILENAME);
        } else {
            store(str, RELEASE_FILENAME);
        }
    }

    public void setProguardUuid(String str) {
        if (str == null) {
            delete(PROGUARD_UUID_FILENAME);
        } else {
            store(str, PROGUARD_UUID_FILENAME);
        }
    }

    public void setSdkVersion(SdkVersion sdkVersion) {
        if (sdkVersion == null) {
            delete(SDK_VERSION_FILENAME);
        } else {
            store(sdkVersion, SDK_VERSION_FILENAME);
        }
    }

    public void setDist(String str) {
        if (str == null) {
            delete(DIST_FILENAME);
        } else {
            store(str, DIST_FILENAME);
        }
    }

    public void setEnvironment(String str) {
        if (str == null) {
            delete(ENVIRONMENT_FILENAME);
        } else {
            store(str, ENVIRONMENT_FILENAME);
        }
    }

    public void setTags(Map<String, String> map) {
        store(map, "tags.json");
    }

    private <T> void store(T t, String str) {
        CacheUtils.store(this.options, t, OPTIONS_CACHE, str);
    }

    private void delete(String str) {
        CacheUtils.delete(this.options, OPTIONS_CACHE, str);
    }

    public static <T> T read(SentryOptions sentryOptions, String str, Class<T> cls) {
        return read(sentryOptions, str, cls, (JsonDeserializer) null);
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [io.sentry.JsonDeserializer, io.sentry.JsonDeserializer<R>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T, R> T read(io.sentry.SentryOptions r1, java.lang.String r2, java.lang.Class<T> r3, io.sentry.JsonDeserializer<R> r4) {
        /*
            java.lang.String r0 = ".options-cache"
            java.lang.Object r1 = io.sentry.cache.CacheUtils.read(r1, r0, r2, r3, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.cache.PersistingOptionsObserver.read(io.sentry.SentryOptions, java.lang.String, java.lang.Class, io.sentry.JsonDeserializer):java.lang.Object");
    }
}
