package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public class zzfi {
    private static final zzej zzb = zzej.zza;
    protected volatile zzgc zza;
    private volatile zzdw zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfi)) {
            return false;
        }
        zzfi zzfi = (zzfi) obj;
        zzgc zzgc = this.zza;
        zzgc zzgc2 = zzfi.zza;
        if (zzgc == null && zzgc2 == null) {
            return zzb().equals(zzfi.zzb());
        }
        if (zzgc != null && zzgc2 != null) {
            return zzgc.equals(zzgc2);
        }
        if (zzgc != null) {
            zzfi.zzc(zzgc.zzf());
            return zzgc.equals(zzfi.zza);
        }
        zzc(zzgc2.zzf());
        return this.zza.equals(zzgc2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzdt) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zze();
        }
        return 0;
    }

    public final zzdw zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzdw zzdw = this.zzc;
                return zzdw;
            }
            if (this.zza == null) {
                this.zzc = zzdw.zzb;
            } else {
                this.zzc = this.zza.zzb();
            }
            zzdw zzdw2 = this.zzc;
            return zzdw2;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.internal.play_billing.zzgc r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.play_billing.zzgc r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.play_billing.zzgc r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x000c:
            r1.zza = r2     // Catch:{ zzff -> 0x0013 }
            com.google.android.gms.internal.play_billing.zzdw r0 = com.google.android.gms.internal.play_billing.zzdw.zzb     // Catch:{ zzff -> 0x0013 }
            r1.zzc = r0     // Catch:{ zzff -> 0x0013 }
            goto L_0x0019
        L_0x0013:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.play_billing.zzdw r2 = com.google.android.gms.internal.play_billing.zzdw.zzb     // Catch:{ all -> 0x001b }
            r1.zzc = r2     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzfi.zzc(com.google.android.gms.internal.play_billing.zzgc):void");
    }
}
