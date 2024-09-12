package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzyr implements zzadm<zzafc> {
    private final /* synthetic */ zzadj zza;
    private final /* synthetic */ zzacf zzb;
    private final /* synthetic */ zzafm zzc;
    private final /* synthetic */ zzagb zzd;
    private final /* synthetic */ zzyl zze;

    zzyr(zzyl zzyl, zzadj zzadj, zzacf zzacf, zzafm zzafm, zzagb zzagb) {
        this.zza = zzadj;
        this.zzb = zzacf;
        this.zzc = zzafm;
        this.zzd = zzagb;
        this.zze = zzyl;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        List<zzafb> zza2 = ((zzafc) obj).zza();
        if (zza2 == null || zza2.isEmpty()) {
            this.zza.zza("No users");
        } else {
            zzyl.zza(this.zze, this.zzb, this.zzc, zza2.get(0), this.zzd, this.zza);
        }
    }
}
