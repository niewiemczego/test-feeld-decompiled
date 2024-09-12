package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final /* synthetic */ class zzy implements Runnable {
    public final /* synthetic */ BillingClientImpl zza;
    public final /* synthetic */ PurchaseHistoryResponseListener zzb;

    public /* synthetic */ zzy(BillingClientImpl billingClientImpl, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        this.zza = billingClientImpl;
        this.zzb = purchaseHistoryResponseListener;
    }

    public final void run() {
        this.zza.zzT(this.zzb);
    }
}
