package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final /* synthetic */ class zzp implements Runnable {
    public final /* synthetic */ BillingClientImpl zza;
    public final /* synthetic */ AlternativeBillingOnlyReportingDetailsListener zzb;

    public /* synthetic */ zzp(BillingClientImpl billingClientImpl, AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        this.zza = billingClientImpl;
        this.zzb = alternativeBillingOnlyReportingDetailsListener;
    }

    public final void run() {
        this.zza.zzP(this.zzb);
    }
}
