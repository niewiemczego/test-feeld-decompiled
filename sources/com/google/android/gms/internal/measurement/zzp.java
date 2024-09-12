package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzp extends zzal {
    private final /* synthetic */ zzo zzk;

    public final zzaq zza(zzh zzh, List<zzaq> list) {
        zzg.zza("getValue", 2, list);
        zzaq zza = zzh.zza(list.get(0));
        zzaq zza2 = zzh.zza(list.get(1));
        String zza3 = this.zzk.zza(zza.zzf());
        return zza3 != null ? new zzas(zza3) : zza2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzp(zzm zzm, String str, zzo zzo) {
        super(str);
        this.zzk = zzo;
    }
}
