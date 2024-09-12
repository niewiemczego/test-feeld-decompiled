package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzay  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzay<E> extends zzaq<E> {
    static final zzaq<Object> zza = new zzay(new Object[0], 0);
    private final transient Object[] zzb;
    private final transient int zzc;

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, i, this.zzc);
        return i + this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean zze() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final int zza() {
        return this.zzc;
    }

    public final int size() {
        return this.zzc;
    }

    public final E get(int i) {
        zzz.zza(i, this.zzc);
        return Objects.requireNonNull(this.zzb[i]);
    }

    zzay(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzf() {
        return this.zzb;
    }
}
