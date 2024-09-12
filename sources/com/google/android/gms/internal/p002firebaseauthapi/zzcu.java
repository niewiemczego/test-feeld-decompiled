package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzic;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcu  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzcu {
    private static final Logger zza = Logger.getLogger(zzcu.class.getName());
    private static final ConcurrentMap<String, Object> zzb = new ConcurrentHashMap();
    private static final Set<Class<?>> zzc;

    public static zzux zza(String str, zzahm zzahm) throws GeneralSecurityException {
        zzbt<?> zza2 = zzmn.zza().zza(str);
        if (zza2 instanceof zzcp) {
            return ((zzcp) zza2).zzc(zzahm);
        }
        throw new GeneralSecurityException("manager for key type " + str + " is not a PrivateKeyManager");
    }

    public static synchronized zzux zza(zzvd zzvd) throws GeneralSecurityException {
        zzux zza2;
        synchronized (zzcu.class) {
            zzbt<?> zza3 = zzmn.zza().zza(zzvd.zzf());
            if (zzmn.zza().zzb(zzvd.zzf())) {
                zza2 = zza3.zza(zzvd.zze());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type " + zzvd.zzf());
            }
        }
        return zza2;
    }

    @Nullable
    public static Class<?> zza(Class<?> cls) {
        try {
            return zzns.zza().zza(cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    public static <P> P zza(zzux zzux, Class<P> cls) throws GeneralSecurityException {
        return zza(zzux.zzf(), zzux.zze(), cls);
    }

    public static <P> P zza(String str, zzahm zzahm, Class<P> cls) throws GeneralSecurityException {
        return zzmn.zza().zza(str, cls).zzb(zzahm);
    }

    public static <P> P zza(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return zza(str, zzahm.zza(bArr), cls);
    }

    public static <B, P> P zza(zzch<B> zzch, Class<P> cls) throws GeneralSecurityException {
        return zzns.zza().zza(zzch, cls);
    }

    static {
        HashSet hashSet = new HashSet();
        hashSet.add(zzbh.class);
        hashSet.add(zzbq.class);
        hashSet.add(zzcw.class);
        hashSet.add(zzbs.class);
        hashSet.add(zzbp.class);
        hashSet.add(zzcf.class);
        hashSet.add(zzrv.class);
        hashSet.add(zzcs.class);
        hashSet.add(zzcr.class);
        zzc = Collections.unmodifiableSet(hashSet);
    }

    private zzcu() {
    }

    public static synchronized <KeyProtoT extends zzakk, PublicKeyProtoT extends zzakk> void zza(zzoq<KeyProtoT, PublicKeyProtoT> zzoq, zznb<PublicKeyProtoT> zznb, boolean z) throws GeneralSecurityException {
        synchronized (zzcu.class) {
            zzmn.zza().zza(zzoq, zznb, true);
        }
    }

    public static synchronized <P> void zza(zzbt<P> zzbt, boolean z) throws GeneralSecurityException {
        synchronized (zzcu.class) {
            if (zzbt != null) {
                try {
                    if (!zzc.contains(zzbt.zza())) {
                        throw new GeneralSecurityException("Registration of key managers for class " + String.valueOf(zzbt.zza()) + " has been disabled. Please file an issue on https://github.com/tink-crypto/tink-java");
                    } else if (zzic.zza.ALGORITHM_NOT_FIPS.zza()) {
                        zzmn.zza().zza(zzbt, true);
                    } else {
                        throw new GeneralSecurityException("Registering key managers is not supported in FIPS mode");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }

    public static synchronized <KeyProtoT extends zzakk> void zza(zznb<KeyProtoT> zznb, boolean z) throws GeneralSecurityException {
        synchronized (zzcu.class) {
            zzmn.zza().zza(zznb, true);
        }
    }

    public static synchronized <B, P> void zza(zzcq<B, P> zzcq) throws GeneralSecurityException {
        synchronized (zzcu.class) {
            zzns.zza().zza(zzcq);
        }
    }
}
