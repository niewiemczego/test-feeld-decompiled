package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzahd;
import com.google.android.gms.internal.p002firebaseauthapi.zzahf;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahd  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public abstract class zzahd<MessageType extends zzahd<MessageType, BuilderType>, BuilderType extends zzahf<MessageType, BuilderType>> implements zzakk {
    protected int zza = 0;

    /* access modifiers changed from: package-private */
    public int zzh() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zza(zzalc zzalc) {
        int zzh = zzh();
        if (zzh != -1) {
            return zzh;
        }
        int zza2 = zzalc.zza(this);
        zzb(zza2);
        return zza2;
    }

    public final zzahm zzi() {
        try {
            zzahv zzc = zzahm.zzc(zzk());
            zza(zzc.zzb());
            return zzc.zza();
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a " + "ByteString" + " threw an IOException (should never happen).", e);
        }
    }

    /* access modifiers changed from: package-private */
    public void zzb(int i) {
        throw new UnsupportedOperationException();
    }

    public final void zza(OutputStream outputStream) throws IOException {
        zzaii zza2 = zzaii.zza(outputStream, zzaii.zzd(zzk()));
        zza(zza2);
        zza2.zzc();
    }

    public final byte[] zzj() {
        try {
            byte[] bArr = new byte[zzk()];
            zzaii zzb = zzaii.zzb(bArr);
            zza(zzb);
            zzb.zzb();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a " + "byte array" + " threw an IOException (should never happen).", e);
        }
    }
}
