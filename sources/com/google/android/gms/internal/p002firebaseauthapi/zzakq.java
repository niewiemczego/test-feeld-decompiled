package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzakq<T> implements zzalc<T> {
    private final zzakk zza;
    private final zzamb<?, ?> zzb;
    private final boolean zzc;
    private final zzair<?> zzd;

    public final int zza(T t) {
        zzamb<?, ?> zzamb = this.zzb;
        int zzb2 = zzamb.zzb(zzamb.zzd(t)) + 0;
        return this.zzc ? zzb2 + this.zzd.zza((Object) t).zza() : zzb2;
    }

    public final int zzb(T t) {
        int hashCode = this.zzb.zzd(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza((Object) t).hashCode() : hashCode;
    }

    static <T> zzakq<T> zza(zzamb<?, ?> zzamb, zzair<?> zzair, zzakk zzakk) {
        return new zzakq<>(zzamb, zzair, zzakk);
    }

    public final T zza() {
        zzakk zzakk = this.zza;
        if (zzakk instanceof zzaja) {
            return ((zzaja) zzakk).zzn();
        }
        return zzakk.zzp().zzg();
    }

    private zzakq(zzamb<?, ?> zzamb, zzair<?> zzair, zzakk zzakk) {
        this.zzb = zzamb;
        this.zzc = zzair.zza(zzakk);
        this.zzd = zzair;
        this.zza = zzakk;
    }

    public final void zzc(T t) {
        this.zzb.zzf(t);
        this.zzd.zzc(t);
    }

    public final void zza(T t, T t2) {
        zzale.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzale.zza(this.zzd, t, t2);
        }
    }

    public final void zza(T t, zzald zzald, zzaip zzaip) throws IOException {
        boolean z;
        zzamb<?, ?> zzamb = this.zzb;
        zzair<?> zzair = this.zzd;
        Object zzc2 = zzamb.zzc(t);
        zzais<?> zzb2 = zzair.zzb(t);
        do {
            try {
                if (zzald.zzc() == Integer.MAX_VALUE) {
                    zzamb.zzb((Object) t, zzc2);
                    return;
                }
                int zzd2 = zzald.zzd();
                if (zzd2 == 11) {
                    int i = 0;
                    Object obj = null;
                    zzahm zzahm = null;
                    while (zzald.zzc() != Integer.MAX_VALUE) {
                        int zzd3 = zzald.zzd();
                        if (zzd3 == 16) {
                            i = zzald.zzj();
                            obj = zzair.zza(zzaip, this.zza, i);
                        } else if (zzd3 == 26) {
                            if (obj != null) {
                                zzair.zza(zzald, obj, zzaip, zzb2);
                            } else {
                                zzahm = zzald.zzp();
                            }
                        } else if (!zzald.zzt()) {
                            break;
                        }
                    }
                    if (zzald.zzd() != 12) {
                        throw zzajj.zzb();
                    } else if (zzahm != null) {
                        if (obj != null) {
                            zzair.zza(zzahm, obj, zzaip, zzb2);
                        } else {
                            zzamb.zza(zzc2, i, zzahm);
                        }
                    }
                } else if ((zzd2 & 7) == 2) {
                    Object zza2 = zzair.zza(zzaip, this.zza, zzd2 >>> 3);
                    if (zza2 != null) {
                        zzair.zza(zzald, zza2, zzaip, zzb2);
                    } else {
                        z = zzamb.zza(zzc2, zzald);
                        continue;
                    }
                } else {
                    z = zzald.zzt();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzamb.zzb((Object) t, zzc2);
            }
        } while (z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.firebase-auth-api.zzaja$zzf} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.p002firebaseauthapi.zzahl r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.firebase-auth-api.zzaja r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzaja) r0
            com.google.android.gms.internal.firebase-auth-api.zzame r1 = r0.zzb
            com.google.android.gms.internal.firebase-auth-api.zzame r2 = com.google.android.gms.internal.p002firebaseauthapi.zzame.zzc()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.firebase-auth-api.zzame r1 = com.google.android.gms.internal.p002firebaseauthapi.zzame.zzd()
            r0.zzb = r1
        L_0x0011:
            com.google.android.gms.internal.firebase-auth-api.zzaja$zzd r10 = (com.google.android.gms.internal.p002firebaseauthapi.zzaja.zzd) r10
            r10.zza()
            r10 = 0
            r0 = r10
        L_0x0018:
            if (r12 >= r13) goto L_0x00a4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r11, r12, r14)
            int r2 = r14.zza
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L_0x0051
            r12 = r2 & 7
            if (r12 != r3) goto L_0x004c
            com.google.android.gms.internal.firebase-auth-api.zzair<?> r12 = r9.zzd
            com.google.android.gms.internal.firebase-auth-api.zzaip r0 = r14.zzd
            com.google.android.gms.internal.firebase-auth-api.zzakk r3 = r9.zza
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.firebase-auth-api.zzaja$zzf r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzaja.zzf) r0
            if (r0 != 0) goto L_0x0043
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.p002firebaseauthapi.zzame) r6, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r7)
            goto L_0x0018
        L_0x0043:
            com.google.android.gms.internal.p002firebaseauthapi.zzaky.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x004c:
            int r12 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza((int) r2, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r14)
            goto L_0x0018
        L_0x0051:
            r12 = 0
            r2 = r10
        L_0x0053:
            if (r4 >= r13) goto L_0x0099
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r11, r4, r14)
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
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza(r11, r4, r14)
            java.lang.Object r2 = r14.zzc
            com.google.android.gms.internal.firebase-auth-api.zzahm r2 = (com.google.android.gms.internal.p002firebaseauthapi.zzahm) r2
            goto L_0x0053
        L_0x0072:
            com.google.android.gms.internal.p002firebaseauthapi.zzaky.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x007b:
            if (r7 != 0) goto L_0x0090
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzc(r11, r4, r14)
            int r12 = r14.zza
            com.google.android.gms.internal.firebase-auth-api.zzair<?> r0 = r9.zzd
            com.google.android.gms.internal.firebase-auth-api.zzaip r5 = r14.zzd
            com.google.android.gms.internal.firebase-auth-api.zzakk r6 = r9.zza
            java.lang.Object r0 = r0.zza(r5, r6, r12)
            com.google.android.gms.internal.firebase-auth-api.zzaja$zzf r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzaja.zzf) r0
            goto L_0x0053
        L_0x0090:
            r6 = 12
            if (r5 == r6) goto L_0x0099
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zza((int) r5, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r14)
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
            com.google.android.gms.internal.firebase-auth-api.zzajj r10 = com.google.android.gms.internal.p002firebaseauthapi.zzajj.zzg()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzakq.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.firebase-auth-api.zzahl):void");
    }

    public final void zza(T t, zzanb zzanb) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd2 = this.zzd.zza((Object) t).zzd();
        while (zzd2.hasNext()) {
            Map.Entry next = zzd2.next();
            zzaiu zzaiu = (zzaiu) next.getKey();
            if (zzaiu.zzc() != zzamy.MESSAGE || zzaiu.zze() || zzaiu.zzd()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzajn) {
                zzanb.zza(zzaiu.zza(), (Object) ((zzajn) next).zza().zzc());
            } else {
                zzanb.zza(zzaiu.zza(), next.getValue());
            }
        }
        zzamb<?, ?> zzamb = this.zzb;
        zzamb.zza(zzamb.zzd(t), zzanb);
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
