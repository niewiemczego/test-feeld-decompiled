package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzei {
    private final Object zza;
    private final int zzb;

    zzei(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzei)) {
            return false;
        }
        zzei zzei = (zzei) obj;
        if (this.zza == zzei.zza && this.zzb == zzei.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
