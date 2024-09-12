package com.google.android.gms.internal.p002firebaseauthapi;

import org.apache.commons.io.IOUtils;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzl  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzl extends zzm {
    private final char zza;

    public final String toString() {
        char c = this.zza;
        char[] cArr = {IOUtils.DIR_SEPARATOR_WINDOWS, 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c & 15);
            c = (char) (c >> 4);
        }
        return "CharMatcher.is('" + String.copyValueOf(cArr) + "')";
    }

    zzl(char c) {
        this.zza = c;
    }

    public final boolean zza(char c) {
        return c == this.zza;
    }
}
