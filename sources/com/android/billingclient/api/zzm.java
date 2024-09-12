package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final /* synthetic */ class zzm implements Runnable {
    public final /* synthetic */ BillingClientImpl zza;
    public final /* synthetic */ BillingConfigResponseListener zzb;

    public /* synthetic */ zzm(BillingClientImpl billingClientImpl, BillingConfigResponseListener billingConfigResponseListener) {
        this.zza = billingClientImpl;
        this.zzb = billingConfigResponseListener;
    }

    public final void run() {
        this.zza.zzQ(this.zzb);
    }
}
