package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final /* synthetic */ class zzx implements Runnable {
    public final /* synthetic */ BillingClientImpl zza;
    public final /* synthetic */ ConsumeResponseListener zzb;
    public final /* synthetic */ ConsumeParams zzc;

    public /* synthetic */ zzx(BillingClientImpl billingClientImpl, ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) {
        this.zza = billingClientImpl;
        this.zzb = consumeResponseListener;
        this.zzc = consumeParams;
    }

    public final void run() {
        this.zza.zzO(this.zzb, this.zzc);
    }
}
