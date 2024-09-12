package com.facebook.imagepipeline.animated.factory;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedImageCompositor;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableAnimatedImage;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class AnimatedImageFactoryImpl implements AnimatedImageFactory {
    @Nullable
    static AnimatedImageDecoder sGifAnimatedImageDecoder = loadIfPresent("com.facebook.animated.gif.GifImage");
    @Nullable
    static AnimatedImageDecoder sWebpAnimatedImageDecoder = loadIfPresent("com.facebook.animated.webp.WebPImage");
    private final AnimatedDrawableBackendProvider mAnimatedDrawableBackendProvider;
    private final PlatformBitmapFactory mBitmapFactory;

    @Nullable
    private static AnimatedImageDecoder loadIfPresent(String str) {
        try {
            return (AnimatedImageDecoder) Class.forName(str).newInstance();
        } catch (Throwable unused) {
            return null;
        }
    }

    public AnimatedImageFactoryImpl(AnimatedDrawableBackendProvider animatedDrawableBackendProvider, PlatformBitmapFactory platformBitmapFactory) {
        this.mAnimatedDrawableBackendProvider = animatedDrawableBackendProvider;
        this.mBitmapFactory = platformBitmapFactory;
    }

    public CloseableImage decodeGif(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions, Bitmap.Config config) {
        AnimatedImage animatedImage;
        if (sGifAnimatedImageDecoder != null) {
            CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
            Preconditions.checkNotNull(byteBufferRef);
            try {
                PooledByteBuffer pooledByteBuffer = byteBufferRef.get();
                if (pooledByteBuffer.getByteBuffer() != null) {
                    animatedImage = sGifAnimatedImageDecoder.decodeFromByteBuffer(pooledByteBuffer.getByteBuffer(), imageDecodeOptions);
                } else {
                    animatedImage = sGifAnimatedImageDecoder.decodeFromNativeMemory(pooledByteBuffer.getNativePtr(), pooledByteBuffer.size(), imageDecodeOptions);
                }
                return getCloseableImage(imageDecodeOptions, animatedImage, config);
            } finally {
                CloseableReference.closeSafely((CloseableReference<?>) byteBufferRef);
            }
        } else {
            throw new UnsupportedOperationException("To encode animated gif please add the dependency to the animated-gif module");
        }
    }

    public CloseableImage decodeWebP(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions, Bitmap.Config config) {
        AnimatedImage animatedImage;
        if (sWebpAnimatedImageDecoder != null) {
            CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage.getByteBufferRef();
            Preconditions.checkNotNull(byteBufferRef);
            try {
                PooledByteBuffer pooledByteBuffer = byteBufferRef.get();
                if (pooledByteBuffer.getByteBuffer() != null) {
                    animatedImage = sWebpAnimatedImageDecoder.decodeFromByteBuffer(pooledByteBuffer.getByteBuffer(), imageDecodeOptions);
                } else {
                    animatedImage = sWebpAnimatedImageDecoder.decodeFromNativeMemory(pooledByteBuffer.getNativePtr(), pooledByteBuffer.size(), imageDecodeOptions);
                }
                return getCloseableImage(imageDecodeOptions, animatedImage, config);
            } finally {
                CloseableReference.closeSafely((CloseableReference<?>) byteBufferRef);
            }
        } else {
            throw new UnsupportedOperationException("To encode animated webp please add the dependency to the animated-webp module");
        }
    }

    private CloseableImage getCloseableImage(ImageDecodeOptions imageDecodeOptions, AnimatedImage animatedImage, Bitmap.Config config) {
        List<CloseableReference<Bitmap>> list;
        CloseableReference<Bitmap> closeableReference = null;
        try {
            int frameCount = imageDecodeOptions.useLastFrameForPreview ? animatedImage.getFrameCount() - 1 : 0;
            if (imageDecodeOptions.forceStaticImage) {
                CloseableStaticBitmap closeableStaticBitmap = new CloseableStaticBitmap(createPreviewBitmap(animatedImage, config, frameCount), ImmutableQualityInfo.FULL_QUALITY, 0);
                CloseableReference.closeSafely((CloseableReference<?>) null);
                CloseableReference.closeSafely((Iterable<? extends CloseableReference<?>>) null);
                return closeableStaticBitmap;
            }
            if (imageDecodeOptions.decodeAllFrames) {
                list = decodeAllFrames(animatedImage, config);
                try {
                    closeableReference = CloseableReference.cloneOrNull(list.get(frameCount));
                } catch (Throwable th) {
                    th = th;
                    CloseableReference.closeSafely((CloseableReference<?>) null);
                    CloseableReference.closeSafely((Iterable<? extends CloseableReference<?>>) list);
                    throw th;
                }
            } else {
                list = null;
            }
            if (imageDecodeOptions.decodePreviewFrame && closeableReference == null) {
                closeableReference = createPreviewBitmap(animatedImage, config, frameCount);
            }
            CloseableAnimatedImage closeableAnimatedImage = new CloseableAnimatedImage(AnimatedImageResult.newBuilder(animatedImage).setPreviewBitmap(closeableReference).setFrameForPreview(frameCount).setDecodedFrames(list).setBitmapTransformation(imageDecodeOptions.bitmapTransformation).build());
            CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
            CloseableReference.closeSafely((Iterable<? extends CloseableReference<?>>) list);
            return closeableAnimatedImage;
        } catch (Throwable th2) {
            th = th2;
            list = null;
            CloseableReference.closeSafely((CloseableReference<?>) null);
            CloseableReference.closeSafely((Iterable<? extends CloseableReference<?>>) list);
            throw th;
        }
    }

    private CloseableReference<Bitmap> createPreviewBitmap(AnimatedImage animatedImage, Bitmap.Config config, int i) {
        CloseableReference<Bitmap> createBitmap = createBitmap(animatedImage.getWidth(), animatedImage.getHeight(), config);
        new AnimatedImageCompositor(this.mAnimatedDrawableBackendProvider.get(AnimatedImageResult.forAnimatedImage(animatedImage), (Rect) null), new AnimatedImageCompositor.Callback() {
            @Nullable
            public CloseableReference<Bitmap> getCachedBitmap(int i) {
                return null;
            }

            public void onIntermediateResult(int i, Bitmap bitmap) {
            }
        }).renderFrame(i, createBitmap.get());
        return createBitmap;
    }

    private List<CloseableReference<Bitmap>> decodeAllFrames(AnimatedImage animatedImage, Bitmap.Config config) {
        AnimatedDrawableBackend animatedDrawableBackend = this.mAnimatedDrawableBackendProvider.get(AnimatedImageResult.forAnimatedImage(animatedImage), (Rect) null);
        final ArrayList arrayList = new ArrayList(animatedDrawableBackend.getFrameCount());
        AnimatedImageCompositor animatedImageCompositor = new AnimatedImageCompositor(animatedDrawableBackend, new AnimatedImageCompositor.Callback() {
            public void onIntermediateResult(int i, Bitmap bitmap) {
            }

            @Nullable
            public CloseableReference<Bitmap> getCachedBitmap(int i) {
                return CloseableReference.cloneOrNull((CloseableReference) arrayList.get(i));
            }
        });
        for (int i = 0; i < animatedDrawableBackend.getFrameCount(); i++) {
            CloseableReference<Bitmap> createBitmap = createBitmap(animatedDrawableBackend.getWidth(), animatedDrawableBackend.getHeight(), config);
            animatedImageCompositor.renderFrame(i, createBitmap.get());
            arrayList.add(createBitmap);
        }
        return arrayList;
    }

    private CloseableReference<Bitmap> createBitmap(int i, int i2, Bitmap.Config config) {
        CloseableReference<Bitmap> createBitmapInternal = this.mBitmapFactory.createBitmapInternal(i, i2, config);
        createBitmapInternal.get().eraseColor(0);
        if (Build.VERSION.SDK_INT >= 12) {
            createBitmapInternal.get().setHasAlpha(true);
        }
        return createBitmapInternal;
    }
}
