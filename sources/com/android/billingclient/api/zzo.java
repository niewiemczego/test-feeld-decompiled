package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final /* synthetic */ class zzo implements Callable {
    public final /* synthetic */ BillingClientImpl zza;
    public final /* synthetic */ AlternativeBillingOnlyReportingDetailsListener zzb;

    public /* synthetic */ zzo(BillingClientImpl billingClientImpl, AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        this.zza = billingClientImpl;
        this.zzb = alternativeBillingOnlyReportingDetailsListener;
    }

    public final Object call() {
        this.zza.zzq(this.zzb);
        return null;
    }
}
