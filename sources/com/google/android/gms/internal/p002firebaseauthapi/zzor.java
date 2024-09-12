package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakk;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzor  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzor<PrimitiveT, KeyProtoT extends zzakk, PublicKeyProtoT extends zzakk> extends zzml<PrimitiveT, KeyProtoT> implements zzcp<PrimitiveT> {
    private final zzoq<KeyProtoT, PublicKeyProtoT> zza;
    private final zznb<PublicKeyProtoT> zzb;

    public final zzux zzc(zzahm zzahm) throws GeneralSecurityException {
        try {
            KeyProtoT zza2 = this.zza.zza(zzahm);
            this.zza.zzb(zza2);
            PublicKeyProtoT zza3 = this.zza.zza(zza2);
            this.zzb.zzb(zza3);
            return (zzux) ((zzaja) zzux.zza().zza(this.zzb.zzd()).zza(zza3.zzi()).zza(this.zzb.zzc()).zzf());
        } catch (zzajj e) {
            throw new GeneralSecurityException("expected serialized proto of type ", e);
        }
    }

    public zzor(zzoq<KeyProtoT, PublicKeyProtoT> zzoq, zznb<PublicKeyProtoT> zznb, Class<PrimitiveT> cls) {
        super(zzoq, cls);
        this.zza = zzoq;
        this.zzb = zznb;
    }
}
