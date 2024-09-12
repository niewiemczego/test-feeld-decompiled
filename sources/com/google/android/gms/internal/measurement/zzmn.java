package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
public enum zzmn {
    DOUBLE(zzmx.DOUBLE, 1),
    FLOAT(zzmx.FLOAT, 5),
    INT64(zzmx.LONG, 0),
    UINT64(zzmx.LONG, 0),
    INT32(zzmx.INT, 0),
    FIXED64(zzmx.LONG, 1),
    FIXED32(zzmx.INT, 5),
    BOOL(zzmx.BOOLEAN, 0),
    STRING(zzmx.STRING, (zzmx) null),
    GROUP(zzmx.MESSAGE, (zzmx) null),
    MESSAGE(zzmx.MESSAGE, (zzmx) null),
    BYTES(zzmx.BYTE_STRING, (zzmx) null),
    UINT32(zzmx.INT, 0),
    ENUM(zzmx.ENUM, 0),
    SFIXED32(zzmx.INT, 5),
    SFIXED64(zzmx.LONG, 1),
    SINT32(zzmx.INT, 0),
    SINT64(zzmx.LONG, 0);
    
    private final zzmx zzt;
    private final int zzu;

    public final int zza() {
        return this.zzu;
    }

    public final zzmx zzb() {
        return this.zzt;
    }

    private zzmn(zzmx zzmx, int i) {
        this.zzt = zzmx;
        this.zzu = i;
    }
}
