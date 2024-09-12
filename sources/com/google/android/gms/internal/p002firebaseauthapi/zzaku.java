package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaku  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaku {
    private static final zzaks zza = zzc();
    private static final zzaks zzb = new zzakv();

    static zzaks zza() {
        return zza;
    }

    static zzaks zzb() {
        return zzb;
    }

    private static zzaks zzc() {
        try {
            return (zzaks) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
