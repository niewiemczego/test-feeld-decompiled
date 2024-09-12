package com.google.android.gms.measurement;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zzhf;
import com.google.android.gms.measurement.internal.zzil;
import com.google.android.gms.measurement.internal.zzim;
import com.google.android.gms.measurement.internal.zziq;
import com.google.android.gms.measurement.internal.zznc;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zza extends AppMeasurement.zza {
    private final zzhf zza;
    private final zziq zzb;

    public final int zza(String str) {
        Preconditions.checkNotEmpty(str);
        return 25;
    }

    public final long zza() {
        return this.zza.zzt().zzm();
    }

    public final Boolean zzb() {
        return this.zzb.zzaa();
    }

    public final Double zzc() {
        return this.zzb.zzab();
    }

    public final Integer zzd() {
        return this.zzb.zzac();
    }

    public final Long zze() {
        return this.zzb.zzad();
    }

    public final Object zza(int i) {
        if (i == 0) {
            return zzj();
        }
        if (i == 1) {
            return zze();
        }
        if (i == 2) {
            return zzc();
        }
        if (i == 3) {
            return zzd();
        }
        if (i != 4) {
            return null;
        }
        return zzb();
    }

    public final String zzf() {
        return this.zzb.zzae();
    }

    public final String zzg() {
        return this.zzb.zzaf();
    }

    public final String zzh() {
        return this.zzb.zzag();
    }

    public final String zzi() {
        return this.zzb.zzae();
    }

    public final String zzj() {
        return this.zzb.zzai();
    }

    public final List<Bundle> zza(String str, String str2) {
        return this.zzb.zza(str, str2);
    }

    public final Map<String, Object> zza(boolean z) {
        List<zznc> zza2 = this.zzb.zza(z);
        ArrayMap arrayMap = new ArrayMap(zza2.size());
        for (zznc next : zza2) {
            Object zza3 = next.zza();
            if (zza3 != null) {
                arrayMap.put(next.zza, zza3);
            }
        }
        return arrayMap;
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        return this.zzb.zza(str, str2, z);
    }

    public zza(zzhf zzhf) {
        super();
        Preconditions.checkNotNull(zzhf);
        this.zza = zzhf;
        this.zzb = zzhf.zzp();
    }

    public final void zzb(String str) {
        this.zza.zze().zza(str, this.zza.zzb().elapsedRealtime());
    }

    public final void zza(String str, String str2, Bundle bundle) {
        this.zza.zzp().zza(str, str2, bundle);
    }

    public final void zzc(String str) {
        this.zza.zze().zzb(str, this.zza.zzb().elapsedRealtime());
    }

    public final void zzb(String str, String str2, Bundle bundle) {
        this.zzb.zzb(str, str2, bundle);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        this.zzb.zza(str, str2, bundle, true, false, j);
    }

    public final void zza(zzil zzil) {
        this.zzb.zza(zzil);
    }

    public final void zza(Bundle bundle) {
        this.zzb.zzb(bundle);
    }

    public final void zza(zzim zzim) {
        this.zzb.zza(zzim);
    }

    public final void zzb(zzil zzil) {
        this.zzb.zzb(zzil);
    }
}
