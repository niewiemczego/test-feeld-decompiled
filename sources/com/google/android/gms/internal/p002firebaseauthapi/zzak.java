package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzak  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
abstract class zzak<E> extends zzbg<E> {
    private final int zza;
    private int zzb;

    public final int nextIndex() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public abstract E zza(int i);

    public final int previousIndex() {
        return this.zzb - 1;
    }

    public final E next() {
        if (hasNext()) {
            int i = this.zzb;
            this.zzb = i + 1;
            return zza(i);
        }
        throw new NoSuchElementException();
    }

    public final E previous() {
        if (hasPrevious()) {
            int i = this.zzb - 1;
            this.zzb = i;
            return zza(i);
        }
        throw new NoSuchElementException();
    }

    protected zzak(int i, int i2) {
        zzz.zzb(i2, i);
        this.zza = i;
        this.zzb = i2;
    }

    public final boolean hasNext() {
        return this.zzb < this.zza;
    }

    public final boolean hasPrevious() {
        return this.zzb > 0;
    }
}
