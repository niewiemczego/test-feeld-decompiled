package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzic;
import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmn  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzmn {
    private static final Logger zza = Logger.getLogger(zzmn.class.getName());
    private static final zzmn zzb = new zzmn();
    private ConcurrentMap<String, zza> zzc = new ConcurrentHashMap();
    private ConcurrentMap<String, Boolean> zzd = new ConcurrentHashMap();

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmn$zza */
    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    private interface zza {
        zzbt<?> zza();

        <P> zzbt<P> zza(Class<P> cls) throws GeneralSecurityException;

        Class<?> zzb();

        Set<Class<?>> zzc();
    }

    public final <P> zzbt<P> zza(String str, Class<P> cls) throws GeneralSecurityException {
        zza zzc2 = zzc(str);
        if (zzc2.zzc().contains(cls)) {
            return zzc2.zza(cls);
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzc2.zzb());
        Set<Class<?>> zzc3 = zzc2.zzc();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class next : zzc3) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(next.getCanonicalName());
            z = false;
        }
        throw new GeneralSecurityException("Primitive type " + name + " not supported by key manager of type " + valueOf + ", supported primitives: " + sb.toString());
    }

    public final zzbt<?> zza(String str) throws GeneralSecurityException {
        return zzc(str).zza();
    }

    private static <KeyProtoT extends zzakk> zza zza(zznb<KeyProtoT> zznb) {
        return new zzmp(zznb);
    }

    private final synchronized zza zzc(String str) throws GeneralSecurityException {
        if (this.zzc.containsKey(str)) {
        } else {
            throw new GeneralSecurityException("No key manager found for key type " + str);
        }
        return (zza) this.zzc.get(str);
    }

    public static zzmn zza() {
        return zzb;
    }

    public final synchronized <KeyProtoT extends zzakk, PublicKeyProtoT extends zzakk> void zza(zzoq<KeyProtoT, PublicKeyProtoT> zzoq, zznb<PublicKeyProtoT> zznb, boolean z) throws GeneralSecurityException {
        zzic.zza zza2 = zzoq.zza();
        zzic.zza zza3 = zznb.zza();
        if (!zza2.zza()) {
            throw new GeneralSecurityException("failed to register key manager " + String.valueOf(zzoq.getClass()) + " as it is not FIPS compatible.");
        } else if (zza3.zza()) {
            zza((zza) new zzmr(zzoq, zznb), true, true);
            zza(zza(zznb), false, false);
        } else {
            throw new GeneralSecurityException("failed to register key manager " + String.valueOf(zznb.getClass()) + " as it is not FIPS compatible.");
        }
    }

    public final synchronized <P> void zza(zzbt<P> zzbt, boolean z) throws GeneralSecurityException {
        zza(zzbt, zzic.zza.ALGORITHM_NOT_FIPS, true);
    }

    public final synchronized <KeyProtoT extends zzakk> void zza(zznb<KeyProtoT> zznb, boolean z) throws GeneralSecurityException {
        if (zznb.zza().zza()) {
            zza(zza(zznb), false, true);
        } else {
            throw new GeneralSecurityException("failed to register key manager " + String.valueOf(zznb.getClass()) + " as it is not FIPS compatible.");
        }
    }

    private final synchronized void zza(zza zza2, boolean z, boolean z2) throws GeneralSecurityException {
        String zzb2 = zza2.zza().zzb();
        if (z2 && this.zzd.containsKey(zzb2)) {
            if (!((Boolean) this.zzd.get(zzb2)).booleanValue()) {
                throw new GeneralSecurityException("New keys are already disallowed for key type " + zzb2);
            }
        }
        zza zza3 = (zza) this.zzc.get(zzb2);
        if (zza3 != null) {
            if (!zza3.zzb().equals(zza2.zzb())) {
                zza.logp(Level.WARNING, "com.google.crypto.tink.internal.KeyManagerRegistry", "registerKeyManagerContainer", "Attempted overwrite of a registered key manager for key type " + zzb2);
                throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", new Object[]{zzb2, zza3.zzb().getName(), zza2.zzb().getName()}));
            }
        }
        if (!z) {
            this.zzc.putIfAbsent(zzb2, zza2);
        } else {
            this.zzc.put(zzb2, zza2);
        }
        this.zzd.put(zzb2, Boolean.valueOf(z2));
    }

    public final synchronized <P> void zza(zzbt<P> zzbt, zzic.zza zza2, boolean z) throws GeneralSecurityException {
        if (zza2.zza()) {
            zza((zza) new zzmq(zzbt), false, z);
        } else {
            throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");
        }
    }

    public final boolean zzb(String str) {
        return ((Boolean) this.zzd.get(str)).booleanValue();
    }
}
