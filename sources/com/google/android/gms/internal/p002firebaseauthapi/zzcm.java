package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcm  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzcm<P> {
    @Nullable
    private final P zza;
    @Nullable
    private final P zzb;
    private final byte[] zzc;
    private final zzvb zzd;
    private final zzvt zze;
    private final int zzf;
    private final String zzg;
    private final zzbu zzh;

    public final int zza() {
        return this.zzf;
    }

    public final zzbu zzb() {
        return this.zzh;
    }

    public final zzvb zzc() {
        return this.zzd;
    }

    public final zzvt zzd() {
        return this.zze;
    }

    @Nullable
    public final P zze() {
        return this.zza;
    }

    @Nullable
    public final P zzf() {
        return this.zzb;
    }

    public final String zzg() {
        return this.zzg;
    }

    zzcm(@Nullable P p, @Nullable P p2, byte[] bArr, zzvb zzvb, zzvt zzvt, int i, String str, zzbu zzbu) {
        this.zza = p;
        this.zzb = p2;
        this.zzc = Arrays.copyOf(bArr, bArr.length);
        this.zzd = zzvb;
        this.zze = zzvt;
        this.zzf = i;
        this.zzg = str;
        this.zzh = zzbu;
    }

    @Nullable
    public final byte[] zzh() {
        byte[] bArr = this.zzc;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}
