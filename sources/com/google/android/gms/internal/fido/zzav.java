package com.google.android.gms.internal.fido;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
final class zzav extends zzaz {
    boolean zza;
    final /* synthetic */ Object zzb;

    zzav(Object obj) {
        this.zzb = obj;
    }

    public final boolean hasNext() {
        return !this.zza;
    }

    public final Object next() {
        if (!this.zza) {
            this.zza = true;
            return this.zzb;
        }
        throw new NoSuchElementException();
    }
}
