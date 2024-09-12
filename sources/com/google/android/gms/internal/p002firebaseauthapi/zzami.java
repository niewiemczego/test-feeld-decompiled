package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzami  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzami implements Iterator<String> {
    private Iterator<String> zza;
    private final /* synthetic */ zzamg zzb;

    public final /* synthetic */ Object next() {
        return this.zza.next();
    }

    zzami(zzamg zzamg) {
        this.zzb = zzamg;
        this.zza = zzamg.zza.iterator();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }
}
