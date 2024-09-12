package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzjv implements zzkc {
    private final zzkc[] zza;

    zzjv(zzkc... zzkcArr) {
        this.zza = zzkcArr;
    }

    public final zzkb zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzkc zzkc = this.zza[i];
            if (zzkc.zzc(cls)) {
                return zzkc.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    public final boolean zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
