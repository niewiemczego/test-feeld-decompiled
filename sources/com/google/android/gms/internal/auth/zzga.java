package com.google.android.gms.internal.auth;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzga implements zzgh {
    private final zzfw zza;
    private final zzgy zzb;
    private final zzel zzc;

    private zzga(zzgy zzgy, zzel zzel, zzfw zzfw) {
        this.zzb = zzgy;
        this.zzc = zzel;
        this.zza = zzfw;
    }

    static zzga zzb(zzgy zzgy, zzel zzel, zzfw zzfw) {
        return new zzga(zzgy, zzel, zzfw);
    }

    public final int zza(Object obj) {
        return this.zzb.zza(obj).hashCode();
    }

    public final Object zzd() {
        return ((zzes) ((zzeu) this.zza).zzi(5, (Object) null, (Object) null)).zzg();
    }

    public final void zze(Object obj) {
        this.zzb.zze(obj);
        this.zzc.zzb(obj);
    }

    public final void zzf(Object obj, Object obj2) {
        zzgj.zzf(this.zzb, obj, obj2);
    }

    public final void zzg(Object obj, byte[] bArr, int i, int i2, zzds zzds) throws IOException {
        zzeu zzeu = (zzeu) obj;
        if (zzeu.zzc == zzgz.zza()) {
            zzeu.zzc = zzgz.zzc();
        }
        zzet zzet = (zzet) obj;
        throw null;
    }

    public final boolean zzh(Object obj, Object obj2) {
        return this.zzb.zza(obj).equals(this.zzb.zza(obj2));
    }

    public final boolean zzi(Object obj) {
        this.zzc.zza(obj);
        throw null;
    }
}
