package com.android.billingclient.api;

import android.content.Context;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzhy;
import com.google.android.gms.internal.play_billing.zzic;
import com.google.android.gms.internal.play_billing.zzio;
import com.google.android.gms.internal.play_billing.zziu;
import com.google.android.gms.internal.play_billing.zziv;
import com.google.android.gms.internal.play_billing.zziz;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzbn implements zzbi {
    private final zzio zza;
    private final zzbp zzb;

    zzbn(Context context, zzio zzio) {
        this.zzb = new zzbp(context);
        this.zza = zzio;
    }

    public final void zza(zzhy zzhy) {
        if (zzhy != null) {
            try {
                zziu zzv = zziv.zzv();
                zzio zzio = this.zza;
                if (zzio != null) {
                    zzv.zzk(zzio);
                }
                zzv.zzi(zzhy);
                this.zzb.zza((zziv) zzv.zzc());
            } catch (Throwable unused) {
                zzb.zzk("BillingLogger", "Unable to log.");
            }
        }
    }

    public final void zzb(zzic zzic) {
        if (zzic != null) {
            try {
                zziu zzv = zziv.zzv();
                zzio zzio = this.zza;
                if (zzio != null) {
                    zzv.zzk(zzio);
                }
                zzv.zzj(zzic);
                this.zzb.zza((zziv) zzv.zzc());
            } catch (Throwable unused) {
                zzb.zzk("BillingLogger", "Unable to log.");
            }
        }
    }

    public final void zzc(zziz zziz) {
        if (zziz != null) {
            try {
                zziu zzv = zziv.zzv();
                zzio zzio = this.zza;
                if (zzio != null) {
                    zzv.zzk(zzio);
                }
                zzv.zzl(zziz);
                this.zzb.zza((zziv) zzv.zzc());
            } catch (Throwable unused) {
                zzb.zzk("BillingLogger", "Unable to log.");
            }
        }
    }
}
