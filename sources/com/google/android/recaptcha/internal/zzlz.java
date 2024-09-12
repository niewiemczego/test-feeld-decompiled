package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzlz extends IllegalArgumentException {
    zzlz(int i, int i2) {
        super("Unpaired surrogate at index " + i + " of " + i2);
    }
}
