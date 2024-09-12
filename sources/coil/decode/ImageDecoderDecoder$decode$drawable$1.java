package coil.decode;

import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/drawable/Drawable;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ImageDecoderDecoder.kt */
final class ImageDecoderDecoder$decode$drawable$1 extends Lambda implements Function0<Drawable> {
    final /* synthetic */ Ref.BooleanRef $isSampled;
    final /* synthetic */ ImageDecoderDecoder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageDecoderDecoder$decode$drawable$1(ImageDecoderDecoder imageDecoderDecoder, Ref.BooleanRef booleanRef) {
        super(0);
        this.this$0 = imageDecoderDecoder;
        this.$isSampled = booleanRef;
    }

    public final Drawable invoke() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ImageDecoderDecoder imageDecoderDecoder = this.this$0;
        ImageSource access$wrapImageSource = imageDecoderDecoder.wrapImageSource(imageDecoderDecoder.source);
        try {
            Drawable decodeDrawable = ImageDecoder.decodeDrawable(this.this$0.toImageDecoderSource(access$wrapImageSource), new ImageDecoderDecoder$decode$drawable$1$invoke$$inlined$decodeDrawable$1(objectRef, this.this$0, this.$isSampled));
            Intrinsics.checkNotNullExpressionValue(decodeDrawable, "crossinline action: Imag…ction(info, source)\n    }");
            return decodeDrawable;
        } finally {
            ImageDecoder imageDecoder = (ImageDecoder) objectRef.element;
            if (imageDecoder != null) {
                imageDecoder.close();
            }
            access$wrapImageSource.close();
        }
    }
}
