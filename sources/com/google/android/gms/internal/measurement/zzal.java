package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public abstract class zzal implements zzak, zzaq {
    protected final String zza;
    protected final Map<String, zzaq> zzb = new HashMap();

    public int hashCode() {
        String str = this.zza;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public abstract zzaq zza(zzh zzh, List<zzaq> list);

    public zzaq zzc() {
        return this;
    }

    public final zzaq zza(String str, zzh zzh, List<zzaq> list) {
        if ("toString".equals(str)) {
            return new zzas(this.zza);
        }
        return zzan.zza(this, new zzas(str), zzh, list);
    }

    public final zzaq zza(String str) {
        if (this.zzb.containsKey(str)) {
            return this.zzb.get(str);
        }
        return zzc;
    }

    public final Boolean zzd() {
        return true;
    }

    public final Double zze() {
        return Double.valueOf(Double.NaN);
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzf() {
        return this.zza;
    }

    public final Iterator<zzaq> zzh() {
        return zzan.zza(this.zzb);
    }

    public zzal(String str) {
        this.zza = str;
    }

    public final void zza(String str, zzaq zzaq) {
        if (zzaq == null) {
            this.zzb.remove(str);
        } else {
            this.zzb.put(str, zzaq);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzal)) {
            return false;
        }
        zzal zzal = (zzal) obj;
        String str = this.zza;
        if (str != null) {
            return str.equals(zzal.zza);
        }
        return false;
    }

    public final boolean zzc(String str) {
        return this.zzb.containsKey(str);
    }
}
