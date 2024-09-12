package com.google.android.recaptcha.internal;

import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzeg implements zzee {
    private final zzef zza;
    private final zzed zzb;

    public zzeg(zzef zzef, zzed zzed) {
        this.zza = zzef;
        this.zzb = zzed;
    }

    private final zzpf zzb(String str, List list) throws zzae {
        if (str.length() != 0) {
            try {
                zzec zzec = new zzec(this.zza.zza(CollectionsKt.toLongArray(list)), 255, zzec.zzb);
                StringBuilder sb = new StringBuilder(str.length());
                for (int i = 0; i < str.length(); i++) {
                    sb.append((char) UInt.m1078constructorimpl(UInt.m1078constructorimpl(str.charAt(i)) ^ UInt.m1078constructorimpl((int) zzec.zza())));
                }
                return zzpf.zzg(zzfy.zzh().zzj(sb.toString()));
            } catch (Exception e) {
                throw new zzae(3, 18, e);
            }
        } else {
            throw new zzae(3, 17, (Throwable) null);
        }
    }

    public final zzpf zza(zzpn zzpn) throws zzae {
        zzfh zzb2 = zzfh.zzb();
        zzpf zzb3 = zzb(zzpn.zzi(), zzpn.zzj());
        zzb2.zzf();
        long zza2 = zzb2.zza(TimeUnit.MICROSECONDS);
        zzv zzv = zzv.zza;
        zzv.zza(zzx.zzm.zza(), zza2);
        return zzb3;
    }
}
