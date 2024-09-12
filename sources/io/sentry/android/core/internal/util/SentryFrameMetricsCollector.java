package io.sentry.android.core.internal.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Choreographer;
import android.view.FrameMetrics;
import android.view.Window;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.BuildInfoProvider;
import io.sentry.util.Objects;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

public final class SentryFrameMetricsCollector implements Application.ActivityLifecycleCallbacks {
    private static final long frozenFrameThresholdNanos = TimeUnit.MILLISECONDS.toNanos(700);
    private static final long oneSecondInNanos = TimeUnit.SECONDS.toNanos(1);
    private final BuildInfoProvider buildInfoProvider;
    private Choreographer choreographer;
    private Field choreographerLastFrameTimeField;
    private WeakReference<Window> currentWindow;
    private Window.OnFrameMetricsAvailableListener frameMetricsAvailableListener;
    private Handler handler;
    private boolean isAvailable;
    private long lastFrameEndNanos;
    private long lastFrameStartNanos;
    private final Map<String, FrameMetricsCollectorListener> listenerMap;
    private final ILogger logger;
    private final Set<Window> trackedWindows;
    private final WindowFrameMetricsManager windowFrameMetricsManager;

    public interface FrameMetricsCollectorListener {
        void onFrameMetricCollected(long j, long j2, long j3, long j4, boolean z, boolean z2, float f);
    }

    public static boolean isSlow(long j, long j2) {
        return j > j2;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public SentryFrameMetricsCollector(Context context, SentryOptions sentryOptions, BuildInfoProvider buildInfoProvider2) {
        this(context, sentryOptions, buildInfoProvider2, (WindowFrameMetricsManager) new WindowFrameMetricsManager() {
        });
    }

    public SentryFrameMetricsCollector(Context context, ILogger iLogger, BuildInfoProvider buildInfoProvider2) {
        this(context, iLogger, buildInfoProvider2, (WindowFrameMetricsManager) new WindowFrameMetricsManager() {
        });
    }

    public SentryFrameMetricsCollector(Context context, SentryOptions sentryOptions, BuildInfoProvider buildInfoProvider2, WindowFrameMetricsManager windowFrameMetricsManager2) {
        this(context, sentryOptions.getLogger(), buildInfoProvider2, windowFrameMetricsManager2);
    }

    public SentryFrameMetricsCollector(Context context, ILogger iLogger, BuildInfoProvider buildInfoProvider2, WindowFrameMetricsManager windowFrameMetricsManager2) {
        this.trackedWindows = new CopyOnWriteArraySet();
        this.listenerMap = new ConcurrentHashMap();
        this.isAvailable = false;
        this.lastFrameStartNanos = 0;
        this.lastFrameEndNanos = 0;
        Objects.requireNonNull(context, "The context is required");
        this.logger = (ILogger) Objects.requireNonNull(iLogger, "Logger is required");
        this.buildInfoProvider = (BuildInfoProvider) Objects.requireNonNull(buildInfoProvider2, "BuildInfoProvider is required");
        this.windowFrameMetricsManager = (WindowFrameMetricsManager) Objects.requireNonNull(windowFrameMetricsManager2, "WindowFrameMetricsManager is required");
        if ((context instanceof Application) && buildInfoProvider2.getSdkInfoVersion() >= 24) {
            this.isAvailable = true;
            HandlerThread handlerThread = new HandlerThread("io.sentry.android.core.internal.util.SentryFrameMetricsCollector");
            handlerThread.setUncaughtExceptionHandler(new SentryFrameMetricsCollector$$ExternalSyntheticLambda0(iLogger));
            handlerThread.start();
            this.handler = new Handler(handlerThread.getLooper());
            ((Application) context).registerActivityLifecycleCallbacks(this);
            new Handler(Looper.getMainLooper()).post(new SentryFrameMetricsCollector$$ExternalSyntheticLambda1(this, iLogger));
            try {
                Field declaredField = Choreographer.class.getDeclaredField("mLastFrameTimeNanos");
                this.choreographerLastFrameTimeField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
                iLogger.log(SentryLevel.ERROR, "Unable to get the frame timestamp from the choreographer: ", (Throwable) e);
            }
            this.frameMetricsAvailableListener = new SentryFrameMetricsCollector$$ExternalSyntheticLambda2(this, buildInfoProvider2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$1$io-sentry-android-core-internal-util-SentryFrameMetricsCollector  reason: not valid java name */
    public /* synthetic */ void m912lambda$new$1$iosentryandroidcoreinternalutilSentryFrameMetricsCollector(ILogger iLogger) {
        try {
            this.choreographer = Choreographer.getInstance();
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Error retrieving Choreographer instance. Slow and frozen frames will not be reported.", th);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$2$io-sentry-android-core-internal-util-SentryFrameMetricsCollector  reason: not valid java name */
    public /* synthetic */ void m913lambda$new$2$iosentryandroidcoreinternalutilSentryFrameMetricsCollector(BuildInfoProvider buildInfoProvider2, Window window, FrameMetrics frameMetrics, int i) {
        float f;
        FrameMetrics frameMetrics2 = frameMetrics;
        long nanoTime = System.nanoTime();
        if (buildInfoProvider2.getSdkInfoVersion() >= 30) {
            f = window.getContext().getDisplay().getRefreshRate();
        } else {
            f = window.getWindowManager().getDefaultDisplay().getRefreshRate();
        }
        long j = oneSecondInNanos;
        long frameCpuDuration = getFrameCpuDuration(frameMetrics2);
        long max = Math.max(0, frameCpuDuration - ((long) (((float) j) / f)));
        long frameStartTimestamp = getFrameStartTimestamp(frameMetrics2);
        if (frameStartTimestamp < 0) {
            frameStartTimestamp = nanoTime - frameCpuDuration;
        }
        long max2 = Math.max(frameStartTimestamp, this.lastFrameEndNanos);
        if (max2 != this.lastFrameStartNanos) {
            this.lastFrameStartNanos = max2;
            this.lastFrameEndNanos = max2 + frameCpuDuration;
            boolean isSlow = isSlow(frameCpuDuration, (long) (((float) j) / (f - 1.0f)));
            boolean z = isSlow && isFrozen(frameCpuDuration);
            for (FrameMetricsCollectorListener onFrameMetricCollected : this.listenerMap.values()) {
                onFrameMetricCollected.onFrameMetricCollected(max2, this.lastFrameEndNanos, frameCpuDuration, max, isSlow, z, f);
                frameCpuDuration = frameCpuDuration;
            }
        }
    }

    public static boolean isFrozen(long j) {
        return j > frozenFrameThresholdNanos;
    }

    private long getFrameStartTimestamp(FrameMetrics frameMetrics) {
        if (this.buildInfoProvider.getSdkInfoVersion() >= 26) {
            return frameMetrics.getMetric(10);
        }
        return getLastKnownFrameStartTimeNanos();
    }

    private long getFrameCpuDuration(FrameMetrics frameMetrics) {
        return frameMetrics.getMetric(0) + frameMetrics.getMetric(1) + frameMetrics.getMetric(2) + frameMetrics.getMetric(3) + frameMetrics.getMetric(4) + frameMetrics.getMetric(5);
    }

    public void onActivityStarted(Activity activity) {
        setCurrentWindow(activity.getWindow());
    }

    public void onActivityStopped(Activity activity) {
        stopTrackingWindow(activity.getWindow());
        WeakReference<Window> weakReference = this.currentWindow;
        if (weakReference != null && weakReference.get() == activity.getWindow()) {
            this.currentWindow = null;
        }
    }

    public String startCollection(FrameMetricsCollectorListener frameMetricsCollectorListener) {
        if (!this.isAvailable) {
            return null;
        }
        String uuid = UUID.randomUUID().toString();
        this.listenerMap.put(uuid, frameMetricsCollectorListener);
        trackCurrentWindow();
        return uuid;
    }

    public void stopCollection(String str) {
        if (this.isAvailable) {
            if (str != null) {
                this.listenerMap.remove(str);
            }
            WeakReference<Window> weakReference = this.currentWindow;
            Window window = weakReference != null ? (Window) weakReference.get() : null;
            if (window != null && this.listenerMap.isEmpty()) {
                stopTrackingWindow(window);
            }
        }
    }

    private void stopTrackingWindow(Window window) {
        if (this.trackedWindows.contains(window)) {
            if (this.buildInfoProvider.getSdkInfoVersion() >= 24) {
                try {
                    this.windowFrameMetricsManager.removeOnFrameMetricsAvailableListener(window, this.frameMetricsAvailableListener);
                } catch (Exception e) {
                    this.logger.log(SentryLevel.ERROR, "Failed to remove frameMetricsAvailableListener", (Throwable) e);
                }
            }
            this.trackedWindows.remove(window);
        }
    }

    private void setCurrentWindow(Window window) {
        WeakReference<Window> weakReference = this.currentWindow;
        if (weakReference == null || weakReference.get() != window) {
            this.currentWindow = new WeakReference<>(window);
            trackCurrentWindow();
        }
    }

    private void trackCurrentWindow() {
        WeakReference<Window> weakReference = this.currentWindow;
        Window window = weakReference != null ? (Window) weakReference.get() : null;
        if (window != null && this.isAvailable && !this.trackedWindows.contains(window) && !this.listenerMap.isEmpty() && this.buildInfoProvider.getSdkInfoVersion() >= 24 && this.handler != null) {
            this.trackedWindows.add(window);
            this.windowFrameMetricsManager.addOnFrameMetricsAvailableListener(window, this.frameMetricsAvailableListener, this.handler);
        }
    }

    public long getLastKnownFrameStartTimeNanos() {
        Field field;
        Choreographer choreographer2 = this.choreographer;
        if (choreographer2 == null || (field = this.choreographerLastFrameTimeField) == null) {
            return -1;
        }
        try {
            Long l = (Long) field.get(choreographer2);
            if (l != null) {
                return l.longValue();
            }
            return -1;
        } catch (IllegalAccessException unused) {
            return -1;
        }
    }

    public interface WindowFrameMetricsManager {
        void addOnFrameMetricsAvailableListener(Window window, Window.OnFrameMetricsAvailableListener onFrameMetricsAvailableListener, Handler handler) {
            window.addOnFrameMetricsAvailableListener(onFrameMetricsAvailableListener, handler);
        }

        void removeOnFrameMetricsAvailableListener(Window window, Window.OnFrameMetricsAvailableListener onFrameMetricsAvailableListener) {
            window.removeOnFrameMetricsAvailableListener(onFrameMetricsAvailableListener);
        }
    }
}
