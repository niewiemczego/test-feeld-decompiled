package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzc;
import org.json.JSONException;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzaq extends zzc {
    final AlternativeBillingOnlyReportingDetailsListener zza;
    final zzbi zzb;

    /* synthetic */ zzaq(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener, zzbi zzbi, zzap zzap) {
        this.zza = alternativeBillingOnlyReportingDetailsListener;
        this.zzb = zzbi;
    }

    public final void zza(Bundle bundle) throws RemoteException {
        if (bundle == null) {
            this.zzb.zza(zzbh.zza(71, 15, zzbk.zzj));
            this.zza.onAlternativeBillingOnlyTokenResponse(zzbk.zzj, (AlternativeBillingOnlyReportingDetails) null);
            return;
        }
        int zzb2 = zzb.zzb(bundle, "BillingClient");
        BillingResult zza2 = zzbk.zza(zzb2, zzb.zzg(bundle, "BillingClient"));
        if (zzb2 != 0) {
            zzb.zzk("BillingClient", "createAlternativeBillingOnlyReportingDetailsAsync() failed. Response code: " + zzb2);
            this.zzb.zza(zzbh.zza(23, 15, zza2));
            this.zza.onAlternativeBillingOnlyTokenResponse(zza2, (AlternativeBillingOnlyReportingDetails) null);
            return;
        }
        try {
            this.zza.onAlternativeBillingOnlyTokenResponse(zza2, new AlternativeBillingOnlyReportingDetails(bundle.getString("CREATE_ALTERNATIVE_BILLING_ONLY_REPORTING_DETAILS")));
        } catch (JSONException e) {
            zzb.zzl("BillingClient", "Error when parsing invalid alternative billing only reporting details. \n Exception: ", e);
            this.zzb.zza(zzbh.zza(72, 15, zzbk.zzj));
            this.zza.onAlternativeBillingOnlyTokenResponse(zzbk.zzj, (AlternativeBillingOnlyReportingDetails) null);
        }
    }
}
