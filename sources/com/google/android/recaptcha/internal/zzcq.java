package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzcq implements zzdd {
    public static final zzcq zza = new zzcq();

    private zzcq() {
    }

    public final void zza(int i, zzcj zzcj, zzpq... zzpqArr) throws zzae {
        int length = zzpqArr.length;
        if (length != 0) {
            zzpi zzf = zzpl.zzf();
            int i2 = 0;
            while (i2 < length) {
                Object zza2 = zzcj.zzc().zza(zzpqArr[i2]);
                if (zza2 != null) {
                    zzpj zzf2 = zzpk.zzf();
                    if (zza2 instanceof Integer) {
                        zzf2.zzt(((Number) zza2).intValue());
                    } else if (zza2 instanceof Short) {
                        zzf2.zzs(((Number) zza2).shortValue());
                    } else if (zza2 instanceof Byte) {
                        zzf2.zze(zzgw.zzm(new byte[]{((Number) zza2).byteValue()}, 0, 1));
                    } else if (zza2 instanceof Long) {
                        zzf2.zzu(((Number) zza2).longValue());
                    } else if (zza2 instanceof Double) {
                        zzf2.zzq(((Number) zza2).doubleValue());
                    } else if (zza2 instanceof Float) {
                        zzf2.zzr(((Number) zza2).floatValue());
                    } else if (zza2 instanceof Boolean) {
                        zzf2.zzd(((Boolean) zza2).booleanValue());
                    } else if (zza2 instanceof Character) {
                        zzf2.zzp(zza2.toString());
                    } else if (zza2 instanceof String) {
                        zzf2.zzv((String) zza2);
                    } else {
                        zzf2.zzv(zza2.toString());
                    }
                    zzf.zze((zzpk) zzf2.zzj());
                    i2++;
                } else {
                    throw new zzae(4, 4, (Throwable) null);
                }
            }
            zzck zzc = zzcj.zzc();
            byte[] zzd = ((zzpl) zzf.zzj()).zzd();
            zzc.zzf(i, zzfy.zzh().zzi(zzd, 0, zzd.length));
            return;
        }
        throw new zzae(4, 3, (Throwable) null);
    }
}
