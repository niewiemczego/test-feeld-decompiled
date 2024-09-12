package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public abstract class zzfm implements Iterable {
    private final zzfe zza = zzfe.zza();

    protected zzfm() {
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        boolean z = true;
        for (Object append : this) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(append);
            z = false;
        }
        sb.append(']');
        return sb.toString();
    }
}
