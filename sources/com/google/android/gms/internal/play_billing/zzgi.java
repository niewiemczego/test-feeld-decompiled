package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzgi {
    private static final zzgh zza;
    private static final zzgh zzb = new zzgh();

    static {
        zzgh zzgh;
        try {
            zzgh = (zzgh) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzgh = null;
        }
        zza = zzgh;
    }

    static zzgh zza() {
        return zza;
    }

    static zzgh zzb() {
        return zzb;
    }
}
