package com.google.android.gms.internal.measurement;

import androidx.collection.SimpleArrayMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzgc implements zzgh {
    private final SimpleArrayMap<String, SimpleArrayMap<String, String>> zza;

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0016 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0017  */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zza(@javax.annotation.Nullable android.net.Uri r2, @javax.annotation.Nullable java.lang.String r3, @javax.annotation.Nullable java.lang.String r4, java.lang.String r5) {
        /*
            r1 = this;
            r0 = 0
            if (r2 == 0) goto L_0x0008
            java.lang.String r3 = r2.toString()
            goto L_0x000a
        L_0x0008:
            if (r3 == 0) goto L_0x0013
        L_0x000a:
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.collection.SimpleArrayMap<java.lang.String, java.lang.String>> r2 = r1.zza
            java.lang.Object r2 = r2.get(r3)
            androidx.collection.SimpleArrayMap r2 = (androidx.collection.SimpleArrayMap) r2
            goto L_0x0014
        L_0x0013:
            r2 = r0
        L_0x0014:
            if (r2 != 0) goto L_0x0017
            return r0
        L_0x0017:
            if (r4 == 0) goto L_0x002a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r5)
            java.lang.String r5 = r3.toString()
        L_0x002a:
            java.lang.Object r2 = r2.get(r5)
            java.lang.String r2 = (java.lang.String) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgc.zza(android.net.Uri, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    zzgc(SimpleArrayMap<String, SimpleArrayMap<String, String>> simpleArrayMap) {
        this.zza = simpleArrayMap;
    }
}
