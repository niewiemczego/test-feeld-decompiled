package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public final class zzck extends zzby {
    /* access modifiers changed from: private */
    public static final Set zza;
    /* access modifiers changed from: private */
    public static final zzbq zzb;
    private static final zzch zzc = new zzch((zzcg) null);
    private final String zzd;
    private final zzbd zze;
    private final Level zzf;
    private final Set zzg;
    private final zzbq zzh;

    static {
        Set unmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(new zzba[]{zzax.zza, zzbc.zza})));
        zza = unmodifiableSet;
        zzb = zzbt.zza(unmodifiableSet).zzd();
    }

    /* synthetic */ zzck(String str, String str2, boolean z, zzbd zzbd, Level level, Set set, zzbq zzbq, zzcj zzcj) {
        super(str2);
        if (str2.length() > 23) {
            int i = -1;
            int length = str2.length() - 1;
            while (true) {
                if (length < 0) {
                    break;
                }
                char charAt = str2.charAt(length);
                if (charAt == '.' || charAt == '$') {
                    i = length;
                } else {
                    length--;
                }
            }
            i = length;
            str2 = str2.substring(i + 1);
        }
        String concat = "".concat(String.valueOf(str2));
        this.zzd = concat.substring(0, Math.min(concat.length(), 23));
        this.zze = zzbd;
        this.zzf = level;
        this.zzg = set;
        this.zzh = zzbq;
    }

    public static zzch zzc() {
        return zzc;
    }
}
