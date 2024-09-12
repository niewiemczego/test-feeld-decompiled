package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public enum zzep {
    DOUBLE(0, 1, zzfg.DOUBLE),
    FLOAT(1, 1, zzfg.FLOAT),
    INT64(2, 1, zzfg.LONG),
    UINT64(3, 1, zzfg.LONG),
    INT32(4, 1, zzfg.INT),
    FIXED64(5, 1, zzfg.LONG),
    FIXED32(6, 1, zzfg.INT),
    BOOL(7, 1, zzfg.BOOLEAN),
    STRING(8, 1, zzfg.STRING),
    MESSAGE(9, 1, zzfg.MESSAGE),
    BYTES(10, 1, zzfg.BYTE_STRING),
    UINT32(11, 1, zzfg.INT),
    ENUM(12, 1, zzfg.ENUM),
    SFIXED32(13, 1, zzfg.INT),
    SFIXED64(14, 1, zzfg.LONG),
    SINT32(15, 1, zzfg.INT),
    SINT64(16, 1, zzfg.LONG),
    GROUP(17, 1, zzfg.MESSAGE),
    DOUBLE_LIST(18, 2, zzfg.DOUBLE),
    FLOAT_LIST(19, 2, zzfg.FLOAT),
    INT64_LIST(20, 2, zzfg.LONG),
    UINT64_LIST(21, 2, zzfg.LONG),
    INT32_LIST(22, 2, zzfg.INT),
    FIXED64_LIST(23, 2, zzfg.LONG),
    FIXED32_LIST(24, 2, zzfg.INT),
    BOOL_LIST(25, 2, zzfg.BOOLEAN),
    STRING_LIST(26, 2, zzfg.STRING),
    MESSAGE_LIST(27, 2, zzfg.MESSAGE),
    BYTES_LIST(28, 2, zzfg.BYTE_STRING),
    UINT32_LIST(29, 2, zzfg.INT),
    ENUM_LIST(30, 2, zzfg.ENUM),
    SFIXED32_LIST(31, 2, zzfg.INT),
    SFIXED64_LIST(32, 2, zzfg.LONG),
    SINT32_LIST(33, 2, zzfg.INT),
    SINT64_LIST(34, 2, zzfg.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzfg.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzfg.FLOAT),
    INT64_LIST_PACKED(37, 3, zzfg.LONG),
    UINT64_LIST_PACKED(38, 3, zzfg.LONG),
    INT32_LIST_PACKED(39, 3, zzfg.INT),
    FIXED64_LIST_PACKED(40, 3, zzfg.LONG),
    FIXED32_LIST_PACKED(41, 3, zzfg.INT),
    BOOL_LIST_PACKED(42, 3, zzfg.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzfg.INT),
    ENUM_LIST_PACKED(44, 3, zzfg.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzfg.INT),
    SFIXED64_LIST_PACKED(46, 3, zzfg.LONG),
    SINT32_LIST_PACKED(47, 3, zzfg.INT),
    SINT64_LIST_PACKED(48, 3, zzfg.LONG),
    GROUP_LIST(49, 2, zzfg.MESSAGE),
    MAP(50, 4, zzfg.VOID);
    
    private static final zzep[] zzZ = null;
    private final zzfg zzab;
    private final int zzac;
    private final Class zzad;

    static {
        zzZ = new zzep[r1];
        for (zzep zzep : values()) {
            zzZ[zzep.zzac] = zzep;
        }
    }

    private zzep(int i, int i2, zzfg zzfg) {
        this.zzac = i;
        this.zzab = zzfg;
        int i3 = i2 - 1;
        if (i3 == 1) {
            this.zzad = zzfg.zza();
        } else if (i3 != 3) {
            this.zzad = null;
        } else {
            this.zzad = zzfg.zza();
        }
        if (i2 == 1) {
            zzfg zzfg2 = zzfg.VOID;
            zzfg.ordinal();
        }
    }

    public final int zza() {
        return this.zzac;
    }
}
