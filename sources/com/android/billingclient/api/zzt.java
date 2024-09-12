package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final /* synthetic */ class zzt implements Callable {
    public final /* synthetic */ BillingClientImpl zza;
    public final /* synthetic */ AlternativeBillingOnlyAvailabilityListener zzb;

    public /* synthetic */ zzt(BillingClientImpl billingClientImpl, AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        this.zza = billingClientImpl;
        this.zzb = alternativeBillingOnlyAvailabilityListener;
    }

    public final Object call() {
        this.zza.zzr(this.zzb);
        return null;
    }
}
