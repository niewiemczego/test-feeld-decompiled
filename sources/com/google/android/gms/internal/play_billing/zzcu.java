package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzcu implements Iterator {
    final /* synthetic */ zzcv zza;
    private int zzb = 0;

    zzcu(zzcv zzcv) {
        this.zza = zzcv;
    }

    public final boolean hasNext() {
        int i = this.zzb;
        zzcv zzcv = this.zza;
        return i < zzcv.zza() - zzcv.zzb();
    }

    public final Object next() {
        int i = this.zzb;
        zzcv zzcv = this.zza;
        if (i < zzcv.zza() - zzcv.zzb()) {
            zzcv zzcv2 = this.zza;
            Object obj = zzcv2.zzb.zzb[zzcv2.zzb() + i];
            this.zzb = i + 1;
            return obj;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
