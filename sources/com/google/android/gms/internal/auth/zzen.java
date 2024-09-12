package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzen {
    private static final zzel zza = new zzem();
    private static final zzel zzb;

    static {
        zzel zzel;
        try {
            zzel = (zzel) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzel = null;
        }
        zzb = zzel;
    }

    static zzel zza() {
        zzel zzel = zzb;
        if (zzel != null) {
            return zzel;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzel zzb() {
        return zza;
    }
}
