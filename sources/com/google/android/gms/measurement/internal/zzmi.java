package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzmi {
    private final Clock zza;
    private long zzb;

    public zzmi(Clock clock) {
        Preconditions.checkNotNull(clock);
        this.zza = clock;
    }

    public final void zza() {
        this.zzb = 0;
    }

    public final void zzb() {
        this.zzb = this.zza.elapsedRealtime();
    }

    public final boolean zza(long j) {
        if (this.zzb != 0 && this.zza.elapsedRealtime() - this.zzb < DateUtils.MILLIS_PER_HOUR) {
            return false;
        }
        return true;
    }
}
