package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.view.ViewConfiguration;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFc1qSDK;
import com.facebook.internal.ServerProtocol;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;

public final class AFd1bSDK extends AFd1cSDK {
    private static char afWarnLog = '\u0003';
    private static char[] getLevel = {2, 13816, 13819, 13812, 1, 4, 13822, 3, 13800};
    private static int init = 1;
    private static int onInstallConversionDataLoadedNative;
    private final String AFLogger$LogLevel;
    private final AFc1wSDK afErrorLogForExcManagerOnly;

    public AFd1bSDK(String str, AFc1vSDK aFc1vSDK) {
        super(new AFe1nSDK(aFc1vSDK.afErrorLogForExcManagerOnly().AFKeystoreWrapper), aFc1vSDK, str);
        this.afErrorLogForExcManagerOnly = aFc1vSDK.afErrorLogForExcManagerOnly();
        this.AFLogger$LogLevel = str;
    }

    public final void AFKeystoreWrapper() {
        boolean z = true;
        int i = onInstallConversionDataLoadedNative + 1;
        init = i % 128;
        if (i % 2 != 0) {
            z = false;
        }
        if (!z) {
            super.AFKeystoreWrapper();
            AFc1aSDK<Result> aFc1aSDK = this.afInfoLog;
            if ((aFc1aSDK != null ? 'Y' : 'L') == 'Y') {
                if ((aFc1aSDK.isSuccessful() ? '3' : ':') != ':') {
                    afWarnLog();
                }
            }
            int i2 = onInstallConversionDataLoadedNative + 123;
            init = i2 % 128;
            int i3 = i2 % 2;
            return;
        }
        super.AFKeystoreWrapper();
        AFc1aSDK<Result> aFc1aSDK2 = this.afInfoLog;
        throw null;
    }

    /* access modifiers changed from: protected */
    public final void valueOf(AFa1sSDK aFa1sSDK) {
        int i = init + 53;
        onInstallConversionDataLoadedNative = i % 128;
        int i2 = i % 2;
        super.valueOf(aFa1sSDK);
        Context context = this.afErrorLogForExcManagerOnly.AFKeystoreWrapper;
        AFb1xSDK AFInAppEventType = AFb1xSDK.AFInAppEventType();
        if (context == null) {
            throw new IllegalStateException("Context is not provided, can't send register request");
        } else if (!AFInAppEventType.values()) {
            PackageManager packageManager = context.getPackageManager();
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                aFa1sSDK.values("app_version_code", Integer.toString(packageInfo.versionCode));
                aFa1sSDK.values("app_version_name", packageInfo.versionName);
                aFa1sSDK.values("app_name", packageManager.getApplicationLabel(packageInfo.applicationInfo).toString());
                aFa1sSDK.values("installDate", AFb1xSDK.AFKeystoreWrapper(new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US), packageInfo.firstInstallTime));
            } catch (Throwable th) {
                AFLogger.afErrorLog("Exception while collecting application version info.", th);
            }
            AFInAppEventType.AFKeystoreWrapper(context, (Map<String, ? super String>) aFa1sSDK.AFInAppEventType());
            String valueOf = AFb1xSDK.valueOf();
            if (!(valueOf == null)) {
                aFa1sSDK.values("appUserId", valueOf);
            }
            try {
                aFa1sSDK.values("model", Build.MODEL);
                Object[] objArr = new Object[1];
                valueOf((byte) (102 - (Process.myTid() >> 22)), 5 - (ViewConfiguration.getWindowTouchSlop() >> 8), "\u0002\u0007\u0000\u0005㙤", objArr);
                aFa1sSDK.values(((String) objArr[0]).intern(), Build.BRAND);
            } catch (Throwable th2) {
                AFLogger.afErrorLog("Exception while collecting device brand and model.", th2);
            }
            if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
                int i3 = init + 5;
                onInstallConversionDataLoadedNative = i3 % 128;
                int i4 = i3 % 2;
                aFa1sSDK.values(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            }
            AFc1qSDK.AFa1vSDK values = AFa1bSDK.values(context.getContentResolver());
            if (values != null) {
                int i5 = init + 85;
                onInstallConversionDataLoadedNative = i5 % 128;
                int i6 = i5 % 2;
                aFa1sSDK.values("amazon_aid", values.AFInAppEventParameterName);
                aFa1sSDK.values("amazon_aid_limit", String.valueOf(values.AFInAppEventType));
            }
            String string = AppsFlyerProperties.getInstance().getString("advertiserId");
            if ((string != null ? 16 : 'G') != 'G') {
                aFa1sSDK.values("advertiserId", string);
            }
            aFa1sSDK.values("devkey", this.AFLogger.AFInAppEventType);
            aFa1sSDK.values("uid", AFb1wSDK.AFInAppEventParameterName((WeakReference<Context>) new WeakReference(context)));
            aFa1sSDK.values("af_gcm_token", this.AFLogger$LogLevel);
            aFa1sSDK.values("launch_counter", Integer.toString(this.AFVersionDeclaration.AFKeystoreWrapper("appsFlyerCount", 0)));
            aFa1sSDK.values("sdk", Integer.toString(Build.VERSION.SDK_INT));
            String AFInAppEventParameterName = AFInAppEventType.AFInAppEventParameterName(context);
            if ((AFInAppEventParameterName != null ? 'C' : 4) == 'C') {
                int i7 = onInstallConversionDataLoadedNative + 79;
                init = i7 % 128;
                int i8 = i7 % 2;
                aFa1sSDK.values("channel", AFInAppEventParameterName);
                if (i8 == 0) {
                    Throwable th3 = null;
                    super.hashCode();
                    throw th3;
                }
            }
        } else {
            AFLogger.afInfoLog("CustomerUserId not set, Tracking is disabled", true);
            throw new IllegalStateException("CustomerUserId not set, register is not sent");
        }
    }

    /* access modifiers changed from: protected */
    public final boolean afDebugLog() {
        int i = onInstallConversionDataLoadedNative + 111;
        int i2 = i % 128;
        init = i2;
        int i3 = i % 2;
        int i4 = i2 + 33;
        onInstallConversionDataLoadedNative = i4 % 128;
        if (i4 % 2 == 0) {
            return false;
        }
        Throwable th = null;
        super.hashCode();
        throw th;
    }

    private void afWarnLog() {
        int i = onInstallConversionDataLoadedNative + 117;
        init = i % 128;
        int i2 = i % 2;
        this.AFVersionDeclaration.AFInAppEventType("sentRegisterRequestToAF", true);
        AFLogger.afDebugLog("[register] Successfully registered for Uninstall Tracking");
        int i3 = onInstallConversionDataLoadedNative + 123;
        init = i3 % 128;
        if ((i3 % 2 == 0 ? ':' : 19) == ':') {
            Throwable th = null;
            super.hashCode();
            throw th;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void valueOf(byte r10, int r11, java.lang.String r12, java.lang.Object[] r13) {
        /*
            if (r12 == 0) goto L_0x0006
            char[] r12 = r12.toCharArray()
        L_0x0006:
            char[] r12 = (char[]) r12
            java.lang.Object r0 = com.appsflyer.internal.AFg1uSDK.afErrorLog
            monitor-enter(r0)
            char[] r1 = getLevel     // Catch:{ all -> 0x00f6 }
            char r2 = afWarnLog     // Catch:{ all -> 0x00f6 }
            char[] r3 = new char[r11]     // Catch:{ all -> 0x00f6 }
            int r4 = r11 % 2
            if (r4 == 0) goto L_0x001e
            int r4 = r11 + -1
            char r5 = r12[r4]     // Catch:{ all -> 0x00f6 }
            int r5 = r5 - r10
            char r5 = (char) r5     // Catch:{ all -> 0x00f6 }
            r3[r4] = r5     // Catch:{ all -> 0x00f6 }
            goto L_0x001f
        L_0x001e:
            r4 = r11
        L_0x001f:
            r5 = 0
            r6 = 1
            if (r4 <= r6) goto L_0x00e0
            com.appsflyer.internal.AFg1uSDK.values = r5     // Catch:{ all -> 0x00f6 }
        L_0x0025:
            int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            if (r7 >= r4) goto L_0x00e0
            int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            char r7 = r12[r7]     // Catch:{ all -> 0x00f6 }
            com.appsflyer.internal.AFg1uSDK.AFInAppEventType = r7     // Catch:{ all -> 0x00f6 }
            int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r6
            char r7 = r12[r7]     // Catch:{ all -> 0x00f6 }
            com.appsflyer.internal.AFg1uSDK.AFKeystoreWrapper = r7     // Catch:{ all -> 0x00f6 }
            char r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventType     // Catch:{ all -> 0x00f6 }
            char r8 = com.appsflyer.internal.AFg1uSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00f6 }
            if (r7 != r8) goto L_0x004f
            int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            char r8 = com.appsflyer.internal.AFg1uSDK.AFInAppEventType     // Catch:{ all -> 0x00f6 }
            int r8 = r8 - r10
            char r8 = (char) r8     // Catch:{ all -> 0x00f6 }
            r3[r7] = r8     // Catch:{ all -> 0x00f6 }
            int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r6
            char r8 = com.appsflyer.internal.AFg1uSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00f6 }
            int r8 = r8 - r10
            char r8 = (char) r8     // Catch:{ all -> 0x00f6 }
            r3[r7] = r8     // Catch:{ all -> 0x00f6 }
            goto L_0x00d8
        L_0x004f:
            char r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventType     // Catch:{ all -> 0x00f6 }
            int r7 = r7 / r2
            com.appsflyer.internal.AFg1uSDK.AFInAppEventParameterName = r7     // Catch:{ all -> 0x00f6 }
            char r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventType     // Catch:{ all -> 0x00f6 }
            int r7 = r7 % r2
            com.appsflyer.internal.AFg1uSDK.AFLogger = r7     // Catch:{ all -> 0x00f6 }
            char r7 = com.appsflyer.internal.AFg1uSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00f6 }
            int r7 = r7 / r2
            com.appsflyer.internal.AFg1uSDK.valueOf = r7     // Catch:{ all -> 0x00f6 }
            char r7 = com.appsflyer.internal.AFg1uSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00f6 }
            int r7 = r7 % r2
            com.appsflyer.internal.AFg1uSDK.afDebugLog = r7     // Catch:{ all -> 0x00f6 }
            int r7 = com.appsflyer.internal.AFg1uSDK.AFLogger     // Catch:{ all -> 0x00f6 }
            int r8 = com.appsflyer.internal.AFg1uSDK.afDebugLog     // Catch:{ all -> 0x00f6 }
            if (r7 != r8) goto L_0x0091
            int r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventParameterName     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r2
            int r7 = r7 - r6
            int r7 = r7 % r2
            com.appsflyer.internal.AFg1uSDK.AFInAppEventParameterName = r7     // Catch:{ all -> 0x00f6 }
            int r7 = com.appsflyer.internal.AFg1uSDK.valueOf     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r2
            int r7 = r7 - r6
            int r7 = r7 % r2
            com.appsflyer.internal.AFg1uSDK.valueOf = r7     // Catch:{ all -> 0x00f6 }
            int r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventParameterName     // Catch:{ all -> 0x00f6 }
            int r7 = r7 * r2
            int r8 = com.appsflyer.internal.AFg1uSDK.AFLogger     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r8
            int r8 = com.appsflyer.internal.AFg1uSDK.valueOf     // Catch:{ all -> 0x00f6 }
            int r8 = r8 * r2
            int r9 = com.appsflyer.internal.AFg1uSDK.afDebugLog     // Catch:{ all -> 0x00f6 }
            int r8 = r8 + r9
            int r9 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            char r7 = r1[r7]     // Catch:{ all -> 0x00f6 }
            r3[r9] = r7     // Catch:{ all -> 0x00f6 }
            int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r6
            char r8 = r1[r8]     // Catch:{ all -> 0x00f6 }
            r3[r7] = r8     // Catch:{ all -> 0x00f6 }
            goto L_0x00d8
        L_0x0091:
            int r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventParameterName     // Catch:{ all -> 0x00f6 }
            int r8 = com.appsflyer.internal.AFg1uSDK.valueOf     // Catch:{ all -> 0x00f6 }
            if (r7 != r8) goto L_0x00bf
            int r7 = com.appsflyer.internal.AFg1uSDK.AFLogger     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r2
            int r7 = r7 - r6
            int r7 = r7 % r2
            com.appsflyer.internal.AFg1uSDK.AFLogger = r7     // Catch:{ all -> 0x00f6 }
            int r7 = com.appsflyer.internal.AFg1uSDK.afDebugLog     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r2
            int r7 = r7 - r6
            int r7 = r7 % r2
            com.appsflyer.internal.AFg1uSDK.afDebugLog = r7     // Catch:{ all -> 0x00f6 }
            int r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventParameterName     // Catch:{ all -> 0x00f6 }
            int r7 = r7 * r2
            int r8 = com.appsflyer.internal.AFg1uSDK.AFLogger     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r8
            int r8 = com.appsflyer.internal.AFg1uSDK.valueOf     // Catch:{ all -> 0x00f6 }
            int r8 = r8 * r2
            int r9 = com.appsflyer.internal.AFg1uSDK.afDebugLog     // Catch:{ all -> 0x00f6 }
            int r8 = r8 + r9
            int r9 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            char r7 = r1[r7]     // Catch:{ all -> 0x00f6 }
            r3[r9] = r7     // Catch:{ all -> 0x00f6 }
            int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r6
            char r8 = r1[r8]     // Catch:{ all -> 0x00f6 }
            r3[r7] = r8     // Catch:{ all -> 0x00f6 }
            goto L_0x00d8
        L_0x00bf:
            int r7 = com.appsflyer.internal.AFg1uSDK.AFInAppEventParameterName     // Catch:{ all -> 0x00f6 }
            int r7 = r7 * r2
            int r8 = com.appsflyer.internal.AFg1uSDK.afDebugLog     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r8
            int r8 = com.appsflyer.internal.AFg1uSDK.valueOf     // Catch:{ all -> 0x00f6 }
            int r8 = r8 * r2
            int r9 = com.appsflyer.internal.AFg1uSDK.AFLogger     // Catch:{ all -> 0x00f6 }
            int r8 = r8 + r9
            int r9 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            char r7 = r1[r7]     // Catch:{ all -> 0x00f6 }
            r3[r9] = r7     // Catch:{ all -> 0x00f6 }
            int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r6
            char r8 = r1[r8]     // Catch:{ all -> 0x00f6 }
            r3[r7] = r8     // Catch:{ all -> 0x00f6 }
        L_0x00d8:
            int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + 2
            com.appsflyer.internal.AFg1uSDK.values = r7     // Catch:{ all -> 0x00f6 }
            goto L_0x0025
        L_0x00e0:
            r10 = r5
        L_0x00e1:
            if (r10 >= r11) goto L_0x00ed
            char r12 = r3[r10]     // Catch:{ all -> 0x00f6 }
            r12 = r12 ^ 13722(0x359a, float:1.9229E-41)
            char r12 = (char) r12     // Catch:{ all -> 0x00f6 }
            r3[r10] = r12     // Catch:{ all -> 0x00f6 }
            int r10 = r10 + 1
            goto L_0x00e1
        L_0x00ed:
            java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x00f6 }
            r10.<init>(r3)     // Catch:{ all -> 0x00f6 }
            monitor-exit(r0)     // Catch:{ all -> 0x00f6 }
            r13[r5] = r10
            return
        L_0x00f6:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1bSDK.valueOf(byte, int, java.lang.String, java.lang.Object[]):void");
    }
}
