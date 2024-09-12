package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzbq extends zzay {
    public final zzaq zza(String str, zzh zzh, List<zzaq> list) {
        if (str == null || str.isEmpty() || !zzh.zzb(str)) {
            throw new IllegalArgumentException(String.format("Command not found: %s", new Object[]{str}));
        }
        zzaq zza = zzh.zza(str);
        if (zza instanceof zzal) {
            return ((zzal) zza).zza(zzh, list);
        }
        throw new IllegalArgumentException(String.format("Function %s is not defined", new Object[]{str}));
    }
}
