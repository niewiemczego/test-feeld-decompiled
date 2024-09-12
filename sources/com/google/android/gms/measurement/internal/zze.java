package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
abstract class zze extends zzf {
    private boolean zza;

    zze(zzhf zzhf) {
        super(zzhf);
        this.zzu.zzaa();
    }

    /* access modifiers changed from: protected */
    public void zzx() {
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzz();

    /* access modifiers changed from: protected */
    public final void zzu() {
        if (!zzy()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzv() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zzz()) {
            this.zzu.zzz();
            this.zza = true;
        }
    }

    public final void zzw() {
        if (!this.zza) {
            zzx();
            this.zzu.zzz();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzy() {
        return this.zza;
    }
}
