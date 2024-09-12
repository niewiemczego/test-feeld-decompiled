package com.android.billingclient.api;

import android.content.Context;
import android.content.IntentFilter;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzh {
    /* access modifiers changed from: private */
    public final Context zza;
    /* access modifiers changed from: private */
    public final zzg zzb;

    zzh(Context context, zzbq zzbq, zzbi zzbi) {
        this.zza = context;
        this.zzb = new zzg(this, (zzbq) null, zzbi, (zzf) null);
    }

    /* access modifiers changed from: package-private */
    public final zzbq zzc() {
        zzbq unused = this.zzb.zzc;
        return null;
    }

    /* access modifiers changed from: package-private */
    public final PurchasesUpdatedListener zzd() {
        return this.zzb.zzb;
    }

    /* access modifiers changed from: package-private */
    public final void zze() {
        this.zzb.zzd(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final void zzf(boolean z) {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        this.zza.getApplicationContext().getPackageName();
        intentFilter.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.zzb.zzc(this.zza, intentFilter, (String) null, (IntentFilter) null);
    }

    zzh(Context context, PurchasesUpdatedListener purchasesUpdatedListener, AlternativeBillingListener alternativeBillingListener, zzbi zzbi) {
        this.zza = context;
        this.zzb = new zzg(this, purchasesUpdatedListener, alternativeBillingListener, zzbi, (zzf) null);
    }

    zzh(Context context, PurchasesUpdatedListener purchasesUpdatedListener, UserChoiceBillingListener userChoiceBillingListener, zzbi zzbi) {
        this.zza = context;
        this.zzb = new zzg(this, purchasesUpdatedListener, userChoiceBillingListener, zzbi, (zzf) null);
    }
}
