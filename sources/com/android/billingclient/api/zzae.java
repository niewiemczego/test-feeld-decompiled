package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final /* synthetic */ class zzae implements Runnable {
    public final /* synthetic */ BillingClientImpl zza;
    public final /* synthetic */ AlternativeBillingOnlyInformationDialogListener zzb;

    public /* synthetic */ zzae(BillingClientImpl billingClientImpl, AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        this.zza = billingClientImpl;
        this.zzb = alternativeBillingOnlyInformationDialogListener;
    }

    public final void run() {
        this.zza.zzW(this.zzb);
    }
}
