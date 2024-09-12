package com.appsflyer.internal;

import android.util.Base64;
import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.net.MalformedURLException;
import java.net.URL;

public final class AFd1aSDK extends AFd1iSDK<String> {
    private final AFe1eSDK afRDLog;

    /* access modifiers changed from: protected */
    public final boolean afDebugLog() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final AFc1mSDK<String> AFInAppEventParameterName(String str) {
        String encodeToString = Base64.encodeToString(this.afRDLog.values(), 2);
        AFLogger.afInfoLog("cached data: ".concat(String.valueOf(encodeToString)));
        this.afErrorLog.AFInAppEventParameterName(this.afRDLog.AFLogger, encodeToString);
        return this.afDebugLog.values(this.afRDLog);
    }

    /* access modifiers changed from: protected */
    public final AppsFlyerRequestListener AFLogger() {
        return this.afRDLog.AFInAppEventType;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AFd1aSDK(com.appsflyer.internal.AFe1eSDK r8, com.appsflyer.internal.AFc1vSDK r9) {
        /*
            r7 = this;
            com.appsflyer.internal.AFd1sSDK r0 = r8.AFVersionDeclaration
            if (r0 == 0) goto L_0x0007
            com.appsflyer.internal.AFd1sSDK r0 = r8.AFVersionDeclaration
            goto L_0x0009
        L_0x0007:
            com.appsflyer.internal.AFd1sSDK r0 = com.appsflyer.internal.AFd1sSDK.CACHED_EVENT
        L_0x0009:
            r2 = r0
            r0 = 1
            com.appsflyer.internal.AFd1sSDK[] r3 = new com.appsflyer.internal.AFd1sSDK[r0]
            r0 = 0
            com.appsflyer.internal.AFd1sSDK r1 = com.appsflyer.internal.AFd1sSDK.RC_CDN
            r3[r0] = r1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r8.afDebugLog
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = "-"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = valueOf(r8)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r5 = r0.toString()
            java.lang.String r6 = r8.afDebugLog
            r1 = r7
            r4 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            r7.afRDLog = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1aSDK.<init>(com.appsflyer.internal.AFe1eSDK, com.appsflyer.internal.AFc1vSDK):void");
    }

    private static String valueOf(AFe1eSDK aFe1eSDK) {
        try {
            return new URL(aFe1eSDK.AFLogger).getHost();
        } catch (MalformedURLException unused) {
            return "";
        }
    }
}
