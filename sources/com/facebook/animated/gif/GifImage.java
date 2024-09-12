package com.facebook.animated.gif;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.soloader.nativeloader.NativeLoader;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public class GifImage implements AnimatedImage, AnimatedImageDecoder {
    private static final int LOOP_COUNT_FOREVER = 0;
    private static final int LOOP_COUNT_MISSING = -1;
    private static volatile boolean sInitialized;
    @Nullable
    private Bitmap.Config mDecodeBitmapConfig = null;
    private long mNativeContext;

    private static native GifImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer, int i, boolean z);

    private static native GifImage nativeCreateFromFileDescriptor(int i, int i2, boolean z);

    private static native GifImage nativeCreateFromNativeMemory(long j, int i, int i2, boolean z);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native GifFrame nativeGetFrame(int i);

    private native int nativeGetFrameCount();

    private native int[] nativeGetFrameDurations();

    private native int nativeGetHeight();

    private native int nativeGetLoopCount();

    private native int nativeGetSizeInBytes();

    private native int nativeGetWidth();

    private native boolean nativeIsAnimated();

    public boolean doesRenderSupportScaling() {
        return false;
    }

    private static synchronized void ensure() {
        synchronized (GifImage.class) {
            if (!sInitialized) {
                sInitialized = true;
                NativeLoader.loadLibrary("gifimage");
            }
        }
    }

    public static GifImage createFromByteArray(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        allocateDirect.put(bArr);
        allocateDirect.rewind();
        return createFromByteBuffer(allocateDirect, ImageDecodeOptions.defaults());
    }

    public static GifImage createFromByteBuffer(ByteBuffer byteBuffer) {
        return createFromByteBuffer(byteBuffer, ImageDecodeOptions.defaults());
    }

    public static GifImage createFromByteBuffer(ByteBuffer byteBuffer, ImageDecodeOptions imageDecodeOptions) {
        ensure();
        byteBuffer.rewind();
        GifImage nativeCreateFromDirectByteBuffer = nativeCreateFromDirectByteBuffer(byteBuffer, imageDecodeOptions.maxDimensionPx, imageDecodeOptions.forceStaticImage);
        nativeCreateFromDirectByteBuffer.mDecodeBitmapConfig = imageDecodeOptions.animatedBitmapConfig;
        return nativeCreateFromDirectByteBuffer;
    }

    public static GifImage createFromNativeMemory(long j, int i, ImageDecodeOptions imageDecodeOptions) {
        ensure();
        Preconditions.checkArgument(Boolean.valueOf(j != 0));
        GifImage nativeCreateFromNativeMemory = nativeCreateFromNativeMemory(j, i, imageDecodeOptions.maxDimensionPx, imageDecodeOptions.forceStaticImage);
        nativeCreateFromNativeMemory.mDecodeBitmapConfig = imageDecodeOptions.animatedBitmapConfig;
        return nativeCreateFromNativeMemory;
    }

    public static GifImage createFromFileDescriptor(int i, ImageDecodeOptions imageDecodeOptions) {
        ensure();
        return nativeCreateFromFileDescriptor(i, imageDecodeOptions.maxDimensionPx, imageDecodeOptions.forceStaticImage);
    }

    public AnimatedImage decodeFromNativeMemory(long j, int i, ImageDecodeOptions imageDecodeOptions) {
        return createFromNativeMemory(j, i, imageDecodeOptions);
    }

    public AnimatedImage decodeFromByteBuffer(ByteBuffer byteBuffer, ImageDecodeOptions imageDecodeOptions) {
        return createFromByteBuffer(byteBuffer, imageDecodeOptions);
    }

    public GifImage() {
    }

    GifImage(long j) {
        this.mNativeContext = j;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        nativeFinalize();
    }

    public void dispose() {
        nativeDispose();
    }

    public int getWidth() {
        return nativeGetWidth();
    }

    public int getHeight() {
        return nativeGetHeight();
    }

    public int getFrameCount() {
        return nativeGetFrameCount();
    }

    public int getDuration() {
        return nativeGetDuration();
    }

    public int[] getFrameDurations() {
        return nativeGetFrameDurations();
    }

    public int getLoopCount() {
        int nativeGetLoopCount = nativeGetLoopCount();
        if (nativeGetLoopCount == -1) {
            return 1;
        }
        if (nativeGetLoopCount != 0) {
            return nativeGetLoopCount + 1;
        }
        return 0;
    }

    public GifFrame getFrame(int i) {
        return nativeGetFrame(i);
    }

    public int getSizeInBytes() {
        return nativeGetSizeInBytes();
    }

    public boolean isAnimated() {
        return nativeIsAnimated();
    }

    public AnimatedDrawableFrameInfo getFrameInfo(int i) {
        GifFrame frame = getFrame(i);
        try {
            return new AnimatedDrawableFrameInfo(i, frame.getXOffset(), frame.getYOffset(), frame.getWidth(), frame.getHeight(), AnimatedDrawableFrameInfo.BlendOperation.BLEND_WITH_PREVIOUS, fromGifDisposalMethod(frame.getDisposalMode()));
        } finally {
            frame.dispose();
        }
    }

    @Nullable
    public Bitmap.Config getAnimatedBitmapConfig() {
        return this.mDecodeBitmapConfig;
    }

    private static AnimatedDrawableFrameInfo.DisposalMethod fromGifDisposalMethod(int i) {
        if (i == 0) {
            return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
        }
        if (i == 1) {
            return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
        }
        if (i == 2) {
            return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND;
        }
        if (i == 3) {
            return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_PREVIOUS;
        }
        return AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
    }
}
