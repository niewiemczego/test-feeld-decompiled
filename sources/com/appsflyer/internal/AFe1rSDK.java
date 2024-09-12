package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.util.concurrent.TimeUnit;

public final class AFe1rSDK {
    private static final long valueOf = TimeUnit.HOURS.toSeconds(24);
    private final AFe1tSDK AFInAppEventType;
    private final AFb1bSDK AFKeystoreWrapper;

    public AFe1rSDK(AFb1bSDK aFb1bSDK, AFe1tSDK aFe1tSDK) {
        this.AFKeystoreWrapper = aFb1bSDK;
        this.AFInAppEventType = aFe1tSDK;
    }

    public final boolean AFKeystoreWrapper() {
        return Boolean.parseBoolean(this.AFKeystoreWrapper.valueOf("com.appsflyer.rc.sandbox"));
    }

    public final boolean values() {
        return Boolean.parseBoolean(this.AFKeystoreWrapper.valueOf("com.appsflyer.rc.staging"));
    }

    public final long AFInAppEventParameterName() {
        String valueOf2 = this.AFKeystoreWrapper.valueOf("com.appsflyer.rc.cache.max-age-fallback");
        if (valueOf2 == null) {
            return valueOf;
        }
        try {
            return Long.parseLong(valueOf2);
        } catch (NumberFormatException e) {
            AFLogger.afErrorLog(new StringBuilder("Can't read maxAgeFallback from Manifest: ").append(e.getMessage()).toString(), e);
            return valueOf;
        }
    }

    public final boolean valueOf() {
        if (this.AFInAppEventType.values == null) {
            AFLogger.afInfoLog("CFG: active config is missing - fetching from CDN");
            return true;
        } else if (System.currentTimeMillis() - this.AFInAppEventType.AFInAppEventType > TimeUnit.SECONDS.toMillis(this.AFInAppEventType.AFInAppEventParameterName)) {
            return true;
        } else {
            return false;
        }
    }
}
