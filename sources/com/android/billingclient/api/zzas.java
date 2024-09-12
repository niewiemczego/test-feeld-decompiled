package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zze;
import com.google.android.gms.internal.play_billing.zzy;
import java.lang.ref.WeakReference;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzas extends zze {
    final WeakReference zza;
    final ResultReceiver zzb;
    final zzbi zzc;

    /* synthetic */ zzas(WeakReference weakReference, ResultReceiver resultReceiver, zzbi zzbi, zzar zzar) {
        this.zza = weakReference;
        this.zzb = resultReceiver;
        this.zzc = zzbi;
    }

    public final void zza(Bundle bundle) throws RemoteException {
        ResultReceiver resultReceiver = this.zzb;
        if (resultReceiver == null) {
            zzb.zzk("BillingClient", "Unable to send result for alternative billing only dialog");
            this.zzc.zza(zzbh.zza(75, 16, zzbk.zzj));
        } else if (bundle == null) {
            resultReceiver.send(6, (Bundle) null);
        } else {
            Activity activity = (Activity) this.zza.get();
            if (activity == null) {
                zzb.zzk("BillingClient", "The activity from which to launch alternative billing only dialog is null");
                this.zzb.send(6, (Bundle) null);
            } else if (!bundle.containsKey("RESPONSE_CODE")) {
                zzb.zzk("BillingClient", "Response bundle doesn't contain a response code");
                this.zzb.send(6, bundle);
            } else {
                int zzb2 = zzb.zzb(bundle, "BillingClient");
                if (zzb2 != 0) {
                    zzb.zzk("BillingClient", "Unable to launch intent for alternative billing only dialog" + zzb2);
                    this.zzb.send(zzb2, bundle);
                    return;
                }
                PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT");
                if (pendingIntent == null) {
                    zzb.zzj("BillingClient", "User has acknowledged the alternative billing only dialog before.");
                    this.zzb.send(0, bundle);
                    return;
                }
                try {
                    Intent intent = new Intent(activity, ProxyBillingActivity.class);
                    intent.putExtra("alternative_billing_only_dialog_result_receiver", this.zzb);
                    intent.putExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT", pendingIntent);
                    activity.startActivity(intent);
                } catch (RuntimeException e) {
                    zzb.zzl("BillingClient", "Runtime error while launching intent for alternative billing only dialog.", e);
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("RESPONSE_CODE", 6);
                    bundle2.putString("DEBUG_MESSAGE", "An internal error occurred.");
                    bundle2.putInt("INTERNAL_LOG_ERROR_REASON", 75);
                    bundle2.putString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS", String.format("%s: %s", new Object[]{e.getClass().getName(), zzy.zzb(e.getMessage())}));
                    this.zzb.send(6, bundle2);
                }
            }
        }
    }
}
