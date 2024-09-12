package com.google.android.recaptcha.internal;

import java.util.Map;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzku extends zzle {
    zzku(int i) {
        super(i, (zzld) null);
    }

    public final void zza() {
        if (!zzj()) {
            for (int i = 0; i < zzb(); i++) {
                ((zzii) zzg(i).getKey()).zzg();
            }
            for (Map.Entry key : zzc()) {
                ((zzii) key.getKey()).zzg();
            }
        }
        super.zza();
    }
}
