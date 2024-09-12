package com.facebook.animated.webp;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import com.facebook.imagepipeline.animated.base.AnimatedImage;
import com.facebook.imagepipeline.animated.factory.AnimatedImageDecoder;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.nativecode.StaticWebpNativeLoader;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public class WebPImage implements AnimatedImage, AnimatedImageDecoder {
    @Nullable
    private Bitmap.Config mDecodeBitmapConfig = null;
    private long mNativeContext;

    private static native WebPImage nativeCreateFromDirectByteBuffer(ByteBuffer byteBuffer);

    private static native WebPImage nativeCreateFromNativeMemory(long j, int i);

    private native void nativeDispose();

    private native void nativeFinalize();

    private native int nativeGetDuration();

    private native WebPFrame nativeGetFrame(int i);

    private native int nativeGetFrameCount();

    private native int[] nativeGetFrameDurations();

    private native int nativeGetHeight();

    private native int nativeGetLoopCount();

    private native int nativeGetSizeInBytes();

    private native int nativeGetWidth();

    public boolean doesRenderSupportScaling() {
        return true;
    }

    public WebPImage() {
    }

    WebPImage(long j) {
        this.mNativeContext = j;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        nativeFinalize();
    }

    public void dispose() {
        nativeDispose();
    }

    public static WebPImage createFromByteArray(byte[] bArr, @Nullable ImageDecodeOptions imageDecodeOptions) {
        StaticWebpNativeLoader.ensure();
        Preconditions.checkNotNull(bArr);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        allocateDirect.put(bArr);
        allocateDirect.rewind();
        WebPImage nativeCreateFromDirectByteBuffer = nativeCreateFromDirectByteBuffer(allocateDirect);
        if (imageDecodeOptions != null) {
            nativeCreateFromDirectByteBuffer.mDecodeBitmapConfig = imageDecodeOptions.animatedBitmapConfig;
        }
        return nativeCreateFromDirectByteBuffer;
    }

    public static WebPImage createFromByteBuffer(ByteBuffer byteBuffer, @Nullable ImageDecodeOptions imageDecodeOptions) {
        StaticWebpNativeLoader.ensure();
        byteBuffer.rewind();
        WebPImage nativeCreateFromDirectByteBuffer = nativeCreateFromDirectByteBuffer(byteBuffer);
        if (imageDecodeOptions != null) {
            nativeCreateFromDirectByteBuffer.mDecodeBitmapConfig = imageDecodeOptions.animatedBitmapConfig;
        }
        return nativeCreateFromDirectByteBuffer;
    }

    public static WebPImage createFromNativeMemory(long j, int i, @Nullable ImageDecodeOptions imageDecodeOptions) {
        StaticWebpNativeLoader.ensure();
        Preconditions.checkArgument(Boolean.valueOf(j != 0));
        WebPImage nativeCreateFromNativeMemory = nativeCreateFromNativeMemory(j, i);
        if (imageDecodeOptions != null) {
            nativeCreateFromNativeMemory.mDecodeBitmapConfig = imageDecodeOptions.animatedBitmapConfig;
        }
        return nativeCreateFromNativeMemory;
    }

    public AnimatedImage decodeFromNativeMemory(long j, int i, ImageDecodeOptions imageDecodeOptions) {
        return createFromNativeMemory(j, i, imageDecodeOptions);
    }

    public AnimatedImage decodeFromByteBuffer(ByteBuffer byteBuffer, ImageDecodeOptions imageDecodeOptions) {
        return createFromByteBuffer(byteBuffer, imageDecodeOptions);
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
        return nativeGetLoopCount();
    }

    public WebPFrame getFrame(int i) {
        return nativeGetFrame(i);
    }

    public int getSizeInBytes() {
        return nativeGetSizeInBytes();
    }

    public AnimatedDrawableFrameInfo getFrameInfo(int i) {
        WebPFrame frame = getFrame(i);
        try {
            return new AnimatedDrawableFrameInfo(i, frame.getXOffset(), frame.getYOffset(), frame.getWidth(), frame.getHeight(), frame.isBlendWithPreviousFrame() ? AnimatedDrawableFrameInfo.BlendOperation.BLEND_WITH_PREVIOUS : AnimatedDrawableFrameInfo.BlendOperation.NO_BLEND, frame.shouldDisposeToBackgroundColor() ? AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_TO_BACKGROUND : AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT);
        } finally {
            frame.dispose();
        }
    }

    @Nullable
    public Bitmap.Config getAnimatedBitmapConfig() {
        return this.mDecodeBitmapConfig;
    }
}
