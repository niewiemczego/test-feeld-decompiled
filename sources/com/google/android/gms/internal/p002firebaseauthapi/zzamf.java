package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ListIterator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzamf implements ListIterator<String> {
    private ListIterator<String> zza;
    private final /* synthetic */ int zzb;
    private final /* synthetic */ zzamg zzc;

    public final int nextIndex() {
        return this.zza.nextIndex();
    }

    public final int previousIndex() {
        return this.zza.previousIndex();
    }

    public final /* synthetic */ Object next() {
        return this.zza.next();
    }

    public final /* synthetic */ Object previous() {
        return this.zza.previous();
    }

    zzamf(zzamg zzamg, int i) {
        this.zzb = i;
        this.zzc = zzamg;
        this.zza = zzamg.zza.listIterator(i);
    }

    public final /* synthetic */ void add(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zza.hasPrevious();
    }
}
