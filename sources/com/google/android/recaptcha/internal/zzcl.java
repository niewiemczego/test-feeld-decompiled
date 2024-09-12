package com.google.android.recaptcha.internal;

import java.util.HashMap;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzcl {
    private final zzaa zza;
    private final zzck zzb;
    private final HashMap zzc;
    private final zzcd zzd;
    private final zzag zze;

    public zzcl(zzcd zzcd, zzag zzag, zzaa zzaa) {
        this.zzd = zzcd;
        this.zze = zzag;
        this.zza = zzaa;
        zzck zzck = new zzck();
        this.zzb = zzck;
        HashMap hashMap = new HashMap();
        this.zzc = hashMap;
        zzck.zze(173, hashMap);
    }

    public final zzaa zza() {
        return this.zza;
    }

    public final zzck zzb() {
        return this.zzb;
    }

    public final void zzc() {
        this.zzb.zzd();
        this.zzb.zze(173, this.zzc);
    }

    public final zzag zzd() {
        return this.zze;
    }

    public final zzcd zze() {
        return this.zzd;
    }

    public final void zzf(int i, Object obj) {
        this.zzc.put(Integer.valueOf(i - 2), obj);
    }
}
