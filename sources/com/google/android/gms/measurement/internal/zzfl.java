package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzqe;
import com.google.android.gms.measurement.internal.zzih;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzfl extends zze {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private long zzg;
    private List<String> zzh;
    private String zzi;
    private int zzj;
    private String zzk;
    private String zzl;
    private String zzm;
    private long zzn = 0;
    private String zzo = null;

    /* access modifiers changed from: package-private */
    public final int zzaa() {
        zzu();
        return this.zzj;
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final int zzab() {
        zzu();
        return this.zzc;
    }

    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    public final /* bridge */ /* synthetic */ zzb zzc() {
        return super.zzc();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzo zza(java.lang.String r47) {
        /*
            r46 = this;
            r0 = r46
            r46.zzt()
            com.google.android.gms.measurement.internal.zzgd r1 = r46.zzk()
            com.google.android.gms.measurement.internal.zzih r1 = r1.zzm()
            boolean r2 = com.google.android.gms.internal.measurement.zznp.zza()
            if (r2 == 0) goto L_0x0030
            com.google.android.gms.measurement.internal.zzaf r2 = r46.zze()
            com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbi.zzcl
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean>) r3)
            if (r2 == 0) goto L_0x0030
            com.google.android.gms.measurement.internal.zzgd r2 = r46.zzk()
            com.google.android.gms.measurement.internal.zzay r2 = r2.zzh()
            java.lang.String r2 = r2.zzf()
            int r3 = r1.zza()
            goto L_0x0034
        L_0x0030:
            java.lang.String r2 = ""
            r3 = 100
        L_0x0034:
            r39 = r2
            r38 = r3
            com.google.android.gms.measurement.internal.zzo r2 = new com.google.android.gms.measurement.internal.zzo
            java.lang.String r5 = r46.zzad()
            java.lang.String r6 = r46.zzae()
            r46.zzu()
            java.lang.String r7 = r0.zzb
            int r3 = r46.zzab()
            long r8 = (long) r3
            r46.zzu()
            java.lang.String r3 = r0.zzd
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            java.lang.String r10 = r0.zzd
            r46.zzu()
            r46.zzt()
            long r3 = r0.zzf
            r13 = 0
            int r3 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r3 != 0) goto L_0x007c
            com.google.android.gms.measurement.internal.zzhf r3 = r0.zzu
            com.google.android.gms.measurement.internal.zznd r3 = r3.zzt()
            android.content.Context r4 = r46.zza()
            android.content.Context r15 = r46.zza()
            java.lang.String r15 = r15.getPackageName()
            long r3 = r3.zza((android.content.Context) r4, (java.lang.String) r15)
            r0.zzf = r3
        L_0x007c:
            long r3 = r0.zzf
            com.google.android.gms.measurement.internal.zzhf r15 = r0.zzu
            boolean r16 = r15.zzac()
            com.google.android.gms.measurement.internal.zzgd r15 = r46.zzk()
            boolean r15 = r15.zzm
            r17 = r15 ^ 1
            r46.zzt()
            com.google.android.gms.measurement.internal.zzhf r15 = r0.zzu
            boolean r15 = r15.zzac()
            r18 = 0
            if (r15 != 0) goto L_0x009c
            r19 = r18
            goto L_0x00a2
        L_0x009c:
            java.lang.String r15 = r46.zzah()
            r19 = r15
        L_0x00a2:
            r20 = 0
            com.google.android.gms.measurement.internal.zzhf r15 = r0.zzu
            com.google.android.gms.measurement.internal.zzgd r11 = r15.zzn()
            com.google.android.gms.measurement.internal.zzgi r11 = r11.zzc
            long r11 = r11.zza()
            int r24 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r24 != 0) goto L_0x00b7
            long r11 = r15.zza
            goto L_0x00bd
        L_0x00b7:
            long r13 = r15.zza
            long r11 = java.lang.Math.min(r13, r11)
        L_0x00bd:
            r26 = r11
            int r28 = r46.zzaa()
            com.google.android.gms.measurement.internal.zzaf r11 = r46.zze()
            boolean r29 = r11.zzp()
            com.google.android.gms.measurement.internal.zzgd r11 = r46.zzk()
            r11.zzt()
            android.content.SharedPreferences r11 = r11.zzc()
            java.lang.String r12 = "deferred_analytics_collection"
            r13 = 0
            boolean r30 = r11.getBoolean(r12, r13)
            java.lang.String r31 = r46.zzac()
            com.google.android.gms.measurement.internal.zzaf r11 = r46.zze()
            java.lang.String r12 = "google_analytics_default_allow_ad_personalization_signals"
            java.lang.Boolean r11 = r11.zzg(r12)
            if (r11 != 0) goto L_0x00f0
            r32 = r18
            goto L_0x00fc
        L_0x00f0:
            boolean r11 = r11.booleanValue()
            r11 = r11 ^ 1
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)
            r32 = r11
        L_0x00fc:
            long r14 = r0.zzg
            java.util.List<java.lang.String> r11 = r0.zzh
            r33 = 0
            java.lang.String r1 = r1.zze()
            java.lang.String r12 = r0.zzi
            if (r12 != 0) goto L_0x0114
            com.google.android.gms.measurement.internal.zznd r12 = r46.zzq()
            java.lang.String r12 = r12.zzp()
            r0.zzi = r12
        L_0x0114:
            java.lang.String r12 = r0.zzi
            boolean r34 = com.google.android.gms.internal.measurement.zzps.zza()
            if (r34 == 0) goto L_0x0163
            com.google.android.gms.measurement.internal.zzaf r13 = r46.zze()
            r35 = r3
            com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzbi.zzbs
            boolean r3 = r13.zza((com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean>) r3)
            if (r3 == 0) goto L_0x0165
            r46.zzt()
            long r3 = r0.zzn
            r24 = 0
            int r3 = (r3 > r24 ? 1 : (r3 == r24 ? 0 : -1))
            if (r3 == 0) goto L_0x0156
            com.google.android.gms.common.util.Clock r3 = r46.zzb()
            long r3 = r3.currentTimeMillis()
            r13 = r11
            r37 = r12
            long r11 = r0.zzn
            long r3 = r3 - r11
            java.lang.String r11 = r0.zzm
            if (r11 == 0) goto L_0x0159
            r11 = 86400000(0x5265c00, double:4.2687272E-316)
            int r3 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r3 <= 0) goto L_0x0159
            java.lang.String r3 = r0.zzo
            if (r3 != 0) goto L_0x0159
            r46.zzag()
            goto L_0x0159
        L_0x0156:
            r13 = r11
            r37 = r12
        L_0x0159:
            java.lang.String r3 = r0.zzm
            if (r3 != 0) goto L_0x0160
            r46.zzag()
        L_0x0160:
            java.lang.String r3 = r0.zzm
            goto L_0x016c
        L_0x0163:
            r35 = r3
        L_0x0165:
            r13 = r11
            r37 = r12
            r24 = 0
            r3 = r18
        L_0x016c:
            com.google.android.gms.measurement.internal.zzaf r4 = r46.zze()
            java.lang.String r11 = "google_analytics_sgtm_upload_enabled"
            java.lang.Boolean r4 = r4.zzg(r11)
            if (r4 != 0) goto L_0x017b
            r40 = 0
            goto L_0x0181
        L_0x017b:
            boolean r4 = r4.booleanValue()
            r40 = r4
        L_0x0181:
            com.google.android.gms.measurement.internal.zznd r4 = r46.zzq()
            java.lang.String r11 = r46.zzad()
            long r41 = r4.zzc(r11)
            boolean r4 = com.google.android.gms.internal.measurement.zzpg.zza()
            if (r4 == 0) goto L_0x01a9
            com.google.android.gms.measurement.internal.zzaf r4 = r46.zze()
            com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzbi.zzcg
            boolean r4 = r4.zza((com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean>) r11)
            if (r4 == 0) goto L_0x01a9
            r46.zzq()
            int r4 = com.google.android.gms.measurement.internal.zznd.zzc()
            r43 = r4
            goto L_0x01ab
        L_0x01a9:
            r43 = 0
        L_0x01ab:
            boolean r4 = com.google.android.gms.internal.measurement.zzpg.zza()
            if (r4 == 0) goto L_0x01c8
            com.google.android.gms.measurement.internal.zzaf r4 = r46.zze()
            com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzbi.zzcg
            boolean r4 = r4.zza((com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean>) r11)
            if (r4 == 0) goto L_0x01c8
            com.google.android.gms.measurement.internal.zznd r4 = r46.zzq()
            long r11 = r4.zzh()
            r44 = r11
            goto L_0x01ca
        L_0x01c8:
            r44 = r24
        L_0x01ca:
            r24 = r35
            r4 = r2
            r34 = r13
            r35 = r37
            r11 = 82001(0x14051, double:4.0514E-319)
            r36 = r14
            r13 = r24
            r15 = r47
            r18 = r19
            r19 = r20
            r21 = r26
            r23 = r28
            r24 = r29
            r25 = r30
            r26 = r31
            r27 = r32
            r28 = r36
            r30 = r34
            r31 = r33
            r32 = r1
            r33 = r35
            r34 = r3
            r35 = r40
            r36 = r41
            r40 = r43
            r41 = r44
            r4.<init>((java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (long) r8, (java.lang.String) r10, (long) r11, (long) r13, (java.lang.String) r15, (boolean) r16, (boolean) r17, (java.lang.String) r18, (long) r19, (long) r21, (int) r23, (boolean) r24, (boolean) r25, (java.lang.String) r26, (java.lang.Boolean) r27, (long) r28, (java.util.List<java.lang.String>) r30, (java.lang.String) r31, (java.lang.String) r32, (java.lang.String) r33, (java.lang.String) r34, (boolean) r35, (long) r36, (int) r38, (java.lang.String) r39, (int) r40, (long) r41)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfl.zza(java.lang.String):com.google.android.gms.measurement.internal.zzo");
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzae zzd() {
        return super.zzd();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzaf zze() {
        return super.zze();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzba zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzfl zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzfo zzh() {
        return super.zzh();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzfq zzi() {
        return super.zzi();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzfr zzj() {
        return super.zzj();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzgd zzk() {
        return super.zzk();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzgy zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ zziq zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzkh zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkp zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzlx zzp() {
        return super.zzp();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zznd zzq() {
        return super.zzq();
    }

    /* access modifiers changed from: package-private */
    public final String zzac() {
        zzu();
        return this.zzl;
    }

    /* access modifiers changed from: package-private */
    public final String zzad() {
        zzu();
        Preconditions.checkNotNull(this.zza);
        return this.zza;
    }

    private final String zzah() {
        if (!zzqe.zza() || !zze().zza(zzbi.zzbk)) {
            try {
                Class<?> loadClass = zza().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                if (loadClass == null) {
                    return null;
                }
                try {
                    Object invoke = loadClass.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{zza()});
                    if (invoke == null) {
                        return null;
                    }
                    try {
                        return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                    } catch (Exception unused) {
                        zzj().zzv().zza("Failed to retrieve Firebase Instance Id");
                        return null;
                    }
                } catch (Exception unused2) {
                    zzj().zzw().zza("Failed to obtain Firebase Analytics instance");
                    return null;
                }
            } catch (ClassNotFoundException unused3) {
                return null;
            }
        } else {
            zzj().zzp().zza("Disabled IID for tests.");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzae() {
        zzt();
        zzu();
        Preconditions.checkNotNull(this.zzk);
        return this.zzk;
    }

    /* access modifiers changed from: package-private */
    public final List<String> zzaf() {
        return this.zzh;
    }

    zzfl(zzhf zzhf, long j) {
        super(zzhf);
        this.zzg = j;
    }

    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x018b A[Catch:{ IllegalStateException -> 0x01cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x018c A[Catch:{ IllegalStateException -> 0x01cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0195 A[Catch:{ IllegalStateException -> 0x01cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01ae A[Catch:{ IllegalStateException -> 0x01cb }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01ec  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x022f  */
    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({"appId", "appStore", "appName", "gmpAppId", "gaAppId"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzx() {
        /*
            r11 = this;
            android.content.Context r0 = r11.zza()
            java.lang.String r0 = r0.getPackageName()
            android.content.Context r1 = r11.zza()
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            java.lang.String r2 = "Unknown"
            java.lang.String r3 = ""
            r4 = 0
            java.lang.String r5 = "unknown"
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != 0) goto L_0x002e
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzft r7 = r7.zzg()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r0)
            java.lang.String r9 = "PackageManager is null, app identity information might be inaccurate. appId"
            r7.zza(r9, r8)
        L_0x002c:
            r8 = r2
            goto L_0x008e
        L_0x002e:
            java.lang.String r5 = r1.getInstallerPackageName(r0)     // Catch:{ IllegalArgumentException -> 0x0033 }
            goto L_0x0044
        L_0x0033:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzft r7 = r7.zzg()
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r0)
            java.lang.String r9 = "Error retrieving app installer package name. appId"
            r7.zza(r9, r8)
        L_0x0044:
            if (r5 != 0) goto L_0x0049
            java.lang.String r5 = "manual_install"
            goto L_0x0052
        L_0x0049:
            java.lang.String r7 = "com.android.vending"
            boolean r7 = r7.equals(r5)
            if (r7 == 0) goto L_0x0052
            r5 = r3
        L_0x0052:
            android.content.Context r7 = r11.zza()     // Catch:{ NameNotFoundException -> 0x007a }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x007a }
            android.content.pm.PackageInfo r7 = r1.getPackageInfo(r7, r4)     // Catch:{ NameNotFoundException -> 0x007a }
            if (r7 == 0) goto L_0x002c
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo     // Catch:{ NameNotFoundException -> 0x007a }
            java.lang.CharSequence r8 = r1.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x007a }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ NameNotFoundException -> 0x007a }
            if (r9 != 0) goto L_0x0071
            java.lang.String r8 = r8.toString()     // Catch:{ NameNotFoundException -> 0x007a }
            goto L_0x0072
        L_0x0071:
            r8 = r2
        L_0x0072:
            java.lang.String r2 = r7.versionName     // Catch:{ NameNotFoundException -> 0x0077 }
            int r6 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x0077 }
            goto L_0x008e
        L_0x0077:
            r7 = r2
            r2 = r8
            goto L_0x007b
        L_0x007a:
            r7 = r2
        L_0x007b:
            com.google.android.gms.measurement.internal.zzfr r8 = r11.zzj()
            com.google.android.gms.measurement.internal.zzft r8 = r8.zzg()
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r0)
            java.lang.String r10 = "Error retrieving package info. appId, appName"
            r8.zza(r10, r9, r2)
            r8 = r2
            r2 = r7
        L_0x008e:
            r11.zza = r0
            r11.zzd = r5
            r11.zzb = r2
            r11.zzc = r6
            r11.zze = r8
            r5 = 0
            r11.zzf = r5
            com.google.android.gms.measurement.internal.zzhf r2 = r11.zzu
            java.lang.String r2 = r2.zzu()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            r5 = 1
            if (r2 != 0) goto L_0x00b9
            com.google.android.gms.measurement.internal.zzhf r2 = r11.zzu
            java.lang.String r2 = r2.zzv()
            java.lang.String r6 = "am"
            boolean r2 = r6.equals(r2)
            if (r2 == 0) goto L_0x00b9
            r2 = r5
            goto L_0x00ba
        L_0x00b9:
            r2 = r4
        L_0x00ba:
            com.google.android.gms.measurement.internal.zzhf r6 = r11.zzu
            int r6 = r6.zzc()
            switch(r6) {
                case 0: goto L_0x0150;
                case 1: goto L_0x0142;
                case 2: goto L_0x0134;
                case 3: goto L_0x0126;
                case 4: goto L_0x0118;
                case 5: goto L_0x010a;
                case 6: goto L_0x00fc;
                case 7: goto L_0x00ee;
                case 8: goto L_0x00df;
                default: goto L_0x00c3;
            }
        L_0x00c3:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzft r7 = r7.zzn()
            java.lang.String r8 = "App measurement disabled"
            r7.zza(r8)
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzft r7 = r7.zzm()
            java.lang.String r8 = "Invalid scion state in identity"
            r7.zza(r8)
            goto L_0x015d
        L_0x00df:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzft r7 = r7.zzn()
            java.lang.String r8 = "App measurement disabled due to denied storage consent"
            r7.zza(r8)
            goto L_0x015d
        L_0x00ee:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzft r7 = r7.zzn()
            java.lang.String r8 = "App measurement disabled via the global data collection setting"
            r7.zza(r8)
            goto L_0x015d
        L_0x00fc:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzft r7 = r7.zzv()
            java.lang.String r8 = "App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics"
            r7.zza(r8)
            goto L_0x015d
        L_0x010a:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzft r7 = r7.zzp()
            java.lang.String r8 = "App measurement disabled via the init parameters"
            r7.zza(r8)
            goto L_0x015d
        L_0x0118:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzft r7 = r7.zzn()
            java.lang.String r8 = "App measurement disabled via the manifest"
            r7.zza(r8)
            goto L_0x015d
        L_0x0126:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzft r7 = r7.zzn()
            java.lang.String r8 = "App measurement disabled by setAnalyticsCollectionEnabled(false)"
            r7.zza(r8)
            goto L_0x015d
        L_0x0134:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzft r7 = r7.zzp()
            java.lang.String r8 = "App measurement deactivated via the init parameters"
            r7.zza(r8)
            goto L_0x015d
        L_0x0142:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzft r7 = r7.zzn()
            java.lang.String r8 = "App measurement deactivated via the manifest"
            r7.zza(r8)
            goto L_0x015d
        L_0x0150:
            com.google.android.gms.measurement.internal.zzfr r7 = r11.zzj()
            com.google.android.gms.measurement.internal.zzft r7 = r7.zzp()
            java.lang.String r8 = "App measurement collection enabled"
            r7.zza(r8)
        L_0x015d:
            if (r6 != 0) goto L_0x0161
            r6 = r5
            goto L_0x0162
        L_0x0161:
            r6 = r4
        L_0x0162:
            r11.zzk = r3
            r11.zzl = r3
            if (r2 == 0) goto L_0x0170
            com.google.android.gms.measurement.internal.zzhf r2 = r11.zzu
            java.lang.String r2 = r2.zzu()
            r11.zzl = r2
        L_0x0170:
            android.content.Context r2 = r11.zza()     // Catch:{ IllegalStateException -> 0x01cb }
            com.google.android.gms.measurement.internal.zzhf r7 = r11.zzu     // Catch:{ IllegalStateException -> 0x01cb }
            java.lang.String r7 = r7.zzx()     // Catch:{ IllegalStateException -> 0x01cb }
            java.lang.String r8 = "google_app_id"
            com.google.android.gms.measurement.internal.zzgz r9 = new com.google.android.gms.measurement.internal.zzgz     // Catch:{ IllegalStateException -> 0x01cb }
            r9.<init>(r2, r7)     // Catch:{ IllegalStateException -> 0x01cb }
            java.lang.String r2 = r9.zza((java.lang.String) r8)     // Catch:{ IllegalStateException -> 0x01cb }
            boolean r7 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IllegalStateException -> 0x01cb }
            if (r7 == 0) goto L_0x018c
            goto L_0x018d
        L_0x018c:
            r3 = r2
        L_0x018d:
            r11.zzk = r3     // Catch:{ IllegalStateException -> 0x01cb }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IllegalStateException -> 0x01cb }
            if (r2 != 0) goto L_0x01ac
            com.google.android.gms.measurement.internal.zzgz r2 = new com.google.android.gms.measurement.internal.zzgz     // Catch:{ IllegalStateException -> 0x01cb }
            android.content.Context r3 = r11.zza()     // Catch:{ IllegalStateException -> 0x01cb }
            com.google.android.gms.measurement.internal.zzhf r7 = r11.zzu     // Catch:{ IllegalStateException -> 0x01cb }
            java.lang.String r7 = r7.zzx()     // Catch:{ IllegalStateException -> 0x01cb }
            r2.<init>(r3, r7)     // Catch:{ IllegalStateException -> 0x01cb }
            java.lang.String r3 = "admob_app_id"
            java.lang.String r2 = r2.zza((java.lang.String) r3)     // Catch:{ IllegalStateException -> 0x01cb }
            r11.zzl = r2     // Catch:{ IllegalStateException -> 0x01cb }
        L_0x01ac:
            if (r6 == 0) goto L_0x01dd
            com.google.android.gms.measurement.internal.zzfr r2 = r11.zzj()     // Catch:{ IllegalStateException -> 0x01cb }
            com.google.android.gms.measurement.internal.zzft r2 = r2.zzp()     // Catch:{ IllegalStateException -> 0x01cb }
            java.lang.String r3 = "App measurement enabled for app package, google app id"
            java.lang.String r6 = r11.zza     // Catch:{ IllegalStateException -> 0x01cb }
            java.lang.String r7 = r11.zzk     // Catch:{ IllegalStateException -> 0x01cb }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x01cb }
            if (r7 == 0) goto L_0x01c5
            java.lang.String r7 = r11.zzl     // Catch:{ IllegalStateException -> 0x01cb }
            goto L_0x01c7
        L_0x01c5:
            java.lang.String r7 = r11.zzk     // Catch:{ IllegalStateException -> 0x01cb }
        L_0x01c7:
            r2.zza(r3, r6, r7)     // Catch:{ IllegalStateException -> 0x01cb }
            goto L_0x01dd
        L_0x01cb:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzfr r3 = r11.zzj()
            com.google.android.gms.measurement.internal.zzft r3 = r3.zzg()
            java.lang.Object r0 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r0)
            java.lang.String r6 = "Fetching Google App Id failed with exception. appId"
            r3.zza(r6, r0, r2)
        L_0x01dd:
            r0 = 0
            r11.zzh = r0
            com.google.android.gms.measurement.internal.zzaf r0 = r11.zze()
            java.lang.String r2 = "analytics.safelisted_events"
            java.util.List r0 = r0.zzi(r2)
            if (r0 == 0) goto L_0x021e
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x0201
            com.google.android.gms.measurement.internal.zzfr r2 = r11.zzj()
            com.google.android.gms.measurement.internal.zzft r2 = r2.zzv()
            java.lang.String r3 = "Safelisted event list is empty. Ignoring"
            r2.zza(r3)
        L_0x01ff:
            r5 = r4
            goto L_0x021e
        L_0x0201:
            java.util.Iterator r2 = r0.iterator()
        L_0x0205:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x021e
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            com.google.android.gms.measurement.internal.zznd r6 = r11.zzq()
            java.lang.String r7 = "safelisted event"
            boolean r3 = r6.zzb((java.lang.String) r7, (java.lang.String) r3)
            if (r3 != 0) goto L_0x0205
            goto L_0x01ff
        L_0x021e:
            if (r5 == 0) goto L_0x0222
            r11.zzh = r0
        L_0x0222:
            if (r1 == 0) goto L_0x022f
            android.content.Context r0 = r11.zza()
            boolean r0 = com.google.android.gms.common.wrappers.InstantApps.isInstantApp(r0)
            r11.zzj = r0
            return
        L_0x022f:
            r11.zzj = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzfl.zzx():void");
    }

    /* access modifiers changed from: package-private */
    public final void zzag() {
        String str;
        zzt();
        if (!zzk().zzm().zza(zzih.zza.ANALYTICS_STORAGE)) {
            zzj().zzc().zza("Analytics Storage consent is not granted");
            str = null;
        } else {
            byte[] bArr = new byte[16];
            zzq().zzv().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
        }
        zzft zzc2 = zzj().zzc();
        Object[] objArr = new Object[1];
        objArr[0] = str == null ? "null" : "not null";
        zzc2.zza(String.format("Resetting session stitching token to %s", objArr));
        this.zzm = str;
        this.zzn = zzb().currentTimeMillis();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb(String str) {
        String str2 = this.zzo;
        boolean z = str2 != null && !str2.equals(str);
        this.zzo = str;
        return z;
    }
}
