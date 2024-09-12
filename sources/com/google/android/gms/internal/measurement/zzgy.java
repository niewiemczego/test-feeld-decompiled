package com.google.android.gms.internal.measurement;

import com.google.common.base.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzgy {
    private final boolean zza;

    public zzgy(zzhb zzhb) {
        Preconditions.checkNotNull(zzhb, "BuildInfo must be non-null");
        this.zza = !zzhb.zza();
    }

    public final boolean zza(String str) {
        Preconditions.checkNotNull(str, "flagName must not be null");
        if (!this.zza) {
            return true;
        }
        return zzha.zza.get().containsValue(str);
    }
}
