package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.AFe1sSDK;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class AFe1kSDK {
    Map<String, Object> AFInAppEventParameterName;
    public volatile String AFInAppEventType;
    public volatile boolean AFKeystoreWrapper = false;
    private boolean AFLogger = false;
    private final AFe1sSDK afDebugLog;
    public volatile String valueOf;
    public final AFc1wSDK values;

    public AFe1kSDK(AFc1wSDK aFc1wSDK, AFe1sSDK aFe1sSDK) {
        this.values = aFc1wSDK;
        this.afDebugLog = aFe1sSDK;
    }

    public final boolean valueOf() {
        return this.AFKeystoreWrapper;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String AFKeystoreWrapper(com.appsflyer.internal.AFc1xSDK r10) {
        /*
            r9 = this;
            java.lang.String r0 = "use cached IMEI: "
            com.appsflyer.AppsFlyerProperties r1 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "collectIMEI"
            r3 = 0
            boolean r1 = r1.getBoolean(r2, r3)
            java.lang.String r2 = "imeiCached"
            r4 = 0
            java.lang.String r5 = r10.AFInAppEventType((java.lang.String) r2, (java.lang.String) r4)
            if (r1 == 0) goto L_0x00a9
            java.lang.String r1 = r9.valueOf
            boolean r1 = com.appsflyer.internal.AFb1pSDK.valueOf(r1)
            if (r1 == 0) goto L_0x00a9
            com.appsflyer.internal.AFc1wSDK r1 = r9.values
            android.content.Context r1 = r1.AFKeystoreWrapper
            if (r1 == 0) goto L_0x00b0
            boolean r6 = valueOf(r1)
            if (r6 == 0) goto L_0x00b0
            java.lang.String r6 = "phone"
            java.lang.Object r1 = r1.getSystemService(r6)     // Catch:{ InvocationTargetException -> 0x0081, Exception -> 0x005a }
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch:{ InvocationTargetException -> 0x0081, Exception -> 0x005a }
            java.lang.Class r6 = r1.getClass()     // Catch:{ InvocationTargetException -> 0x0081, Exception -> 0x005a }
            java.lang.String r7 = "getDeviceId"
            java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch:{ InvocationTargetException -> 0x0081, Exception -> 0x005a }
            java.lang.reflect.Method r6 = r6.getMethod(r7, r8)     // Catch:{ InvocationTargetException -> 0x0081, Exception -> 0x005a }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ InvocationTargetException -> 0x0081, Exception -> 0x005a }
            java.lang.Object r1 = r6.invoke(r1, r3)     // Catch:{ InvocationTargetException -> 0x0081, Exception -> 0x005a }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ InvocationTargetException -> 0x0081, Exception -> 0x005a }
            if (r1 == 0) goto L_0x004a
            goto L_0x00b1
        L_0x004a:
            if (r5 == 0) goto L_0x0058
            java.lang.String r1 = java.lang.String.valueOf(r5)     // Catch:{ InvocationTargetException -> 0x0081, Exception -> 0x005a }
            java.lang.String r1 = r0.concat(r1)     // Catch:{ InvocationTargetException -> 0x0081, Exception -> 0x005a }
            com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ InvocationTargetException -> 0x0081, Exception -> 0x005a }
            goto L_0x00a7
        L_0x0058:
            r5 = r4
            goto L_0x00a7
        L_0x005a:
            r1 = move-exception
            if (r5 == 0) goto L_0x0069
            java.lang.String r3 = java.lang.String.valueOf(r5)
            java.lang.String r0 = r0.concat(r3)
            com.appsflyer.AFLogger.afDebugLog(r0)
            goto L_0x006a
        L_0x0069:
            r5 = r4
        L_0x006a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "WARNING: Can't collect IMEI: other reason: "
            r0.<init>(r3)
            java.lang.String r3 = r1.getMessage()
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afErrorLog(r0, r1)
            goto L_0x00a7
        L_0x0081:
            r1 = move-exception
            if (r5 == 0) goto L_0x0090
            java.lang.String r3 = java.lang.String.valueOf(r5)
            java.lang.String r0 = r0.concat(r3)
            com.appsflyer.AFLogger.afDebugLog(r0)
            goto L_0x0091
        L_0x0090:
            r5 = r4
        L_0x0091:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "WARNING: Can't collect IMEI because of missing permissions: "
            r0.<init>(r3)
            java.lang.String r3 = r1.getMessage()
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.afErrorLog(r0, r1)
        L_0x00a7:
            r1 = r5
            goto L_0x00b1
        L_0x00a9:
            java.lang.String r0 = r9.valueOf
            if (r0 == 0) goto L_0x00b0
            java.lang.String r1 = r9.valueOf
            goto L_0x00b1
        L_0x00b0:
            r1 = r4
        L_0x00b1:
            boolean r0 = com.appsflyer.internal.AFb1pSDK.valueOf(r1)
            if (r0 != 0) goto L_0x00bb
            r10.AFKeystoreWrapper((java.lang.String) r2, (java.lang.String) r1)
            return r1
        L_0x00bb:
            java.lang.String r10 = "IMEI was not collected."
            com.appsflyer.AFLogger.afInfoLog(r10)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFe1kSDK.AFKeystoreWrapper(com.appsflyer.internal.AFc1xSDK):java.lang.String");
    }

    public final Map<String, Object> AFInAppEventParameterName() {
        HashMap hashMap = new HashMap();
        if (AFKeystoreWrapper()) {
            hashMap.put("lvl", this.AFInAppEventParameterName);
        } else if (this.AFLogger) {
            HashMap hashMap2 = new HashMap();
            this.AFInAppEventParameterName = hashMap2;
            hashMap2.put("error", "operation timed out.");
            hashMap.put("lvl", this.AFInAppEventParameterName);
        }
        return hashMap;
    }

    private boolean AFKeystoreWrapper() {
        Map<String, Object> map = this.AFInAppEventParameterName;
        return map != null && !map.isEmpty();
    }

    public final boolean values() {
        return this.AFLogger && !AFKeystoreWrapper();
    }

    public final boolean AFInAppEventType() {
        try {
            Class.forName("com.appsflyer.lvl.AppsFlyerLVL");
            final long currentTimeMillis = System.currentTimeMillis();
            AFe1sSDK aFe1sSDK = this.afDebugLog;
            Context context = this.values.AFKeystoreWrapper;
            AnonymousClass4 r6 = new AFe1sSDK.AFa1ySDK() {
                public final void valueOf(String str, String str2) {
                    AFe1kSDK.this.AFInAppEventParameterName = new ConcurrentHashMap();
                    AFe1kSDK.this.AFInAppEventParameterName.put("signedData", str);
                    AFe1kSDK.this.AFInAppEventParameterName.put("signature", str2);
                    AFe1kSDK.this.AFInAppEventParameterName.put("ttr", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AFLogger.afInfoLog("Successfully retrieved Google LVL data.");
                }

                public final void AFInAppEventParameterName(String str, Exception exc) {
                    AFe1kSDK.this.AFInAppEventParameterName = new ConcurrentHashMap();
                    String message = exc.getMessage();
                    if (message == null) {
                        message = "unknown";
                    }
                    AFe1kSDK.this.AFInAppEventParameterName.put("error", message);
                    AFLogger.afErrorLog(str, exc, true, true, false);
                }
            };
            try {
                Class<?> cls = Class.forName("com.appsflyer.lvl.AppsFlyerLVL");
                Class<?> cls2 = Class.forName("com.appsflyer.lvl.AppsFlyerLVL$resultListener");
                Method method = cls.getMethod("checkLicense", new Class[]{Long.TYPE, Context.class, cls2});
                AFe1sSDK.AnonymousClass5 r9 = new InvocationHandler(r6) {
                    private /* synthetic */ AFa1ySDK values;

                    {
                        this.values = r2;
                    }

                    public final Object invoke(Object obj, Method method, Object[] objArr) {
                        if (method.getName().equals("onLvlResult")) {
                            String str = objArr[0];
                            String str2 = str != null ? str : null;
                            String str3 = objArr[1];
                            String str4 = str3 != null ? str3 : null;
                            AFa1ySDK aFa1ySDK = this.values;
                            if (aFa1ySDK == null) {
                                AFLogger.afDebugLog("onLvlResult invocation succeeded, but listener is null");
                            } else if (str2 != null && str4 != null) {
                                aFa1ySDK.valueOf(str2, str4);
                            } else if (str4 == null) {
                                aFa1ySDK.AFInAppEventParameterName("onLvlResult with error", new Exception("AFLVL Invalid signature"));
                            } else {
                                aFa1ySDK.AFInAppEventParameterName("onLvlResult with error", new Exception("AFLVL Invalid signedData"));
                            }
                        } else if (method.getName().equals("onLvlFailure")) {
                            AFa1ySDK aFa1ySDK2 = this.values;
                            if (aFa1ySDK2 != null) {
                                Exception exc = objArr[0];
                                if (exc != null) {
                                    aFa1ySDK2.AFInAppEventParameterName("onLvlFailure with exception", exc);
                                } else {
                                    aFa1ySDK2.AFInAppEventParameterName("onLvlFailure", new Exception("unknown"));
                                }
                            } else {
                                AFLogger.afDebugLog("onLvlFailure: listener is null");
                            }
                        } else {
                            AFa1ySDK aFa1ySDK3 = this.values;
                            if (aFa1ySDK3 != null) {
                                aFa1ySDK3.AFInAppEventParameterName("lvlInvocation failed", new Exception("com.appsflyer.lvl.AppsFlyerLVL$resultListener invocation failed"));
                            }
                        }
                        return null;
                    }
                };
                method.invoke((Object) null, new Object[]{Long.valueOf(currentTimeMillis), context, Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, r9)});
            } catch (ClassNotFoundException e) {
                r6.AFInAppEventParameterName(e.getClass().getSimpleName(), e);
            } catch (NoSuchMethodException e2) {
                r6.AFInAppEventParameterName(e2.getClass().getSimpleName(), e2);
            } catch (IllegalAccessException e3) {
                r6.AFInAppEventParameterName(e3.getClass().getSimpleName(), e3);
            } catch (InvocationTargetException e4) {
                r6.AFInAppEventParameterName(e4.getClass().getSimpleName(), e4);
            }
            this.AFLogger = true;
        } catch (ClassNotFoundException unused) {
            this.AFLogger = false;
        }
        return this.AFLogger;
    }

    private static boolean valueOf(Context context) {
        if (!(AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_ANDROID_ID_FORCE_BY_USER, false) || AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.COLLECT_IMEI_FORCE_BY_USER, false))) {
            AFb1xSDK.AFInAppEventType();
            if (!AFb1xSDK.AFKeystoreWrapper(context)) {
                return true;
            }
            return false;
        }
        return true;
    }
}
