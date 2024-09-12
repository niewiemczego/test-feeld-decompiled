package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzajp<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zza;

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zza.next();
        return next.getValue() instanceof zzajk ? new zzajn(next) : next;
    }

    public zzajp(Iterator<Map.Entry<K, Object>> it) {
        this.zza = it;
    }

    public final void remove() {
        this.zza.remove();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }
}
