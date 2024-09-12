package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzhd implements zzkq {
    private final zzhc zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzhd(zzhc zzhc) {
        byte[] bArr = zzjc.zzd;
        this.zza = zzhc;
        zzhc.zzc = this;
    }

    private final void zzP(Object obj, zzkr zzkr, zzie zzie) throws IOException {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzkr.zzh(obj, this, zzie);
            if (this.zzb != this.zzc) {
                throw zzje.zzg();
            }
        } finally {
            this.zzc = i;
        }
    }

    private final void zzQ(Object obj, zzkr zzkr, zzie zzie) throws IOException {
        zzhc zzhc = this.zza;
        int zzn = zzhc.zzn();
        if (zzhc.zza < zzhc.zzb) {
            int zze = this.zza.zze(zzn);
            this.zza.zza++;
            zzkr.zzh(obj, this, zzie);
            this.zza.zzz(0);
            zzhc zzhc2 = this.zza;
            zzhc2.zza--;
            zzhc2.zzA(zze);
            return;
        }
        throw new zzje("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final void zzR(int i) throws IOException {
        if (this.zza.zzd() != i) {
            throw zzje.zzj();
        }
    }

    private final void zzS(int i) throws IOException {
        if ((this.zzb & 7) != i) {
            throw zzje.zza();
        }
    }

    private static final void zzT(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzje.zzg();
        }
    }

    private static final void zzU(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzje.zzg();
        }
    }

    public static zzhd zzq(zzhc zzhc) {
        zzhd zzhd = zzhc.zzc;
        return zzhd != null ? zzhd : new zzhd(zzhc);
    }

    public final void zzA(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zzjt) {
            zzjt zzjt = (zzjt) list;
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    zzjt.zzg(this.zza.zzo());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzU(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzjt.zzg(this.zza.zzo());
                } while (this.zza.zzd() < zzd2);
                return;
            } else {
                throw zzje.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                } while (this.zza.zzd() < zzd3);
                return;
            } else {
                throw zzje.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzB(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zzil) {
            zzil zzil = (zzil) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzil.zze(this.zza.zzc());
                } while (this.zza.zzd() < zzd2);
                return;
            } else if (i2 == 5) {
                do {
                    zzil.zze(this.zza.zzc());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else {
                throw zzje.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                } while (this.zza.zzd() < zzd3);
                return;
            } else if (i3 == 5) {
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else {
                throw zzje.zza();
            }
        }
        this.zzd = i;
    }

    @Deprecated
    public final void zzC(List list, zzkr zzkr, zzie zzie) throws IOException {
        int zzm;
        int i = this.zzb;
        if ((i & 7) == 3) {
            do {
                Object zze = zzkr.zze();
                zzP(zze, zzkr, zzie);
                zzkr.zzf(zze);
                list.add(zze);
                if (!this.zza.zzC() && this.zzd == 0) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == i);
            this.zzd = zzm;
            return;
        }
        throw zzje.zza();
    }

    public final void zzD(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zziu.zzg(this.zza.zzh());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzhc zzhc = this.zza;
                int zzd2 = zzhc.zzd() + zzhc.zzn();
                do {
                    zziu.zzg(this.zza.zzh());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            } else {
                throw zzje.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else if (i3 == 2) {
                zzhc zzhc2 = this.zza;
                int zzd3 = zzhc2.zzd() + zzhc2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
                return;
            } else {
                throw zzje.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzE(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zzjt) {
            zzjt zzjt = (zzjt) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzjt.zzg(this.zza.zzp());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzhc zzhc = this.zza;
                int zzd2 = zzhc.zzd() + zzhc.zzn();
                do {
                    zzjt.zzg(this.zza.zzp());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            } else {
                throw zzje.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else if (i3 == 2) {
                zzhc zzhc2 = this.zza;
                int zzd3 = zzhc2.zzd() + zzhc2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
                return;
            } else {
                throw zzje.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzF(List list, zzkr zzkr, zzie zzie) throws IOException {
        int zzm;
        int i = this.zzb;
        if ((i & 7) == 2) {
            do {
                Object zze = zzkr.zze();
                zzQ(zze, zzkr, zzie);
                zzkr.zzf(zze);
                list.add(zze);
                if (!this.zza.zzC() && this.zzd == 0) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == i);
            this.zzd = zzm;
            return;
        }
        throw zzje.zza();
    }

    public final void zzG(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zziu.zzg(this.zza.zzk());
                } while (this.zza.zzd() < zzd2);
                return;
            } else if (i2 == 5) {
                do {
                    zziu.zzg(this.zza.zzk());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else {
                throw zzje.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                } while (this.zza.zzd() < zzd3);
                return;
            } else if (i3 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else {
                throw zzje.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzH(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zzjt) {
            zzjt zzjt = (zzjt) list;
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    zzjt.zzg(this.zza.zzt());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzU(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzjt.zzg(this.zza.zzt());
                } while (this.zza.zzd() < zzd2);
                return;
            } else {
                throw zzje.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                } while (this.zza.zzd() < zzd3);
                return;
            } else {
                throw zzje.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzI(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zziu.zzg(this.zza.zzl());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzhc zzhc = this.zza;
                int zzd2 = zzhc.zzd() + zzhc.zzn();
                do {
                    zziu.zzg(this.zza.zzl());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            } else {
                throw zzje.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzl()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else if (i3 == 2) {
                zzhc zzhc2 = this.zza;
                int zzd3 = zzhc2.zzd() + zzhc2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzl()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
                return;
            } else {
                throw zzje.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzJ(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zzjt) {
            zzjt zzjt = (zzjt) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzjt.zzg(this.zza.zzu());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzhc zzhc = this.zza;
                int zzd2 = zzhc.zzd() + zzhc.zzn();
                do {
                    zzjt.zzg(this.zza.zzu());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            } else {
                throw zzje.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else if (i3 == 2) {
                zzhc zzhc2 = this.zza;
                int zzd3 = zzhc2.zzd() + zzhc2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
                return;
            } else {
                throw zzje.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzK(List list, boolean z) throws IOException {
        int zzm;
        int i;
        if ((this.zzb & 7) == 2) {
            if ((list instanceof zzjm) && !z) {
                zzjm zzjm = (zzjm) list;
                do {
                    zzjm.zzi(zzp());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else {
                do {
                    list.add(z ? zzs() : zzr());
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            }
            this.zzd = i;
            return;
        }
        throw zzje.zza();
    }

    public final void zzL(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zziu.zzg(this.zza.zzn());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzhc zzhc = this.zza;
                int zzd2 = zzhc.zzd() + zzhc.zzn();
                do {
                    zziu.zzg(this.zza.zzn());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            } else {
                throw zzje.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else if (i3 == 2) {
                zzhc zzhc2 = this.zza;
                int zzd3 = zzhc2.zzd() + zzhc2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
                return;
            } else {
                throw zzje.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzM(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zzjt) {
            zzjt zzjt = (zzjt) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzjt.zzg(this.zza.zzv());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzhc zzhc = this.zza;
                int zzd2 = zzhc.zzd() + zzhc.zzn();
                do {
                    zzjt.zzg(this.zza.zzv());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            } else {
                throw zzje.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Long.valueOf(this.zza.zzv()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else if (i3 == 2) {
                zzhc zzhc2 = this.zza;
                int zzd3 = zzhc2.zzd() + zzhc2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzv()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
                return;
            } else {
                throw zzje.zza();
            }
        }
        this.zzd = i;
    }

    public final boolean zzN() throws IOException {
        zzS(0);
        return this.zza.zzD();
    }

    public final boolean zzO() throws IOException {
        int i;
        if (this.zza.zzC() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzE(i);
    }

    public final double zza() throws IOException {
        zzS(1);
        return this.zza.zzb();
    }

    public final float zzb() throws IOException {
        zzS(5);
        return this.zza.zzc();
    }

    public final int zzc() throws IOException {
        int i = this.zzd;
        if (i != 0) {
            this.zzb = i;
            this.zzd = 0;
        } else {
            i = this.zza.zzm();
            this.zzb = i;
        }
        if (i == 0 || i == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return i >>> 3;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final int zze() throws IOException {
        zzS(0);
        return this.zza.zzf();
    }

    public final int zzf() throws IOException {
        zzS(5);
        return this.zza.zzg();
    }

    public final int zzg() throws IOException {
        zzS(0);
        return this.zza.zzh();
    }

    public final int zzh() throws IOException {
        zzS(5);
        return this.zza.zzk();
    }

    public final int zzi() throws IOException {
        zzS(0);
        return this.zza.zzl();
    }

    public final int zzj() throws IOException {
        zzS(0);
        return this.zza.zzn();
    }

    public final long zzk() throws IOException {
        zzS(1);
        return this.zza.zzo();
    }

    public final long zzl() throws IOException {
        zzS(0);
        return this.zza.zzp();
    }

    public final long zzm() throws IOException {
        zzS(1);
        return this.zza.zzt();
    }

    public final long zzn() throws IOException {
        zzS(0);
        return this.zza.zzu();
    }

    public final long zzo() throws IOException {
        zzS(0);
        return this.zza.zzv();
    }

    public final zzgw zzp() throws IOException {
        zzS(2);
        return this.zza.zzw();
    }

    public final String zzr() throws IOException {
        zzS(2);
        return this.zza.zzx();
    }

    public final String zzs() throws IOException {
        zzS(2);
        return this.zza.zzy();
    }

    public final void zzt(Object obj, zzkr zzkr, zzie zzie) throws IOException {
        zzS(3);
        zzP(obj, zzkr, zzie);
    }

    public final void zzu(Object obj, zzkr zzkr, zzie zzie) throws IOException {
        zzS(2);
        zzQ(obj, zzkr, zzie);
    }

    public final void zzv(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zzgl) {
            zzgl zzgl = (zzgl) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zzgl.zze(this.zza.zzD());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzhc zzhc = this.zza;
                int zzd2 = zzhc.zzd() + zzhc.zzn();
                do {
                    zzgl.zze(this.zza.zzD());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            } else {
                throw zzje.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zza.zzD()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else if (i3 == 2) {
                zzhc zzhc2 = this.zza;
                int zzd3 = zzhc2.zzd() + zzhc2.zzn();
                do {
                    list.add(Boolean.valueOf(this.zza.zzD()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
                return;
            } else {
                throw zzje.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzw(List list) throws IOException {
        int zzm;
        if ((this.zzb & 7) == 2) {
            do {
                list.add(zzp());
                if (!this.zza.zzC()) {
                    zzm = this.zza.zzm();
                } else {
                    return;
                }
            } while (zzm == this.zzb);
            this.zzd = zzm;
            return;
        }
        throw zzje.zza();
    }

    public final void zzx(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zzhy) {
            zzhy zzhy = (zzhy) list;
            int i2 = this.zzb & 7;
            if (i2 == 1) {
                do {
                    zzhy.zze(this.zza.zzb());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzU(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zzhy.zze(this.zza.zzb());
                } while (this.zza.zzd() < zzd2);
                return;
            } else {
                throw zzje.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 1) {
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzU(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                } while (this.zza.zzd() < zzd3);
                return;
            } else {
                throw zzje.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzy(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            int i2 = this.zzb & 7;
            if (i2 == 0) {
                do {
                    zziu.zzg(this.zza.zzf());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else if (i2 == 2) {
                zzhc zzhc = this.zza;
                int zzd2 = zzhc.zzd() + zzhc.zzn();
                do {
                    zziu.zzg(this.zza.zzf());
                } while (this.zza.zzd() < zzd2);
                zzR(zzd2);
                return;
            } else {
                throw zzje.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 0) {
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else if (i3 == 2) {
                zzhc zzhc2 = this.zza;
                int zzd3 = zzhc2.zzd() + zzhc2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzd() < zzd3);
                zzR(zzd3);
                return;
            } else {
                throw zzje.zza();
            }
        }
        this.zzd = i;
    }

    public final void zzz(List list) throws IOException {
        int i;
        int zzm;
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int zzn = this.zza.zzn();
                zzT(zzn);
                int zzd2 = this.zza.zzd() + zzn;
                do {
                    zziu.zzg(this.zza.zzg());
                } while (this.zza.zzd() < zzd2);
                return;
            } else if (i2 == 5) {
                do {
                    zziu.zzg(this.zza.zzg());
                    if (!this.zza.zzC()) {
                        i = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (i == this.zzb);
            } else {
                throw zzje.zza();
            }
        } else {
            int i3 = this.zzb & 7;
            if (i3 == 2) {
                int zzn2 = this.zza.zzn();
                zzT(zzn2);
                int zzd3 = this.zza.zzd() + zzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                } while (this.zza.zzd() < zzd3);
                return;
            } else if (i3 == 5) {
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                    if (!this.zza.zzC()) {
                        zzm = this.zza.zzm();
                    } else {
                        return;
                    }
                } while (zzm == this.zzb);
                i = zzm;
            } else {
                throw zzje.zza();
            }
        }
        this.zzd = i;
    }
}
