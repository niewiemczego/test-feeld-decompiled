package com.google.android.recaptcha.internal;

import android.content.Context;
import java.util.Locale;
import java.util.MissingResourceException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzbf {
    public static final zzbe zza = new zzbe((DefaultConstructorMarker) null);
    private static zzmo zzb;
    private final String zzc;
    private final zzac zzd;
    private final zznc zze;
    private final long zzf = System.currentTimeMillis();

    public zzbf(zzbb zzbb, String str, zzac zzac) {
        this.zzc = str;
        this.zzd = zzac;
        zznc zzi = zznf.zzi();
        this.zze = zzi;
        zzi.zzp(zzbb.zza());
        zzi.zzd(zzbb.zzb());
        zzi.zzr(zzbb.zzc());
        if (zzbb.zzd() != null) {
            zzi.zzu(zzbb.zzd());
        }
        zzi.zzt(zzmg.zzc(zzmg.zzb(System.currentTimeMillis())));
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004c A[Catch:{ NameNotFoundException -> 0x0095 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067 A[Catch:{ NameNotFoundException -> 0x0095 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final com.google.android.recaptcha.internal.zzmo zzb(android.content.Context r8) {
        /*
            java.lang.String r0 = "unknown"
            r1 = 33
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ NameNotFoundException -> 0x0047 }
            java.lang.String r3 = "com.google.android.gms.version"
            r4 = -1
            if (r2 < r1) goto L_0x002b
            android.content.pm.PackageManager r2 = r8.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0047 }
            java.lang.String r5 = r8.getPackageName()     // Catch:{ NameNotFoundException -> 0x0047 }
            r6 = 128(0x80, double:6.32E-322)
            android.content.pm.PackageManager$ApplicationInfoFlags r6 = android.content.pm.PackageManager.ApplicationInfoFlags.of(r6)     // Catch:{ NameNotFoundException -> 0x0047 }
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo(r5, r6)     // Catch:{ NameNotFoundException -> 0x0047 }
            android.os.Bundle r2 = r2.metaData     // Catch:{ NameNotFoundException -> 0x0047 }
            int r2 = r2.getInt(r3, r4)     // Catch:{ NameNotFoundException -> 0x0047 }
            if (r2 != r4) goto L_0x0026
            goto L_0x0047
        L_0x0026:
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ NameNotFoundException -> 0x0047 }
            goto L_0x0048
        L_0x002b:
            android.content.pm.PackageManager r2 = r8.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0047 }
            java.lang.String r5 = r8.getPackageName()     // Catch:{ NameNotFoundException -> 0x0047 }
            r6 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo(r5, r6)     // Catch:{ NameNotFoundException -> 0x0047 }
            android.os.Bundle r2 = r2.metaData     // Catch:{ NameNotFoundException -> 0x0047 }
            int r2 = r2.getInt(r3, r4)     // Catch:{ NameNotFoundException -> 0x0047 }
            if (r2 != r4) goto L_0x0042
            goto L_0x0047
        L_0x0042:
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ NameNotFoundException -> 0x0047 }
            goto L_0x0048
        L_0x0047:
            r2 = r0
        L_0x0048:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ NameNotFoundException -> 0x0095 }
            if (r3 < r1) goto L_0x0067
            android.content.pm.PackageManager r1 = r8.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0095 }
            java.lang.String r8 = r8.getPackageName()     // Catch:{ NameNotFoundException -> 0x0095 }
            r3 = 0
            android.content.pm.PackageManager$PackageInfoFlags r3 = android.content.pm.PackageManager.PackageInfoFlags.of(r3)     // Catch:{ NameNotFoundException -> 0x0095 }
            android.content.pm.PackageInfo r8 = r1.getPackageInfo(r8, r3)     // Catch:{ NameNotFoundException -> 0x0095 }
            long r3 = r8.getLongVersionCode()     // Catch:{ NameNotFoundException -> 0x0095 }
            java.lang.String r0 = java.lang.String.valueOf(r3)     // Catch:{ NameNotFoundException -> 0x0095 }
            goto L_0x0095
        L_0x0067:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ NameNotFoundException -> 0x0095 }
            r3 = 28
            r4 = 0
            if (r1 < r3) goto L_0x0083
            android.content.pm.PackageManager r1 = r8.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0095 }
            java.lang.String r8 = r8.getPackageName()     // Catch:{ NameNotFoundException -> 0x0095 }
            android.content.pm.PackageInfo r8 = r1.getPackageInfo(r8, r4)     // Catch:{ NameNotFoundException -> 0x0095 }
            long r3 = r8.getLongVersionCode()     // Catch:{ NameNotFoundException -> 0x0095 }
            java.lang.String r0 = java.lang.String.valueOf(r3)     // Catch:{ NameNotFoundException -> 0x0095 }
            goto L_0x0095
        L_0x0083:
            android.content.pm.PackageManager r1 = r8.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0095 }
            java.lang.String r8 = r8.getPackageName()     // Catch:{ NameNotFoundException -> 0x0095 }
            android.content.pm.PackageInfo r8 = r1.getPackageInfo(r8, r4)     // Catch:{ NameNotFoundException -> 0x0095 }
            int r8 = r8.versionCode     // Catch:{ NameNotFoundException -> 0x0095 }
            java.lang.String r0 = java.lang.String.valueOf(r8)     // Catch:{ NameNotFoundException -> 0x0095 }
        L_0x0095:
            com.google.android.recaptcha.internal.zzmn r8 = com.google.android.recaptcha.internal.zzmo.zzf()
            int r1 = android.os.Build.VERSION.SDK_INT
            r8.zzd(r1)
            r8.zzq(r2)
            java.lang.String r1 = "18.4.0"
            r8.zzs(r1)
            java.lang.String r1 = android.os.Build.MODEL
            r8.zzp(r1)
            java.lang.String r1 = android.os.Build.MANUFACTURER
            r8.zzr(r1)
            r8.zze(r0)
            com.google.android.recaptcha.internal.zzit r8 = r8.zzj()
            com.google.android.recaptcha.internal.zzmo r8 = (com.google.android.recaptcha.internal.zzmo) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzbf.zzb(android.content.Context):com.google.android.recaptcha.internal.zzmo");
    }

    public final zznf zza(int i, zzmr zzmr, Context context) {
        String str;
        String str2 = "";
        long currentTimeMillis = System.currentTimeMillis() - this.zzf;
        zznc zznc = this.zze;
        zznc.zze(currentTimeMillis);
        zznc.zzv(i);
        if (zzmr != null) {
            this.zze.zzq(zzmr);
        }
        if (zzb == null) {
            zzb = zzb(context);
        }
        try {
            str = Locale.getDefault().getISO3Language();
        } catch (MissingResourceException unused) {
            str = str2;
        }
        try {
            str2 = Locale.getDefault().getISO3Country();
        } catch (MissingResourceException unused2) {
        }
        zznc zznc2 = this.zze;
        String str3 = this.zzc;
        zznq zzf2 = zznr.zzf();
        zzf2.zzq(str3);
        zzmo zzmo = zzb;
        if (zzmo == null) {
            zzmo = zzb(context);
        }
        zzf2.zzd(zzmo);
        zzf2.zzp(str);
        zzf2.zze(str2);
        zznc2.zzs((zznr) zzf2.zzj());
        return (zznf) this.zze.zzj();
    }
}
