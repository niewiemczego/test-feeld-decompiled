package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final /* synthetic */ class zzr implements Runnable {
    public final /* synthetic */ BillingClientImpl zza;
    public final /* synthetic */ SkuDetailsResponseListener zzb;

    public /* synthetic */ zzr(BillingClientImpl billingClientImpl, SkuDetailsResponseListener skuDetailsResponseListener) {
        this.zza = billingClientImpl;
        this.zzb = skuDetailsResponseListener;
    }

    public final void run() {
        this.zza.zzV(this.zzb);
    }
}
