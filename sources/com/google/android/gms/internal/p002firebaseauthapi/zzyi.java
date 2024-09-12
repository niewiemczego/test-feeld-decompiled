package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.internal.zzbk;
import com.google.firebase.auth.zzd;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzyi {
    private String zza;
    private List<zzafq> zzb;
    private zzd zzc;

    public final zzd zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zza;
    }

    public final List<MultiFactorInfo> zzc() {
        return zzbk.zza(this.zzb);
    }

    public zzyi(String str, List<zzafq> list, zzd zzd) {
        this.zza = str;
        this.zzb = list;
        this.zzc = zzd;
    }
}
