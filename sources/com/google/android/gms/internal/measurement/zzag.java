package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzag implements zzaq {
    private final boolean zza;

    public final int hashCode() {
        return Boolean.valueOf(this.zza).hashCode();
    }

    public final Iterator<zzaq> zzh() {
        return null;
    }

    public final zzaq zza(String str, zzh zzh, List<zzaq> list) {
        if ("toString".equals(str)) {
            return new zzas(Boolean.toString(this.zza));
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", new Object[]{Boolean.toString(this.zza), str}));
    }

    public final zzaq zzc() {
        return new zzag(Boolean.valueOf(this.zza));
    }

    public final Boolean zzd() {
        return Boolean.valueOf(this.zza);
    }

    public final Double zze() {
        return Double.valueOf(this.zza ? 1.0d : 0.0d);
    }

    public final String zzf() {
        return Boolean.toString(this.zza);
    }

    public final String toString() {
        return String.valueOf(this.zza);
    }

    public zzag(Boolean bool) {
        if (bool == null) {
            this.zza = false;
        } else {
            this.zza = bool.booleanValue();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zzag) && this.zza == ((zzag) obj).zza;
    }
}
