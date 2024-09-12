package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public enum zzht {
    DOUBLE(zzhu.DOUBLE, 1),
    FLOAT(zzhu.FLOAT, 5),
    INT64(zzhu.LONG, 0),
    UINT64(zzhu.LONG, 0),
    INT32(zzhu.INT, 0),
    FIXED64(zzhu.LONG, 1),
    FIXED32(zzhu.INT, 5),
    BOOL(zzhu.BOOLEAN, 0),
    STRING(zzhu.STRING, 2),
    GROUP(zzhu.MESSAGE, 3),
    MESSAGE(zzhu.MESSAGE, 2),
    BYTES(zzhu.BYTE_STRING, 2),
    UINT32(zzhu.INT, 0),
    ENUM(zzhu.ENUM, 0),
    SFIXED32(zzhu.INT, 5),
    SFIXED64(zzhu.LONG, 1),
    SINT32(zzhu.INT, 0),
    SINT64(zzhu.LONG, 0);
    
    private final zzhu zzt;

    private zzht(zzhu zzhu, int i) {
        this.zzt = zzhu;
    }

    public final zzhu zza() {
        return this.zzt;
    }
}
