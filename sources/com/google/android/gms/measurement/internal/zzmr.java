package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzmr implements zzfx {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzmp zzb;

    zzmr(zzmp zzmp, String str) {
        this.zzb = zzmp;
        this.zza = str;
    }

    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.zzb.zza(true, i, th, bArr, this.zza);
    }
}
