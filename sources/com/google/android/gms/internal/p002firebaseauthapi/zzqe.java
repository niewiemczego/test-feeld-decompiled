package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzic;
import com.google.android.gms.internal.p002firebaseauthapi.zzqm;
import com.google.android.gms.internal.p002firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqe  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzqe extends zznb<zzue> {
    private static final zzoe<zzqb, zzpx> zza = zzoe.zza(zzqh.zza, zzqb.class, zzpx.class);
    private static final zzoe<zzqb, zzcf> zzb = zzoe.zza(zzqg.zza, zzqb.class, zzcf.class);
    private static final zznp<zzqm> zzc = zzqj.zza;

    public static int zzh() {
        return 0;
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    public final zzic.zza zza() {
        return zzic.zza.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    public final zzna<zzuf, zzue> zzb() {
        return new zzql(this, zzuf.class);
    }

    public final zzux.zzb zzc() {
        return zzux.zzb.SYMMETRIC;
    }

    public final /* synthetic */ zzakk zza(zzahm zzahm) throws zzajj {
        return zzue.zza(zzahm, zzaip.zza());
    }

    zzqe() {
        super(zzue.class, new zzqi(zzcf.class));
    }

    public static void zza(boolean z) throws GeneralSecurityException {
        zzcu.zza(new zzqe(), true);
        zzrg.zza();
        zzns.zza().zza(zza);
        zzns.zza().zza(zzb);
        zznt zza2 = zznt.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("HMAC_SHA256_128BITTAG", zzqv.zza);
        hashMap.put("HMAC_SHA256_128BITTAG_RAW", zzqm.zzd().zza(32).zzb(16).zza(zzqm.zzc.zzd).zza(zzqm.zzb.zzc).zza());
        hashMap.put("HMAC_SHA256_256BITTAG", zzqm.zzd().zza(32).zzb(32).zza(zzqm.zzc.zza).zza(zzqm.zzb.zzc).zza());
        hashMap.put("HMAC_SHA256_256BITTAG_RAW", zzqm.zzd().zza(32).zzb(32).zza(zzqm.zzc.zzd).zza(zzqm.zzb.zzc).zza());
        hashMap.put("HMAC_SHA512_128BITTAG", zzqm.zzd().zza(64).zzb(16).zza(zzqm.zzc.zza).zza(zzqm.zzb.zze).zza());
        hashMap.put("HMAC_SHA512_128BITTAG_RAW", zzqm.zzd().zza(64).zzb(16).zza(zzqm.zzc.zzd).zza(zzqm.zzb.zze).zza());
        hashMap.put("HMAC_SHA512_256BITTAG", zzqm.zzd().zza(64).zzb(32).zza(zzqm.zzc.zza).zza(zzqm.zzb.zze).zza());
        hashMap.put("HMAC_SHA512_256BITTAG_RAW", zzqm.zzd().zza(64).zzb(32).zza(zzqm.zzc.zzd).zza(zzqm.zzb.zze).zza());
        hashMap.put("HMAC_SHA512_512BITTAG", zzqv.zzb);
        hashMap.put("HMAC_SHA512_512BITTAG_RAW", zzqm.zzd().zza(64).zzb(64).zza(zzqm.zzc.zzd).zza(zzqm.zzb.zze).zza());
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zznm.zza().zza(zzc, zzqm.class);
    }

    public final /* synthetic */ void zzb(zzakk zzakk) throws GeneralSecurityException {
        zzue zzue = (zzue) zzakk;
        zzxq.zza(zzue.zza(), 0);
        if (zzue.zzf().zzb() >= 16) {
            zzb(zzue.zze());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    /* access modifiers changed from: private */
    public static void zzb(zzui zzui) throws GeneralSecurityException {
        if (zzui.zza() >= 10) {
            int i = zzqk.zza[zzui.zzb().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                throw new GeneralSecurityException("unknown hash type");
                            } else if (zzui.zza() > 64) {
                                throw new GeneralSecurityException("tag size too big");
                            }
                        } else if (zzui.zza() > 48) {
                            throw new GeneralSecurityException("tag size too big");
                        }
                    } else if (zzui.zza() > 32) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                } else if (zzui.zza() > 28) {
                    throw new GeneralSecurityException("tag size too big");
                }
            } else if (zzui.zza() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }
}
