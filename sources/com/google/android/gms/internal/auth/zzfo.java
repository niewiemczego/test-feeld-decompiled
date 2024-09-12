package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzfo implements zzgi {
    private static final zzfu zza = new zzfm();
    private final zzfu zzb;

    public zzfo() {
        zzfu zzfu;
        zzfu[] zzfuArr = new zzfu[2];
        zzfuArr[0] = zzer.zza();
        try {
            zzfu = (zzfu) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzfu = zza;
        }
        zzfuArr[1] = zzfu;
        zzfn zzfn = new zzfn(zzfuArr);
        zzez.zzf(zzfn, "messageInfoFactory");
        this.zzb = zzfn;
    }

    private static boolean zzb(zzft zzft) {
        return zzft.zzc() == 1;
    }

    public final zzgh zza(Class cls) {
        zzgj.zzg(cls);
        zzft zzb2 = this.zzb.zzb(cls);
        if (zzb2.zzb()) {
            if (zzeu.class.isAssignableFrom(cls)) {
                return zzga.zzb(zzgj.zzc(), zzen.zzb(), zzb2.zza());
            }
            return zzga.zzb(zzgj.zza(), zzen.zza(), zzb2.zza());
        } else if (zzeu.class.isAssignableFrom(cls)) {
            if (zzb(zzb2)) {
                return zzfz.zzj(cls, zzb2, zzgc.zzb(), zzfk.zzd(), zzgj.zzc(), zzen.zzb(), zzfs.zzb());
            }
            return zzfz.zzj(cls, zzb2, zzgc.zzb(), zzfk.zzd(), zzgj.zzc(), (zzel) null, zzfs.zzb());
        } else if (zzb(zzb2)) {
            return zzfz.zzj(cls, zzb2, zzgc.zza(), zzfk.zzc(), zzgj.zza(), zzen.zza(), zzfs.zza());
        } else {
            return zzfz.zzj(cls, zzb2, zzgc.zza(), zzfk.zzc(), zzgj.zzb(), (zzel) null, zzfs.zza());
        }
    }
}
