package com.google.android.recaptcha.internal;

import kotlin.comparisons.ComparisonsKt;
import kotlin.text.StringsKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzu implements Comparable {
    private int zza;
    private long zzb;
    private long zzc;

    public final String toString() {
        String padEnd$default = StringsKt.padEnd$default(String.valueOf(this.zzb / ((long) this.zza)), 10, 0, 2, (Object) null);
        String padEnd$default2 = StringsKt.padEnd$default(String.valueOf(this.zzc), 10, 0, 2, (Object) null);
        String padEnd$default3 = StringsKt.padEnd$default(String.valueOf(this.zzb), 10, 0, 2, (Object) null);
        String padEnd$default4 = StringsKt.padEnd$default(String.valueOf(this.zza), 5, 0, 2, (Object) null);
        return "avgExecutionTime: " + padEnd$default + " us| maxExecutionTime: " + padEnd$default2 + " us| totalTime: " + padEnd$default3 + " us| #Usages: " + padEnd$default4;
    }

    /* renamed from: zza */
    public final int compareTo(zzu zzu) {
        return ComparisonsKt.compareValues(Long.valueOf(this.zzb), Long.valueOf(zzu.zzb));
    }

    public final int zzb() {
        return this.zza;
    }

    public final long zzc() {
        return this.zzc;
    }

    public final long zzd() {
        return this.zzb;
    }

    public final void zze(long j) {
        this.zzc = j;
    }

    public final void zzf(long j) {
        this.zzb = j;
    }

    public final void zzg(int i) {
        this.zza = i;
    }
}
