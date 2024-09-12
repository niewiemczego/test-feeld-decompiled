package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzes implements zzga {
    private static final zzes zza = new zzes();

    private zzes() {
    }

    public static zzes zza() {
        return zza;
    }

    public final zzfz zzb(Class cls) {
        if (zzex.class.isAssignableFrom(cls)) {
            try {
                return (zzfz) zzex.zzh(cls.asSubclass(zzex.class)).zzu(3, (Object) null, (Object) null);
            } catch (Exception e) {
                throw new RuntimeException("Unable to get message info for ".concat(String.valueOf(cls.getName())), e);
            }
        } else {
            throw new IllegalArgumentException("Unsupported message type: ".concat(String.valueOf(cls.getName())));
        }
    }

    public final boolean zzc(Class cls) {
        return zzex.class.isAssignableFrom(cls);
    }
}
