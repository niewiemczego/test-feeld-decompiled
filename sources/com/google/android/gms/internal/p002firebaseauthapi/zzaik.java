package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaik  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzaik implements zzanb {
    private final zzaii zza;

    public static zzaik zza(zzaii zzaii) {
        if (zzaii.zza != null) {
            return zzaii.zza;
        }
        return new zzaik(zzaii);
    }

    public final int zza() {
        return zzana.zza;
    }

    private zzaik(zzaii zzaii) {
        zzaii zzaii2 = (zzaii) zzajc.zza(zzaii, "output");
        this.zza = zzaii2;
        zzaii2.zza = this;
    }

    public final void zza(int i, boolean z) throws IOException {
        this.zza.zzb(i, z);
    }

    public final void zza(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzaii.zza(list.get(i4).booleanValue());
            }
            this.zza.zzl(i3);
            while (i2 < list.size()) {
                this.zza.zzb(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    public final void zza(int i, zzahm zzahm) throws IOException {
        this.zza.zzc(i, zzahm);
    }

    public final void zza(int i, List<zzahm> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zza.zzc(i, list.get(i2));
        }
    }

    public final void zza(int i, double d) throws IOException {
        this.zza.zzb(i, d);
    }

    public final void zzb(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzaii.zza(list.get(i4).doubleValue());
            }
            this.zza.zzl(i3);
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
        this.zza.zzj(i, 4);
    }

    public final void zza(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    public final void zzc(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzaii.zza(list.get(i4).intValue());
            }
            this.zza.zzl(i3);
            while (i2 < list.size()) {
                this.zza.zzj(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzh(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzb(int i, int i2) throws IOException {
        this.zza.zzg(i, i2);
    }

    public final void zzd(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzaii.zzb(list.get(i4).intValue());
            }
            this.zza.zzl(i3);
            while (i2 < list.size()) {
                this.zza.zzi(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zza(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzaii.zza(list.get(i4).longValue());
            }
            this.zza.zzl(i3);
            while (i2 < list.size()) {
                this.zza.zzf(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzf(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zza(int i, float f) throws IOException {
        this.zza.zzb(i, f);
    }

    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzaii.zza(list.get(i4).floatValue());
            }
            this.zza.zzl(i3);
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

    public final void zza(int i, Object obj, zzalc zzalc) throws IOException {
        zzaii zzaii = this.zza;
        zzaii.zzj(i, 3);
        zzalc.zza((zzakk) obj, (zzanb) zzaii.zza);
        zzaii.zzj(i, 4);
    }

    public final void zza(int i, List<?> list, zzalc zzalc) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, (Object) list.get(i2), zzalc);
        }
    }

    public final void zzc(int i, int i2) throws IOException {
        this.zza.zzh(i, i2);
    }

    public final void zzg(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzaii.zzc(list.get(i4).intValue());
            }
            this.zza.zzl(i3);
            while (i2 < list.size()) {
                this.zza.zzj(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzh(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzb(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    public final void zzh(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzaii.zzb(list.get(i4).longValue());
            }
            this.zza.zzl(i3);
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

    public final <K, V> void zza(int i, zzakf<K, V> zzakf, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.zza.zzj(i, 2);
            this.zza.zzl(zzakc.zza(zzakf, next.getKey(), next.getValue()));
            zzakc.zza(this.zza, zzakf, next.getKey(), next.getValue());
        }
    }

    public final void zzb(int i, Object obj, zzalc zzalc) throws IOException {
        this.zza.zzc(i, (zzakk) obj, zzalc);
    }

    public final void zzb(int i, List<?> list, zzalc zzalc) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, (Object) list.get(i2), zzalc);
        }
    }

    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzahm) {
            this.zza.zzd(i, (zzahm) obj);
        } else {
            this.zza.zzb(i, (zzakk) obj);
        }
    }

    public final void zzd(int i, int i2) throws IOException {
        this.zza.zzg(i, i2);
    }

    public final void zzi(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzaii.zze(list.get(i4).intValue());
            }
            this.zza.zzl(i3);
            while (i2 < list.size()) {
                this.zza.zzi(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzc(int i, long j) throws IOException {
        this.zza.zzf(i, j);
    }

    public final void zzj(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzaii.zzc(list.get(i4).longValue());
            }
            this.zza.zzl(i3);
            while (i2 < list.size()) {
                this.zza.zzf(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzf(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zze(int i, int i2) throws IOException {
        this.zza.zzi(i, i2);
    }

    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzaii.zzf(list.get(i4).intValue());
            }
            this.zza.zzl(i3);
            while (i2 < list.size()) {
                this.zza.zzk(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzi(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzd(int i, long j) throws IOException {
        this.zza.zzg(i, j);
    }

    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzaii.zzd(list.get(i4).longValue());
            }
            this.zza.zzl(i3);
            while (i2 < list.size()) {
                this.zza.zzg(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzg(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Deprecated
    public final void zzb(int i) throws IOException {
        this.zza.zzj(i, 3);
    }

    public final void zza(int i, String str) throws IOException {
        this.zza.zzb(i, str);
    }

    public final void zzb(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzajq) {
            zzajq zzajq = (zzajq) list;
            while (i2 < list.size()) {
                Object zzb = zzajq.zzb(i2);
                if (zzb instanceof String) {
                    this.zza.zzb(i, (String) zzb);
                } else {
                    this.zza.zzc(i, (zzahm) zzb);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzb(i, list.get(i2));
            i2++;
        }
    }

    public final void zzf(int i, int i2) throws IOException {
        this.zza.zzk(i, i2);
    }

    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzaii.zzh(list.get(i4).intValue());
            }
            this.zza.zzl(i3);
            while (i2 < list.size()) {
                this.zza.zzl(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zza.zzk(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zze(int i, long j) throws IOException {
        this.zza.zzh(i, j);
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zza.zzj(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzaii.zze(list.get(i4).longValue());
            }
            this.zza.zzl(i3);
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
}
