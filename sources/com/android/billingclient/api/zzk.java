package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final /* synthetic */ class zzk implements Runnable {
    public final /* synthetic */ BillingClientImpl zza;
    public final /* synthetic */ AcknowledgePurchaseResponseListener zzb;

    public /* synthetic */ zzk(BillingClientImpl billingClientImpl, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        this.zza = billingClientImpl;
        this.zzb = acknowledgePurchaseResponseListener;
    }

    public final void run() {
        this.zza.zzM(this.zzb);
    }
}
