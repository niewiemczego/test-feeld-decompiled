package com.google.android.gms.internal.play_billing;

import android.os.Build;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzce extends zzby {
    private static final AtomicReference zza = new AtomicReference();
    private static final AtomicLong zzb = new AtomicLong();
    private static final ConcurrentLinkedQueue zzc = new ConcurrentLinkedQueue();
    private volatile zzbf zzd;

    private zzce(String str) {
        super(str);
        boolean z = true;
        boolean z2 = Build.FINGERPRINT == null || "robolectric".equals(Build.FINGERPRINT);
        boolean z3 = "goldfish".equals(Build.HARDWARE) || "ranchu".equals(Build.HARDWARE);
        if (!"eng".equals(Build.TYPE) && !"userdebug".equals(Build.TYPE)) {
            z = false;
        }
        if (z2 || z3) {
            this.zzd = new zzbz().zza(zza());
        } else if (z) {
            this.zzd = zzck.zzc().zzb(false).zza(zza());
        } else {
            this.zzd = null;
        }
    }

    public static zzbf zzb(String str) {
        AtomicReference atomicReference = zza;
        if (atomicReference.get() != null) {
            return ((zzca) atomicReference.get()).zza(str);
        }
        zzce zzce = new zzce(str.replace('$', '.'));
        zzcc.zza.offer(zzce);
        if (atomicReference.get() != null) {
            while (true) {
                zzce zzce2 = (zzce) zzcc.zza.poll();
                if (zzce2 == null) {
                    break;
                }
                zzce2.zzd = ((zzca) zza.get()).zza(zzce2.zza());
            }
            if (((zzcd) zzc.poll()) != null) {
                zzb.getAndDecrement();
                throw null;
            }
        }
        return zzce;
    }
}
