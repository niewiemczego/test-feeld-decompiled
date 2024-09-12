package com.appsflyer.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.appsflyer.AFLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

public final class AFc1lSDK implements AFb1zSDK {
    private final AFc1wSDK AFKeystoreWrapper;

    public static final List<StackTraceElement> AFInAppEventParameterName(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        StackTraceElement[] stackTrace = th.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "");
        Collection arrayList = new ArrayList();
        for (Object obj : (Object[]) stackTrace) {
            StackTraceElement stackTraceElement = (StackTraceElement) obj;
            String className = stackTraceElement.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "");
            if (!StringsKt.startsWith$default(className, "com.appsflyer", false, 2, (Object) null)) {
                stackTraceElement = null;
            }
            if (stackTraceElement != null) {
                arrayList.add(stackTraceElement);
            }
        }
        return (List) arrayList;
    }

    AFc1lSDK() {
    }

    public static Map<String, String> values(Context context) {
        HashMap hashMap = new HashMap();
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            hashMap.put("x_px", String.valueOf(displayMetrics.widthPixels));
            hashMap.put("y_px", String.valueOf(displayMetrics.heightPixels));
            hashMap.put("d_dpi", String.valueOf(displayMetrics.densityDpi));
            hashMap.put("size", String.valueOf(context.getResources().getConfiguration().screenLayout & 15));
            hashMap.put("xdp", String.valueOf(displayMetrics.xdpi));
            hashMap.put("ydp", String.valueOf(displayMetrics.ydpi));
        } catch (Throwable th) {
            AFLogger.afErrorLog("Couldn't aggregate screen stats: ", th);
        }
        return hashMap;
    }

    public AFc1lSDK(AFc1wSDK aFc1wSDK) {
        this.AFKeystoreWrapper = aFc1wSDK;
    }

    public final void AFKeystoreWrapper() {
        try {
            if (!new File(this.AFKeystoreWrapper.AFKeystoreWrapper.getFilesDir(), "AFRequestCache").exists()) {
                new File(this.AFKeystoreWrapper.AFKeystoreWrapper.getFilesDir(), "AFRequestCache").mkdir();
            }
        } catch (Exception e) {
            AFLogger.afErrorLog("CACHE: Could not create cache directory", e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d6 A[SYNTHETIC, Splitter:B:32:0x00d6] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e3 A[SYNTHETIC, Splitter:B:40:0x00e3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String AFKeystoreWrapper(com.appsflyer.internal.AFa1oSDK r8) {
        /*
            r7 = this;
            java.lang.String r0 = "AFRequestCache"
            java.lang.String r1 = "could not close cache writer"
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            com.appsflyer.internal.AFc1wSDK r4 = r7.AFKeystoreWrapper     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            android.content.Context r4 = r4.AFKeystoreWrapper     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            java.io.File r4 = r4.getFilesDir()     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            r3.<init>(r4, r0)     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            if (r4 != 0) goto L_0x001c
            r3.mkdir()     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            return r2
        L_0x001c:
            java.io.File[] r3 = r3.listFiles()     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            if (r3 == 0) goto L_0x002d
            int r3 = r3.length     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            r4 = 40
            if (r3 <= r4) goto L_0x002d
            java.lang.String r8 = "CACHE: reached cache limit, not caching request"
            com.appsflyer.AFLogger.afInfoLog(r8)     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            return r2
        L_0x002d:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            java.lang.String r4 = "CACHE: caching request with URL: "
            r3.<init>(r4)     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            java.lang.String r4 = r8.AFKeystoreWrapper     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            com.appsflyer.AFLogger.afInfoLog(r3)     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            java.lang.String r3 = java.lang.Long.toString(r3)     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            com.appsflyer.internal.AFc1wSDK r6 = r7.AFKeystoreWrapper     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            android.content.Context r6 = r6.AFKeystoreWrapper     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            java.io.File r6 = r6.getFilesDir()     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            r5.<init>(r6, r0)     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            r4.<init>(r5, r3)     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            r4.createNewFile()     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            java.lang.String r4 = r4.getPath()     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            r6 = 1
            r5.<init>(r4, r6)     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            r0.<init>(r5)     // Catch:{ Exception -> 0x00cd, all -> 0x00cb }
            java.lang.String r4 = "version="
            r0.write(r4)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r4 = r8.values     // Catch:{ Exception -> 0x00c9 }
            r0.write(r4)     // Catch:{ Exception -> 0x00c9 }
            r4 = 10
            r0.write(r4)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r5 = "url="
            r0.write(r5)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r5 = r8.AFKeystoreWrapper     // Catch:{ Exception -> 0x00c9 }
            r0.write(r5)     // Catch:{ Exception -> 0x00c9 }
            r0.write(r4)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r5 = "data="
            r0.write(r5)     // Catch:{ Exception -> 0x00c9 }
            byte[] r5 = r8.values()     // Catch:{ Exception -> 0x00c9 }
            r6 = 2
            java.lang.String r5 = android.util.Base64.encodeToString(r5, r6)     // Catch:{ Exception -> 0x00c9 }
            r0.write(r5)     // Catch:{ Exception -> 0x00c9 }
            r0.write(r4)     // Catch:{ Exception -> 0x00c9 }
            com.appsflyer.internal.AFd1sSDK r8 = r8.AFInAppEventType     // Catch:{ Exception -> 0x00c9 }
            if (r8 == 0) goto L_0x00b0
            java.lang.String r5 = "type="
            r0.write(r5)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r8 = r8.name()     // Catch:{ Exception -> 0x00c9 }
            r0.write(r8)     // Catch:{ Exception -> 0x00c9 }
            r0.write(r4)     // Catch:{ Exception -> 0x00c9 }
        L_0x00b0:
            r0.flush()     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r8 = "CACHE: done, cacheKey: "
            java.lang.String r4 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x00c9 }
            java.lang.String r8 = r8.concat(r4)     // Catch:{ Exception -> 0x00c9 }
            com.appsflyer.AFLogger.afInfoLog(r8)     // Catch:{ Exception -> 0x00c9 }
            r0.close()     // Catch:{ IOException -> 0x00c4 }
            goto L_0x00c8
        L_0x00c4:
            r8 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r1, r8)
        L_0x00c8:
            return r3
        L_0x00c9:
            r8 = move-exception
            goto L_0x00cf
        L_0x00cb:
            r8 = move-exception
            goto L_0x00e1
        L_0x00cd:
            r8 = move-exception
            r0 = r2
        L_0x00cf:
            java.lang.String r3 = "CACHE: Could not cache request"
            com.appsflyer.AFLogger.afErrorLog(r3, r8)     // Catch:{ all -> 0x00df }
            if (r0 == 0) goto L_0x00de
            r0.close()     // Catch:{ IOException -> 0x00da }
            goto L_0x00de
        L_0x00da:
            r8 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r1, r8)
        L_0x00de:
            return r2
        L_0x00df:
            r8 = move-exception
            r2 = r0
        L_0x00e1:
            if (r2 == 0) goto L_0x00eb
            r2.close()     // Catch:{ IOException -> 0x00e7 }
            goto L_0x00eb
        L_0x00e7:
            r0 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r1, r0)
        L_0x00eb:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1lSDK.AFKeystoreWrapper(com.appsflyer.internal.AFa1oSDK):java.lang.String");
    }

    public final List<AFa1oSDK> AFInAppEventType() {
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(this.AFKeystoreWrapper.AFKeystoreWrapper.getFilesDir(), "AFRequestCache");
            if (!file.exists()) {
                file.mkdir();
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return arrayList;
            }
            for (File file2 : listFiles) {
                AFLogger.afInfoLog(new StringBuilder("CACHE: Found cached request").append(file2.getName()).toString());
                arrayList.add(valueOf(file2));
            }
            return arrayList;
        } catch (Exception e) {
            AFLogger.afErrorLog("CACHE: Could not get cached requests", e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0033 A[SYNTHETIC, Splitter:B:18:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0040 A[SYNTHETIC, Splitter:B:26:0x0040] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.appsflyer.internal.AFa1oSDK valueOf(java.io.File r5) {
        /*
            java.lang.String r0 = "could not close load reader"
            r1 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ Exception -> 0x002a, all -> 0x0028 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x002a, all -> 0x0028 }
            long r3 = r5.length()     // Catch:{ Exception -> 0x0026 }
            int r3 = (int) r3     // Catch:{ Exception -> 0x0026 }
            char[] r3 = new char[r3]     // Catch:{ Exception -> 0x0026 }
            r2.read(r3)     // Catch:{ Exception -> 0x0026 }
            com.appsflyer.internal.AFa1oSDK r4 = new com.appsflyer.internal.AFa1oSDK     // Catch:{ Exception -> 0x0026 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x0026 }
            java.lang.String r5 = r5.getName()     // Catch:{ Exception -> 0x0026 }
            r4.AFInAppEventParameterName = r5     // Catch:{ Exception -> 0x0026 }
            r2.close()     // Catch:{ IOException -> 0x0021 }
            goto L_0x0025
        L_0x0021:
            r5 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r5)
        L_0x0025:
            return r4
        L_0x0026:
            r5 = move-exception
            goto L_0x002c
        L_0x0028:
            r5 = move-exception
            goto L_0x003e
        L_0x002a:
            r5 = move-exception
            r2 = r1
        L_0x002c:
            java.lang.String r3 = "error while loading request from cache"
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r3, r5)     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x003b
            r2.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r5 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r5)
        L_0x003b:
            return r1
        L_0x003c:
            r5 = move-exception
            r1 = r2
        L_0x003e:
            if (r1 == 0) goto L_0x0048
            r1.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r1 = move-exception
            com.appsflyer.AFLogger.afErrorLogForExcManagerOnly(r0, r1)
        L_0x0048:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.AFc1lSDK.valueOf(java.io.File):com.appsflyer.internal.AFa1oSDK");
    }

    public final boolean AFKeystoreWrapper(String str) {
        File file = new File(new File(this.AFKeystoreWrapper.AFKeystoreWrapper.getFilesDir(), "AFRequestCache"), str);
        AFLogger.afInfoLog(new StringBuilder("CACHE: Deleting ").append(str).append(" from cache").toString());
        if (!file.exists()) {
            return true;
        }
        try {
            return file.delete();
        } catch (Exception e) {
            AFLogger.afErrorLog(new StringBuilder("CACHE: Could not delete ").append(str).append(" from cache").toString(), e);
            return false;
        }
    }

    public final void values() {
        try {
            File file = new File(this.AFKeystoreWrapper.AFKeystoreWrapper.getFilesDir(), "AFRequestCache");
            if (!file.exists()) {
                file.mkdir();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    AFLogger.afInfoLog(new StringBuilder("CACHE: Found cached request").append(file2.getName()).toString());
                    AFLogger.afInfoLog(new StringBuilder("CACHE: Deleting ").append(file2.getName()).append(" from cache").toString());
                    file2.delete();
                }
            }
        } catch (Exception e) {
            AFLogger.afErrorLog("CACHE: Could not cache request", e);
        }
    }
}
