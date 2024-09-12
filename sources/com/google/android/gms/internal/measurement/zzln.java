package com.google.android.gms.internal.measurement;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
final class zzln implements Comparable<zzln>, Map.Entry<K, V> {
    private final K zza;
    private V zzb;
    private final /* synthetic */ zzlg zzc;

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzln) obj).getKey());
    }

    public final int hashCode() {
        K k = this.zza;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.zzb;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    public final /* synthetic */ Object getKey() {
        return this.zza;
    }

    public final V getValue() {
        return this.zzb;
    }

    public final V setValue(V v) {
        this.zzc.zzg();
        V v2 = this.zzb;
        this.zzb = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        return valueOf + "=" + String.valueOf(this.zzb);
    }

    zzln(zzlg zzlg, Map.Entry<K, V> entry) {
        this(zzlg, (Comparable) entry.getKey(), entry.getValue());
    }

    zzln(zzlg zzlg, K k, V v) {
        this.zzc = zzlg;
        this.zza = k;
        this.zzb = v;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return zza(this.zza, entry.getKey()) && zza(this.zzb, entry.getValue());
    }

    private static boolean zza(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }
}
