package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.StrictMode;
import android.util.Log;
import com.google.common.base.Optional;
import java.io.File;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzgj {
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        throw r11;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x00d2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.measurement.zzgh zza(android.content.Context r11, java.io.File r12) {
        /*
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00d3 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00d3 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00d3 }
            r2.<init>(r12)     // Catch:{ IOException -> 0x00d3 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x00d3 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x00d3 }
            r1 = 0
            r2 = 1
            androidx.collection.SimpleArrayMap r3 = new androidx.collection.SimpleArrayMap     // Catch:{ all -> 0x00b7 }
            r3.<init>()     // Catch:{ all -> 0x00b7 }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x00b7 }
            r4.<init>()     // Catch:{ all -> 0x00b7 }
        L_0x001b:
            java.lang.String r5 = r0.readLine()     // Catch:{ all -> 0x00b7 }
            java.lang.String r6 = "HermeticFileOverrides"
            if (r5 == 0) goto L_0x008a
            java.lang.String r7 = " "
            r8 = 3
            java.lang.String[] r7 = r5.split(r7, r8)     // Catch:{ all -> 0x00b7 }
            int r9 = r7.length     // Catch:{ all -> 0x00b7 }
            if (r9 == r8) goto L_0x0040
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b7 }
            java.lang.String r8 = "Invalid: "
            r7.<init>(r8)     // Catch:{ all -> 0x00b7 }
            java.lang.StringBuilder r5 = r7.append(r5)     // Catch:{ all -> 0x00b7 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00b7 }
            android.util.Log.e(r6, r5)     // Catch:{ all -> 0x00b7 }
            goto L_0x001b
        L_0x0040:
            r5 = r7[r1]     // Catch:{ all -> 0x00b7 }
            java.lang.String r5 = zza((java.lang.String) r5)     // Catch:{ all -> 0x00b7 }
            r6 = r7[r2]     // Catch:{ all -> 0x00b7 }
            java.lang.String r6 = zza((java.lang.String) r6)     // Catch:{ all -> 0x00b7 }
            java.lang.String r6 = android.net.Uri.decode(r6)     // Catch:{ all -> 0x00b7 }
            r8 = 2
            r9 = r7[r8]     // Catch:{ all -> 0x00b7 }
            java.lang.Object r9 = r4.get(r9)     // Catch:{ all -> 0x00b7 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x00b7 }
            if (r9 != 0) goto L_0x0072
            r7 = r7[r8]     // Catch:{ all -> 0x00b7 }
            java.lang.String r7 = zza((java.lang.String) r7)     // Catch:{ all -> 0x00b7 }
            java.lang.String r9 = android.net.Uri.decode(r7)     // Catch:{ all -> 0x00b7 }
            int r8 = r9.length()     // Catch:{ all -> 0x00b7 }
            r10 = 1024(0x400, float:1.435E-42)
            if (r8 < r10) goto L_0x006f
            if (r9 != r7) goto L_0x0072
        L_0x006f:
            r4.put(r7, r9)     // Catch:{ all -> 0x00b7 }
        L_0x0072:
            boolean r7 = r3.containsKey(r5)     // Catch:{ all -> 0x00b7 }
            if (r7 != 0) goto L_0x0080
            androidx.collection.SimpleArrayMap r7 = new androidx.collection.SimpleArrayMap     // Catch:{ all -> 0x00b7 }
            r7.<init>()     // Catch:{ all -> 0x00b7 }
            r3.put(r5, r7)     // Catch:{ all -> 0x00b7 }
        L_0x0080:
            java.lang.Object r5 = r3.get(r5)     // Catch:{ all -> 0x00b7 }
            androidx.collection.SimpleArrayMap r5 = (androidx.collection.SimpleArrayMap) r5     // Catch:{ all -> 0x00b7 }
            r5.put(r6, r9)     // Catch:{ all -> 0x00b7 }
            goto L_0x001b
        L_0x008a:
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x00b7 }
            java.lang.String r11 = r11.getPackageName()     // Catch:{ all -> 0x00b7 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b7 }
            java.lang.String r5 = "Parsed "
            r4.<init>(r5)     // Catch:{ all -> 0x00b7 }
            java.lang.StringBuilder r12 = r4.append(r12)     // Catch:{ all -> 0x00b7 }
            java.lang.String r4 = " for Android package "
            java.lang.StringBuilder r12 = r12.append(r4)     // Catch:{ all -> 0x00b7 }
            java.lang.StringBuilder r11 = r12.append(r11)     // Catch:{ all -> 0x00b7 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00b7 }
            android.util.Log.w(r6, r11)     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.measurement.zzgc r11 = new com.google.android.gms.internal.measurement.zzgc     // Catch:{ all -> 0x00b7 }
            r11.<init>(r3)     // Catch:{ all -> 0x00b7 }
            r0.close()     // Catch:{ IOException -> 0x00d3 }
            return r11
        L_0x00b7:
            r11 = move-exception
            r0.close()     // Catch:{ all -> 0x00bc }
            goto L_0x00d2
        L_0x00bc:
            r12 = move-exception
            java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
            java.lang.String r3 = "addSuppressed"
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x00d2 }
            java.lang.Class<java.lang.Throwable> r5 = java.lang.Throwable.class
            r4[r1] = r5     // Catch:{ Exception -> 0x00d2 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r3, r4)     // Catch:{ Exception -> 0x00d2 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00d2 }
            r2[r1] = r12     // Catch:{ Exception -> 0x00d2 }
            r0.invoke(r11, r2)     // Catch:{ Exception -> 0x00d2 }
        L_0x00d2:
            throw r11     // Catch:{ IOException -> 0x00d3 }
        L_0x00d3:
            r11 = move-exception
            java.lang.RuntimeException r12 = new java.lang.RuntimeException
            r12.<init>(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgj.zza(android.content.Context, java.io.File):com.google.android.gms.internal.measurement.zzgh");
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
    public static class zza {
        private static volatile Optional<zzgh> zza;

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x003c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static com.google.common.base.Optional<com.google.android.gms.internal.measurement.zzgh> zza(android.content.Context r4) {
            /*
                java.lang.Class<com.google.android.gms.internal.measurement.zzgj$zza> r0 = com.google.android.gms.internal.measurement.zzgj.zza.class
                monitor-enter(r0)
                com.google.common.base.Optional<com.google.android.gms.internal.measurement.zzgh> r1 = zza     // Catch:{ all -> 0x0056 }
                if (r1 != 0) goto L_0x0054
                com.google.android.gms.internal.measurement.zzgj r1 = new com.google.android.gms.internal.measurement.zzgj     // Catch:{ all -> 0x0056 }
                r1.<init>()     // Catch:{ all -> 0x0056 }
                java.lang.String r1 = android.os.Build.TYPE     // Catch:{ all -> 0x0056 }
                java.lang.String r2 = android.os.Build.TAGS     // Catch:{ all -> 0x0056 }
                java.lang.String r3 = "eng"
                boolean r3 = r1.equals(r3)     // Catch:{ all -> 0x0056 }
                if (r3 != 0) goto L_0x0020
                java.lang.String r3 = "userdebug"
                boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0056 }
                if (r1 == 0) goto L_0x0031
            L_0x0020:
                java.lang.String r1 = "dev-keys"
                boolean r1 = r2.contains(r1)     // Catch:{ all -> 0x0056 }
                if (r1 != 0) goto L_0x0033
                java.lang.String r1 = "test-keys"
                boolean r1 = r2.contains(r1)     // Catch:{ all -> 0x0056 }
                if (r1 == 0) goto L_0x0031
                goto L_0x0033
            L_0x0031:
                r1 = 0
                goto L_0x0034
            L_0x0033:
                r1 = 1
            L_0x0034:
                if (r1 != 0) goto L_0x003c
                com.google.common.base.Optional r4 = com.google.common.base.Optional.absent()     // Catch:{ all -> 0x0056 }
            L_0x003a:
                r1 = r4
                goto L_0x0052
            L_0x003c:
                boolean r1 = com.google.android.gms.internal.measurement.zzfw.zza()     // Catch:{ all -> 0x0056 }
                if (r1 == 0) goto L_0x004d
                boolean r1 = r4.isDeviceProtectedStorage()     // Catch:{ all -> 0x0056 }
                if (r1 == 0) goto L_0x0049
                goto L_0x004d
            L_0x0049:
                android.content.Context r4 = r4.createDeviceProtectedStorageContext()     // Catch:{ all -> 0x0056 }
            L_0x004d:
                com.google.common.base.Optional r4 = com.google.android.gms.internal.measurement.zzgj.zza((android.content.Context) r4)     // Catch:{ all -> 0x0056 }
                goto L_0x003a
            L_0x0052:
                zza = r1     // Catch:{ all -> 0x0056 }
            L_0x0054:
                monitor-exit(r0)     // Catch:{ all -> 0x0056 }
                return r1
            L_0x0056:
                r4 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0056 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgj.zza.zza(android.content.Context):com.google.common.base.Optional");
        }

        private zza() {
        }
    }

    private static Optional<File> zzb(Context context) {
        try {
            File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
            return file.exists() ? Optional.of(file) : Optional.absent();
        } catch (RuntimeException e) {
            Log.e("HermeticFileOverrides", "no data dir", e);
            return Optional.absent();
        }
    }

    static Optional<zzgh> zza(Context context) {
        Optional<zzgh> optional;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            Optional<File> zzb = zzb(context);
            if (zzb.isPresent()) {
                optional = Optional.of(zza(context, zzb.get()));
            } else {
                optional = Optional.absent();
            }
            return optional;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private static final String zza(String str) {
        return new String(str);
    }
}
