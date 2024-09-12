package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzim implements zzkc {
    private static final zzim zza = new zzim();

    private zzim() {
    }

    public static zzim zza() {
        return zza;
    }

    public final zzkb zzb(Class cls) {
        if (zzit.class.isAssignableFrom(cls)) {
            try {
                return (zzkb) zzit.zzr(cls.asSubclass(zzit.class)).zzh(3, (Object) null, (Object) null);
            } catch (Exception e) {
                throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
    }

    public final boolean zzc(Class cls) {
        return zzit.class.isAssignableFrom(cls);
    }
}
