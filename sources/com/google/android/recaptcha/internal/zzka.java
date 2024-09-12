package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzka {
    private static final zzjz zza;
    private static final zzjz zzb = new zzjz();

    static {
        zzjz zzjz;
        try {
            zzjz = (zzjz) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzjz = null;
        }
        zza = zzjz;
    }

    static zzjz zza() {
        return zza;
    }

    static zzjz zzb() {
        return zzb;
    }
}
