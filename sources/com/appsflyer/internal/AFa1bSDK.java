package com.appsflyer.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.amplitude.reactnative.AndroidContextProvider;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFc1lSDK;
import com.appsflyer.internal.AFc1qSDK;
import com.appsflyer.internal.AFc1sSDK;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class AFa1bSDK implements AFc1tSDK {
    static Boolean AFInAppEventType;
    static String values;
    private final AFc1wSDK AFKeystoreWrapper;

    public AFa1bSDK() {
    }

    public static AFc1qSDK.AFa1vSDK values(ContentResolver contentResolver) {
        String str;
        if (!AFInAppEventType() || contentResolver == null || AppsFlyerProperties.getInstance().getString("amazon_aid") != null || !"Amazon".equals(Build.MANUFACTURER)) {
            return null;
        }
        int i = Settings.Secure.getInt(contentResolver, AndroidContextProvider.SETTING_LIMIT_AD_TRACKING, 2);
        if (i == 0) {
            return new AFc1qSDK.AFa1vSDK(Settings.Secure.getString(contentResolver, AndroidContextProvider.SETTING_ADVERTISING_ID), Boolean.FALSE);
        }
        if (i == 2) {
            return null;
        }
        try {
            str = Settings.Secure.getString(contentResolver, AndroidContextProvider.SETTING_ADVERTISING_ID);
        } catch (Throwable th) {
            AFLogger.afErrorLog("Couldn't fetch Amazon Advertising ID (Ad-Tracking is limited!)", th);
            str = "";
        }
        return new AFc1qSDK.AFa1vSDK(str, Boolean.TRUE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0061 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.appsflyer.internal.AFc1qSDK.AFa1vSDK AFInAppEventParameterName(android.content.Context r5) {
        /*
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = values
            r2 = 1
            if (r1 == 0) goto L_0x000b
            r3 = r2
            goto L_0x000c
        L_0x000b:
            r3 = 0
        L_0x000c:
            r4 = 0
            if (r3 == 0) goto L_0x0011
        L_0x000f:
            r5 = r4
            goto L_0x0053
        L_0x0011:
            java.lang.Boolean r1 = AFInAppEventType
            if (r1 == 0) goto L_0x001b
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0027
        L_0x001b:
            java.lang.Boolean r1 = AFInAppEventType
            if (r1 != 0) goto L_0x0051
            java.lang.String r1 = "collectOAID"
            boolean r1 = r0.getBoolean(r1, r2)
            if (r1 == 0) goto L_0x0051
        L_0x0027:
            com.appsflyer.oaid.OaidClient r1 = new com.appsflyer.oaid.OaidClient     // Catch:{ all -> 0x0046 }
            r1.<init>(r5)     // Catch:{ all -> 0x0046 }
            boolean r5 = r0.isEnableLog()     // Catch:{ all -> 0x0046 }
            r1.setLogging(r5)     // Catch:{ all -> 0x0046 }
            com.appsflyer.oaid.OaidClient$Info r5 = r1.fetch()     // Catch:{ all -> 0x0046 }
            if (r5 == 0) goto L_0x0051
            java.lang.String r0 = r5.getId()     // Catch:{ all -> 0x0046 }
            java.lang.Boolean r5 = r5.getLat()     // Catch:{ all -> 0x0043 }
            r1 = r0
            goto L_0x0053
        L_0x0043:
            r5 = move-exception
            r1 = r0
            goto L_0x0048
        L_0x0046:
            r5 = move-exception
            r1 = r4
        L_0x0048:
            java.lang.String r0 = "No OAID library"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r5)
            com.appsflyer.AFLogger.afDebugLog(r0)
            goto L_0x000f
        L_0x0051:
            r5 = r4
            r1 = r5
        L_0x0053:
            if (r1 == 0) goto L_0x0061
            com.appsflyer.internal.AFc1qSDK$AFa1vSDK r0 = new com.appsflyer.internal.AFc1qSDK$AFa1vSDK
            r0.<init>(r1, r5)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            r0.AFKeystoreWrapper = r5
            return r0
        L_0x0061:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.AFInAppEventParameterName(android.content.Context):com.appsflyer.internal.AFc1qSDK$AFa1vSDK");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: java.lang.Object} */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0045, code lost:
        if (r8.length() == 0) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a7, code lost:
        if (r7 == 0) goto L_0x00a9;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0093 A[SYNTHETIC, Splitter:B:34:0x0093] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x012c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.appsflyer.internal.AFc1qSDK.AFa1vSDK AFInAppEventType(android.content.Context r13, java.util.Map<java.lang.String, java.lang.Object> r14) {
        /*
            java.lang.String r0 = "advertiserIdEnabled"
            java.lang.String r1 = "advertiserId"
            boolean r2 = AFInAppEventType()
            r3 = 0
            if (r2 != 0) goto L_0x000c
            return r3
        L_0x000c:
            java.lang.String r2 = "Trying to fetch GAID.."
            com.appsflyer.AFLogger.afInfoLog(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r4 = -1
            com.google.android.gms.common.GoogleApiAvailability r5 = com.google.android.gms.common.GoogleApiAvailability.getInstance()     // Catch:{ all -> 0x0020 }
            int r4 = r5.isGooglePlayServicesAvailable(r13)     // Catch:{ all -> 0x0020 }
            goto L_0x0026
        L_0x0020:
            r5 = move-exception
            java.lang.String r6 = "isGooglePlayServicesAvailable error"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r6, r5)
        L_0x0026:
            r5 = 0
            r6 = 1
            java.lang.String r7 = "com.google.android.gms.ads.identifier.AdvertisingIdClient"
            java.lang.Class.forName(r7)     // Catch:{ all -> 0x0066 }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r7 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r13)     // Catch:{ all -> 0x0066 }
            if (r7 == 0) goto L_0x0059
            java.lang.String r8 = r7.getId()     // Catch:{ all -> 0x0066 }
            boolean r7 = r7.isLimitAdTrackingEnabled()     // Catch:{ all -> 0x0052 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x0052 }
            if (r8 == 0) goto L_0x0047
            int r7 = r8.length()     // Catch:{ all -> 0x004f }
            if (r7 != 0) goto L_0x004c
        L_0x0047:
            java.lang.String r7 = "emptyOrNull |"
            r2.append(r7)     // Catch:{ all -> 0x004f }
        L_0x004c:
            r9 = r6
            goto L_0x00f8
        L_0x004f:
            r7 = move-exception
            r9 = r6
            goto L_0x0054
        L_0x0052:
            r7 = move-exception
            r9 = r5
        L_0x0054:
            r12 = r7
            r7 = r3
            r3 = r8
            r8 = r12
            goto L_0x006a
        L_0x0059:
            java.lang.String r7 = "gpsAdInfo-null |"
            r2.append(r7)     // Catch:{ all -> 0x0066 }
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0066 }
            java.lang.String r8 = "GpsAdIndo is null"
            r7.<init>(r8)     // Catch:{ all -> 0x0066 }
            throw r7     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r7 = move-exception
            r9 = r5
            r8 = r7
            r7 = r3
        L_0x006a:
            java.lang.String r10 = r8.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r10, r8)
            java.lang.Class r8 = r8.getClass()
            java.lang.String r8 = r8.getSimpleName()
            java.lang.StringBuilder r8 = r2.append(r8)
            java.lang.String r10 = " |"
            r8.append(r10)
            java.lang.String r8 = "WARNING: Google Play Services is missing."
            com.appsflyer.AFLogger.afInfoLog(r8)
            com.appsflyer.AppsFlyerProperties r8 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r11 = "enableGpsFallback"
            boolean r8 = r8.getBoolean(r11, r6)
            if (r8 == 0) goto L_0x00f6
            com.appsflyer.internal.AFa1eSDK$AFa1ySDK r3 = com.appsflyer.internal.AFa1eSDK.values(r13)     // Catch:{ all -> 0x00af }
            java.lang.String r8 = r3.values     // Catch:{ all -> 0x00af }
            boolean r3 = r3.valueOf()     // Catch:{ all -> 0x00af }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x00af }
            if (r8 == 0) goto L_0x00a9
            int r7 = r8.length()     // Catch:{ all -> 0x00af }
            if (r7 != 0) goto L_0x00f8
        L_0x00a9:
            java.lang.String r7 = "emptyOrNull (bypass) |"
            r2.append(r7)     // Catch:{ all -> 0x00af }
            goto L_0x00f8
        L_0x00af:
            r3 = move-exception
            java.lang.String r7 = r3.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r7, r3, r6, r5, r5)
            java.lang.Class r5 = r3.getClass()
            java.lang.String r5 = r5.getSimpleName()
            java.lang.StringBuilder r5 = r2.append(r5)
            r5.append(r10)
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r8 = r5.getString(r1)
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r5 = r5.getString(r0)
            boolean r5 = java.lang.Boolean.parseBoolean(r5)
            r5 = r5 ^ r6
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            java.lang.String r7 = r3.getLocalizedMessage()
            if (r7 == 0) goto L_0x00ed
            java.lang.String r3 = r3.getLocalizedMessage()
            com.appsflyer.AFLogger.afInfoLog(r3)
            goto L_0x00f4
        L_0x00ed:
            java.lang.String r3 = r3.toString()
            com.appsflyer.AFLogger.afInfoLog(r3)
        L_0x00f4:
            r3 = r5
            goto L_0x00f8
        L_0x00f6:
            r8 = r3
            r3 = r7
        L_0x00f8:
            java.lang.Class r13 = r13.getClass()
            java.lang.String r13 = r13.getName()
            java.lang.String r5 = "android.app.ReceiverRestrictedContext"
            boolean r13 = r13.equals(r5)
            if (r13 == 0) goto L_0x0126
            com.appsflyer.AppsFlyerProperties r13 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r8 = r13.getString(r1)
            com.appsflyer.AppsFlyerProperties r13 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r13 = r13.getString(r0)
            boolean r13 = java.lang.Boolean.parseBoolean(r13)
            r13 = r13 ^ r6
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r13)
            java.lang.String r13 = "context = android.app.ReceiverRestrictedContext |"
            r2.append(r13)
        L_0x0126:
            int r13 = r2.length()
            if (r13 <= 0) goto L_0x0148
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.StringBuilder r13 = r13.append(r4)
            java.lang.String r4 = ": "
            java.lang.StringBuilder r13 = r13.append(r4)
            java.lang.StringBuilder r13 = r13.append(r2)
            java.lang.String r13 = r13.toString()
            java.lang.String r2 = "gaidError"
            r14.put(r2, r13)
        L_0x0148:
            if (r8 == 0) goto L_0x017b
            if (r3 == 0) goto L_0x017b
            r14.put(r1, r8)
            boolean r13 = r3.booleanValue()
            r13 = r13 ^ r6
            java.lang.String r13 = java.lang.String.valueOf(r13)
            r14.put(r0, r13)
            com.appsflyer.AppsFlyerProperties r13 = com.appsflyer.AppsFlyerProperties.getInstance()
            r13.set((java.lang.String) r1, (java.lang.String) r8)
            com.appsflyer.AppsFlyerProperties r13 = com.appsflyer.AppsFlyerProperties.getInstance()
            boolean r1 = r3.booleanValue()
            r1 = r1 ^ r6
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r13.set((java.lang.String) r0, (java.lang.String) r1)
            java.lang.String r13 = java.lang.String.valueOf(r9)
            java.lang.String r0 = "isGaidWithGps"
            r14.put(r0, r13)
        L_0x017b:
            com.appsflyer.internal.AFc1qSDK$AFa1vSDK r13 = new com.appsflyer.internal.AFc1qSDK$AFa1vSDK
            r13.<init>(r8, r3)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.AFInAppEventType(android.content.Context, java.util.Map):com.appsflyer.internal.AFc1qSDK$AFa1vSDK");
    }

    private static boolean AFInAppEventType() {
        Boolean bool = AFInAppEventType;
        return bool == null || bool.booleanValue();
    }

    public AFa1bSDK(AFc1wSDK aFc1wSDK) {
        Intrinsics.checkNotNullParameter(aFc1wSDK, "");
        this.AFKeystoreWrapper = aFc1wSDK;
    }

    private File values() {
        Context context = this.AFKeystoreWrapper.AFKeystoreWrapper;
        if (context == null) {
            return null;
        }
        File file = new File(context.getFilesDir(), "AFExceptionsCache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private File afRDLog() {
        File values2 = values();
        if (values2 == null) {
            return null;
        }
        File file = new File(values2, "6.10.3");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final String AFInAppEventParameterName(Throwable th, String str) {
        String str2;
        Throwable th2 = th;
        String str3 = str;
        Intrinsics.checkNotNullParameter(th2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        synchronized (this) {
            File afRDLog = afRDLog();
            str2 = null;
            if (afRDLog != null) {
                try {
                    Intrinsics.checkNotNullParameter(th2, "");
                    Intrinsics.checkNotNullParameter(str3, "");
                    StringBuilder sb = new StringBuilder();
                    Intrinsics.checkNotNullParameter(th2, "");
                    String name = th.getClass().getName();
                    Intrinsics.checkNotNullExpressionValue(name, "");
                    String obj = sb.append(name).append(": ").append(str3).toString();
                    Intrinsics.checkNotNullParameter(th2, "");
                    Intrinsics.checkNotNullParameter(th2, "");
                    AFc1sSDK aFc1sSDK = new AFc1sSDK(obj, AFc1qSDK.AFa1vSDK.values(new StringBuilder().append(th2).append(10).append(CollectionsKt.joinToString$default(AFc1lSDK.AFInAppEventParameterName(th), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, AFc1lSDK.AnonymousClass3.values, 30, (Object) null)).toString()), ExceptionsKt.stackTraceToString(th), 0, 8, (DefaultConstructorMarker) null);
                    String str4 = aFc1sSDK.AFKeystoreWrapper;
                    File file = new File(afRDLog, str4);
                    if (file.exists()) {
                        AFc1sSDK.AFa1zSDK aFa1zSDK = AFc1sSDK.AFa1zSDK;
                        AFc1sSDK AFInAppEventParameterName = AFc1sSDK.AFa1zSDK.AFInAppEventParameterName(FilesKt.readText$default(file, (Charset) null, 1, (Object) null));
                        if (AFInAppEventParameterName != null) {
                            AFInAppEventParameterName.AFInAppEventParameterName++;
                            aFc1sSDK = AFInAppEventParameterName;
                        }
                    }
                    FilesKt.writeText$default(file, new StringBuilder("label=").append(AFc1qSDK.AFa1vSDK.AFKeystoreWrapper(aFc1sSDK.valueOf)).append("\nhashName=").append(AFc1qSDK.AFa1vSDK.AFKeystoreWrapper(aFc1sSDK.AFKeystoreWrapper)).append("\nstackTrace=").append(AFc1qSDK.AFa1vSDK.AFKeystoreWrapper(aFc1sSDK.AFInAppEventType)).append("\nc=").append(aFc1sSDK.AFInAppEventParameterName).toString(), (Charset) null, 2, (Object) null);
                    str2 = str4;
                } catch (Exception e) {
                    StringBuilder sb2 = new StringBuilder("Could not cache exception\n");
                    String obj2 = new StringBuilder(" ").append(e.getMessage()).toString();
                    Intrinsics.checkNotNullParameter(obj2, "");
                    AFLogger.afRDLog(sb2.append("[Exception Manager]: ".concat(String.valueOf(obj2))).toString());
                    String str5 = null;
                }
            }
        }
        return str2;
    }

    public final List<AFc1sSDK> valueOf() {
        List<AFc1sSDK> list;
        synchronized (this) {
            File afRDLog = afRDLog();
            list = null;
            if (afRDLog != null) {
                try {
                    File[] listFiles = afRDLog.listFiles();
                    if (listFiles != null) {
                        Intrinsics.checkNotNullExpressionValue(listFiles, "");
                        Collection arrayList = new ArrayList();
                        for (File file : listFiles) {
                            AFc1sSDK.AFa1zSDK aFa1zSDK = AFc1sSDK.AFa1zSDK;
                            Intrinsics.checkNotNullExpressionValue(file, "");
                            AFc1sSDK AFInAppEventParameterName = AFc1sSDK.AFa1zSDK.AFInAppEventParameterName(FilesKt.readText$default(file, (Charset) null, 1, (Object) null));
                            if (AFInAppEventParameterName != null) {
                                arrayList.add(AFInAppEventParameterName);
                            }
                        }
                        list = (List) arrayList;
                    }
                } catch (Throwable th) {
                    String obj = new StringBuilder("Could not get stored exceptions\n ").append(th.getMessage()).toString();
                    Intrinsics.checkNotNullParameter(obj, "");
                    AFLogger.afRDLog("[Exception Manager]: ".concat(String.valueOf(obj)));
                    List list2 = null;
                }
            }
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
        }
        return list;
    }

    public final int AFKeystoreWrapper() {
        int i = 0;
        for (AFc1sSDK aFc1sSDK : valueOf()) {
            i += aFc1sSDK.AFInAppEventParameterName;
        }
        return i;
    }

    public final boolean AFInAppEventParameterName() {
        return values(new String[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e3, code lost:
        if (((java.lang.Boolean) kotlin.collections.CollectionsKt.first(r15)).booleanValue() != false) goto L_0x00e5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean values(java.lang.String... r15) {
        /*
            r14 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            monitor-enter(r14)
            java.io.File r0 = r14.values()     // Catch:{ all -> 0x00e8 }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00e5
            int r3 = r15.length     // Catch:{ all -> 0x00e8 }
            if (r3 != 0) goto L_0x0013
            r3 = r2
            goto L_0x0014
        L_0x0013:
            r3 = r1
        L_0x0014:
            if (r3 == 0) goto L_0x002c
            java.lang.String r15 = "delete all exceptions"
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)     // Catch:{ all -> 0x00e8 }
            java.lang.String r1 = "[Exception Manager]: "
            java.lang.String r15 = r1.concat(r15)     // Catch:{ all -> 0x00e8 }
            com.appsflyer.AFLogger.afRDLog(r15)     // Catch:{ all -> 0x00e8 }
            boolean r1 = kotlin.io.FilesKt.deleteRecursively(r0)     // Catch:{ all -> 0x00e8 }
            goto L_0x00e6
        L_0x002c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e8 }
            java.lang.String r4 = "delete all exceptions except for: "
            r3.<init>(r4)     // Catch:{ all -> 0x00e8 }
            java.lang.String r4 = ", "
            r6 = r4
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ all -> 0x00e8 }
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 62
            r13 = 0
            r5 = r15
            java.lang.String r4 = kotlin.collections.ArraysKt.joinToString$default((java.lang.Object[]) r5, (java.lang.CharSequence) r6, (java.lang.CharSequence) r7, (java.lang.CharSequence) r8, (int) r9, (java.lang.CharSequence) r10, (kotlin.jvm.functions.Function1) r11, (int) r12, (java.lang.Object) r13)     // Catch:{ all -> 0x00e8 }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x00e8 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00e8 }
            java.lang.String r4 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)     // Catch:{ all -> 0x00e8 }
            java.lang.String r4 = "[Exception Manager]: "
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x00e8 }
            java.lang.String r3 = r4.concat(r3)     // Catch:{ all -> 0x00e8 }
            com.appsflyer.AFLogger.afRDLog(r3)     // Catch:{ all -> 0x00e8 }
            java.io.File[] r0 = r0.listFiles()     // Catch:{ all -> 0x00e8 }
            if (r0 == 0) goto L_0x00e5
            java.lang.String r3 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch:{ all -> 0x00e8 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x00e8 }
            r3.<init>()     // Catch:{ all -> 0x00e8 }
            java.util.Collection r3 = (java.util.Collection) r3     // Catch:{ all -> 0x00e8 }
            int r4 = r0.length     // Catch:{ all -> 0x00e8 }
            r5 = r1
        L_0x0073:
            if (r5 >= r4) goto L_0x0087
            r6 = r0[r5]     // Catch:{ all -> 0x00e8 }
            java.lang.String r7 = r6.getName()     // Catch:{ all -> 0x00e8 }
            boolean r7 = kotlin.collections.ArraysKt.contains((T[]) r15, r7)     // Catch:{ all -> 0x00e8 }
            if (r7 != 0) goto L_0x0084
            r3.add(r6)     // Catch:{ all -> 0x00e8 }
        L_0x0084:
            int r5 = r5 + 1
            goto L_0x0073
        L_0x0087:
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x00e8 }
            java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch:{ all -> 0x00e8 }
            java.util.ArrayList r15 = new java.util.ArrayList     // Catch:{ all -> 0x00e8 }
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r0)     // Catch:{ all -> 0x00e8 }
            r15.<init>(r0)     // Catch:{ all -> 0x00e8 }
            java.util.Collection r15 = (java.util.Collection) r15     // Catch:{ all -> 0x00e8 }
            java.util.Iterator r0 = r3.iterator()     // Catch:{ all -> 0x00e8 }
        L_0x009c:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x00e8 }
            if (r3 == 0) goto L_0x00b9
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x00e8 }
            java.io.File r3 = (java.io.File) r3     // Catch:{ all -> 0x00e8 }
            java.lang.String r4 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ all -> 0x00e8 }
            boolean r3 = kotlin.io.FilesKt.deleteRecursively(r3)     // Catch:{ all -> 0x00e8 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x00e8 }
            r15.add(r3)     // Catch:{ all -> 0x00e8 }
            goto L_0x009c
        L_0x00b9:
            java.util.List r15 = (java.util.List) r15     // Catch:{ all -> 0x00e8 }
            java.lang.Iterable r15 = (java.lang.Iterable) r15     // Catch:{ all -> 0x00e8 }
            java.util.Set r15 = kotlin.collections.CollectionsKt.toSet(r15)     // Catch:{ all -> 0x00e8 }
            java.util.Collection r15 = (java.util.Collection) r15     // Catch:{ all -> 0x00e8 }
            boolean r0 = r15.isEmpty()     // Catch:{ all -> 0x00e8 }
            if (r0 == 0) goto L_0x00cf
            java.lang.Boolean r15 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00e8 }
            java.util.Set r15 = kotlin.collections.SetsKt.setOf(r15)     // Catch:{ all -> 0x00e8 }
        L_0x00cf:
            java.util.Set r15 = (java.util.Set) r15     // Catch:{ all -> 0x00e8 }
            int r0 = r15.size()     // Catch:{ all -> 0x00e8 }
            if (r0 != r2) goto L_0x00e6
            java.lang.Iterable r15 = (java.lang.Iterable) r15     // Catch:{ all -> 0x00e8 }
            java.lang.Object r15 = kotlin.collections.CollectionsKt.first(r15)     // Catch:{ all -> 0x00e8 }
            java.lang.Boolean r15 = (java.lang.Boolean) r15     // Catch:{ all -> 0x00e8 }
            boolean r15 = r15.booleanValue()     // Catch:{ all -> 0x00e8 }
            if (r15 == 0) goto L_0x00e6
        L_0x00e5:
            r1 = r2
        L_0x00e6:
            monitor-exit(r14)
            return r1
        L_0x00e8:
            r15 = move-exception
            monitor-exit(r14)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFa1bSDK.values(java.lang.String[]):boolean");
    }
}
