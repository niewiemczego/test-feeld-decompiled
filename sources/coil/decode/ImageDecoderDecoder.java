package coil.decode;

import android.graphics.ImageDecoder;
import android.os.Build;
import coil.ImageLoader;
import coil.decode.Decoder;
import coil.decode.ImageSource;
import coil.fetch.SourceResult;
import coil.request.Gifs;
import coil.request.Options;
import coil.transform.AnimatedTransformation;
import coil.util.GifUtils;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
import okio.Okio;
import okio.Path;
import okio.Source;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0016B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0002J\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0003H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcoil/decode/ImageDecoderDecoder;", "Lcoil/decode/Decoder;", "source", "Lcoil/decode/ImageSource;", "options", "Lcoil/request/Options;", "enforceMinimumFrameDelay", "", "(Lcoil/decode/ImageSource;Lcoil/request/Options;Z)V", "decode", "Lcoil/decode/DecodeResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wrapDrawable", "Landroid/graphics/drawable/Drawable;", "baseDrawable", "(Landroid/graphics/drawable/Drawable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wrapImageSource", "configureImageDecoderProperties", "", "Landroid/graphics/ImageDecoder;", "toImageDecoderSource", "Landroid/graphics/ImageDecoder$Source;", "Factory", "coil-gif_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ImageDecoderDecoder.kt */
public final class ImageDecoderDecoder implements Decoder {
    private final boolean enforceMinimumFrameDelay;
    /* access modifiers changed from: private */
    public final Options options;
    /* access modifiers changed from: private */
    public final ImageSource source;

    public ImageDecoderDecoder(ImageSource imageSource, Options options2) {
        this(imageSource, options2, false, 4, (DefaultConstructorMarker) null);
    }

    public ImageDecoderDecoder(ImageSource imageSource, Options options2, boolean z) {
        this.source = imageSource;
        this.options = options2;
        this.enforceMinimumFrameDelay = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageDecoderDecoder(ImageSource imageSource, Options options2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(imageSource, options2, (i & 4) != 0 ? true : z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0074 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object decode(kotlin.coroutines.Continuation<? super coil.decode.DecodeResult> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof coil.decode.ImageDecoderDecoder$decode$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            coil.decode.ImageDecoderDecoder$decode$1 r0 = (coil.decode.ImageDecoderDecoder$decode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            coil.decode.ImageDecoderDecoder$decode$1 r0 = new coil.decode.ImageDecoderDecoder$decode$1
            r0.<init>(r7, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 == r5) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r0 = r0.L$0
            kotlin.jvm.internal.Ref$BooleanRef r0 = (kotlin.jvm.internal.Ref.BooleanRef) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0076
        L_0x0032:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x003a:
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.internal.Ref$BooleanRef r2 = (kotlin.jvm.internal.Ref.BooleanRef) r2
            java.lang.Object r5 = r0.L$0
            coil.decode.ImageDecoderDecoder r5 = (coil.decode.ImageDecoderDecoder) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0066
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.jvm.internal.Ref$BooleanRef r8 = new kotlin.jvm.internal.Ref$BooleanRef
            r8.<init>()
            coil.decode.ImageDecoderDecoder$decode$drawable$1 r2 = new coil.decode.ImageDecoderDecoder$decode$drawable$1
            r2.<init>(r7, r8)
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r5
            java.lang.Object r2 = kotlinx.coroutines.InterruptibleKt.runInterruptible$default(r4, r2, r0, r5, r4)
            if (r2 != r1) goto L_0x0062
            return r1
        L_0x0062:
            r5 = r7
            r6 = r2
            r2 = r8
            r8 = r6
        L_0x0066:
            android.graphics.drawable.Drawable r8 = (android.graphics.drawable.Drawable) r8
            r0.L$0 = r2
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r8 = r5.wrapDrawable(r8, r0)
            if (r8 != r1) goto L_0x0075
            return r1
        L_0x0075:
            r0 = r2
        L_0x0076:
            android.graphics.drawable.Drawable r8 = (android.graphics.drawable.Drawable) r8
            boolean r0 = r0.element
            coil.decode.DecodeResult r1 = new coil.decode.DecodeResult
            r1.<init>(r8, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.ImageDecoderDecoder.decode(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final ImageSource wrapImageSource(ImageSource imageSource) {
        return (!this.enforceMinimumFrameDelay || !GifDecodeUtils.isGif(DecodeUtils.INSTANCE, imageSource.source())) ? imageSource : ImageSources.create(Okio.buffer((Source) new FrameDelayRewritingSource(imageSource.source())), this.options.getContext());
    }

    /* access modifiers changed from: private */
    public final ImageDecoder.Source toImageDecoderSource(ImageSource imageSource) {
        Path fileOrNull = imageSource.fileOrNull();
        if (fileOrNull != null) {
            return ImageDecoder.createSource(fileOrNull.toFile());
        }
        ImageSource.Metadata metadata = imageSource.getMetadata();
        if (metadata instanceof AssetMetadata) {
            return ImageDecoder.createSource(this.options.getContext().getAssets(), ((AssetMetadata) metadata).getFileName());
        }
        if (metadata instanceof ContentMetadata) {
            return ImageDecoder.createSource(this.options.getContext().getContentResolver(), ((ContentMetadata) metadata).getUri());
        }
        if (metadata instanceof ResourceMetadata) {
            ResourceMetadata resourceMetadata = (ResourceMetadata) metadata;
            if (Intrinsics.areEqual((Object) resourceMetadata.getPackageName(), (Object) this.options.getContext().getPackageName())) {
                return ImageDecoder.createSource(this.options.getContext().getResources(), resourceMetadata.getResId());
            }
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return ImageDecoder.createSource(imageSource.source().readByteArray());
        }
        if (Build.VERSION.SDK_INT == 30) {
            return ImageDecoder.createSource(ByteBuffer.wrap(imageSource.source().readByteArray()));
        }
        return ImageDecoder.createSource(imageSource.file().toFile());
    }

    /* access modifiers changed from: private */
    public final void configureImageDecoderProperties(ImageDecoder imageDecoder) {
        imageDecoder.setAllocator(GifUtils.isHardware(this.options.getConfig()) ? 3 : 1);
        imageDecoder.setMemorySizePolicy(this.options.getAllowRgb565() ^ true ? 1 : 0);
        if (this.options.getColorSpace() != null) {
            imageDecoder.setTargetColorSpace(this.options.getColorSpace());
        }
        imageDecoder.setUnpremultipliedRequired(!this.options.getPremultipliedAlpha());
        AnimatedTransformation animatedTransformation = Gifs.animatedTransformation(this.options.getParameters());
        imageDecoder.setPostProcessor(animatedTransformation != null ? GifUtils.asPostProcessor(animatedTransformation) : null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object wrapDrawable(android.graphics.drawable.Drawable r8, kotlin.coroutines.Continuation<? super android.graphics.drawable.Drawable> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof coil.decode.ImageDecoderDecoder$wrapDrawable$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            coil.decode.ImageDecoderDecoder$wrapDrawable$1 r0 = (coil.decode.ImageDecoderDecoder$wrapDrawable$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            coil.decode.ImageDecoderDecoder$wrapDrawable$1 r0 = new coil.decode.ImageDecoderDecoder$wrapDrawable$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r8 = r0.L$1
            android.graphics.drawable.Drawable r8 = (android.graphics.drawable.Drawable) r8
            java.lang.Object r0 = r0.L$0
            coil.decode.ImageDecoderDecoder r0 = (coil.decode.ImageDecoderDecoder) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0094
        L_0x0032:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r9)
            boolean r9 = r8 instanceof android.graphics.drawable.AnimatedImageDrawable
            if (r9 != 0) goto L_0x0042
            return r8
        L_0x0042:
            r9 = r8
            android.graphics.drawable.AnimatedImageDrawable r9 = (android.graphics.drawable.AnimatedImageDrawable) r9
            coil.request.Options r2 = r7.options
            coil.request.Parameters r2 = r2.getParameters()
            java.lang.Integer r2 = coil.request.Gifs.repeatCount(r2)
            if (r2 == 0) goto L_0x0056
            int r2 = r2.intValue()
            goto L_0x0057
        L_0x0056:
            r2 = -1
        L_0x0057:
            r9.setRepeatCount(r2)
            coil.request.Options r9 = r7.options
            coil.request.Parameters r9 = r9.getParameters()
            kotlin.jvm.functions.Function0 r9 = coil.request.Gifs.animationStartCallback(r9)
            coil.request.Options r2 = r7.options
            coil.request.Parameters r2 = r2.getParameters()
            kotlin.jvm.functions.Function0 r2 = coil.request.Gifs.animationEndCallback(r2)
            if (r9 != 0) goto L_0x0075
            if (r2 == 0) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            r0 = r7
            goto L_0x0094
        L_0x0075:
            kotlinx.coroutines.MainCoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.getMain()
            kotlinx.coroutines.MainCoroutineDispatcher r4 = r4.getImmediate()
            kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4
            coil.decode.ImageDecoderDecoder$wrapDrawable$2 r5 = new coil.decode.ImageDecoderDecoder$wrapDrawable$2
            r6 = 0
            r5.<init>(r8, r9, r2, r6)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r4, r5, r0)
            if (r9 != r1) goto L_0x0073
            return r1
        L_0x0094:
            coil.drawable.ScaleDrawable r9 = new coil.drawable.ScaleDrawable
            coil.request.Options r0 = r0.options
            coil.size.Scale r0 = r0.getScale()
            r9.<init>(r8, r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.ImageDecoderDecoder.wrapDrawable(android.graphics.drawable.Drawable, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcoil/decode/ImageDecoderDecoder$Factory;", "Lcoil/decode/Decoder$Factory;", "enforceMinimumFrameDelay", "", "(Z)V", "create", "Lcoil/decode/Decoder;", "result", "Lcoil/fetch/SourceResult;", "options", "Lcoil/request/Options;", "imageLoader", "Lcoil/ImageLoader;", "equals", "other", "", "hashCode", "", "isApplicable", "source", "Lokio/BufferedSource;", "coil-gif_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ImageDecoderDecoder.kt */
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
            if (!isApplicable(sourceResult.getSource().source())) {
                return null;
            }
            return new ImageDecoderDecoder(sourceResult.getSource(), options, this.enforceMinimumFrameDelay);
        }

        private final boolean isApplicable(BufferedSource bufferedSource) {
            return GifDecodeUtils.isGif(DecodeUtils.INSTANCE, bufferedSource) || GifDecodeUtils.isAnimatedWebP(DecodeUtils.INSTANCE, bufferedSource) || (Build.VERSION.SDK_INT >= 30 && GifDecodeUtils.isAnimatedHeif(DecodeUtils.INSTANCE, bufferedSource));
        }

        public boolean equals(Object obj) {
            return obj instanceof Factory;
        }

        public int hashCode() {
            return getClass().hashCode();
        }
    }
}
