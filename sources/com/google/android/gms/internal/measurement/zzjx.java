package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
final class zzjx implements zzle {
    private static final zzkk zza = new zzka();
    private final zzkk zzb;

    private static zzkk zza() {
        try {
            return (zzkk) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zza;
        }
    }

    public final <T> zzlb<T> zza(Class<T> cls) {
        zzld.zza((Class<?>) cls);
        zzkh zza2 = this.zzb.zza(cls);
        if (zza2.zzc()) {
            if (zzix.class.isAssignableFrom(cls)) {
                return zzkp.zza(zzld.zzb(), zzin.zzb(), zza2.zza());
            }
            return zzkp.zza(zzld.zza(), zzin.zza(), zza2.zza());
        } else if (zzix.class.isAssignableFrom(cls)) {
            if (zza(zza2)) {
                return zzkn.zza(cls, zza2, zzkt.zzb(), zzjs.zzb(), zzld.zzb(), zzin.zzb(), zzki.zzb());
            }
            return zzkn.zza(cls, zza2, zzkt.zzb(), zzjs.zzb(), zzld.zzb(), (zzim<?>) null, zzki.zzb());
        } else if (zza(zza2)) {
            return zzkn.zza(cls, zza2, zzkt.zza(), zzjs.zza(), zzld.zza(), zzin.zza(), zzki.zza());
        } else {
            return zzkn.zza(cls, zza2, zzkt.zza(), zzjs.zza(), zzld.zza(), (zzim<?>) null, zzki.zza());
        }
    }

    public zzjx() {
        this(new zzkc(zziy.zza(), zza()));
    }

    private zzjx(zzkk zzkk) {
        this.zzb = (zzkk) zziz.zza(zzkk, "messageInfoFactory");
    }

    private static boolean zza(zzkh zzkh) {
        return zzjz.zza[zzkh.zzb().ordinal()] != 1;
    }
}
