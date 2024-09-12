package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.regex.Matcher;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzt extends zzp {
    private final Matcher zza;

    public final int zza() {
        return this.zza.end();
    }

    public final int zzb() {
        return this.zza.start();
    }

    zzt(Matcher matcher) {
        this.zza = (Matcher) zzz.zza(matcher);
    }

    public final boolean zza(int i) {
        return this.zza.find(i);
    }

    public final boolean zzc() {
        return this.zza.matches();
    }
}
