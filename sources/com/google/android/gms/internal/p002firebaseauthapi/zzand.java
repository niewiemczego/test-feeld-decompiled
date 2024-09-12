package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzand  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzand {
    private static final zzaly zza = ((zzaly) ((zzaja) zzaly.zzc().zza(-62135596800L).zza(0).zzf()));
    private static final zzaly zzb = ((zzaly) ((zzaja) zzaly.zzc().zza(253402300799L).zza(999999999).zzf()));
    private static final zzaly zzc = ((zzaly) ((zzaja) zzaly.zzc().zza(0).zza(0).zzf()));
    private static final ThreadLocal<SimpleDateFormat> zzd = new zzanc();
    @Nullable
    private static final Method zze = zzc("now");
    @Nullable
    private static final Method zzf = zzc("getEpochSecond");
    @Nullable
    private static final Method zzg = zzc("getNano");

    private static long zzb(String str) throws ParseException {
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            try {
                return ((Long.parseLong(str.substring(0, indexOf)) * 60) + Long.parseLong(str.substring(indexOf + 1))) * 60;
            } catch (NumberFormatException e) {
                ParseException parseException = new ParseException("Invalid offset value: " + str, 0);
                parseException.initCause(e);
                throw parseException;
            }
        } else {
            throw new ParseException("Invalid offset value: " + str, 0);
        }
    }

    public static long zza(zzaly zzaly) {
        return zzb(zzaly).zzb();
    }

    private static zzaly zzb(zzaly zzaly) {
        long zzb2 = zzaly.zzb();
        int zza2 = zzaly.zza();
        if (zzb2 >= -62135596800L && zzb2 <= 253402300799L && zza2 >= 0 && zza2 < 1000000000) {
            return zzaly;
        }
        throw new IllegalArgumentException(String.format("Timestamp is not valid. See proto definition for valid values. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. Nanos (%s) must be in range [0, +999,999,999].", new Object[]{Long.valueOf(zzb2), Integer.valueOf(zza2)}));
    }

    public static zzaly zza(String str) throws ParseException {
        String str2;
        int i;
        int indexOf = str.indexOf(84);
        if (indexOf != -1) {
            int indexOf2 = str.indexOf(90, indexOf);
            if (indexOf2 == -1) {
                indexOf2 = str.indexOf(43, indexOf);
            }
            if (indexOf2 == -1) {
                indexOf2 = str.indexOf(45, indexOf);
            }
            if (indexOf2 != -1) {
                String substring = str.substring(0, indexOf2);
                int indexOf3 = substring.indexOf(46);
                if (indexOf3 != -1) {
                    String substring2 = substring.substring(0, indexOf3);
                    str2 = substring.substring(indexOf3 + 1);
                    substring = substring2;
                } else {
                    str2 = "";
                }
                long time = zzd.get().parse(substring).getTime() / 1000;
                if (str2.isEmpty()) {
                    i = 0;
                } else {
                    i = 0;
                    for (int i2 = 0; i2 < 9; i2++) {
                        i *= 10;
                        if (i2 < str2.length()) {
                            if (str2.charAt(i2) < '0' || str2.charAt(i2) > '9') {
                                throw new ParseException("Invalid nanoseconds.", 0);
                            }
                            i += str2.charAt(i2) - '0';
                        }
                    }
                }
                if (str.charAt(indexOf2) != 'Z') {
                    long zzb2 = zzb(str.substring(indexOf2 + 1));
                    time = str.charAt(indexOf2) == '+' ? time - zzb2 : time + zzb2;
                } else if (str.length() != indexOf2 + 1) {
                    throw new ParseException("Failed to parse timestamp: invalid trailing data \"" + str.substring(indexOf2) + "\"", 0);
                }
                if (i <= -1000000000 || i >= 1000000000) {
                    try {
                        time = zzbf.zza(time, (long) (i / 1000000000));
                        i %= 1000000000;
                    } catch (IllegalArgumentException e) {
                        ParseException parseException = new ParseException("Failed to parse timestamp " + str + " Timestamp is out of range.", 0);
                        parseException.initCause(e);
                        throw parseException;
                    }
                }
                if (i < 0) {
                    i += 1000000000;
                    time = zzbf.zzb(time, 1);
                }
                return zzb((zzaly) ((zzaja) zzaly.zzc().zza(time).zza(i).zzf()));
            }
            throw new ParseException("Failed to parse timestamp: missing valid timezone offset.", 0);
        }
        throw new ParseException("Failed to parse timestamp: invalid timestamp \"" + str + "\"", 0);
    }

    @Nullable
    private static Method zzc(String str) {
        try {
            return Class.forName("java.time.Instant").getMethod(str, new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static /* synthetic */ SimpleDateFormat zza() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        simpleDateFormat.setCalendar(gregorianCalendar);
        return simpleDateFormat;
    }
}
