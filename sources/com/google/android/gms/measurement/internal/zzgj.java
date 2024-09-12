package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzgj {
    private final String zza;
    private final String zzb = null;
    private boolean zzc;
    private String zzd;
    private final /* synthetic */ zzgd zze;

    public final String zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zze.zzc().getString(this.zza, (String) null);
        }
        return this.zzd;
    }

    public zzgj(zzgd zzgd, String str, String str2) {
        this.zze = zzgd;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
    }

    public final void zza(String str) {
        SharedPreferences.Editor edit = this.zze.zzc().edit();
        edit.putString(this.zza, str);
        edit.apply();
        this.zzd = str;
    }
}
