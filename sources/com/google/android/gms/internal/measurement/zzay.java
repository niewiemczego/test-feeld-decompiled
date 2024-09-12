package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public abstract class zzay {
    final List<zzbv> zza = new ArrayList();

    /* access modifiers changed from: package-private */
    public final zzaq zza(String str) {
        if (this.zza.contains(zzg.zza(str))) {
            throw new UnsupportedOperationException("Command not implemented: " + str);
        }
        throw new IllegalArgumentException("Command not supported");
    }

    public abstract zzaq zza(String str, zzh zzh, List<zzaq> list);

    protected zzay() {
    }
}
