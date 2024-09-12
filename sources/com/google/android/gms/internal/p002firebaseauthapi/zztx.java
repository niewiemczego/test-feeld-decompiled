package com.google.android.gms.internal.p002firebaseauthapi;

import kotlin.text.Typography;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztx  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public enum zztx implements zzajf {
    UNKNOWN_CURVE(0),
    NIST_P256(2),
    NIST_P384(3),
    NIST_P521(4),
    CURVE25519(5),
    UNRECOGNIZED(-1);
    
    private static final zzaje<zztx> zzg = null;
    private final int zzi;

    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.zzi;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static zztx zza(int i) {
        if (i == 0) {
            return UNKNOWN_CURVE;
        }
        if (i == 2) {
            return NIST_P256;
        }
        if (i == 3) {
            return NIST_P384;
        }
        if (i == 4) {
            return NIST_P521;
        }
        if (i != 5) {
            return null;
        }
        return CURVE25519;
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
        zzg = new zztz();
    }

    private zztx(int i) {
        this.zzi = i;
    }
}
