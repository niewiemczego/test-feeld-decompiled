package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.Serializable;
import java.util.regex.Pattern;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzu extends zzs implements Serializable {
    private final Pattern zza;

    public final zzp zza(CharSequence charSequence) {
        return new zzt(this.zza.matcher(charSequence));
    }

    public final String toString() {
        return this.zza.toString();
    }

    zzu(Pattern pattern) {
        this.zza = (Pattern) zzz.zza(pattern);
    }
}
