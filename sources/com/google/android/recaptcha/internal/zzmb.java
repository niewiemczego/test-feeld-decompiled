package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public enum zzmb {
    DOUBLE(zzmc.DOUBLE, 1),
    FLOAT(zzmc.FLOAT, 5),
    INT64(zzmc.LONG, 0),
    UINT64(zzmc.LONG, 0),
    INT32(zzmc.INT, 0),
    FIXED64(zzmc.LONG, 1),
    FIXED32(zzmc.INT, 5),
    BOOL(zzmc.BOOLEAN, 0),
    STRING(zzmc.STRING, 2),
    GROUP(zzmc.MESSAGE, 3),
    MESSAGE(zzmc.MESSAGE, 2),
    BYTES(zzmc.BYTE_STRING, 2),
    UINT32(zzmc.INT, 0),
    ENUM(zzmc.ENUM, 0),
    SFIXED32(zzmc.INT, 5),
    SFIXED64(zzmc.LONG, 1),
    SINT32(zzmc.INT, 0),
    SINT64(zzmc.LONG, 0);
    
    private final zzmc zzt;

    private zzmb(zzmc zzmc, int i) {
        this.zzt = zzmc;
    }

    public final zzmc zza() {
        return this.zzt;
    }
}
