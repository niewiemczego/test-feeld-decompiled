package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public abstract class zzj {
    public int zza(CharSequence charSequence, int i) {
        int length = charSequence.length();
        zzz.zza(i, length, FirebaseAnalytics.Param.INDEX);
        while (i < length) {
            if (zza(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public abstract boolean zza(char c);

    protected zzj() {
    }
}
