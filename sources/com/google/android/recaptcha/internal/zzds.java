package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzds implements zzdd {
    public static final zzds zza = new zzds();

    private zzds() {
    }

    public final void zza(int i, zzcj zzcj, zzpq... zzpqArr) throws zzae {
        if (zzpqArr.length == 1) {
            Object zza2 = zzcj.zzc().zza(zzpqArr[0]);
            if (true != (zza2 instanceof String)) {
                zza2 = null;
            }
            String str = (String) zza2;
            if (str != null) {
                zzcj.zzf(str);
                return;
            }
            throw new zzae(4, 5, (Throwable) null);
        }
        throw new zzae(4, 3, (Throwable) null);
    }
}
