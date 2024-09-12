package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakk;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzna  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public abstract class zzna<KeyFormatProtoT extends zzakk, KeyProtoT extends zzakk> {
    private final Class<KeyFormatProtoT> zza;

    public zzna(Class<KeyFormatProtoT> cls) {
        this.zza = cls;
    }

    public abstract KeyFormatProtoT zza(zzahm zzahm) throws zzajj;

    public abstract KeyProtoT zza(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;

    public abstract void zzb(KeyFormatProtoT keyformatprotot) throws GeneralSecurityException;
}
