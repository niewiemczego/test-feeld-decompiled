package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Comparator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaho  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaho implements Comparator<zzahm> {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzahm zzahm = (zzahm) obj;
        zzahm zzahm2 = (zzahm) obj2;
        zzahs zzahs = (zzahs) zzahm.iterator();
        zzahs zzahs2 = (zzahs) zzahm2.iterator();
        while (zzahs.hasNext() && zzahs2.hasNext()) {
            int compareTo = Integer.valueOf(zzahm.zza(zzahs.zza())).compareTo(Integer.valueOf(zzahm.zza(zzahs2.zza())));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzahm.zzb()).compareTo(Integer.valueOf(zzahm2.zzb()));
    }

    zzaho() {
    }
}
