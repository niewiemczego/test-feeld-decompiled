package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzgc {
    private static final zzgb zza;
    private static final zzgb zzb = new zzgb();

    static {
        zzgb zzgb;
        try {
            zzgb = (zzgb) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzgb = null;
        }
        zza = zzgb;
    }

    static zzgb zza() {
        return zza;
    }

    static zzgb zzb() {
        return zzb;
    }
}
