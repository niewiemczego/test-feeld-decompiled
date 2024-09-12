package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzaz {
    final String zza;
    final String zzb;
    final long zzc;
    final long zzd;
    final zzbb zze;
    private final String zzf;

    /* access modifiers changed from: package-private */
    public final zzaz zza(zzhf zzhf, long j) {
        return new zzaz(zzhf, this.zzf, this.zza, this.zzb, this.zzc, j, this.zze);
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        return "Event{appId='" + str + "', name='" + str2 + "', params=" + String.valueOf(this.zze) + "}";
    }

    zzaz(zzhf zzhf, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzbb zzbb;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        if (j2 != 0 && j2 > j) {
            zzhf.zzj().zzu().zza("Event created with reverse previous/current timestamps. appId", zzfr.zza(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzbb = new zzbb(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String str4 = (String) it.next();
                if (str4 == null) {
                    zzhf.zzj().zzg().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object zzb2 = zzhf.zzt().zzb(str4, bundle2.get(str4));
                    if (zzb2 == null) {
                        zzhf.zzj().zzu().zza("Param value can't be null", zzhf.zzk().zzb(str4));
                        it.remove();
                    } else {
                        zzhf.zzt().zza(bundle2, str4, zzb2);
                    }
                }
            }
            zzbb = new zzbb(bundle2);
        }
        this.zze = zzbb;
    }

    private zzaz(zzhf zzhf, String str, String str2, String str3, long j, long j2, zzbb zzbb) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzbb);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        if (j2 != 0 && j2 > j) {
            zzhf.zzj().zzu().zza("Event created with reverse previous/current timestamps. appId, name", zzfr.zza(str2), zzfr.zza(str3));
        }
        this.zze = zzbb;
    }
}
