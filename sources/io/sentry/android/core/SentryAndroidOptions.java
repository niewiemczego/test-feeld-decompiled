package io.sentry.android.core;

import io.sentry.Hint;
import io.sentry.SentryEvent;
import io.sentry.SentryOptions;
import io.sentry.android.core.internal.util.SentryFrameMetricsCollector;
import io.sentry.protocol.SdkVersion;

public final class SentryAndroidOptions extends SentryOptions {
    private boolean anrEnabled = true;
    private boolean anrReportInDebug = false;
    private long anrTimeoutIntervalMillis = 5000;
    private boolean attachAnrThreadDump = false;
    private boolean attachScreenshot;
    private boolean attachViewHierarchy;
    private BeforeCaptureCallback beforeScreenshotCaptureCallback;
    private BeforeCaptureCallback beforeViewHierarchyCaptureCallback;
    private boolean collectAdditionalContext = true;
    private IDebugImagesLoader debugImagesLoader = NoOpDebugImagesLoader.getInstance();
    private boolean enableActivityLifecycleBreadcrumbs = true;
    private boolean enableActivityLifecycleTracingAutoFinish = true;
    private boolean enableAppComponentBreadcrumbs = true;
    private boolean enableAppLifecycleBreadcrumbs = true;
    private boolean enableAutoActivityLifecycleTracing = true;
    private boolean enableFramesTracking = true;
    private boolean enableNdk = true;
    private boolean enableNetworkEventBreadcrumbs = true;
    private boolean enablePerformanceV2 = false;
    private boolean enableRootCheck = true;
    private boolean enableScopeSync = true;
    private boolean enableSystemEventBreadcrumbs = true;
    private SentryFrameMetricsCollector frameMetricsCollector;
    private String nativeSdkName = null;
    private boolean reportHistoricalAnrs = false;
    private final long startupCrashDurationThresholdMillis = 2000;
    private long startupCrashFlushTimeoutMillis = 5000;

    public interface BeforeCaptureCallback {
        boolean execute(SentryEvent sentryEvent, Hint hint, boolean z);
    }

    @Deprecated
    public int getProfilingTracesIntervalMillis() {
        return 0;
    }

    public long getStartupCrashDurationThresholdMillis() {
        return 2000;
    }

    @Deprecated
    public void setProfilingTracesIntervalMillis(int i) {
    }

    public SentryAndroidOptions() {
        setSentryClientName("sentry.java.android/7.8.0");
        setSdkVersion(createSdkVersion());
        setAttachServerName(false);
    }

    private SdkVersion createSdkVersion() {
        SdkVersion updateSdkVersion = SdkVersion.updateSdkVersion(getSdkVersion(), BuildConfig.SENTRY_ANDROID_SDK_NAME, "7.8.0");
        updateSdkVersion.addPackage("maven:io.sentry:sentry-android-core", "7.8.0");
        return updateSdkVersion;
    }

    public boolean isAnrEnabled() {
        return this.anrEnabled;
    }

    public void setAnrEnabled(boolean z) {
        this.anrEnabled = z;
    }

    public long getAnrTimeoutIntervalMillis() {
        return this.anrTimeoutIntervalMillis;
    }

    public void setAnrTimeoutIntervalMillis(long j) {
        this.anrTimeoutIntervalMillis = j;
    }

    public boolean isAnrReportInDebug() {
        return this.anrReportInDebug;
    }

    public void setAnrReportInDebug(boolean z) {
        this.anrReportInDebug = z;
    }

    public boolean isEnableActivityLifecycleBreadcrumbs() {
        return this.enableActivityLifecycleBreadcrumbs;
    }

    public void setEnableActivityLifecycleBreadcrumbs(boolean z) {
        this.enableActivityLifecycleBreadcrumbs = z;
    }

    public boolean isEnableAppLifecycleBreadcrumbs() {
        return this.enableAppLifecycleBreadcrumbs;
    }

    public void setEnableAppLifecycleBreadcrumbs(boolean z) {
        this.enableAppLifecycleBreadcrumbs = z;
    }

    public boolean isEnableSystemEventBreadcrumbs() {
        return this.enableSystemEventBreadcrumbs;
    }

    public void setEnableSystemEventBreadcrumbs(boolean z) {
        this.enableSystemEventBreadcrumbs = z;
    }

    public boolean isEnableAppComponentBreadcrumbs() {
        return this.enableAppComponentBreadcrumbs;
    }

    public void setEnableAppComponentBreadcrumbs(boolean z) {
        this.enableAppComponentBreadcrumbs = z;
    }

    public boolean isEnableNetworkEventBreadcrumbs() {
        return this.enableNetworkEventBreadcrumbs;
    }

    public void setEnableNetworkEventBreadcrumbs(boolean z) {
        this.enableNetworkEventBreadcrumbs = z;
    }

    public void enableAllAutoBreadcrumbs(boolean z) {
        this.enableActivityLifecycleBreadcrumbs = z;
        this.enableAppComponentBreadcrumbs = z;
        this.enableSystemEventBreadcrumbs = z;
        this.enableAppLifecycleBreadcrumbs = z;
        this.enableNetworkEventBreadcrumbs = z;
        setEnableUserInteractionBreadcrumbs(z);
    }

    public IDebugImagesLoader getDebugImagesLoader() {
        return this.debugImagesLoader;
    }

    public void setDebugImagesLoader(IDebugImagesLoader iDebugImagesLoader) {
        if (iDebugImagesLoader == null) {
            iDebugImagesLoader = NoOpDebugImagesLoader.getInstance();
        }
        this.debugImagesLoader = iDebugImagesLoader;
    }

    public boolean isEnableAutoActivityLifecycleTracing() {
        return this.enableAutoActivityLifecycleTracing;
    }

    public void setEnableAutoActivityLifecycleTracing(boolean z) {
        this.enableAutoActivityLifecycleTracing = z;
    }

    public boolean isEnableActivityLifecycleTracingAutoFinish() {
        return this.enableActivityLifecycleTracingAutoFinish;
    }

    public void setEnableActivityLifecycleTracingAutoFinish(boolean z) {
        this.enableActivityLifecycleTracingAutoFinish = z;
    }

    public boolean isAttachScreenshot() {
        return this.attachScreenshot;
    }

    public void setAttachScreenshot(boolean z) {
        this.attachScreenshot = z;
    }

    public boolean isAttachViewHierarchy() {
        return this.attachViewHierarchy;
    }

    public void setAttachViewHierarchy(boolean z) {
        this.attachViewHierarchy = z;
    }

    public boolean isCollectAdditionalContext() {
        return this.collectAdditionalContext;
    }

    public void setCollectAdditionalContext(boolean z) {
        this.collectAdditionalContext = z;
    }

    public boolean isEnableFramesTracking() {
        return this.enableFramesTracking;
    }

    public void setEnableFramesTracking(boolean z) {
        this.enableFramesTracking = z;
    }

    /* access modifiers changed from: package-private */
    public long getStartupCrashFlushTimeoutMillis() {
        return this.startupCrashFlushTimeoutMillis;
    }

    /* access modifiers changed from: package-private */
    public void setStartupCrashFlushTimeoutMillis(long j) {
        this.startupCrashFlushTimeoutMillis = j;
    }

    public void setNativeSdkName(String str) {
        this.nativeSdkName = str;
    }

    public String getNativeSdkName() {
        return this.nativeSdkName;
    }

    public boolean isEnableRootCheck() {
        return this.enableRootCheck;
    }

    public void setEnableRootCheck(boolean z) {
        this.enableRootCheck = z;
    }

    public BeforeCaptureCallback getBeforeScreenshotCaptureCallback() {
        return this.beforeScreenshotCaptureCallback;
    }

    public void setBeforeScreenshotCaptureCallback(BeforeCaptureCallback beforeCaptureCallback) {
        this.beforeScreenshotCaptureCallback = beforeCaptureCallback;
    }

    public BeforeCaptureCallback getBeforeViewHierarchyCaptureCallback() {
        return this.beforeViewHierarchyCaptureCallback;
    }

    public void setBeforeViewHierarchyCaptureCallback(BeforeCaptureCallback beforeCaptureCallback) {
        this.beforeViewHierarchyCaptureCallback = beforeCaptureCallback;
    }

    public boolean isEnableNdk() {
        return this.enableNdk;
    }

    public void setEnableNdk(boolean z) {
        this.enableNdk = z;
    }

    public boolean isEnableScopeSync() {
        return this.enableScopeSync;
    }

    public void setEnableScopeSync(boolean z) {
        this.enableScopeSync = z;
    }

    public boolean isReportHistoricalAnrs() {
        return this.reportHistoricalAnrs;
    }

    public void setReportHistoricalAnrs(boolean z) {
        this.reportHistoricalAnrs = z;
    }

    public boolean isAttachAnrThreadDump() {
        return this.attachAnrThreadDump;
    }

    public void setAttachAnrThreadDump(boolean z) {
        this.attachAnrThreadDump = z;
    }

    public boolean isEnablePerformanceV2() {
        return this.enablePerformanceV2;
    }

    public void setEnablePerformanceV2(boolean z) {
        this.enablePerformanceV2 = z;
    }

    public SentryFrameMetricsCollector getFrameMetricsCollector() {
        return this.frameMetricsCollector;
    }

    public void setFrameMetricsCollector(SentryFrameMetricsCollector sentryFrameMetricsCollector) {
        this.frameMetricsCollector = sentryFrameMetricsCollector;
    }
}
