package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zziq implements zzii {
    final int zza;
    final zzmb zzb;

    zziq(zziw zziw, int i, zzmb zzmb, boolean z, boolean z2) {
        this.zza = i;
        this.zzb = zzmb;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return this.zza - ((zziq) obj).zza;
    }

    public final int zza() {
        return this.zza;
    }

    public final zzkd zzb(zzkd zzkd, zzke zzke) {
        ((zzin) zzkd).zzg((zzit) zzke);
        return zzkd;
    }

    public final zzkj zzc(zzkj zzkj, zzkj zzkj2) {
        throw new UnsupportedOperationException();
    }

    public final zzmb zzd() {
        return this.zzb;
    }

    public final zzmc zze() {
        return this.zzb.zza();
    }

    public final boolean zzf() {
        return false;
    }

    public final boolean zzg() {
        return false;
    }
}
