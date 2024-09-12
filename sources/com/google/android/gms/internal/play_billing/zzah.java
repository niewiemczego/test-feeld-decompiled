package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zzah {
    Object[] zza = new Object[8];
    int zzb = 0;
    zzag zzc;

    public final zzah zza(Object obj, Object obj2) {
        int i = this.zzb + 1;
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            int i3 = length + (length >> 1) + 1;
            if (i3 < i2) {
                int highestOneBit = Integer.highestOneBit(i2 - 1);
                i3 = highestOneBit + highestOneBit;
            }
            if (i3 < 0) {
                i3 = Integer.MAX_VALUE;
            }
            this.zza = Arrays.copyOf(objArr, i3);
        }
        zzaa.zza(obj, obj2);
        Object[] objArr2 = this.zza;
        int i4 = this.zzb;
        int i5 = i4 + i4;
        objArr2[i5] = obj;
        objArr2[i5 + 1] = obj2;
        this.zzb = i4 + 1;
        return this;
    }

    public final zzai zzb() {
        zzag zzag = this.zzc;
        if (zzag == null) {
            zzaq zzf = zzaq.zzf(this.zzb, this.zza, this);
            zzag zzag2 = this.zzc;
            if (zzag2 == null) {
                return zzf;
            }
            throw zzag2.zza();
        }
        throw zzag.zza();
    }
}
