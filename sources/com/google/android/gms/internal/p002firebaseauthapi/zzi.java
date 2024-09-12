package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzi  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
abstract class zzi<T> implements Iterator<T> {
    private int zza = zzh.zzb;
    @CheckForNull
    private T zzb;

    /* access modifiers changed from: protected */
    @CheckForNull
    public abstract T zza();

    /* access modifiers changed from: protected */
    @CheckForNull
    public final T zzb() {
        this.zza = zzh.zzc;
        return null;
    }

    public final T next() {
        if (hasNext()) {
            this.zza = zzh.zzb;
            T t = this.zzb;
            this.zzb = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    protected zzi() {
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        if (this.zza != zzh.zzd) {
            int i = this.zza - 1;
            if (i == 0) {
                return true;
            }
            if (i != 2) {
                this.zza = zzh.zzd;
                this.zzb = zza();
                if (this.zza != zzh.zzc) {
                    this.zza = zzh.zza;
                    return true;
                }
            }
            return false;
        }
        throw new IllegalStateException();
    }
}
