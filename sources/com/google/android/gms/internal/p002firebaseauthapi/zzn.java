package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzn extends zzo {
    static final zzj zza = new zzn();

    public final int zza(CharSequence charSequence, int i) {
        zzz.zza(i, charSequence.length(), FirebaseAnalytics.Param.INDEX);
        return -1;
    }

    public final boolean zza(char c) {
        return false;
    }

    private zzn() {
        super("CharMatcher.none()");
    }
}
