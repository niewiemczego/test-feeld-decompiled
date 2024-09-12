package com.google.android.gms.internal.play_billing;

import java.util.Comparator;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzcq implements Comparator {
    zzcq() {
    }

    public final int compare(Object obj, Object obj2) {
        zzcx zza = zzcx.zza(obj);
        zzcx zza2 = zzcx.zza(obj2);
        if (zza != zza2) {
            return zza.compareTo(zza2);
        }
        int ordinal = zza.ordinal();
        if (ordinal == 0) {
            return ((Boolean) obj).compareTo((Boolean) obj2);
        }
        if (ordinal == 1) {
            return ((String) obj).compareTo((String) obj2);
        }
        if (ordinal == 2) {
            return ((Long) obj).compareTo((Long) obj2);
        }
        if (ordinal == 3) {
            return ((Double) obj).compareTo((Double) obj2);
        }
        throw null;
    }
}
