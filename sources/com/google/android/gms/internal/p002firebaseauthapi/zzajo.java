package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class zzajo {
    private static final zzaip zza = zzaip.zza;
    private zzahm zzb;
    private volatile zzakk zzc;
    private volatile zzahm zzd;

    public int hashCode() {
        return 1;
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zzb();
        }
        if (this.zzc != null) {
            return this.zzc.zzk();
        }
        return 0;
    }

    public final zzahm zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                zzahm zzahm = this.zzd;
                return zzahm;
            }
            if (this.zzc == null) {
                this.zzd = zzahm.zza;
            } else {
                this.zzd = this.zzc.zzi();
            }
            zzahm zzahm2 = this.zzd;
            return zzahm2;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.p002firebaseauthapi.zzakk zzb(com.google.android.gms.internal.p002firebaseauthapi.zzakk r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.firebase-auth-api.zzakk r0 = r1.zzc
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.firebase-auth-api.zzakk r0 = r1.zzc     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzc = r2     // Catch:{ zzajj -> 0x0012 }
            com.google.android.gms.internal.firebase-auth-api.zzahm r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahm.zza     // Catch:{ zzajj -> 0x0012 }
            r1.zzd = r0     // Catch:{ zzajj -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzc = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.firebase-auth-api.zzahm r2 = com.google.android.gms.internal.p002firebaseauthapi.zzahm.zza     // Catch:{ all -> 0x001a }
            r1.zzd = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.firebase-auth-api.zzakk r2 = r1.zzc
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzajo.zzb(com.google.android.gms.internal.firebase-auth-api.zzakk):com.google.android.gms.internal.firebase-auth-api.zzakk");
    }

    public final zzakk zza(zzakk zzakk) {
        zzakk zzakk2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzakk;
        return zzakk2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzajo)) {
            return false;
        }
        zzajo zzajo = (zzajo) obj;
        zzakk zzakk = this.zzc;
        zzakk zzakk2 = zzajo.zzc;
        if (zzakk == null && zzakk2 == null) {
            return zzc().equals(zzajo.zzc());
        }
        if (zzakk != null && zzakk2 != null) {
            return zzakk.equals(zzakk2);
        }
        if (zzakk != null) {
            return zzakk.equals(zzajo.zzb(zzakk.zzr()));
        }
        return zzb(zzakk2.zzr()).equals(zzakk2);
    }
}
