package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzah implements Iterator<zzaq> {
    private int zza = 0;
    private final /* synthetic */ zzaf zzb;

    public final /* synthetic */ Object next() {
        if (this.zza < this.zzb.zzb()) {
            zzaf zzaf = this.zzb;
            int i = this.zza;
            this.zza = i + 1;
            return zzaf.zza(i);
        }
        throw new NoSuchElementException("Out of bounds index: " + this.zza);
    }

    zzah(zzaf zzaf) {
        this.zzb = zzaf;
    }

    public final boolean hasNext() {
        return this.zza < this.zzb.zzb();
    }
}
