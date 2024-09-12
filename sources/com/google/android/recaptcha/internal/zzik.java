package com.google.android.recaptcha.internal;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public enum zzik {
    DOUBLE(0, 1, zzjf.DOUBLE),
    FLOAT(1, 1, zzjf.FLOAT),
    INT64(2, 1, zzjf.LONG),
    UINT64(3, 1, zzjf.LONG),
    INT32(4, 1, zzjf.INT),
    FIXED64(5, 1, zzjf.LONG),
    FIXED32(6, 1, zzjf.INT),
    BOOL(7, 1, zzjf.BOOLEAN),
    STRING(8, 1, zzjf.STRING),
    MESSAGE(9, 1, zzjf.MESSAGE),
    BYTES(10, 1, zzjf.BYTE_STRING),
    UINT32(11, 1, zzjf.INT),
    ENUM(12, 1, zzjf.ENUM),
    SFIXED32(13, 1, zzjf.INT),
    SFIXED64(14, 1, zzjf.LONG),
    SINT32(15, 1, zzjf.INT),
    SINT64(16, 1, zzjf.LONG),
    GROUP(17, 1, zzjf.MESSAGE),
    DOUBLE_LIST(18, 2, zzjf.DOUBLE),
    FLOAT_LIST(19, 2, zzjf.FLOAT),
    INT64_LIST(20, 2, zzjf.LONG),
    UINT64_LIST(21, 2, zzjf.LONG),
    INT32_LIST(22, 2, zzjf.INT),
    FIXED64_LIST(23, 2, zzjf.LONG),
    FIXED32_LIST(24, 2, zzjf.INT),
    BOOL_LIST(25, 2, zzjf.BOOLEAN),
    STRING_LIST(26, 2, zzjf.STRING),
    MESSAGE_LIST(27, 2, zzjf.MESSAGE),
    BYTES_LIST(28, 2, zzjf.BYTE_STRING),
    UINT32_LIST(29, 2, zzjf.INT),
    ENUM_LIST(30, 2, zzjf.ENUM),
    SFIXED32_LIST(31, 2, zzjf.INT),
    SFIXED64_LIST(32, 2, zzjf.LONG),
    SINT32_LIST(33, 2, zzjf.INT),
    SINT64_LIST(34, 2, zzjf.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzjf.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzjf.FLOAT),
    INT64_LIST_PACKED(37, 3, zzjf.LONG),
    UINT64_LIST_PACKED(38, 3, zzjf.LONG),
    INT32_LIST_PACKED(39, 3, zzjf.INT),
    FIXED64_LIST_PACKED(40, 3, zzjf.LONG),
    FIXED32_LIST_PACKED(41, 3, zzjf.INT),
    BOOL_LIST_PACKED(42, 3, zzjf.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzjf.INT),
    ENUM_LIST_PACKED(44, 3, zzjf.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzjf.INT),
    SFIXED64_LIST_PACKED(46, 3, zzjf.LONG),
    SINT32_LIST_PACKED(47, 3, zzjf.INT),
    SINT64_LIST_PACKED(48, 3, zzjf.LONG),
    GROUP_LIST(49, 2, zzjf.MESSAGE),
    MAP(50, 4, zzjf.VOID);
    
    private static final zzik[] zzZ = null;
    private final zzjf zzab;
    private final int zzac;
    private final Class zzad;

    static {
        zzZ = new zzik[r1];
        for (zzik zzik : values()) {
            zzZ[zzik.zzac] = zzik;
        }
    }

    private zzik(int i, int i2, zzjf zzjf) {
        this.zzac = i;
        this.zzab = zzjf;
        int i3 = i2 - 1;
        if (i3 == 1) {
            this.zzad = zzjf.zza();
        } else if (i3 != 3) {
            this.zzad = null;
        } else {
            this.zzad = zzjf.zza();
        }
        if (i2 == 1) {
            zzjf zzjf2 = zzjf.VOID;
            zzjf.ordinal();
        }
    }

    public final int zza() {
        return this.zzac;
    }
}
