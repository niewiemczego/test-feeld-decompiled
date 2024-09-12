package com.android.billingclient.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/android/billingclient/api/CreateAlternativeBillingOnlyReportingDetailsResult;", "", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "alternativeBillingOnlyReportingDetails", "Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetails;", "(Lcom/android/billingclient/api/BillingResult;Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetails;)V", "getAlternativeBillingOnlyReportingDetails", "()Lcom/android/billingclient/api/AlternativeBillingOnlyReportingDetails;", "getBillingResult", "()Lcom/android/billingclient/api/BillingResult;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "java.com.google.android.libraries.play.billing.public.ktbilling_granule"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: com.android.billingclient:billing-ktx@@6.1.0 */
public final class CreateAlternativeBillingOnlyReportingDetailsResult {
    private final BillingResult zza;
    private final AlternativeBillingOnlyReportingDetails zzb;

    public CreateAlternativeBillingOnlyReportingDetailsResult(BillingResult billingResult, AlternativeBillingOnlyReportingDetails alternativeBillingOnlyReportingDetails) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        this.zza = billingResult;
        this.zzb = alternativeBillingOnlyReportingDetails;
    }

    public static /* synthetic */ CreateAlternativeBillingOnlyReportingDetailsResult copy$default(CreateAlternativeBillingOnlyReportingDetailsResult createAlternativeBillingOnlyReportingDetailsResult, BillingResult billingResult, AlternativeBillingOnlyReportingDetails alternativeBillingOnlyReportingDetails, int i, Object obj) {
        if ((i & 1) != 0) {
            billingResult = createAlternativeBillingOnlyReportingDetailsResult.zza;
        }
        if ((i & 2) != 0) {
            alternativeBillingOnlyReportingDetails = createAlternativeBillingOnlyReportingDetailsResult.zzb;
        }
        return createAlternativeBillingOnlyReportingDetailsResult.copy(billingResult, alternativeBillingOnlyReportingDetails);
    }

    public final BillingResult component1() {
        return this.zza;
    }

    public final AlternativeBillingOnlyReportingDetails component2() {
        return this.zzb;
    }

    public final CreateAlternativeBillingOnlyReportingDetailsResult copy(BillingResult billingResult, AlternativeBillingOnlyReportingDetails alternativeBillingOnlyReportingDetails) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        return new CreateAlternativeBillingOnlyReportingDetailsResult(billingResult, alternativeBillingOnlyReportingDetails);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreateAlternativeBillingOnlyReportingDetailsResult)) {
            return false;
        }
        CreateAlternativeBillingOnlyReportingDetailsResult createAlternativeBillingOnlyReportingDetailsResult = (CreateAlternativeBillingOnlyReportingDetailsResult) obj;
        return Intrinsics.areEqual((Object) this.zza, (Object) createAlternativeBillingOnlyReportingDetailsResult.zza) && Intrinsics.areEqual((Object) this.zzb, (Object) createAlternativeBillingOnlyReportingDetailsResult.zzb);
    }

    public final AlternativeBillingOnlyReportingDetails getAlternativeBillingOnlyReportingDetails() {
        return this.zzb;
    }

    public final BillingResult getBillingResult() {
        return this.zza;
    }

    public int hashCode() {
        int hashCode = this.zza.hashCode() * 31;
        AlternativeBillingOnlyReportingDetails alternativeBillingOnlyReportingDetails = this.zzb;
        return hashCode + (alternativeBillingOnlyReportingDetails == null ? 0 : alternativeBillingOnlyReportingDetails.hashCode());
    }

    public String toString() {
        return "CreateAlternativeBillingOnlyReportingDetailsResult(billingResult=" + this.zza + ", alternativeBillingOnlyReportingDetails=" + this.zzb + ")";
    }
}
