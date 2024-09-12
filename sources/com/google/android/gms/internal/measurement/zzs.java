package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public enum zzs {
    DEBUG(3),
    ERROR(6),
    INFO(4),
    VERBOSE(2),
    WARN(5);
    
    private final int zzg;

    public static zzs zza(int i) {
        if (i == 2) {
            return VERBOSE;
        }
        if (i == 3) {
            return DEBUG;
        }
        if (i == 5) {
            return WARN;
        }
        if (i != 6) {
            return INFO;
        }
        return ERROR;
    }

    private zzs(int i) {
        this.zzg = i;
    }
}
