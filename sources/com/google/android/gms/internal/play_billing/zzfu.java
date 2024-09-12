package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzfu implements zzgn {
    private static final zzga zza = new zzfs();
    private final zzga zzb;

    public zzfu() {
        zzga zzga;
        zzga[] zzgaArr = new zzga[2];
        zzgaArr[0] = zzes.zza();
        try {
            zzga = (zzga) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzga = zza;
        }
        zzgaArr[1] = zzga;
        zzft zzft = new zzft(zzgaArr);
        byte[] bArr = zzfd.zzd;
        this.zzb = zzft;
    }

    private static boolean zzb(zzfz zzfz) {
        return zzfz.zzc() + -1 != 1;
    }

    public final zzgm zza(Class cls) {
        zzgo.zzq(cls);
        zzfz zzb2 = this.zzb.zzb(cls);
        if (zzb2.zzb()) {
            if (zzex.class.isAssignableFrom(cls)) {
                return zzgg.zzc(zzgo.zzn(), zzem.zzb(), zzb2.zza());
            }
            return zzgg.zzc(zzgo.zzm(), zzem.zza(), zzb2.zza());
        } else if (zzex.class.isAssignableFrom(cls)) {
            if (zzb(zzb2)) {
                return zzgf.zzl(cls, zzb2, zzgi.zzb(), zzfq.zzd(), zzgo.zzn(), zzem.zzb(), zzfy.zzb());
            }
            return zzgf.zzl(cls, zzb2, zzgi.zzb(), zzfq.zzd(), zzgo.zzn(), (zzek) null, zzfy.zzb());
        } else if (zzb(zzb2)) {
            return zzgf.zzl(cls, zzb2, zzgi.zza(), zzfq.zzc(), zzgo.zzm(), zzem.zza(), zzfy.zza());
        } else {
            return zzgf.zzl(cls, zzb2, zzgi.zza(), zzfq.zzc(), zzgo.zzm(), (zzek) null, zzfy.zza());
        }
    }
}
