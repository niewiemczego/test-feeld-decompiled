package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakg  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzakg implements zzakh {
    public final int zza(int i, Object obj, Object obj2) {
        zzake zzake = (zzake) obj;
        zzakc zzakc = (zzakc) obj2;
        if (zzake.isEmpty()) {
            return 0;
        }
        Iterator it = zzake.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    public final zzakf<?, ?> zza(Object obj) {
        zzakc zzakc = (zzakc) obj;
        throw new NoSuchMethodError();
    }

    public final Object zza(Object obj, Object obj2) {
        zzake zzake = (zzake) obj;
        zzake zzake2 = (zzake) obj2;
        if (!zzake2.isEmpty()) {
            if (!zzake.zzd()) {
                zzake = zzake.zzb();
            }
            zzake.zza(zzake2);
        }
        return zzake;
    }

    public final Object zzb(Object obj) {
        return zzake.zza().zzb();
    }

    public final Object zzc(Object obj) {
        ((zzake) obj).zzc();
        return obj;
    }

    public final Map<?, ?> zzd(Object obj) {
        return (zzake) obj;
    }

    public final Map<?, ?> zze(Object obj) {
        return (zzake) obj;
    }

    zzakg() {
    }

    public final boolean zzf(Object obj) {
        return !((zzake) obj).zzd();
    }
}
