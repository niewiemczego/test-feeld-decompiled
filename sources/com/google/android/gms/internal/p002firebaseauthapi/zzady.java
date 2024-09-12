package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzady  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzady extends zzacf {
    private final String zza;
    private final /* synthetic */ zzadt zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzady(zzadt zzadt, zzacf zzacf, String str) {
        super(zzacf);
        this.zzb = zzadt;
        this.zza = str;
    }

    public final void zzb(String str) {
        zzadt.zza.d("onCodeSent", new Object[0]);
        zzaea zzaea = (zzaea) this.zzb.zzd.get(this.zza);
        if (zzaea != null) {
            for (zzacf zzb2 : zzaea.zzb) {
                zzb2.zzb(str);
            }
            zzaea.zzg = true;
            zzaea.zzd = str;
            if (zzaea.zza <= 0) {
                this.zzb.zzb(this.zza);
            } else if (!zzaea.zzc) {
                this.zzb.zze(this.zza);
            } else if (!zzah.zzc(zzaea.zze)) {
                zzadt.zza(this.zzb, this.zza);
            }
        }
    }

    public final void zza(Status status) {
        Logger zza2 = zzadt.zza;
        String statusCodeString = CommonStatusCodes.getStatusCodeString(status.getStatusCode());
        zza2.e("SMS verification code request failed: " + statusCodeString + " " + status.getStatusMessage(), new Object[0]);
        zzaea zzaea = (zzaea) this.zzb.zzd.get(this.zza);
        if (zzaea != null) {
            for (zzacf zza3 : zzaea.zzb) {
                zza3.zza(status);
            }
            this.zzb.zzc(this.zza);
        }
    }
}
