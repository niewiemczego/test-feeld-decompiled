package jp.wasabeef.glide.transformations.internal;

public class SupportRSBlur {
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap blur(android.content.Context r6, android.graphics.Bitmap r7, int r8) throws androidx.renderscript.RSRuntimeException {
        /*
            r0 = 23
            r1 = 0
            androidx.renderscript.RenderScript r6 = androidx.renderscript.RenderScript.create(r6)     // Catch:{ all -> 0x005e }
            androidx.renderscript.RenderScript$RSMessageHandler r2 = new androidx.renderscript.RenderScript$RSMessageHandler     // Catch:{ all -> 0x0058 }
            r2.<init>()     // Catch:{ all -> 0x0058 }
            r6.setMessageHandler(r2)     // Catch:{ all -> 0x0058 }
            androidx.renderscript.Allocation$MipmapControl r2 = androidx.renderscript.Allocation.MipmapControl.MIPMAP_NONE     // Catch:{ all -> 0x0058 }
            r3 = 1
            androidx.renderscript.Allocation r2 = androidx.renderscript.Allocation.createFromBitmap(r6, r7, r2, r3)     // Catch:{ all -> 0x0058 }
            androidx.renderscript.Type r3 = r2.getType()     // Catch:{ all -> 0x0055 }
            androidx.renderscript.Allocation r3 = androidx.renderscript.Allocation.createTyped(r6, r3)     // Catch:{ all -> 0x0055 }
            androidx.renderscript.Element r4 = androidx.renderscript.Element.U8_4(r6)     // Catch:{ all -> 0x0050 }
            androidx.renderscript.ScriptIntrinsicBlur r1 = androidx.renderscript.ScriptIntrinsicBlur.create(r6, r4)     // Catch:{ all -> 0x0050 }
            r1.setInput(r2)     // Catch:{ all -> 0x0050 }
            float r8 = (float) r8     // Catch:{ all -> 0x0050 }
            r1.setRadius(r8)     // Catch:{ all -> 0x0050 }
            r1.forEach(r3)     // Catch:{ all -> 0x0050 }
            r3.copyTo(r7)     // Catch:{ all -> 0x0050 }
            if (r6 == 0) goto L_0x0040
            int r8 = android.os.Build.VERSION.SDK_INT
            if (r8 < r0) goto L_0x003d
            androidx.renderscript.RenderScript.releaseAllContexts()
            goto L_0x0040
        L_0x003d:
            r6.destroy()
        L_0x0040:
            if (r2 == 0) goto L_0x0045
            r2.destroy()
        L_0x0045:
            if (r3 == 0) goto L_0x004a
            r3.destroy()
        L_0x004a:
            if (r1 == 0) goto L_0x004f
            r1.destroy()
        L_0x004f:
            return r7
        L_0x0050:
            r7 = move-exception
            r5 = r1
            r1 = r6
            r6 = r5
            goto L_0x0062
        L_0x0055:
            r7 = move-exception
            r3 = r1
            goto L_0x005b
        L_0x0058:
            r7 = move-exception
            r2 = r1
            r3 = r2
        L_0x005b:
            r1 = r6
            r6 = r3
            goto L_0x0062
        L_0x005e:
            r7 = move-exception
            r6 = r1
            r2 = r6
            r3 = r2
        L_0x0062:
            if (r1 == 0) goto L_0x006f
            int r8 = android.os.Build.VERSION.SDK_INT
            if (r8 < r0) goto L_0x006c
            androidx.renderscript.RenderScript.releaseAllContexts()
            goto L_0x006f
        L_0x006c:
            r1.destroy()
        L_0x006f:
            if (r2 == 0) goto L_0x0074
            r2.destroy()
        L_0x0074:
            if (r3 == 0) goto L_0x0079
            r3.destroy()
        L_0x0079:
            if (r6 == 0) goto L_0x007e
            r6.destroy()
        L_0x007e:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.wasabeef.glide.transformations.internal.SupportRSBlur.blur(android.content.Context, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }
}
