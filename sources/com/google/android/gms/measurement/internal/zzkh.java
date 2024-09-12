package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.sentry.protocol.App;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzkh extends zze {
    protected zzki zza;
    private volatile zzki zzb;
    private volatile zzki zzc;
    private final Map<Activity, zzki> zzd = new ConcurrentHashMap();
    private Activity zze;
    private volatile boolean zzf;
    private volatile zzki zzg;
    /* access modifiers changed from: private */
    public zzki zzh;
    private boolean zzi;
    private final Object zzj = new Object();

    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    /* access modifiers changed from: protected */
    public final boolean zzz() {
        return false;
    }

    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    public final /* bridge */ /* synthetic */ zzb zzc() {
        return super.zzc();
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

    private final zzki zzd(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzki zzki = this.zzd.get(activity);
        if (zzki == null) {
            zzki zzki2 = new zzki((String) null, zza(activity.getClass(), "Activity"), zzq().zzm());
            this.zzd.put(activity, zzki2);
            zzki = zzki2;
        }
        return this.zzg != null ? this.zzg : zzki;
    }

    public final zzki zzaa() {
        return this.zzb;
    }

    public final zzki zza(boolean z) {
        zzu();
        zzt();
        if (!z) {
            return this.zza;
        }
        zzki zzki = this.zza;
        return zzki != null ? zzki : this.zzh;
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

    private final String zza(Class<?> cls, String str) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return str;
        }
        String[] split = canonicalName.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > zze().zzb((String) null) ? str2.substring(0, zze().zzb((String) null)) : str2;
    }

    static /* synthetic */ void zza(zzkh zzkh, Bundle bundle, zzki zzki, zzki zzki2, long j) {
        if (bundle != null) {
            bundle.remove(FirebaseAnalytics.Param.SCREEN_NAME);
            bundle.remove(FirebaseAnalytics.Param.SCREEN_CLASS);
        }
        zzkh.zza(zzki, zzki2, j, true, zzkh.zzq().zza((String) null, FirebaseAnalytics.Event.SCREEN_VIEW, bundle, (List<String>) null, false));
    }

    public zzkh(zzhf zzhf) {
        super(zzhf);
    }

    private final void zza(Activity activity, zzki zzki, boolean z) {
        zzki zzki2;
        zzki zzki3 = zzki;
        zzki zzki4 = this.zzb == null ? this.zzc : this.zzb;
        if (zzki3.zzb == null) {
            zzki2 = new zzki(zzki3.zza, activity != null ? zza(activity.getClass(), "Activity") : null, zzki3.zzc, zzki3.zze, zzki3.zzf);
        } else {
            zzki2 = zzki3;
        }
        this.zzc = this.zzb;
        this.zzb = zzki2;
        zzl().zzb((Runnable) new zzkm(this, zzki2, zzki4, zzb().elapsedRealtime(), z));
    }

    /* access modifiers changed from: private */
    public final void zza(zzki zzki, zzki zzki2, long j, boolean z, Bundle bundle) {
        Bundle bundle2;
        zzki zzki3 = zzki;
        zzki zzki4 = zzki2;
        long j2 = j;
        Bundle bundle3 = bundle;
        zzt();
        boolean z2 = false;
        boolean z3 = zzki4 == null || zzki4.zzc != zzki3.zzc || !zzkk.zza(zzki4.zzb, zzki3.zzb) || !zzkk.zza(zzki4.zza, zzki3.zza);
        if (z && this.zza != null) {
            z2 = true;
        }
        if (z3) {
            if (bundle3 == null) {
                bundle2 = new Bundle();
            }
            Bundle bundle4 = bundle2;
            zznd.zza(zzki3, bundle4, true);
            if (zzki4 != null) {
                if (zzki4.zza != null) {
                    bundle4.putString("_pn", zzki4.zza);
                }
                if (zzki4.zzb != null) {
                    bundle4.putString("_pc", zzki4.zzb);
                }
                bundle4.putLong("_pi", zzki4.zzc);
            }
            if (z2) {
                long zza2 = zzp().zzb.zza(j2);
                if (zza2 > 0) {
                    zzq().zza(bundle4, zza2);
                }
            }
            if (!zze().zzu()) {
                bundle4.putLong("_mst", 1);
            }
            zzm().zza(zzki3.zze ? App.TYPE : "auto", "_vs", (!zzki3.zze || zzki3.zzf == 0) ? zzb().currentTimeMillis() : zzki3.zzf, bundle4);
        }
        if (z2) {
            zza(this.zza, true, j2);
        }
        this.zza = zzki3;
        if (zzki3.zze) {
            this.zzh = zzki3;
        }
        zzo().zza(zzki3);
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

    public final void zza(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (zze().zzu() && bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.zzd.put(activity, new zzki(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
        }
    }

    public final void zza(Activity activity) {
        synchronized (this.zzj) {
            if (activity == this.zze) {
                this.zze = null;
            }
        }
        if (zze().zzu()) {
            this.zzd.remove(activity);
        }
    }

    public final void zzb(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = false;
            this.zzf = true;
        }
        long elapsedRealtime = zzb().elapsedRealtime();
        if (!zze().zzu()) {
            this.zzb = null;
            zzl().zzb((Runnable) new zzko(this, elapsedRealtime));
            return;
        }
        zzki zzd2 = zzd(activity);
        this.zzc = this.zzb;
        this.zzb = null;
        zzl().zzb((Runnable) new zzkn(this, zzd2, elapsedRealtime));
    }

    public final void zzc(Activity activity) {
        synchronized (this.zzj) {
            this.zzi = true;
            if (activity != this.zze) {
                synchronized (this.zzj) {
                    this.zze = activity;
                    this.zzf = false;
                }
                if (zze().zzu()) {
                    this.zzg = null;
                    zzl().zzb((Runnable) new zzkq(this));
                }
            }
        }
        if (!zze().zzu()) {
            this.zzb = this.zzg;
            zzl().zzb((Runnable) new zzkl(this));
            return;
        }
        zza(activity, zzd(activity), false);
        zzb zzc2 = zzc();
        zzc2.zzl().zzb((Runnable) new zzc(zzc2, zzc2.zzb().elapsedRealtime()));
    }

    public final void zzb(Activity activity, Bundle bundle) {
        zzki zzki;
        if (zze().zzu() && bundle != null && (zzki = this.zzd.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", zzki.zzc);
            bundle2.putString("name", zzki.zza);
            bundle2.putString("referrer_name", zzki.zzb);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(zzki zzki, boolean z, long j) {
        zzc().zza(zzb().elapsedRealtime());
        if (zzp().zza(zzki != null && zzki.zzd, z, j) && zzki != null) {
            zzki.zzd = false;
        }
    }

    @Deprecated
    public final void zza(Activity activity, String str, String str2) {
        if (!zze().zzu()) {
            zzj().zzv().zza("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        zzki zzki = this.zzb;
        if (zzki == null) {
            zzj().zzv().zza("setCurrentScreen cannot be called while no activity active");
        } else if (this.zzd.get(activity) == null) {
            zzj().zzv().zza("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = zza(activity.getClass(), "Activity");
            }
            boolean zza2 = zzkk.zza(zzki.zzb, str2);
            boolean zza3 = zzkk.zza(zzki.zza, str);
            if (zza2 && zza3) {
                zzj().zzv().zza("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > zze().zzb((String) null))) {
                zzj().zzv().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= zze().zzb((String) null))) {
                zzj().zzp().zza("Setting current screen to name, class", str == null ? "null" : str, str2);
                zzki zzki2 = new zzki(str, str2, zzq().zzm());
                this.zzd.put(activity, zzki2);
                zza(activity, zzki2, true);
            } else {
                zzj().zzv().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c2, code lost:
        r0 = zzj().zzp();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00cc, code lost:
        if (r3 != null) goto L_0x00d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ce, code lost:
        r2 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d1, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d2, code lost:
        if (r4 != null) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d4, code lost:
        r5 = "null";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d7, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d8, code lost:
        r0.zza("Logging screen view with name, class", r2, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00dd, code lost:
        if (r12.zzb != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00df, code lost:
        r0 = r12.zzc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e2, code lost:
        r0 = r12.zzb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e4, code lost:
        r2 = new com.google.android.gms.measurement.internal.zzki(r3, r4, zzq().zzm(), true, r14);
        r12.zzb = r2;
        r12.zzc = r0;
        r12.zzg = r2;
        zzl().zzb((java.lang.Runnable) new com.google.android.gms.measurement.internal.zzkj(r12, r13, r2, r0, zzb().elapsedRealtime()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0113, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.os.Bundle r13, long r14) {
        /*
            r12 = this;
            java.lang.Object r0 = r12.zzj
            monitor-enter(r0)
            boolean r1 = r12.zzi     // Catch:{ all -> 0x0114 }
            if (r1 != 0) goto L_0x0016
            com.google.android.gms.measurement.internal.zzfr r13 = r12.zzj()     // Catch:{ all -> 0x0114 }
            com.google.android.gms.measurement.internal.zzft r13 = r13.zzv()     // Catch:{ all -> 0x0114 }
            java.lang.String r14 = "Cannot log screen view event when the app is in the background."
            r13.zza(r14)     // Catch:{ all -> 0x0114 }
            monitor-exit(r0)     // Catch:{ all -> 0x0114 }
            return
        L_0x0016:
            r1 = 0
            if (r13 == 0) goto L_0x0082
            java.lang.String r2 = "screen_name"
            java.lang.String r2 = r13.getString(r2)     // Catch:{ all -> 0x0114 }
            if (r2 == 0) goto L_0x004c
            int r3 = r2.length()     // Catch:{ all -> 0x0114 }
            if (r3 <= 0) goto L_0x0035
            int r3 = r2.length()     // Catch:{ all -> 0x0114 }
            com.google.android.gms.measurement.internal.zzaf r4 = r12.zze()     // Catch:{ all -> 0x0114 }
            int r4 = r4.zzb(r1)     // Catch:{ all -> 0x0114 }
            if (r3 <= r4) goto L_0x004c
        L_0x0035:
            com.google.android.gms.measurement.internal.zzfr r13 = r12.zzj()     // Catch:{ all -> 0x0114 }
            com.google.android.gms.measurement.internal.zzft r13 = r13.zzv()     // Catch:{ all -> 0x0114 }
            java.lang.String r14 = "Invalid screen name length for screen view. Length"
            int r15 = r2.length()     // Catch:{ all -> 0x0114 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x0114 }
            r13.zza(r14, r15)     // Catch:{ all -> 0x0114 }
            monitor-exit(r0)     // Catch:{ all -> 0x0114 }
            return
        L_0x004c:
            java.lang.String r3 = "screen_class"
            java.lang.String r3 = r13.getString(r3)     // Catch:{ all -> 0x0114 }
            if (r3 == 0) goto L_0x007f
            int r4 = r3.length()     // Catch:{ all -> 0x0114 }
            if (r4 <= 0) goto L_0x0068
            int r4 = r3.length()     // Catch:{ all -> 0x0114 }
            com.google.android.gms.measurement.internal.zzaf r5 = r12.zze()     // Catch:{ all -> 0x0114 }
            int r1 = r5.zzb(r1)     // Catch:{ all -> 0x0114 }
            if (r4 <= r1) goto L_0x007f
        L_0x0068:
            com.google.android.gms.measurement.internal.zzfr r13 = r12.zzj()     // Catch:{ all -> 0x0114 }
            com.google.android.gms.measurement.internal.zzft r13 = r13.zzv()     // Catch:{ all -> 0x0114 }
            java.lang.String r14 = "Invalid screen class length for screen view. Length"
            int r15 = r3.length()     // Catch:{ all -> 0x0114 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x0114 }
            r13.zza(r14, r15)     // Catch:{ all -> 0x0114 }
            monitor-exit(r0)     // Catch:{ all -> 0x0114 }
            return
        L_0x007f:
            r1 = r3
            r3 = r2
            goto L_0x0083
        L_0x0082:
            r3 = r1
        L_0x0083:
            if (r1 != 0) goto L_0x0096
            android.app.Activity r1 = r12.zze     // Catch:{ all -> 0x0114 }
            if (r1 == 0) goto L_0x0094
            java.lang.Class r1 = r1.getClass()     // Catch:{ all -> 0x0114 }
            java.lang.String r2 = "Activity"
            java.lang.String r1 = r12.zza((java.lang.Class<?>) r1, (java.lang.String) r2)     // Catch:{ all -> 0x0114 }
            goto L_0x0096
        L_0x0094:
            java.lang.String r1 = "Activity"
        L_0x0096:
            r4 = r1
            com.google.android.gms.measurement.internal.zzki r1 = r12.zzb     // Catch:{ all -> 0x0114 }
            boolean r2 = r12.zzf     // Catch:{ all -> 0x0114 }
            if (r2 == 0) goto L_0x00c1
            if (r1 == 0) goto L_0x00c1
            r2 = 0
            r12.zzf = r2     // Catch:{ all -> 0x0114 }
            java.lang.String r2 = r1.zzb     // Catch:{ all -> 0x0114 }
            boolean r2 = com.google.android.gms.measurement.internal.zzkk.zza(r2, r4)     // Catch:{ all -> 0x0114 }
            java.lang.String r1 = r1.zza     // Catch:{ all -> 0x0114 }
            boolean r1 = com.google.android.gms.measurement.internal.zzkk.zza(r1, r3)     // Catch:{ all -> 0x0114 }
            if (r2 == 0) goto L_0x00c1
            if (r1 == 0) goto L_0x00c1
            com.google.android.gms.measurement.internal.zzfr r13 = r12.zzj()     // Catch:{ all -> 0x0114 }
            com.google.android.gms.measurement.internal.zzft r13 = r13.zzv()     // Catch:{ all -> 0x0114 }
            java.lang.String r14 = "Ignoring call to log screen view event with duplicate parameters."
            r13.zza(r14)     // Catch:{ all -> 0x0114 }
            monitor-exit(r0)     // Catch:{ all -> 0x0114 }
            return
        L_0x00c1:
            monitor-exit(r0)     // Catch:{ all -> 0x0114 }
            com.google.android.gms.measurement.internal.zzfr r0 = r12.zzj()
            com.google.android.gms.measurement.internal.zzft r0 = r0.zzp()
            java.lang.String r1 = "Logging screen view with name, class"
            if (r3 != 0) goto L_0x00d1
            java.lang.String r2 = "null"
            goto L_0x00d2
        L_0x00d1:
            r2 = r3
        L_0x00d2:
            if (r4 != 0) goto L_0x00d7
            java.lang.String r5 = "null"
            goto L_0x00d8
        L_0x00d7:
            r5 = r4
        L_0x00d8:
            r0.zza(r1, r2, r5)
            com.google.android.gms.measurement.internal.zzki r0 = r12.zzb
            if (r0 != 0) goto L_0x00e2
            com.google.android.gms.measurement.internal.zzki r0 = r12.zzc
            goto L_0x00e4
        L_0x00e2:
            com.google.android.gms.measurement.internal.zzki r0 = r12.zzb
        L_0x00e4:
            com.google.android.gms.measurement.internal.zzki r1 = new com.google.android.gms.measurement.internal.zzki
            com.google.android.gms.measurement.internal.zznd r2 = r12.zzq()
            long r5 = r2.zzm()
            r7 = 1
            r2 = r1
            r8 = r14
            r2.<init>(r3, r4, r5, r7, r8)
            r12.zzb = r1
            r12.zzc = r0
            r12.zzg = r1
            com.google.android.gms.common.util.Clock r14 = r12.zzb()
            long r10 = r14.elapsedRealtime()
            com.google.android.gms.measurement.internal.zzgy r14 = r12.zzl()
            com.google.android.gms.measurement.internal.zzkj r15 = new com.google.android.gms.measurement.internal.zzkj
            r5 = r15
            r6 = r12
            r7 = r13
            r8 = r1
            r9 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            r14.zzb((java.lang.Runnable) r15)
            return
        L_0x0114:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0114 }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkh.zza(android.os.Bundle, long):void");
    }
}
