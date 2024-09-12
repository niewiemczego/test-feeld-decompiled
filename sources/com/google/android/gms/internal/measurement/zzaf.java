package com.google.android.gms.internal.measurement;

import com.adapty.internal.crossplatform.AdaptyImmutableMapTypeAdapterFactory;
import com.facebook.hermes.intl.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzaf implements zzak, zzaq, Iterable<zzaq> {
    private final SortedMap<Integer, zzaq> zza;
    private final Map<String, zzaq> zzb;

    public final int zza() {
        return this.zza.size();
    }

    public final int hashCode() {
        return this.zza.hashCode() * 31;
    }

    public final int zzb() {
        if (this.zza.isEmpty()) {
            return 0;
        }
        return this.zza.lastKey().intValue() + 1;
    }

    public final zzaq zza(String str, zzh zzh, List<zzaq> list) {
        if ("concat".equals(str) || "every".equals(str) || "filter".equals(str) || "forEach".equals(str) || "indexOf".equals(str) || "join".equals(str) || "lastIndexOf".equals(str) || AdaptyImmutableMapTypeAdapterFactory.MAP.equals(str) || "pop".equals(str) || "push".equals(str) || "reduce".equals(str) || "reduceRight".equals(str) || "reverse".equals(str) || "shift".equals(str) || "slice".equals(str) || "some".equals(str) || Constants.SORT.equals(str) || "splice".equals(str) || "toString".equals(str) || "unshift".equals(str)) {
            return zzbe.zza(str, this, zzh, list);
        }
        return zzan.zza(this, new zzas(str), zzh, list);
    }

    public final zzaq zzc() {
        zzaf zzaf = new zzaf();
        for (Map.Entry next : this.zza.entrySet()) {
            if (next.getValue() instanceof zzak) {
                zzaf.zza.put((Integer) next.getKey(), (zzaq) next.getValue());
            } else {
                zzaf.zza.put((Integer) next.getKey(), ((zzaq) next.getValue()).zzc());
            }
        }
        return zzaf;
    }

    public final zzaq zza(int i) {
        zzaq zzaq;
        if (i >= zzb()) {
            throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
        } else if (!zzc(i) || (zzaq = (zzaq) this.zza.get(Integer.valueOf(i))) == null) {
            return zzc;
        } else {
            return zzaq;
        }
    }

    public final zzaq zza(String str) {
        zzaq zzaq;
        if ("length".equals(str)) {
            return new zzai(Double.valueOf((double) zzb()));
        }
        if (!zzc(str) || (zzaq = this.zzb.get(str)) == null) {
            return zzc;
        }
        return zzaq;
    }

    public final Boolean zzd() {
        return true;
    }

    public final Double zze() {
        if (this.zza.size() == 1) {
            return zza(0).zze();
        }
        if (this.zza.size() <= 0) {
            return Double.valueOf(0.0d);
        }
        return Double.valueOf(Double.NaN);
    }

    public final String zzf() {
        return toString();
    }

    public final String toString() {
        return zzb(",");
    }

    public final String zzb(String str) {
        if (str == null) {
            str = "";
        }
        StringBuilder sb = new StringBuilder();
        if (!this.zza.isEmpty()) {
            for (int i = 0; i < zzb(); i++) {
                zzaq zza2 = zza(i);
                sb.append(str);
                if (!(zza2 instanceof zzax) && !(zza2 instanceof zzao)) {
                    sb.append(zza2.zzf());
                }
            }
            sb.delete(0, str.length());
        }
        return sb.toString();
    }

    public final Iterator<Integer> zzg() {
        return this.zza.keySet().iterator();
    }

    public final Iterator<zzaq> zzh() {
        return new zzae(this, this.zza.keySet().iterator(), this.zzb.keySet().iterator());
    }

    public final Iterator<zzaq> iterator() {
        return new zzah(this);
    }

    public final List<zzaq> zzi() {
        ArrayList arrayList = new ArrayList(zzb());
        for (int i = 0; i < zzb(); i++) {
            arrayList.add(zza(i));
        }
        return arrayList;
    }

    public zzaf() {
        this.zza = new TreeMap();
        this.zzb = new TreeMap();
    }

    public zzaf(List<zzaq> list) {
        this();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                zzb(i, list.get(i));
            }
        }
    }

    public zzaf(zzaq... zzaqArr) {
        this((List<zzaq>) Arrays.asList(zzaqArr));
    }

    public final void zza(zzaq zzaq) {
        zzb(zzb(), zzaq);
    }

    public final void zzj() {
        this.zza.clear();
    }

    public final void zza(int i, zzaq zzaq) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid value index: " + i);
        } else if (i >= zzb()) {
            zzb(i, zzaq);
        } else {
            for (int intValue = this.zza.lastKey().intValue(); intValue >= i; intValue--) {
                zzaq zzaq2 = (zzaq) this.zza.get(Integer.valueOf(intValue));
                if (zzaq2 != null) {
                    zzb(intValue + 1, zzaq2);
                    this.zza.remove(Integer.valueOf(intValue));
                }
            }
            zzb(i, zzaq);
        }
    }

    public final void zzb(int i) {
        int intValue = this.zza.lastKey().intValue();
        if (i <= intValue && i >= 0) {
            this.zza.remove(Integer.valueOf(i));
            if (i == intValue) {
                int i2 = i - 1;
                if (!this.zza.containsKey(Integer.valueOf(i2)) && i2 >= 0) {
                    this.zza.put(Integer.valueOf(i2), zzaq.zzc);
                    return;
                }
                return;
            }
            while (true) {
                i++;
                if (i <= this.zza.lastKey().intValue()) {
                    zzaq zzaq = (zzaq) this.zza.get(Integer.valueOf(i));
                    if (zzaq != null) {
                        this.zza.put(Integer.valueOf(i - 1), zzaq);
                        this.zza.remove(Integer.valueOf(i));
                    }
                } else {
                    return;
                }
            }
        }
    }

    @RequiresNonNull({"elements"})
    public final void zzb(int i, zzaq zzaq) {
        if (i > 32468) {
            throw new IllegalStateException("Array too large");
        } else if (i < 0) {
            throw new IndexOutOfBoundsException("Out of bounds index: " + i);
        } else if (zzaq == null) {
            this.zza.remove(Integer.valueOf(i));
        } else {
            this.zza.put(Integer.valueOf(i), zzaq);
        }
    }

    public final void zza(String str, zzaq zzaq) {
        if (zzaq == null) {
            this.zzb.remove(str);
        } else {
            this.zzb.put(str, zzaq);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaf)) {
            return false;
        }
        zzaf zzaf = (zzaf) obj;
        if (zzb() != zzaf.zzb()) {
            return false;
        }
        if (this.zza.isEmpty()) {
            return zzaf.zza.isEmpty();
        }
        for (int intValue = this.zza.firstKey().intValue(); intValue <= this.zza.lastKey().intValue(); intValue++) {
            if (!zza(intValue).equals(zzaf.zza(intValue))) {
                return false;
            }
        }
        return true;
    }

    public final boolean zzc(int i) {
        if (i >= 0 && i <= this.zza.lastKey().intValue()) {
            return this.zza.containsKey(Integer.valueOf(i));
        }
        throw new IndexOutOfBoundsException("Out of bounds index: " + i);
    }

    public final boolean zzc(String str) {
        return "length".equals(str) || this.zzb.containsKey(str);
    }
}
