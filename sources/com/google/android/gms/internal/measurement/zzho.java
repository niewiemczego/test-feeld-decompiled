package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
final class zzho implements Comparator<zzhm> {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzhm zzhm = (zzhm) obj;
        zzhm zzhm2 = (zzhm) obj2;
        zzhs zzhs = (zzhs) zzhm.iterator();
        zzhs zzhs2 = (zzhs) zzhm2.iterator();
        while (zzhs.hasNext() && zzhs2.hasNext()) {
            int compareTo = Integer.valueOf(zzhm.zza(zzhs.zza())).compareTo(Integer.valueOf(zzhm.zza(zzhs2.zza())));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzhm.zzb()).compareTo(Integer.valueOf(zzhm2.zzb()));
    }

    zzho() {
    }
}
