package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzakk;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzml  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
class zzml<PrimitiveT, KeyProtoT extends zzakk> implements zzbt<PrimitiveT> {
    private final zznb<KeyProtoT> zza;
    private final Class<PrimitiveT> zzb;

    public final zzux zza(zzahm zzahm) throws GeneralSecurityException {
        try {
            return (zzux) ((zzaja) zzux.zza().zza(this.zza.zzd()).zza(new zzmo(this.zza.zzb()).zza(zzahm).zzi()).zza(this.zza.zzc()).zzf());
        } catch (zzajj e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }

    public final Class<PrimitiveT> zza() {
        return this.zzb;
    }

    public final PrimitiveT zzb(zzahm zzahm) throws GeneralSecurityException {
        try {
            KeyProtoT zza2 = this.zza.zza(zzahm);
            if (!Void.class.equals(this.zzb)) {
                this.zza.zzb(zza2);
                return this.zza.zza(zza2, this.zzb);
            }
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        } catch (zzajj e) {
            throw new GeneralSecurityException("Failures parsing proto of type " + this.zza.zzf().getName(), e);
        }
    }

    public final String zzb() {
        return this.zza.zzd();
    }

    public zzml(zznb<KeyProtoT> zznb, Class<PrimitiveT> cls) {
        if (zznb.zzg().contains(cls) || Void.class.equals(cls)) {
            this.zza = zznb;
            this.zzb = cls;
            return;
        }
        throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", new Object[]{zznb.toString(), cls.getName()}));
    }
}
