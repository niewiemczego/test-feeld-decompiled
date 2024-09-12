package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpe  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzpe extends RuntimeException {
    public static <T> T zza(zzph<T> zzph) {
        try {
            return zzph.zza();
        } catch (Exception e) {
            throw new zzpe((Throwable) e);
        }
    }

    public zzpe(String str) {
        super(str);
    }

    private zzpe(Throwable th) {
        super(th);
    }

    public zzpe(String str, Throwable th) {
        super(str, th);
    }
}
