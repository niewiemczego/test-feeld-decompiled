package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzcp;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzlx extends zze {
    protected final zzmf zza = new zzmf(this);
    protected final zzmd zzb = new zzmd(this);
    /* access modifiers changed from: private */
    public Handler zzc;
    private boolean zzd = true;
    private final zzmc zze = new zzmc(this);

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

    static /* synthetic */ void zza(zzlx zzlx, long j) {
        zzlx.zzt();
        zzlx.zzab();
        zzlx.zzj().zzp().zza("Activity paused, time", Long.valueOf(j));
        zzlx.zze.zza(j);
        if (zzlx.zze().zzu()) {
            zzlx.zzb.zzb(j);
        }
    }

    static /* synthetic */ void zzb(zzlx zzlx, long j) {
        zzlx.zzt();
        zzlx.zzab();
        zzlx.zzj().zzp().zza("Activity resumed, time", Long.valueOf(j));
        if (zzlx.zze().zza(zzbi.zzcj)) {
            if (zzlx.zze().zzu() || zzlx.zzd) {
                zzlx.zzb.zzc(j);
            }
        } else if (zzlx.zze().zzu() || zzlx.zzk().zzn.zza()) {
            zzlx.zzb.zzc(j);
        }
        zzlx.zze.zza();
        zzmf zzmf = zzlx.zza;
        zzmf.zza.zzt();
        if (zzmf.zza.zzu.zzac()) {
            zzmf.zza(zzmf.zza.zzb().currentTimeMillis(), false);
        }
    }

    zzlx(zzhf zzhf) {
        super(zzhf);
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

    /* access modifiers changed from: private */
    public final void zzab() {
        zzt();
        if (this.zzc == null) {
            this.zzc = new zzcp(Looper.getMainLooper());
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        zzt();
        this.zzd = z;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzaa() {
        zzt();
        return this.zzd;
    }

    public final boolean zza(boolean z, boolean z2, long j) {
        return this.zzb.zza(z, z2, j);
    }
}
