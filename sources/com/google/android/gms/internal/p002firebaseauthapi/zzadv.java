package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.tasks.OnFailureListener;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadv  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzadv implements OnFailureListener {
    zzadv(zzadt zzadt) {
    }

    public final void onFailure(Exception exc) {
        zzadt.zza.e("SmsRetrieverClient failed to start: " + exc.getMessage(), new Object[0]);
    }
}
