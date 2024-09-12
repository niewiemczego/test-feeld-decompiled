package com.google.android.gms.internal.auth;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzdv extends zzdx {
    final /* synthetic */ zzee zza;
    private int zzb = 0;
    private final int zzc;

    zzdv(zzee zzee) {
        this.zza = zzee;
        this.zzc = zzee.zzd();
    }

    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    public final byte zza() {
        int i = this.zzb;
        if (i < this.zzc) {
            this.zzb = i + 1;
            return this.zza.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
