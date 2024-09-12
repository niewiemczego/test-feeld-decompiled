package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzdy implements zzdd {
    public static final zzdy zza = new zzdy();

    private zzdy() {
    }

    public final void zza(int i, zzcj zzcj, zzpq... zzpqArr) throws zzae {
        int length = zzpqArr.length;
        if (length == 2) {
            Object zza2 = zzcj.zzc().zza(zzpqArr[0]);
            if (true != (zza2 instanceof String)) {
                zza2 = null;
            }
            String str = (String) zza2;
            if (str != null) {
                Object zza3 = zzcj.zzc().zza(zzpqArr[1]);
                if (true != (zza3 instanceof zzz)) {
                    zza3 = null;
                }
                zzz zzz = (zzz) zza3;
                if (zzz != null) {
                    byte[] zzd = zzbp.zza(zzcj.zzb(), zzz).zzd();
                    zzcj.zzi().zzb(str, zzfy.zzh().zzi(zzd, 0, zzd.length));
                    return;
                }
                throw new zzae(4, 5, (Throwable) null);
            }
            throw new zzae(4, 5, (Throwable) null);
        } else if (length == 0) {
            zzcj.zzc().zzf(i, new zzz());
        } else {
            throw new zzae(4, 3, (Throwable) null);
        }
    }
}
