package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzwz;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzwr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzwr<T_WRAPPER extends zzwz<JcePrimitiveT>, JcePrimitiveT> {
    public static final zzwr<zzxc, Cipher> zza = new zzwr<>(new zzxc());
    public static final zzwr<zzxg, Mac> zzb = new zzwr<>(new zzxg());
    public static final zzwr<zzxb, KeyAgreement> zzc = new zzwr<>(new zzxb());
    public static final zzwr<zzxd, KeyPairGenerator> zzd = new zzwr<>(new zzxd());
    public static final zzwr<zzxe, KeyFactory> zze = new zzwr<>(new zzxe());
    private static final zzwr<zzxi, Signature> zzf = new zzwr<>(new zzxi());
    private static final zzwr<zzxf, MessageDigest> zzg = new zzwr<>(new zzxf());
    private final zzxa<JcePrimitiveT> zzh;

    public final JcePrimitiveT zza(String str) throws GeneralSecurityException {
        return this.zzh.zza(str);
    }

    public static List<Provider> zza(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String provider : strArr) {
            Provider provider2 = Security.getProvider(provider);
            if (provider2 != null) {
                arrayList.add(provider2);
            }
        }
        return arrayList;
    }

    private zzwr(T_WRAPPER t_wrapper) {
        if (zzic.zzb()) {
            this.zzh = new zzwy(t_wrapper);
        } else if (zzxn.zza()) {
            this.zzh = new zzwu(t_wrapper);
        } else {
            this.zzh = new zzww(t_wrapper);
        }
    }
}
