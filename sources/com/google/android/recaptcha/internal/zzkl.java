package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzkl {
    private static final zzkk zza;
    private static final zzkk zzb = new zzkk();

    static {
        zzkk zzkk;
        try {
            zzkk = (zzkk) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzkk = null;
        }
        zza = zzkk;
    }

    static zzkk zza() {
        return zza;
    }

    static zzkk zzb() {
        return zzb;
    }
}
