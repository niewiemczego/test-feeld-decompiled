package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzil;
import com.google.android.gms.measurement.internal.zzim;
import com.google.android.gms.measurement.internal.zzjz;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzc extends AppMeasurement.zza {
    private final zzjz zza;

    public final int zza(String str) {
        return this.zza.zza(str);
    }

    public final long zza() {
        return this.zza.zza();
    }

    public final Boolean zzb() {
        return (Boolean) this.zza.zza(4);
    }

    public final Double zzc() {
        return (Double) this.zza.zza(2);
    }

    public final Integer zzd() {
        return (Integer) this.zza.zza(3);
    }

    public final Long zze() {
        return (Long) this.zza.zza(1);
    }

    public final Object zza(int i) {
        return this.zza.zza(i);
    }

    public final String zzf() {
        return this.zza.zzf();
    }

    public final String zzg() {
        return this.zza.zzg();
    }

    public final String zzh() {
        return this.zza.zzh();
    }

    public final String zzi() {
        return this.zza.zzi();
    }

    public final String zzj() {
        return (String) this.zza.zza(0);
    }

    public final List<Bundle> zza(String str, String str2) {
        return this.zza.zza(str, str2);
    }

    public final Map<String, Object> zza(boolean z) {
        return this.zza.zza((String) null, (String) null, z);
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        return this.zza.zza(str, str2, z);
    }

    public zzc(zzjz zzjz) {
        super();
        Preconditions.checkNotNull(zzjz);
        this.zza = zzjz;
    }

    public final void zzb(String str) {
        this.zza.zzb(str);
    }

    public final void zza(String str, String str2, Bundle bundle) {
        this.zza.zza(str, str2, bundle);
    }

    public final void zzc(String str) {
        this.zza.zzc(str);
    }

    public final void zzb(String str, String str2, Bundle bundle) {
        this.zza.zzb(str, str2, bundle);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        this.zza.zza(str, str2, bundle, j);
    }

    public final void zza(zzil zzil) {
        this.zza.zza(zzil);
    }

    public final void zza(Bundle bundle) {
        this.zza.zza(bundle);
    }

    public final void zza(zzim zzim) {
        this.zza.zza(zzim);
    }

    public final void zzb(zzil zzil) {
        this.zza.zzb(zzil);
    }
}
