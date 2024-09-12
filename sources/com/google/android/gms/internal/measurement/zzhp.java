package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
final class zzhp extends zzhr {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzhm zzc;

    public final byte zza() {
        int i = this.zza;
        if (i < this.zzb) {
            this.zza = i + 1;
            return this.zzc.zzb(i);
        }
        throw new NoSuchElementException();
    }

    zzhp(zzhm zzhm) {
        this.zzc = zzhm;
        this.zzb = zzhm.zzb();
    }

    public final boolean hasNext() {
        return this.zza < this.zzb;
    }
}
