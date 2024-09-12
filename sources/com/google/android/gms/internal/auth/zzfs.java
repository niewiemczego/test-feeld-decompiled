package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzfs {
    private static final zzfr zza;
    private static final zzfr zzb = new zzfr();

    static {
        zzfr zzfr;
        try {
            zzfr = (zzfr) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzfr = null;
        }
        zza = zzfr;
    }

    static zzfr zza() {
        return zza;
    }

    static zzfr zzb() {
        return zzb;
    }
}
