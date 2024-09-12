package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzyq implements zzadm<zzage> {
    private final /* synthetic */ zzagb zza;
    private final /* synthetic */ zzafb zzb;
    private final /* synthetic */ zzacf zzc;
    private final /* synthetic */ zzafm zzd;
    private final /* synthetic */ zzadj zze;
    private final /* synthetic */ zzyl zzf;

    zzyq(zzyl zzyl, zzagb zzagb, zzafb zzafb, zzacf zzacf, zzafm zzafm, zzadj zzadj) {
        this.zza = zzagb;
        this.zzb = zzafb;
        this.zzc = zzacf;
        this.zzd = zzafm;
        this.zze = zzadj;
        this.zzf = zzyl;
    }

    public final void zza(String str) {
        this.zze.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        zzage zzage = (zzage) obj;
        if (this.zza.zzi("EMAIL")) {
            this.zzb.zzb((String) null);
        } else if (this.zza.zzc() != null) {
            this.zzb.zzb(this.zza.zzc());
        }
        if (this.zza.zzi("DISPLAY_NAME")) {
            this.zzb.zza((String) null);
        } else if (this.zza.zzb() != null) {
            this.zzb.zza(this.zza.zzb());
        }
        if (this.zza.zzi("PHOTO_URL")) {
            this.zzb.zzd((String) null);
        } else if (this.zza.zze() != null) {
            this.zzb.zzd(this.zza.zze());
        }
        if (!TextUtils.isEmpty(this.zza.zzd())) {
            this.zzb.zzc(Base64Utils.encode("redacted".getBytes()));
        }
        List zze2 = zzage.zze();
        if (zze2 == null) {
            zze2 = new ArrayList();
        }
        this.zzb.zza((List<zzafr>) zze2);
        zzacf zzacf = this.zzc;
        zzafm zzafm = this.zzd;
        Preconditions.checkNotNull(zzafm);
        Preconditions.checkNotNull(zzage);
        String zzc2 = zzage.zzc();
        String zzd2 = zzage.zzd();
        if (!TextUtils.isEmpty(zzc2) && !TextUtils.isEmpty(zzd2)) {
            zzafm = new zzafm(zzd2, zzc2, Long.valueOf(zzage.zza()), zzafm.zze());
        }
        zzacf.zza(zzafm, this.zzb);
    }
}
