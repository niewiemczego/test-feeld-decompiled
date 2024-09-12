package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
final class zzjw implements zzks {
    private static final zzkc zza = new zzju();
    private final zzkc zzb;

    public zzjw() {
        zzkc zzkc;
        zzkc[] zzkcArr = new zzkc[2];
        zzkcArr[0] = zzim.zza();
        try {
            zzkc = (zzkc) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzkc = zza;
        }
        zzkcArr[1] = zzkc;
        zzjv zzjv = new zzjv(zzkcArr);
        byte[] bArr = zzjc.zzd;
        this.zzb = zzjv;
    }

    private static boolean zzb(zzkb zzkb) {
        return zzkb.zzc() + -1 != 1;
    }

    public final zzkr zza(Class cls) {
        zzkt.zzs(cls);
        zzkb zzb2 = this.zzb.zzb(cls);
        if (zzb2.zzb()) {
            if (zzit.class.isAssignableFrom(cls)) {
                return zzki.zzc(zzkt.zzn(), zzih.zzb(), zzb2.zza());
            }
            return zzki.zzc(zzkt.zzm(), zzih.zza(), zzb2.zza());
        } else if (zzit.class.isAssignableFrom(cls)) {
            if (zzb(zzb2)) {
                return zzkh.zzm(cls, zzb2, zzkl.zzb(), zzjs.zze(), zzkt.zzn(), zzih.zzb(), zzka.zzb());
            }
            return zzkh.zzm(cls, zzb2, zzkl.zzb(), zzjs.zze(), zzkt.zzn(), (zzif) null, zzka.zzb());
        } else if (zzb(zzb2)) {
            return zzkh.zzm(cls, zzb2, zzkl.zza(), zzjs.zzd(), zzkt.zzm(), zzih.zza(), zzka.zza());
        } else {
            return zzkh.zzm(cls, zzb2, zzkl.zza(), zzjs.zzd(), zzkt.zzm(), (zzif) null, zzka.zza());
        }
    }
}
