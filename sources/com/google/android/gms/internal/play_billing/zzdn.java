package com.google.android.gms.internal.play_billing;

import java.util.NoSuchElementException;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzdn extends zzdp {
    final /* synthetic */ zzdw zza;
    private int zzb = 0;
    private final int zzc;

    zzdn(zzdw zzdw) {
        this.zza = zzdw;
        this.zzc = zzdw.zzd();
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
