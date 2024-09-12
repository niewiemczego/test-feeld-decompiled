package com.google.android.gms.internal.auth;

import android.util.Log;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzcx extends zzdc {
    zzcx(zzcz zzcz, String str, Double d, boolean z) {
        super(zzcz, str, d, true, (zzdb) null);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            String zzc = super.zzc();
            Log.e("PhenotypeFlag", "Invalid double value for " + zzc + ": " + ((String) obj));
            return null;
        }
    }
}
