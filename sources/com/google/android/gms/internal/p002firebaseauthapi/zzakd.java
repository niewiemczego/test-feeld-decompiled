package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzakd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzakd implements zzakl {
    private zzakl[] zza;

    public final zzaki zza(Class<?> cls) {
        for (zzakl zzakl : this.zza) {
            if (zzakl.zzb(cls)) {
                return zzakl.zza(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
    }

    zzakd(zzakl... zzaklArr) {
        this.zza = zzaklArr;
    }

    public final boolean zzb(Class<?> cls) {
        for (zzakl zzb : this.zza) {
            if (zzb.zzb(cls)) {
                return true;
            }
        }
        return false;
    }
}
