package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzpd {
    private final Class<?> zza;
    private final Class<? extends zzow> zzb;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        String simpleName = this.zza.getSimpleName();
        return simpleName + " with serialization type: " + this.zzb.getSimpleName();
    }

    private zzpd(Class<?> cls, Class<? extends zzow> cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzpd)) {
            return false;
        }
        zzpd zzpd = (zzpd) obj;
        if (!zzpd.zza.equals(this.zza) || !zzpd.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }
}
