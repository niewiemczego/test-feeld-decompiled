package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzjz {
    zzjz() {
    }

    public static final boolean zza(Object obj) {
        return !((zzjy) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzjy zzjy = (zzjy) obj;
        zzjy zzjy2 = (zzjy) obj2;
        if (!zzjy2.isEmpty()) {
            if (!zzjy.zze()) {
                zzjy = zzjy.zzb();
            }
            zzjy.zzd(zzjy2);
        }
        return zzjy;
    }
}
