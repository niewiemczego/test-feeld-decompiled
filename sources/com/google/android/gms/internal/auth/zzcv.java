package com.google.android.gms.internal.auth;

import android.util.Log;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzcv extends zzdc {
    zzcv(zzcz zzcz, String str, Long l, boolean z) {
        super(zzcz, str, l, true, (zzdb) null);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            String zzc = super.zzc();
            Log.e("PhenotypeFlag", "Invalid long value for " + zzc + ": " + ((String) obj));
            return null;
        }
    }
}
