package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzake  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzake<K, V> extends LinkedHashMap<K, V> {
    private static final zzake<?, ?> zza;
    private boolean zzb = true;

    private static int zza(Object obj) {
        if (obj instanceof byte[]) {
            return zzajc.zza((byte[]) obj);
        }
        if (!(obj instanceof zzajf)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        int i = 0;
        for (Map.Entry entry : entrySet()) {
            i += zza(entry.getValue()) ^ zza(entry.getKey());
        }
        return i;
    }

    public static <K, V> zzake<K, V> zza() {
        return zza;
    }

    public final zzake<K, V> zzb() {
        return isEmpty() ? new zzake<>() : new zzake<>(this);
    }

    public final V put(K k, V v) {
        zze();
        zzajc.zza(k);
        zzajc.zza(v);
        return super.put(k, v);
    }

    public final V remove(Object obj) {
        zze();
        return super.remove(obj);
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    static {
        zzake<?, ?> zzake = new zzake<>();
        zza = zzake;
        zzake.zzb = false;
    }

    private zzake() {
    }

    private zzake(Map<K, V> map) {
        super(map);
    }

    public final void clear() {
        zze();
        super.clear();
    }

    private final void zze() {
        if (!this.zzb) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzc() {
        this.zzb = false;
    }

    public final void zza(zzake<K, V> zzake) {
        zze();
        if (!zzake.isEmpty()) {
            putAll(zzake);
        }
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        zze();
        for (Object next : map.keySet()) {
            zzajc.zza(next);
            zzajc.zza(map.get(next));
        }
        super.putAll(map);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof java.util.Map
            r1 = 0
            if (r0 == 0) goto L_0x005d
            java.util.Map r7 = (java.util.Map) r7
            r0 = 1
            if (r6 == r7) goto L_0x0059
            int r2 = r6.size()
            int r3 = r7.size()
            if (r2 == r3) goto L_0x0016
        L_0x0014:
            r7 = r1
            goto L_0x005a
        L_0x0016:
            java.util.Set r2 = r6.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x001e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0059
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            boolean r4 = r7.containsKey(r4)
            if (r4 != 0) goto L_0x0035
            goto L_0x0014
        L_0x0035:
            java.lang.Object r4 = r3.getValue()
            java.lang.Object r3 = r3.getKey()
            java.lang.Object r3 = r7.get(r3)
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L_0x0052
            boolean r5 = r3 instanceof byte[]
            if (r5 == 0) goto L_0x0052
            byte[] r4 = (byte[]) r4
            byte[] r3 = (byte[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L_0x0056
        L_0x0052:
            boolean r3 = r4.equals(r3)
        L_0x0056:
            if (r3 != 0) goto L_0x001e
            goto L_0x0014
        L_0x0059:
            r7 = r0
        L_0x005a:
            if (r7 == 0) goto L_0x005d
            return r0
        L_0x005d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzake.equals(java.lang.Object):boolean");
    }

    public final boolean zzd() {
        return this.zzb;
    }
}
