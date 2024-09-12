package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzaja;
import com.google.android.gms.internal.p002firebaseauthapi.zzux;
import com.google.android.gms.internal.p002firebaseauthapi.zzvh;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzby  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzby {
    private final zzvh zza;
    private final List<zzca> zzb;
    private final zzrl zzc = zzrl.zza;

    static final zzby zza(zzvh zzvh) throws GeneralSecurityException {
        zzc(zzvh);
        return new zzby(zzvh, zzb(zzvh));
    }

    public final zzby zza() throws GeneralSecurityException {
        if (this.zza != null) {
            zzvh.zzb zzc2 = zzvh.zzc();
            for (zzvh.zza next : this.zza.zze()) {
                zzux zzb2 = next.zzb();
                if (zzb2.zzb() == zzux.zzb.ASYMMETRIC_PRIVATE) {
                    zzux zza2 = zzcu.zza(zzb2.zzf(), zzb2.zze());
                    zzaja.zzb zzm = next.zzm();
                    zzaja.zzb zzb3 = zzm;
                    zzc2.zza((zzvh.zza) ((zzaja) ((zzvh.zza.C0035zza) zzm).zza(zza2).zzf()));
                } else {
                    throw new GeneralSecurityException("The keyset contains a non-private key");
                }
            }
            zzc2.zza(this.zza.zzb());
            return zza((zzvh) ((zzaja) zzc2.zzf()));
        }
        throw new GeneralSecurityException("cleartext keyset is not available");
    }

    public static final zzby zza(zzcb zzcb, zzbh zzbh) throws GeneralSecurityException, IOException {
        byte[] bArr = new byte[0];
        zzty zza2 = zzcb.zza();
        if (zza2 != null && zza2.zzc().zzb() != 0) {
            return zza(zza(zza2, zzbh, bArr));
        }
        throw new GeneralSecurityException("empty keyset");
    }

    private static zzot zza(zzvh.zza zza2) {
        try {
            return zzot.zza(zza2.zzb().zzf(), zza2.zzb().zze(), zza2.zzb().zzb(), zza2.zzf(), zza2.zzf() == zzvt.RAW ? null : Integer.valueOf(zza2.zza()));
        } catch (GeneralSecurityException e) {
            throw new zzpe("Creating a protokey serialization failed", e);
        }
    }

    private static zzty zza(zzvh zzvh, zzbh zzbh, byte[] bArr) throws GeneralSecurityException {
        byte[] zzb2 = zzbh.zzb(zzvh.zzj(), bArr);
        try {
            if (zzvh.zza(zzbh.zza(zzb2, bArr), zzaip.zza()).equals(zzvh)) {
                return (zzty) ((zzaja) zzty.zza().zza(zzahm.zza(zzb2)).zza(zzcy.zza(zzvh)).zzf());
            }
            throw new GeneralSecurityException("cannot encrypt keyset");
        } catch (zzajj unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    private static zzvh zza(zzty zzty, zzbh zzbh, byte[] bArr) throws GeneralSecurityException {
        try {
            zzvh zza2 = zzvh.zza(zzbh.zza(zzty.zzc().zzg(), bArr), zzaip.zza());
            zzc(zza2);
            return zza2;
        } catch (zzajj unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    /* access modifiers changed from: package-private */
    public final zzvh zzb() {
        return this.zza;
    }

    public final zzvi zzc() {
        return zzcy.zza(this.zza);
    }

    @Nullable
    private static <B> B zza(zzmm zzmm, zzbu zzbu, Class<B> cls) throws GeneralSecurityException {
        try {
            return zzmm.zza(zzbu, cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    @Nullable
    private static <B> B zza(zzmm zzmm, zzvh.zza zza2, Class<B> cls) throws GeneralSecurityException {
        try {
            return zzmm.zza(zza2.zzb(), cls);
        } catch (GeneralSecurityException e) {
            if (e.getMessage().contains("No key manager found for key type ") || e.getMessage().contains(" not supported by key manager of type ")) {
                return null;
            }
            throw e;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    public final <P> P zza(Class<P> cls) throws GeneralSecurityException {
        zzox zza2 = zzox.zza();
        if (zza2 instanceof zzmm) {
            zzmm zzmm = zza2;
            Class<?> zza3 = zzmm.zza(cls);
            if (zza3 != null) {
                zzcy.zzb(this.zza);
                zzck zzck = new zzck(zza3);
                zzck.zza(this.zzc);
                for (int i = 0; i < this.zza.zza(); i++) {
                    zzvh.zza zza4 = this.zza.zza(i);
                    if (zza4.zzc().equals(zzvb.ENABLED)) {
                        Object zza5 = zza(zzmm, zza4, zza3);
                        Object zza6 = this.zzb.get(i) != null ? zza(zzmm, this.zzb.get(i).zza(), zza3) : null;
                        if (zza6 == null && zza5 == null) {
                            throw new GeneralSecurityException("Unable to get primitive " + String.valueOf(zza3) + " for key of type " + zza4.zzb().zzf());
                        } else if (zza4.zza() == this.zza.zzb()) {
                            zzck.zzb(zza6, zza5, zza4);
                        } else {
                            zzck.zza(zza6, zza5, zza4);
                        }
                    }
                }
                return zzmm.zza(zzck.zza(), cls);
            }
            throw new GeneralSecurityException("No wrapper found for " + cls.getName());
        }
        throw new GeneralSecurityException("Currently only subclasses of InternalConfiguration are accepted");
    }

    public final String toString() {
        return zzcy.zza(this.zza).toString();
    }

    private static List<zzca> zzb(zzvh zzvh) {
        zzbw zzbw;
        ArrayList arrayList = new ArrayList(zzvh.zza());
        for (zzvh.zza next : zzvh.zze()) {
            int zza2 = next.zza();
            try {
                zzbu zza3 = zznv.zza().zza(zza(next), zzct.zza());
                int i = zzbx.zza[next.zzc().ordinal()];
                if (i == 1) {
                    zzbw = zzbw.zza;
                } else if (i == 2) {
                    zzbw = zzbw.zzb;
                } else if (i == 3) {
                    zzbw = zzbw.zzc;
                } else {
                    throw new GeneralSecurityException("Unknown key status");
                }
                arrayList.add(new zzca(zza3, zzbw, zza2, zza2 == zzvh.zzb()));
            } catch (GeneralSecurityException unused) {
                arrayList.add((Object) null);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private zzby(zzvh zzvh, List<zzca> list) {
        this.zza = zzvh;
        this.zzb = list;
    }

    private static void zzc(zzvh zzvh) throws GeneralSecurityException {
        if (zzvh == null || zzvh.zza() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    public final void zza(zzce zzce, zzbh zzbh) throws GeneralSecurityException, IOException {
        zzce.zza(zza(this.zza, zzbh, new byte[0]));
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.p002firebaseauthapi.zzce r5) throws java.security.GeneralSecurityException, java.io.IOException {
        /*
            r4 = this;
            com.google.android.gms.internal.firebase-auth-api.zzvh r0 = r4.zza
            java.util.List r0 = r0.zze()
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0064
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.firebase-auth-api.zzvh$zza r1 = (com.google.android.gms.internal.p002firebaseauthapi.zzvh.zza) r1
            com.google.android.gms.internal.firebase-auth-api.zzux r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzux$zzb r2 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzux$zzb r3 = com.google.android.gms.internal.p002firebaseauthapi.zzux.zzb.UNKNOWN_KEYMATERIAL
            if (r2 == r3) goto L_0x003b
            com.google.android.gms.internal.firebase-auth-api.zzux r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzux$zzb r2 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzux$zzb r3 = com.google.android.gms.internal.p002firebaseauthapi.zzux.zzb.SYMMETRIC
            if (r2 == r3) goto L_0x003b
            com.google.android.gms.internal.firebase-auth-api.zzux r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzux$zzb r2 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzux$zzb r3 = com.google.android.gms.internal.p002firebaseauthapi.zzux.zzb.ASYMMETRIC_PRIVATE
            if (r2 == r3) goto L_0x003b
            goto L_0x000a
        L_0x003b:
            java.security.GeneralSecurityException r5 = new java.security.GeneralSecurityException
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r2 = 0
            com.google.android.gms.internal.firebase-auth-api.zzux r3 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzux$zzb r3 = r3.zzb()
            java.lang.String r3 = r3.name()
            r0[r2] = r3
            r2 = 1
            com.google.android.gms.internal.firebase-auth-api.zzux r1 = r1.zzb()
            java.lang.String r1 = r1.zzf()
            r0[r2] = r1
            java.lang.String r1 = "keyset contains key material of type %s for type url %s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r5.<init>(r0)
            throw r5
        L_0x0064:
            com.google.android.gms.internal.firebase-auth-api.zzvh r0 = r4.zza
            r5.zza((com.google.android.gms.internal.p002firebaseauthapi.zzvh) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzby.zza(com.google.android.gms.internal.firebase-auth-api.zzce):void");
    }
}
