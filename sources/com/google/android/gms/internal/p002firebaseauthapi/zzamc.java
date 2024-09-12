package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzamc extends RuntimeException {
    private final List<String> zza = null;

    public final zzajj zza() {
        return new zzajj(getMessage());
    }

    public zzamc(zzakk zzakk) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }
}
