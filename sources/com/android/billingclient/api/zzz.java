package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final /* synthetic */ class zzz implements Runnable {
    public final /* synthetic */ BillingClientImpl zza;
    public final /* synthetic */ ProductDetailsResponseListener zzb;

    public /* synthetic */ zzz(BillingClientImpl billingClientImpl, ProductDetailsResponseListener productDetailsResponseListener) {
        this.zza = billingClientImpl;
        this.zzb = productDetailsResponseListener;
    }

    public final void run() {
        this.zza.zzS(this.zzb);
    }
}
