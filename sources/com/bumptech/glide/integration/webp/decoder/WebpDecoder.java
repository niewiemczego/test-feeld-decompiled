package com.bumptech.glide.integration.webp.decoder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.LruCache;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.integration.webp.WebpFrame;
import com.bumptech.glide.integration.webp.WebpFrameInfo;
import com.bumptech.glide.integration.webp.WebpImage;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class WebpDecoder implements GifDecoder {
    private static final int MAX_FRAME_BITMAP_CACHE_SIZE = 5;
    private static final String TAG = "WebpDecoder";
    private int downsampledHeight;
    private int downsampledWidth;
    private Bitmap.Config mBitmapConfig;
    /* access modifiers changed from: private */
    public final GifDecoder.BitmapProvider mBitmapProvider;
    private WebpFrameCacheStrategy mCacheStrategy;
    private final LruCache<Integer, Bitmap> mFrameBitmapCache;
    private final int[] mFrameDurations;
    private final WebpFrameInfo[] mFrameInfos;
    private int mFramePointer;
    private final Paint mTransparentFillPaint;
    private WebpImage mWebPImage;
    private ByteBuffer rawData;
    private int sampleSize;

    public int getStatus() {
        return 0;
    }

    public int read(InputStream inputStream, int i) {
        return 0;
    }

    public int read(byte[] bArr) {
        return 0;
    }

    public WebpDecoder(GifDecoder.BitmapProvider bitmapProvider, WebpImage webpImage, ByteBuffer byteBuffer, int i) {
        this(bitmapProvider, webpImage, byteBuffer, i, WebpFrameCacheStrategy.NONE);
    }

    public WebpDecoder(GifDecoder.BitmapProvider bitmapProvider, WebpImage webpImage, ByteBuffer byteBuffer, int i, WebpFrameCacheStrategy webpFrameCacheStrategy) {
        int i2;
        this.mFramePointer = -1;
        this.mBitmapConfig = Bitmap.Config.ARGB_8888;
        this.mBitmapProvider = bitmapProvider;
        this.mWebPImage = webpImage;
        this.mFrameDurations = webpImage.getFrameDurations();
        this.mFrameInfos = new WebpFrameInfo[webpImage.getFrameCount()];
        for (int i3 = 0; i3 < this.mWebPImage.getFrameCount(); i3++) {
            this.mFrameInfos[i3] = this.mWebPImage.getFrameInfo(i3);
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "mFrameInfos: " + this.mFrameInfos[i3].toString());
            }
        }
        this.mCacheStrategy = webpFrameCacheStrategy;
        Paint paint = new Paint();
        this.mTransparentFillPaint = paint;
        paint.setColor(0);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        if (this.mCacheStrategy.cacheAll()) {
            i2 = webpImage.getFrameCount();
        } else {
            i2 = Math.max(5, this.mCacheStrategy.getCacheSize());
        }
        this.mFrameBitmapCache = new LruCache<Integer, Bitmap>(i2) {
            /* access modifiers changed from: protected */
            public void entryRemoved(boolean z, Integer num, Bitmap bitmap, Bitmap bitmap2) {
                if (bitmap != null) {
                    WebpDecoder.this.mBitmapProvider.release(bitmap);
                }
            }
        };
        setData(new GifHeader(), byteBuffer, i);
    }

    public WebpFrameCacheStrategy getCacheStrategy() {
        return this.mCacheStrategy;
    }

    public int getWidth() {
        return this.mWebPImage.getWidth();
    }

    public int getHeight() {
        return this.mWebPImage.getHeight();
    }

    public ByteBuffer getData() {
        return this.rawData;
    }

    public void advance() {
        this.mFramePointer = (this.mFramePointer + 1) % this.mWebPImage.getFrameCount();
    }

    public int getDelay(int i) {
        if (i >= 0) {
            int[] iArr = this.mFrameDurations;
            if (i < iArr.length) {
                return iArr[i];
            }
        }
        return -1;
    }

    public int getNextDelay() {
        int i;
        if (this.mFrameDurations.length == 0 || (i = this.mFramePointer) < 0) {
            return 0;
        }
        return getDelay(i);
    }

    public int getFrameCount() {
        return this.mWebPImage.getFrameCount();
    }

    public int getCurrentFrameIndex() {
        return this.mFramePointer;
    }

    public void resetFrameIndex() {
        this.mFramePointer = -1;
    }

    @Deprecated
    public int getLoopCount() {
        return this.mWebPImage.getLoopCount();
    }

    public int getNetscapeLoopCount() {
        return this.mWebPImage.getLoopCount();
    }

    public int getTotalIterationCount() {
        if (this.mWebPImage.getLoopCount() == 0) {
            return 0;
        }
        return this.mWebPImage.getLoopCount();
    }

    public int getByteSize() {
        return this.mWebPImage.getSizeInBytes();
    }

    public void setDefaultBitmapConfig(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888) {
            this.mBitmapConfig = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888);
    }

    public Bitmap getNextFrame() {
        Bitmap bitmap;
        int currentFrameIndex = getCurrentFrameIndex();
        Bitmap obtain = this.mBitmapProvider.obtain(this.downsampledWidth, this.downsampledHeight, Bitmap.Config.ARGB_8888);
        obtain.eraseColor(0);
        if (Build.VERSION.SDK_INT >= 24) {
            obtain.setDensity(DisplayMetrics.DENSITY_DEVICE_STABLE);
        }
        Canvas canvas = new Canvas(obtain);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        if (this.mCacheStrategy.noCache() || (bitmap = this.mFrameBitmapCache.get(Integer.valueOf(currentFrameIndex))) == null) {
            int prepareCanvasWithBlending = !isKeyFrame(currentFrameIndex) ? prepareCanvasWithBlending(currentFrameIndex - 1, canvas) : currentFrameIndex;
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "frameNumber=" + currentFrameIndex + ", nextIndex=" + prepareCanvasWithBlending);
            }
            while (prepareCanvasWithBlending < currentFrameIndex) {
                WebpFrameInfo webpFrameInfo = this.mFrameInfos[prepareCanvasWithBlending];
                if (!webpFrameInfo.blendPreviousFrame) {
                    disposeToBackground(canvas, webpFrameInfo);
                }
                renderFrame(prepareCanvasWithBlending, canvas);
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "renderFrame, index=" + prepareCanvasWithBlending + ", blend=" + webpFrameInfo.blendPreviousFrame + ", dispose=" + webpFrameInfo.disposeBackgroundColor);
                }
                if (webpFrameInfo.disposeBackgroundColor) {
                    disposeToBackground(canvas, webpFrameInfo);
                }
                prepareCanvasWithBlending++;
            }
            WebpFrameInfo webpFrameInfo2 = this.mFrameInfos[currentFrameIndex];
            if (!webpFrameInfo2.blendPreviousFrame) {
                disposeToBackground(canvas, webpFrameInfo2);
            }
            renderFrame(currentFrameIndex, canvas);
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "renderFrame, index=" + currentFrameIndex + ", blend=" + webpFrameInfo2.blendPreviousFrame + ", dispose=" + webpFrameInfo2.disposeBackgroundColor);
            }
            cacheFrameBitmap(currentFrameIndex, obtain);
            return obtain;
        }
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "hit frame bitmap from memory cache, frameNumber=" + currentFrameIndex);
        }
        bitmap.setDensity(canvas.getDensity());
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return obtain;
    }

    private void renderFrame(int i, Canvas canvas) {
        WebpFrameInfo webpFrameInfo = this.mFrameInfos[i];
        int i2 = webpFrameInfo.width / this.sampleSize;
        int i3 = webpFrameInfo.height / this.sampleSize;
        int i4 = webpFrameInfo.xOffset / this.sampleSize;
        int i5 = webpFrameInfo.yOffset / this.sampleSize;
        if (i2 != 0 && i3 != 0) {
            WebpFrame frame = this.mWebPImage.getFrame(i);
            try {
                Bitmap obtain = this.mBitmapProvider.obtain(i2, i3, this.mBitmapConfig);
                obtain.eraseColor(0);
                obtain.setDensity(canvas.getDensity());
                frame.renderFrame(i2, i3, obtain);
                canvas.drawBitmap(obtain, (float) i4, (float) i5, (Paint) null);
                this.mBitmapProvider.release(obtain);
            } catch (IllegalArgumentException | IllegalStateException unused) {
                Log.e(TAG, "Rendering of frame failed. Frame number: " + i);
            } catch (Throwable th) {
                frame.dispose();
                throw th;
            }
            frame.dispose();
        }
    }

    private void cacheFrameBitmap(int i, Bitmap bitmap) {
        this.mFrameBitmapCache.remove(Integer.valueOf(i));
        Bitmap obtain = this.mBitmapProvider.obtain(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        obtain.eraseColor(0);
        obtain.setDensity(bitmap.getDensity());
        Canvas canvas = new Canvas(obtain);
        canvas.drawColor(0, PorterDuff.Mode.SRC);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        this.mFrameBitmapCache.put(Integer.valueOf(i), obtain);
    }

    public void clear() {
        this.mWebPImage.dispose();
        this.mWebPImage = null;
        this.mFrameBitmapCache.evictAll();
        this.rawData = null;
    }

    public void setData(GifHeader gifHeader, byte[] bArr) {
        setData(gifHeader, ByteBuffer.wrap(bArr));
    }

    public void setData(GifHeader gifHeader, ByteBuffer byteBuffer) {
        setData(gifHeader, byteBuffer, 1);
    }

    public void setData(GifHeader gifHeader, ByteBuffer byteBuffer, int i) {
        if (i > 0) {
            int highestOneBit = Integer.highestOneBit(i);
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.rawData = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.sampleSize = highestOneBit;
            this.downsampledWidth = this.mWebPImage.getWidth() / highestOneBit;
            this.downsampledHeight = this.mWebPImage.getHeight() / highestOneBit;
            return;
        }
        throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
    }

    private int prepareCanvasWithBlending(int i, Canvas canvas) {
        while (i >= 0) {
            WebpFrameInfo webpFrameInfo = this.mFrameInfos[i];
            if (webpFrameInfo.disposeBackgroundColor && isFullFrame(webpFrameInfo)) {
                return i + 1;
            }
            Bitmap bitmap = this.mFrameBitmapCache.get(Integer.valueOf(i));
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.setDensity(canvas.getDensity());
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                if (webpFrameInfo.disposeBackgroundColor) {
                    disposeToBackground(canvas, webpFrameInfo);
                }
                return i + 1;
            } else if (isKeyFrame(i)) {
                return i;
            } else {
                i--;
            }
        }
        return 0;
    }

    private void disposeToBackground(Canvas canvas, WebpFrameInfo webpFrameInfo) {
        canvas.drawRect((float) (webpFrameInfo.xOffset / this.sampleSize), (float) (webpFrameInfo.yOffset / this.sampleSize), (float) ((webpFrameInfo.xOffset + webpFrameInfo.width) / this.sampleSize), (float) ((webpFrameInfo.yOffset + webpFrameInfo.height) / this.sampleSize), this.mTransparentFillPaint);
    }

    private boolean isKeyFrame(int i) {
        if (i == 0) {
            return true;
        }
        WebpFrameInfo[] webpFrameInfoArr = this.mFrameInfos;
        WebpFrameInfo webpFrameInfo = webpFrameInfoArr[i];
        WebpFrameInfo webpFrameInfo2 = webpFrameInfoArr[i - 1];
        if (!webpFrameInfo.blendPreviousFrame && isFullFrame(webpFrameInfo)) {
            return true;
        }
        if (!webpFrameInfo2.disposeBackgroundColor || !isFullFrame(webpFrameInfo2)) {
            return false;
        }
        return true;
    }

    private boolean isFullFrame(WebpFrameInfo webpFrameInfo) {
        return webpFrameInfo.xOffset == 0 && webpFrameInfo.yOffset == 0 && webpFrameInfo.width == this.mWebPImage.getWidth() && webpFrameInfo.height == this.mWebPImage.getHeight();
    }
}
