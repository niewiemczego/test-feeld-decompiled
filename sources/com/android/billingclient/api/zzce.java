package com.android.billingclient.api;

import java.util.List;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zzce {
    private final List zza;
    private final BillingResult zzb;

    public zzce(BillingResult billingResult, List list) {
        this.zza = list;
        this.zzb = billingResult;
    }

    public final BillingResult zza() {
        return this.zzb;
    }

    public final List zzb() {
        return this.zza;
    }
}
