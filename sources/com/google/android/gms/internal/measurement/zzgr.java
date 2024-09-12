package com.google.android.gms.internal.measurement;

import android.util.Log;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzgr extends zzgn<Long> {
    /* access modifiers changed from: private */
    @Nullable
    /* renamed from: zzb */
    public final Long zza(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String zzb = super.zzb();
        Log.e("PhenotypeFlag", "Invalid long value for " + zzb + ": " + String.valueOf(obj));
        return null;
    }

    zzgr(zzgv zzgv, String str, Long l, boolean z) {
        super(zzgv, str, l);
    }
}
