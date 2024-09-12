package com.github.penfeizhou.animation.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.github.penfeizhou.animation.executor.FrameDecoderExecutor;
import com.github.penfeizhou.animation.io.Reader;
import com.github.penfeizhou.animation.io.Writer;
import com.github.penfeizhou.animation.loader.Loader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public abstract class FrameSeqDecoder<R extends Reader, W extends Writer> {
    public static final boolean DEBUG = false;
    /* access modifiers changed from: private */
    public static final Rect RECT_EMPTY = new Rect();
    private static final String TAG = "FrameSeqDecoder";
    private final Set<Bitmap> cacheBitmaps;
    private final Object cacheBitmapsLock;
    protected Map<Bitmap, Canvas> cachedCanvas;
    /* access modifiers changed from: private */
    public boolean finished;
    protected ByteBuffer frameBuffer;
    protected int frameIndex = -1;
    protected List<Frame<R, W>> frames = new ArrayList();
    protected volatile Rect fullRect;
    private Integer loopLimit = null;
    /* access modifiers changed from: private */
    public final Loader mLoader;
    /* access modifiers changed from: private */
    public R mReader;
    private volatile State mState;
    private W mWriter;
    /* access modifiers changed from: private */
    public final AtomicBoolean paused;
    /* access modifiers changed from: private */
    public int playCount;
    /* access modifiers changed from: private */
    public final Set<RenderListener> renderListeners;
    private final Runnable renderTask;
    protected int sampleSize;
    private final int taskId;
    /* access modifiers changed from: private */
    public final Handler workerHandler;

    public interface RenderListener {
        void onEnd();

        void onRender(ByteBuffer byteBuffer);

        void onStart();
    }

    private enum State {
        IDLE,
        RUNNING,
        INITIALIZING,
        FINISHING
    }

    private String debugInfo() {
        return "";
    }

    /* access modifiers changed from: protected */
    public abstract int getLoopCount();

    /* access modifiers changed from: protected */
    public abstract R getReader(Reader reader);

    /* access modifiers changed from: protected */
    public abstract W getWriter();

    /* access modifiers changed from: protected */
    public abstract Rect read(R r) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void release();

    /* access modifiers changed from: protected */
    public abstract void renderFrame(Frame<R, W> frame);

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0062, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x007d, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap obtainBitmap(int r9, int r10) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.cacheBitmapsLock
            monitor-enter(r0)
            java.util.Set<android.graphics.Bitmap> r1 = r8.cacheBitmaps     // Catch:{ all -> 0x007e }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x007e }
            r2 = 0
            r3 = r2
        L_0x000b:
            boolean r4 = r1.hasNext()     // Catch:{ all -> 0x007e }
            if (r4 == 0) goto L_0x0065
            int r3 = r9 * r10
            int r3 = r3 * 4
            java.lang.Object r4 = r1.next()     // Catch:{ all -> 0x007e }
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4     // Catch:{ all -> 0x007e }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x007e }
            r6 = 19
            r7 = 0
            if (r5 < r6) goto L_0x0047
            if (r4 == 0) goto L_0x0063
            int r5 = r4.getAllocationByteCount()     // Catch:{ all -> 0x007e }
            if (r5 < r3) goto L_0x0063
            r1.remove()     // Catch:{ all -> 0x007e }
            int r1 = r4.getWidth()     // Catch:{ all -> 0x007e }
            if (r1 != r9) goto L_0x0039
            int r1 = r4.getHeight()     // Catch:{ all -> 0x007e }
            if (r1 == r10) goto L_0x0042
        L_0x0039:
            if (r9 <= 0) goto L_0x0042
            if (r10 <= 0) goto L_0x0042
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ all -> 0x007e }
            r4.reconfigure(r9, r10, r1)     // Catch:{ all -> 0x007e }
        L_0x0042:
            r4.eraseColor(r7)     // Catch:{ all -> 0x007e }
            monitor-exit(r0)     // Catch:{ all -> 0x007e }
            return r4
        L_0x0047:
            if (r4 == 0) goto L_0x0063
            int r5 = r4.getByteCount()     // Catch:{ all -> 0x007e }
            if (r5 < r3) goto L_0x0063
            int r2 = r4.getWidth()     // Catch:{ all -> 0x007e }
            if (r2 != r9) goto L_0x0061
            int r9 = r4.getHeight()     // Catch:{ all -> 0x007e }
            if (r9 != r10) goto L_0x0061
            r1.remove()     // Catch:{ all -> 0x007e }
            r4.eraseColor(r7)     // Catch:{ all -> 0x007e }
        L_0x0061:
            monitor-exit(r0)     // Catch:{ all -> 0x007e }
            return r4
        L_0x0063:
            r3 = r4
            goto L_0x000b
        L_0x0065:
            if (r9 <= 0) goto L_0x007c
            if (r10 > 0) goto L_0x006a
            goto L_0x007c
        L_0x006a:
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ Exception -> 0x0076, OutOfMemoryError -> 0x0071 }
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r9, r10, r1)     // Catch:{ Exception -> 0x0076, OutOfMemoryError -> 0x0071 }
            goto L_0x007a
        L_0x0071:
            r9 = move-exception
            r9.printStackTrace()     // Catch:{ all -> 0x007e }
            goto L_0x007a
        L_0x0076:
            r9 = move-exception
            r9.printStackTrace()     // Catch:{ all -> 0x007e }
        L_0x007a:
            monitor-exit(r0)     // Catch:{ all -> 0x007e }
            return r3
        L_0x007c:
            monitor-exit(r0)     // Catch:{ all -> 0x007e }
            return r2
        L_0x007e:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007e }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.penfeizhou.animation.decode.FrameSeqDecoder.obtainBitmap(int, int):android.graphics.Bitmap");
    }

    /* access modifiers changed from: protected */
    public void recycleBitmap(Bitmap bitmap) {
        synchronized (this.cacheBitmapsLock) {
            if (bitmap != null) {
                this.cacheBitmaps.add(bitmap);
            }
        }
    }

    public FrameSeqDecoder(Loader loader, RenderListener renderListener) {
        HashSet hashSet = new HashSet();
        this.renderListeners = hashSet;
        this.paused = new AtomicBoolean(true);
        this.renderTask = new Runnable() {
            public void run() {
                if (!FrameSeqDecoder.this.paused.get()) {
                    if (FrameSeqDecoder.this.canStep()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        FrameSeqDecoder.this.workerHandler.postDelayed(this, Math.max(0, FrameSeqDecoder.this.step() - (System.currentTimeMillis() - currentTimeMillis)));
                        for (RenderListener onRender : FrameSeqDecoder.this.renderListeners) {
                            onRender.onRender(FrameSeqDecoder.this.frameBuffer);
                        }
                        return;
                    }
                    FrameSeqDecoder.this.stop();
                }
            }
        };
        this.sampleSize = 1;
        this.cacheBitmaps = new HashSet();
        this.cacheBitmapsLock = new Object();
        this.cachedCanvas = new WeakHashMap();
        this.mWriter = getWriter();
        this.mReader = null;
        this.finished = false;
        this.mState = State.IDLE;
        this.mLoader = loader;
        if (renderListener != null) {
            hashSet.add(renderListener);
        }
        int generateTaskId = FrameDecoderExecutor.getInstance().generateTaskId();
        this.taskId = generateTaskId;
        this.workerHandler = new Handler(FrameDecoderExecutor.getInstance().getLooper(generateTaskId));
    }

    public void addRenderListener(final RenderListener renderListener) {
        this.workerHandler.post(new Runnable() {
            public void run() {
                FrameSeqDecoder.this.renderListeners.add(renderListener);
            }
        });
    }

    public void removeRenderListener(final RenderListener renderListener) {
        this.workerHandler.post(new Runnable() {
            public void run() {
                FrameSeqDecoder.this.renderListeners.remove(renderListener);
            }
        });
    }

    public void stopIfNeeded() {
        this.workerHandler.post(new Runnable() {
            public void run() {
                if (FrameSeqDecoder.this.renderListeners.size() == 0) {
                    FrameSeqDecoder.this.stop();
                }
            }
        });
    }

    public Rect getBounds() {
        if (this.fullRect == null) {
            if (this.mState == State.FINISHING) {
                Log.e(TAG, "In finishing,do not interrupt");
            }
            final Thread currentThread = Thread.currentThread();
            this.workerHandler.post(new Runnable() {
                public void run() {
                    try {
                        if (FrameSeqDecoder.this.fullRect == null) {
                            if (FrameSeqDecoder.this.mReader == null) {
                                FrameSeqDecoder frameSeqDecoder = FrameSeqDecoder.this;
                                Reader unused = frameSeqDecoder.mReader = frameSeqDecoder.getReader(frameSeqDecoder.mLoader.obtain());
                            } else {
                                FrameSeqDecoder.this.mReader.reset();
                            }
                            FrameSeqDecoder frameSeqDecoder2 = FrameSeqDecoder.this;
                            frameSeqDecoder2.initCanvasBounds(frameSeqDecoder2.read(frameSeqDecoder2.mReader));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        FrameSeqDecoder.this.fullRect = FrameSeqDecoder.RECT_EMPTY;
                    } catch (Throwable th) {
                        LockSupport.unpark(currentThread);
                        throw th;
                    }
                    LockSupport.unpark(currentThread);
                }
            });
            LockSupport.park(currentThread);
        }
        return this.fullRect == null ? RECT_EMPTY : this.fullRect;
    }

    /* access modifiers changed from: private */
    public void initCanvasBounds(Rect rect) {
        this.fullRect = rect;
        int width = rect.width() * rect.height();
        int i = this.sampleSize;
        this.frameBuffer = ByteBuffer.allocate(((width / (i * i)) + 1) * 4);
        if (this.mWriter == null) {
            this.mWriter = getWriter();
        }
    }

    public int getFrameCount() {
        return this.frames.size();
    }

    public void start() {
        if (this.fullRect != RECT_EMPTY) {
            if (this.mState == State.RUNNING || this.mState == State.INITIALIZING) {
                Log.i(TAG, debugInfo() + " Already started");
                return;
            }
            if (this.mState == State.FINISHING) {
                Log.e(TAG, debugInfo() + " Processing,wait for finish at " + this.mState);
            }
            this.mState = State.INITIALIZING;
            if (Looper.myLooper() == this.workerHandler.getLooper()) {
                innerStart();
            } else {
                this.workerHandler.post(new Runnable() {
                    public void run() {
                        FrameSeqDecoder.this.innerStart();
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void innerStart() {
        this.paused.compareAndSet(true, false);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.frames.size() == 0) {
                R r = this.mReader;
                if (r == null) {
                    this.mReader = getReader(this.mLoader.obtain());
                } else {
                    r.reset();
                }
                initCanvasBounds(read(this.mReader));
            }
        } catch (Throwable th) {
            Log.i(TAG, debugInfo() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - currentTimeMillis));
            this.mState = State.RUNNING;
            throw th;
        }
        String str = TAG;
        Log.i(str, debugInfo() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - currentTimeMillis));
        this.mState = State.RUNNING;
        if (getNumPlays() == 0 || !this.finished) {
            this.frameIndex = -1;
            this.renderTask.run();
            for (RenderListener onStart : this.renderListeners) {
                onStart.onStart();
            }
            return;
        }
        Log.i(str, debugInfo() + " No need to started");
    }

    /* access modifiers changed from: private */
    public void innerStop() {
        this.workerHandler.removeCallbacks(this.renderTask);
        this.frames.clear();
        synchronized (this.cacheBitmapsLock) {
            for (Bitmap next : this.cacheBitmaps) {
                if (next != null && !next.isRecycled()) {
                    next.recycle();
                }
            }
            this.cacheBitmaps.clear();
        }
        if (this.frameBuffer != null) {
            this.frameBuffer = null;
        }
        this.cachedCanvas.clear();
        try {
            R r = this.mReader;
            if (r != null) {
                r.close();
                this.mReader = null;
            }
            W w = this.mWriter;
            if (w != null) {
                w.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        release();
        this.mState = State.IDLE;
        for (RenderListener onEnd : this.renderListeners) {
            onEnd.onEnd();
        }
    }

    public void stop() {
        if (this.fullRect != RECT_EMPTY) {
            if (this.mState == State.FINISHING || this.mState == State.IDLE) {
                Log.i(TAG, debugInfo() + "No need to stop");
                return;
            }
            if (this.mState == State.INITIALIZING) {
                Log.e(TAG, debugInfo() + "Processing,wait for finish at " + this.mState);
            }
            this.mState = State.FINISHING;
            if (Looper.myLooper() == this.workerHandler.getLooper()) {
                innerStop();
            } else {
                this.workerHandler.post(new Runnable() {
                    public void run() {
                        FrameSeqDecoder.this.innerStop();
                    }
                });
            }
        }
    }

    public boolean isRunning() {
        return this.mState == State.RUNNING || this.mState == State.INITIALIZING;
    }

    public boolean isPaused() {
        return this.paused.get();
    }

    public void setLoopLimit(int i) {
        this.loopLimit = Integer.valueOf(i);
    }

    public void reset() {
        this.workerHandler.post(new Runnable() {
            public void run() {
                int unused = FrameSeqDecoder.this.playCount = 0;
                FrameSeqDecoder.this.frameIndex = -1;
                boolean unused2 = FrameSeqDecoder.this.finished = false;
            }
        });
    }

    public void pause() {
        this.workerHandler.removeCallbacks(this.renderTask);
        this.paused.compareAndSet(false, true);
    }

    public void resume() {
        this.paused.compareAndSet(true, false);
        this.workerHandler.removeCallbacks(this.renderTask);
        this.workerHandler.post(this.renderTask);
    }

    public int getSampleSize() {
        return this.sampleSize;
    }

    public boolean setDesiredSize(int i, int i2) {
        final int desiredSample = getDesiredSample(i, i2);
        if (desiredSample == this.sampleSize) {
            return false;
        }
        final boolean isRunning = isRunning();
        this.workerHandler.removeCallbacks(this.renderTask);
        this.workerHandler.post(new Runnable() {
            public void run() {
                FrameSeqDecoder.this.innerStop();
                try {
                    FrameSeqDecoder.this.sampleSize = desiredSample;
                    FrameSeqDecoder frameSeqDecoder = FrameSeqDecoder.this;
                    frameSeqDecoder.initCanvasBounds(frameSeqDecoder.read(frameSeqDecoder.getReader(frameSeqDecoder.mLoader.obtain())));
                    if (isRunning) {
                        FrameSeqDecoder.this.innerStart();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        return true;
    }

    /* access modifiers changed from: protected */
    public int getDesiredSample(int i, int i2) {
        int i3 = 1;
        if (i != 0 && i2 != 0) {
            int min = Math.min(getBounds().width() / i, getBounds().height() / i2);
            while (true) {
                int i4 = i3 * 2;
                if (i4 > min) {
                    break;
                }
                i3 = i4;
            }
        }
        return i3;
    }

    private int getNumPlays() {
        Integer num = this.loopLimit;
        return num != null ? num.intValue() : getLoopCount();
    }

    /* access modifiers changed from: private */
    public boolean canStep() {
        if (!isRunning() || this.frames.size() == 0) {
            return false;
        }
        if (getNumPlays() <= 0 || this.playCount < getNumPlays() - 1) {
            return true;
        }
        if (this.playCount == getNumPlays() - 1 && this.frameIndex < getFrameCount() - 1) {
            return true;
        }
        this.finished = true;
        return false;
    }

    /* access modifiers changed from: private */
    public long step() {
        int i = this.frameIndex + 1;
        this.frameIndex = i;
        if (i >= getFrameCount()) {
            this.frameIndex = 0;
            this.playCount++;
        }
        Frame frame = getFrame(this.frameIndex);
        if (frame == null) {
            return 0;
        }
        renderFrame(frame);
        return (long) frame.frameDuration;
    }

    public Frame<R, W> getFrame(int i) {
        if (i < 0 || i >= this.frames.size()) {
            return null;
        }
        return this.frames.get(i);
    }

    public Bitmap getFrameBitmap(int i) throws IOException {
        if (this.mState != State.IDLE) {
            Log.e(TAG, debugInfo() + ",stop first");
            return null;
        }
        this.mState = State.RUNNING;
        int i2 = 0;
        this.paused.compareAndSet(true, false);
        if (this.frames.size() == 0) {
            R r = this.mReader;
            if (r == null) {
                this.mReader = getReader(this.mLoader.obtain());
            } else {
                r.reset();
            }
            initCanvasBounds(read(this.mReader));
        }
        if (i < 0) {
            i += this.frames.size();
        }
        if (i >= 0) {
            i2 = i;
        }
        this.frameIndex = -1;
        while (this.frameIndex < i2 && canStep()) {
            step();
        }
        this.frameBuffer.rewind();
        Bitmap createBitmap = Bitmap.createBitmap(getBounds().width() / getSampleSize(), getBounds().height() / getSampleSize(), Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(this.frameBuffer);
        innerStop();
        return createBitmap;
    }

    public int getMemorySize() {
        int i;
        int i2;
        synchronized (this.cacheBitmapsLock) {
            i = 0;
            for (Bitmap next : this.cacheBitmaps) {
                if (!next.isRecycled()) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        i2 = next.getAllocationByteCount();
                    } else {
                        i2 = next.getByteCount();
                    }
                    i += i2;
                }
            }
            ByteBuffer byteBuffer = this.frameBuffer;
            if (byteBuffer != null) {
                i += byteBuffer.capacity();
            }
        }
        return i;
    }
}
