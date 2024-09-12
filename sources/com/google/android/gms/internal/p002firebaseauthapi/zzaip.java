package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaip  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzaip {
    static final zzaip zza = new zzaip(true);
    private static volatile boolean zzb = false;
    private static boolean zzc = true;
    private final Map<zzaio, zzaja.zzf<?, ?>> zzd;

    public static zzaip zza() {
        return zza;
    }

    public final <ContainingType extends zzakk> zzaja.zzf<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.zzd.get(new zzaio(containingtype, i));
    }

    zzaip() {
        this.zzd = new HashMap();
    }

    private zzaip(boolean z) {
        this.zzd = Collections.emptyMap();
    }
}
