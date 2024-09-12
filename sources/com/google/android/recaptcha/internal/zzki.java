package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzki implements zzkr {
    private final zzke zza;
    private final zzll zzb;
    private final boolean zzc;
    private final zzif zzd;

    private zzki(zzll zzll, zzif zzif, zzke zzke) {
        this.zzb = zzll;
        this.zzc = zzif.zzj(zzke);
        this.zzd = zzif;
        this.zza = zzke;
    }

    static zzki zzc(zzll zzll, zzif zzif, zzke zzke) {
        return new zzki(zzll, zzif, zzke);
    }

    public final int zza(Object obj) {
        zzll zzll = this.zzb;
        int zzb2 = zzll.zzb(zzll.zzd(obj));
        return this.zzc ? zzb2 + this.zzd.zzb(obj).zzb() : zzb2;
    }

    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzd(obj).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zzb(obj).zza.hashCode() : hashCode;
    }

    public final Object zze() {
        zzke zzke = this.zza;
        if (zzke instanceof zzit) {
            return ((zzit) zzke).zzs();
        }
        return zzke.zzW().zzk();
    }

    public final void zzf(Object obj) {
        this.zzb.zzm(obj);
        this.zzd.zzf(obj);
    }

    public final void zzg(Object obj, Object obj2) {
        zzkt.zzr(this.zzb, obj, obj2);
        if (this.zzc) {
            zzkt.zzq(this.zzd, obj, obj2);
        }
    }

    public final void zzh(Object obj, zzkq zzkq, zzie zzie) throws IOException {
        boolean z;
        zzll zzll = this.zzb;
        Object zzc2 = zzll.zzc(obj);
        zzif zzif = this.zzd;
        zzij zzc3 = zzif.zzc(obj);
        while (true) {
            if (zzkq.zzc() == Integer.MAX_VALUE) {
                break;
            }
            int zzd2 = zzkq.zzd();
            if (zzd2 != 11) {
                if ((zzd2 & 7) == 2) {
                    Object zzd3 = zzif.zzd(zzie, this.zza, zzd2 >>> 3);
                    if (zzd3 != null) {
                        zzif.zzg(zzkq, zzd3, zzie, zzc3);
                    } else {
                        z = zzll.zzr(zzc2, zzkq);
                    }
                } else {
                    z = zzkq.zzO();
                }
                if (!z) {
                    break;
                }
            } else {
                int i = 0;
                Object obj2 = null;
                zzgw zzgw = null;
                while (true) {
                    try {
                        if (zzkq.zzc() == Integer.MAX_VALUE) {
                            break;
                        }
                        int zzd4 = zzkq.zzd();
                        if (zzd4 == 16) {
                            i = zzkq.zzj();
                            obj2 = zzif.zzd(zzie, this.zza, i);
                        } else if (zzd4 == 26) {
                            if (obj2 != null) {
                                zzif.zzg(zzkq, obj2, zzie, zzc3);
                            } else {
                                zzgw = zzkq.zzp();
                            }
                        } else if (!zzkq.zzO()) {
                            break;
                        }
                    } catch (Throwable th) {
                        zzll.zzn(obj, zzc2);
                        throw th;
                    }
                }
                if (zzkq.zzd() != 12) {
                    throw zzje.zzb();
                } else if (zzgw != null) {
                    if (obj2 != null) {
                        zzif.zzh(zzgw, obj2, zzie, zzc3);
                    } else {
                        zzll.zzk(zzc2, i, zzgw);
                    }
                }
            }
        }
        zzll.zzn(obj, zzc2);
    }

    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzgj zzgj) throws IOException {
        zzit zzit = (zzit) obj;
        zzlm zzlm = zzit.zzc;
        if (zzlm == zzlm.zzc()) {
            zzlm = zzlm.zzf();
            zzit.zzc = zzlm;
        }
        ((zzip) obj).zzi();
        Object obj2 = null;
        while (i < i2) {
            int zzi = zzgk.zzi(bArr, i, zzgj);
            int i3 = zzgj.zza;
            if (i3 == 11) {
                int i4 = 0;
                zzgw zzgw = null;
                while (zzi < i2) {
                    zzi = zzgk.zzi(bArr, zzi, zzgj);
                    int i5 = zzgj.zza;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (obj2 != null) {
                                int i8 = zzkn.zza;
                                throw null;
                            } else if (i7 == 2) {
                                zzi = zzgk.zza(bArr, zzi, zzgj);
                                zzgw = (zzgw) zzgj.zzc;
                            }
                        }
                    } else if (i7 == 0) {
                        zzi = zzgk.zzi(bArr, zzi, zzgj);
                        i4 = zzgj.zza;
                        obj2 = this.zzd.zzd(zzgj.zzd, this.zza, i4);
                    }
                    if (i5 == 12) {
                        break;
                    }
                    zzi = zzgk.zzo(i5, bArr, zzi, i2, zzgj);
                }
                if (zzgw != null) {
                    zzlm.zzj((i4 << 3) | 2, zzgw);
                }
                i = zzi;
            } else if ((i3 & 7) == 2) {
                obj2 = this.zzd.zzd(zzgj.zzd, this.zza, i3 >>> 3);
                if (obj2 == null) {
                    i = zzgk.zzh(i3, bArr, zzi, i2, zzlm, zzgj);
                } else {
                    int i9 = zzkn.zza;
                    throw null;
                }
            } else {
                i = zzgk.zzo(i3, bArr, zzi, i2, zzgj);
            }
        }
        if (i != i2) {
            throw zzje.zzg();
        }
    }

    public final void zzj(Object obj, zzmd zzmd) throws IOException {
        Iterator zzf = this.zzd.zzb(obj).zzf();
        while (zzf.hasNext()) {
            Map.Entry entry = (Map.Entry) zzf.next();
            zzii zzii = (zzii) entry.getKey();
            if (zzii.zze() == zzmc.MESSAGE) {
                zzii.zzg();
                zzii.zzf();
                if (entry instanceof zzjh) {
                    zzmd.zzw(zzii.zza(), ((zzjh) entry).zza().zzb());
                } else {
                    zzmd.zzw(zzii.zza(), entry.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        zzll zzll = this.zzb;
        zzll.zzp(zzll.zzd(obj), zzmd);
    }

    public final boolean zzk(Object obj, Object obj2) {
        zzll zzll = this.zzb;
        if (!zzll.zzd(obj).equals(zzll.zzd(obj2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zzb(obj).equals(this.zzd.zzb(obj2));
        }
        return true;
    }

    public final boolean zzl(Object obj) {
        return this.zzd.zzb(obj).zzk();
    }
}
