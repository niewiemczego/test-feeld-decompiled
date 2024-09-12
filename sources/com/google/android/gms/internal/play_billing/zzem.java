package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzem {
    private static final zzek zza = new zzel();
    private static final zzek zzb;

    static {
        zzek zzek;
        try {
            zzek = (zzek) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzek = null;
        }
        zzb = zzek;
    }

    static zzek zza() {
        zzek zzek = zzb;
        if (zzek != null) {
            return zzek;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzek zzb() {
        return zza;
    }
}
