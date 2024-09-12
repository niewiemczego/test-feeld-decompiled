package com.google.android.recaptcha.internal;

import com.braze.Constants;
import io.sentry.protocol.MetricSummary;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzfh {
    private final zzfk zza = zzfk.zza();
    private boolean zzb;
    private long zzc;
    private long zzd;

    zzfh() {
    }

    public static zzfh zzb() {
        zzfh zzfh = new zzfh();
        zzfh.zze();
        return zzfh;
    }

    public static zzfh zzc() {
        return new zzfh();
    }

    private final long zzg() {
        return this.zzb ? (System.nanoTime() - this.zzd) + this.zzc : this.zzc;
    }

    public final String toString() {
        TimeUnit timeUnit;
        String str;
        long zzg = zzg();
        if (TimeUnit.DAYS.convert(zzg, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.DAYS;
        } else if (TimeUnit.HOURS.convert(zzg, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.HOURS;
        } else if (TimeUnit.MINUTES.convert(zzg, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.MINUTES;
        } else if (TimeUnit.SECONDS.convert(zzg, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.SECONDS;
        } else if (TimeUnit.MILLISECONDS.convert(zzg, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.MILLISECONDS;
        } else if (TimeUnit.MICROSECONDS.convert(zzg, TimeUnit.NANOSECONDS) > 0) {
            timeUnit = TimeUnit.MICROSECONDS;
        } else {
            timeUnit = TimeUnit.NANOSECONDS;
        }
        String format = String.format(Locale.ROOT, "%.4g", new Object[]{Double.valueOf(((double) zzg) / ((double) TimeUnit.NANOSECONDS.convert(1, timeUnit)))});
        switch (zzfg.zza[timeUnit.ordinal()]) {
            case 1:
                str = "ns";
                break;
            case 2:
                str = "μs";
                break;
            case 3:
                str = "ms";
                break;
            case 4:
                str = Constants.BRAZE_PUSH_SUMMARY_TEXT_KEY;
                break;
            case 5:
                str = MetricSummary.JsonKeys.MIN;
                break;
            case 6:
                str = "h";
                break;
            case 7:
                str = Constants.BRAZE_PUSH_NOTIFICATION_SOUND_DEFAULT_VALUE;
                break;
            default:
                throw new AssertionError();
        }
        return format + " " + str;
    }

    public final long zza(TimeUnit timeUnit) {
        return timeUnit.convert(zzg(), TimeUnit.NANOSECONDS);
    }

    public final zzfh zzd() {
        this.zzc = 0;
        this.zzb = false;
        return this;
    }

    public final zzfh zze() {
        zzff.zze(!this.zzb, "This stopwatch is already running.");
        this.zzb = true;
        this.zzd = System.nanoTime();
        return this;
    }

    public final zzfh zzf() {
        long nanoTime = System.nanoTime();
        zzff.zze(this.zzb, "This stopwatch is already stopped.");
        this.zzb = false;
        this.zzc += nanoTime - this.zzd;
        return this;
    }
}
