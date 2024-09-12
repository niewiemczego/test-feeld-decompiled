package com.google.android.recaptcha.internal;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzgn extends zzgp {
    final /* synthetic */ zzgw zza;
    private int zzb = 0;
    private final int zzc;

    zzgn(zzgw zzgw) {
        this.zza = zzgw;
        this.zzc = zzgw.zzd();
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
