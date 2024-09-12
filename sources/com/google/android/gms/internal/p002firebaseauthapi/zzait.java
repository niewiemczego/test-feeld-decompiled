package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzait  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzait {
    private static final zzair<?> zza = new zzaiq();
    private static final zzair<?> zzb = zzc();

    static zzair<?> zza() {
        zzair<?> zzair = zzb;
        if (zzair != null) {
            return zzair;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static zzair<?> zzb() {
        return zza;
    }

    private static zzair<?> zzc() {
        try {
            return (zzair) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
