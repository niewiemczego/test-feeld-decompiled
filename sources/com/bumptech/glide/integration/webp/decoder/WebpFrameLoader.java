package com.bumptech.glide.integration.webp.decoder;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class WebpFrameLoader {
    public static final Option<WebpFrameCacheStrategy> FRAME_CACHE_STRATEGY = Option.memory("com.bumptech.glide.integration.webp.decoder.WebpFrameLoader.CacheStrategy", WebpFrameCacheStrategy.AUTO);
    private final BitmapPool bitmapPool;
    private final List<FrameCallback> callbacks;
    private DelayTarget current;
    private Bitmap firstFrame;
    private int firstFrameSize;
    private final Handler handler;
    private int height;
    private boolean isCleared;
    private boolean isLoadPending;
    private boolean isRunning;
    private DelayTarget next;
    private OnEveryFrameListener onEveryFrameListener;
    private DelayTarget pendingTarget;
    private RequestBuilder<Bitmap> requestBuilder;
    final RequestManager requestManager;
    private boolean startFromFirstFrame;
    private Transformation<Bitmap> transformation;
    private final WebpDecoder webpDecoder;
    private int width;

    public interface FrameCallback {
        void onFrameReady();
    }

    interface OnEveryFrameListener {
        void onFrameReady();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WebpFrameLoader(Glide glide, WebpDecoder webpDecoder2, int i, int i2, Transformation<Bitmap> transformation2, Bitmap bitmap) {
        this(glide.getBitmapPool(), Glide.with(glide.getContext()), webpDecoder2, (Handler) null, getRequestBuilder(Glide.with(glide.getContext()), i, i2), transformation2, bitmap);
        Handler handler2 = null;
    }

    WebpFrameLoader(BitmapPool bitmapPool2, RequestManager requestManager2, WebpDecoder webpDecoder2, Handler handler2, RequestBuilder<Bitmap> requestBuilder2, Transformation<Bitmap> transformation2, Bitmap bitmap) {
        this.callbacks = new ArrayList();
        this.isRunning = false;
        this.isLoadPending = false;
        this.startFromFirstFrame = false;
        this.requestManager = requestManager2;
        handler2 = handler2 == null ? new Handler(Looper.getMainLooper(), new FrameLoaderCallback()) : handler2;
        this.bitmapPool = bitmapPool2;
        this.handler = handler2;
        this.requestBuilder = requestBuilder2;
        this.webpDecoder = webpDecoder2;
        setFrameTransformation(transformation2, bitmap);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation, java.lang.Object, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setFrameTransformation(com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r3, android.graphics.Bitmap r4) {
        /*
            r2 = this;
            java.lang.Object r0 = com.bumptech.glide.util.Preconditions.checkNotNull(r3)
            com.bumptech.glide.load.Transformation r0 = (com.bumptech.glide.load.Transformation) r0
            r2.transformation = r0
            java.lang.Object r0 = com.bumptech.glide.util.Preconditions.checkNotNull(r4)
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            r2.firstFrame = r0
            com.bumptech.glide.RequestBuilder<android.graphics.Bitmap> r0 = r2.requestBuilder
            com.bumptech.glide.request.RequestOptions r1 = new com.bumptech.glide.request.RequestOptions
            r1.<init>()
            com.bumptech.glide.request.BaseRequestOptions r3 = r1.transform((com.bumptech.glide.load.Transformation<android.graphics.Bitmap>) r3)
            com.bumptech.glide.RequestBuilder r3 = r0.apply((com.bumptech.glide.request.BaseRequestOptions<?>) r3)
            r2.requestBuilder = r3
            int r3 = com.bumptech.glide.util.Util.getBitmapByteSize(r4)
            r2.firstFrameSize = r3
            int r3 = r4.getWidth()
            r2.width = r3
            int r3 = r4.getHeight()
            r2.height = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.integration.webp.decoder.WebpFrameLoader.setFrameTransformation(com.bumptech.glide.load.Transformation, android.graphics.Bitmap):void");
    }

    /* access modifiers changed from: package-private */
    public Transformation<Bitmap> getFrameTransformation() {
        return this.transformation;
    }

    /* access modifiers changed from: package-private */
    public Bitmap getFirstFrame() {
        return this.firstFrame;
    }

    /* access modifiers changed from: package-private */
    public void subscribe(FrameCallback frameCallback) {
        if (this.isCleared) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        } else if (!this.callbacks.contains(frameCallback)) {
            boolean isEmpty = this.callbacks.isEmpty();
            this.callbacks.add(frameCallback);
            if (isEmpty) {
                start();
            }
        } else {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
    }

    /* access modifiers changed from: package-private */
    public void unsubscribe(FrameCallback frameCallback) {
        this.callbacks.remove(frameCallback);
        if (this.callbacks.isEmpty()) {
            stop();
        }
    }

    /* access modifiers changed from: package-private */
    public int getWidth() {
        return this.width;
    }

    /* access modifiers changed from: package-private */
    public int getHeight() {
        return this.height;
    }

    /* access modifiers changed from: package-private */
    public int getSize() {
        return this.webpDecoder.getByteSize() + this.firstFrameSize;
    }

    /* access modifiers changed from: package-private */
    public int getCurrentIndex() {
        DelayTarget delayTarget = this.current;
        if (delayTarget != null) {
            return delayTarget.index;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer getBuffer() {
        return this.webpDecoder.getData().asReadOnlyBuffer();
    }

    /* access modifiers changed from: package-private */
    public int getFrameCount() {
        return this.webpDecoder.getFrameCount();
    }

    /* access modifiers changed from: package-private */
    public int getLoopCount() {
        return this.webpDecoder.getTotalIterationCount();
    }

    private void start() {
        if (!this.isRunning) {
            this.isRunning = true;
            this.isCleared = false;
            loadNextFrame();
        }
    }

    private void stop() {
        this.isRunning = false;
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.callbacks.clear();
        recycleFirstFrame();
        stop();
        DelayTarget delayTarget = this.current;
        if (delayTarget != null) {
            this.requestManager.clear((Target<?>) delayTarget);
            this.current = null;
        }
        DelayTarget delayTarget2 = this.next;
        if (delayTarget2 != null) {
            this.requestManager.clear((Target<?>) delayTarget2);
            this.next = null;
        }
        DelayTarget delayTarget3 = this.pendingTarget;
        if (delayTarget3 != null) {
            this.requestManager.clear((Target<?>) delayTarget3);
            this.pendingTarget = null;
        }
        this.webpDecoder.clear();
        this.isCleared = true;
    }

    /* access modifiers changed from: package-private */
    public Bitmap getCurrentFrame() {
        DelayTarget delayTarget = this.current;
        return delayTarget != null ? delayTarget.getResource() : this.firstFrame;
    }

    private void loadNextFrame() {
        if (this.isRunning && !this.isLoadPending) {
            if (this.startFromFirstFrame) {
                Preconditions.checkArgument(this.pendingTarget == null, "Pending target must be null when starting from the first frame");
                this.webpDecoder.resetFrameIndex();
                this.startFromFirstFrame = false;
            }
            DelayTarget delayTarget = this.pendingTarget;
            if (delayTarget != null) {
                this.pendingTarget = null;
                onFrameReady(delayTarget);
                return;
            }
            this.isLoadPending = true;
            int nextDelay = this.webpDecoder.getNextDelay();
            this.webpDecoder.advance();
            int currentFrameIndex = this.webpDecoder.getCurrentFrameIndex();
            this.next = new DelayTarget(this.handler, currentFrameIndex, SystemClock.uptimeMillis() + ((long) nextDelay));
            this.requestBuilder.apply((BaseRequestOptions<?>) (RequestOptions) RequestOptions.signatureOf(getFrameSignature(currentFrameIndex)).skipMemoryCache(this.webpDecoder.getCacheStrategy().noCache())).load((Object) this.webpDecoder).into(this.next);
        }
    }

    private void recycleFirstFrame() {
        Bitmap bitmap = this.firstFrame;
        if (bitmap != null) {
            this.bitmapPool.put(bitmap);
            this.firstFrame = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void setNextStartFromFirstFrame() {
        Preconditions.checkArgument(!this.isRunning, "Can't restart a running animation");
        this.startFromFirstFrame = true;
        DelayTarget delayTarget = this.pendingTarget;
        if (delayTarget != null) {
            this.requestManager.clear((Target<?>) delayTarget);
            this.pendingTarget = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void setOnEveryFrameReadyListener(OnEveryFrameListener onEveryFrameListener2) {
        this.onEveryFrameListener = onEveryFrameListener2;
    }

    /* access modifiers changed from: package-private */
    public void onFrameReady(DelayTarget delayTarget) {
        OnEveryFrameListener onEveryFrameListener2 = this.onEveryFrameListener;
        if (onEveryFrameListener2 != null) {
            onEveryFrameListener2.onFrameReady();
        }
        this.isLoadPending = false;
        if (this.isCleared) {
            this.handler.obtainMessage(2, delayTarget).sendToTarget();
        } else if (this.isRunning) {
            if (delayTarget.getResource() != null) {
                recycleFirstFrame();
                DelayTarget delayTarget2 = this.current;
                this.current = delayTarget;
                for (int size = this.callbacks.size() - 1; size >= 0; size--) {
                    this.callbacks.get(size).onFrameReady();
                }
                if (delayTarget2 != null) {
                    this.handler.obtainMessage(2, delayTarget2).sendToTarget();
                }
            }
            loadNextFrame();
        } else if (this.startFromFirstFrame) {
            this.handler.obtainMessage(2, delayTarget).sendToTarget();
        } else {
            this.pendingTarget = delayTarget;
        }
    }

    private class FrameLoaderCallback implements Handler.Callback {
        static final int MSG_CLEAR = 2;
        static final int MSG_DELAY = 1;

        FrameLoaderCallback() {
        }

        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                WebpFrameLoader.this.onFrameReady((DelayTarget) message.obj);
                return true;
            } else if (message.what != 2) {
                return false;
            } else {
                WebpFrameLoader.this.requestManager.clear((Target<?>) (DelayTarget) message.obj);
                return false;
            }
        }
    }

    static class DelayTarget extends CustomTarget<Bitmap> {
        private final Handler handler;
        final int index;
        private Bitmap resource;
        private final long targetTime;

        DelayTarget(Handler handler2, int i, long j) {
            this.handler = handler2;
            this.index = i;
            this.targetTime = j;
        }

        /* access modifiers changed from: package-private */
        public Bitmap getResource() {
            return this.resource;
        }

        public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
            this.resource = bitmap;
            this.handler.sendMessageAtTime(this.handler.obtainMessage(1, this), this.targetTime);
        }

        public void onLoadCleared(Drawable drawable) {
            this.resource = null;
        }
    }

    private static RequestBuilder<Bitmap> getRequestBuilder(RequestManager requestManager2, int i, int i2) {
        return requestManager2.asBitmap().apply((BaseRequestOptions<?>) ((RequestOptions) ((RequestOptions) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE).useAnimationPool(true)).skipMemoryCache(true)).override(i, i2));
    }

    private Key getFrameSignature(int i) {
        return new WebpFrameCacheKey(new ObjectKey(this.webpDecoder), i);
    }

    private static class WebpFrameCacheKey implements Key {
        private final int frameIndex;
        private final Key sourceKey;

        WebpFrameCacheKey(Key key, int i) {
            this.sourceKey = key;
            this.frameIndex = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof WebpFrameCacheKey)) {
                return false;
            }
            WebpFrameCacheKey webpFrameCacheKey = (WebpFrameCacheKey) obj;
            if (!this.sourceKey.equals(webpFrameCacheKey.sourceKey) || this.frameIndex != webpFrameCacheKey.frameIndex) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.sourceKey.hashCode() * 31) + this.frameIndex;
        }

        public void updateDiskCacheKey(MessageDigest messageDigest) {
            messageDigest.update(ByteBuffer.allocate(12).putInt(this.frameIndex).array());
            this.sourceKey.updateDiskCacheKey(messageDigest);
        }
    }
}
