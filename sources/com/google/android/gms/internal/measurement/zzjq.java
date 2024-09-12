package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
public final class zzjq extends zzhg<String> implements zzjp, RandomAccess {
    private static final zzjq zza;
    @Deprecated
    private static final zzjp zzb;
    private final List<Object> zzc;

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final int size() {
        return this.zzc.size();
    }

    public final /* synthetic */ zzjf zza(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzc);
            return new zzjq((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final zzjp h_() {
        return zzc() ? new zzmb(this) : this;
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzhm) {
            zzhm zzhm = (zzhm) obj;
            String zzc2 = zzhm.zzc();
            if (zzhm.zzd()) {
                this.zzc.set(i, zzc2);
            }
            return zzc2;
        }
        byte[] bArr = (byte[]) obj;
        String zzb2 = zziz.zzb(bArr);
        if (zziz.zzc(bArr)) {
            this.zzc.set(i, zzb2);
        }
        return zzb2;
    }

    public final Object zzb(int i) {
        return this.zzc.get(i);
    }

    public final /* synthetic */ Object remove(int i) {
        zza();
        Object remove = this.zzc.remove(i);
        this.modCount++;
        return zza(remove);
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        zza();
        return zza(this.zzc.set(i, (String) obj));
    }

    private static String zza(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzhm) {
            return ((zzhm) obj).zzc();
        }
        return zziz.zzb((byte[]) obj);
    }

    public final List<?> zzb() {
        return Collections.unmodifiableList(this.zzc);
    }

    static {
        zzjq zzjq = new zzjq(false);
        zza = zzjq;
        zzb = zzjq;
    }

    public zzjq() {
        this(10);
    }

    public zzjq(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzjq(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    private zzjq(boolean z) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    public final void zza(zzhm zzhm) {
        zza();
        this.zzc.add(zzhm);
        this.modCount++;
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zza();
        this.zzc.add(i, (String) obj);
        this.modCount++;
    }

    public final void clear() {
        zza();
        this.zzc.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zza();
        if (collection instanceof zzjp) {
            collection = ((zzjp) collection).zzb();
        }
        boolean addAll = this.zzc.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* bridge */ /* synthetic */ boolean zzc() {
        return super.zzc();
    }

    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }
}
