package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.internal.zzao;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaad  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaad implements zzadm<zzafm> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzacf zzb;
    private final /* synthetic */ zzyl zzc;

    zzaad(zzyl zzyl, String str, zzacf zzacf) {
        this.zza = str;
        this.zzb = zzacf;
        this.zzc = zzyl;
    }

    public final void zza(String str) {
        this.zzb.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzafm zzafm = (zzafm) obj;
        zzagb zzagb = new zzagb();
        zzagb.zzd(zzafm.zzc()).zzc(this.zza);
        zzyl.zza(this.zzc, this.zzb, zzafm, zzagb, (zzadj) this);
    }
}
