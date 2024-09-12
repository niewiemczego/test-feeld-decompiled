package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzdf;
import com.google.android.gms.internal.play_billing.zzdg;
import java.io.IOException;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public abstract class zzdg<MessageType extends zzdg<MessageType, BuilderType>, BuilderType extends zzdf<MessageType, BuilderType>> implements zzgc {
    protected int zza = 0;

    /* access modifiers changed from: package-private */
    public int zza(zzgm zzgm) {
        throw null;
    }

    public final zzdw zzb() {
        try {
            int zze = zze();
            zzdw zzdw = zzdw.zzb;
            byte[] bArr = new byte[zze];
            zzee zzz = zzee.zzz(bArr, 0, zze);
            zzr(zzz);
            zzz.zzA();
            return new zzdt(bArr);
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public final byte[] zzc() {
        try {
            int zze = zze();
            byte[] bArr = new byte[zze];
            zzee zzz = zzee.zzz(bArr, 0, zze);
            zzr(zzz);
            zzz.zzA();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a byte array threw an IOException (should never happen).", e);
        }
    }
}
