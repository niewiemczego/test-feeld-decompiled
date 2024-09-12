package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import org.apache.commons.io.FileUtils;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public abstract class zzai implements Map, Serializable {
    @CheckForNull
    private transient zzaj zza;
    @CheckForNull
    private transient zzaj zzb;
    @CheckForNull
    private transient zzac zzc;

    zzai() {
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public final boolean containsKey(@CheckForNull Object obj) {
        return get(obj) != null;
    }

    public final boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        return entrySet().equals(((Map) obj).entrySet());
    }

    @CheckForNull
    public abstract Object get(@CheckForNull Object obj);

    @CheckForNull
    public final Object getOrDefault(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public final int hashCode() {
        return zzar.zza(entrySet());
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final /* bridge */ /* synthetic */ Set keySet() {
        zzaj zzaj = this.zzb;
        if (zzaj != null) {
            return zzaj;
        }
        zzaj zzd = zzd();
        this.zzb = zzd;
        return zzd;
    }

    @CheckForNull
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    @Deprecated
    public final Object remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        if (size >= 0) {
            StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, FileUtils.ONE_GB));
            sb.append('{');
            boolean z = true;
            for (Map.Entry entry : entrySet()) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
                z = false;
            }
            sb.append('}');
            return sb.toString();
        }
        throw new IllegalArgumentException("size cannot be negative but was: " + size);
    }

    /* access modifiers changed from: package-private */
    public abstract zzac zza();

    /* renamed from: zzb */
    public final zzac values() {
        zzac zzac = this.zzc;
        if (zzac != null) {
            return zzac;
        }
        zzac zza2 = zza();
        this.zzc = zza2;
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public abstract zzaj zzc();

    /* access modifiers changed from: package-private */
    public abstract zzaj zzd();

    /* renamed from: zze */
    public final zzaj entrySet() {
        zzaj zzaj = this.zza;
        if (zzaj != null) {
            return zzaj;
        }
        zzaj zzc2 = zzc();
        this.zza = zzc2;
        return zzc2;
    }
}
