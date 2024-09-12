package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzcv;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzkp extends zze {
    /* access modifiers changed from: private */
    public final zzlm zza;
    /* access modifiers changed from: private */
    public zzfk zzb;
    private volatile Boolean zzc;
    private final zzaw zzd;
    private final zzmi zze;
    private final List<Runnable> zzf = new ArrayList();
    private final zzaw zzg;

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

    private final zzo zzb(boolean z) {
        return zzg().zza(z ? zzj().zzx() : null);
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzae zzd() {
        return super.zzd();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzaf zze() {
        return super.zze();
    }

    /* access modifiers changed from: protected */
    public final zzam zzaa() {
        zzt();
        zzu();
        zzfk zzfk = this.zzb;
        if (zzfk == null) {
            zzad();
            zzj().zzc().zza("Failed to get consents; not connected to service yet.");
            return null;
        }
        zzo zzb2 = zzb(false);
        Preconditions.checkNotNull(zzb2);
        try {
            zzam zza2 = zzfk.zza(zzb2);
            zzal();
            return zza2;
        } catch (RemoteException e) {
            zzj().zzg().zza("Failed to get consents; remote exception", e);
            return null;
        }
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
    public final Boolean zzab() {
        return this.zzc;
    }

    static /* synthetic */ void zzd(zzkp zzkp) {
        zzkp.zzt();
        if (zzkp.zzah()) {
            zzkp.zzj().zzp().zza("Inactivity, disconnecting from the service");
            zzkp.zzae();
        }
    }

    static /* synthetic */ void zza(zzkp zzkp, ComponentName componentName) {
        zzkp.zzt();
        if (zzkp.zzb != null) {
            zzkp.zzb = null;
            zzkp.zzj().zzp().zza("Disconnected from device MeasurementService", componentName);
            zzkp.zzt();
            zzkp.zzad();
        }
    }

    protected zzkp(zzhf zzhf) {
        super(zzhf);
        this.zze = new zzmi(zzhf.zzb());
        this.zza = new zzlm(this);
        this.zzd = new zzks(this, zzhf);
        this.zzg = new zzlb(this, zzhf);
    }

    /* access modifiers changed from: protected */
    public final void zzac() {
        zzt();
        zzu();
        zzo zzb2 = zzb(true);
        zzh().zzab();
        zza((Runnable) new zzla(this, zzb2));
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

    /* access modifiers changed from: package-private */
    public final void zzad() {
        zzt();
        zzu();
        if (!zzah()) {
            if (zzam()) {
                this.zza.zza();
            } else if (!zze().zzw()) {
                List<ResolveInfo> queryIntentServices = zza().getPackageManager().queryIntentServices(new Intent().setClassName(zza(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
                if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                    Intent intent = new Intent("com.google.android.gms.measurement.START");
                    intent.setComponent(new ComponentName(zza(), "com.google.android.gms.measurement.AppMeasurementService"));
                    this.zza.zza(intent);
                    return;
                }
                zzj().zzg().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    public final void zzae() {
        zzt();
        zzu();
        this.zza.zzb();
        try {
            ConnectionTracker.getInstance().unbindService(zza(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    /* access modifiers changed from: private */
    public final void zzak() {
        zzt();
        zzj().zzp().zza("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        for (Runnable run : this.zzf) {
            try {
                run.run();
            } catch (RuntimeException e) {
                zzj().zzg().zza("Task exception while flushing queue", e);
            }
        }
        this.zzf.clear();
        this.zzg.zza();
    }

    public final void zza(zzcv zzcv) {
        zzt();
        zzu();
        zza((Runnable) new zzkx(this, zzb(false), zzcv));
    }

    public final void zza(AtomicReference<String> atomicReference) {
        zzt();
        zzu();
        zza((Runnable) new zzky(this, atomicReference, zzb(false)));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzcv zzcv, String str, String str2) {
        zzt();
        zzu();
        zza((Runnable) new zzlk(this, str, str2, zzb(false), zzcv));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzad>> atomicReference, String str, String str2, String str3) {
        zzt();
        zzu();
        zza((Runnable) new zzlh(this, atomicReference, str, str2, str3, zzb(false)));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzmh>> atomicReference, Bundle bundle) {
        zzt();
        zzu();
        zza((Runnable) new zzkt(this, atomicReference, zzb(false), bundle));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zznc>> atomicReference, boolean z) {
        zzt();
        zzu();
        zza((Runnable) new zzku(this, atomicReference, zzb(false), z));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzcv zzcv, String str, String str2, boolean z) {
        zzt();
        zzu();
        zza((Runnable) new zzkr(this, str, str2, zzb(false), z, zzcv));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zznc>> atomicReference, String str, String str2, String str3, boolean z) {
        zzt();
        zzu();
        zza((Runnable) new zzlj(this, atomicReference, str, str2, str3, zzb(false), z));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzbg zzbg, String str) {
        Preconditions.checkNotNull(zzbg);
        zzt();
        zzu();
        zza((Runnable) new zzlf(this, true, zzb(true), zzh().zza(zzbg), zzbg, str));
    }

    public final void zza(zzcv zzcv, zzbg zzbg, String str) {
        zzt();
        zzu();
        if (zzq().zza((int) GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            zzj().zzu().zza("Not bundling data. Service unavailable or out of date");
            zzq().zza(zzcv, new byte[0]);
            return;
        }
        zza((Runnable) new zzle(this, zzbg, str, zzcv));
    }

    /* access modifiers changed from: private */
    public final void zzal() {
        zzt();
        this.zze.zzb();
        this.zzd.zza(zzbi.zzaj.zza(null).longValue());
    }

    /* access modifiers changed from: protected */
    public final void zzaf() {
        zzt();
        zzu();
        zzo zzb2 = zzb(false);
        zzh().zzaa();
        zza((Runnable) new zzkv(this, zzb2));
    }

    private final void zza(Runnable runnable) throws IllegalStateException {
        zzt();
        if (zzah()) {
            runnable.run();
        } else if (((long) this.zzf.size()) >= 1000) {
            zzj().zzg().zza("Discarding data. Max runnable queue size reached");
        } else {
            this.zzf.add(runnable);
            this.zzg.zza(60000);
            zzad();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzfk zzfk, AbstractSafeParcelable abstractSafeParcelable, zzo zzo) {
        int i;
        zzt();
        zzu();
        int i2 = 0;
        int i3 = 100;
        while (i2 < 1001 && i3 == 100) {
            ArrayList arrayList = new ArrayList();
            List<AbstractSafeParcelable> zza2 = zzh().zza(100);
            if (zza2 != null) {
                arrayList.addAll(zza2);
                i = zza2.size();
            } else {
                i = 0;
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            ArrayList arrayList2 = arrayList;
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzbg) {
                    try {
                        zzfk.zza((zzbg) abstractSafeParcelable2, zzo);
                    } catch (RemoteException e) {
                        zzj().zzg().zza("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zznc) {
                    try {
                        zzfk.zza((zznc) abstractSafeParcelable2, zzo);
                    } catch (RemoteException e2) {
                        zzj().zzg().zza("Failed to send user property to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzad) {
                    try {
                        zzfk.zza((zzad) abstractSafeParcelable2, zzo);
                    } catch (RemoteException e3) {
                        zzj().zzg().zza("Failed to send conditional user property to the service", e3);
                    }
                } else {
                    zzj().zzg().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i3 = i;
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(zzad zzad) {
        Preconditions.checkNotNull(zzad);
        zzt();
        zzu();
        zza((Runnable) new zzli(this, true, zzb(true), zzh().zza(zzad), new zzad(zzad), zzad));
    }

    /* access modifiers changed from: protected */
    public final void zza(boolean z) {
        zzt();
        zzu();
        if (z) {
            zzh().zzaa();
        }
        if (zzaj()) {
            zza((Runnable) new zzlg(this, zzb(false)));
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(zzki zzki) {
        zzt();
        zzu();
        zza((Runnable) new zzkz(this, zzki));
    }

    public final void zza(Bundle bundle) {
        zzt();
        zzu();
        zza((Runnable) new zzlc(this, zzb(false), bundle));
    }

    /* access modifiers changed from: protected */
    public final void zzag() {
        zzt();
        zzu();
        zza((Runnable) new zzld(this, zzb(true)));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzfk zzfk) {
        zzt();
        Preconditions.checkNotNull(zzfk);
        this.zzb = zzfk;
        zzal();
        zzak();
    }

    /* access modifiers changed from: protected */
    public final void zza(zznc zznc) {
        zzt();
        zzu();
        zza((Runnable) new zzkw(this, zzb(true), zzh().zza(zznc), zznc));
    }

    public final boolean zzah() {
        zzt();
        zzu();
        return this.zzb != null;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzai() {
        zzt();
        zzu();
        if (zzam() && zzq().zzg() < 200900) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzaj() {
        zzt();
        zzu();
        if (zzam() && zzq().zzg() < zzbi.zzbo.zza(null).intValue()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzam() {
        /*
            r5 = this;
            r5.zzt()
            r5.zzu()
            java.lang.Boolean r0 = r5.zzc
            if (r0 != 0) goto L_0x0102
            r5.zzt()
            r5.zzu()
            com.google.android.gms.measurement.internal.zzgd r0 = r5.zzk()
            java.lang.Boolean r0 = r0.zzn()
            r1 = 1
            if (r0 == 0) goto L_0x0023
            boolean r2 = r0.booleanValue()
            if (r2 == 0) goto L_0x0023
            goto L_0x00fc
        L_0x0023:
            com.google.android.gms.measurement.internal.zzfl r2 = r5.zzg()
            int r2 = r2.zzaa()
            r3 = 0
            if (r2 != r1) goto L_0x0031
        L_0x002e:
            r0 = r1
            goto L_0x00d8
        L_0x0031:
            com.google.android.gms.measurement.internal.zzfr r2 = r5.zzj()
            com.google.android.gms.measurement.internal.zzft r2 = r2.zzp()
            java.lang.String r4 = "Checking service availability"
            r2.zza(r4)
            com.google.android.gms.measurement.internal.zznd r2 = r5.zzq()
            r4 = 12451000(0xbdfcb8, float:1.7447567E-38)
            int r2 = r2.zza((int) r4)
            if (r2 == 0) goto L_0x00c9
            if (r2 == r1) goto L_0x00b9
            r4 = 2
            if (r2 == r4) goto L_0x0099
            r0 = 3
            if (r2 == r0) goto L_0x0089
            r0 = 9
            if (r2 == r0) goto L_0x007b
            r0 = 18
            if (r2 == r0) goto L_0x006d
            com.google.android.gms.measurement.internal.zzfr r0 = r5.zzj()
            com.google.android.gms.measurement.internal.zzft r0 = r0.zzu()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            java.lang.String r2 = "Unexpected service status"
            r0.zza(r2, r1)
            goto L_0x0096
        L_0x006d:
            com.google.android.gms.measurement.internal.zzfr r0 = r5.zzj()
            com.google.android.gms.measurement.internal.zzft r0 = r0.zzu()
            java.lang.String r2 = "Service updating"
            r0.zza(r2)
            goto L_0x002e
        L_0x007b:
            com.google.android.gms.measurement.internal.zzfr r0 = r5.zzj()
            com.google.android.gms.measurement.internal.zzft r0 = r0.zzu()
            java.lang.String r1 = "Service invalid"
            r0.zza(r1)
            goto L_0x0096
        L_0x0089:
            com.google.android.gms.measurement.internal.zzfr r0 = r5.zzj()
            com.google.android.gms.measurement.internal.zzft r0 = r0.zzu()
            java.lang.String r1 = "Service disabled"
            r0.zza(r1)
        L_0x0096:
            r0 = r3
            r1 = r0
            goto L_0x00d8
        L_0x0099:
            com.google.android.gms.measurement.internal.zzfr r2 = r5.zzj()
            com.google.android.gms.measurement.internal.zzft r2 = r2.zzc()
            java.lang.String r4 = "Service container out of date"
            r2.zza(r4)
            com.google.android.gms.measurement.internal.zznd r2 = r5.zzq()
            int r2 = r2.zzg()
            r4 = 17443(0x4423, float:2.4443E-41)
            if (r2 >= r4) goto L_0x00b3
            goto L_0x00c6
        L_0x00b3:
            if (r0 != 0) goto L_0x00b6
            goto L_0x00b7
        L_0x00b6:
            r1 = r3
        L_0x00b7:
            r0 = r3
            goto L_0x00d8
        L_0x00b9:
            com.google.android.gms.measurement.internal.zzfr r0 = r5.zzj()
            com.google.android.gms.measurement.internal.zzft r0 = r0.zzp()
            java.lang.String r2 = "Service missing"
            r0.zza(r2)
        L_0x00c6:
            r0 = r1
            r1 = r3
            goto L_0x00d8
        L_0x00c9:
            com.google.android.gms.measurement.internal.zzfr r0 = r5.zzj()
            com.google.android.gms.measurement.internal.zzft r0 = r0.zzp()
            java.lang.String r2 = "Service available"
            r0.zza(r2)
            goto L_0x002e
        L_0x00d8:
            if (r1 != 0) goto L_0x00f2
            com.google.android.gms.measurement.internal.zzaf r2 = r5.zze()
            boolean r2 = r2.zzw()
            if (r2 == 0) goto L_0x00f2
            com.google.android.gms.measurement.internal.zzfr r0 = r5.zzj()
            com.google.android.gms.measurement.internal.zzft r0 = r0.zzg()
            java.lang.String r2 = "No way to upload. Consider using the full version of Analytics"
            r0.zza(r2)
            goto L_0x00f3
        L_0x00f2:
            r3 = r0
        L_0x00f3:
            if (r3 == 0) goto L_0x00fc
            com.google.android.gms.measurement.internal.zzgd r0 = r5.zzk()
            r0.zza((boolean) r1)
        L_0x00fc:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r5.zzc = r0
        L_0x0102:
            java.lang.Boolean r0 = r5.zzc
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkp.zzam():boolean");
    }
}
