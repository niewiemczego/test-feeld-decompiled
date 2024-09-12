package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.reflect.Type;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaix  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public enum zzaix {
    DOUBLE(0, zzaiz.SCALAR, zzajl.DOUBLE),
    FLOAT(1, zzaiz.SCALAR, zzajl.FLOAT),
    INT64(2, zzaiz.SCALAR, zzajl.LONG),
    UINT64(3, zzaiz.SCALAR, zzajl.LONG),
    INT32(4, zzaiz.SCALAR, zzajl.INT),
    FIXED64(5, zzaiz.SCALAR, zzajl.LONG),
    FIXED32(6, zzaiz.SCALAR, zzajl.INT),
    BOOL(7, zzaiz.SCALAR, zzajl.BOOLEAN),
    STRING(8, zzaiz.SCALAR, zzajl.STRING),
    MESSAGE(9, zzaiz.SCALAR, zzajl.MESSAGE),
    BYTES(10, zzaiz.SCALAR, zzajl.BYTE_STRING),
    UINT32(11, zzaiz.SCALAR, zzajl.INT),
    ENUM(12, zzaiz.SCALAR, zzajl.ENUM),
    SFIXED32(13, zzaiz.SCALAR, zzajl.INT),
    SFIXED64(14, zzaiz.SCALAR, zzajl.LONG),
    SINT32(15, zzaiz.SCALAR, zzajl.INT),
    SINT64(16, zzaiz.SCALAR, zzajl.LONG),
    GROUP(17, zzaiz.SCALAR, zzajl.MESSAGE),
    DOUBLE_LIST(18, zzaiz.VECTOR, zzajl.DOUBLE),
    FLOAT_LIST(19, zzaiz.VECTOR, zzajl.FLOAT),
    INT64_LIST(20, zzaiz.VECTOR, zzajl.LONG),
    UINT64_LIST(21, zzaiz.VECTOR, zzajl.LONG),
    INT32_LIST(22, zzaiz.VECTOR, zzajl.INT),
    FIXED64_LIST(23, zzaiz.VECTOR, zzajl.LONG),
    FIXED32_LIST(24, zzaiz.VECTOR, zzajl.INT),
    BOOL_LIST(25, zzaiz.VECTOR, zzajl.BOOLEAN),
    STRING_LIST(26, zzaiz.VECTOR, zzajl.STRING),
    MESSAGE_LIST(27, zzaiz.VECTOR, zzajl.MESSAGE),
    BYTES_LIST(28, zzaiz.VECTOR, zzajl.BYTE_STRING),
    UINT32_LIST(29, zzaiz.VECTOR, zzajl.INT),
    ENUM_LIST(30, zzaiz.VECTOR, zzajl.ENUM),
    SFIXED32_LIST(31, zzaiz.VECTOR, zzajl.INT),
    SFIXED64_LIST(32, zzaiz.VECTOR, zzajl.LONG),
    SINT32_LIST(33, zzaiz.VECTOR, zzajl.INT),
    SINT64_LIST(34, zzaiz.VECTOR, zzajl.LONG),
    DOUBLE_LIST_PACKED(35, zzaiz.PACKED_VECTOR, zzajl.DOUBLE),
    FLOAT_LIST_PACKED(36, zzaiz.PACKED_VECTOR, zzajl.FLOAT),
    INT64_LIST_PACKED(37, zzaiz.PACKED_VECTOR, zzajl.LONG),
    UINT64_LIST_PACKED(38, zzaiz.PACKED_VECTOR, zzajl.LONG),
    INT32_LIST_PACKED(39, zzaiz.PACKED_VECTOR, zzajl.INT),
    FIXED64_LIST_PACKED(40, zzaiz.PACKED_VECTOR, zzajl.LONG),
    FIXED32_LIST_PACKED(41, zzaiz.PACKED_VECTOR, zzajl.INT),
    BOOL_LIST_PACKED(42, zzaiz.PACKED_VECTOR, zzajl.BOOLEAN),
    UINT32_LIST_PACKED(43, zzaiz.PACKED_VECTOR, zzajl.INT),
    ENUM_LIST_PACKED(44, zzaiz.PACKED_VECTOR, zzajl.ENUM),
    SFIXED32_LIST_PACKED(45, zzaiz.PACKED_VECTOR, zzajl.INT),
    SFIXED64_LIST_PACKED(46, zzaiz.PACKED_VECTOR, zzajl.LONG),
    SINT32_LIST_PACKED(47, zzaiz.PACKED_VECTOR, zzajl.INT),
    SINT64_LIST_PACKED(48, zzaiz.PACKED_VECTOR, zzajl.LONG),
    GROUP_LIST(49, zzaiz.VECTOR, zzajl.MESSAGE),
    MAP(50, zzaiz.MAP, zzajl.VOID);
    
    private static final zzaix[] zzaz = null;
    private static final Type[] zzba = null;
    private final zzajl zzbc;
    private final int zzbd;
    private final zzaiz zzbe;
    private final Class<?> zzbf;
    private final boolean zzbg;

    public final int zza() {
        return this.zzbd;
    }

    static {
        int i;
        zzba = new Type[0];
        zzaix[] values = values();
        zzaz = new zzaix[values.length];
        for (zzaix zzaix : values) {
            zzaz[zzaix.zzbd] = zzaix;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
        r5 = com.google.android.gms.internal.p002firebaseauthapi.zzaiw.zza[r6.ordinal()];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzaix(int r4, com.google.android.gms.internal.p002firebaseauthapi.zzaiz r5, com.google.android.gms.internal.p002firebaseauthapi.zzajl r6) {
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
            com.google.android.gms.internal.firebase-auth-api.zzaiz r0 = com.google.android.gms.internal.p002firebaseauthapi.zzaiz.SCALAR
            if (r5 != r0) goto L_0x0039
            int[] r5 = com.google.android.gms.internal.p002firebaseauthapi.zzaiw.zza
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzaix.<init>(java.lang.String, int, int, com.google.android.gms.internal.firebase-auth-api.zzaiz, com.google.android.gms.internal.firebase-auth-api.zzajl):void");
    }
}
