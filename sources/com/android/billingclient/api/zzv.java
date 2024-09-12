package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final /* synthetic */ class zzv implements Runnable {
    public final /* synthetic */ BillingClientImpl zza;
    public final /* synthetic */ AlternativeBillingOnlyAvailabilityListener zzb;

    public /* synthetic */ zzv(BillingClientImpl billingClientImpl, AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        this.zza = billingClientImpl;
        this.zzb = alternativeBillingOnlyAvailabilityListener;
    }

    public final void run() {
        this.zza.zzR(this.zzb);
    }
}
