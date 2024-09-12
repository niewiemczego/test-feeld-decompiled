package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
public enum zzhn {
    DOUBLE(zzho.DOUBLE, 1),
    FLOAT(zzho.FLOAT, 5),
    INT64(zzho.LONG, 0),
    UINT64(zzho.LONG, 0),
    INT32(zzho.INT, 0),
    FIXED64(zzho.LONG, 1),
    FIXED32(zzho.INT, 5),
    BOOL(zzho.BOOLEAN, 0),
    STRING(zzho.STRING, 2),
    GROUP(zzho.MESSAGE, 3),
    MESSAGE(zzho.MESSAGE, 2),
    BYTES(zzho.BYTE_STRING, 2),
    UINT32(zzho.INT, 0),
    ENUM(zzho.ENUM, 0),
    SFIXED32(zzho.INT, 5),
    SFIXED64(zzho.LONG, 1),
    SINT32(zzho.INT, 0),
    SINT64(zzho.LONG, 0);
    
    private final zzho zzt;

    private zzhn(zzho zzho, int i) {
        this.zzt = zzho;
    }

    public final zzho zza() {
        return this.zzt;
    }
}
