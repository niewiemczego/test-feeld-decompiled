package com.android.billingclient.api;

import java.util.List;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzaz {
    private final List zza;
    private final BillingResult zzb;

    zzaz(BillingResult billingResult, List list) {
        this.zza = list;
        this.zzb = billingResult;
    }

    /* access modifiers changed from: package-private */
    public final BillingResult zza() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final List zzb() {
        return this.zza;
    }
}
