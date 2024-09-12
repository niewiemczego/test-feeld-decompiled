package com.google.android.gms.internal.measurement;

import android.util.Log;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzgt extends zzgn<Double> {
    /* access modifiers changed from: private */
    @Nullable
    /* renamed from: zzb */
    public final Double zza(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String zzb = super.zzb();
        Log.e("PhenotypeFlag", "Invalid double value for " + zzb + ": " + String.valueOf(obj));
        return null;
    }

    zzgt(zzgv zzgv, String str, Double d, boolean z) {
        super(zzgv, str, d);
    }
}
