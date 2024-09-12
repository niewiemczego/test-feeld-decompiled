package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzai implements Callable {
    final /* synthetic */ String zza;
    final /* synthetic */ PurchaseHistoryResponseListener zzb;
    final /* synthetic */ BillingClientImpl zzc;

    zzai(BillingClientImpl billingClientImpl, String str, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        this.zzc = billingClientImpl;
        this.zza = str;
        this.zzb = purchaseHistoryResponseListener;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzaz zzg = BillingClientImpl.zzg(this.zzc, this.zza);
        this.zzb.onPurchaseHistoryResponse(zzg.zza(), zzg.zzb());
        return null;
    }
}
