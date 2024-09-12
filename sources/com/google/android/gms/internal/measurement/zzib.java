package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
public abstract class zzib {
    private static volatile int zzd = 100;
    int zza;
    int zzb;
    zzif zzc;
    private int zze;
    private boolean zzf;

    public static long zza(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int zze(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract double zza() throws IOException;

    public abstract int zza(int i) throws zzji;

    public abstract float zzb() throws IOException;

    public abstract void zzb(int i) throws zzji;

    public abstract int zzc();

    public abstract void zzc(int i);

    public abstract int zzd() throws IOException;

    public abstract boolean zzd(int i) throws IOException;

    public abstract int zze() throws IOException;

    public abstract int zzf() throws IOException;

    public abstract int zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract int zzi() throws IOException;

    public abstract int zzj() throws IOException;

    public abstract long zzk() throws IOException;

    public abstract long zzl() throws IOException;

    /* access modifiers changed from: package-private */
    public abstract long zzm() throws IOException;

    public abstract long zzn() throws IOException;

    public abstract long zzo() throws IOException;

    public abstract long zzp() throws IOException;

    public abstract zzhm zzq() throws IOException;

    public abstract String zzr() throws IOException;

    public abstract String zzs() throws IOException;

    public abstract boolean zzt() throws IOException;

    public abstract boolean zzu() throws IOException;

    static zzib zza(byte[] bArr, int i, int i2, boolean z) {
        zzia zzia = new zzia(bArr, i2);
        try {
            zzia.zza(i2);
            return zzia;
        } catch (zzji e) {
            throw new IllegalArgumentException(e);
        }
    }

    private zzib() {
        this.zzb = zzd;
        this.zze = Integer.MAX_VALUE;
        this.zzf = false;
    }
}
