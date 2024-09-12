package com.google.android.gms.internal.p002firebaseauthapi;

import kotlin.text.Typography;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvt  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public enum zzvt implements zzajf {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);
    
    private static final zzaje<zzvt> zzg = null;
    private final int zzi;

    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.zzi;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static zzvt zza(int i) {
        if (i == 0) {
            return UNKNOWN_PREFIX;
        }
        if (i == 1) {
            return TINK;
        }
        if (i == 2) {
            return LEGACY;
        }
        if (i == 3) {
            return RAW;
        }
        if (i != 4) {
            return null;
        }
        return CRUNCHY;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)));
        if (this != UNRECOGNIZED) {
            sb.append(" number=").append(zza());
        }
        return sb.append(" name=").append(name()).append(Typography.greater).toString();
    }

    static {
        zzg = new zzvs();
    }

    private zzvt(int i) {
        this.zzi = i;
    }
}
