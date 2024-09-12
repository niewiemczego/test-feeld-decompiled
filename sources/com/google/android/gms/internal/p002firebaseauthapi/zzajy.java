package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajy  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzajy implements zzalf {
    private static final zzakl zza = new zzakb();
    private final zzakl zzb;

    private static zzakl zza() {
        try {
            return (zzakl) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zza;
        }
    }

    public final <T> zzalc<T> zza(Class<T> cls) {
        zzale.zza((Class<?>) cls);
        zzaki zza2 = this.zzb.zza(cls);
        if (zza2.zzc()) {
            if (zzaja.class.isAssignableFrom(cls)) {
                return zzakq.zza(zzale.zzb(), zzait.zzb(), zza2.zza());
            }
            return zzakq.zza(zzale.zza(), zzait.zza(), zza2.zza());
        } else if (zzaja.class.isAssignableFrom(cls)) {
            if (zza(zza2)) {
                return zzako.zza(cls, zza2, zzaku.zzb(), zzajt.zzb(), zzale.zzb(), zzait.zzb(), zzakj.zzb());
            }
            return zzako.zza(cls, zza2, zzaku.zzb(), zzajt.zzb(), zzale.zzb(), (zzair<?>) null, zzakj.zzb());
        } else if (zza(zza2)) {
            return zzako.zza(cls, zza2, zzaku.zza(), zzajt.zza(), zzale.zza(), zzait.zza(), zzakj.zza());
        } else {
            return zzako.zza(cls, zza2, zzaku.zza(), zzajt.zza(), zzale.zza(), (zzair<?>) null, zzakj.zza());
        }
    }

    public zzajy() {
        this(new zzakd(zzajb.zza(), zza()));
    }

    private zzajy(zzakl zzakl) {
        this.zzb = (zzakl) zzajc.zza(zzakl, "messageInfoFactory");
    }

    private static boolean zza(zzaki zzaki) {
        return zzaka.zza[zzaki.zzb().ordinal()] != 1;
    }
}
