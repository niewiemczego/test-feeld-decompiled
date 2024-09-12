package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

@Deprecated
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzamg extends AbstractList<String> implements zzajq, RandomAccess {
    /* access modifiers changed from: private */
    public final zzajq zza;

    public final zzajq a_() {
        return this;
    }

    public final int size() {
        return this.zza.size();
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zza.get(i);
    }

    public final Object zzb(int i) {
        return this.zza.zzb(i);
    }

    public final Iterator<String> iterator() {
        return new zzami(this);
    }

    public final List<?> zzb() {
        return this.zza.zzb();
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzamf(this, i);
    }

    public zzamg(zzajq zzajq) {
        this.zza = zzajq;
    }

    public final void zza(zzahm zzahm) {
        throw new UnsupportedOperationException();
    }
}
