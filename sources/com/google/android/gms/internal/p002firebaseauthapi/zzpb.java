package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzpb {
    private final Class<? extends zzow> zza;
    private final zzxr zzb;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        String simpleName = this.zza.getSimpleName();
        return simpleName + ", object identifier: " + String.valueOf(this.zzb);
    }

    private zzpb(Class<? extends zzow> cls, zzxr zzxr) {
        this.zza = cls;
        this.zzb = zzxr;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzpb)) {
            return false;
        }
        zzpb zzpb = (zzpb) obj;
        if (!zzpb.zza.equals(this.zza) || !zzpb.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }
}
