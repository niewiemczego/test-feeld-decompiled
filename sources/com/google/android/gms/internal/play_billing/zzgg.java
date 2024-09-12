package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzgg implements zzgm {
    private final zzgc zza;
    private final zzhd zzb;
    private final boolean zzc;
    private final zzek zzd;

    private zzgg(zzhd zzhd, zzek zzek, zzgc zzgc) {
        this.zzb = zzhd;
        this.zzc = zzek.zzc(zzgc);
        this.zzd = zzek;
        this.zza = zzgc;
    }

    static zzgg zzc(zzhd zzhd, zzek zzek, zzgc zzgc) {
        return new zzgg(zzhd, zzek, zzgc);
    }

    public final int zza(Object obj) {
        zzhd zzhd = this.zzb;
        int zzb2 = zzhd.zzb(zzhd.zzd(obj));
        if (!this.zzc) {
            return zzb2;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzd(obj).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final Object zze() {
        zzgc zzgc = this.zza;
        if (zzgc instanceof zzex) {
            return ((zzex) zzgc).zzi();
        }
        return zzgc.zzk().zze();
    }

    public final void zzf(Object obj) {
        this.zzb.zzg(obj);
        this.zzd.zzb(obj);
    }

    public final void zzg(Object obj, Object obj2) {
        zzgo.zzp(this.zzb, obj, obj2);
        if (this.zzc) {
            this.zzd.zza(obj2);
            throw null;
        }
    }

    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzdj zzdj) throws IOException {
        zzex zzex = (zzex) obj;
        if (zzex.zzc == zzhe.zzc()) {
            zzex.zzc = zzhe.zzf();
        }
        zzeu zzeu = (zzeu) obj;
        throw null;
    }

    public final void zzi(Object obj, zzhv zzhv) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }

    public final boolean zzj(Object obj, Object obj2) {
        zzhd zzhd = this.zzb;
        if (!zzhd.zzd(obj).equals(zzhd.zzd(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    public final boolean zzk(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }
}
