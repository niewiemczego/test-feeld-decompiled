package com.android.billingclient.api;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/android/billingclient/api/SkuDetailsResult;", "", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "skuDetailsList", "", "Lcom/android/billingclient/api/SkuDetails;", "(Lcom/android/billingclient/api/BillingResult;Ljava/util/List;)V", "getBillingResult", "()Lcom/android/billingclient/api/BillingResult;", "getSkuDetailsList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "java.com.google.android.libraries.play.billing.public.ktbilling_granule"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: com.android.billingclient:billing-ktx@@6.1.0 */
public final class SkuDetailsResult {
    private final BillingResult zza;
    private final List zzb;

    public SkuDetailsResult(BillingResult billingResult, List<? extends SkuDetails> list) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        this.zza = billingResult;
        this.zzb = list;
    }

    public static /* synthetic */ SkuDetailsResult copy$default(SkuDetailsResult skuDetailsResult, BillingResult billingResult, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            billingResult = skuDetailsResult.zza;
        }
        if ((i & 2) != 0) {
            list = skuDetailsResult.zzb;
        }
        return skuDetailsResult.copy(billingResult, list);
    }

    public final BillingResult component1() {
        return this.zza;
    }

    public final List<SkuDetails> component2() {
        return this.zzb;
    }

    public final SkuDetailsResult copy(BillingResult billingResult, List<? extends SkuDetails> list) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        return new SkuDetailsResult(billingResult, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SkuDetailsResult)) {
            return false;
        }
        SkuDetailsResult skuDetailsResult = (SkuDetailsResult) obj;
        return Intrinsics.areEqual((Object) this.zza, (Object) skuDetailsResult.zza) && Intrinsics.areEqual((Object) this.zzb, (Object) skuDetailsResult.zzb);
    }

    public final BillingResult getBillingResult() {
        return this.zza;
    }

    public final List<SkuDetails> getSkuDetailsList() {
        return this.zzb;
    }

    public int hashCode() {
        int hashCode = this.zza.hashCode() * 31;
        List list = this.zzb;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "SkuDetailsResult(billingResult=" + this.zza + ", skuDetailsList=" + this.zzb + ")";
    }
}
