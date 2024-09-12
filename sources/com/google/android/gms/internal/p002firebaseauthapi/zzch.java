package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzch  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzch<P> {
    private final ConcurrentMap<zzcl, List<zzcm<P>>> zza;
    private final List<zzcm<P>> zzb;
    private zzcm<P> zzc;
    private final Class<P> zzd;
    private final zzrl zze;
    private final boolean zzf;

    @Nullable
    public final zzcm<P> zza() {
        return this.zzc;
    }

    public final zzrl zzb() {
        return this.zze;
    }

    public final Class<P> zzc() {
        return this.zzd;
    }

    public final Collection<List<zzcm<P>>> zzd() {
        return this.zza.values();
    }

    public final List<zzcm<P>> zza(byte[] bArr) {
        List<zzcm<P>> list = (List) this.zza.get(new zzcl(bArr));
        if (list != null) {
            return list;
        }
        return Collections.emptyList();
    }

    public final List<zzcm<P>> zze() {
        return zza(zzbo.zza);
    }

    private zzch(ConcurrentMap<zzcl, List<zzcm<P>>> concurrentMap, List<zzcm<P>> list, zzcm<P> zzcm, zzrl zzrl, Class<P> cls) {
        this.zza = concurrentMap;
        this.zzb = list;
        this.zzc = zzcm;
        this.zzd = cls;
        this.zze = zzrl;
        this.zzf = false;
    }

    public final boolean zzf() {
        return !this.zze.zza().isEmpty();
    }
}
