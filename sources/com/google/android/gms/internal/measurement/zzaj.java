package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzaj implements zzaq {
    private final zzaq zza;
    private final String zzb;

    public final int hashCode() {
        return (this.zzb.hashCode() * 31) + this.zza.hashCode();
    }

    public final Iterator<zzaq> zzh() {
        return null;
    }

    public final zzaq zza(String str, zzh zzh, List<zzaq> list) {
        throw new IllegalStateException("Control does not have functions");
    }

    public final zzaq zzc() {
        return new zzaj(this.zzb, this.zza.zzc());
    }

    public final zzaq zza() {
        return this.zza;
    }

    public final Boolean zzd() {
        throw new IllegalStateException("Control is not a boolean");
    }

    public final Double zze() {
        throw new IllegalStateException("Control is not a double");
    }

    public final String zzf() {
        throw new IllegalStateException("Control is not a String");
    }

    public final String zzb() {
        return this.zzb;
    }

    public zzaj() {
        this.zza = zzc;
        this.zzb = "return";
    }

    public zzaj(String str) {
        this.zza = zzc;
        this.zzb = str;
    }

    public zzaj(String str, zzaq zzaq) {
        this.zza = zzaq;
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaj)) {
            return false;
        }
        zzaj zzaj = (zzaj) obj;
        return this.zzb.equals(zzaj.zzb) && this.zza.equals(zzaj.zza);
    }
}
