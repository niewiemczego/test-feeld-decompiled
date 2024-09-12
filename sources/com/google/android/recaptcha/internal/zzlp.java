package com.google.android.recaptcha.internal;

import java.util.Iterator;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzlp implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzlq zzb;

    zzlp(zzlq zzlq) {
        this.zzb = zzlq;
        this.zza = zzlq.zza.iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
