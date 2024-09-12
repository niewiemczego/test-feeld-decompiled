package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
final class zzmc extends zzma<zzlz, zzlz> {
    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zza(Object obj) {
        return ((zzlz) obj).zza();
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzlc zzlc) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzb(Object obj) {
        return ((zzlz) obj).zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(Object obj) {
        zzlz zzlz = ((zzix) obj).zzb;
        if (zzlz != zzlz.zzc()) {
            return zzlz;
        }
        zzlz zzd = zzlz.zzd();
        zza(obj, zzd);
        return zzd;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzd(Object obj) {
        return ((zzix) obj).zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(Object obj, Object obj2) {
        zzlz zzlz = (zzlz) obj;
        zzlz zzlz2 = (zzlz) obj2;
        if (zzlz.zzc().equals(zzlz2)) {
            return zzlz;
        }
        if (zzlz.zzc().equals(zzlz)) {
            return zzlz.zza(zzlz, zzlz2);
        }
        return zzlz.zza(zzlz2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza() {
        return zzlz.zzd();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zze(Object obj) {
        zzlz zzlz = (zzlz) obj;
        zzlz.zze();
        return zzlz;
    }

    zzmc() {
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, int i2) {
        ((zzlz) obj).zza((i << 3) | 5, (Object) Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzlz) obj).zza((i << 3) | 1, (Object) Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, Object obj2) {
        ((zzlz) obj).zza((i << 3) | 3, (Object) (zzlz) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, zzhm zzhm) {
        ((zzlz) obj).zza((i << 3) | 2, (Object) zzhm);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzlz) obj).zza(i << 3, (Object) Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final void zzf(Object obj) {
        ((zzix) obj).zzb.zze();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, Object obj2) {
        zza(obj, (zzlz) obj2);
    }

    private static void zza(Object obj, zzlz zzlz) {
        ((zzix) obj).zzb = zzlz;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Object obj, Object obj2) {
        zza(obj, (zzlz) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, zzmw zzmw) throws IOException {
        ((zzlz) obj).zza(zzmw);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, zzmw zzmw) throws IOException {
        ((zzlz) obj).zzb(zzmw);
    }
}
