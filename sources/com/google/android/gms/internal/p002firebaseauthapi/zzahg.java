package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
abstract class zzahg<E> extends AbstractList<E> implements zzajg<E> {
    private boolean zza;

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public E remove(int i) {
        zza();
        return super.remove(i);
    }

    public E set(int i, E e) {
        zza();
        return super.set(i, e);
    }

    zzahg() {
        this(true);
    }

    zzahg(boolean z) {
        this.zza = z;
    }

    public void add(int i, E e) {
        zza();
        super.add(i, e);
    }

    public void clear() {
        zza();
        super.clear();
    }

    /* access modifiers changed from: protected */
    public final void zza() {
        if (!this.zza) {
            throw new UnsupportedOperationException();
        }
    }

    public final void b_() {
        if (this.zza) {
            this.zza = false;
        }
    }

    public boolean add(E e) {
        zza();
        return super.add(e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        zza();
        return super.addAll(collection);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        zza();
        return super.addAll(i, collection);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean zzc() {
        return this.zza;
    }

    public boolean remove(Object obj) {
        zza();
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        zza();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        zza();
        return super.retainAll(collection);
    }
}
