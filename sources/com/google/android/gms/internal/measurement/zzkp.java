package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
final class zzkp<T> implements zzlb<T> {
    private final zzkj zza;
    private final zzma<?, ?> zzb;
    private final boolean zzc;
    private final zzim<?> zzd;

    public final int zza(T t) {
        zzma<?, ?> zzma = this.zzb;
        int zzb2 = zzma.zzb(zzma.zzd(t)) + 0;
        return this.zzc ? zzb2 + this.zzd.zza((Object) t).zza() : zzb2;
    }

    public final int zzb(T t) {
        int hashCode = this.zzb.zzd(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza((Object) t).hashCode() : hashCode;
    }

    static <T> zzkp<T> zza(zzma<?, ?> zzma, zzim<?> zzim, zzkj zzkj) {
        return new zzkp<>(zzma, zzim, zzkj);
    }

    public final T zza() {
        zzkj zzkj = this.zza;
        if (zzkj instanceof zzix) {
            return ((zzix) zzkj).zzbz();
        }
        return zzkj.zzcd().zzac();
    }

    private zzkp(zzma<?, ?> zzma, zzim<?> zzim, zzkj zzkj) {
        this.zzb = zzma;
        this.zzc = zzim.zza(zzkj);
        this.zzd = zzim;
        this.zza = zzkj;
    }

    public final void zzc(T t) {
        this.zzb.zzf(t);
        this.zzd.zzc(t);
    }

    public final void zza(T t, T t2) {
        zzld.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzld.zza(this.zzd, t, t2);
        }
    }

    public final void zza(T t, zzlc zzlc, zzik zzik) throws IOException {
        boolean z;
        zzma<?, ?> zzma = this.zzb;
        zzim<?> zzim = this.zzd;
        Object zzc2 = zzma.zzc(t);
        zziq<?> zzb2 = zzim.zzb(t);
        do {
            try {
                if (zzlc.zzc() == Integer.MAX_VALUE) {
                    zzma.zzb((Object) t, zzc2);
                    return;
                }
                int zzd2 = zzlc.zzd();
                if (zzd2 == 11) {
                    int i = 0;
                    Object obj = null;
                    zzhm zzhm = null;
                    while (zzlc.zzc() != Integer.MAX_VALUE) {
                        int zzd3 = zzlc.zzd();
                        if (zzd3 == 16) {
                            i = zzlc.zzj();
                            obj = zzim.zza(zzik, this.zza, i);
                        } else if (zzd3 == 26) {
                            if (obj != null) {
                                zzim.zza(zzlc, obj, zzik, zzb2);
                            } else {
                                zzhm = zzlc.zzp();
                            }
                        } else if (!zzlc.zzt()) {
                            break;
                        }
                    }
                    if (zzlc.zzd() != 12) {
                        throw zzji.zzb();
                    } else if (zzhm != null) {
                        if (obj != null) {
                            zzim.zza(zzhm, obj, zzik, zzb2);
                        } else {
                            zzma.zza(zzc2, i, zzhm);
                        }
                    }
                } else if ((zzd2 & 7) == 2) {
                    Object zza2 = zzim.zza(zzik, this.zza, zzd2 >>> 3);
                    if (zza2 != null) {
                        zzim.zza(zzlc, zza2, zzik, zzb2);
                    } else {
                        z = zzma.zza(zzc2, zzlc);
                        continue;
                    }
                } else {
                    z = zzlc.zzt();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzma.zzb((Object) t, zzc2);
            }
        } while (z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.measurement.zzix$zzf} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.measurement.zzhl r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.measurement.zzix r0 = (com.google.android.gms.internal.measurement.zzix) r0
            com.google.android.gms.internal.measurement.zzlz r1 = r0.zzb
            com.google.android.gms.internal.measurement.zzlz r2 = com.google.android.gms.internal.measurement.zzlz.zzc()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.measurement.zzlz r1 = com.google.android.gms.internal.measurement.zzlz.zzd()
            r0.zzb = r1
        L_0x0011:
            com.google.android.gms.internal.measurement.zzix$zzd r10 = (com.google.android.gms.internal.measurement.zzix.zzd) r10
            r10.zza()
            r10 = 0
            r0 = r10
        L_0x0018:
            if (r12 >= r13) goto L_0x00a4
            int r4 = com.google.android.gms.internal.measurement.zzhi.zzc(r11, r12, r14)
            int r2 = r14.zza
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L_0x0051
            r12 = r2 & 7
            if (r12 != r3) goto L_0x004c
            com.google.android.gms.internal.measurement.zzim<?> r12 = r9.zzd
            com.google.android.gms.internal.measurement.zzik r0 = r14.zzd
            com.google.android.gms.internal.measurement.zzkj r3 = r9.zza
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.measurement.zzix$zzf r0 = (com.google.android.gms.internal.measurement.zzix.zzf) r0
            if (r0 != 0) goto L_0x0043
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.measurement.zzhi.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzlz) r6, (com.google.android.gms.internal.measurement.zzhl) r7)
            goto L_0x0018
        L_0x0043:
            com.google.android.gms.internal.measurement.zzkx.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x004c:
            int r12 = com.google.android.gms.internal.measurement.zzhi.zza((int) r2, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.measurement.zzhl) r14)
            goto L_0x0018
        L_0x0051:
            r12 = 0
            r2 = r10
        L_0x0053:
            if (r4 >= r13) goto L_0x0099
            int r4 = com.google.android.gms.internal.measurement.zzhi.zzc(r11, r4, r14)
            int r5 = r14.zza
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L_0x007b
            r8 = 3
            if (r6 == r8) goto L_0x0065
            goto L_0x0090
        L_0x0065:
            if (r0 != 0) goto L_0x0072
            if (r7 != r3) goto L_0x0090
            int r4 = com.google.android.gms.internal.measurement.zzhi.zza(r11, r4, r14)
            java.lang.Object r2 = r14.zzc
            com.google.android.gms.internal.measurement.zzhm r2 = (com.google.android.gms.internal.measurement.zzhm) r2
            goto L_0x0053
        L_0x0072:
            com.google.android.gms.internal.measurement.zzkx.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x007b:
            if (r7 != 0) goto L_0x0090
            int r4 = com.google.android.gms.internal.measurement.zzhi.zzc(r11, r4, r14)
            int r12 = r14.zza
            com.google.android.gms.internal.measurement.zzim<?> r0 = r9.zzd
            com.google.android.gms.internal.measurement.zzik r5 = r14.zzd
            com.google.android.gms.internal.measurement.zzkj r6 = r9.zza
            java.lang.Object r0 = r0.zza(r5, r6, r12)
            com.google.android.gms.internal.measurement.zzix$zzf r0 = (com.google.android.gms.internal.measurement.zzix.zzf) r0
            goto L_0x0053
        L_0x0090:
            r6 = 12
            if (r5 == r6) goto L_0x0099
            int r4 = com.google.android.gms.internal.measurement.zzhi.zza((int) r5, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.measurement.zzhl) r14)
            goto L_0x0053
        L_0x0099:
            if (r2 == 0) goto L_0x00a1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zza((int) r12, (java.lang.Object) r2)
        L_0x00a1:
            r12 = r4
            goto L_0x0018
        L_0x00a4:
            if (r12 != r13) goto L_0x00a7
            return
        L_0x00a7:
            com.google.android.gms.internal.measurement.zzji r10 = com.google.android.gms.internal.measurement.zzji.zzg()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzkp.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzhl):void");
    }

    public final void zza(T t, zzmw zzmw) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd2 = this.zzd.zza((Object) t).zzd();
        while (zzd2.hasNext()) {
            Map.Entry next = zzd2.next();
            zzis zzis = (zzis) next.getKey();
            if (zzis.zzc() != zzmx.MESSAGE || zzis.zze() || zzis.zzd()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzjm) {
                zzmw.zza(zzis.zza(), (Object) ((zzjm) next).zza().zzc());
            } else {
                zzmw.zza(zzis.zza(), next.getValue());
            }
        }
        zzma<?, ?> zzma = this.zzb;
        zzma.zza(zzma.zzd(t), zzmw);
    }

    public final boolean zzb(T t, T t2) {
        if (!this.zzb.zzd(t).equals(this.zzb.zzd(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza((Object) t).equals(this.zzd.zza((Object) t2));
        }
        return true;
    }

    public final boolean zzd(T t) {
        return this.zzd.zza((Object) t).zzg();
    }
}
