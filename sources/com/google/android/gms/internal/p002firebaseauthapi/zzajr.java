package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzajr extends zzahg<String> implements zzajq, RandomAccess {
    private static final zzajr zza;
    @Deprecated
    private static final zzajq zzb;
    private final List<Object> zzc;

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final int size() {
        return this.zzc.size();
    }

    public final /* synthetic */ zzajg zza(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzc);
            return new zzajr((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public final zzajq a_() {
        return zzc() ? new zzamg(this) : this;
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzahm) {
            zzahm zzahm = (zzahm) obj;
            String zzd = zzahm.zzd();
            if (zzahm.zzf()) {
                this.zzc.set(i, zzd);
            }
            return zzd;
        }
        byte[] bArr = (byte[]) obj;
        String zzb2 = zzajc.zzb(bArr);
        if (zzajc.zzc(bArr)) {
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
        if (obj instanceof zzahm) {
            return ((zzahm) obj).zzd();
        }
        return zzajc.zzb((byte[]) obj);
    }

    public final List<?> zzb() {
        return Collections.unmodifiableList(this.zzc);
    }

    static {
        zzajr zzajr = new zzajr(false);
        zza = zzajr;
        zzb = zzajr;
    }

    public zzajr() {
        this(10);
    }

    public zzajr(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzajr(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    private zzajr(boolean z) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    public final void zza(zzahm zzahm) {
        zza();
        this.zzc.add(zzahm);
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
        if (collection instanceof zzajq) {
            collection = ((zzajq) collection).zzb();
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
