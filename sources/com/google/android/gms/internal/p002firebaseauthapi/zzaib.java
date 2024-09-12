package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaib  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public abstract class zzaib {
    private static volatile int zze = 100;
    int zza;
    int zzb;
    int zzc;
    zzaig zzd;
    private boolean zzf;

    public static long zza(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int zze(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract double zza() throws IOException;

    public abstract int zza(int i) throws zzajj;

    public abstract float zzb() throws IOException;

    public abstract void zzb(int i) throws zzajj;

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

    public abstract zzahm zzq() throws IOException;

    public abstract String zzr() throws IOException;

    public abstract String zzs() throws IOException;

    public abstract boolean zzt() throws IOException;

    public abstract boolean zzu() throws IOException;

    static zzaib zza(byte[] bArr, int i, int i2, boolean z) {
        zzaia zzaia = new zzaia(bArr, i, i2, z);
        try {
            zzaia.zza(i2);
            return zzaia;
        } catch (zzajj e) {
            throw new IllegalArgumentException(e);
        }
    }

    private zzaib() {
        this.zzb = zze;
        this.zzc = Integer.MAX_VALUE;
        this.zzf = false;
    }
}
