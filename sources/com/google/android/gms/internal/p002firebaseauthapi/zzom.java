package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzom  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzom {
    private final Class<?> zza;
    private final Class<?> zzb;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        String simpleName = this.zza.getSimpleName();
        return simpleName + " with primitive type: " + this.zzb.getSimpleName();
    }

    private zzom(Class<?> cls, Class<?> cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzom)) {
            return false;
        }
        zzom zzom = (zzom) obj;
        if (!zzom.zza.equals(this.zza) || !zzom.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }
}
