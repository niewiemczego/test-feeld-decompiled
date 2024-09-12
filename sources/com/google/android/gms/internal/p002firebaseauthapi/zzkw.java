package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzsh;
import com.google.android.gms.internal.p002firebaseauthapi.zzst;
import com.google.android.gms.internal.p002firebaseauthapi.zztb;
import com.google.android.gms.internal.p002firebaseauthapi.zzue;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkw  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzkw implements zzwk {
    private final String zza;
    private final int zzb;
    private zzst zzc;
    private zzsd zzd;
    private int zze;
    private zztb zzf;

    public final int zza() {
        return this.zzb;
    }

    public final zzlv zza(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != this.zzb) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        } else if (this.zza.equals(zzcx.zzb)) {
            return new zzlv((zzbh) zzcu.zza(this.zza, ((zzst) ((zzaja) ((zzst.zza) zzst.zzb().zza(this.zzc)).zza(zzahm.zza(bArr, 0, this.zzb)).zzf())).zzi(), zzbh.class));
        } else {
            if (this.zza.equals(zzcx.zza)) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zze);
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zze, this.zzb);
                return new zzlv((zzbh) zzcu.zza(this.zza, ((zzsd) ((zzaja) zzsd.zzb().zza(this.zzd.zza()).zza((zzsh) ((zzaja) ((zzsh.zza) zzsh.zzb().zza(this.zzd.zzd())).zza(zzahm.zza(copyOfRange)).zzf())).zza((zzue) ((zzaja) ((zzue.zza) zzue.zzb().zza(this.zzd.zze())).zza(zzahm.zza(copyOfRange2)).zzf())).zzf())).zzi(), zzbh.class));
            } else if (this.zza.equals(zzis.zza)) {
                return new zzlv((zzbq) zzcu.zza(this.zza, ((zztb) ((zzaja) ((zztb.zza) zztb.zzb().zza(this.zzf)).zza(zzahm.zza(bArr, 0, this.zzb)).zzf())).zzi(), zzbq.class));
            } else {
                throw new GeneralSecurityException("unknown DEM key type");
            }
        }
    }

    zzkw(zzvd zzvd) throws GeneralSecurityException {
        String zzf2 = zzvd.zzf();
        this.zza = zzf2;
        if (zzf2.equals(zzcx.zzb)) {
            try {
                zzsw zza2 = zzsw.zza(zzvd.zze(), zzaip.zza());
                this.zzc = zzst.zza(zzcu.zza(zzvd).zze(), zzaip.zza());
                this.zzb = zza2.zza();
            } catch (zzajj e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (zzf2.equals(zzcx.zza)) {
            try {
                zzsg zza3 = zzsg.zza(zzvd.zze(), zzaip.zza());
                this.zzd = zzsd.zza(zzcu.zza(zzvd).zze(), zzaip.zza());
                this.zze = zza3.zzc().zza();
                this.zzb = this.zze + zza3.zzd().zza();
            } catch (zzajj e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        } else if (zzf2.equals(zzis.zza)) {
            try {
                zzte zza4 = zzte.zza(zzvd.zze(), zzaip.zza());
                this.zzf = zztb.zza(zzcu.zza(zzvd).zze(), zzaip.zza());
                this.zzb = zza4.zza();
            } catch (zzajj e3) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e3);
            }
        } else {
            throw new GeneralSecurityException("unsupported AEAD DEM key type: " + zzf2);
        }
    }
}
