package com.google.android.recaptcha.internal;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzba {
    private final String zza;
    private final long zzb;
    private final int zzc;

    public zzba(String str, long j, int i) {
        this.zza = str;
        this.zzb = j;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzba)) {
            return false;
        }
        zzba zzba = (zzba) obj;
        return Intrinsics.areEqual((Object) zzba.zza, (Object) this.zza) && zzba.zzb == this.zzb && zzba.zzc == this.zzc;
    }

    public final int zza() {
        return this.zzc;
    }

    public final long zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zza;
    }
}
