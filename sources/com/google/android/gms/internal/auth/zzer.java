package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzer implements zzfu {
    private static final zzer zza = new zzer();

    private zzer() {
    }

    public static zzer zza() {
        return zza;
    }

    public final zzft zzb(Class cls) {
        if (zzeu.class.isAssignableFrom(cls)) {
            try {
                return (zzft) zzeu.zza(cls.asSubclass(zzeu.class)).zzi(3, (Object) null, (Object) null);
            } catch (Exception e) {
                throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
    }

    public final boolean zzc(Class cls) {
        return zzeu.class.isAssignableFrom(cls);
    }
}
