package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.android.billingclient.api.BillingResult;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzg;
import org.json.JSONException;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzau extends zzg {
    final BillingConfigResponseListener zza;
    final zzbi zzb;

    /* synthetic */ zzau(BillingConfigResponseListener billingConfigResponseListener, zzbi zzbi, zzat zzat) {
        this.zza = billingConfigResponseListener;
        this.zzb = zzbi;
    }

    public final void zza(Bundle bundle) throws RemoteException {
        if (bundle == null) {
            this.zzb.zza(zzbh.zza(63, 13, zzbk.zzj));
            this.zza.onBillingConfigResponse(zzbk.zzj, (BillingConfig) null);
            return;
        }
        int zzb2 = zzb.zzb(bundle, "BillingClient");
        String zzg = zzb.zzg(bundle, "BillingClient");
        BillingResult.Builder newBuilder = BillingResult.newBuilder();
        newBuilder.setResponseCode(zzb2);
        newBuilder.setDebugMessage(zzg);
        if (zzb2 != 0) {
            zzb.zzk("BillingClient", "getBillingConfig() failed. Response code: " + zzb2);
            BillingResult build = newBuilder.build();
            this.zzb.zza(zzbh.zza(23, 13, build));
            this.zza.onBillingConfigResponse(build, (BillingConfig) null);
        } else if (!bundle.containsKey("BILLING_CONFIG")) {
            zzb.zzk("BillingClient", "getBillingConfig() returned a bundle with neither an error nor a billing config response");
            newBuilder.setResponseCode(6);
            BillingResult build2 = newBuilder.build();
            this.zzb.zza(zzbh.zza(64, 13, build2));
            this.zza.onBillingConfigResponse(build2, (BillingConfig) null);
        } else {
            try {
                this.zza.onBillingConfigResponse(newBuilder.build(), new BillingConfig(bundle.getString("BILLING_CONFIG")));
            } catch (JSONException e) {
                zzb.zzl("BillingClient", "Got a JSON exception trying to decode BillingConfig. \n Exception: ", e);
                this.zzb.zza(zzbh.zza(65, 13, zzbk.zzj));
                this.zza.onBillingConfigResponse(zzbk.zzj, (BillingConfig) null);
            }
        }
    }
}
