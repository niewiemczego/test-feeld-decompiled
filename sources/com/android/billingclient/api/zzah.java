package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzaf;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzah implements Callable {
    final /* synthetic */ String zza;
    final /* synthetic */ PurchasesResponseListener zzb;
    final /* synthetic */ BillingClientImpl zzc;

    zzah(BillingClientImpl billingClientImpl, String str, PurchasesResponseListener purchasesResponseListener) {
        this.zzc = billingClientImpl;
        this.zza = str;
        this.zzb = purchasesResponseListener;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzce zzX = BillingClientImpl.zzX(this.zzc, this.zza, 9);
        if (zzX.zzb() != null) {
            this.zzb.onQueryPurchasesResponse(zzX.zza(), zzX.zzb());
            return null;
        }
        this.zzb.onQueryPurchasesResponse(zzX.zza(), zzaf.zzk());
        return null;
    }
}
