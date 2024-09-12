package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzos  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzos implements zzow {
    private final zzxr zza;
    private final zzvd zzb;

    public static zzos zza(zzvd zzvd) throws GeneralSecurityException {
        return new zzos(zzvd, zzpg.zza(zzvd.zzf()));
    }

    public static zzos zzb(zzvd zzvd) {
        return new zzos(zzvd, zzpg.zzb(zzvd.zzf()));
    }

    public final zzvd zza() {
        return this.zzb;
    }

    public final zzxr zzb() {
        return this.zza;
    }

    private zzos(zzvd zzvd, zzxr zzxr) {
        this.zzb = zzvd;
        this.zza = zzxr;
    }
}
