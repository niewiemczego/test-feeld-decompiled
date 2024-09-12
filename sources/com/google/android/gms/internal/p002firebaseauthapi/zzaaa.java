package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzao;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaa  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaaa implements zzadm<zzafm> {
    private final /* synthetic */ UserProfileChangeRequest zza;
    private final /* synthetic */ zzacf zzb;
    private final /* synthetic */ zzyl zzc;

    zzaaa(zzyl zzyl, UserProfileChangeRequest userProfileChangeRequest, zzacf zzacf) {
        this.zza = userProfileChangeRequest;
        this.zzb = zzacf;
        this.zzc = zzyl;
    }

    public final void zza(String str) {
        this.zzb.zza(zzao.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzafm zzafm = (zzafm) obj;
        zzagb zzagb = new zzagb();
        zzagb.zzd(zzafm.zzc());
        if (this.zza.zzb() || this.zza.getDisplayName() != null) {
            zzagb.zzb(this.zza.getDisplayName());
        }
        if (this.zza.zzc() || this.zza.getPhotoUri() != null) {
            zzagb.zzg(this.zza.zza());
        }
        zzyl.zza(this.zzc, this.zzb, zzafm, zzagb, (zzadj) this);
    }
}
