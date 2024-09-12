package coil.decode;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcoil/decode/DecodeResult;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SvgDecoder.kt */
final class SvgDecoder$decode$2 extends Lambda implements Function0<DecodeResult> {
    final /* synthetic */ SvgDecoder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SvgDecoder$decode$2(SvgDecoder svgDecoder) {
        super(0);
        this.this$0 = svgDecoder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ea, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00eb, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ee, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final coil.decode.DecodeResult invoke() {
        /*
            r10 = this;
            coil.decode.SvgDecoder r0 = r10.this$0
            coil.decode.ImageSource r0 = r0.source
            okio.BufferedSource r0 = r0.source()
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = r0
            okio.BufferedSource r1 = (okio.BufferedSource) r1     // Catch:{ all -> 0x00e8 }
            java.io.InputStream r1 = r1.inputStream()     // Catch:{ all -> 0x00e8 }
            com.caverock.androidsvg.SVG r1 = com.caverock.androidsvg.SVG.getFromInputStream(r1)     // Catch:{ all -> 0x00e8 }
            r2 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            android.graphics.RectF r0 = r1.getDocumentViewBox()
            coil.decode.SvgDecoder r3 = r10.this$0
            boolean r3 = r3.getUseViewBoundsAsIntrinsicSize()
            if (r3 == 0) goto L_0x0032
            if (r0 == 0) goto L_0x0032
            float r3 = r0.width()
            float r4 = r0.height()
            goto L_0x003a
        L_0x0032:
            float r3 = r1.getDocumentWidth()
            float r4 = r1.getDocumentHeight()
        L_0x003a:
            coil.decode.SvgDecoder r5 = r10.this$0
            coil.request.Options r6 = r5.options
            coil.size.Scale r6 = r6.getScale()
            kotlin.Pair r5 = r5.getDstSize(r3, r4, r6)
            java.lang.Object r6 = r5.component1()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            java.lang.Object r5 = r5.component2()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            r7 = 0
            int r8 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r8 <= 0) goto L_0x0079
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x0079
            coil.decode.SvgDecoder r9 = r10.this$0
            coil.request.Options r9 = r9.options
            coil.size.Scale r9 = r9.getScale()
            float r5 = coil.decode.DecodeUtils.computeSizeMultiplier((float) r3, (float) r4, (float) r6, (float) r5, (coil.size.Scale) r9)
            float r6 = r5 * r3
            int r6 = (int) r6
            float r5 = r5 * r4
            int r5 = (int) r5
            goto L_0x0081
        L_0x0079:
            int r6 = kotlin.math.MathKt.roundToInt((float) r6)
            int r5 = kotlin.math.MathKt.roundToInt((float) r5)
        L_0x0081:
            if (r0 != 0) goto L_0x008c
            if (r8 <= 0) goto L_0x008c
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x008c
            r1.setDocumentViewBox(r7, r7, r3, r4)
        L_0x008c:
            java.lang.String r0 = "100%"
            r1.setDocumentWidth((java.lang.String) r0)
            r1.setDocumentHeight((java.lang.String) r0)
            coil.decode.SvgDecoder r0 = r10.this$0
            coil.request.Options r0 = r0.options
            android.graphics.Bitmap$Config r0 = r0.getConfig()
            android.graphics.Bitmap$Config r0 = coil.util.SvgUtils.toSoftware(r0)
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r6, r5, r0)
            java.lang.String r3 = "createBitmap(width, height, config)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            coil.decode.SvgDecoder r3 = r10.this$0
            coil.request.Options r3 = r3.options
            coil.request.Parameters r3 = r3.getParameters()
            java.lang.String r3 = coil.request.Svgs.css(r3)
            if (r3 == 0) goto L_0x00c4
            com.caverock.androidsvg.RenderOptions r2 = new com.caverock.androidsvg.RenderOptions
            r2.<init>()
            com.caverock.androidsvg.RenderOptions r2 = r2.css(r3)
        L_0x00c4:
            android.graphics.Canvas r3 = new android.graphics.Canvas
            r3.<init>(r0)
            r1.renderToCanvas((android.graphics.Canvas) r3, (com.caverock.androidsvg.RenderOptions) r2)
            coil.decode.DecodeResult r1 = new coil.decode.DecodeResult
            coil.decode.SvgDecoder r2 = r10.this$0
            coil.request.Options r2 = r2.options
            android.content.Context r2 = r2.getContext()
            android.content.res.Resources r2 = r2.getResources()
            android.graphics.drawable.BitmapDrawable r3 = new android.graphics.drawable.BitmapDrawable
            r3.<init>(r2, r0)
            android.graphics.drawable.Drawable r3 = (android.graphics.drawable.Drawable) r3
            r0 = 1
            r1.<init>(r3, r0)
            return r1
        L_0x00e8:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x00ea }
        L_0x00ea:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.SvgDecoder$decode$2.invoke():coil.decode.DecodeResult");
    }
}
