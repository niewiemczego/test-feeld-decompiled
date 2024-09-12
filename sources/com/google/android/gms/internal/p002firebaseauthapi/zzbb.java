package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzbb extends zzaq<Object> {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final boolean zze() {
        return true;
    }

    public final Object get(int i) {
        zzz.zza(i, this.zzc);
        return Objects.requireNonNull(this.zza[(i * 2) + this.zzb]);
    }

    zzbb(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }
}
