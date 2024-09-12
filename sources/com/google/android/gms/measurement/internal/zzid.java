package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
class zzid implements zzif {
    protected final zzhf zzu;

    @Pure
    public Context zza() {
        return this.zzu.zza();
    }

    @Pure
    public Clock zzb() {
        return this.zzu.zzb();
    }

    @Pure
    public zzae zzd() {
        return this.zzu.zzd();
    }

    @Pure
    public zzaf zze() {
        return this.zzu.zzf();
    }

    @Pure
    public zzba zzf() {
        return this.zzu.zzg();
    }

    @Pure
    public zzfq zzi() {
        return this.zzu.zzk();
    }

    @Pure
    public zzfr zzj() {
        return this.zzu.zzj();
    }

    @Pure
    public zzgd zzk() {
        return this.zzu.zzn();
    }

    @Pure
    public zzgy zzl() {
        return this.zzu.zzl();
    }

    @Pure
    public zznd zzq() {
        return this.zzu.zzt();
    }

    zzid(zzhf zzhf) {
        Preconditions.checkNotNull(zzhf);
        this.zzu = zzhf;
    }

    public void zzr() {
        this.zzu.zzl().zzr();
    }

    public void zzs() {
        this.zzu.zzy();
    }

    public void zzt() {
        this.zzu.zzl().zzt();
    }
}
