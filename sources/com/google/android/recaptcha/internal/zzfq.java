package com.google.android.recaptcha.internal;

import java.util.Iterator;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzfq implements Iterator {
    boolean zza = true;
    final /* synthetic */ Iterator zzb;

    zzfq(zzfr zzfr, Iterator it) {
        this.zzb = it;
    }

    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    public final Object next() {
        Object next = this.zzb.next();
        this.zza = false;
        return next;
    }

    public final void remove() {
        zzff.zze(!this.zza, "no calls to next() since the last call to remove()");
        this.zzb.remove();
    }
}
