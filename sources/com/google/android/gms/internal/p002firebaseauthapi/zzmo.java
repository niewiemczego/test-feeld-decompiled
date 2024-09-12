package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakk;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzmo<KeyFormatProtoT extends zzakk, KeyProtoT extends zzakk> {
    private final zzna<KeyFormatProtoT, KeyProtoT> zza;

    /* access modifiers changed from: package-private */
    public final KeyProtoT zza(zzahm zzahm) throws GeneralSecurityException, zzajj {
        KeyFormatProtoT zza2 = this.zza.zza(zzahm);
        this.zza.zzb(zza2);
        return this.zza.zza(zza2);
    }

    zzmo(zzna<KeyFormatProtoT, KeyProtoT> zzna) {
        this.zza = zzna;
    }
}
