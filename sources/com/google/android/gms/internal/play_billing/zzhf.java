package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzhf extends zzhd {
    zzhf() {
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zza(Object obj) {
        return ((zzhe) obj).zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzb(Object obj) {
        return ((zzhe) obj).zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zzc(Object obj) {
        zzex zzex = (zzex) obj;
        zzhe zzhe = zzex.zzc;
        if (zzhe != zzhe.zzc()) {
            return zzhe;
        }
        zzhe zzf = zzhe.zzf();
        zzex.zzc = zzf;
        return zzf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzd(Object obj) {
        return ((zzex) obj).zzc;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        if (zzhe.zzc().equals(obj2)) {
            return obj;
        }
        if (zzhe.zzc().equals(obj)) {
            return zzhe.zze((zzhe) obj, (zzhe) obj2);
        }
        ((zzhe) obj).zzd((zzhe) obj2);
        return obj;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zzf(Object obj, int i, long j) {
        ((zzhe) obj).zzj(i << 3, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final void zzg(Object obj) {
        ((zzex) obj).zzc.zzh();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(Object obj, Object obj2) {
        ((zzex) obj).zzc = (zzhe) obj2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(Object obj, zzhv zzhv) throws IOException {
        ((zzhe) obj).zzk(zzhv);
    }
}
