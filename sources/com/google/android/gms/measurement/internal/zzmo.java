package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
abstract class zzmo extends zzml {
    private boolean zza;

    zzmo(zzmp zzmp) {
        super(zzmp);
        this.zzf.zzu();
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzc();

    /* access modifiers changed from: protected */
    public final void zzak() {
        if (!zzam()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzal() {
        if (!this.zza) {
            zzc();
            this.zzf.zzt();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzam() {
        return this.zza;
    }
}
