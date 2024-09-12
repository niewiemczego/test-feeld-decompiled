package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public class zzba {
    private final String zza;
    private final Class zzb;
    private final boolean zzc;

    protected zzba(String str, Class cls, boolean z) {
        this(str, cls, z, true);
    }

    public static zzba zza(String str, Class cls) {
        return new zzba(str, cls, false, false);
    }

    public final String toString() {
        Class cls = this.zzb;
        String name = getClass().getName();
        String name2 = cls.getName();
        return name + "/" + this.zza + "[" + name2 + "]";
    }

    public final boolean zzb() {
        return this.zzc;
    }

    private zzba(String str, Class cls, boolean z, boolean z2) {
        zzda.zzb(str);
        this.zza = str;
        this.zzb = cls;
        this.zzc = z;
        System.identityHashCode(this);
        for (int i = 0; i < 5; i++) {
        }
    }
}
