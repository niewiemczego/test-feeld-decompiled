package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
final class zzjr extends zzjs {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzmg.zze(obj, j);
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.android.gms.internal.measurement.zzjq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.android.gms.internal.measurement.zzjq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.google.android.gms.internal.measurement.zzjq} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <L> java.util.List<L> zza(java.lang.Object r3, long r4, int r6) {
        /*
            java.util.List r0 = zzc(r3, r4)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x002d
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzjp
            if (r1 == 0) goto L_0x0014
            com.google.android.gms.internal.measurement.zzjq r0 = new com.google.android.gms.internal.measurement.zzjq
            r0.<init>((int) r6)
            goto L_0x0029
        L_0x0014:
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzkv
            if (r1 == 0) goto L_0x0024
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzjf
            if (r1 == 0) goto L_0x0024
            com.google.android.gms.internal.measurement.zzjf r0 = (com.google.android.gms.internal.measurement.zzjf) r0
            com.google.android.gms.internal.measurement.zzjf r6 = r0.zza(r6)
            r0 = r6
            goto L_0x0029
        L_0x0024:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r6)
        L_0x0029:
            com.google.android.gms.internal.measurement.zzmg.zza((java.lang.Object) r3, (long) r4, (java.lang.Object) r0)
            goto L_0x007f
        L_0x002d:
            java.lang.Class<?> r1 = zza
            java.lang.Class r2 = r0.getClass()
            boolean r1 = r1.isAssignableFrom(r2)
            if (r1 == 0) goto L_0x004b
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>(r2)
            r1.addAll(r0)
            com.google.android.gms.internal.measurement.zzmg.zza((java.lang.Object) r3, (long) r4, (java.lang.Object) r1)
        L_0x0049:
            r0 = r1
            goto L_0x007f
        L_0x004b:
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzmb
            if (r1 == 0) goto L_0x0062
            com.google.android.gms.internal.measurement.zzjq r1 = new com.google.android.gms.internal.measurement.zzjq
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>((int) r2)
            com.google.android.gms.internal.measurement.zzmb r0 = (com.google.android.gms.internal.measurement.zzmb) r0
            r1.addAll(r0)
            com.google.android.gms.internal.measurement.zzmg.zza((java.lang.Object) r3, (long) r4, (java.lang.Object) r1)
            goto L_0x0049
        L_0x0062:
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzkv
            if (r1 == 0) goto L_0x007f
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzjf
            if (r1 == 0) goto L_0x007f
            r1 = r0
            com.google.android.gms.internal.measurement.zzjf r1 = (com.google.android.gms.internal.measurement.zzjf) r1
            boolean r2 = r1.zzc()
            if (r2 != 0) goto L_0x007f
            int r0 = r0.size()
            int r0 = r0 + r6
            com.google.android.gms.internal.measurement.zzjf r0 = r1.zza(r0)
            com.google.android.gms.internal.measurement.zzmg.zza((java.lang.Object) r3, (long) r4, (java.lang.Object) r0)
        L_0x007f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjr.zza(java.lang.Object, long, int):java.util.List");
    }

    private zzjr() {
        super();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zzmg.zze(obj, j);
        if (list instanceof zzjp) {
            obj2 = ((zzjp) list).h_();
        } else if (!zza.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzkv) || !(list instanceof zzjf)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzjf zzjf = (zzjf) list;
                if (zzjf.zzc()) {
                    zzjf.i_();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzmg.zza(obj, j, obj2);
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzc = zzc(obj2, j);
        List zza2 = zza(obj, j, zzc.size());
        int size = zza2.size();
        int size2 = zzc.size();
        if (size > 0 && size2 > 0) {
            zza2.addAll(zzc);
        }
        if (size > 0) {
            zzc = zza2;
        }
        zzmg.zza(obj, j, (Object) zzc);
    }
}
