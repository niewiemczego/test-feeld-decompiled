package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.annotation.Nullable;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzmg {
    public static final zzlj zza;
    public static final zzlj zzb;
    public static final zzlj zzc;
    private static final ThreadLocal zzd = new zzmf();
    @Nullable
    private static final Method zze = zzd("now");
    @Nullable
    private static final Method zzf = zzd("getEpochSecond");
    @Nullable
    private static final Method zzg = zzd("getNano");

    static {
        zzli zzi = zzlj.zzi();
        zzi.zze(-62135596800L);
        zzi.zzd(0);
        zza = (zzlj) zzi.zzj();
        zzli zzi2 = zzlj.zzi();
        zzi2.zze(253402300799L);
        zzi2.zzd(999999999);
        zzb = (zzlj) zzi2.zzj();
        zzli zzi3 = zzlj.zzi();
        zzi3.zze(0);
        zzi3.zzd(0);
        zzc = (zzlj) zzi3.zzj();
    }

    public static zzlj zza(zzlj zzlj) {
        long zzg2 = zzlj.zzg();
        int i = (zzg2 > -62135596800L ? 1 : (zzg2 == -62135596800L ? 0 : -1));
        int zzf2 = zzlj.zzf();
        if (i >= 0 && zzg2 <= 253402300799L && zzf2 >= 0 && zzf2 < 1000000000) {
            return zzlj;
        }
        throw new IllegalArgumentException(String.format("Timestamp is not valid. See proto definition for valid values. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. Nanos (%s) must be in range [0, +999,999,999].", new Object[]{Long.valueOf(zzg2), Integer.valueOf(zzf2)}));
    }

    public static zzlj zzb(long j) {
        int i = (int) ((j % 1000) * 1000000);
        long j2 = j / 1000;
        if (i <= -1000000000 || i >= 1000000000) {
            j2 = zzgb.zza(j2, (long) (i / 1000000000));
            i %= 1000000000;
        }
        if (i < 0) {
            i += 1000000000;
            j2 = zzgb.zzb(j2, 1);
        }
        zzli zzi = zzlj.zzi();
        zzi.zze(j2);
        zzi.zzd(i);
        zzlj zzlj = (zzlj) zzi.zzj();
        zza(zzlj);
        return zzlj;
    }

    public static String zzc(zzlj zzlj) {
        String str;
        zza(zzlj);
        long zzg2 = zzlj.zzg();
        int zzf2 = zzlj.zzf();
        StringBuilder sb = new StringBuilder();
        sb.append(((SimpleDateFormat) zzd.get()).format(new Date(zzg2 * 1000)));
        if (zzf2 != 0) {
            sb.append(".");
            if (zzf2 % 1000000 == 0) {
                str = String.format(Locale.ENGLISH, "%1$03d", new Object[]{Integer.valueOf(zzf2 / 1000000)});
            } else if (zzf2 % 1000 == 0) {
                str = String.format(Locale.ENGLISH, "%1$06d", new Object[]{Integer.valueOf(zzf2 / 1000)});
            } else {
                str = String.format(Locale.ENGLISH, "%1$09d", new Object[]{Integer.valueOf(zzf2)});
            }
            sb.append(str);
        }
        sb.append("Z");
        return sb.toString();
    }

    @Nullable
    private static Method zzd(String str) {
        try {
            return Class.forName("java.time.Instant").getMethod(str, new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
