package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkq  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzkq {
    public static final zzvd zza;
    private static final byte[] zzb;
    private static final zzvd zzc;
    private static final zzvd zzd;

    @Deprecated
    private static zzvd zza(zztx zztx, zzuc zzuc, zztj zztj, zzvd zzvd, zzvt zzvt, byte[] bArr) {
        return (zzvd) ((zzaja) zzvd.zza().zza(new zzje().zzd()).zza(zzvt).zza(((zzto) ((zzaja) zzto.zza().zza((zztp) ((zzaja) zztp.zzc().zza((zztw) ((zzaja) zztw.zza().zza(zztx).zza(zzuc).zza(zzahm.zza(bArr)).zzf())).zza((zztk) ((zzaja) zztk.zza().zza(zzvd).zzf())).zza(zztj).zzf())).zzf())).zzi()).zzf());
    }

    static {
        byte[] bArr = new byte[0];
        zzb = bArr;
        byte[] bArr2 = bArr;
        zza = zza(zztx.NIST_P256, zzuc.SHA256, zztj.UNCOMPRESSED, zzcz.zza, zzvt.TINK, bArr2);
        zzc = zza(zztx.NIST_P256, zzuc.SHA256, zztj.COMPRESSED, zzcz.zza, zzvt.RAW, bArr2);
        zzd = zza(zztx.NIST_P256, zzuc.SHA256, zztj.UNCOMPRESSED, zzcz.zzb, zzvt.TINK, bArr2);
    }
}
