package com.google.android.gms.internal.measurement;

import java.lang.reflect.Type;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.0 */
public enum zzir {
    DOUBLE(0, zzit.SCALAR, zzjk.DOUBLE),
    FLOAT(1, zzit.SCALAR, zzjk.FLOAT),
    INT64(2, zzit.SCALAR, zzjk.LONG),
    UINT64(3, zzit.SCALAR, zzjk.LONG),
    INT32(4, zzit.SCALAR, zzjk.INT),
    FIXED64(5, zzit.SCALAR, zzjk.LONG),
    FIXED32(6, zzit.SCALAR, zzjk.INT),
    BOOL(7, zzit.SCALAR, zzjk.BOOLEAN),
    STRING(8, zzit.SCALAR, zzjk.STRING),
    MESSAGE(9, zzit.SCALAR, zzjk.MESSAGE),
    BYTES(10, zzit.SCALAR, zzjk.BYTE_STRING),
    UINT32(11, zzit.SCALAR, zzjk.INT),
    ENUM(12, zzit.SCALAR, zzjk.ENUM),
    SFIXED32(13, zzit.SCALAR, zzjk.INT),
    SFIXED64(14, zzit.SCALAR, zzjk.LONG),
    SINT32(15, zzit.SCALAR, zzjk.INT),
    SINT64(16, zzit.SCALAR, zzjk.LONG),
    GROUP(17, zzit.SCALAR, zzjk.MESSAGE),
    DOUBLE_LIST(18, zzit.VECTOR, zzjk.DOUBLE),
    FLOAT_LIST(19, zzit.VECTOR, zzjk.FLOAT),
    INT64_LIST(20, zzit.VECTOR, zzjk.LONG),
    UINT64_LIST(21, zzit.VECTOR, zzjk.LONG),
    INT32_LIST(22, zzit.VECTOR, zzjk.INT),
    FIXED64_LIST(23, zzit.VECTOR, zzjk.LONG),
    FIXED32_LIST(24, zzit.VECTOR, zzjk.INT),
    BOOL_LIST(25, zzit.VECTOR, zzjk.BOOLEAN),
    STRING_LIST(26, zzit.VECTOR, zzjk.STRING),
    MESSAGE_LIST(27, zzit.VECTOR, zzjk.MESSAGE),
    BYTES_LIST(28, zzit.VECTOR, zzjk.BYTE_STRING),
    UINT32_LIST(29, zzit.VECTOR, zzjk.INT),
    ENUM_LIST(30, zzit.VECTOR, zzjk.ENUM),
    SFIXED32_LIST(31, zzit.VECTOR, zzjk.INT),
    SFIXED64_LIST(32, zzit.VECTOR, zzjk.LONG),
    SINT32_LIST(33, zzit.VECTOR, zzjk.INT),
    SINT64_LIST(34, zzit.VECTOR, zzjk.LONG),
    DOUBLE_LIST_PACKED(35, zzit.PACKED_VECTOR, zzjk.DOUBLE),
    FLOAT_LIST_PACKED(36, zzit.PACKED_VECTOR, zzjk.FLOAT),
    INT64_LIST_PACKED(37, zzit.PACKED_VECTOR, zzjk.LONG),
    UINT64_LIST_PACKED(38, zzit.PACKED_VECTOR, zzjk.LONG),
    INT32_LIST_PACKED(39, zzit.PACKED_VECTOR, zzjk.INT),
    FIXED64_LIST_PACKED(40, zzit.PACKED_VECTOR, zzjk.LONG),
    FIXED32_LIST_PACKED(41, zzit.PACKED_VECTOR, zzjk.INT),
    BOOL_LIST_PACKED(42, zzit.PACKED_VECTOR, zzjk.BOOLEAN),
    UINT32_LIST_PACKED(43, zzit.PACKED_VECTOR, zzjk.INT),
    ENUM_LIST_PACKED(44, zzit.PACKED_VECTOR, zzjk.ENUM),
    SFIXED32_LIST_PACKED(45, zzit.PACKED_VECTOR, zzjk.INT),
    SFIXED64_LIST_PACKED(46, zzit.PACKED_VECTOR, zzjk.LONG),
    SINT32_LIST_PACKED(47, zzit.PACKED_VECTOR, zzjk.INT),
    SINT64_LIST_PACKED(48, zzit.PACKED_VECTOR, zzjk.LONG),
    GROUP_LIST(49, zzit.VECTOR, zzjk.MESSAGE),
    MAP(50, zzit.MAP, zzjk.VOID);
    
    private static final zzir[] zzaz = null;
    private static final Type[] zzba = null;
    private final zzjk zzbc;
    private final int zzbd;
    private final zzit zzbe;
    private final Class<?> zzbf;
    private final boolean zzbg;

    public final int zza() {
        return this.zzbd;
    }

    static {
        int i;
        zzba = new Type[0];
        zzir[] values = values();
        zzaz = new zzir[values.length];
        for (zzir zzir : values) {
            zzaz[zzir.zzbd] = zzir;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
        r5 = com.google.android.gms.internal.measurement.zziu.zza[r6.ordinal()];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzir(int r4, com.google.android.gms.internal.measurement.zzit r5, com.google.android.gms.internal.measurement.zzjk r6) {
        /*
            r1 = this;
            r1.<init>(r2, r3)
            r1.zzbd = r4
            r1.zzbe = r5
            r1.zzbc = r6
            int r2 = r5.ordinal()
            r3 = 3
            r4 = 1
            if (r2 == r4) goto L_0x001e
            if (r2 == r3) goto L_0x0017
            r2 = 0
            r1.zzbf = r2
            goto L_0x0024
        L_0x0017:
            java.lang.Class r2 = r6.zza()
            r1.zzbf = r2
            goto L_0x0024
        L_0x001e:
            java.lang.Class r2 = r6.zza()
            r1.zzbf = r2
        L_0x0024:
            r2 = 0
            com.google.android.gms.internal.measurement.zzit r0 = com.google.android.gms.internal.measurement.zzit.SCALAR
            if (r5 != r0) goto L_0x0039
            int[] r5 = com.google.android.gms.internal.measurement.zziu.zza
            int r6 = r6.ordinal()
            r5 = r5[r6]
            if (r5 == r4) goto L_0x0039
            r6 = 2
            if (r5 == r6) goto L_0x0039
            if (r5 == r3) goto L_0x0039
            goto L_0x003a
        L_0x0039:
            r4 = r2
        L_0x003a:
            r1.zzbg = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzir.<init>(java.lang.String, int, int, com.google.android.gms.internal.measurement.zzit, com.google.android.gms.internal.measurement.zzjk):void");
    }
}
