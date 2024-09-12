package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
enum zzaj {
    UNSET('0'),
    REMOTE_DEFAULT('1'),
    REMOTE_DELEGATION('2'),
    MANIFEST('3'),
    INITIALIZATION('4'),
    API('5'),
    CHILD_ACCOUNT('6'),
    FAILSAFE('9');
    
    /* access modifiers changed from: private */
    public final char zzj;

    public static zzaj zza(char c) {
        for (zzaj zzaj : values()) {
            if (zzaj.zzj == c) {
                return zzaj;
            }
        }
        return UNSET;
    }

    private zzaj(char c) {
        this.zzj = c;
    }
}
