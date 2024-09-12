package com.appsflyer.internal;

import android.util.Base64;
import com.appsflyer.AFLogger;
import java.nio.charset.Charset;

public final class AFe1tSDK {
    public static final Charset valueOf = Charset.forName("UTF-8");
    public long AFInAppEventParameterName;
    public long AFInAppEventType;
    public final AFc1xSDK AFKeystoreWrapper;
    public AFb1lSDK values = valueOf();

    public AFe1tSDK(AFc1xSDK aFc1xSDK) {
        this.AFKeystoreWrapper = aFc1xSDK;
        this.AFInAppEventType = aFc1xSDK.AFKeystoreWrapper("af_rc_timestamp", 0);
        this.AFInAppEventParameterName = aFc1xSDK.AFKeystoreWrapper("af_rc_max_age", 0);
    }

    private AFb1lSDK valueOf() {
        String AFInAppEventType2 = this.AFKeystoreWrapper.AFInAppEventType("af_remote_config", (String) null);
        if (AFInAppEventType2 == null) {
            AFLogger.afDebugLog("CFG: No configuration found in cache");
            return null;
        }
        try {
            return new AFb1lSDK(new String(Base64.decode(AFInAppEventType2, 2), valueOf));
        } catch (Exception e) {
            AFLogger.afErrorLog("CFG: Error reading malformed configuration from cache, requires fetching from remote again", e, true);
            return null;
        }
    }
}
