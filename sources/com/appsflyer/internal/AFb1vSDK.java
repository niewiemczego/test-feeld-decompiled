package com.appsflyer.internal;

import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import com.amplitude.reactnative.AndroidContextProvider;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import io.sentry.SentryEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.text.Typography;

public final class AFb1vSDK implements AFb1sSDK {
    private static int AFLogger$LogLevel = 0;
    private static int AFVersionDeclaration = 1;
    private static char afDebugLog = '\u0003';
    private static char[] afInfoLog = {2, 13822, 3, 13800, 1, 13812, 4, 13819, 13816};
    private int AFInAppEventParameterName = 0;
    private boolean AFInAppEventType = true;
    private List<String> AFKeystoreWrapper = new ArrayList();
    private String AFLogger = "-1";
    private boolean afErrorLog = false;
    private boolean afRDLog = (true ^ AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false));
    private final Map<String, Object> valueOf = new HashMap();
    private final String values = "yyyy-MM-dd HH:mm:ssZ";

    public final synchronized void AFInAppEventParameterName(String str) {
        int i = AFLogger$LogLevel + 67;
        int i2 = i % 128;
        AFVersionDeclaration = i2;
        int i3 = i % 2;
        this.AFLogger = str;
        int i4 = i2 + 65;
        AFLogger$LogLevel = i4 % 128;
        if ((i4 % 2 != 0 ? 'Z' : 'O') != 'O') {
            throw null;
        }
    }

    public final synchronized void AFKeystoreWrapper() {
        boolean z = true;
        this.afErrorLog = true;
        AFInAppEventType("r_debugging_on", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        int i = AFVersionDeclaration + 91;
        AFLogger$LogLevel = i % 128;
        if (i % 2 == 0) {
            z = false;
        }
        if (z) {
            throw null;
        }
    }

    public final synchronized void valueOf() {
        boolean z = false;
        AFInAppEventType("r_debugging_off", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        this.afErrorLog = false;
        this.AFInAppEventType = false;
        int i = AFVersionDeclaration + 17;
        AFLogger$LogLevel = i % 128;
        if (i % 2 == 0) {
            z = true;
        }
        if (!z) {
            throw null;
        }
    }

    public final synchronized void AFInAppEventParameterName() {
        int i = AFLogger$LogLevel + 3;
        AFVersionDeclaration = i % 128;
        if (!(i % 2 == 0)) {
            this.valueOf.clear();
            this.AFKeystoreWrapper.clear();
            this.AFInAppEventParameterName = 0;
        } else {
            this.valueOf.clear();
            this.AFKeystoreWrapper.clear();
            this.AFInAppEventParameterName = 1;
        }
        int i2 = AFVersionDeclaration + 63;
        AFLogger$LogLevel = i2 % 128;
        int i3 = i2 % 2;
    }

    public final void values(String str, PackageManager packageManager, AFc1vSDK aFc1vSDK) {
        try {
            AFe1vSDK aFe1vSDK = new AFe1vSDK(AFInAppEventType(str, packageManager, aFc1vSDK), aFc1vSDK);
            AFd1pSDK afDebugLog2 = aFc1vSDK.afDebugLog();
            afDebugLog2.AFKeystoreWrapper.execute(new Runnable(aFe1vSDK) {
                private /* synthetic */ AFd1qSDK AFInAppEventParameterName;

                {
                    this.AFInAppEventParameterName = r2;
                }

                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                        r6 = this;
                        com.appsflyer.internal.AFd1pSDK r0 = com.appsflyer.internal.AFd1pSDK.this
                        java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r0 = r0.afDebugLog
                        monitor-enter(r0)
                        com.appsflyer.internal.AFd1pSDK r1 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                        java.util.Set<com.appsflyer.internal.AFd1qSDK<?>> r1 = r1.afRDLog     // Catch:{ all -> 0x0197 }
                        com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                        boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0197 }
                        if (r1 == 0) goto L_0x0027
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0197 }
                        java.lang.String r2 = "QUEUE: tried to add already running task: "
                        r1.<init>(r2)     // Catch:{ all -> 0x0197 }
                        com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                        java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0197 }
                        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0197 }
                        com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x0197 }
                        monitor-exit(r0)     // Catch:{ all -> 0x0197 }
                        return
                    L_0x0027:
                        com.appsflyer.internal.AFd1pSDK r1 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                        java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r1 = r1.afDebugLog     // Catch:{ all -> 0x0197 }
                        com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                        boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0197 }
                        if (r1 != 0) goto L_0x0181
                        com.appsflyer.internal.AFd1pSDK r1 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                        java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r1 = r1.AFLogger     // Catch:{ all -> 0x0197 }
                        com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                        boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0197 }
                        if (r1 == 0) goto L_0x0041
                        goto L_0x0181
                    L_0x0041:
                        com.appsflyer.internal.AFd1pSDK r1 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                        com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                        java.util.Set<com.appsflyer.internal.AFd1sSDK> r3 = r2.AFKeystoreWrapper     // Catch:{ all -> 0x0197 }
                        java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0197 }
                    L_0x004b:
                        boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0197 }
                        if (r4 == 0) goto L_0x0065
                        java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0197 }
                        com.appsflyer.internal.AFd1sSDK r4 = (com.appsflyer.internal.AFd1sSDK) r4     // Catch:{ all -> 0x0197 }
                        java.util.Set<com.appsflyer.internal.AFd1sSDK> r5 = r1.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                        boolean r5 = r5.contains(r4)     // Catch:{ all -> 0x0197 }
                        if (r5 == 0) goto L_0x004b
                        java.util.Set<com.appsflyer.internal.AFd1sSDK> r5 = r2.valueOf     // Catch:{ all -> 0x0197 }
                        r5.add(r4)     // Catch:{ all -> 0x0197 }
                        goto L_0x004b
                    L_0x0065:
                        com.appsflyer.internal.AFd1pSDK r1 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                        com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                        boolean r1 = r1.AFInAppEventType((com.appsflyer.internal.AFd1qSDK<?>) r2)     // Catch:{ all -> 0x0197 }
                        if (r1 == 0) goto L_0x007a
                        com.appsflyer.internal.AFd1pSDK r1 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                        java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r1 = r1.afDebugLog     // Catch:{ all -> 0x0197 }
                        com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                        boolean r1 = r1.add(r2)     // Catch:{ all -> 0x0197 }
                        goto L_0x009f
                    L_0x007a:
                        com.appsflyer.internal.AFd1pSDK r1 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                        java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r1 = r1.AFLogger     // Catch:{ all -> 0x0197 }
                        com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                        boolean r1 = r1.add(r2)     // Catch:{ all -> 0x0197 }
                        if (r1 == 0) goto L_0x009f
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0197 }
                        java.lang.String r3 = "QUEUE: new task was blocked: "
                        r2.<init>(r3)     // Catch:{ all -> 0x0197 }
                        com.appsflyer.internal.AFd1qSDK r3 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                        java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0197 }
                        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0197 }
                        com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ all -> 0x0197 }
                        com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                        r2.valueOf()     // Catch:{ all -> 0x0197 }
                    L_0x009f:
                        if (r1 == 0) goto L_0x00b4
                        com.appsflyer.internal.AFd1pSDK r2 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                        java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r2 = r2.afDebugLog     // Catch:{ all -> 0x0197 }
                        com.appsflyer.internal.AFd1pSDK r3 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                        java.util.List<com.appsflyer.internal.AFd1qSDK<?>> r3 = r3.afInfoLog     // Catch:{ all -> 0x0197 }
                        r2.addAll(r3)     // Catch:{ all -> 0x0197 }
                        com.appsflyer.internal.AFd1pSDK r2 = com.appsflyer.internal.AFd1pSDK.this     // Catch:{ all -> 0x0197 }
                        java.util.List<com.appsflyer.internal.AFd1qSDK<?>> r2 = r2.afInfoLog     // Catch:{ all -> 0x0197 }
                        r2.clear()     // Catch:{ all -> 0x0197 }
                        goto L_0x00c8
                    L_0x00b4:
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0197 }
                        java.lang.String r3 = "QUEUE: task not added, it's already in the queue: "
                        r2.<init>(r3)     // Catch:{ all -> 0x0197 }
                        com.appsflyer.internal.AFd1qSDK r3 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                        java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0197 }
                        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0197 }
                        com.appsflyer.AFLogger.afDebugLog(r2)     // Catch:{ all -> 0x0197 }
                    L_0x00c8:
                        monitor-exit(r0)     // Catch:{ all -> 0x0197 }
                        if (r1 == 0) goto L_0x016c
                        com.appsflyer.internal.AFd1pSDK r0 = com.appsflyer.internal.AFd1pSDK.this
                        java.util.Set<com.appsflyer.internal.AFd1sSDK> r0 = r0.AFInAppEventParameterName
                        com.appsflyer.internal.AFd1qSDK r1 = r6.AFInAppEventParameterName
                        com.appsflyer.internal.AFd1sSDK r1 = r1.values
                        r0.add(r1)
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        java.lang.String r1 = "QUEUE: new task added: "
                        r0.<init>(r1)
                        com.appsflyer.internal.AFd1qSDK r1 = r6.AFInAppEventParameterName
                        java.lang.StringBuilder r0 = r0.append(r1)
                        java.lang.String r0 = r0.toString()
                        com.appsflyer.AFLogger.afDebugLog(r0)
                        com.appsflyer.internal.AFd1pSDK r0 = com.appsflyer.internal.AFd1pSDK.this
                        java.util.List<com.appsflyer.internal.AFd1wSDK> r0 = r0.valueOf
                        java.util.Iterator r0 = r0.iterator()
                    L_0x00f2:
                        boolean r1 = r0.hasNext()
                        if (r1 == 0) goto L_0x00ff
                        java.lang.Object r1 = r0.next()
                        com.appsflyer.internal.AFd1wSDK r1 = (com.appsflyer.internal.AFd1wSDK) r1
                        goto L_0x00f2
                    L_0x00ff:
                        com.appsflyer.internal.AFd1pSDK r0 = com.appsflyer.internal.AFd1pSDK.this
                        java.util.concurrent.ExecutorService r1 = r0.AFInAppEventType
                        r1.submit(r0)
                        com.appsflyer.internal.AFd1pSDK r0 = com.appsflyer.internal.AFd1pSDK.this
                        java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r1 = r0.afDebugLog
                        monitor-enter(r1)
                        java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r2 = r0.afDebugLog     // Catch:{ all -> 0x0169 }
                        int r2 = r2.size()     // Catch:{ all -> 0x0169 }
                        java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r3 = r0.AFLogger     // Catch:{ all -> 0x0169 }
                        int r3 = r3.size()     // Catch:{ all -> 0x0169 }
                        int r2 = r2 + r3
                        int r2 = r2 + -40
                    L_0x011a:
                        if (r2 <= 0) goto L_0x0167
                        java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r3 = r0.AFLogger     // Catch:{ all -> 0x0169 }
                        boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0169 }
                        r4 = 1
                        if (r3 != 0) goto L_0x0127
                        r3 = r4
                        goto L_0x0128
                    L_0x0127:
                        r3 = 0
                    L_0x0128:
                        java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r5 = r0.afDebugLog     // Catch:{ all -> 0x0169 }
                        boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0169 }
                        r4 = r4 ^ r5
                        if (r4 == 0) goto L_0x0155
                        if (r3 == 0) goto L_0x0155
                        java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r3 = r0.afDebugLog     // Catch:{ all -> 0x0169 }
                        java.lang.Object r3 = r3.first()     // Catch:{ all -> 0x0169 }
                        com.appsflyer.internal.AFd1qSDK r3 = (com.appsflyer.internal.AFd1qSDK) r3     // Catch:{ all -> 0x0169 }
                        java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r4 = r0.AFLogger     // Catch:{ all -> 0x0169 }
                        java.lang.Object r4 = r4.first()     // Catch:{ all -> 0x0169 }
                        com.appsflyer.internal.AFd1qSDK r4 = (com.appsflyer.internal.AFd1qSDK) r4     // Catch:{ all -> 0x0169 }
                        int r3 = r3.compareTo(r4)     // Catch:{ all -> 0x0169 }
                        if (r3 <= 0) goto L_0x014f
                        java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r3 = r0.afDebugLog     // Catch:{ all -> 0x0169 }
                        r0.AFKeystoreWrapper(r3)     // Catch:{ all -> 0x0169 }
                        goto L_0x0164
                    L_0x014f:
                        java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r3 = r0.AFLogger     // Catch:{ all -> 0x0169 }
                        r0.AFKeystoreWrapper(r3)     // Catch:{ all -> 0x0169 }
                        goto L_0x0164
                    L_0x0155:
                        if (r4 == 0) goto L_0x015d
                        java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r3 = r0.afDebugLog     // Catch:{ all -> 0x0169 }
                        r0.AFKeystoreWrapper(r3)     // Catch:{ all -> 0x0169 }
                        goto L_0x0164
                    L_0x015d:
                        if (r3 == 0) goto L_0x0164
                        java.util.NavigableSet<com.appsflyer.internal.AFd1qSDK<?>> r3 = r0.AFLogger     // Catch:{ all -> 0x0169 }
                        r0.AFKeystoreWrapper(r3)     // Catch:{ all -> 0x0169 }
                    L_0x0164:
                        int r2 = r2 + -1
                        goto L_0x011a
                    L_0x0167:
                        monitor-exit(r1)     // Catch:{ all -> 0x0169 }
                        return
                    L_0x0169:
                        r0 = move-exception
                        monitor-exit(r1)
                        throw r0
                    L_0x016c:
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        java.lang.String r1 = "QUEUE: tried to add already pending task: "
                        r0.<init>(r1)
                        com.appsflyer.internal.AFd1qSDK r1 = r6.AFInAppEventParameterName
                        java.lang.StringBuilder r0 = r0.append(r1)
                        java.lang.String r0 = r0.toString()
                        com.appsflyer.AFLogger.afWarnLog(r0)
                        return
                    L_0x0181:
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0197 }
                        java.lang.String r2 = "QUEUE: tried to add already scheduled task: "
                        r1.<init>(r2)     // Catch:{ all -> 0x0197 }
                        com.appsflyer.internal.AFd1qSDK r2 = r6.AFInAppEventParameterName     // Catch:{ all -> 0x0197 }
                        java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0197 }
                        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0197 }
                        com.appsflyer.AFLogger.afDebugLog(r1)     // Catch:{ all -> 0x0197 }
                        monitor-exit(r0)     // Catch:{ all -> 0x0197 }
                        return
                    L_0x0197:
                        r1 = move-exception
                        monitor-exit(r0)
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFd1pSDK.AnonymousClass5.run():void");
                }
            });
            int i = AFVersionDeclaration + 33;
            AFLogger$LogLevel = i % 128;
            int i2 = i % 2;
        } catch (Throwable th) {
            AFLogger.afErrorLogForExcManagerOnly("could not send proxy data", th);
        }
    }

    private Map<String, Object> AFInAppEventType(String str, PackageManager packageManager, AFc1vSDK aFc1vSDK) {
        int i = AFVersionDeclaration + 55;
        AFLogger$LogLevel = i % 128;
        int i2 = i % 2;
        valueOf(str, packageManager, aFc1vSDK.afWarnLog());
        Map<String, Object> AFLogger2 = AFLogger();
        int i3 = AFVersionDeclaration + 113;
        AFLogger$LogLevel = i3 % 128;
        if ((i3 % 2 != 0 ? '4' : 'N') != '4') {
            return AFLogger2;
        }
        int i4 = 61 / 0;
        return AFLogger2;
    }

    private boolean afErrorLog() {
        int i = AFLogger$LogLevel;
        int i2 = i + 53;
        AFVersionDeclaration = i2 % 128;
        Throwable th = null;
        if (!(i2 % 2 == 0)) {
            if ((this.afRDLog ? 20 : Typography.less) == 20) {
                if (!this.AFInAppEventType) {
                    int i3 = i + 119;
                    AFVersionDeclaration = i3 % 128;
                    if (i3 % 2 != 0) {
                        if ((this.afErrorLog ? '\'' : 15) != '\'') {
                            return false;
                        }
                    } else {
                        super.hashCode();
                        throw th;
                    }
                }
                return true;
            }
            return false;
        }
        super.hashCode();
        throw th;
    }

    private synchronized void values(String str, String str2, String str3) {
        int i = AFVersionDeclaration + 37;
        AFLogger$LogLevel = i % 128;
        int i2 = i % 2;
        try {
            Map<String, Object> map = this.valueOf;
            boolean z = false;
            Object[] objArr = new Object[1];
            AFKeystoreWrapper(View.resolveSizeAndState(0, 0, 0) + 5, (byte) (25 - (ViewConfiguration.getScrollBarSize() >> 8)), "\u0006\u0005\b\u0004㘗", objArr);
            map.put(((String) objArr[0]).intern(), Build.BRAND);
            this.valueOf.put("model", Build.MODEL);
            this.valueOf.put("platform", AndroidContextProvider.PLATFORM);
            this.valueOf.put("platform_version", Build.VERSION.RELEASE);
            if ((str != null ? 'Q' : '<') != '<') {
                int i3 = AFVersionDeclaration + 125;
                AFLogger$LogLevel = i3 % 128;
                if (i3 % 2 != 0) {
                    str.length();
                    throw null;
                } else if (str.length() > 0) {
                    this.valueOf.put("advertiserId", str);
                }
            }
            if ((str2 != null) && str2.length() > 0) {
                int i4 = AFVersionDeclaration + 69;
                AFLogger$LogLevel = i4 % 128;
                int i5 = i4 % 2;
                this.valueOf.put("imei", str2);
            }
            if (str3 != null) {
                z = true;
            }
            if (z) {
                int i6 = AFVersionDeclaration + 117;
                AFLogger$LogLevel = i6 % 128;
                int i7 = i6 % 2;
                if (str3.length() > 0) {
                    this.valueOf.put("android_id", str3);
                }
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized void valueOf(String str, String str2, String str3, String str4) {
        try {
            this.valueOf.put("sdk_version", str);
            if (str2 != null) {
                int i = AFLogger$LogLevel + 91;
                AFVersionDeclaration = i % 128;
                if ((i % 2 == 0 ? 20 : '8') != 20) {
                    if ((str2.length() > 0 ? ' ' : '&') != '&') {
                        this.valueOf.put("devkey", str2);
                    }
                } else {
                    str2.length();
                    throw null;
                }
            }
            if (str3 != null && str3.length() > 0) {
                this.valueOf.put("originalAppsFlyerId", str3);
                int i2 = AFVersionDeclaration + 17;
                AFLogger$LogLevel = i2 % 128;
                int i3 = i2 % 2;
            }
            if (str4 != null) {
                if (str4.length() > 0) {
                    this.valueOf.put("uid", str4);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        if (r5.length() > 0) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void values(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x0038
            int r2 = AFVersionDeclaration     // Catch:{ all -> 0x0036 }
            int r2 = r2 + 105
            int r3 = r2 % 128
            AFLogger$LogLevel = r3     // Catch:{ all -> 0x0036 }
            int r2 = r2 % 2
            r3 = 15
            if (r2 == 0) goto L_0x0015
            r2 = r3
            goto L_0x0017
        L_0x0015:
            r2 = 23
        L_0x0017:
            if (r2 == r3) goto L_0x0025
            int r2 = r5.length()     // Catch:{ all -> 0x0092 }
            if (r2 <= 0) goto L_0x0021
            r2 = r1
            goto L_0x0022
        L_0x0021:
            r2 = r0
        L_0x0022:
            if (r2 == 0) goto L_0x002e
            goto L_0x0038
        L_0x0025:
            int r2 = r5.length()     // Catch:{ all -> 0x0092 }
            r3 = 34
            int r3 = r3 / r1
            if (r2 <= 0) goto L_0x0038
        L_0x002e:
            java.util.Map<java.lang.String, java.lang.Object> r2 = r4.valueOf     // Catch:{ all -> 0x0092 }
            java.lang.String r3 = "app_id"
            r2.put(r3, r5)     // Catch:{ all -> 0x0092 }
            goto L_0x0038
        L_0x0036:
            r5 = move-exception
            goto L_0x0090
        L_0x0038:
            r5 = 99
            if (r6 == 0) goto L_0x003e
            r2 = 4
            goto L_0x003f
        L_0x003e:
            r2 = r5
        L_0x003f:
            if (r2 == r5) goto L_0x004e
            int r5 = r6.length()     // Catch:{ all -> 0x0092 }
            if (r5 <= 0) goto L_0x004e
            java.util.Map<java.lang.String, java.lang.Object> r5 = r4.valueOf     // Catch:{ all -> 0x0092 }
            java.lang.String r2 = "app_version"
            r5.put(r2, r6)     // Catch:{ all -> 0x0092 }
        L_0x004e:
            if (r7 == 0) goto L_0x005d
            int r5 = r7.length()     // Catch:{ all -> 0x0092 }
            if (r5 <= 0) goto L_0x005d
            java.util.Map<java.lang.String, java.lang.Object> r5 = r4.valueOf     // Catch:{ all -> 0x0092 }
            java.lang.String r6 = "channel"
            r5.put(r6, r7)     // Catch:{ all -> 0x0092 }
        L_0x005d:
            if (r8 == 0) goto L_0x0094
            int r5 = r8.length()     // Catch:{ all -> 0x0092 }
            if (r5 <= 0) goto L_0x0067
            r5 = r1
            goto L_0x0068
        L_0x0067:
            r5 = r0
        L_0x0068:
            if (r5 == r0) goto L_0x0094
            int r5 = AFVersionDeclaration     // Catch:{ all -> 0x0036 }
            int r5 = r5 + 117
            int r6 = r5 % 128
            AFLogger$LogLevel = r6     // Catch:{ all -> 0x0036 }
            int r5 = r5 % 2
            r6 = 56
            if (r5 == 0) goto L_0x007a
            r5 = r6
            goto L_0x007b
        L_0x007a:
            r5 = 5
        L_0x007b:
            if (r5 == r6) goto L_0x0085
            java.util.Map<java.lang.String, java.lang.Object> r5 = r4.valueOf     // Catch:{ all -> 0x0092 }
            java.lang.String r6 = "preInstall"
            r5.put(r6, r8)     // Catch:{ all -> 0x0092 }
            goto L_0x0094
        L_0x0085:
            java.util.Map<java.lang.String, java.lang.Object> r5 = r4.valueOf     // Catch:{ all -> 0x0092 }
            java.lang.String r6 = "preInstall"
            r5.put(r6, r8)     // Catch:{ all -> 0x0092 }
            r5 = 74
            int r5 = r5 / r1
            goto L_0x0094
        L_0x0090:
            monitor-exit(r4)
            throw r5
        L_0x0092:
            monitor-exit(r4)
            return
        L_0x0094:
            monitor-exit(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1vSDK.values(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    public final void values(String str, String... strArr) {
        int i = AFVersionDeclaration + 93;
        AFLogger$LogLevel = i % 128;
        boolean z = i % 2 != 0;
        AFInAppEventType("public_api_call", str, strArr);
        if (!z) {
            int i2 = AFVersionDeclaration + 79;
            AFLogger$LogLevel = i2 % 128;
            int i3 = i2 % 2;
            return;
        }
        throw null;
    }

    public final void values(Throwable th) {
        String str;
        int i = AFVersionDeclaration + 25;
        AFLogger$LogLevel = i % 128;
        Throwable th2 = null;
        if ((i % 2 != 0 ? 'I' : Typography.quote) != 'I') {
            Throwable cause = th.getCause();
            String simpleName = th.getClass().getSimpleName();
            if ((cause == null ? (char) 4 : 19) != 19) {
                int i2 = AFVersionDeclaration + 5;
                AFLogger$LogLevel = i2 % 128;
                if ((i2 % 2 != 0 ? '<' : 8) != '<') {
                    str = th.getMessage();
                } else {
                    th.getMessage();
                    super.hashCode();
                    throw th2;
                }
            } else {
                str = cause.getMessage();
            }
            AFInAppEventType(SentryEvent.JsonKeys.EXCEPTION, simpleName, AFInAppEventType(str, cause == null ? th.getStackTrace() : cause.getStackTrace()));
            int i3 = AFLogger$LogLevel + 47;
            AFVersionDeclaration = i3 % 128;
            if (i3 % 2 == 0) {
                throw th2;
            }
            return;
        }
        th.getCause();
        th.getClass().getSimpleName();
        super.hashCode();
        throw th2;
    }

    public final void AFInAppEventParameterName(String str, String str2) {
        int i = AFVersionDeclaration + 61;
        AFLogger$LogLevel = i % 128;
        int i2 = i % 2;
        AFInAppEventType("server_request", str, str2);
        int i3 = AFLogger$LogLevel + 63;
        AFVersionDeclaration = i3 % 128;
        int i4 = i3 % 2;
    }

    public final void values(String str, int i, String str2) {
        int i2 = AFLogger$LogLevel + 107;
        AFVersionDeclaration = i2 % 128;
        if ((i2 % 2 == 0 ? 4 : 'T') != 'T') {
            String[] strArr = new String[5];
            strArr[0] = String.valueOf(i);
            strArr[0] = str2;
            AFInAppEventType("server_response", str, strArr);
            return;
        }
        AFInAppEventType("server_response", str, String.valueOf(i), str2);
    }

    public final void values(String str, String str2) {
        int i = AFVersionDeclaration + 67;
        AFLogger$LogLevel = i % 128;
        int i2 = i % 2;
        AFInAppEventType((String) null, str, str2);
        int i3 = AFLogger$LogLevel + 49;
        AFVersionDeclaration = i3 % 128;
        if ((i3 % 2 == 0 ? 'A' : Typography.amp) == 'A') {
            throw null;
        }
    }

    private synchronized void AFInAppEventType(String str, String str2, String... strArr) {
        String str3;
        if ((afErrorLog() ? '=' : 22) == '=') {
            int i = AFLogger$LogLevel + 55;
            AFVersionDeclaration = i % 128;
            int i2 = i % 2;
            if (this.AFInAppEventParameterName < 98304) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    String join = TextUtils.join(", ", strArr);
                    if (str != null) {
                        str3 = new StringBuilder().append(currentTimeMillis).append(" ").append(Thread.currentThread().getId()).append(" _/AppsFlyer_6.10.3 [").append(str).append("] ").append(str2).append(" ").append(join).toString();
                        int i3 = AFLogger$LogLevel + 51;
                        AFVersionDeclaration = i3 % 128;
                        int i4 = i3 % 2;
                    } else {
                        str3 = new StringBuilder().append(currentTimeMillis).append(" ").append(Thread.currentThread().getId()).append(" ").append(str2).append("/AppsFlyer_6.10.3 ").append(join).toString();
                    }
                    this.AFKeystoreWrapper.add(str3);
                    this.AFInAppEventParameterName += str3.length() << 1;
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
        }
        int i5 = AFLogger$LogLevel + 45;
        AFVersionDeclaration = i5 % 128;
        int i6 = i5 % 2;
    }

    private synchronized Map<String, Object> AFLogger() {
        int i = AFLogger$LogLevel + 101;
        AFVersionDeclaration = i % 128;
        if (!(i % 2 == 0)) {
            this.valueOf.put("data", this.AFKeystoreWrapper);
            afDebugLog();
        } else {
            this.valueOf.put("data", this.AFKeystoreWrapper);
            afDebugLog();
            Throwable th = null;
            super.hashCode();
            throw th;
        }
        return this.valueOf;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:8|9|10|11|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x008a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void valueOf(java.lang.String r6, android.content.pm.PackageManager r7, com.appsflyer.internal.AFe1kSDK r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = AFLogger$LogLevel     // Catch:{ all -> 0x00a3 }
            int r0 = r0 + 39
            int r1 = r0 % 128
            AFVersionDeclaration = r1     // Catch:{ all -> 0x00a3 }
            int r0 = r0 % 2
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x00a3 }
            java.lang.String r1 = "remote_debug_static_data"
            java.lang.String r2 = r0.getString(r1)     // Catch:{ all -> 0x00a3 }
            java.util.Map<java.lang.String, java.lang.Object> r3 = r5.valueOf     // Catch:{ all -> 0x00a3 }
            r3.clear()     // Catch:{ all -> 0x00a3 }
            if (r2 == 0) goto L_0x0035
            java.util.Map<java.lang.String, java.lang.Object> r6 = r5.valueOf     // Catch:{ all -> 0x0098 }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ all -> 0x0098 }
            r7.<init>((java.lang.String) r2)     // Catch:{ all -> 0x0098 }
            java.util.Map r7 = com.appsflyer.internal.AFa1oSDK.AFInAppEventType(r7)     // Catch:{ all -> 0x0098 }
            r6.putAll(r7)     // Catch:{ all -> 0x0098 }
            int r6 = AFLogger$LogLevel     // Catch:{ all -> 0x00a3 }
            int r6 = r6 + 117
            int r7 = r6 % 128
            AFVersionDeclaration = r7     // Catch:{ all -> 0x00a3 }
            int r6 = r6 % 2
            goto L_0x0098
        L_0x0035:
            com.appsflyer.internal.AFb1xSDK r2 = com.appsflyer.internal.AFb1xSDK.AFInAppEventType()     // Catch:{ all -> 0x00a3 }
            java.lang.String r3 = "advertiserId"
            java.lang.String r3 = r0.getString(r3)     // Catch:{ all -> 0x00a3 }
            java.lang.String r8 = r8.valueOf     // Catch:{ all -> 0x00a3 }
            java.lang.String r4 = r2.afInfoLog     // Catch:{ all -> 0x00a3 }
            r5.values((java.lang.String) r3, (java.lang.String) r8, (java.lang.String) r4)     // Catch:{ all -> 0x00a3 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a3 }
            java.lang.String r3 = "6.10.3."
            r8.<init>(r3)     // Catch:{ all -> 0x00a3 }
            java.lang.String r3 = com.appsflyer.internal.AFb1xSDK.AFInAppEventParameterName     // Catch:{ all -> 0x00a3 }
            java.lang.StringBuilder r8 = r8.append(r3)     // Catch:{ all -> 0x00a3 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00a3 }
            com.appsflyer.internal.AFc1vSDK r2 = r2.AFKeystoreWrapper()     // Catch:{ all -> 0x00a3 }
            com.appsflyer.internal.AFe1kSDK r2 = r2.afWarnLog()     // Catch:{ all -> 0x00a3 }
            java.lang.String r2 = r2.AFInAppEventType     // Catch:{ all -> 0x00a3 }
            java.lang.String r3 = "KSAppsFlyerId"
            java.lang.String r3 = r0.getString(r3)     // Catch:{ all -> 0x00a3 }
            java.lang.String r4 = "uid"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ all -> 0x00a3 }
            r5.valueOf(r8, r2, r3, r4)     // Catch:{ all -> 0x00a3 }
            r8 = 0
            android.content.pm.PackageInfo r7 = r7.getPackageInfo(r6, r8)     // Catch:{ all -> 0x008a }
            int r7 = r7.versionCode     // Catch:{ all -> 0x008a }
            java.lang.String r8 = "channel"
            java.lang.String r8 = r0.getString(r8)     // Catch:{ all -> 0x008a }
            java.lang.String r2 = "preInstallName"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x008a }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x008a }
            r5.values(r6, r7, r8, r2)     // Catch:{ all -> 0x008a }
        L_0x008a:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x00a3 }
            java.util.Map<java.lang.String, java.lang.Object> r7 = r5.valueOf     // Catch:{ all -> 0x00a3 }
            r6.<init>((java.util.Map<?, ?>) r7)     // Catch:{ all -> 0x00a3 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00a3 }
            r0.set((java.lang.String) r1, (java.lang.String) r6)     // Catch:{ all -> 0x00a3 }
        L_0x0098:
            java.util.Map<java.lang.String, java.lang.Object> r6 = r5.valueOf     // Catch:{ all -> 0x00a3 }
            java.lang.String r7 = "launch_counter"
            java.lang.String r8 = r5.AFLogger     // Catch:{ all -> 0x00a3 }
            r6.put(r7, r8)     // Catch:{ all -> 0x00a3 }
            monitor-exit(r5)
            return
        L_0x00a3:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1vSDK.valueOf(java.lang.String, android.content.pm.PackageManager, com.appsflyer.internal.AFe1kSDK):void");
    }

    private static String[] AFInAppEventType(String str, StackTraceElement[] stackTraceElementArr) {
        int i = AFLogger$LogLevel + 75;
        AFVersionDeclaration = i % 128;
        if (i % 2 != 0) {
            int i2 = 1;
            if (!(stackTraceElementArr == null)) {
                String[] strArr = new String[(stackTraceElementArr.length + 1)];
                strArr[0] = str;
                while (true) {
                    if ((i2 < stackTraceElementArr.length ? 'V' : ',') == ',') {
                        return strArr;
                    }
                    strArr[i2] = stackTraceElementArr[i2].toString();
                    i2++;
                    int i3 = AFLogger$LogLevel + 29;
                    AFVersionDeclaration = i3 % 128;
                    int i4 = i3 % 2;
                }
            } else {
                return new String[]{str};
            }
        } else {
            Throwable th = null;
            super.hashCode();
            throw th;
        }
    }

    private synchronized void afDebugLog() {
        this.AFKeystoreWrapper = new ArrayList();
        this.AFInAppEventParameterName = 0;
        int i = AFLogger$LogLevel + 125;
        AFVersionDeclaration = i % 128;
        if ((i % 2 == 0 ? 'X' : '5') != '5') {
            int i2 = 93 / 0;
        }
    }

    public final synchronized void values() {
        char c = '\'';
        int i = AFVersionDeclaration + 39;
        AFLogger$LogLevel = i % 128;
        if (i % 2 != 0) {
            c = '5';
        }
        boolean z = false;
        if (c != '5') {
            this.AFInAppEventType = false;
        } else {
            this.AFInAppEventType = true;
        }
        afDebugLog();
        int i2 = AFLogger$LogLevel + 95;
        AFVersionDeclaration = i2 % 128;
        if (i2 % 2 == 0) {
            z = true;
        }
        if (z) {
            throw null;
        }
    }

    public final void AFInAppEventType() {
        int i = AFLogger$LogLevel;
        int i2 = i + 75;
        AFVersionDeclaration = i2 % 128;
        int i3 = i2 % 2;
        this.afRDLog = false;
        int i4 = i + 23;
        AFVersionDeclaration = i4 % 128;
        if ((i4 % 2 == 0 ? (char) 9 : 22) != 22) {
            throw null;
        }
    }

    public final boolean afInfoLog() {
        int i = AFLogger$LogLevel + 25;
        AFVersionDeclaration = i % 128;
        if (i % 2 != 0) {
            return this.afErrorLog;
        }
        Throwable th = null;
        super.hashCode();
        throw th;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: char[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: java.lang.String} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void AFKeystoreWrapper(int r10, byte r11, java.lang.String r12, java.lang.Object[] r13) {
        /*
            if (r12 == 0) goto L_0x0006
            char[] r12 = r12.toCharArray()
        L_0x0006:
            char[] r12 = (char[]) r12
            java.lang.Object r0 = com.appsflyer.internal.AFg1uSDK.afErrorLog
            monitor-enter(r0)
            char[] r1 = afInfoLog     // Catch:{ all -> 0x00f6 }
            char r2 = afDebugLog     // Catch:{ all -> 0x00f6 }
            char[] r3 = new char[r10]     // Catch:{ all -> 0x00f6 }
            int r4 = r10 % 2
            if (r4 == 0) goto L_0x001e
            int r4 = r10 + -1
            char r5 = r12[r4]     // Catch:{ all -> 0x00f6 }
            int r5 = r5 - r11
            char r5 = (char) r5     // Catch:{ all -> 0x00f6 }
            r3[r4] = r5     // Catch:{ all -> 0x00f6 }
            goto L_0x001f
        L_0x001e:
            r4 = r10
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
            int r8 = r8 - r11
            char r8 = (char) r8     // Catch:{ all -> 0x00f6 }
            r3[r7] = r8     // Catch:{ all -> 0x00f6 }
            int r7 = com.appsflyer.internal.AFg1uSDK.values     // Catch:{ all -> 0x00f6 }
            int r7 = r7 + r6
            char r8 = com.appsflyer.internal.AFg1uSDK.AFKeystoreWrapper     // Catch:{ all -> 0x00f6 }
            int r8 = r8 - r11
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
            r11 = r5
        L_0x00e1:
            if (r11 >= r10) goto L_0x00ed
            char r12 = r3[r11]     // Catch:{ all -> 0x00f6 }
            r12 = r12 ^ 13722(0x359a, float:1.9229E-41)
            char r12 = (char) r12     // Catch:{ all -> 0x00f6 }
            r3[r11] = r12     // Catch:{ all -> 0x00f6 }
            int r11 = r11 + 1
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
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFb1vSDK.AFKeystoreWrapper(int, byte, java.lang.String, java.lang.Object[]):void");
    }
}
