package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzj  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzzj implements zzadm<zzafc> {
    private final /* synthetic */ zzadm zza;
    private final /* synthetic */ zzafm zzb;
    private final /* synthetic */ zzzg zzc;

    zzzj(zzzg zzzg, zzadm zzadm, zzafm zzafm) {
        this.zza = zzadm;
        this.zzb = zzafm;
        this.zzc = zzzg;
    }

    public final void zza(String str) {
        this.zzc.zzb.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        List<zzafb> zza2 = ((zzafc) obj).zza();
        if (zza2 == null || zza2.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        zzagb zzagb = new zzagb();
        zzagb.zzd(this.zzb.zzc()).zza(this.zzc.zza);
        zzyl.zza(this.zzc.zzc, this.zzc.zzb, this.zzb, zza2.get(0), zzagb, (zzadj) this.zza);
    }
}
