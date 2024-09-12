package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.internal.play_billing.zzaf;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzej;
import com.google.android.gms.internal.play_billing.zzhy;
import java.util.List;
import org.json.JSONException;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzg extends BroadcastReceiver {
    final /* synthetic */ zzh zza;
    /* access modifiers changed from: private */
    public final PurchasesUpdatedListener zzb;
    /* access modifiers changed from: private */
    public final zzbq zzc;
    private final AlternativeBillingListener zzd;
    private final UserChoiceBillingListener zze;
    private final zzbi zzf;
    private boolean zzg;

    /* synthetic */ zzg(zzh zzh, zzbq zzbq, zzbi zzbi, zzf zzf2) {
        this.zza = zzh;
        this.zzb = null;
        this.zzd = null;
        this.zze = null;
        this.zzc = null;
        this.zzf = zzbi;
    }

    private final void zze(Bundle bundle, BillingResult billingResult, int i) {
        if (bundle.getByteArray("FAILURE_LOGGING_PAYLOAD") != null) {
            try {
                this.zzf.zza(zzhy.zzx(bundle.getByteArray("FAILURE_LOGGING_PAYLOAD"), zzej.zza()));
            } catch (Throwable unused) {
                zzb.zzk("BillingBroadcastManager", "Failed parsing Api failure.");
            }
        } else {
            this.zzf.zza(zzbh.zza(23, i, billingResult));
        }
    }

    public final void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            zzb.zzk("BillingBroadcastManager", "Bundle is null.");
            this.zzf.zza(zzbh.zza(11, 1, zzbk.zzj));
            PurchasesUpdatedListener purchasesUpdatedListener = this.zzb;
            if (purchasesUpdatedListener != null) {
                purchasesUpdatedListener.onPurchasesUpdated(zzbk.zzj, (List<Purchase>) null);
                return;
            }
            return;
        }
        BillingResult zze2 = zzb.zze(intent, "BillingBroadcastManager");
        String action = intent.getAction();
        String string = extras.getString("INTENT_SOURCE");
        int i = 2;
        if (string != "LAUNCH_BILLING_FLOW" && (string == null || !string.equals("LAUNCH_BILLING_FLOW"))) {
            i = 1;
        }
        if (action.equals("com.android.vending.billing.PURCHASES_UPDATED") || action.equals("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED")) {
            List zzi = zzb.zzi(extras);
            if (zze2.getResponseCode() == 0) {
                this.zzf.zzb(zzbh.zzb(i));
            } else {
                zze(extras, zze2, i);
            }
            this.zzb.onPurchasesUpdated(zze2, zzi);
        } else if (!action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
        } else {
            if (zze2.getResponseCode() != 0) {
                zze(extras, zze2, i);
                this.zzb.onPurchasesUpdated(zze2, zzaf.zzk());
            } else if (this.zzd == null && this.zze == null) {
                zzb.zzk("BillingBroadcastManager", "AlternativeBillingListener and UserChoiceBillingListener is null.");
                this.zzf.zza(zzbh.zza(77, i, zzbk.zzj));
                this.zzb.onPurchasesUpdated(zzbk.zzj, zzaf.zzk());
            } else {
                String string2 = extras.getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                if (string2 != null) {
                    try {
                        if (this.zze != null) {
                            this.zze.userSelectedAlternativeBilling(new UserChoiceDetails(string2));
                        } else {
                            this.zzd.userSelectedAlternativeBilling(new AlternativeChoiceDetails(string2));
                        }
                        this.zzf.zzb(zzbh.zzb(i));
                    } catch (JSONException unused) {
                        zzb.zzk("BillingBroadcastManager", String.format("Error when parsing invalid user choice data: [%s]", new Object[]{string2}));
                        this.zzf.zza(zzbh.zza(17, i, zzbk.zzj));
                        this.zzb.onPurchasesUpdated(zzbk.zzj, zzaf.zzk());
                    }
                } else {
                    zzb.zzk("BillingBroadcastManager", "Couldn't find alternative billing user choice data in bundle.");
                    this.zzf.zza(zzbh.zza(16, i, zzbk.zzj));
                    this.zzb.onPurchasesUpdated(zzbk.zzj, zzaf.zzk());
                }
            }
        }
    }

    public final synchronized void zzc(Context context, IntentFilter intentFilter, String str, IntentFilter intentFilter2) {
        if (!this.zzg) {
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this.zza.zzb, intentFilter, (String) null, (Handler) null, 2);
            } else {
                this.zza.zza.getApplicationContext().getPackageName();
                context.registerReceiver(this.zza.zzb, intentFilter);
            }
            this.zzg = true;
        }
    }

    public final synchronized void zzd(Context context) {
        if (this.zzg) {
            context.unregisterReceiver(this.zza.zzb);
            this.zzg = false;
            return;
        }
        zzb.zzk("BillingBroadcastManager", "Receiver is not registered.");
    }

    /* synthetic */ zzg(zzh zzh, PurchasesUpdatedListener purchasesUpdatedListener, AlternativeBillingListener alternativeBillingListener, zzbi zzbi, zzf zzf2) {
        this.zza = zzh;
        this.zzb = purchasesUpdatedListener;
        this.zzf = zzbi;
        this.zzd = alternativeBillingListener;
        this.zze = null;
        this.zzc = null;
    }

    /* synthetic */ zzg(zzh zzh, PurchasesUpdatedListener purchasesUpdatedListener, UserChoiceBillingListener userChoiceBillingListener, zzbi zzbi, zzf zzf2) {
        this.zza = zzh;
        this.zzb = purchasesUpdatedListener;
        this.zzf = zzbi;
        this.zze = userChoiceBillingListener;
        this.zzd = null;
        this.zzc = null;
    }
}
