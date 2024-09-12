package com.google.android.recaptcha.internal;

import android.content.Context;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzek implements zzen {
    private final Context zzb;

    public zzek(Context context) {
        this.zzb = context;
    }

    public final /* synthetic */ Object cs(Object[] objArr) {
        return zzel.zza(this, objArr);
    }

    public final Object zza(Object... objArr) {
        return this.zzb.getSharedPreferences("_GRECAPTCHA", 0);
    }
}
