package coil.decode;

import coil.ImageLoader;
import coil.decode.Decoder;
import coil.fetch.SourceResult;
import coil.request.Options;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.InterruptibleKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0002\f\rB!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcoil/decode/GifDecoder;", "Lcoil/decode/Decoder;", "source", "Lcoil/decode/ImageSource;", "options", "Lcoil/request/Options;", "enforceMinimumFrameDelay", "", "(Lcoil/decode/ImageSource;Lcoil/request/Options;Z)V", "decode", "Lcoil/decode/DecodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Factory", "coil-gif_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GifDecoder.kt */
public final class GifDecoder implements Decoder {
    public static final String ANIMATED_TRANSFORMATION_KEY = "coil#animated_transformation";
    public static final String ANIMATION_END_CALLBACK_KEY = "coil#animation_end_callback";
    public static final String ANIMATION_START_CALLBACK_KEY = "coil#animation_start_callback";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REPEAT_COUNT_KEY = "coil#repeat_count";
    /* access modifiers changed from: private */
    public final boolean enforceMinimumFrameDelay;
    /* access modifiers changed from: private */
    public final Options options;
    /* access modifiers changed from: private */
    public final ImageSource source;

    public GifDecoder(ImageSource imageSource, Options options2) {
        this(imageSource, options2, false, 4, (DefaultConstructorMarker) null);
    }

    public GifDecoder(ImageSource imageSource, Options options2, boolean z) {
        this.source = imageSource;
        this.options = options2;
        this.enforceMinimumFrameDelay = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GifDecoder(ImageSource imageSource, Options options2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageSource, options2, (i & 4) != 0 ? true : z);
    }

    public Object decode(Continuation<? super DecodeResult> continuation) {
        return InterruptibleKt.runInterruptible$default((CoroutineContext) null, new GifDecoder$decode$2(this), continuation, 1, (Object) null);
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcoil/decode/GifDecoder$Factory;", "Lcoil/decode/Decoder$Factory;", "enforceMinimumFrameDelay", "", "(Z)V", "create", "Lcoil/decode/Decoder;", "result", "Lcoil/fetch/SourceResult;", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "equals", "other", "", "hashCode", "", "coil-gif_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: GifDecoder.kt */
    public static final class Factory implements Decoder.Factory {
        private final boolean enforceMinimumFrameDelay;

        public Factory() {
            this(false, 1, (DefaultConstructorMarker) null);
        }

        public Factory(boolean z) {
            this.enforceMinimumFrameDelay = z;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Factory(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z);
        }

        public Decoder create(SourceResult sourceResult, Options options, ImageLoader imageLoader) {
            if (!GifDecodeUtils.isGif(DecodeUtils.INSTANCE, sourceResult.getSource().source())) {
                return null;
            }
            return new GifDecoder(sourceResult.getSource(), options, this.enforceMinimumFrameDelay);
        }

        public boolean equals(Object obj) {
            return obj instanceof Factory;
        }

        public int hashCode() {
            return getClass().hashCode();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcoil/decode/GifDecoder$Companion;", "", "()V", "ANIMATED_TRANSFORMATION_KEY", "", "ANIMATION_END_CALLBACK_KEY", "ANIMATION_START_CALLBACK_KEY", "REPEAT_COUNT_KEY", "coil-gif_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: GifDecoder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
