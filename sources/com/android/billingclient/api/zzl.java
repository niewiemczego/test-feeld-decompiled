package com.android.billingclient.api;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final /* synthetic */ class zzl implements Callable {
    public final /* synthetic */ BillingClientImpl zza;
    public final /* synthetic */ Bundle zzb;
    public final /* synthetic */ BillingConfigResponseListener zzc;

    public /* synthetic */ zzl(BillingClientImpl billingClientImpl, Bundle bundle, BillingConfigResponseListener billingConfigResponseListener) {
        this.zza = billingClientImpl;
        this.zzb = bundle;
        this.zzc = billingConfigResponseListener;
    }

    public final Object call() {
        this.zza.zzm(this.zzb, this.zzc);
        return null;
    }
}
