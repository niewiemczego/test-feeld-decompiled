package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzi;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzaw extends zzi {
    final AlternativeBillingOnlyAvailabilityListener zza;
    final zzbi zzb;

    /* synthetic */ zzaw(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener, zzbi zzbi, zzav zzav) {
        this.zza = alternativeBillingOnlyAvailabilityListener;
        this.zzb = zzbi;
    }

    public final void zza(Bundle bundle) throws RemoteException {
        if (bundle == null) {
            this.zzb.zza(zzbh.zza(67, 14, zzbk.zzj));
            this.zza.onAlternativeBillingOnlyAvailabilityResponse(zzbk.zzj);
            return;
        }
        int zzb2 = zzb.zzb(bundle, "BillingClient");
        BillingResult zza2 = zzbk.zza(zzb2, zzb.zzg(bundle, "BillingClient"));
        if (zzb2 != 0) {
            zzb.zzk("BillingClient", "isAlternativeBillingOnlyAvailableAsync() failed. Response code: " + zzb2);
            this.zzb.zza(zzbh.zza(23, 14, zza2));
        }
        this.zza.onAlternativeBillingOnlyAvailabilityResponse(zza2);
    }
}
