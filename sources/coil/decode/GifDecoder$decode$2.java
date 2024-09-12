package coil.decode;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcoil/decode/DecodeResult;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: GifDecoder.kt */
final class GifDecoder$decode$2 extends Lambda implements Function0<DecodeResult> {
    final /* synthetic */ GifDecoder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GifDecoder$decode$2(GifDecoder gifDecoder) {
        super(0);
        this.this$0 = gifDecoder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f7, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f8, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00fb, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final coil.decode.DecodeResult invoke() {
        /*
            r5 = this;
            coil.decode.GifDecoder r0 = r5.this$0
            boolean r0 = r0.enforceMinimumFrameDelay
            if (r0 == 0) goto L_0x0020
            coil.decode.FrameDelayRewritingSource r0 = new coil.decode.FrameDelayRewritingSource
            coil.decode.GifDecoder r1 = r5.this$0
            coil.decode.ImageSource r1 = r1.source
            okio.BufferedSource r1 = r1.source()
            okio.Source r1 = (okio.Source) r1
            r0.<init>(r1)
            okio.Source r0 = (okio.Source) r0
            okio.BufferedSource r0 = okio.Okio.buffer((okio.Source) r0)
            goto L_0x002a
        L_0x0020:
            coil.decode.GifDecoder r0 = r5.this$0
            coil.decode.ImageSource r0 = r0.source
            okio.BufferedSource r0 = r0.source()
        L_0x002a:
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = 0
            r2 = r0
            okio.BufferedSource r2 = (okio.BufferedSource) r2     // Catch:{ all -> 0x00f5 }
            java.io.InputStream r2 = r2.inputStream()     // Catch:{ all -> 0x00f5 }
            android.graphics.Movie r2 = android.graphics.Movie.decodeStream(r2)     // Catch:{ all -> 0x00f5 }
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            r0 = 0
            if (r2 == 0) goto L_0x004c
            int r1 = r2.width()
            if (r1 <= 0) goto L_0x004c
            int r1 = r2.height()
            if (r1 <= 0) goto L_0x004c
            r1 = 1
            goto L_0x004d
        L_0x004c:
            r1 = r0
        L_0x004d:
            if (r1 == 0) goto L_0x00e9
            coil.drawable.MovieDrawable r1 = new coil.drawable.MovieDrawable
            boolean r3 = r2.isOpaque()
            if (r3 == 0) goto L_0x0066
            coil.decode.GifDecoder r3 = r5.this$0
            coil.request.Options r3 = r3.options
            boolean r3 = r3.getAllowRgb565()
            if (r3 == 0) goto L_0x0066
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.RGB_565
            goto L_0x0083
        L_0x0066:
            coil.decode.GifDecoder r3 = r5.this$0
            coil.request.Options r3 = r3.options
            android.graphics.Bitmap$Config r3 = r3.getConfig()
            boolean r3 = coil.util.GifUtils.isHardware(r3)
            if (r3 == 0) goto L_0x0079
            android.graphics.Bitmap$Config r3 = android.graphics.Bitmap.Config.ARGB_8888
            goto L_0x0083
        L_0x0079:
            coil.decode.GifDecoder r3 = r5.this$0
            coil.request.Options r3 = r3.options
            android.graphics.Bitmap$Config r3 = r3.getConfig()
        L_0x0083:
            coil.decode.GifDecoder r4 = r5.this$0
            coil.request.Options r4 = r4.options
            coil.size.Scale r4 = r4.getScale()
            r1.<init>(r2, r3, r4)
            coil.decode.GifDecoder r2 = r5.this$0
            coil.request.Options r2 = r2.options
            coil.request.Parameters r2 = r2.getParameters()
            java.lang.Integer r2 = coil.request.Gifs.repeatCount(r2)
            if (r2 == 0) goto L_0x00a5
            int r2 = r2.intValue()
            goto L_0x00a6
        L_0x00a5:
            r2 = -1
        L_0x00a6:
            r1.setRepeatCount(r2)
            coil.decode.GifDecoder r2 = r5.this$0
            coil.request.Options r2 = r2.options
            coil.request.Parameters r2 = r2.getParameters()
            kotlin.jvm.functions.Function0 r2 = coil.request.Gifs.animationStartCallback(r2)
            coil.decode.GifDecoder r3 = r5.this$0
            coil.request.Options r3 = r3.options
            coil.request.Parameters r3 = r3.getParameters()
            kotlin.jvm.functions.Function0 r3 = coil.request.Gifs.animationEndCallback(r3)
            if (r2 != 0) goto L_0x00c9
            if (r3 == 0) goto L_0x00d0
        L_0x00c9:
            androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback r2 = coil.util.GifUtils.animatable2CompatCallbackOf(r2, r3)
            r1.registerAnimationCallback(r2)
        L_0x00d0:
            coil.decode.GifDecoder r2 = r5.this$0
            coil.request.Options r2 = r2.options
            coil.request.Parameters r2 = r2.getParameters()
            coil.transform.AnimatedTransformation r2 = coil.request.Gifs.animatedTransformation(r2)
            r1.setAnimatedTransformation(r2)
            coil.decode.DecodeResult r2 = new coil.decode.DecodeResult
            android.graphics.drawable.Drawable r1 = (android.graphics.drawable.Drawable) r1
            r2.<init>(r1, r0)
            return r2
        L_0x00e9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Failed to decode GIF."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00f5:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x00f7 }
        L_0x00f7:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.GifDecoder$decode$2.invoke():coil.decode.DecodeResult");
    }
}
