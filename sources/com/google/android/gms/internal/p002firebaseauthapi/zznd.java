package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzux;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zznd<P> implements zzbt<P> {
    private final String zza;
    private final Class<P> zzb;
    private final zzux.zzb zzc;
    private final zzakx<? extends zzakk> zzd;

    public static <P> zzbt<P> zza(String str, Class<P> cls, zzux.zzb zzb2, zzakx<? extends zzakk> zzakx) {
        return new zznd(str, cls, zzb2, zzakx);
    }

    public final zzux zza(zzahm zzahm) throws GeneralSecurityException {
        zzot zzot = (zzot) zznv.zza().zza(zznk.zza().zza(zznv.zza().zza(zzos.zza((zzvd) ((zzaja) zzvd.zza().zza(this.zza).zza(zzahm).zza(zzvt.RAW).zzf()))), (Integer) null), zzot.class, zzbr.zza());
        return (zzux) ((zzaja) zzux.zza().zza(zzot.zzf()).zza(zzot.zzd()).zza(zzot.zza()).zzf());
    }

    public final Class<P> zza() {
        return this.zzb;
    }

    public final P zzb(zzahm zzahm) throws GeneralSecurityException {
        return zzns.zza().zza(zznv.zza().zza(zzot.zza(this.zza, zzahm, this.zzc, zzvt.RAW, (Integer) null), zzbr.zza()), this.zzb);
    }

    public final String zzb() {
        return this.zza;
    }

    private zznd(String str, Class<P> cls, zzux.zzb zzb2, zzakx<? extends zzakk> zzakx) {
        this.zzd = zzakx;
        this.zza = str;
        this.zzb = cls;
        this.zzc = zzb2;
    }
}
