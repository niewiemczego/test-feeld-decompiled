package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;

public final class AFd1jSDK extends AFd1iSDK<String> {
    private final String afRDLog;
    private final AFe1oSDK afWarnLog;

    /* access modifiers changed from: protected */
    public final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean afDebugLog() {
        return false;
    }

    public AFd1jSDK(AFc1vSDK aFc1vSDK, String str, AFe1oSDK aFe1oSDK) {
        super(AFd1sSDK.IMPRESSIONS, new AFd1sSDK[]{AFd1sSDK.RC_CDN}, aFc1vSDK, str);
        this.afRDLog = str;
        this.afWarnLog = aFe1oSDK;
    }

    /* access modifiers changed from: protected */
    public final AFc1mSDK<String> AFInAppEventParameterName(String str) {
        return this.afDebugLog.AFKeystoreWrapper(this.afRDLog);
    }

    public final void AFKeystoreWrapper() {
        super.AFKeystoreWrapper();
        AFc1aSDK<Result> aFc1aSDK = this.afInfoLog;
        if (aFc1aSDK != null) {
            int statusCode = aFc1aSDK.getStatusCode();
            if (statusCode == 200) {
                AFLogger.afInfoLog(new StringBuilder("Cross promotion impressions success: ").append(this.afRDLog).toString(), false);
            } else if (statusCode == 301 || statusCode == 302) {
                AFLogger.afInfoLog(new StringBuilder("Cross promotion redirection success: ").append(this.afRDLog).toString(), false);
                String valueOf = aFc1aSDK.valueOf("Location");
                AFe1oSDK aFe1oSDK = this.afWarnLog;
                if (aFe1oSDK != null && valueOf != null) {
                    aFe1oSDK.AFInAppEventParameterName = valueOf;
                    AFe1oSDK aFe1oSDK2 = this.afWarnLog;
                    Context context = aFe1oSDK2.valueOf.get();
                    if (context != null) {
                        try {
                            if (aFe1oSDK2.AFInAppEventParameterName != null) {
                                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(aFe1oSDK2.AFInAppEventParameterName)).setFlags(268435456));
                            }
                        } catch (Exception e) {
                            AFLogger.afErrorLog("Failed to open cross promotion url, does OS have browser installed?".concat(String.valueOf(e)), e);
                        }
                    }
                }
            } else {
                AFLogger.afInfoLog(new StringBuilder("call to ").append(this.afRDLog).append(" failed: ").append(statusCode).toString());
            }
        }
    }
}
