package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzir extends zzic {
    final zzke zza;
    final zziq zzb;

    zzir(zzke zzke, Object obj, zzke zzke2, zziq zziq, Class cls) {
        if (zzke == null) {
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        } else if (zziq.zzb != zzmb.MESSAGE) {
            this.zza = zzke;
            this.zzb = zziq;
        } else {
            throw new IllegalArgumentException("Null messageDefaultInstance");
        }
    }
}
