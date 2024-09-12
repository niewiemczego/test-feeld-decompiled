package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzix;
import com.google.android.gms.internal.measurement.zznp;
import com.google.android.gms.internal.measurement.zzps;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzkg extends zzmo {
    private static String zza(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }

    /* access modifiers changed from: protected */
    public final boolean zzc() {
        return false;
    }

    public zzkg(zzmp zzmp) {
        super(zzmp);
    }

    public final byte[] zza(zzbg zzbg, String str) {
        zzne zzne;
        zzfi.zzi.zza zza;
        zzfi.zzj.zza zza2;
        Bundle bundle;
        zzh zzh;
        byte[] bArr;
        zzbc zzbc;
        long j;
        zzbg zzbg2 = zzbg;
        String str2 = str;
        zzt();
        this.zzu.zzy();
        Preconditions.checkNotNull(zzbg);
        Preconditions.checkNotEmpty(str);
        if (!zze().zze(str2, zzbi.zzbc)) {
            zzj().zzc().zza("Generating ScionPayload disabled. packageName", str2);
            return new byte[0];
        } else if ("_iap".equals(zzbg2.zza) || "_iapx".equals(zzbg2.zza)) {
            zzfi.zzi.zza zzb = zzfi.zzi.zzb();
            zzh().zzp();
            zzh zzd = zzh().zzd(str2);
            if (zzd == null) {
                zzj().zzc().zza("Log and bundle not available. package_name", str2);
                byte[] bArr2 = new byte[0];
                zzh().zzu();
                return bArr2;
            } else if (!zzd.zzak()) {
                zzj().zzc().zza("Log and bundle disabled. package_name", str2);
                byte[] bArr3 = new byte[0];
                zzh().zzu();
                return bArr3;
            } else {
                zzfi.zzj.zza zzp = zzfi.zzj.zzu().zzg(1).zzp("android");
                if (!TextUtils.isEmpty(zzd.zzx())) {
                    zzp.zzb(zzd.zzx());
                }
                if (!TextUtils.isEmpty(zzd.zzz())) {
                    zzp.zzd((String) Preconditions.checkNotNull(zzd.zzz()));
                }
                if (!TextUtils.isEmpty(zzd.zzaa())) {
                    zzp.zze((String) Preconditions.checkNotNull(zzd.zzaa()));
                }
                if (zzd.zzc() != -2147483648L) {
                    zzp.zze((int) zzd.zzc());
                }
                zzp.zzf(zzd.zzo()).zzd(zzd.zzm());
                String zzac = zzd.zzac();
                String zzv = zzd.zzv();
                if (!TextUtils.isEmpty(zzac)) {
                    zzp.zzm(zzac);
                } else if (!TextUtils.isEmpty(zzv)) {
                    zzp.zza(zzv);
                }
                zzp.zzj(zzd.zzt());
                zzih zzb2 = this.zzf.zzb(str2);
                zzp.zzc(zzd.zzl());
                if (this.zzu.zzac() && zze().zzk(zzp.zzr()) && zzb2.zzg() && !TextUtils.isEmpty((CharSequence) null)) {
                    zzp.zzj((String) null);
                }
                zzp.zzg(zzb2.zze());
                if (zzb2.zzg() && zzd.zzaj()) {
                    Pair<String, Boolean> zza3 = zzn().zza(zzd.zzx(), zzb2);
                    if (zzd.zzaj() && zza3 != null && !TextUtils.isEmpty((CharSequence) zza3.first)) {
                        try {
                            zzp.zzq(zza((String) zza3.first, Long.toString(zzbg2.zzd)));
                            if (zza3.second != null) {
                                zzp.zzc(((Boolean) zza3.second).booleanValue());
                            }
                        } catch (SecurityException e) {
                            zzj().zzc().zza("Resettable device id encryption failed", e.getMessage());
                            return new byte[0];
                        } finally {
                            zzh().zzu();
                        }
                    }
                }
                zzf().zzab();
                zzfi.zzj.zza zzi = zzp.zzi(Build.MODEL);
                zzf().zzab();
                zzi.zzo(Build.VERSION.RELEASE).zzi((int) zzf().zzg()).zzs(zzf().zzh());
                try {
                    if (zzb2.zzh() && zzd.zzy() != null) {
                        zzp.zzc(zza((String) Preconditions.checkNotNull(zzd.zzy()), Long.toString(zzbg2.zzd)));
                    }
                    if (!TextUtils.isEmpty(zzd.zzab())) {
                        zzp.zzl((String) Preconditions.checkNotNull(zzd.zzab()));
                    }
                    String zzx = zzd.zzx();
                    List<zzne> zzi2 = zzh().zzi(zzx);
                    Iterator<zzne> it = zzi2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            zzne = null;
                            break;
                        }
                        zzne = it.next();
                        if ("_lte".equals(zzne.zzc)) {
                            break;
                        }
                    }
                    if (zzne == null || zzne.zze == null) {
                        zzne zzne2 = new zzne(zzx, "auto", "_lte", zzb().currentTimeMillis(), 0L);
                        zzi2.add(zzne2);
                        zzh().zza(zzne2);
                    }
                    zzfi.zzn[] zznArr = new zzfi.zzn[zzi2.size()];
                    for (int i = 0; i < zzi2.size(); i++) {
                        zzfi.zzn.zza zzb3 = zzfi.zzn.zze().zza(zzi2.get(i).zzc).zzb(zzi2.get(i).zzd);
                        g_().zza(zzb3, zzi2.get(i).zze);
                        zznArr[i] = (zzfi.zzn) ((zzix) zzb3.zzab());
                    }
                    zzp.zze((Iterable<? extends zzfi.zzn>) Arrays.asList(zznArr));
                    g_().zza(zzp);
                    if (zznp.zza() && zze().zza(zzbi.zzcm)) {
                        this.zzf.zza(zzd, zzp);
                    }
                    zzfv zza4 = zzfv.zza(zzbg);
                    zzq().zza(zza4.zzb, zzh().zzc(str2));
                    zzq().zza(zza4, zze().zzd(str2));
                    Bundle bundle2 = zza4.zzb;
                    bundle2.putLong("_c", 1);
                    zzj().zzc().zza("Marking in-app purchase as real-time");
                    bundle2.putLong("_r", 1);
                    bundle2.putString("_o", zzbg2.zzc);
                    if (zzq().zzf(zzp.zzr())) {
                        zzq().zza(bundle2, "_dbg", (Object) 1L);
                        zzq().zza(bundle2, "_r", (Object) 1L);
                    }
                    zzbc zzd2 = zzh().zzd(str2, zzbg2.zza);
                    if (zzd2 == null) {
                        bundle = bundle2;
                        zzh = zzd;
                        zza2 = zzp;
                        zza = zzb;
                        bArr = null;
                        zzbc = new zzbc(str, zzbg2.zza, 0, 0, zzbg2.zzd, 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
                        j = 0;
                    } else {
                        bundle = bundle2;
                        zzh = zzd;
                        zza2 = zzp;
                        zza = zzb;
                        bArr = null;
                        j = zzd2.zzf;
                        zzbc = zzd2.zza(zzbg2.zzd);
                    }
                    zzh().zza(zzbc);
                    zzaz zzaz = new zzaz(this.zzu, zzbg2.zzc, str, zzbg2.zza, zzbg2.zzd, j, bundle);
                    zzfi.zze.zza zza5 = zzfi.zze.zze().zzb(zzaz.zzc).zza(zzaz.zzb).zza(zzaz.zzd);
                    Iterator<String> it2 = zzaz.zze.iterator();
                    while (it2.hasNext()) {
                        String next = it2.next();
                        zzfi.zzg.zza zza6 = zzfi.zzg.zze().zza(next);
                        Object zzc = zzaz.zze.zzc(next);
                        if (zzc != null) {
                            g_().zza(zza6, zzc);
                            zza5.zza(zza6);
                        }
                    }
                    zzfi.zzj.zza zza7 = zza2;
                    zza7.zza(zza5).zza(zzfi.zzk.zza().zza(zzfi.zzf.zza().zza(zzbc.zzc).zza(zzbg2.zza)));
                    zza7.zza((Iterable<? extends zzfi.zzc>) zzg().zza(zzh.zzx(), Collections.emptyList(), zza7.zzx(), Long.valueOf(zza5.zzc()), Long.valueOf(zza5.zzc())));
                    if (zza5.zzg()) {
                        zza7.zzi(zza5.zzc()).zze(zza5.zzc());
                    }
                    long zzp2 = zzh.zzp();
                    int i2 = (zzp2 > 0 ? 1 : (zzp2 == 0 ? 0 : -1));
                    if (i2 != 0) {
                        zza7.zzg(zzp2);
                    }
                    long zzr = zzh.zzr();
                    if (zzr != 0) {
                        zza7.zzh(zzr);
                    } else if (i2 != 0) {
                        zza7.zzh(zzp2);
                    }
                    String zzaf = zzh.zzaf();
                    if (zzps.zza()) {
                        if (zze().zze(str, zzbi.zzbt) && zzaf != null) {
                            zza7.zzr(zzaf);
                        }
                    } else {
                        String str3 = str;
                    }
                    zzh.zzai();
                    zza7.zzf((int) zzh.zzq()).zzl(82001).zzk(zzb().currentTimeMillis()).zzd(Boolean.TRUE.booleanValue());
                    if (zze().zza(zzbi.zzbw)) {
                        this.zzf.zza(zza7.zzr(), zza7);
                    }
                    zzfi.zzi.zza zza8 = zza;
                    zza8.zza(zza7);
                    zzh zzh2 = zzh;
                    zzh2.zzp(zza7.zzd());
                    zzh2.zzn(zza7.zzc());
                    zzh().zza(zzh2);
                    zzh().zzw();
                    try {
                        return g_().zzb(((zzfi.zzi) ((zzix) zza8.zzab())).zzbv());
                    } catch (IOException e2) {
                        zzj().zzg().zza("Data loss. Failed to bundle and serialize. appId", zzfr.zza(str), e2);
                        return bArr;
                    }
                } catch (SecurityException e3) {
                    zzj().zzc().zza("app instance id encryption failed", e3.getMessage());
                    byte[] bArr4 = new byte[0];
                    zzh().zzu();
                    return bArr4;
                }
            }
        } else {
            zzj().zzc().zza("Generating a payload for this event is not available. package_name, event_name", str2, zzbg2.zza);
            return null;
        }
    }
}
