package com.android.billingclient.api;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zzbv {
    private boolean zza;

    private zzbv() {
    }

    /* synthetic */ zzbv(zzbu zzbu) {
    }

    public final zzbv zza() {
        this.zza = true;
        return this;
    }

    public final zzbx zzb() {
        if (this.zza) {
            return new zzbx(true, false, (zzbw) null);
        }
        throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
    }
}
