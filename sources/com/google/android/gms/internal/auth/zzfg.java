package com.google.android.gms.internal.auth;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzfg extends zzfk {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzfg() {
        super((zzfj) null);
    }

    /* synthetic */ zzfg(zzff zzff) {
        super((zzfj) null);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj, long j) {
        Object obj2;
        List list = (List) zzhi.zzf(obj, j);
        if (list instanceof zzfe) {
            obj2 = ((zzfe) list).zze();
        } else if (!zza.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzgd) || !(list instanceof zzey)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzey zzey = (zzey) list;
                if (zzey.zzc()) {
                    zzey.zzb();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zzhi.zzp(obj, j, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: com.google.android.gms.internal.auth.zzfd} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: com.google.android.gms.internal.auth.zzfd} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: com.google.android.gms.internal.auth.zzfd} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(java.lang.Object r5, java.lang.Object r6, long r7) {
        /*
            r4 = this;
            java.lang.Object r6 = com.google.android.gms.internal.auth.zzhi.zzf(r6, r7)
            java.util.List r6 = (java.util.List) r6
            int r0 = r6.size()
            java.lang.Object r1 = com.google.android.gms.internal.auth.zzhi.zzf(r5, r7)
            java.util.List r1 = (java.util.List) r1
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x0039
            boolean r2 = r1 instanceof com.google.android.gms.internal.auth.zzfe
            if (r2 == 0) goto L_0x0020
            com.google.android.gms.internal.auth.zzfd r1 = new com.google.android.gms.internal.auth.zzfd
            r1.<init>((int) r0)
            goto L_0x0035
        L_0x0020:
            boolean r2 = r1 instanceof com.google.android.gms.internal.auth.zzgd
            if (r2 == 0) goto L_0x0030
            boolean r2 = r1 instanceof com.google.android.gms.internal.auth.zzey
            if (r2 == 0) goto L_0x0030
            com.google.android.gms.internal.auth.zzey r1 = (com.google.android.gms.internal.auth.zzey) r1
            com.google.android.gms.internal.auth.zzey r0 = r1.zzd(r0)
            r1 = r0
            goto L_0x0035
        L_0x0030:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
        L_0x0035:
            com.google.android.gms.internal.auth.zzhi.zzp(r5, r7, r1)
            goto L_0x008f
        L_0x0039:
            java.lang.Class r2 = zza
            java.lang.Class r3 = r1.getClass()
            boolean r2 = r2.isAssignableFrom(r3)
            if (r2 == 0) goto L_0x0057
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>(r3)
            r2.addAll(r1)
            com.google.android.gms.internal.auth.zzhi.zzp(r5, r7, r2)
        L_0x0055:
            r1 = r2
            goto L_0x008f
        L_0x0057:
            boolean r2 = r1 instanceof com.google.android.gms.internal.auth.zzhd
            if (r2 == 0) goto L_0x0072
            com.google.android.gms.internal.auth.zzfd r2 = new com.google.android.gms.internal.auth.zzfd
            int r3 = r1.size()
            int r3 = r3 + r0
            r2.<init>((int) r3)
            com.google.android.gms.internal.auth.zzhd r1 = (com.google.android.gms.internal.auth.zzhd) r1
            int r0 = r2.size()
            r2.addAll(r0, r1)
            com.google.android.gms.internal.auth.zzhi.zzp(r5, r7, r2)
            goto L_0x0055
        L_0x0072:
            boolean r2 = r1 instanceof com.google.android.gms.internal.auth.zzgd
            if (r2 == 0) goto L_0x008f
            boolean r2 = r1 instanceof com.google.android.gms.internal.auth.zzey
            if (r2 == 0) goto L_0x008f
            r2 = r1
            com.google.android.gms.internal.auth.zzey r2 = (com.google.android.gms.internal.auth.zzey) r2
            boolean r3 = r2.zzc()
            if (r3 != 0) goto L_0x008f
            int r1 = r1.size()
            int r1 = r1 + r0
            com.google.android.gms.internal.auth.zzey r1 = r2.zzd(r1)
            com.google.android.gms.internal.auth.zzhi.zzp(r5, r7, r1)
        L_0x008f:
            int r0 = r1.size()
            int r2 = r6.size()
            if (r0 <= 0) goto L_0x009e
            if (r2 <= 0) goto L_0x009e
            r1.addAll(r6)
        L_0x009e:
            if (r0 > 0) goto L_0x00a1
            goto L_0x00a2
        L_0x00a1:
            r6 = r1
        L_0x00a2:
            com.google.android.gms.internal.auth.zzhi.zzp(r5, r7, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzfg.zzb(java.lang.Object, java.lang.Object, long):void");
    }
}
