package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
abstract class zzic extends zzid {
    private boolean zza;

    zzic(zzhf zzhf) {
        super(zzhf);
        this.zzu.zzaa();
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzo();

    /* access modifiers changed from: protected */
    public void zzz() {
    }

    /* access modifiers changed from: protected */
    public final void zzab() {
        if (!zzae()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzac() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zzo()) {
            this.zzu.zzz();
            this.zza = true;
        }
    }

    public final void zzad() {
        if (!this.zza) {
            zzz();
            this.zzu.zzz();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzae() {
        return this.zza;
    }
}
