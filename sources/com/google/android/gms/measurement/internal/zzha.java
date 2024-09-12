package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzha implements Thread.UncaughtExceptionHandler {
    private final String zza;
    private final /* synthetic */ zzgy zzb;

    public zzha(zzgy zzgy, String str) {
        this.zzb = zzgy;
        Preconditions.checkNotNull(str);
        this.zza = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.zzb.zzj().zzg().zza(this.zza, th);
    }
}
