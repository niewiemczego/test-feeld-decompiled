package com.google.android.gms.internal.p002firebaseauthapi;

import kotlin.text.Typography;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuc  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public enum zzuc implements zzajf {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA384(2),
    SHA256(3),
    SHA512(4),
    SHA224(5),
    UNRECOGNIZED(-1);
    
    private static final zzaje<zzuc> zzh = null;
    private final int zzj;

    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.zzj;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static zzuc zza(int i) {
        if (i == 0) {
            return UNKNOWN_HASH;
        }
        if (i == 1) {
            return SHA1;
        }
        if (i == 2) {
            return SHA384;
        }
        if (i == 3) {
            return SHA256;
        }
        if (i == 4) {
            return SHA512;
        }
        if (i != 5) {
            return null;
        }
        return SHA224;
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
        zzh = new zzub();
    }

    private zzuc(int i) {
        this.zzj = i;
    }
}
