package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public abstract class zzaq<E> extends zzal<E> implements List<E>, RandomAccess {
    private static final zzbg<Object> zza = new zzas(zzay.zza, 0);

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Deprecated
    public final zzaq<E> zzc() {
        return this;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~((i * 31) + get(i2).hashCode()));
        }
        return i;
    }

    public int indexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        if (this instanceof RandomAccess) {
            int size = size();
            int i = 0;
            if (obj == null) {
                while (i < size) {
                    if (get(i) == null) {
                        return i;
                    }
                    i++;
                }
            } else {
                while (i < size) {
                    if (obj.equals(get(i))) {
                        return i;
                    }
                    i++;
                }
            }
            return -1;
        }
        ListIterator listIterator = listIterator();
        while (listIterator.hasNext()) {
            if (zzw.zza(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public int lastIndexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        if (this instanceof RandomAccess) {
            if (obj == null) {
                for (int size = size() - 1; size >= 0; size--) {
                    if (get(size) == null) {
                        return size;
                    }
                }
            } else {
                for (int size2 = size() - 1; size2 >= 0; size2--) {
                    if (obj.equals(get(size2))) {
                        return size2;
                    }
                }
            }
            return -1;
        }
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (zzw.zza(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public static <E> zzap<E> zzg() {
        return new zzap<>();
    }

    static <E> zzaq<E> zza(Object[] objArr) {
        return zzb(objArr, objArr.length);
    }

    static <E> zzaq<E> zzb(Object[] objArr, int i) {
        if (i == 0) {
            return zzay.zza;
        }
        return new zzay(objArr, i);
    }

    private static <E> zzaq<E> zzb(Object... objArr) {
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            if (objArr[i] != null) {
                i++;
            } else {
                throw new NullPointerException("at index " + i);
            }
        }
        return zzb(objArr, objArr.length);
    }

    public static <E> zzaq<E> zza(Collection<? extends E> collection) {
        if (!(collection instanceof zzal)) {
            return zzb(collection.toArray());
        }
        zzaq<E> zzc = ((zzal) collection).zzc();
        if (!zzc.zze()) {
            return zzc;
        }
        Object[] array = zzc.toArray();
        return zzb(array, array.length);
    }

    public static <E> zzaq<E> zzh() {
        return zzay.zza;
    }

    public static <E> zzaq<E> zza(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        return zzb(e, e2, e3, e4, e5, e6, e7, e8);
    }

    /* renamed from: zza */
    public zzaq<E> subList(int i, int i2) {
        zzz.zza(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return zzay.zza;
        }
        return new zzar(this, i, i3);
    }

    public final zzbd<E> zzd() {
        return (zzbg) listIterator();
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public /* synthetic */ ListIterator listIterator() {
        return (zzbg) listIterator(0);
    }

    public /* synthetic */ ListIterator listIterator(int i) {
        zzz.zzb(i, size());
        if (isEmpty()) {
            return zza;
        }
        return new zzas(this, i);
    }

    zzaq() {
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(@CheckForNull Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == zzz.zza(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (!(this instanceof RandomAccess) || !(list instanceof RandomAccess)) {
                    zzaq zzaq = this;
                    int size2 = size();
                    Iterator it = list.iterator();
                    int i = 0;
                    while (true) {
                        if (i < size2) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Object obj2 = get(i);
                            i++;
                            if (!zzw.zza(obj2, it.next())) {
                                break;
                            }
                        } else if (!it.hasNext()) {
                            return true;
                        }
                    }
                } else {
                    int i2 = 0;
                    while (i2 < size) {
                        if (zzw.zza(get(i2), list.get(i2))) {
                            i2++;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
