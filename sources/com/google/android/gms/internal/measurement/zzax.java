package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzax implements zzaq {
    public final zzaq zza(String str, zzh zzh, List<zzaq> list) {
        throw new IllegalStateException(String.format("Undefined has no function %s", new Object[]{str}));
    }

    public final String zzf() {
        return "undefined";
    }

    public final Iterator<zzaq> zzh() {
        return null;
    }

    public final zzaq zzc() {
        return zzaq.zzc;
    }

    public final Boolean zzd() {
        return false;
    }

    public final Double zze() {
        return Double.valueOf(Double.NaN);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj instanceof zzax;
    }
}
