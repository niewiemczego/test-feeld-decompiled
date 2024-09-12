package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzall  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzall extends zzalt {
    private final /* synthetic */ zzalh zza;

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzalj(this.zza);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzall(zzalh zzalh) {
        super(zzalh);
        this.zza = zzalh;
    }
}
