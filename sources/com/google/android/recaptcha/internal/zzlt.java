package com.google.android.recaptcha.internal;

import sun.misc.Unsafe;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzlt extends zzlu {
    zzlt(Unsafe unsafe) {
        super(unsafe);
    }

    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    public final void zzc(Object obj, long j, boolean z) {
        if (zzlv.zzb) {
            zzlv.zzD(obj, j, r3 ? (byte) 1 : 0);
        } else {
            zzlv.zzE(obj, j, r3 ? (byte) 1 : 0);
        }
    }

    public final void zzd(Object obj, long j, byte b) {
        if (zzlv.zzb) {
            zzlv.zzD(obj, j, b);
        } else {
            zzlv.zzE(obj, j, b);
        }
    }

    public final void zze(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    public final void zzf(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    public final boolean zzg(Object obj, long j) {
        if (zzlv.zzb) {
            return zzlv.zzt(obj, j);
        }
        return zzlv.zzu(obj, j);
    }
}
