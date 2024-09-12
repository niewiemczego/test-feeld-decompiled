package com.google.android.gms.internal.play_billing;

import java.util.Comparator;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzdo implements Comparator {
    zzdo() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzdw zzdw = (zzdw) obj;
        zzdw zzdw2 = (zzdw) obj2;
        zzdn zzdn = new zzdn(zzdw);
        zzdn zzdn2 = new zzdn(zzdw2);
        while (zzdn.hasNext() && zzdn2.hasNext()) {
            int compareTo = Integer.valueOf(zzdn.zza() & 255).compareTo(Integer.valueOf(zzdn2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzdw.zzd()).compareTo(Integer.valueOf(zzdw2.zzd()));
    }
}
