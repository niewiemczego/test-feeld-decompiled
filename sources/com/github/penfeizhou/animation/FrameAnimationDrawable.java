package com.github.penfeizhou.animation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.github.penfeizhou.animation.decode.FrameSeqDecoder;
import com.github.penfeizhou.animation.loader.Loader;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class FrameAnimationDrawable<Decoder extends FrameSeqDecoder<?, ?>> extends Drawable implements Animatable2Compat, FrameSeqDecoder.RenderListener {
    private static final int MSG_ANIMATION_END = 2;
    private static final int MSG_ANIMATION_START = 1;
    private static final String TAG = "FrameAnimationDrawable";
    /* access modifiers changed from: private */
    public final Set<Animatable2Compat.AnimationCallback> animationCallbacks = new HashSet();
    private boolean autoPlay = true;
    private Bitmap bitmap;
    private final DrawFilter drawFilter = new PaintFlagsDrawFilter(0, 3);
    private final Decoder frameSeqDecoder;
    private final Runnable invalidateRunnable = new Runnable() {
        public void run() {
            FrameAnimationDrawable.this.invalidateSelf();
        }
    };
    private final Matrix matrix = new Matrix();
    private boolean noMeasure = false;
    private final Set<WeakReference<Drawable.Callback>> obtainedCallbacks = new HashSet();
    private final Paint paint;
    private final Handler uiHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                Iterator it = new ArrayList(FrameAnimationDrawable.this.animationCallbacks).iterator();
                while (it.hasNext()) {
                    ((Animatable2Compat.AnimationCallback) it.next()).onAnimationStart(FrameAnimationDrawable.this);
                }
            } else if (i == 2) {
                Iterator it2 = new ArrayList(FrameAnimationDrawable.this.animationCallbacks).iterator();
                while (it2.hasNext()) {
                    ((Animatable2Compat.AnimationCallback) it2.next()).onAnimationEnd(FrameAnimationDrawable.this);
                }
            }
        }
    };

    /* access modifiers changed from: protected */
    public abstract Decoder createFrameSeqDecoder(Loader loader, FrameSeqDecoder.RenderListener renderListener);

    public int getOpacity() {
        return -3;
    }

    public FrameAnimationDrawable(Decoder decoder) {
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setAntiAlias(true);
        this.frameSeqDecoder = decoder;
    }

    public FrameAnimationDrawable(Loader loader) {
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setAntiAlias(true);
        this.frameSeqDecoder = createFrameSeqDecoder(loader, this);
    }

    public void setAutoPlay(boolean z) {
        this.autoPlay = z;
    }

    public void setNoMeasure(boolean z) {
        this.noMeasure = z;
    }

    public void setLoopLimit(int i) {
        this.frameSeqDecoder.setLoopLimit(i);
    }

    public void reset() {
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.bitmap.eraseColor(0);
        }
        this.frameSeqDecoder.reset();
    }

    public void pause() {
        this.frameSeqDecoder.pause();
    }

    public void resume() {
        this.frameSeqDecoder.resume();
    }

    public boolean isPaused() {
        return this.frameSeqDecoder.isPaused();
    }

    public void start() {
        if (this.frameSeqDecoder.isRunning()) {
            this.frameSeqDecoder.stop();
        }
        this.frameSeqDecoder.reset();
        innerStart();
    }

    private void innerStart() {
        this.frameSeqDecoder.addRenderListener(this);
        if (this.autoPlay) {
            this.frameSeqDecoder.start();
        } else if (!this.frameSeqDecoder.isRunning()) {
            this.frameSeqDecoder.start();
        }
    }

    public void stop() {
        innerStop();
    }

    private void innerStop() {
        this.frameSeqDecoder.removeRenderListener(this);
        if (this.autoPlay) {
            this.frameSeqDecoder.stop();
        } else {
            this.frameSeqDecoder.stopIfNeeded();
        }
    }

    public boolean isRunning() {
        return this.frameSeqDecoder.isRunning();
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            canvas.setDrawFilter(this.drawFilter);
            canvas.drawBitmap(this.bitmap, this.matrix, this.paint);
        }
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        boolean desiredSize = this.frameSeqDecoder.setDesiredSize(getBounds().width(), getBounds().height());
        this.matrix.setScale(((((float) getBounds().width()) * 1.0f) * ((float) this.frameSeqDecoder.getSampleSize())) / ((float) this.frameSeqDecoder.getBounds().width()), ((((float) getBounds().height()) * 1.0f) * ((float) this.frameSeqDecoder.getSampleSize())) / ((float) this.frameSeqDecoder.getBounds().height()));
        if (desiredSize) {
            this.bitmap = Bitmap.createBitmap(this.frameSeqDecoder.getBounds().width() / this.frameSeqDecoder.getSampleSize(), this.frameSeqDecoder.getBounds().height() / this.frameSeqDecoder.getSampleSize(), Bitmap.Config.ARGB_8888);
        }
    }

    public void setAlpha(int i) {
        this.paint.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    public void onStart() {
        Message.obtain(this.uiHandler, 1).sendToTarget();
    }

    public void onRender(ByteBuffer byteBuffer) {
        if (isRunning()) {
            Bitmap bitmap2 = this.bitmap;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                this.bitmap = Bitmap.createBitmap(this.frameSeqDecoder.getBounds().width() / this.frameSeqDecoder.getSampleSize(), this.frameSeqDecoder.getBounds().height() / this.frameSeqDecoder.getSampleSize(), Bitmap.Config.ARGB_8888);
            }
            byteBuffer.rewind();
            if (byteBuffer.remaining() < this.bitmap.getByteCount()) {
                Log.e(TAG, "onRender:Buffer not large enough for pixels");
                return;
            }
            this.bitmap.copyPixelsFromBuffer(byteBuffer);
            this.uiHandler.post(this.invalidateRunnable);
        }
    }

    public void onEnd() {
        Message.obtain(this.uiHandler, 2).sendToTarget();
    }

    public boolean setVisible(boolean z, boolean z2) {
        hookRecordCallbacks();
        if (this.autoPlay) {
            if (z) {
                if (!isRunning()) {
                    innerStart();
                }
            } else if (isRunning()) {
                innerStop();
            }
        }
        return super.setVisible(z, z2);
    }

    public int getIntrinsicWidth() {
        if (this.noMeasure) {
            return -1;
        }
        try {
            return this.frameSeqDecoder.getBounds().width();
        } catch (Exception unused) {
            return 0;
        }
    }

    public int getIntrinsicHeight() {
        if (this.noMeasure) {
            return -1;
        }
        try {
            return this.frameSeqDecoder.getBounds().height();
        } catch (Exception unused) {
            return 0;
        }
    }

    public void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        this.animationCallbacks.add(animationCallback);
    }

    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        return this.animationCallbacks.remove(animationCallback);
    }

    public void clearAnimationCallbacks() {
        this.animationCallbacks.clear();
    }

    public int getMemorySize() {
        int i;
        int memorySize = this.frameSeqDecoder.getMemorySize();
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            if (Build.VERSION.SDK_INT >= 19) {
                i = this.bitmap.getAllocationByteCount();
            } else {
                i = this.bitmap.getByteCount();
            }
            memorySize += i;
        }
        return Math.max(1, memorySize);
    }

    public Drawable.Callback getCallback() {
        return super.getCallback();
    }

    private void hookRecordCallbacks() {
        ArrayList<WeakReference> arrayList = new ArrayList<>();
        Drawable.Callback callback = getCallback();
        boolean z = false;
        for (WeakReference weakReference : new HashSet(this.obtainedCallbacks)) {
            Drawable.Callback callback2 = (Drawable.Callback) weakReference.get();
            if (callback2 == null) {
                arrayList.add(weakReference);
            } else if (callback2 == callback) {
                z = true;
            } else {
                callback2.invalidateDrawable(this);
            }
        }
        for (WeakReference remove : arrayList) {
            this.obtainedCallbacks.remove(remove);
        }
        if (!z) {
            this.obtainedCallbacks.add(new WeakReference(callback));
        }
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        for (WeakReference weakReference : new HashSet(this.obtainedCallbacks)) {
            Drawable.Callback callback = (Drawable.Callback) weakReference.get();
            if (!(callback == null || callback == getCallback())) {
                callback.invalidateDrawable(this);
            }
        }
    }

    public Decoder getFrameSeqDecoder() {
        return this.frameSeqDecoder;
    }
}
