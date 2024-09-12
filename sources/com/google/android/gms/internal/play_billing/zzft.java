package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzft implements zzga {
    private final zzga[] zza;

    zzft(zzga... zzgaArr) {
        this.zza = zzgaArr;
    }

    public final zzfz zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzga zzga = this.zza[i];
            if (zzga.zzc(cls)) {
                return zzga.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    public final boolean zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
