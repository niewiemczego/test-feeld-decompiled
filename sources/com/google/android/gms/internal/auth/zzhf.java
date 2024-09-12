package com.google.android.gms.internal.auth;

import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzhf extends zzhh {
    zzhf(Unsafe unsafe) {
        super(unsafe);
    }

    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(zzj(obj, j));
    }

    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(zzi(obj, j));
    }

    public final void zzc(Object obj, long j, boolean z) {
        if (zzhi.zza) {
            zzhi.zzi(obj, j, z);
        } else {
            zzhi.zzj(obj, j, z);
        }
    }

    public final void zzd(Object obj, long j, double d) {
        zzn(obj, j, Double.doubleToLongBits(d));
    }

    public final void zze(Object obj, long j, float f) {
        zzm(obj, j, Float.floatToIntBits(f));
    }

    public final boolean zzf(Object obj, long j) {
        if (zzhi.zza) {
            return zzhi.zzq(obj, j);
        }
        return zzhi.zzr(obj, j);
    }
}
