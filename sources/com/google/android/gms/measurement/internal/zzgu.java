package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.internal.measurement.zzv;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzgu implements zzv {
    private final /* synthetic */ zzgp zza;

    zzgu(zzgp zzgp) {
        this.zza = zzgp;
    }

    public final void zza(zzs zzs, String str, List<String> list, boolean z, boolean z2) {
        zzft zzft;
        int i = zzgw.zza[zzs.ordinal()];
        if (i == 1) {
            zzft = this.zza.zzj().zzc();
        } else if (i != 2) {
            if (i != 3) {
                zzft = i != 4 ? this.zza.zzj().zzn() : this.zza.zzj().zzp();
            } else if (z) {
                zzft = this.zza.zzj().zzw();
            } else {
                zzft = !z2 ? this.zza.zzj().zzv() : this.zza.zzj().zzu();
            }
        } else if (z) {
            zzft = this.zza.zzj().zzm();
        } else if (!z2) {
            zzft = this.zza.zzj().zzh();
        } else {
            zzft = this.zza.zzj().zzg();
        }
        int size = list.size();
        if (size == 1) {
            zzft.zza(str, list.get(0));
        } else if (size == 2) {
            zzft.zza(str, list.get(0), list.get(1));
        } else if (size != 3) {
            zzft.zza(str);
        } else {
            zzft.zza(str, list.get(0), list.get(1), list.get(2));
        }
    }
}
