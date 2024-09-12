package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzew;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
abstract class zzac {
    String zza;
    int zzb;
    Boolean zzc;
    Boolean zzd;
    Long zze;
    Long zzf;

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0084, code lost:
        if (r2 != null) goto L_0x0086;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Boolean zza(java.math.BigDecimal r8, com.google.android.gms.internal.measurement.zzew.zzd r9, double r10) {
        /*
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r9)
            boolean r0 = r9.zzh()
            r1 = 0
            if (r0 == 0) goto L_0x0118
            com.google.android.gms.internal.measurement.zzew$zzd$zzb r0 = r9.zza()
            com.google.android.gms.internal.measurement.zzew$zzd$zzb r2 = com.google.android.gms.internal.measurement.zzew.zzd.zzb.UNKNOWN_COMPARISON_TYPE
            if (r0 != r2) goto L_0x0014
            goto L_0x0118
        L_0x0014:
            com.google.android.gms.internal.measurement.zzew$zzd$zzb r0 = r9.zza()
            com.google.android.gms.internal.measurement.zzew$zzd$zzb r2 = com.google.android.gms.internal.measurement.zzew.zzd.zzb.BETWEEN
            if (r0 != r2) goto L_0x0029
            boolean r0 = r9.zzl()
            if (r0 == 0) goto L_0x0028
            boolean r0 = r9.zzk()
            if (r0 != 0) goto L_0x0030
        L_0x0028:
            return r1
        L_0x0029:
            boolean r0 = r9.zzi()
            if (r0 != 0) goto L_0x0030
            return r1
        L_0x0030:
            com.google.android.gms.internal.measurement.zzew$zzd$zzb r0 = r9.zza()
            com.google.android.gms.internal.measurement.zzew$zzd$zzb r2 = r9.zza()
            com.google.android.gms.internal.measurement.zzew$zzd$zzb r3 = com.google.android.gms.internal.measurement.zzew.zzd.zzb.BETWEEN
            if (r2 != r3) goto L_0x0067
            java.lang.String r2 = r9.zzf()
            boolean r2 = com.google.android.gms.measurement.internal.zzmz.zzb((java.lang.String) r2)
            if (r2 == 0) goto L_0x0066
            java.lang.String r2 = r9.zze()
            boolean r2 = com.google.android.gms.measurement.internal.zzmz.zzb((java.lang.String) r2)
            if (r2 != 0) goto L_0x0051
            goto L_0x0066
        L_0x0051:
            java.math.BigDecimal r2 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0066 }
            java.lang.String r3 = r9.zzf()     // Catch:{ NumberFormatException -> 0x0066 }
            r2.<init>(r3)     // Catch:{ NumberFormatException -> 0x0066 }
            java.math.BigDecimal r3 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0066 }
            java.lang.String r9 = r9.zze()     // Catch:{ NumberFormatException -> 0x0066 }
            r3.<init>(r9)     // Catch:{ NumberFormatException -> 0x0066 }
            r9 = r2
            r2 = r1
            goto L_0x007d
        L_0x0066:
            return r1
        L_0x0067:
            java.lang.String r2 = r9.zzd()
            boolean r2 = com.google.android.gms.measurement.internal.zzmz.zzb((java.lang.String) r2)
            if (r2 != 0) goto L_0x0072
            return r1
        L_0x0072:
            java.math.BigDecimal r2 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0118 }
            java.lang.String r9 = r9.zzd()     // Catch:{ NumberFormatException -> 0x0118 }
            r2.<init>(r9)     // Catch:{ NumberFormatException -> 0x0118 }
            r9 = r1
            r3 = r9
        L_0x007d:
            com.google.android.gms.internal.measurement.zzew$zzd$zzb r4 = com.google.android.gms.internal.measurement.zzew.zzd.zzb.BETWEEN
            if (r0 != r4) goto L_0x0084
            if (r9 != 0) goto L_0x0086
            return r1
        L_0x0084:
            if (r2 == 0) goto L_0x0118
        L_0x0086:
            int[] r4 = com.google.android.gms.measurement.internal.zzw.zzb
            int r0 = r0.ordinal()
            r0 = r4[r0]
            r4 = 0
            r5 = 1
            if (r0 == r5) goto L_0x010a
            r6 = 2
            if (r0 == r6) goto L_0x00fc
            r7 = 3
            if (r0 == r7) goto L_0x00b2
            r10 = 4
            if (r0 == r10) goto L_0x009d
            goto L_0x0118
        L_0x009d:
            if (r9 != 0) goto L_0x00a0
            return r1
        L_0x00a0:
            int r9 = r8.compareTo(r9)
            if (r9 < 0) goto L_0x00ad
            int r8 = r8.compareTo(r3)
            if (r8 > 0) goto L_0x00ad
            r4 = r5
        L_0x00ad:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r4)
            return r8
        L_0x00b2:
            if (r2 == 0) goto L_0x0118
            r0 = 0
            int r9 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r9 == 0) goto L_0x00f0
            java.math.BigDecimal r9 = new java.math.BigDecimal
            r9.<init>(r10)
            java.math.BigDecimal r0 = new java.math.BigDecimal
            r0.<init>(r6)
            java.math.BigDecimal r9 = r9.multiply(r0)
            java.math.BigDecimal r9 = r2.subtract(r9)
            int r9 = r8.compareTo(r9)
            if (r9 <= 0) goto L_0x00eb
            java.math.BigDecimal r9 = new java.math.BigDecimal
            r9.<init>(r10)
            java.math.BigDecimal r10 = new java.math.BigDecimal
            r10.<init>(r6)
            java.math.BigDecimal r9 = r9.multiply(r10)
            java.math.BigDecimal r9 = r2.add(r9)
            int r8 = r8.compareTo(r9)
            if (r8 >= 0) goto L_0x00eb
            r4 = r5
        L_0x00eb:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r4)
            return r8
        L_0x00f0:
            int r8 = r8.compareTo(r2)
            if (r8 != 0) goto L_0x00f7
            r4 = r5
        L_0x00f7:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r4)
            return r8
        L_0x00fc:
            if (r2 == 0) goto L_0x0118
            int r8 = r8.compareTo(r2)
            if (r8 <= 0) goto L_0x0105
            r4 = r5
        L_0x0105:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r4)
            return r8
        L_0x010a:
            if (r2 == 0) goto L_0x0118
            int r8 = r8.compareTo(r2)
            if (r8 >= 0) goto L_0x0113
            r4 = r5
        L_0x0113:
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r4)
            return r8
        L_0x0118:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzac.zza(java.math.BigDecimal, com.google.android.gms.internal.measurement.zzew$zzd, double):java.lang.Boolean");
    }

    /* access modifiers changed from: package-private */
    public abstract int zza();

    /* access modifiers changed from: package-private */
    public abstract boolean zzb();

    /* access modifiers changed from: package-private */
    public abstract boolean zzc();

    static Boolean zza(String str, zzew.zzf zzf2, zzfr zzfr) {
        String str2;
        List<String> list;
        Preconditions.checkNotNull(zzf2);
        if (str == null || !zzf2.zzj() || zzf2.zzb() == zzew.zzf.zza.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        if (zzf2.zzb() == zzew.zzf.zza.IN_LIST) {
            if (zzf2.zza() == 0) {
                return null;
            }
        } else if (!zzf2.zzi()) {
            return null;
        }
        zzew.zzf.zza zzb2 = zzf2.zzb();
        boolean zzg = zzf2.zzg();
        if (zzg || zzb2 == zzew.zzf.zza.REGEXP || zzb2 == zzew.zzf.zza.IN_LIST) {
            str2 = zzf2.zze();
        } else {
            str2 = zzf2.zze().toUpperCase(Locale.ENGLISH);
        }
        String str3 = str2;
        if (zzf2.zza() == 0) {
            list = null;
        } else {
            List<String> zzf3 = zzf2.zzf();
            if (!zzg) {
                ArrayList arrayList = new ArrayList(zzf3.size());
                for (String upperCase : zzf3) {
                    arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
                }
                zzf3 = Collections.unmodifiableList(arrayList);
            }
            list = zzf3;
        }
        return zza(str, zzb2, zzg, str3, list, zzb2 == zzew.zzf.zza.REGEXP ? str3 : null, zzfr);
    }

    private static Boolean zza(String str, zzew.zzf.zza zza2, boolean z, String str2, List<String> list, String str3, zzfr zzfr) {
        if (str == null) {
            return null;
        }
        if (zza2 == zzew.zzf.zza.IN_LIST) {
            if (list == null || list.isEmpty()) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && zza2 != zzew.zzf.zza.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (zzw.zza[zza2.ordinal()]) {
            case 1:
                if (str3 == null) {
                    return null;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (zzfr != null) {
                        zzfr.zzu().zza("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                if (list == null) {
                    return null;
                }
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    static Boolean zza(double d, zzew.zzd zzd2) {
        try {
            return zza(new BigDecimal(d), zzd2, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zza(long j, zzew.zzd zzd2) {
        try {
            return zza(new BigDecimal(j), zzd2, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zza(String str, zzew.zzd zzd2) {
        if (!zzmz.zzb(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str), zzd2, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    zzac(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }
}
