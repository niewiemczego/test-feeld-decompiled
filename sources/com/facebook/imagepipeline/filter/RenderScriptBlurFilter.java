package com.facebook.imagepipeline.filter;

import android.os.Build;

public abstract class RenderScriptBlurFilter {
    public static final int BLUR_MAX_RADIUS = 25;

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void blurBitmap(android.graphics.Bitmap r2, android.graphics.Bitmap r3, android.content.Context r4, int r5) {
        /*
            com.facebook.common.internal.Preconditions.checkNotNull(r2)
            com.facebook.common.internal.Preconditions.checkNotNull(r3)
            com.facebook.common.internal.Preconditions.checkNotNull(r4)
            if (r5 <= 0) goto L_0x0011
            r0 = 25
            if (r5 > r0) goto L_0x0011
            r0 = 1
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            com.facebook.common.internal.Preconditions.checkArgument(r0)
            r0 = 0
            android.renderscript.RenderScript r4 = android.renderscript.RenderScript.create(r4)     // Catch:{ all -> 0x005f }
            java.lang.Object r4 = com.facebook.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x005f }
            android.renderscript.RenderScript r4 = (android.renderscript.RenderScript) r4     // Catch:{ all -> 0x005f }
            android.renderscript.Element r0 = android.renderscript.Element.U8_4(r4)     // Catch:{ all -> 0x005c }
            android.renderscript.ScriptIntrinsicBlur r0 = android.renderscript.ScriptIntrinsicBlur.create(r4, r0)     // Catch:{ all -> 0x005c }
            android.renderscript.Allocation r3 = android.renderscript.Allocation.createFromBitmap(r4, r3)     // Catch:{ all -> 0x005c }
            java.lang.Object r3 = com.facebook.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x005c }
            android.renderscript.Allocation r3 = (android.renderscript.Allocation) r3     // Catch:{ all -> 0x005c }
            android.renderscript.Allocation r1 = android.renderscript.Allocation.createFromBitmap(r4, r2)     // Catch:{ all -> 0x005c }
            java.lang.Object r1 = com.facebook.common.internal.Preconditions.checkNotNull(r1)     // Catch:{ all -> 0x005c }
            android.renderscript.Allocation r1 = (android.renderscript.Allocation) r1     // Catch:{ all -> 0x005c }
            float r5 = (float) r5     // Catch:{ all -> 0x005c }
            r0.setRadius(r5)     // Catch:{ all -> 0x005c }
            r0.setInput(r3)     // Catch:{ all -> 0x005c }
            r0.forEach(r1)     // Catch:{ all -> 0x005c }
            r1.copyTo(r2)     // Catch:{ all -> 0x005c }
            r0.destroy()     // Catch:{ all -> 0x005c }
            r3.destroy()     // Catch:{ all -> 0x005c }
            r1.destroy()     // Catch:{ all -> 0x005c }
            if (r4 == 0) goto L_0x005b
            r4.destroy()
        L_0x005b:
            return
        L_0x005c:
            r2 = move-exception
            r0 = r4
            goto L_0x0060
        L_0x005f:
            r2 = move-exception
        L_0x0060:
            if (r0 == 0) goto L_0x0065
            r0.destroy()
        L_0x0065:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.filter.RenderScriptBlurFilter.blurBitmap(android.graphics.Bitmap, android.graphics.Bitmap, android.content.Context, int):void");
    }

    public static boolean canUseRenderScript() {
        return Build.VERSION.SDK_INT >= 17;
    }
}
