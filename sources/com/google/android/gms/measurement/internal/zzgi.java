package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzgi {
    private final String zza;
    private final long zzb;
    private boolean zzc;
    private long zzd;
    private final /* synthetic */ zzgd zze;

    public final long zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zze.zzc().getLong(this.zza, this.zzb);
        }
        return this.zzd;
    }

    public zzgi(zzgd zzgd, String str, long j) {
        this.zze = zzgd;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = j;
    }

    public final void zza(long j) {
        SharedPreferences.Editor edit = this.zze.zzc().edit();
        edit.putLong(this.zza, j);
        edit.apply();
        this.zzd = j;
    }
}
