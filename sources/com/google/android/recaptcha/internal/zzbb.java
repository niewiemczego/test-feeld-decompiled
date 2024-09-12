package com.google.android.recaptcha.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzbb {
    private final zzne zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze = null;

    public zzbb(zzne zzne, String str, String str2, String str3, String str4) {
        this.zza = zzne;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbb)) {
            return false;
        }
        zzbb zzbb = (zzbb) obj;
        if (zzbb.zza != this.zza || !Intrinsics.areEqual((Object) zzbb.zzb, (Object) this.zzb) || !Intrinsics.areEqual((Object) zzbb.zzc, (Object) this.zzc) || !Intrinsics.areEqual((Object) zzbb.zzd, (Object) this.zzd)) {
            return false;
        }
        String str = zzbb.zze;
        return Intrinsics.areEqual((Object) null, (Object) null);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, null});
    }

    public final zzne zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }
}
