package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
final class zzif implements zzlc {
    private final zzib zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    public final double zza() throws IOException {
        zzb(1);
        return this.zza.zza();
    }

    public final float zzb() throws IOException {
        zzb(5);
        return this.zza.zzb();
    }

    public final int zzc() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            this.zzb = this.zza.zzi();
        }
        int i2 = this.zzb;
        if (i2 == 0 || i2 == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() throws IOException {
        zzb(0);
        return this.zza.zzd();
    }

    public final int zzf() throws IOException {
        zzb(5);
        return this.zza.zze();
    }

    public final int zzg() throws IOException {
        zzb(0);
        return this.zza.zzf();
    }

    public final int zzh() throws IOException {
        zzb(5);
        return this.zza.zzg();
    }

    public final int zzi() throws IOException {
        zzb(0);
        return this.zza.zzh();
    }

    public final int zzj() throws IOException {
        zzb(0);
        return this.zza.zzj();
    }

    public final long zzk() throws IOException {
        zzb(1);
        return this.zza.zzk();
    }

    public final long zzl() throws IOException {
        zzb(0);
        return this.zza.zzl();
    }

    public final long zzm() throws IOException {
        zzb(1);
        return this.zza.zzn();
    }

    public final long zzn() throws IOException {
        zzb(0);
        return this.zza.zzo();
    }

    public final long zzo() throws IOException {
        zzb(0);
        return this.zza.zzp();
    }

    public final zzhm zzp() throws IOException {
        zzb(2);
        return this.zza.zzq();
    }

    public static zzif zza(zzib zzib) {
        if (zzib.zzc != null) {
            return zzib.zzc;
        }
        return new zzif(zzib);
    }

    private final Object zza(zzmn zzmn, Class<?> cls, zzik zzik) throws IOException {
        switch (zzie.zza[zzmn.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzs());
            case 2:
                return zzp();
            case 3:
                return Double.valueOf(zza());
            case 4:
                return Integer.valueOf(zze());
            case 5:
                return Integer.valueOf(zzf());
            case 6:
                return Long.valueOf(zzk());
            case 7:
                return Float.valueOf(zzb());
            case 8:
                return Integer.valueOf(zzg());
            case 9:
                return Long.valueOf(zzl());
            case 10:
                zzb(2);
                return zzb(zzkx.zza().zza(cls), zzik);
            case 11:
                return Integer.valueOf(zzh());
            case 12:
                return Long.valueOf(zzm());
            case 13:
                return Integer.valueOf(zzi());
            case 14:
                return Long.valueOf(zzn());
            case 15:
                return zzr();
            case 16:
                return Integer.valueOf(zzj());
            case 17:
                return Long.valueOf(zzo());
            default:
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    private final <T> T zza(zzlb<T> zzlb, zzik zzik) throws IOException {
        T zza2 = zzlb.zza();
        zzc(zza2, zzlb, zzik);
        zzlb.zzc(zza2);
        return zza2;
    }

    private final <T> T zzb(zzlb<T> zzlb, zzik zzik) throws IOException {
        T zza2 = zzlb.zza();
        zzd(zza2, zzlb, zzik);
        zzlb.zzc(zza2);
        return zza2;
    }

    public final String zzq() throws IOException {
        zzb(2);
        return this.zza.zzr();
    }

    public final String zzr() throws IOException {
        zzb(2);
        return this.zza.zzs();
    }

    private zzif(zzib zzib) {
        zzib zzib2 = (zzib) zziz.zza(zzib, "input");
        this.zza = zzib2;
        zzib2.zzc = this;
    }

    public final <T> void zza(T t, zzlb<T> zzlb, zzik zzik) throws IOException {
        zzb(3);
        zzc(t, zzlb, zzik);
    }

    private final <T> void zzc(T t, zzlb<T> zzlb, zzik zzik) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzlb.zza(t, this, zzik);
            if (this.zzb != this.zzc) {
                throw zzji.zzg();
            }
        } finally {
            this.zzc = i;
        }
    }

    public final <T> void zzb(T t, zzlb<T> zzlb, zzik zzik) throws IOException {
        zzb(2);
        zzd(t, zzlb, zzik);
    }

    private final <T> void zzd(T t, zzlb<T> zzlb, zzik zzik) throws IOException {
        int zzj = this.zza.zzj();
        if (this.zza.zza < this.zza.zzb) {
            int zza2 = this.zza.zza(zzj);
            this.zza.zza++;
            zzlb.zza(t, this, zzik);
            this.zza.zzb(0);
            zzib zzib = this.zza;
            zzib.zza--;
            this.zza.zzc(zza2);
            return;
        }
        throw new zzji("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public final void zza(List<Boolean> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzhk) {
            zzhk zzhk = (zzhk) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzhk.zza(this.zza.zzu());
                    if (!this.zza.zzt()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else if (i == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    zzhk.zza(this.zza.zzu());
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
            } else {
                throw zzji.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzu()));
                    if (!this.zza.zzt()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else if (i2 == 2) {
                int zzc3 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Boolean.valueOf(this.zza.zzu()));
                } while (this.zza.zzc() < zzc3);
                zza(zzc3);
            } else {
                throw zzji.zza();
            }
        }
    }

    public final void zzb(List<zzhm> list) throws IOException {
        int zzi;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzp());
                if (!this.zza.zzt()) {
                    zzi = this.zza.zzi();
                } else {
                    return;
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
            return;
        }
        throw zzji.zza();
    }

    public final void zzc(List<Double> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzii) {
            zzii zzii = (zzii) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzii.zza(this.zza.zza());
                    if (!this.zza.zzt()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else if (i == 2) {
                int zzj = this.zza.zzj();
                zzd(zzj);
                int zzc2 = this.zza.zzc() + zzj;
                do {
                    zzii.zza(this.zza.zza());
                } while (this.zza.zzc() < zzc2);
            } else {
                throw zzji.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.zza.zza()));
                    if (!this.zza.zzt()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else if (i2 == 2) {
                int zzj2 = this.zza.zzj();
                zzd(zzj2);
                int zzc3 = this.zza.zzc() + zzj2;
                do {
                    list.add(Double.valueOf(this.zza.zza()));
                } while (this.zza.zzc() < zzc3);
            } else {
                throw zzji.zza();
            }
        }
    }

    public final void zzd(List<Integer> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzja) {
            zzja zzja = (zzja) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzja.zzd(this.zza.zzd());
                    if (!this.zza.zzt()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else if (i == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    zzja.zzd(this.zza.zzd());
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
            } else {
                throw zzji.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzd()));
                    if (!this.zza.zzt()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else if (i2 == 2) {
                int zzc3 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Integer.valueOf(this.zza.zzd()));
                } while (this.zza.zzc() < zzc3);
                zza(zzc3);
            } else {
                throw zzji.zza();
            }
        }
    }

    public final void zze(List<Integer> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzja) {
            zzja zzja = (zzja) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzj = this.zza.zzj();
                zzc(zzj);
                int zzc2 = this.zza.zzc() + zzj;
                do {
                    zzja.zzd(this.zza.zze());
                } while (this.zza.zzc() < zzc2);
            } else if (i == 5) {
                do {
                    zzja.zzd(this.zza.zze());
                    if (!this.zza.zzt()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else {
                throw zzji.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzj2 = this.zza.zzj();
                zzc(zzj2);
                int zzc3 = this.zza.zzc() + zzj2;
                do {
                    list.add(Integer.valueOf(this.zza.zze()));
                } while (this.zza.zzc() < zzc3);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zze()));
                    if (!this.zza.zzt()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else {
                throw zzji.zza();
            }
        }
    }

    public final void zzf(List<Long> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzjy) {
            zzjy zzjy = (zzjy) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzjy.zza(this.zza.zzk());
                    if (!this.zza.zzt()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else if (i == 2) {
                int zzj = this.zza.zzj();
                zzd(zzj);
                int zzc2 = this.zza.zzc() + zzj;
                do {
                    zzjy.zza(this.zza.zzk());
                } while (this.zza.zzc() < zzc2);
            } else {
                throw zzji.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzk()));
                    if (!this.zza.zzt()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else if (i2 == 2) {
                int zzj2 = this.zza.zzj();
                zzd(zzj2);
                int zzc3 = this.zza.zzc() + zzj2;
                do {
                    list.add(Long.valueOf(this.zza.zzk()));
                } while (this.zza.zzc() < zzc3);
            } else {
                throw zzji.zza();
            }
        }
    }

    public final void zzg(List<Float> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zziw) {
            zziw zziw = (zziw) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzj = this.zza.zzj();
                zzc(zzj);
                int zzc2 = this.zza.zzc() + zzj;
                do {
                    zziw.zza(this.zza.zzb());
                } while (this.zza.zzc() < zzc2);
            } else if (i == 5) {
                do {
                    zziw.zza(this.zza.zzb());
                    if (!this.zza.zzt()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else {
                throw zzji.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzj2 = this.zza.zzj();
                zzc(zzj2);
                int zzc3 = this.zza.zzc() + zzj2;
                do {
                    list.add(Float.valueOf(this.zza.zzb()));
                } while (this.zza.zzc() < zzc3);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zza.zzb()));
                    if (!this.zza.zzt()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else {
                throw zzji.zza();
            }
        }
    }

    @Deprecated
    public final <T> void zza(List<T> list, zzlb<T> zzlb, zzik zzik) throws IOException {
        int zzi;
        int i = this.zzb;
        if ((i & 7) == 3) {
            do {
                list.add(zza(zzlb, zzik));
                if (!this.zza.zzt() && this.zzd == 0) {
                    zzi = this.zza.zzi();
                } else {
                    return;
                }
            } while (zzi == i);
            this.zzd = zzi;
            return;
        }
        throw zzji.zza();
    }

    public final void zzh(List<Integer> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzja) {
            zzja zzja = (zzja) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzja.zzd(this.zza.zzf());
                    if (!this.zza.zzt()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else if (i == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    zzja.zzd(this.zza.zzf());
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
            } else {
                throw zzji.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                    if (!this.zza.zzt()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else if (i2 == 2) {
                int zzc3 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzc() < zzc3);
                zza(zzc3);
            } else {
                throw zzji.zza();
            }
        }
    }

    public final void zzi(List<Long> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzjy) {
            zzjy zzjy = (zzjy) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzjy.zza(this.zza.zzl());
                    if (!this.zza.zzt()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else if (i == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    zzjy.zza(this.zza.zzl());
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
            } else {
                throw zzji.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzl()));
                    if (!this.zza.zzt()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else if (i2 == 2) {
                int zzc3 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Long.valueOf(this.zza.zzl()));
                } while (this.zza.zzc() < zzc3);
                zza(zzc3);
            } else {
                throw zzji.zza();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (zzt() != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        throw new com.google.android.gms.internal.measurement.zzji("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.measurement.zzke<K, V> r9, com.google.android.gms.internal.measurement.zzik r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.zzb((int) r0)
            com.google.android.gms.internal.measurement.zzib r1 = r7.zza
            int r1 = r1.zzj()
            com.google.android.gms.internal.measurement.zzib r2 = r7.zza
            int r1 = r2.zza((int) r1)
            K r2 = r9.zzb
            V r3 = r9.zzd
        L_0x0014:
            int r4 = r7.zzc()     // Catch:{ all -> 0x0064 }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x005b
            com.google.android.gms.internal.measurement.zzib r5 = r7.zza     // Catch:{ all -> 0x0064 }
            boolean r5 = r5.zzt()     // Catch:{ all -> 0x0064 }
            if (r5 != 0) goto L_0x005b
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0046
            if (r4 == r0) goto L_0x0039
            boolean r4 = r7.zzt()     // Catch:{ zzjh -> 0x004e }
            if (r4 == 0) goto L_0x0033
            goto L_0x0014
        L_0x0033:
            com.google.android.gms.internal.measurement.zzji r4 = new com.google.android.gms.internal.measurement.zzji     // Catch:{ zzjh -> 0x004e }
            r4.<init>(r6)     // Catch:{ zzjh -> 0x004e }
            throw r4     // Catch:{ zzjh -> 0x004e }
        L_0x0039:
            com.google.android.gms.internal.measurement.zzmn r4 = r9.zzc     // Catch:{ zzjh -> 0x004e }
            V r5 = r9.zzd     // Catch:{ zzjh -> 0x004e }
            java.lang.Class r5 = r5.getClass()     // Catch:{ zzjh -> 0x004e }
            java.lang.Object r3 = r7.zza((com.google.android.gms.internal.measurement.zzmn) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.measurement.zzik) r10)     // Catch:{ zzjh -> 0x004e }
            goto L_0x0014
        L_0x0046:
            com.google.android.gms.internal.measurement.zzmn r4 = r9.zza     // Catch:{ zzjh -> 0x004e }
            r5 = 0
            java.lang.Object r2 = r7.zza((com.google.android.gms.internal.measurement.zzmn) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.measurement.zzik) r5)     // Catch:{ zzjh -> 0x004e }
            goto L_0x0014
        L_0x004e:
            boolean r4 = r7.zzt()     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x0055
            goto L_0x0014
        L_0x0055:
            com.google.android.gms.internal.measurement.zzji r8 = new com.google.android.gms.internal.measurement.zzji     // Catch:{ all -> 0x0064 }
            r8.<init>(r6)     // Catch:{ all -> 0x0064 }
            throw r8     // Catch:{ all -> 0x0064 }
        L_0x005b:
            r8.put(r2, r3)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.internal.measurement.zzib r8 = r7.zza
            r8.zzc(r1)
            return
        L_0x0064:
            r8 = move-exception
            com.google.android.gms.internal.measurement.zzib r9 = r7.zza
            r9.zzc(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzif.zza(java.util.Map, com.google.android.gms.internal.measurement.zzke, com.google.android.gms.internal.measurement.zzik):void");
    }

    public final <T> void zzb(List<T> list, zzlb<T> zzlb, zzik zzik) throws IOException {
        int zzi;
        int i = this.zzb;
        if ((i & 7) == 2) {
            do {
                list.add(zzb(zzlb, zzik));
                if (!this.zza.zzt() && this.zzd == 0) {
                    zzi = this.zza.zzi();
                } else {
                    return;
                }
            } while (zzi == i);
            this.zzd = zzi;
            return;
        }
        throw zzji.zza();
    }

    public final void zzj(List<Integer> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzja) {
            zzja zzja = (zzja) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int zzj = this.zza.zzj();
                zzc(zzj);
                int zzc2 = this.zza.zzc() + zzj;
                do {
                    zzja.zzd(this.zza.zzg());
                } while (this.zza.zzc() < zzc2);
            } else if (i == 5) {
                do {
                    zzja.zzd(this.zza.zzg());
                    if (!this.zza.zzt()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else {
                throw zzji.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzj2 = this.zza.zzj();
                zzc(zzj2);
                int zzc3 = this.zza.zzc() + zzj2;
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                } while (this.zza.zzc() < zzc3);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                    if (!this.zza.zzt()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else {
                throw zzji.zza();
            }
        }
    }

    public final void zzk(List<Long> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzjy) {
            zzjy zzjy = (zzjy) list;
            int i = this.zzb & 7;
            if (i == 1) {
                do {
                    zzjy.zza(this.zza.zzn());
                    if (!this.zza.zzt()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else if (i == 2) {
                int zzj = this.zza.zzj();
                zzd(zzj);
                int zzc2 = this.zza.zzc() + zzj;
                do {
                    zzjy.zza(this.zza.zzn());
                } while (this.zza.zzc() < zzc2);
            } else {
                throw zzji.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzn()));
                    if (!this.zza.zzt()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else if (i2 == 2) {
                int zzj2 = this.zza.zzj();
                zzd(zzj2);
                int zzc3 = this.zza.zzc() + zzj2;
                do {
                    list.add(Long.valueOf(this.zza.zzn()));
                } while (this.zza.zzc() < zzc3);
            } else {
                throw zzji.zza();
            }
        }
    }

    public final void zzl(List<Integer> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzja) {
            zzja zzja = (zzja) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzja.zzd(this.zza.zzh());
                    if (!this.zza.zzt()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else if (i == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    zzja.zzd(this.zza.zzh());
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
            } else {
                throw zzji.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                    if (!this.zza.zzt()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else if (i2 == 2) {
                int zzc3 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzc() < zzc3);
                zza(zzc3);
            } else {
                throw zzji.zza();
            }
        }
    }

    public final void zzm(List<Long> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzjy) {
            zzjy zzjy = (zzjy) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzjy.zza(this.zza.zzo());
                    if (!this.zza.zzt()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else if (i == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    zzjy.zza(this.zza.zzo());
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
            } else {
                throw zzji.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                    if (!this.zza.zzt()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else if (i2 == 2) {
                int zzc3 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                } while (this.zza.zzc() < zzc3);
                zza(zzc3);
            } else {
                throw zzji.zza();
            }
        }
    }

    public final void zzn(List<String> list) throws IOException {
        zza(list, false);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zzi;
        int zzi2;
        if ((this.zzb & 7) != 2) {
            throw zzji.zza();
        } else if (!(list instanceof zzjp) || z) {
            do {
                list.add(z ? zzr() : zzq());
                if (!this.zza.zzt()) {
                    zzi = this.zza.zzi();
                } else {
                    return;
                }
            } while (zzi == this.zzb);
            this.zzd = zzi;
        } else {
            zzjp zzjp = (zzjp) list;
            do {
                zzjp.zza(zzp());
                if (!this.zza.zzt()) {
                    zzi2 = this.zza.zzi();
                } else {
                    return;
                }
            } while (zzi2 == this.zzb);
            this.zzd = zzi2;
        }
    }

    public final void zzo(List<String> list) throws IOException {
        zza(list, true);
    }

    public final void zzp(List<Integer> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzja) {
            zzja zzja = (zzja) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzja.zzd(this.zza.zzj());
                    if (!this.zza.zzt()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else if (i == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    zzja.zzd(this.zza.zzj());
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
            } else {
                throw zzji.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzj()));
                    if (!this.zza.zzt()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else if (i2 == 2) {
                int zzc3 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Integer.valueOf(this.zza.zzj()));
                } while (this.zza.zzc() < zzc3);
                zza(zzc3);
            } else {
                throw zzji.zza();
            }
        }
    }

    public final void zzq(List<Long> list) throws IOException {
        int zzi;
        int zzi2;
        if (list instanceof zzjy) {
            zzjy zzjy = (zzjy) list;
            int i = this.zzb & 7;
            if (i == 0) {
                do {
                    zzjy.zza(this.zza.zzp());
                    if (!this.zza.zzt()) {
                        zzi2 = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi2 == this.zzb);
                this.zzd = zzi2;
            } else if (i == 2) {
                int zzc2 = this.zza.zzc() + this.zza.zzj();
                do {
                    zzjy.zza(this.zza.zzp());
                } while (this.zza.zzc() < zzc2);
                zza(zzc2);
            } else {
                throw zzji.zza();
            }
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                    if (!this.zza.zzt()) {
                        zzi = this.zza.zzi();
                    } else {
                        return;
                    }
                } while (zzi == this.zzb);
                this.zzd = zzi;
            } else if (i2 == 2) {
                int zzc3 = this.zza.zzc() + this.zza.zzj();
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                } while (this.zza.zzc() < zzc3);
                zza(zzc3);
            } else {
                throw zzji.zza();
            }
        }
    }

    private final void zza(int i) throws IOException {
        if (this.zza.zzc() != i) {
            throw zzji.zzh();
        }
    }

    private final void zzb(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzji.zza();
        }
    }

    private static void zzc(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzji.zzg();
        }
    }

    private static void zzd(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzji.zzg();
        }
    }

    public final boolean zzs() throws IOException {
        zzb(0);
        return this.zza.zzu();
    }

    public final boolean zzt() throws IOException {
        int i;
        if (this.zza.zzt() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzd(i);
    }
}
