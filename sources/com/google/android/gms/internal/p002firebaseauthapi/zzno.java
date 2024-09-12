package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzno  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzno {
    private static final zzno zza = new zzno();
    private static final zznr zzb = new zznr();
    private final AtomicReference<zzrq> zzc = new AtomicReference<>();

    public static zzno zza() {
        return zza;
    }

    public final zzrq zzb() {
        zzrq zzrq = this.zzc.get();
        return zzrq == null ? zzb : zzrq;
    }
}
