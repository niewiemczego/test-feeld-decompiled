package com.google.android.gms.internal.measurement;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
class zzlg<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int zza;
    /* access modifiers changed from: private */
    public List<zzln> zzb;
    /* access modifiers changed from: private */
    public Map<K, V> zzc;
    private boolean zzd;
    private volatile zzls zze;
    /* access modifiers changed from: private */
    public Map<K, V> zzf;
    private volatile zzlk zzg;

    private final int zza(K k) {
        int size = this.zzb.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzb.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zzb.get(i2).getKey());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else if (compareTo2 <= 0) {
                return i2;
            } else {
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    public final int zzb() {
        return this.zzb.size();
    }

    public int hashCode() {
        int zzb2 = zzb();
        int i = 0;
        for (int i2 = 0; i2 < zzb2; i2++) {
            i += this.zzb.get(i2).hashCode();
        }
        return this.zzc.size() > 0 ? i + this.zzc.hashCode() : i;
    }

    public int size() {
        return this.zzb.size() + this.zzc.size();
    }

    static <FieldDescriptorType extends zzis<FieldDescriptorType>> zzlg<FieldDescriptorType, Object> zza(int i) {
        return new zzlf(i);
    }

    public final Iterable<Map.Entry<K, V>> zzc() {
        if (this.zzc.isEmpty()) {
            return zzlm.zza();
        }
        return this.zzc.entrySet();
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza2 = zza(comparable);
        if (zza2 >= 0) {
            return this.zzb.get(zza2).getValue();
        }
        return this.zzc.get(comparable);
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zzg();
        int zza2 = zza(k);
        if (zza2 >= 0) {
            return this.zzb.get(zza2).setValue(v);
        }
        zzg();
        if (this.zzb.isEmpty() && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList(this.zza);
        }
        int i = -(zza2 + 1);
        if (i >= this.zza) {
            return zzf().put(k, v);
        }
        int size = this.zzb.size();
        int i2 = this.zza;
        if (size == i2) {
            zzln remove = this.zzb.remove(i2 - 1);
            zzf().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzb.add(i, new zzln(this, k, v));
        return null;
    }

    public V remove(Object obj) {
        zzg();
        Comparable comparable = (Comparable) obj;
        int zza2 = zza(comparable);
        if (zza2 >= 0) {
            return zzc(zza2);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    /* access modifiers changed from: private */
    public final V zzc(int i) {
        zzg();
        V value = this.zzb.remove(i).getValue();
        if (!this.zzc.isEmpty()) {
            Iterator it = zzf().entrySet().iterator();
            this.zzb.add(new zzln(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    public final Map.Entry<K, V> zzb(int i) {
        return this.zzb.get(i);
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> zzd() {
        if (this.zzg == null) {
            this.zzg = new zzlk(this);
        }
        return this.zzg;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zze == null) {
            this.zze = new zzls(this);
        }
        return this.zze;
    }

    private final SortedMap<K, V> zzf() {
        zzg();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            TreeMap treeMap2 = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    private zzlg(int i) {
        this.zza = i;
        this.zzb = Collections.emptyList();
        this.zzc = Collections.emptyMap();
        this.zzf = Collections.emptyMap();
    }

    /* access modifiers changed from: private */
    public final void zzg() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    public void clear() {
        zzg();
        if (!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
        if (!this.zzc.isEmpty()) {
            this.zzc.clear();
        }
    }

    public void zza() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.zzd) {
            if (this.zzc.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.zzc);
            }
            this.zzc = map;
            if (this.zzf.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.zzf);
            }
            this.zzf = map2;
            this.zzd = true;
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzc.containsKey(comparable);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzlg)) {
            return super.equals(obj);
        }
        zzlg zzlg = (zzlg) obj;
        int size = size();
        if (size != zzlg.size()) {
            return false;
        }
        int zzb2 = zzb();
        if (zzb2 != zzlg.zzb()) {
            return entrySet().equals(zzlg.entrySet());
        }
        for (int i = 0; i < zzb2; i++) {
            if (!zzb(i).equals(zzlg.zzb(i))) {
                return false;
            }
        }
        if (zzb2 != size) {
            return this.zzc.equals(zzlg.zzc);
        }
        return true;
    }

    public final boolean zze() {
        return this.zzd;
    }
}
