package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzalb<E> extends zzahg<E> implements RandomAccess {
    private static final zzalb<Object> zza = new zzalb<>(new Object[0], 0, false);
    private E[] zzb;
    private int zzc;

    public final int size() {
        return this.zzc;
    }

    public final /* synthetic */ zzajg zza(int i) {
        if (i >= this.zzc) {
            return new zzalb(Arrays.copyOf(this.zzb, i), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public static <E> zzalb<E> zzd() {
        return zza;
    }

    public final E get(int i) {
        zzc(i);
        return this.zzb[i];
    }

    public final E remove(int i) {
        zza();
        zzc(i);
        E[] eArr = this.zzb;
        E e = eArr[i];
        int i2 = this.zzc;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.zzc--;
        this.modCount++;
        return e;
    }

    public final E set(int i, E e) {
        zza();
        zzc(i);
        E[] eArr = this.zzb;
        E e2 = eArr[i];
        eArr[i] = e;
        this.modCount++;
        return e2;
    }

    private final String zzb(int i) {
        return "Index:" + i + ", Size:" + this.zzc;
    }

    zzalb() {
        this(new Object[10], 0, true);
    }

    private zzalb(E[] eArr, int i, boolean z) {
        super(z);
        this.zzb = eArr;
        this.zzc = i;
    }

    public final void add(int i, E e) {
        int i2;
        zza();
        if (i < 0 || i > (i2 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzb(i));
        }
        E[] eArr = this.zzb;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = new Object[(((i2 * 3) / 2) + 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.zzb, i, eArr2, i + 1, this.zzc - i);
            this.zzb = eArr2;
        }
        this.zzb[i] = e;
        this.zzc++;
        this.modCount++;
    }

    private final void zzc(int i) {
        if (i < 0 || i >= this.zzc) {
            throw new IndexOutOfBoundsException(zzb(i));
        }
    }

    public final boolean add(E e) {
        zza();
        int i = this.zzc;
        E[] eArr = this.zzb;
        if (i == eArr.length) {
            this.zzb = Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzb;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        eArr2[i2] = e;
        this.modCount++;
        return true;
    }
}