package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zziq;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjb  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzjb {
    private static final zzxr zza;
    private static final zzoa<zziq, zzos> zzb = zzoa.zza(zzja.zza, zziq.class, zzos.class);
    private static final zznw<zzos> zzc;
    private static final zzmx<zzij, zzot> zzd = zzmx.zza(zzjc.zza, zzij.class, zzot.class);
    private static final zzmt<zzot> zze;
    private static final Map<zziq.zzb, zzvt> zzf;
    private static final Map<zzvt, zziq.zzb> zzg;

    /* access modifiers changed from: private */
    public static zzij zzb(zzot zzot, @Nullable zzct zzct) throws GeneralSecurityException {
        if (zzot.zzf().equals(zzis.zza)) {
            try {
                zztb zza2 = zztb.zza(zzot.zzd(), zzaip.zza());
                if (zza2.zza() == 0) {
                    return zzij.zzb().zza(zziq.zzc().zza(zza2.zzd().zzb()).zza(zza(zzot.zzc())).zza()).zza(zzxt.zza(zza2.zzd().zzg(), zzct.zza(zzct))).zza(zzot.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzajj unused) {
                throw new GeneralSecurityException("Parsing AesSivKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters");
        }
    }

    private static zziq.zzb zza(zzvt zzvt) throws GeneralSecurityException {
        Map<zzvt, zziq.zzb> map = zzg;
        if (map.containsKey(zzvt)) {
            return map.get(zzvt);
        }
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zzvt.zza());
    }

    /* access modifiers changed from: private */
    public static zziq zzb(zzos zzos) throws GeneralSecurityException {
        if (zzos.zza().zzf().equals(zzis.zza)) {
            try {
                zzte zza2 = zzte.zza(zzos.zza().zze(), zzaip.zza());
                if (zza2.zzb() == 0) {
                    return zziq.zzc().zza(zza2.zza()).zza(zza(zzos.zza().zzd())).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzajj e) {
                throw new GeneralSecurityException("Parsing AesSivParameters failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters: " + zzos.zza().zzf());
        }
    }

    private static zzvt zza(zziq.zzb zzb2) throws GeneralSecurityException {
        Map<zziq.zzb, zzvt> map = zzf;
        if (map.containsKey(zzb2)) {
            return map.get(zzb2);
        }
        throw new GeneralSecurityException("Unable to serialize variant: " + String.valueOf(zzb2));
    }

    static {
        zzxr zzb2 = zzpg.zzb(zzis.zza);
        zza = zzb2;
        zzc = zznw.zza(zzjd.zza, zzb2, zzos.class);
        zze = zzmt.zza(zzjf.zza, zzb2, zzot.class);
        HashMap hashMap = new HashMap();
        hashMap.put(zziq.zzb.zzc, zzvt.RAW);
        hashMap.put(zziq.zzb.zza, zzvt.TINK);
        hashMap.put(zziq.zzb.zzb, zzvt.CRUNCHY);
        zzf = Collections.unmodifiableMap(hashMap);
        EnumMap enumMap = new EnumMap(zzvt.class);
        enumMap.put(zzvt.RAW, zziq.zzb.zzc);
        enumMap.put(zzvt.TINK, zziq.zzb.zza);
        enumMap.put(zzvt.CRUNCHY, zziq.zzb.zzb);
        enumMap.put(zzvt.LEGACY, zziq.zzb.zzb);
        zzg = Collections.unmodifiableMap(enumMap);
    }

    public static void zza() throws GeneralSecurityException {
        zznv zza2 = zznv.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }
}
