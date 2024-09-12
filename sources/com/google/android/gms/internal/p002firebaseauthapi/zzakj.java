package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzakj {
    private static final zzakh zza = zzc();
    private static final zzakh zzb = new zzakg();

    static zzakh zza() {
        return zza;
    }

    static zzakh zzb() {
        return zzb;
    }

    private static zzakh zzc() {
        try {
            return (zzakh) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
