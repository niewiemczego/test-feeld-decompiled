package com.google.android.gms.internal.play_billing;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzcv extends AbstractSet {
    final int zza = -1;
    final /* synthetic */ zzcw zzb;

    zzcv(zzcw zzcw, int i) {
        this.zzb = zzcw;
    }

    public final boolean contains(Object obj) {
        Comparator comparator;
        int i = this.zza;
        Object[] zzc = this.zzb.zzb;
        int zzb2 = zzb();
        int zza2 = zza();
        if (i == -1) {
            comparator = zzcw.zza;
        } else {
            comparator = zzcy.zza;
        }
        return Arrays.binarySearch(zzc, zzb2, zza2, obj, comparator) >= 0;
    }

    public final Iterator iterator() {
        return new zzcu(this);
    }

    public final int size() {
        return zza() - zzb();
    }

    /* access modifiers changed from: package-private */
    public final int zza() {
        return this.zzb.zzc[this.zza + 1];
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        if (this.zza == -1) {
            return 0;
        }
        return this.zzb.zzc[0];
    }
}
