package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;
import com.google.android.gms.internal.p002firebaseauthapi.zzty;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzbj implements zzce {
    private final OutputStream zza;

    public static zzce zza(OutputStream outputStream) {
        return new zzbj(outputStream);
    }

    private zzbj(OutputStream outputStream) {
        this.zza = outputStream;
    }

    public final void zza(zzty zzty) throws IOException {
        try {
            zzaja.zzb zzm = zzty.zzm();
            zzaja.zzb zzb = zzm;
            ((zzty) ((zzaja) ((zzty.zza) zzm).zza().zzf())).zza(this.zza);
        } finally {
            this.zza.close();
        }
    }

    public final void zza(zzvh zzvh) throws IOException {
        try {
            zzvh.zza(this.zza);
        } finally {
            this.zza.close();
        }
    }
}
