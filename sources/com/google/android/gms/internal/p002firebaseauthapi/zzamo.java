package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzamo  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public enum zzamo {
    DOUBLE(zzamy.DOUBLE, 1),
    FLOAT(zzamy.FLOAT, 5),
    INT64(zzamy.LONG, 0),
    UINT64(zzamy.LONG, 0),
    INT32(zzamy.INT, 0),
    FIXED64(zzamy.LONG, 1),
    FIXED32(zzamy.INT, 5),
    BOOL(zzamy.BOOLEAN, 0),
    STRING(zzamy.STRING, (zzamy) null),
    GROUP(zzamy.MESSAGE, (zzamy) null),
    MESSAGE(zzamy.MESSAGE, (zzamy) null),
    BYTES(zzamy.BYTE_STRING, (zzamy) null),
    UINT32(zzamy.INT, 0),
    ENUM(zzamy.ENUM, 0),
    SFIXED32(zzamy.INT, 5),
    SFIXED64(zzamy.LONG, 1),
    SINT32(zzamy.INT, 0),
    SINT64(zzamy.LONG, 0);
    
    private final zzamy zzt;
    private final int zzu;

    public final int zza() {
        return this.zzu;
    }

    public final zzamy zzb() {
        return this.zzt;
    }

    private zzamo(zzamy zzamy, int i) {
        this.zzt = zzamy;
        this.zzu = i;
    }
}
