package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final /* synthetic */ class zzac implements Callable {
    public final /* synthetic */ BillingClientImpl zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzac(BillingClientImpl billingClientImpl, String str, String str2) {
        this.zza = billingClientImpl;
        this.zzb = str;
        this.zzc = str2;
    }

    public final Object call() {
        return this.zza.zzd(this.zzb, this.zzc);
    }
}
