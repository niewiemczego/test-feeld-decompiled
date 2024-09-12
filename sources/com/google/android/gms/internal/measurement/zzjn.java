package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
public class zzjn {
    private static final zzik zza = zzik.zza;
    private zzhm zzb;
    private volatile zzkj zzc;
    private volatile zzhm zzd;

    public int hashCode() {
        return 1;
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zzb();
        }
        if (this.zzc != null) {
            return this.zzc.zzbw();
        }
        return 0;
    }

    public final zzhm zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                zzhm zzhm = this.zzd;
                return zzhm;
            }
            if (this.zzc == null) {
                this.zzd = zzhm.zza;
            } else {
                this.zzd = this.zzc.zzbu();
            }
            zzhm zzhm2 = this.zzd;
            return zzhm2;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.measurement.zzkj zzb(com.google.android.gms.internal.measurement.zzkj r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.measurement.zzkj r0 = r1.zzc
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.measurement.zzkj r0 = r1.zzc     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzc = r2     // Catch:{ zzji -> 0x0012 }
            com.google.android.gms.internal.measurement.zzhm r0 = com.google.android.gms.internal.measurement.zzhm.zza     // Catch:{ zzji -> 0x0012 }
            r1.zzd = r0     // Catch:{ zzji -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzc = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.measurement.zzhm r2 = com.google.android.gms.internal.measurement.zzhm.zza     // Catch:{ all -> 0x001a }
            r1.zzd = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.measurement.zzkj r2 = r1.zzc
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjn.zzb(com.google.android.gms.internal.measurement.zzkj):com.google.android.gms.internal.measurement.zzkj");
    }

    public final zzkj zza(zzkj zzkj) {
        zzkj zzkj2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzkj;
        return zzkj2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzjn)) {
            return false;
        }
        zzjn zzjn = (zzjn) obj;
        zzkj zzkj = this.zzc;
        zzkj zzkj2 = zzjn.zzc;
        if (zzkj == null && zzkj2 == null) {
            return zzc().equals(zzjn.zzc());
        }
        if (zzkj != null && zzkj2 != null) {
            return zzkj.equals(zzkj2);
        }
        if (zzkj != null) {
            return zzkj.equals(zzjn.zzb(zzkj.zzcf()));
        }
        return zzb(zzkj2.zzcf()).equals(zzkj2);
    }
}
