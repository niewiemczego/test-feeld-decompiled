package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzfy {
    private static final zzfx zza;
    private static final zzfx zzb = new zzfx();

    static {
        zzfx zzfx;
        try {
            zzfx = (zzfx) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            zzfx = null;
        }
        zza = zzfx;
    }

    static zzfx zza() {
        return zza;
    }

    static zzfx zzb() {
        return zzb;
    }
}
