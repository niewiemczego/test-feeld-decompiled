package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzbr {
    public static final zzbr zza = new zzbr();

    private zzbr() {
    }

    public static final zzp zza(int i) {
        if (i == 403) {
            return new zzp(zzn.zzl, zzl.zzV, (String) null);
        }
        if (i == 404) {
            return new zzp(zzn.zze, zzl.zzs, (String) null);
        }
        if (i != 503) {
            return new zzp(zzn.zzc, zzl.zzW, (String) null);
        }
        return new zzp(zzn.zzl, zzl.zzV, (String) null);
    }
}
