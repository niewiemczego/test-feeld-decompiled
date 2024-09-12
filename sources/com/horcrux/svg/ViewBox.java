package com.horcrux.svg;

class ViewBox {
    private static final int MOS_MEET = 0;
    private static final int MOS_NONE = 2;
    private static final int MOS_SLICE = 1;

    ViewBox() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.graphics.Matrix getTransform(android.graphics.RectF r22, android.graphics.RectF r23, java.lang.String r24, int r25) {
        /*
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            float r4 = r0.left
            double r4 = (double) r4
            float r6 = r0.top
            double r6 = (double) r6
            float r8 = r22.width()
            double r8 = (double) r8
            float r0 = r22.height()
            double r10 = (double) r0
            float r0 = r1.left
            double r12 = (double) r0
            float r0 = r1.top
            double r14 = (double) r0
            float r0 = r23.width()
            double r0 = (double) r0
            float r2 = r23.height()
            double r2 = (double) r2
            r16 = r14
            double r14 = r0 / r8
            r18 = r8
            double r8 = r2 / r10
            double r4 = r4 * r14
            double r12 = r12 - r4
            double r6 = r6 * r8
            double r4 = r16 - r6
            r6 = 2
            r16 = r2
            r2 = r25
            if (r2 != r6) goto L_0x005f
            double r2 = java.lang.Math.min(r14, r8)
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x0051
            double r0 = r0 / r2
            double r0 = r0 - r18
            r6 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r0 = r0 / r6
            double r12 = r12 - r0
            double r0 = r16 / r2
            double r0 = r0 - r10
            goto L_0x005b
        L_0x0051:
            r6 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r8 = r18 * r2
            double r0 = r0 - r8
            double r0 = r0 / r6
            double r12 = r12 - r0
            double r10 = r10 * r2
            double r0 = r16 - r10
        L_0x005b:
            double r0 = r0 / r6
            double r4 = r4 - r0
            r8 = r2
            goto L_0x00b9
        L_0x005f:
            java.lang.String r3 = "none"
            r6 = r24
            boolean r7 = r6.equals(r3)
            if (r7 != 0) goto L_0x0071
            if (r2 != 0) goto L_0x0071
            double r14 = java.lang.Math.min(r14, r8)
        L_0x006f:
            r8 = r14
            goto L_0x007f
        L_0x0071:
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x007f
            r3 = 1
            if (r2 != r3) goto L_0x007f
            double r14 = java.lang.Math.max(r14, r8)
            goto L_0x006f
        L_0x007f:
            java.lang.String r2 = "xMid"
            boolean r2 = r6.contains(r2)
            if (r2 == 0) goto L_0x0090
            double r2 = r18 * r14
            double r2 = r0 - r2
            r20 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r2 = r2 / r20
            double r12 = r12 + r2
        L_0x0090:
            java.lang.String r2 = "xMax"
            boolean r2 = r6.contains(r2)
            if (r2 == 0) goto L_0x009c
            double r2 = r18 * r14
            double r0 = r0 - r2
            double r12 = r12 + r0
        L_0x009c:
            java.lang.String r0 = "YMid"
            boolean r0 = r6.contains(r0)
            if (r0 == 0) goto L_0x00ac
            double r0 = r10 * r8
            double r2 = r16 - r0
            r0 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r2 = r2 / r0
            double r4 = r4 + r2
        L_0x00ac:
            java.lang.String r0 = "YMax"
            boolean r0 = r6.contains(r0)
            if (r0 == 0) goto L_0x00b8
            double r10 = r10 * r8
            double r2 = r16 - r10
            double r4 = r4 + r2
        L_0x00b8:
            r2 = r14
        L_0x00b9:
            android.graphics.Matrix r0 = new android.graphics.Matrix
            r0.<init>()
            float r1 = (float) r12
            float r4 = (float) r4
            r0.postTranslate(r1, r4)
            float r1 = (float) r2
            float r2 = (float) r8
            r0.preScale(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.ViewBox.getTransform(android.graphics.RectF, android.graphics.RectF, java.lang.String, int):android.graphics.Matrix");
    }
}
