package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzzn implements zzadm<zzagi> {
    private final /* synthetic */ zzagf zza;
    private final /* synthetic */ zzacf zzb;

    zzzn(zzyl zzyl, zzagf zzagf, zzacf zzacf) {
        this.zza = zzagf;
        this.zzb = zzacf;
    }

    public final void zza(String str) {
        this.zzb.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzagi zzagi = (zzagi) obj;
        zzagf zzagf = this.zza;
        if (zzagf instanceof zzagj) {
            this.zzb.zzb(zzagi.zza());
        } else if (zzagf instanceof zzagl) {
            this.zzb.zza(zzagi);
        } else {
            throw new IllegalArgumentException("startMfaEnrollmentRequest must be an instance of either StartPhoneMfaEnrollmentRequest or StartTotpMfaEnrollmentRequest but was " + this.zza.getClass().getName() + ".");
        }
    }
}
