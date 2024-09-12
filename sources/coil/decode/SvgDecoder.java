package coil.decode;

import coil.ImageLoader;
import coil.decode.Decoder;
import coil.fetch.SourceResult;
import coil.request.Options;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import coil.util.SvgUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.InterruptibleKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ,\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcoil/decode/SvgDecoder;", "Lcoil/decode/Decoder;", "source", "Lcoil/decode/ImageSource;", "options", "Lcoil/request/Options;", "useViewBoundsAsIntrinsicSize", "", "(Lcoil/decode/ImageSource;Lcoil/request/Options;Z)V", "getUseViewBoundsAsIntrinsicSize", "()Z", "decode", "Lcoil/decode/DecodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDstSize", "Lkotlin/Pair;", "", "srcWidth", "srcHeight", "scale", "Lcoil/size/Scale;", "Companion", "Factory", "coil-svg_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SvgDecoder.kt */
public final class SvgDecoder implements Decoder {
    public static final String CSS_KEY = "coil#css";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float DEFAULT_SIZE = 512.0f;
    private static final String MIME_TYPE_SVG = "image/svg+xml";
    /* access modifiers changed from: private */
    public final Options options;
    /* access modifiers changed from: private */
    public final ImageSource source;
    private final boolean useViewBoundsAsIntrinsicSize;

    public SvgDecoder(ImageSource imageSource, Options options2) {
        this(imageSource, options2, false, 4, (DefaultConstructorMarker) null);
    }

    public SvgDecoder(ImageSource imageSource, Options options2, boolean z) {
        this.source = imageSource;
        this.options = options2;
        this.useViewBoundsAsIntrinsicSize = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SvgDecoder(ImageSource imageSource, Options options2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageSource, options2, (i & 4) != 0 ? true : z);
    }

    public final boolean getUseViewBoundsAsIntrinsicSize() {
        return this.useViewBoundsAsIntrinsicSize;
    }

    public Object decode(Continuation<? super DecodeResult> continuation) {
        return InterruptibleKt.runInterruptible$default((CoroutineContext) null, new SvgDecoder$decode$2(this), continuation, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Pair<Float, Float> getDstSize(float f, float f2, Scale scale) {
        if (Sizes.isOriginal(this.options.getSize())) {
            if (f <= 0.0f) {
                f = 512.0f;
            }
            if (f2 <= 0.0f) {
                f2 = 512.0f;
            }
            return TuplesKt.to(Float.valueOf(f), Float.valueOf(f2));
        }
        Size size = this.options.getSize();
        return TuplesKt.to(Float.valueOf(SvgUtils.toPx(size.component1(), scale)), Float.valueOf(SvgUtils.toPx(size.component2(), scale)));
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcoil/decode/SvgDecoder$Factory;", "Lcoil/decode/Decoder$Factory;", "useViewBoundsAsIntrinsicSize", "", "(Z)V", "getUseViewBoundsAsIntrinsicSize", "()Z", "create", "Lcoil/decode/Decoder;", "result", "Lcoil/fetch/SourceResult;", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "equals", "other", "", "hashCode", "", "isApplicable", "coil-svg_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SvgDecoder.kt */
    public static final class Factory implements Decoder.Factory {
        private final boolean useViewBoundsAsIntrinsicSize;

        public Factory() {
            this(false, 1, (DefaultConstructorMarker) null);
        }

        public Factory(boolean z) {
            this.useViewBoundsAsIntrinsicSize = z;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Factory(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z);
        }

        public final boolean getUseViewBoundsAsIntrinsicSize() {
            return this.useViewBoundsAsIntrinsicSize;
        }

        public Decoder create(SourceResult sourceResult, Options options, ImageLoader imageLoader) {
            if (!isApplicable(sourceResult)) {
                return null;
            }
            return new SvgDecoder(sourceResult.getSource(), options, this.useViewBoundsAsIntrinsicSize);
        }

        private final boolean isApplicable(SourceResult sourceResult) {
            return Intrinsics.areEqual((Object) sourceResult.getMimeType(), (Object) SvgDecoder.MIME_TYPE_SVG) || SvgDecodeUtils.isSvg(DecodeUtils.INSTANCE, sourceResult.getSource().source());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Factory) || this.useViewBoundsAsIntrinsicSize != ((Factory) obj).useViewBoundsAsIntrinsicSize) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Boolean.hashCode(this.useViewBoundsAsIntrinsicSize);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcoil/decode/SvgDecoder$Companion;", "", "()V", "CSS_KEY", "", "DEFAULT_SIZE", "", "MIME_TYPE_SVG", "coil-svg_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SvgDecoder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
