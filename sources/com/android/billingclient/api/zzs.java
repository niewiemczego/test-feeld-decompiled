package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final /* synthetic */ class zzs implements Runnable {
    public final /* synthetic */ BillingClientImpl zza;
    public final /* synthetic */ PurchasesResponseListener zzb;

    public /* synthetic */ zzs(BillingClientImpl billingClientImpl, PurchasesResponseListener purchasesResponseListener) {
        this.zza = billingClientImpl;
        this.zzb = purchasesResponseListener;
    }

    public final void run() {
        this.zza.zzU(this.zzb);
    }
}
