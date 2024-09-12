package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakk;
import com.google.android.gms.internal.p002firebaseauthapi.zzic;
import com.google.android.gms.internal.p002firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public abstract class zznb<KeyProtoT extends zzakk> {
    private final Class<KeyProtoT> zza;
    private final Map<Class<?>, zzoi<?, KeyProtoT>> zzb;
    private final Class<?> zzc;

    public abstract KeyProtoT zza(zzahm zzahm) throws zzajj;

    public abstract zzic.zza zza();

    public zzna<?, KeyProtoT> zzb() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public abstract void zzb(KeyProtoT keyprotot) throws GeneralSecurityException;

    public abstract zzux.zzb zzc();

    public abstract String zzd();

    public final Class<?> zze() {
        return this.zzc;
    }

    public final Class<KeyProtoT> zzf() {
        return this.zza;
    }

    public final <P> P zza(KeyProtoT keyprotot, Class<P> cls) throws GeneralSecurityException {
        zzoi zzoi = this.zzb.get(cls);
        if (zzoi != null) {
            return zzoi.zza(keyprotot);
        }
        throw new IllegalArgumentException("Requested primitive class " + cls.getCanonicalName() + " not supported.");
    }

    public final Set<Class<?>> zzg() {
        return this.zzb.keySet();
    }

    @SafeVarargs
    protected zznb(Class<KeyProtoT> cls, zzoi<?, KeyProtoT>... zzoiArr) {
        this.zza = cls;
        HashMap hashMap = new HashMap();
        int length = zzoiArr.length;
        int i = 0;
        while (i < length) {
            zzoi<?, KeyProtoT> zzoi = zzoiArr[i];
            if (!hashMap.containsKey(zzoi.zza())) {
                hashMap.put(zzoi.zza(), zzoi);
                i++;
            } else {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive " + zzoi.zza().getCanonicalName());
            }
        }
        if (zzoiArr.length > 0) {
            this.zzc = zzoiArr[0].zza();
        } else {
            this.zzc = Void.class;
        }
        this.zzb = Collections.unmodifiableMap(hashMap);
    }
}
