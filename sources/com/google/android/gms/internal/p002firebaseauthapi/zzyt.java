package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import com.google.firebase.auth.zzd;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzyt implements zzadm<zzafc> {
    private final /* synthetic */ zzadj zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ Boolean zzd;
    private final /* synthetic */ zzd zze;
    private final /* synthetic */ zzacf zzf;
    private final /* synthetic */ zzafm zzg;

    zzyt(zzyl zzyl, zzadj zzadj, String str, String str2, Boolean bool, zzd zzd2, zzacf zzacf, zzafm zzafm) {
        this.zza = zzadj;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bool;
        this.zze = zzd2;
        this.zzf = zzacf;
        this.zzg = zzafm;
    }

    public final void zza(String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        List<zzafb> zza2 = ((zzafc) obj).zza();
        if (zza2 == null || zza2.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        boolean z = false;
        zzafb zzafb = zza2.get(0);
        zzafu zzf2 = zzafb.zzf();
        List<zzafr> zza3 = zzf2 != null ? zzf2.zza() : null;
        if (zza3 != null && !zza3.isEmpty()) {
            if (!TextUtils.isEmpty(this.zzb)) {
                int i = 0;
                while (true) {
                    if (i >= zza3.size()) {
                        break;
                    } else if (zza3.get(i).zzf().equals(this.zzb)) {
                        zza3.get(i).zza(this.zzc);
                        break;
                    } else {
                        i++;
                    }
                }
            } else {
                zza3.get(0).zza(this.zzc);
            }
        }
        Boolean bool = this.zzd;
        if (bool != null) {
            zzafb.zza(bool.booleanValue());
        } else {
            if (zzafb.zzb() - zzafb.zza() < 1000) {
                z = true;
            }
            zzafb.zza(z);
        }
        zzafb.zza(this.zze);
        this.zzf.zza(this.zzg, zzafb);
    }
}
