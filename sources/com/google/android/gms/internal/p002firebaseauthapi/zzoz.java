package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoz  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzoz {
    /* access modifiers changed from: private */
    public final Map<zzpd, zzmx<?, ?>> zza;
    /* access modifiers changed from: private */
    public final Map<zzpb, zzmt<?>> zzb;
    /* access modifiers changed from: private */
    public final Map<zzpd, zzoa<?, ?>> zzc;
    /* access modifiers changed from: private */
    public final Map<zzpb, zznw<?>> zzd;

    public final <SerializationT extends zzow> zzbu zza(SerializationT serializationt, @Nullable zzct zzct) throws GeneralSecurityException {
        zzpb zzpb = new zzpb(serializationt.getClass(), serializationt.zzb());
        if (this.zzb.containsKey(zzpb)) {
            return this.zzb.get(zzpb).zza(serializationt, zzct);
        }
        throw new GeneralSecurityException("No Key Parser for requested key type " + String.valueOf(zzpb) + " available");
    }

    public final <SerializationT extends zzow> zzci zza(SerializationT serializationt) throws GeneralSecurityException {
        zzpb zzpb = new zzpb(serializationt.getClass(), serializationt.zzb());
        if (this.zzd.containsKey(zzpb)) {
            return this.zzd.get(zzpb).zza(serializationt);
        }
        throw new GeneralSecurityException("No Parameters Parser for requested key type " + String.valueOf(zzpb) + " available");
    }

    public final <KeyT extends zzbu, SerializationT extends zzow> SerializationT zza(KeyT keyt, Class<SerializationT> cls, @Nullable zzct zzct) throws GeneralSecurityException {
        zzpd zzpd = new zzpd(keyt.getClass(), cls);
        if (this.zza.containsKey(zzpd)) {
            return this.zza.get(zzpd).zza(keyt, zzct);
        }
        throw new GeneralSecurityException("No Key serializer for " + String.valueOf(zzpd) + " available");
    }

    public final <ParametersT extends zzci, SerializationT extends zzow> SerializationT zza(ParametersT parameterst, Class<SerializationT> cls) throws GeneralSecurityException {
        zzpd zzpd = new zzpd(parameterst.getClass(), cls);
        if (this.zzc.containsKey(zzpd)) {
            return this.zzc.get(zzpd).zza(parameterst);
        }
        throw new GeneralSecurityException("No Key Format serializer for " + String.valueOf(zzpd) + " available");
    }

    private zzoz(zzoy zzoy) {
        this.zza = new HashMap(zzoy.zza);
        this.zzb = new HashMap(zzoy.zzb);
        this.zzc = new HashMap(zzoy.zzc);
        this.zzd = new HashMap(zzoy.zzd);
    }

    public final <SerializationT extends zzow> boolean zzb(SerializationT serializationt) {
        return this.zzb.containsKey(new zzpb(serializationt.getClass(), serializationt.zzb()));
    }

    public final <SerializationT extends zzow> boolean zzc(SerializationT serializationt) {
        return this.zzd.containsKey(new zzpb(serializationt.getClass(), serializationt.zzb()));
    }
}
