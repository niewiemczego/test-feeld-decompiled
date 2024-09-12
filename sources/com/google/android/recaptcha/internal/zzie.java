package com.google.android.recaptcha.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzie {
    static final zzie zza = new zzie(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private final Map zzd;

    zzie() {
        this.zzd = new HashMap();
    }

    public final zzir zza(zzke zzke, int i) {
        return (zzir) this.zzd.get(new zzid(zzke, i));
    }

    zzie(boolean z) {
        this.zzd = Collections.emptyMap();
    }
}
