package com.android.billingclient.api;

import android.content.Context;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.Destination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zziv;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzbp {
    private boolean zza;
    private Transport zzb;

    zzbp(Context context) {
        try {
            TransportRuntime.initialize(context);
            this.zzb = TransportRuntime.getInstance().newFactory((Destination) CCTDestination.INSTANCE).getTransport("PLAY_BILLING_LIBRARY", zziv.class, Encoding.of("proto"), zzbo.zza);
        } catch (Throwable unused) {
            this.zza = true;
        }
    }

    public final void zza(zziv zziv) {
        if (this.zza) {
            zzb.zzk("BillingLogger", "Skipping logging since initialization failed.");
            return;
        }
        try {
            this.zzb.send(Event.ofData(zziv));
        } catch (Throwable unused) {
            zzb.zzk("BillingLogger", "logging failed.");
        }
    }
}
