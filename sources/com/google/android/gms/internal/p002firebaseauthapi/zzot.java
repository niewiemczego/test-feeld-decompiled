package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzot  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzot implements zzow {
    private final String zza;
    private final zzxr zzb;
    private final zzahm zzc;
    private final zzux.zzb zzd;
    private final zzvt zze;
    @Nullable
    private final Integer zzf;

    public static zzot zza(String str, zzahm zzahm, zzux.zzb zzb2, zzvt zzvt, @Nullable Integer num) throws GeneralSecurityException {
        if (zzvt == zzvt.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new zzot(str, zzahm, zzb2, zzvt, num);
    }

    public final zzux.zzb zza() {
        return this.zzd;
    }

    public final zzvt zzc() {
        return this.zze;
    }

    public final zzxr zzb() {
        return this.zzb;
    }

    public final zzahm zzd() {
        return this.zzc;
    }

    @Nullable
    public final Integer zze() {
        return this.zzf;
    }

    public final String zzf() {
        return this.zza;
    }

    private zzot(String str, zzahm zzahm, zzux.zzb zzb2, zzvt zzvt, @Nullable Integer num) {
        this.zza = str;
        this.zzb = zzpg.zzb(str);
        this.zzc = zzahm;
        this.zzd = zzb2;
        this.zze = zzvt;
        this.zzf = num;
    }
}
