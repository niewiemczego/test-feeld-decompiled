package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzlk extends RuntimeException {
    public zzlk(zzke zzke) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzje zza() {
        return new zzje(getMessage());
    }
}
