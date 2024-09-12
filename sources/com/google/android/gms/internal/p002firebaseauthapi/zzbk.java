package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbk  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzbk implements zzcb {
    private final InputStream zza;

    public static zzcb zza(byte[] bArr) {
        return new zzbk(new ByteArrayInputStream(bArr));
    }

    public final zzty zza() throws IOException {
        try {
            return zzty.zza(this.zza, zzaip.zza());
        } finally {
            this.zza.close();
        }
    }

    public final zzvh zzb() throws IOException {
        try {
            return zzvh.zza(this.zza, zzaip.zza());
        } finally {
            this.zza.close();
        }
    }

    private zzbk(InputStream inputStream) {
        this.zza = inputStream;
    }
}
