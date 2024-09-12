package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzxl extends ThreadLocal<Mac> {
    private final /* synthetic */ zzxm zza;

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final Mac initialValue() {
        try {
            Mac zza2 = zzwr.zzb.zza(this.zza.zzc);
            zza2.init(this.zza.zzd);
            return zza2;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    zzxl(zzxm zzxm) {
        this.zza = zzxm;
    }
}
