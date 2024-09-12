package com.android.billingclient.api;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final /* synthetic */ class zzcd implements ActivityResultCallback {
    public final /* synthetic */ ProxyBillingActivity zza;

    public /* synthetic */ zzcd(ProxyBillingActivity proxyBillingActivity) {
        this.zza = proxyBillingActivity;
    }

    public final void onActivityResult(Object obj) {
        this.zza.onAlternativeBillingOnlyDialogResult((ActivityResult) obj);
    }
}
