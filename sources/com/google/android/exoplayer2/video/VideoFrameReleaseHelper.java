package com.google.android.exoplayer2.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;

public final class VideoFrameReleaseHelper {
    private static final long MAX_ALLOWED_ADJUSTMENT_NS = 20000000;
    private static final int MINIMUM_FRAMES_WITHOUT_SYNC_TO_CLEAR_SURFACE_FRAME_RATE = 30;
    private static final long MINIMUM_MATCHING_FRAME_DURATION_FOR_HIGH_CONFIDENCE_NS = 5000000000L;
    private static final float MINIMUM_MEDIA_FRAME_RATE_CHANGE_FOR_UPDATE_HIGH_CONFIDENCE = 0.02f;
    private static final float MINIMUM_MEDIA_FRAME_RATE_CHANGE_FOR_UPDATE_LOW_CONFIDENCE = 1.0f;
    private static final String TAG = "VideoFrameReleaseHelper";
    private static final long VSYNC_OFFSET_PERCENTAGE = 80;
    private static final long VSYNC_SAMPLE_UPDATE_PERIOD_MS = 500;
    private int changeFrameRateStrategy;
    private final DisplayHelper displayHelper;
    private float formatFrameRate;
    private long frameIndex;
    private final FixedFrameRateEstimator frameRateEstimator = new FixedFrameRateEstimator();
    private long lastAdjustedFrameIndex;
    private long lastAdjustedReleaseTimeNs;
    private long pendingLastAdjustedFrameIndex;
    private long pendingLastAdjustedReleaseTimeNs;
    private float playbackSpeed;
    private boolean started;
    private Surface surface;
    private float surfaceMediaFrameRate;
    private float surfacePlaybackFrameRate;
    private long vsyncDurationNs;
    private long vsyncOffsetNs;
    private final VSyncSampler vsyncSampler;

    private interface DisplayHelper {

        public interface Listener {
            void onDefaultDisplayChanged(Display display);
        }

        void register(Listener listener);

        void unregister();
    }

    public VideoFrameReleaseHelper(Context context) {
        DisplayHelper maybeBuildDisplayHelper = maybeBuildDisplayHelper(context);
        this.displayHelper = maybeBuildDisplayHelper;
        this.vsyncSampler = maybeBuildDisplayHelper != null ? VSyncSampler.getInstance() : null;
        this.vsyncDurationNs = C.TIME_UNSET;
        this.vsyncOffsetNs = C.TIME_UNSET;
        this.formatFrameRate = -1.0f;
        this.playbackSpeed = 1.0f;
        this.changeFrameRateStrategy = 0;
    }

    public void setChangeFrameRateStrategy(int i) {
        if (this.changeFrameRateStrategy != i) {
            this.changeFrameRateStrategy = i;
            updateSurfacePlaybackFrameRate(true);
        }
    }

    public void onStarted() {
        this.started = true;
        resetAdjustment();
        if (this.displayHelper != null) {
            ((VSyncSampler) Assertions.checkNotNull(this.vsyncSampler)).addObserver();
            this.displayHelper.register(new VideoFrameReleaseHelper$$ExternalSyntheticLambda0(this));
        }
        updateSurfacePlaybackFrameRate(false);
    }

    public void onSurfaceChanged(Surface surface2) {
        if (surface2 instanceof PlaceholderSurface) {
            surface2 = null;
        }
        if (this.surface != surface2) {
            clearSurfaceFrameRate();
            this.surface = surface2;
            updateSurfacePlaybackFrameRate(true);
        }
    }

    public void onPositionReset() {
        resetAdjustment();
    }

    public void onPlaybackSpeed(float f) {
        this.playbackSpeed = f;
        resetAdjustment();
        updateSurfacePlaybackFrameRate(false);
    }

    public void onFormatChanged(float f) {
        this.formatFrameRate = f;
        this.frameRateEstimator.reset();
        updateSurfaceMediaFrameRate();
    }

    public void onNextFrame(long j) {
        long j2 = this.pendingLastAdjustedFrameIndex;
        if (j2 != -1) {
            this.lastAdjustedFrameIndex = j2;
            this.lastAdjustedReleaseTimeNs = this.pendingLastAdjustedReleaseTimeNs;
        }
        this.frameIndex++;
        this.frameRateEstimator.onNextFrame(j * 1000);
        updateSurfaceMediaFrameRate();
    }

    public void onStopped() {
        this.started = false;
        DisplayHelper displayHelper2 = this.displayHelper;
        if (displayHelper2 != null) {
            displayHelper2.unregister();
            ((VSyncSampler) Assertions.checkNotNull(this.vsyncSampler)).removeObserver();
        }
        clearSurfaceFrameRate();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long adjustReleaseTime(long r11) {
        /*
            r10 = this;
            long r0 = r10.lastAdjustedFrameIndex
            r2 = -1
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x002f
            com.google.android.exoplayer2.video.FixedFrameRateEstimator r0 = r10.frameRateEstimator
            boolean r0 = r0.isSynced()
            if (r0 == 0) goto L_0x002f
            com.google.android.exoplayer2.video.FixedFrameRateEstimator r0 = r10.frameRateEstimator
            long r0 = r0.getFrameDurationNs()
            long r2 = r10.lastAdjustedReleaseTimeNs
            long r4 = r10.frameIndex
            long r6 = r10.lastAdjustedFrameIndex
            long r4 = r4 - r6
            long r0 = r0 * r4
            float r0 = (float) r0
            float r1 = r10.playbackSpeed
            float r0 = r0 / r1
            long r0 = (long) r0
            long r2 = r2 + r0
            boolean r0 = adjustmentAllowed(r11, r2)
            if (r0 == 0) goto L_0x002c
            r4 = r2
            goto L_0x0030
        L_0x002c:
            r10.resetAdjustment()
        L_0x002f:
            r4 = r11
        L_0x0030:
            long r11 = r10.frameIndex
            r10.pendingLastAdjustedFrameIndex = r11
            r10.pendingLastAdjustedReleaseTimeNs = r4
            com.google.android.exoplayer2.video.VideoFrameReleaseHelper$VSyncSampler r11 = r10.vsyncSampler
            if (r11 == 0) goto L_0x0057
            long r0 = r10.vsyncDurationNs
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x0046
            goto L_0x0057
        L_0x0046:
            long r6 = r11.sampledVsyncTimeNs
            int r11 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r11 != 0) goto L_0x004d
            return r4
        L_0x004d:
            long r8 = r10.vsyncDurationNs
            long r11 = closestVsync(r4, r6, r8)
            long r0 = r10.vsyncOffsetNs
            long r11 = r11 - r0
            return r11
        L_0x0057:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.VideoFrameReleaseHelper.adjustReleaseTime(long):long");
    }

    private void resetAdjustment() {
        this.frameIndex = 0;
        this.lastAdjustedFrameIndex = -1;
        this.pendingLastAdjustedFrameIndex = -1;
    }

    private static boolean adjustmentAllowed(long j, long j2) {
        return Math.abs(j - j2) <= MAX_ALLOWED_ADJUSTMENT_NS;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005c, code lost:
        if (java.lang.Math.abs(r0 - r7.surfaceMediaFrameRate) >= (r7.frameRateEstimator.isSynced() && (r7.frameRateEstimator.getMatchingFrameDurationSumNs() > MINIMUM_MATCHING_FRAME_DURATION_FOR_HIGH_CONFIDENCE_NS ? 1 : (r7.frameRateEstimator.getMatchingFrameDurationSumNs() == MINIMUM_MATCHING_FRAME_DURATION_FOR_HIGH_CONFIDENCE_NS ? 0 : -1)) >= 0 ? MINIMUM_MEDIA_FRAME_RATE_CHANGE_FOR_UPDATE_HIGH_CONFIDENCE : 1.0f)) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006a, code lost:
        if (r7.frameRateEstimator.getFramesWithoutSyncCount() >= 30) goto L_0x006c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateSurfaceMediaFrameRate() {
        /*
            r7 = this;
            int r0 = com.google.android.exoplayer2.util.Util.SDK_INT
            r1 = 30
            if (r0 < r1) goto L_0x0073
            android.view.Surface r0 = r7.surface
            if (r0 != 0) goto L_0x000c
            goto L_0x0073
        L_0x000c:
            com.google.android.exoplayer2.video.FixedFrameRateEstimator r0 = r7.frameRateEstimator
            boolean r0 = r0.isSynced()
            if (r0 == 0) goto L_0x001b
            com.google.android.exoplayer2.video.FixedFrameRateEstimator r0 = r7.frameRateEstimator
            float r0 = r0.getFrameRate()
            goto L_0x001d
        L_0x001b:
            float r0 = r7.formatFrameRate
        L_0x001d:
            float r2 = r7.surfaceMediaFrameRate
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 != 0) goto L_0x0024
            return
        L_0x0024:
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x0061
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0061
            com.google.android.exoplayer2.video.FixedFrameRateEstimator r1 = r7.frameRateEstimator
            boolean r1 = r1.isSynced()
            if (r1 == 0) goto L_0x0049
            com.google.android.exoplayer2.video.FixedFrameRateEstimator r1 = r7.frameRateEstimator
            long r1 = r1.getMatchingFrameDurationSumNs()
            r3 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x0049
            r1 = r6
            goto L_0x004a
        L_0x0049:
            r1 = r5
        L_0x004a:
            if (r1 == 0) goto L_0x0050
            r1 = 1017370378(0x3ca3d70a, float:0.02)
            goto L_0x0052
        L_0x0050:
            r1 = 1065353216(0x3f800000, float:1.0)
        L_0x0052:
            float r2 = r7.surfaceMediaFrameRate
            float r2 = r0 - r2
            float r2 = java.lang.Math.abs(r2)
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 < 0) goto L_0x005f
            goto L_0x006c
        L_0x005f:
            r6 = r5
            goto L_0x006c
        L_0x0061:
            if (r4 == 0) goto L_0x0064
            goto L_0x006c
        L_0x0064:
            com.google.android.exoplayer2.video.FixedFrameRateEstimator r2 = r7.frameRateEstimator
            int r2 = r2.getFramesWithoutSyncCount()
            if (r2 < r1) goto L_0x005f
        L_0x006c:
            if (r6 == 0) goto L_0x0073
            r7.surfaceMediaFrameRate = r0
            r7.updateSurfacePlaybackFrameRate(r5)
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.VideoFrameReleaseHelper.updateSurfaceMediaFrameRate():void");
    }

    private void updateSurfacePlaybackFrameRate(boolean z) {
        Surface surface2;
        if (Util.SDK_INT >= 30 && (surface2 = this.surface) != null && this.changeFrameRateStrategy != Integer.MIN_VALUE) {
            float f = 0.0f;
            if (this.started) {
                float f2 = this.surfaceMediaFrameRate;
                if (f2 != -1.0f) {
                    f = this.playbackSpeed * f2;
                }
            }
            if (z || this.surfacePlaybackFrameRate != f) {
                this.surfacePlaybackFrameRate = f;
                Api30.setSurfaceFrameRate(surface2, f);
            }
        }
    }

    private void clearSurfaceFrameRate() {
        Surface surface2;
        if (Util.SDK_INT >= 30 && (surface2 = this.surface) != null && this.changeFrameRateStrategy != Integer.MIN_VALUE && this.surfacePlaybackFrameRate != 0.0f) {
            this.surfacePlaybackFrameRate = 0.0f;
            Api30.setSurfaceFrameRate(surface2, 0.0f);
        }
    }

    /* access modifiers changed from: private */
    public void updateDefaultDisplayRefreshRateParams(Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            this.vsyncDurationNs = refreshRate;
            this.vsyncOffsetNs = (refreshRate * VSYNC_OFFSET_PERCENTAGE) / 100;
            return;
        }
        Log.w(TAG, "Unable to query display refresh rate");
        this.vsyncDurationNs = C.TIME_UNSET;
        this.vsyncOffsetNs = C.TIME_UNSET;
    }

    private static long closestVsync(long j, long j2, long j3) {
        long j4;
        long j5 = j2 + (((j - j2) / j3) * j3);
        if (j <= j5) {
            j4 = j5 - j3;
        } else {
            long j6 = j5;
            j5 = j3 + j5;
            j4 = j6;
        }
        return j5 - j < j - j4 ? j5 : j4;
    }

    private static DisplayHelper maybeBuildDisplayHelper(Context context) {
        DisplayHelper displayHelper2 = null;
        if (context == null) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        if (Util.SDK_INT >= 17) {
            displayHelper2 = DisplayHelperV17.maybeBuildNewInstance(applicationContext);
        }
        return displayHelper2 == null ? DisplayHelperV16.maybeBuildNewInstance(applicationContext) : displayHelper2;
    }

    private static final class Api30 {
        private Api30() {
        }

        public static void setSurfaceFrameRate(Surface surface, float f) {
            try {
                surface.setFrameRate(f, f == 0.0f ? 0 : 1);
            } catch (IllegalStateException e) {
                Log.e(VideoFrameReleaseHelper.TAG, "Failed to call Surface.setFrameRate", e);
            }
        }
    }

    private static final class DisplayHelperV16 implements DisplayHelper {
        private final WindowManager windowManager;

        public void unregister() {
        }

        public static DisplayHelper maybeBuildNewInstance(Context context) {
            WindowManager windowManager2 = (WindowManager) context.getSystemService("window");
            if (windowManager2 != null) {
                return new DisplayHelperV16(windowManager2);
            }
            return null;
        }

        private DisplayHelperV16(WindowManager windowManager2) {
            this.windowManager = windowManager2;
        }

        public void register(DisplayHelper.Listener listener) {
            listener.onDefaultDisplayChanged(this.windowManager.getDefaultDisplay());
        }
    }

    private static final class DisplayHelperV17 implements DisplayHelper, DisplayManager.DisplayListener {
        private final DisplayManager displayManager;
        private DisplayHelper.Listener listener;

        public void onDisplayAdded(int i) {
        }

        public void onDisplayRemoved(int i) {
        }

        public static DisplayHelper maybeBuildNewInstance(Context context) {
            DisplayManager displayManager2 = (DisplayManager) context.getSystemService("display");
            if (displayManager2 != null) {
                return new DisplayHelperV17(displayManager2);
            }
            return null;
        }

        private DisplayHelperV17(DisplayManager displayManager2) {
            this.displayManager = displayManager2;
        }

        public void register(DisplayHelper.Listener listener2) {
            this.listener = listener2;
            this.displayManager.registerDisplayListener(this, Util.createHandlerForCurrentLooper());
            listener2.onDefaultDisplayChanged(getDefaultDisplay());
        }

        public void unregister() {
            this.displayManager.unregisterDisplayListener(this);
            this.listener = null;
        }

        public void onDisplayChanged(int i) {
            DisplayHelper.Listener listener2 = this.listener;
            if (listener2 != null && i == 0) {
                listener2.onDefaultDisplayChanged(getDefaultDisplay());
            }
        }

        private Display getDefaultDisplay() {
            return this.displayManager.getDisplay(0);
        }
    }

    private static final class VSyncSampler implements Choreographer.FrameCallback, Handler.Callback {
        private static final int CREATE_CHOREOGRAPHER = 0;
        private static final VSyncSampler INSTANCE = new VSyncSampler();
        private static final int MSG_ADD_OBSERVER = 1;
        private static final int MSG_REMOVE_OBSERVER = 2;
        private Choreographer choreographer;
        private final HandlerThread choreographerOwnerThread;
        private final Handler handler;
        private int observerCount;
        public volatile long sampledVsyncTimeNs = C.TIME_UNSET;

        public static VSyncSampler getInstance() {
            return INSTANCE;
        }

        private VSyncSampler() {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
            this.choreographerOwnerThread = handlerThread;
            handlerThread.start();
            Handler createHandler = Util.createHandler(handlerThread.getLooper(), this);
            this.handler = createHandler;
            createHandler.sendEmptyMessage(0);
        }

        public void addObserver() {
            this.handler.sendEmptyMessage(1);
        }

        public void removeObserver() {
            this.handler.sendEmptyMessage(2);
        }

        public void doFrame(long j) {
            this.sampledVsyncTimeNs = j;
            ((Choreographer) Assertions.checkNotNull(this.choreographer)).postFrameCallbackDelayed(this, 500);
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                createChoreographerInstanceInternal();
                return true;
            } else if (i == 1) {
                addObserverInternal();
                return true;
            } else if (i != 2) {
                return false;
            } else {
                removeObserverInternal();
                return true;
            }
        }

        private void createChoreographerInstanceInternal() {
            try {
                this.choreographer = Choreographer.getInstance();
            } catch (RuntimeException e) {
                Log.w(VideoFrameReleaseHelper.TAG, "Vsync sampling disabled due to platform error", e);
            }
        }

        private void addObserverInternal() {
            Choreographer choreographer2 = this.choreographer;
            if (choreographer2 != null) {
                int i = this.observerCount + 1;
                this.observerCount = i;
                if (i == 1) {
                    choreographer2.postFrameCallback(this);
                }
            }
        }

        private void removeObserverInternal() {
            Choreographer choreographer2 = this.choreographer;
            if (choreographer2 != null) {
                int i = this.observerCount - 1;
                this.observerCount = i;
                if (i == 0) {
                    choreographer2.removeFrameCallback(this);
                    this.sampledVsyncTimeNs = C.TIME_UNSET;
                }
            }
        }
    }
}
