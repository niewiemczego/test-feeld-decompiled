package com.google.android.recaptcha.internal;

import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzbp {
    public static final zzbp zza = new zzbp();

    private zzbp() {
    }

    public static final zzno zza(zzz zzz, zzz zzz2) {
        zznn zzf = zzno.zzf();
        zzf.zzp(zzmg.zzb(zzz.zzb()));
        zzf.zzq(zzme.zza(zzz.zza(TimeUnit.NANOSECONDS)));
        zzf.zzd(zzmg.zzb(zzz2.zzb()));
        zzf.zze(zzme.zza(zzz2.zza(TimeUnit.NANOSECONDS)));
        return (zzno) zzf.zzj();
    }
}
