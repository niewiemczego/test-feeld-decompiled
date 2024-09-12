package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzain  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzain extends zzahg<Double> implements zzajg<Double>, zzakw, RandomAccess {
    private static final zzain zza = new zzain(new double[0], 0, false);
    private double[] zzb;
    private int zzc;

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            i = (i * 31) + zzajc.zza(Double.doubleToLongBits(this.zzb[i2]));
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.zzb[i] == doubleValue) {
                return i;
            }
        }
        return -1;
    }

    public final int size() {
        return this.zzc;
    }

    public final /* synthetic */ zzajg zza(int i) {
        if (i >= this.zzc) {
            return new zzain(Arrays.copyOf(this.zzb, i), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzc(i);
        return Double.valueOf(this.zzb[i]);
    }

    public final /* synthetic */ Object remove(int i) {
        zza();
        zzc(i);
        double[] dArr = this.zzb;
        double d = dArr[i];
        int i2 = this.zzc;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.zzc--;
        this.modCount++;
        return Double.valueOf(d);
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zza();
        zzc(i);
        double[] dArr = this.zzb;
        double d = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d);
    }

    private final String zzb(int i) {
        return "Index:" + i + ", Size:" + this.zzc;
    }

    zzain() {
        this(new double[10], 0, true);
    }

    private zzain(double[] dArr, int i, boolean z) {
        super(z);
        this.zzb = dArr;
        this.zzc = i;
    }

    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        double doubleValue = ((Double) obj).doubleValue();
        zza();
        if (i < 0 || i > (i2 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzb(i));
        }
        double[] dArr = this.zzb;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.zzb, i, dArr2, i + 1, this.zzc - i);
            this.zzb = dArr2;
        }
        this.zzb[i] = doubleValue;
        this.zzc++;
        this.modCount++;
    }

    public final void zza(double d) {
        zza();
        int i = this.zzc;
        double[] dArr = this.zzb;
        if (i == dArr.length) {
            double[] dArr2 = new double[(((i * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.zzb = dArr2;
        }
        double[] dArr3 = this.zzb;
        int i2 = this.zzc;
        this.zzc = i2 + 1;
        dArr3[i2] = d;
    }

    private final void zzc(int i) {
        if (i < 0 || i >= this.zzc) {
            throw new IndexOutOfBoundsException(zzb(i));
        }
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zza();
        if (i2 >= i) {
            double[] dArr = this.zzb;
            System.arraycopy(dArr, i2, dArr, i, this.zzc - i2);
            this.zzc -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ boolean add(Object obj) {
        zza(((Double) obj).doubleValue());
        return true;
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        zza();
        zzajc.zza(collection);
        if (!(collection instanceof zzain)) {
            return super.addAll(collection);
        }
        zzain zzain = (zzain) collection;
        int i = zzain.zzc;
        if (i == 0) {
            return false;
        }
        int i2 = this.zzc;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.zzb;
            if (i3 > dArr.length) {
                this.zzb = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(zzain.zzb, 0, this.zzb, this.zzc, zzain.zzc);
            this.zzc = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzain)) {
            return super.equals(obj);
        }
        zzain zzain = (zzain) obj;
        if (this.zzc != zzain.zzc) {
            return false;
        }
        double[] dArr = zzain.zzb;
        for (int i = 0; i < this.zzc; i++) {
            if (Double.doubleToLongBits(this.zzb[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }
}
