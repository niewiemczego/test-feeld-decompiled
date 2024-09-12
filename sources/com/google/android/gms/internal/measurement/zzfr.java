package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public class zzfr {
    public static final Uri zza = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Pattern zzb = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzc = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final Uri zzd = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    /* access modifiers changed from: private */
    public static final AtomicBoolean zze = new AtomicBoolean();
    private static ContentResolver zzf = null;
    private static zzb zzg = null;
    private static HashMap<String, String> zzh;
    private static final HashMap<String, Boolean> zzi = new HashMap<>(16, 1.0f);
    private static final HashMap<String, Integer> zzj = new HashMap<>(16, 1.0f);
    private static final HashMap<String, Long> zzk = new HashMap<>(16, 1.0f);
    private static final HashMap<String, Float> zzl = new HashMap<>(16, 1.0f);
    private static Object zzm;
    private static boolean zzn;
    private static String[] zzo = new String[0];

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
    public interface zza<T extends Map<String, String>> {
        T zza(int i);
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
    public interface zzb {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006e, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ea, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ec, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f1, code lost:
        r10 = r10.query(zza, (java.lang.String[]) null, (java.lang.String) null, new java.lang.String[]{r11}, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ff, code lost:
        if (r10 != null) goto L_0x0107;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0101, code lost:
        if (r10 == null) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0103, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0106, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010b, code lost:
        if (r10.moveToFirst() != false) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x010d, code lost:
        zza(r0, r11, (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0115, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r12 = r10.getString(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x011a, code lost:
        if (r10 == null) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x011c, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x011f, code lost:
        if (r12 == null) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0125, code lost:
        if (r12.equals((java.lang.Object) null) == false) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0127, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0128, code lost:
        zza(r0, r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x012b, code lost:
        if (r12 == null) goto L_0x012e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x012d, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x012e, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x012f, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0130, code lost:
        if (r10 != null) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0132, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0135, code lost:
        throw r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String zza(android.content.ContentResolver r10, java.lang.String r11, java.lang.String r12) {
        /*
            java.lang.Class<com.google.android.gms.internal.measurement.zzfr> r12 = com.google.android.gms.internal.measurement.zzfr.class
            monitor-enter(r12)
            java.util.HashMap<java.lang.String, java.lang.String> r0 = zzh     // Catch:{ all -> 0x0136 }
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 != 0) goto L_0x002e
            java.util.concurrent.atomic.AtomicBoolean r0 = zze     // Catch:{ all -> 0x0136 }
            r0.set(r2)     // Catch:{ all -> 0x0136 }
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x0136 }
            r4 = 16
            r5 = 1065353216(0x3f800000, float:1.0)
            r0.<init>(r4, r5)     // Catch:{ all -> 0x0136 }
            zzh = r0     // Catch:{ all -> 0x0136 }
            java.lang.Object r0 = new java.lang.Object     // Catch:{ all -> 0x0136 }
            r0.<init>()     // Catch:{ all -> 0x0136 }
            zzm = r0     // Catch:{ all -> 0x0136 }
            zzn = r2     // Catch:{ all -> 0x0136 }
            android.net.Uri r0 = zza     // Catch:{ all -> 0x0136 }
            com.google.android.gms.internal.measurement.zzfu r4 = new com.google.android.gms.internal.measurement.zzfu     // Catch:{ all -> 0x0136 }
            r4.<init>(r3)     // Catch:{ all -> 0x0136 }
            r10.registerContentObserver(r0, r1, r4)     // Catch:{ all -> 0x0136 }
            goto L_0x0058
        L_0x002e:
            java.util.concurrent.atomic.AtomicBoolean r0 = zze     // Catch:{ all -> 0x0136 }
            boolean r0 = r0.getAndSet(r2)     // Catch:{ all -> 0x0136 }
            if (r0 == 0) goto L_0x0058
            java.util.HashMap<java.lang.String, java.lang.String> r0 = zzh     // Catch:{ all -> 0x0136 }
            r0.clear()     // Catch:{ all -> 0x0136 }
            java.util.HashMap<java.lang.String, java.lang.Boolean> r0 = zzi     // Catch:{ all -> 0x0136 }
            r0.clear()     // Catch:{ all -> 0x0136 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = zzj     // Catch:{ all -> 0x0136 }
            r0.clear()     // Catch:{ all -> 0x0136 }
            java.util.HashMap<java.lang.String, java.lang.Long> r0 = zzk     // Catch:{ all -> 0x0136 }
            r0.clear()     // Catch:{ all -> 0x0136 }
            java.util.HashMap<java.lang.String, java.lang.Float> r0 = zzl     // Catch:{ all -> 0x0136 }
            r0.clear()     // Catch:{ all -> 0x0136 }
            java.lang.Object r0 = new java.lang.Object     // Catch:{ all -> 0x0136 }
            r0.<init>()     // Catch:{ all -> 0x0136 }
            zzm = r0     // Catch:{ all -> 0x0136 }
            zzn = r2     // Catch:{ all -> 0x0136 }
        L_0x0058:
            java.lang.Object r0 = zzm     // Catch:{ all -> 0x0136 }
            java.util.HashMap<java.lang.String, java.lang.String> r4 = zzh     // Catch:{ all -> 0x0136 }
            boolean r4 = r4.containsKey(r11)     // Catch:{ all -> 0x0136 }
            if (r4 == 0) goto L_0x006f
            java.util.HashMap<java.lang.String, java.lang.String> r10 = zzh     // Catch:{ all -> 0x0136 }
            java.lang.Object r10 = r10.get(r11)     // Catch:{ all -> 0x0136 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0136 }
            if (r10 == 0) goto L_0x006d
            r3 = r10
        L_0x006d:
            monitor-exit(r12)     // Catch:{ all -> 0x0136 }
            return r3
        L_0x006f:
            java.lang.String[] r4 = zzo     // Catch:{ all -> 0x0136 }
            int r5 = r4.length     // Catch:{ all -> 0x0136 }
            r6 = r2
        L_0x0073:
            if (r6 >= r5) goto L_0x00f0
            r7 = r4[r6]     // Catch:{ all -> 0x0136 }
            boolean r7 = r11.startsWith(r7)     // Catch:{ all -> 0x0136 }
            if (r7 == 0) goto L_0x00ed
            boolean r0 = zzn     // Catch:{ all -> 0x0136 }
            if (r0 != 0) goto L_0x00eb
            java.lang.String[] r0 = zzo     // Catch:{ all -> 0x0136 }
            com.google.android.gms.internal.measurement.zzft r2 = new com.google.android.gms.internal.measurement.zzft     // Catch:{ all -> 0x0136 }
            r2.<init>()     // Catch:{ all -> 0x0136 }
            java.util.Map r10 = zza((android.content.ContentResolver) r10, (java.lang.String[]) r0, r2)     // Catch:{ all -> 0x0136 }
            java.util.HashMap r10 = (java.util.HashMap) r10     // Catch:{ all -> 0x0136 }
            if (r10 == 0) goto L_0x00d6
            boolean r0 = r10.isEmpty()     // Catch:{ all -> 0x0136 }
            if (r0 != 0) goto L_0x00be
            java.util.Set r0 = r10.keySet()     // Catch:{ all -> 0x0136 }
            java.util.HashMap<java.lang.String, java.lang.Boolean> r2 = zzi     // Catch:{ all -> 0x0136 }
            java.util.Set r2 = r2.keySet()     // Catch:{ all -> 0x0136 }
            r0.removeAll(r2)     // Catch:{ all -> 0x0136 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r2 = zzj     // Catch:{ all -> 0x0136 }
            java.util.Set r2 = r2.keySet()     // Catch:{ all -> 0x0136 }
            r0.removeAll(r2)     // Catch:{ all -> 0x0136 }
            java.util.HashMap<java.lang.String, java.lang.Long> r2 = zzk     // Catch:{ all -> 0x0136 }
            java.util.Set r2 = r2.keySet()     // Catch:{ all -> 0x0136 }
            r0.removeAll(r2)     // Catch:{ all -> 0x0136 }
            java.util.HashMap<java.lang.String, java.lang.Float> r2 = zzl     // Catch:{ all -> 0x0136 }
            java.util.Set r2 = r2.keySet()     // Catch:{ all -> 0x0136 }
            r0.removeAll(r2)     // Catch:{ all -> 0x0136 }
        L_0x00be:
            boolean r0 = r10.isEmpty()     // Catch:{ all -> 0x0136 }
            if (r0 != 0) goto L_0x00d4
            java.util.HashMap<java.lang.String, java.lang.String> r0 = zzh     // Catch:{ all -> 0x0136 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0136 }
            if (r0 == 0) goto L_0x00cf
            zzh = r10     // Catch:{ all -> 0x0136 }
            goto L_0x00d4
        L_0x00cf:
            java.util.HashMap<java.lang.String, java.lang.String> r0 = zzh     // Catch:{ all -> 0x0136 }
            r0.putAll(r10)     // Catch:{ all -> 0x0136 }
        L_0x00d4:
            zzn = r1     // Catch:{ all -> 0x0136 }
        L_0x00d6:
            java.util.HashMap<java.lang.String, java.lang.String> r10 = zzh     // Catch:{ all -> 0x0136 }
            boolean r10 = r10.containsKey(r11)     // Catch:{ all -> 0x0136 }
            if (r10 == 0) goto L_0x00eb
            java.util.HashMap<java.lang.String, java.lang.String> r10 = zzh     // Catch:{ all -> 0x0136 }
            java.lang.Object r10 = r10.get(r11)     // Catch:{ all -> 0x0136 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0136 }
            if (r10 == 0) goto L_0x00e9
            r3 = r10
        L_0x00e9:
            monitor-exit(r12)     // Catch:{ all -> 0x0136 }
            return r3
        L_0x00eb:
            monitor-exit(r12)     // Catch:{ all -> 0x0136 }
            return r3
        L_0x00ed:
            int r6 = r6 + 1
            goto L_0x0073
        L_0x00f0:
            monitor-exit(r12)     // Catch:{ all -> 0x0136 }
            android.net.Uri r5 = zza
            r6 = 0
            r7 = 0
            java.lang.String[] r8 = new java.lang.String[r1]
            r8[r2] = r11
            r9 = 0
            r4 = r10
            android.database.Cursor r10 = r4.query(r5, r6, r7, r8, r9)
            if (r10 != 0) goto L_0x0107
            if (r10 == 0) goto L_0x0106
            r10.close()
        L_0x0106:
            return r3
        L_0x0107:
            boolean r12 = r10.moveToFirst()     // Catch:{ all -> 0x012f }
            if (r12 != 0) goto L_0x0116
            zza((java.lang.Object) r0, (java.lang.String) r11, (java.lang.String) r3)     // Catch:{ all -> 0x012f }
            if (r10 == 0) goto L_0x0115
            r10.close()
        L_0x0115:
            return r3
        L_0x0116:
            java.lang.String r12 = r10.getString(r1)     // Catch:{ all -> 0x012f }
            if (r10 == 0) goto L_0x011f
            r10.close()
        L_0x011f:
            if (r12 == 0) goto L_0x0128
            boolean r10 = r12.equals(r3)
            if (r10 == 0) goto L_0x0128
            r12 = r3
        L_0x0128:
            zza((java.lang.Object) r0, (java.lang.String) r11, (java.lang.String) r12)
            if (r12 == 0) goto L_0x012e
            return r12
        L_0x012e:
            return r3
        L_0x012f:
            r11 = move-exception
            if (r10 == 0) goto L_0x0135
            r10.close()
        L_0x0135:
            throw r11
        L_0x0136:
            r10 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x0136 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfr.zza(android.content.ContentResolver, java.lang.String, java.lang.String):java.lang.String");
    }

    private static <T extends Map<String, String>> T zza(ContentResolver contentResolver, String[] strArr, zza<T> zza2) {
        Cursor query = contentResolver.query(zzd, (String[]) null, (String) null, strArr, (String) null);
        if (query == null) {
            return null;
        }
        T zza3 = zza2.zza(query.getCount());
        while (query.moveToNext()) {
            try {
                zza3.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return zza3;
    }

    private static void zza(Object obj, String str, String str2) {
        synchronized (zzfr.class) {
            if (obj == zzm) {
                zzh.put(str, str2);
            }
        }
    }
}
