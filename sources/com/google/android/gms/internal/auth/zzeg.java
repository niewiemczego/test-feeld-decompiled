package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzeg extends zzei {
    private final byte[] zzb;
    private int zzc;
    private int zzd;
    private int zze = Integer.MAX_VALUE;

    /* synthetic */ zzeg(byte[] bArr, int i, int i2, boolean z, zzef zzef) {
        super((zzeh) null);
        this.zzb = bArr;
        this.zzc = 0;
    }

    public final int zza(int i) throws zzfa {
        int i2 = this.zze;
        this.zze = 0;
        int i3 = this.zzc + this.zzd;
        this.zzc = i3;
        if (i3 > 0) {
            this.zzd = i3;
            this.zzc = i3 - i3;
        } else {
            this.zzd = 0;
        }
        return i2;
    }
}
