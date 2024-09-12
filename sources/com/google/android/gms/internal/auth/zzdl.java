package com.google.android.gms.internal.auth;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzdl implements zzdj {
    @CheckForNull
    volatile zzdj zza;
    volatile boolean zzb;
    @CheckForNull
    Object zzc;

    zzdl(zzdj zzdj) {
        zzdj.getClass();
        this.zza = zzdj;
    }

    public final String toString() {
        Object obj = this.zza;
        StringBuilder sb = new StringBuilder();
        sb.append("Suppliers.memoize(");
        if (obj == null) {
            obj = "<supplier that returned " + this.zzc + ">";
        }
        sb.append(obj);
        sb.append(")");
        return sb.toString();
    }

    public final Object zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    zzdj zzdj = this.zza;
                    zzdj.getClass();
                    Object zza2 = zzdj.zza();
                    this.zzc = zza2;
                    this.zzb = true;
                    this.zza = null;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
