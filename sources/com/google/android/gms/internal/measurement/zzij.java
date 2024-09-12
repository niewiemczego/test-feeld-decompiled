package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
final class zzij implements zzmw {
    private final zzig zza;

    public static zzij zza(zzig zzig) {
        if (zzig.zza != null) {
            return zzig.zza;
        }
        return new zzij(zzig);
    }

    public final int zza() {
        return zzmz.zza;
    }

    private zzij(zzig zzig) {
        zzig zzig2 = (zzig) zziz.zza(zzig, "output");
        this.zza = zzig2;
        zzig2.zza = this;
    }

    public final void zza(int i, boolean z) throws IOException {
        this.zza.zza(i, z);
    }

    public final void zza(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzig.zza(list.get(i4).booleanValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    public final void zza(int i, zzhm zzhm) throws IOException {
        this.zza.zza(i, zzhm);
    }

    public final void zza(int i, List<zzhm> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zza(i, list.get(i2));
        }
    }

    public final void zza(int i, double d) throws IOException {
        this.zza.zzb(i, d);
    }

    public final void zzb(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzig.zza(list.get(i4).doubleValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    @Deprecated
    public final void zza(int i) throws IOException {
        this.zza.zzc(i, 4);
    }

    public final void zza(int i, int i2) throws IOException {
        this.zza.zzb(i, i2);
    }

    public final void zzc(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzig.zzd(list.get(i4).intValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzb(int i, int i2) throws IOException {
        this.zza.zza(i, i2);
    }

    public final void zzd(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzig.zze(list.get(i4).intValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zza(int i, long j) throws IOException {
        this.zza.zza(i, j);
    }

    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzig.zzc(list.get(i4).longValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zza(int i, float f) throws IOException {
        this.zza.zzb(i, f);
    }

    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzig.zza(list.get(i4).floatValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).floatValue());
            i2++;
        }
    }

    public final void zza(int i, Object obj, zzlb zzlb) throws IOException {
        zzig zzig = this.zza;
        zzig.zzc(i, 3);
        zzlb.zza((zzkj) obj, (zzmw) zzig.zza);
        zzig.zzc(i, 4);
    }

    public final void zza(int i, List<?> list, zzlb zzlb) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, (Object) list.get(i2), zzlb);
        }
    }

    public final void zzc(int i, int i2) throws IOException {
        this.zza.zzb(i, i2);
    }

    public final void zzg(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzig.zzf(list.get(i4).intValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzb(int i, long j) throws IOException {
        this.zza.zzb(i, j);
    }

    public final void zzh(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzig.zzd(list.get(i4).longValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final <K, V> void zza(int i, zzke<K, V> zzke, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.zza.zzc(i, 2);
            this.zza.zzc(zzkb.zza(zzke, next.getKey(), next.getValue()));
            zzkb.zza(this.zza, zzke, next.getKey(), next.getValue());
        }
    }

    public final void zzb(int i, Object obj, zzlb zzlb) throws IOException {
        this.zza.zza(i, (zzkj) obj, zzlb);
    }

    public final void zzb(int i, List<?> list, zzlb zzlb) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, (Object) list.get(i2), zzlb);
        }
    }

    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzhm) {
            this.zza.zzb(i, (zzhm) obj);
        } else {
            this.zza.zza(i, (zzkj) obj);
        }
    }

    public final void zzd(int i, int i2) throws IOException {
        this.zza.zza(i, i2);
    }

    public final void zzi(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzig.zzg(list.get(i4).intValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzc(int i, long j) throws IOException {
        this.zza.zza(i, j);
    }

    public final void zzj(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzig.zze(list.get(i4).longValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zza(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zze(int i, int i2) throws IOException {
        this.zza.zzk(i, i2);
    }

    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzig.zzh(list.get(i4).intValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zzk(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzk(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzd(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzig.zzf(list.get(i4).longValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zzh(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzh(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Deprecated
    public final void zzb(int i) throws IOException {
        this.zza.zzc(i, 3);
    }

    public final void zza(int i, String str) throws IOException {
        this.zza.zza(i, str);
    }

    public final void zzb(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzjp) {
            zzjp zzjp = (zzjp) list;
            while (i2 < list.size()) {
                Object zzb = zzjp.zzb(i2);
                if (zzb instanceof String) {
                    this.zza.zza(i, (String) zzb);
                } else {
                    this.zza.zza(i, (zzhm) zzb);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zza(i, list.get(i2));
            i2++;
        }
    }

    public final void zzf(int i, int i2) throws IOException {
        this.zza.zzd(i, i2);
    }

    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzig.zzj(list.get(i4).intValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zzc(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzd(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zze(int i, long j) throws IOException {
        this.zza.zzb(i, j);
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzc(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzig.zzg(list.get(i4).longValue());
            }
            this.zza.zzc(i3);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }
}
