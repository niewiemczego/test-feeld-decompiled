package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.ProviderInfo;

public final class AFf1lSDK extends AFf1jSDK {
    final ProviderInfo AFInAppEventParameterName;
    private final AFc1vSDK afErrorLog;

    public AFf1lSDK(ProviderInfo providerInfo, Runnable runnable, AFc1vSDK aFc1vSDK) {
        super("af_referrer", providerInfo.authority, runnable);
        this.afErrorLog = aFc1vSDK;
        this.AFInAppEventParameterName = providerInfo;
    }

    public final void values(final Context context) {
        this.afErrorLog.AFInAppEventType().execute(new Runnable() {
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0075, code lost:
                if (android.os.Build.VERSION.SDK_INT < 24) goto L_0x0086;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x0080, code lost:
                if (android.os.Build.VERSION.SDK_INT < 24) goto L_0x0086;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x0082, code lost:
                r0.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0086, code lost:
                r0.release();
             */
            /* JADX WARNING: Removed duplicated region for block: B:32:0x009b  */
            /* JADX WARNING: Removed duplicated region for block: B:43:0x00de  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                    r9 = this;
                    com.appsflyer.internal.AFf1lSDK r0 = com.appsflyer.internal.AFf1lSDK.this
                    long r1 = java.lang.System.currentTimeMillis()
                    r0.AFLogger = r1
                    com.appsflyer.internal.AFf1jSDK$AFa1wSDK r1 = com.appsflyer.internal.AFf1jSDK.AFa1wSDK.STARTED
                    r0.AFKeystoreWrapper = r1
                    com.appsflyer.internal.AFf1jSDK$4 r1 = new com.appsflyer.internal.AFf1jSDK$4
                    r1.<init>()
                    r0.addObserver(r1)
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r1 = "content://"
                    r0.<init>(r1)
                    com.appsflyer.internal.AFf1lSDK r1 = com.appsflyer.internal.AFf1lSDK.this
                    android.content.pm.ProviderInfo r1 = r1.AFInAppEventParameterName
                    java.lang.String r1 = r1.authority
                    java.lang.StringBuilder r0 = r0.append(r1)
                    java.lang.String r1 = "/transaction_id"
                    java.lang.StringBuilder r0 = r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    android.net.Uri r2 = android.net.Uri.parse(r0)
                    android.content.Context r0 = r2
                    android.content.ContentResolver r0 = r0.getContentResolver()
                    android.content.ContentProviderClient r0 = r0.acquireUnstableContentProviderClient(r2)
                    if (r0 == 0) goto L_0x0096
                    r3 = 0
                    r7 = 0
                    r8 = 24
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ DeadObjectException -> 0x0078, RemoteException -> 0x006d }
                    java.lang.String r4 = "app_id="
                    r1.<init>(r4)     // Catch:{ DeadObjectException -> 0x0078, RemoteException -> 0x006d }
                    android.content.Context r4 = r2     // Catch:{ DeadObjectException -> 0x0078, RemoteException -> 0x006d }
                    java.lang.String r4 = r4.getPackageName()     // Catch:{ DeadObjectException -> 0x0078, RemoteException -> 0x006d }
                    java.lang.StringBuilder r1 = r1.append(r4)     // Catch:{ DeadObjectException -> 0x0078, RemoteException -> 0x006d }
                    java.lang.String r4 = r1.toString()     // Catch:{ DeadObjectException -> 0x0078, RemoteException -> 0x006d }
                    r5 = 0
                    r6 = 0
                    r1 = r0
                    android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ DeadObjectException -> 0x0078, RemoteException -> 0x006d }
                    int r2 = android.os.Build.VERSION.SDK_INT
                    if (r2 < r8) goto L_0x0067
                    r0.close()
                    goto L_0x0097
                L_0x0067:
                    r0.release()
                    goto L_0x0097
                L_0x006b:
                    r1 = move-exception
                    goto L_0x008a
                L_0x006d:
                    r1 = move-exception
                    java.lang.String r2 = "[Preinstall]: Failed to query unstable content providerClient"
                    com.appsflyer.AFLogger.afErrorLog(r2, r1, r7)     // Catch:{ all -> 0x006b }
                    int r1 = android.os.Build.VERSION.SDK_INT
                    if (r1 < r8) goto L_0x0086
                    goto L_0x0082
                L_0x0078:
                    r1 = move-exception
                    java.lang.String r2 = "[Preinstall]: Failed to acquire unstable content providerClient"
                    com.appsflyer.AFLogger.afErrorLog(r2, r1, r7)     // Catch:{ all -> 0x006b }
                    int r1 = android.os.Build.VERSION.SDK_INT
                    if (r1 < r8) goto L_0x0086
                L_0x0082:
                    r0.close()
                    goto L_0x0096
                L_0x0086:
                    r0.release()
                    goto L_0x0096
                L_0x008a:
                    int r2 = android.os.Build.VERSION.SDK_INT
                    if (r2 < r8) goto L_0x0092
                    r0.close()
                    goto L_0x0095
                L_0x0092:
                    r0.release()
                L_0x0095:
                    throw r1
                L_0x0096:
                    r1 = 0
                L_0x0097:
                    java.lang.String r0 = "response"
                    if (r1 == 0) goto L_0x00de
                    java.lang.String r2 = "transaction_id"
                    int r2 = r1.getColumnIndex(r2)
                    r3 = -1
                    if (r2 != r3) goto L_0x00b3
                    java.lang.String r2 = "[Preinstall]: Wrong column name"
                    com.appsflyer.AFLogger.afWarnLog(r2)
                    com.appsflyer.internal.AFf1lSDK r2 = com.appsflyer.internal.AFf1lSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r2 = r2.AFInAppEventType
                    java.lang.String r3 = "FEATURE_NOT_SUPPORTED"
                    r2.put(r0, r3)
                    goto L_0x00da
                L_0x00b3:
                    com.appsflyer.internal.AFf1lSDK r3 = com.appsflyer.internal.AFf1lSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r3 = r3.AFInAppEventType
                    java.lang.String r4 = "OK"
                    r3.put(r0, r4)
                    boolean r0 = r1.moveToFirst()
                    if (r0 == 0) goto L_0x00da
                    java.lang.String r0 = r1.getString(r2)
                    r1.close()
                    if (r0 == 0) goto L_0x00da
                    boolean r2 = r0.isEmpty()
                    if (r2 != 0) goto L_0x00da
                    com.appsflyer.internal.AFf1lSDK r2 = com.appsflyer.internal.AFf1lSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r2 = r2.AFInAppEventType
                    java.lang.String r3 = "referrer"
                    r2.put(r3, r0)
                L_0x00da:
                    r1.close()
                    goto L_0x00ec
                L_0x00de:
                    java.lang.String r1 = "[Preinstall]: ContentProvider query failed, got null Cursor"
                    com.appsflyer.AFLogger.afWarnLog(r1)
                    com.appsflyer.internal.AFf1lSDK r1 = com.appsflyer.internal.AFf1lSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r1 = r1.AFInAppEventType
                    java.lang.String r2 = "SERVICE_UNAVAILABLE"
                    r1.put(r0, r2)
                L_0x00ec:
                    com.appsflyer.internal.AFf1lSDK r0 = com.appsflyer.internal.AFf1lSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r0 = r0.AFInAppEventType
                    android.content.Context r1 = r2
                    com.appsflyer.internal.AFf1lSDK r2 = com.appsflyer.internal.AFf1lSDK.this
                    android.content.pm.ProviderInfo r2 = r2.AFInAppEventParameterName
                    java.lang.String r2 = r2.packageName
                    long r1 = com.appsflyer.internal.AFa1cSDK.values((android.content.Context) r1, (java.lang.String) r2)
                    java.lang.Long r1 = java.lang.Long.valueOf(r1)
                    java.lang.String r2 = "api_ver"
                    r0.put(r2, r1)
                    com.appsflyer.internal.AFf1lSDK r0 = com.appsflyer.internal.AFf1lSDK.this
                    java.util.Map<java.lang.String, java.lang.Object> r0 = r0.AFInAppEventType
                    android.content.Context r1 = r2
                    com.appsflyer.internal.AFf1lSDK r2 = com.appsflyer.internal.AFf1lSDK.this
                    android.content.pm.ProviderInfo r2 = r2.AFInAppEventParameterName
                    java.lang.String r2 = r2.packageName
                    java.lang.String r1 = com.appsflyer.internal.AFa1cSDK.AFInAppEventParameterName(r1, r2)
                    java.lang.String r2 = "api_ver_name"
                    r0.put(r2, r1)
                    com.appsflyer.internal.AFf1lSDK r0 = com.appsflyer.internal.AFf1lSDK.this
                    r0.values()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFf1lSDK.AnonymousClass1.run():void");
            }
        });
    }
}
