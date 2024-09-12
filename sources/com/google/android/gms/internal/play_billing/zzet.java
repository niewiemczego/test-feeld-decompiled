package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzet;
import com.google.android.gms.internal.play_billing.zzex;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public class zzet<MessageType extends zzex<MessageType, BuilderType>, BuilderType extends zzet<MessageType, BuilderType>> extends zzdf<MessageType, BuilderType> {
    protected zzex zza;
    private final zzex zzb;

    protected zzet(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzt()) {
            this.zza = messagetype.zzi();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    /* renamed from: zzb */
    public final zzet zza() {
        zzet zzet = (zzet) this.zzb.zzu(5, (Object) null, (Object) null);
        zzet.zza = zze();
        return zzet;
    }

    public final MessageType zzc() {
        MessageType zzd = zze();
        if (zzd.zzs()) {
            return zzd;
        }
        throw new zzhc(zzd);
    }

    /* renamed from: zzd */
    public MessageType zze() {
        if (!this.zza.zzt()) {
            return this.zza;
        }
        this.zza.zzn();
        return this.zza;
    }

    public final /* bridge */ /* synthetic */ zzgc zzf() {
        throw null;
    }

    /* access modifiers changed from: protected */
    public final void zzg() {
        if (!this.zza.zzt()) {
            zzh();
        }
    }

    /* access modifiers changed from: protected */
    public void zzh() {
        zzex zzi = this.zzb.zzi();
        zzgk.zza().zzb(zzi.getClass()).zzg(zzi, this.zza);
        this.zza = zzi;
    }
}
