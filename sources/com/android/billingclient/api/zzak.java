package com.android.billingclient.api;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.android.billingclient.api.BillingResult;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzhy;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzih;
import com.google.android.gms.internal.play_billing.zzii;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzak extends ResultReceiver {
    final /* synthetic */ AlternativeBillingOnlyInformationDialogListener zza;
    final /* synthetic */ BillingClientImpl zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzak(BillingClientImpl billingClientImpl, Handler handler, AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        super(handler);
        this.zzb = billingClientImpl;
        this.zza = alternativeBillingOnlyInformationDialogListener;
    }

    public final void onReceiveResult(int i, Bundle bundle) {
        zzhy zzhy;
        BillingResult.Builder newBuilder = BillingResult.newBuilder();
        newBuilder.setResponseCode(i);
        if (i != 0) {
            if (bundle == null) {
                this.zzb.zzf.zza(zzbh.zza(73, 16, zzbk.zzj));
                this.zza.onAlternativeBillingOnlyInformationDialogResponse(zzbk.zzj);
                return;
            }
            newBuilder.setDebugMessage(zzb.zzg(bundle, "BillingClient"));
            int i2 = bundle.getInt("INTERNAL_LOG_ERROR_REASON");
            zzbi zzh = this.zzb.zzf;
            int zza2 = i2 != 0 ? zzih.zza(i2) : 23;
            BillingResult build = newBuilder.build();
            String string = bundle.getString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS");
            try {
                zzie zzv = zzii.zzv();
                zzv.zzk(build.getResponseCode());
                zzv.zzj(build.getDebugMessage());
                zzv.zzl(zza2);
                if (string != null) {
                    zzv.zzi(string);
                }
                zzhx zzv2 = zzhy.zzv();
                zzv2.zzi(zzv);
                zzv2.zzk(16);
                zzhy = (zzhy) zzv2.zzc();
            } catch (Exception e) {
                zzb.zzl("BillingLogger", "Unable to create logging payload", e);
                zzhy = null;
            }
            zzh.zza(zzhy);
        }
        this.zza.onAlternativeBillingOnlyInformationDialogResponse(newBuilder.build());
    }
}
