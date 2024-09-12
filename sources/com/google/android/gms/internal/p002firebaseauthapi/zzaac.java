package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaac  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaac implements zzadm<zzafm> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzacf zzb;
    private final /* synthetic */ zzyl zzc;

    zzaac(zzyl zzyl, String str, zzacf zzacf) {
        this.zza = str;
        this.zzb = zzacf;
        this.zzc = zzyl;
    }

    public final void zza(String str) {
        this.zzb.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzafm zzafm = (zzafm) obj;
        String zzc2 = zzafm.zzc();
        zzagb zzagb = new zzagb();
        zzagb.zzd(zzc2).zzf(this.zza);
        zzyl.zza(this.zzc, this.zzb, zzafm, zzagb, (zzadj) this);
    }
}
