package com.google.android.gms.measurement.internal;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final /* synthetic */ class zzis implements Comparator {
    public static final /* synthetic */ zzis zza = new zzis();

    private /* synthetic */ zzis() {
    }

    public final int compare(Object obj, Object obj2) {
        return (((Long) obj).longValue() > ((Long) obj2).longValue() ? 1 : (((Long) obj).longValue() == ((Long) obj2).longValue() ? 0 : -1));
    }
}
