package coil.decode;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "coil.decode.ImageDecoderDecoder", f = "ImageDecoderDecoder.kt", i = {0, 0}, l = {158}, m = "wrapDrawable", n = {"this", "baseDrawable"}, s = {"L$0", "L$1"})
/* compiled from: ImageDecoderDecoder.kt */
final class ImageDecoderDecoder$wrapDrawable$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageDecoderDecoder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageDecoderDecoder$wrapDrawable$1(ImageDecoderDecoder imageDecoderDecoder, Continuation<? super ImageDecoderDecoder$wrapDrawable$1> continuation) {
        super(continuation);
        this.this$0 = imageDecoderDecoder;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.wrapDrawable((Drawable) null, this);
    }
}