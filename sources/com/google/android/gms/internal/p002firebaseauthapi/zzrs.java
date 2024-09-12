package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrs  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzrs {
    private final zzrl zza;
    private final List<zzru> zzb;
    @Nullable
    private final Integer zzc;

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", new Object[]{this.zza, this.zzb, this.zzc});
    }

    private zzrs(zzrl zzrl, List<zzru> list, Integer num) {
        this.zza = zzrl;
        this.zzb = list;
        this.zzc = num;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzrs)) {
            return false;
        }
        zzrs zzrs = (zzrs) obj;
        if (!this.zza.equals(zzrs.zza) || !this.zzb.equals(zzrs.zzb) || !Objects.equals(this.zzc, zzrs.zzc)) {
            return false;
        }
        return true;
    }
}
