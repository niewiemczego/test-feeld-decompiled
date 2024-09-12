package io.sentry.android.core;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.util.Objects;
import java.util.Arrays;
import java.util.List;

final class ManifestMetadataReader {
    static final String ANR_ENABLE = "io.sentry.anr.enable";
    static final String ANR_REPORT_DEBUG = "io.sentry.anr.report-debug";
    static final String ANR_TIMEOUT_INTERVAL_MILLIS = "io.sentry.anr.timeout-interval-millis";
    static final String ATTACH_SCREENSHOT = "io.sentry.attach-screenshot";
    static final String ATTACH_THREADS = "io.sentry.attach-threads";
    static final String ATTACH_VIEW_HIERARCHY = "io.sentry.attach-view-hierarchy";
    static final String AUTO_INIT = "io.sentry.auto-init";
    static final String AUTO_SESSION_TRACKING_ENABLE = "io.sentry.auto-session-tracking.enable";
    static final String BREADCRUMBS_ACTIVITY_LIFECYCLE_ENABLE = "io.sentry.breadcrumbs.activity-lifecycle";
    static final String BREADCRUMBS_APP_COMPONENTS_ENABLE = "io.sentry.breadcrumbs.app-components";
    static final String BREADCRUMBS_APP_LIFECYCLE_ENABLE = "io.sentry.breadcrumbs.app-lifecycle";
    static final String BREADCRUMBS_NETWORK_EVENTS_ENABLE = "io.sentry.breadcrumbs.network-events";
    static final String BREADCRUMBS_SYSTEM_EVENTS_ENABLE = "io.sentry.breadcrumbs.system-events";
    static final String BREADCRUMBS_USER_INTERACTION_ENABLE = "io.sentry.breadcrumbs.user-interaction";
    static final String CLIENT_REPORTS_ENABLE = "io.sentry.send-client-reports";
    static final String COLLECT_ADDITIONAL_CONTEXT = "io.sentry.additional-context";
    static final String DEBUG = "io.sentry.debug";
    static final String DEBUG_LEVEL = "io.sentry.debug.level";
    static final String DSN = "io.sentry.dsn";
    static final String ENABLE_APP_START_PROFILING = "io.sentry.profiling.enable-app-start";
    static final String ENABLE_METRICS = "io.sentry.enable-metrics";
    static final String ENABLE_PERFORMANCE_V2 = "io.sentry.performance-v2.enable";
    static final String ENABLE_ROOT_CHECK = "io.sentry.enable-root-check";
    static final String ENABLE_SCOPE_PERSISTENCE = "io.sentry.enable-scope-persistence";
    static final String ENABLE_SENTRY = "io.sentry.enabled";
    static final String ENVIRONMENT = "io.sentry.environment";
    static final String IDLE_TIMEOUT = "io.sentry.traces.idle-timeout";
    static final String NDK_ENABLE = "io.sentry.ndk.enable";
    static final String NDK_SCOPE_SYNC_ENABLE = "io.sentry.ndk.scope-sync.enable";
    static final String PERFORM_FRAMES_TRACKING = "io.sentry.traces.frames-tracking";
    static final String PROFILES_SAMPLE_RATE = "io.sentry.traces.profiling.sample-rate";
    static final String PROGUARD_UUID = "io.sentry.proguard-uuid";
    static final String RELEASE = "io.sentry.release";
    static final String SAMPLE_RATE = "io.sentry.sample-rate";
    static final String SDK_NAME = "io.sentry.sdk.name";
    static final String SDK_VERSION = "io.sentry.sdk.version";
    static final String SEND_DEFAULT_PII = "io.sentry.send-default-pii";
    static final String SEND_MODULES = "io.sentry.send-modules";
    static final String SENTRY_GRADLE_PLUGIN_INTEGRATIONS = "io.sentry.gradle-plugin-integrations";
    static final String SESSION_TRACKING_ENABLE = "io.sentry.session-tracking.enable";
    static final String SESSION_TRACKING_TIMEOUT_INTERVAL_MILLIS = "io.sentry.session-tracking.timeout-interval-millis";
    static final String TRACES_ACTIVITY_AUTO_FINISH_ENABLE = "io.sentry.traces.activity.auto-finish.enable";
    static final String TRACES_ACTIVITY_ENABLE = "io.sentry.traces.activity.enable";
    static final String TRACES_PROFILING_ENABLE = "io.sentry.traces.profiling.enable";
    static final String TRACES_SAMPLE_RATE = "io.sentry.traces.sample-rate";
    static final String TRACES_UI_ENABLE = "io.sentry.traces.user-interaction.enable";
    static final String TRACE_PROPAGATION_TARGETS = "io.sentry.traces.trace-propagation-targets";
    static final String TRACE_SAMPLING = "io.sentry.traces.trace-sampling";
    static final String TRACING_ENABLE = "io.sentry.traces.enable";
    @Deprecated
    static final String TRACING_ORIGINS = "io.sentry.traces.tracing-origins";
    static final String TTFD_ENABLE = "io.sentry.traces.time-to-full-display.enable";
    static final String UNCAUGHT_EXCEPTION_HANDLER_ENABLE = "io.sentry.uncaught-exception-handler.enable";

    private ManifestMetadataReader() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0276, code lost:
        if (r3.isEmpty() != false) goto L_0x0278;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x01cb A[Catch:{ all -> 0x035f }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x01db A[Catch:{ all -> 0x035f }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0226 A[Catch:{ all -> 0x035f }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x025d A[Catch:{ all -> 0x035f }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0294 A[Catch:{ all -> 0x035f }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x02b4 A[Catch:{ all -> 0x035f }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x02eb A[Catch:{ all -> 0x035f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void applyMetadata(android.content.Context r11, io.sentry.android.core.SentryAndroidOptions r12, io.sentry.android.core.BuildInfoProvider r13) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "io.sentry.traces.trace-propagation-targets"
            java.lang.String r2 = "The application context is required."
            io.sentry.util.Objects.requireNonNull(r11, r2)
            java.lang.String r2 = "The options object is required."
            io.sentry.util.Objects.requireNonNull(r12, r2)
            io.sentry.ILogger r2 = r12.getLogger()     // Catch:{ all -> 0x035f }
            android.os.Bundle r11 = getMetadata(r11, r2, r13)     // Catch:{ all -> 0x035f }
            io.sentry.ILogger r13 = r12.getLogger()     // Catch:{ all -> 0x035f }
            r2 = 0
            if (r11 == 0) goto L_0x0351
            java.lang.String r3 = "io.sentry.debug"
            boolean r4 = r12.isDebug()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r4)     // Catch:{ all -> 0x035f }
            r12.setDebug(r3)     // Catch:{ all -> 0x035f }
            boolean r3 = r12.isDebug()     // Catch:{ all -> 0x035f }
            if (r3 == 0) goto L_0x0053
            java.lang.String r3 = "io.sentry.debug.level"
            io.sentry.SentryLevel r4 = r12.getDiagnosticLevel()     // Catch:{ all -> 0x035f }
            java.lang.String r4 = r4.name()     // Catch:{ all -> 0x035f }
            java.util.Locale r5 = java.util.Locale.ROOT     // Catch:{ all -> 0x035f }
            java.lang.String r4 = r4.toLowerCase(r5)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = readString(r11, r13, r3, r4)     // Catch:{ all -> 0x035f }
            if (r3 == 0) goto L_0x0053
            java.util.Locale r4 = java.util.Locale.ROOT     // Catch:{ all -> 0x035f }
            java.lang.String r3 = r3.toUpperCase(r4)     // Catch:{ all -> 0x035f }
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.valueOf(r3)     // Catch:{ all -> 0x035f }
            r12.setDiagnosticLevel(r3)     // Catch:{ all -> 0x035f }
        L_0x0053:
            java.lang.String r3 = "io.sentry.anr.enable"
            boolean r4 = r12.isAnrEnabled()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r4)     // Catch:{ all -> 0x035f }
            r12.setAnrEnabled(r3)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.session-tracking.enable"
            boolean r4 = r12.isEnableAutoSessionTracking()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r4)     // Catch:{ all -> 0x035f }
            java.lang.String r4 = "io.sentry.auto-session-tracking.enable"
            boolean r3 = readBool(r11, r13, r4, r3)     // Catch:{ all -> 0x035f }
            r12.setEnableAutoSessionTracking(r3)     // Catch:{ all -> 0x035f }
            java.lang.Double r3 = r12.getSampleRate()     // Catch:{ all -> 0x035f }
            r4 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            if (r3 != 0) goto L_0x008c
            java.lang.String r3 = "io.sentry.sample-rate"
            java.lang.Double r3 = readDouble(r11, r13, r3)     // Catch:{ all -> 0x035f }
            double r6 = r3.doubleValue()     // Catch:{ all -> 0x035f }
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x008c
            r12.setSampleRate(r3)     // Catch:{ all -> 0x035f }
        L_0x008c:
            java.lang.String r3 = "io.sentry.anr.report-debug"
            boolean r6 = r12.isAnrReportInDebug()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setAnrReportInDebug(r3)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.anr.timeout-interval-millis"
            long r6 = r12.getAnrTimeoutIntervalMillis()     // Catch:{ all -> 0x035f }
            long r6 = readLong(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setAnrTimeoutIntervalMillis(r6)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.dsn"
            java.lang.String r6 = r12.getDsn()     // Catch:{ all -> 0x035f }
            java.lang.String r3 = readString(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            java.lang.String r6 = "io.sentry.enabled"
            boolean r7 = r12.isEnabled()     // Catch:{ all -> 0x035f }
            boolean r6 = readBool(r11, r13, r6, r7)     // Catch:{ all -> 0x035f }
            if (r6 == 0) goto L_0x00d5
            if (r3 == 0) goto L_0x00c5
            boolean r7 = r3.isEmpty()     // Catch:{ all -> 0x035f }
            if (r7 == 0) goto L_0x00c5
            goto L_0x00d5
        L_0x00c5:
            if (r3 != 0) goto L_0x00e2
            io.sentry.ILogger r7 = r12.getLogger()     // Catch:{ all -> 0x035f }
            io.sentry.SentryLevel r8 = io.sentry.SentryLevel.FATAL     // Catch:{ all -> 0x035f }
            java.lang.String r9 = "DSN is required. Use empty string to disable SDK."
            java.lang.Object[] r10 = new java.lang.Object[r2]     // Catch:{ all -> 0x035f }
            r7.log((io.sentry.SentryLevel) r8, (java.lang.String) r9, (java.lang.Object[]) r10)     // Catch:{ all -> 0x035f }
            goto L_0x00e2
        L_0x00d5:
            io.sentry.ILogger r7 = r12.getLogger()     // Catch:{ all -> 0x035f }
            io.sentry.SentryLevel r8 = io.sentry.SentryLevel.DEBUG     // Catch:{ all -> 0x035f }
            java.lang.String r9 = "Sentry enabled flag set to false or DSN is empty: disabling sentry-android"
            java.lang.Object[] r10 = new java.lang.Object[r2]     // Catch:{ all -> 0x035f }
            r7.log((io.sentry.SentryLevel) r8, (java.lang.String) r9, (java.lang.Object[]) r10)     // Catch:{ all -> 0x035f }
        L_0x00e2:
            r12.setEnabled(r6)     // Catch:{ all -> 0x035f }
            r12.setDsn(r3)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.ndk.enable"
            boolean r6 = r12.isEnableNdk()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setEnableNdk(r3)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.ndk.scope-sync.enable"
            boolean r6 = r12.isEnableScopeSync()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setEnableScopeSync(r3)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.release"
            java.lang.String r6 = r12.getRelease()     // Catch:{ all -> 0x035f }
            java.lang.String r3 = readString(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setRelease(r3)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.environment"
            java.lang.String r6 = r12.getEnvironment()     // Catch:{ all -> 0x035f }
            java.lang.String r3 = readString(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setEnvironment(r3)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.session-tracking.timeout-interval-millis"
            long r6 = r12.getSessionTrackingIntervalMillis()     // Catch:{ all -> 0x035f }
            long r6 = readLong(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setSessionTrackingIntervalMillis(r6)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.breadcrumbs.activity-lifecycle"
            boolean r6 = r12.isEnableActivityLifecycleBreadcrumbs()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setEnableActivityLifecycleBreadcrumbs(r3)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.breadcrumbs.app-lifecycle"
            boolean r6 = r12.isEnableAppLifecycleBreadcrumbs()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setEnableAppLifecycleBreadcrumbs(r3)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.breadcrumbs.system-events"
            boolean r6 = r12.isEnableSystemEventBreadcrumbs()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setEnableSystemEventBreadcrumbs(r3)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.breadcrumbs.app-components"
            boolean r6 = r12.isEnableAppComponentBreadcrumbs()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setEnableAppComponentBreadcrumbs(r3)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.breadcrumbs.user-interaction"
            boolean r6 = r12.isEnableUserInteractionBreadcrumbs()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setEnableUserInteractionBreadcrumbs(r3)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.breadcrumbs.network-events"
            boolean r6 = r12.isEnableNetworkEventBreadcrumbs()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setEnableNetworkEventBreadcrumbs(r3)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.uncaught-exception-handler.enable"
            boolean r6 = r12.isEnableUncaughtExceptionHandler()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setEnableUncaughtExceptionHandler(r3)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.attach-threads"
            boolean r6 = r12.isAttachThreads()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setAttachThreads(r3)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.attach-screenshot"
            boolean r6 = r12.isAttachScreenshot()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setAttachScreenshot(r3)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.attach-view-hierarchy"
            boolean r6 = r12.isAttachViewHierarchy()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setAttachViewHierarchy(r3)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.send-client-reports"
            boolean r6 = r12.isSendClientReports()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setSendClientReports(r3)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.additional-context"
            boolean r6 = r12.isCollectAdditionalContext()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setCollectAdditionalContext(r3)     // Catch:{ all -> 0x035f }
            java.lang.Boolean r3 = r12.getEnableTracing()     // Catch:{ all -> 0x035f }
            if (r3 != 0) goto L_0x01d5
            java.lang.String r3 = "io.sentry.traces.enable"
            r6 = 0
            java.lang.Boolean r3 = readBoolNullable(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setEnableTracing(r3)     // Catch:{ all -> 0x035f }
        L_0x01d5:
            java.lang.Double r3 = r12.getTracesSampleRate()     // Catch:{ all -> 0x035f }
            if (r3 != 0) goto L_0x01ec
            java.lang.String r3 = "io.sentry.traces.sample-rate"
            java.lang.Double r3 = readDouble(r11, r13, r3)     // Catch:{ all -> 0x035f }
            double r6 = r3.doubleValue()     // Catch:{ all -> 0x035f }
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x01ec
            r12.setTracesSampleRate(r3)     // Catch:{ all -> 0x035f }
        L_0x01ec:
            java.lang.String r3 = "io.sentry.traces.trace-sampling"
            boolean r6 = r12.isTraceSampling()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setTraceSampling(r3)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.traces.activity.enable"
            boolean r6 = r12.isEnableAutoActivityLifecycleTracing()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setEnableAutoActivityLifecycleTracing(r3)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.traces.activity.auto-finish.enable"
            boolean r6 = r12.isEnableActivityLifecycleTracingAutoFinish()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setEnableActivityLifecycleTracingAutoFinish(r3)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.traces.profiling.enable"
            boolean r6 = r12.isProfilingEnabled()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r6)     // Catch:{ all -> 0x035f }
            r12.setProfilingEnabled(r3)     // Catch:{ all -> 0x035f }
            java.lang.Double r3 = r12.getProfilesSampleRate()     // Catch:{ all -> 0x035f }
            if (r3 != 0) goto L_0x0237
            java.lang.String r3 = "io.sentry.traces.profiling.sample-rate"
            java.lang.Double r3 = readDouble(r11, r13, r3)     // Catch:{ all -> 0x035f }
            double r6 = r3.doubleValue()     // Catch:{ all -> 0x035f }
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0237
            r12.setProfilesSampleRate(r3)     // Catch:{ all -> 0x035f }
        L_0x0237:
            java.lang.String r3 = "io.sentry.traces.user-interaction.enable"
            boolean r4 = r12.isEnableUserInteractionTracing()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r4)     // Catch:{ all -> 0x035f }
            r12.setEnableUserInteractionTracing(r3)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.traces.time-to-full-display.enable"
            boolean r4 = r12.isEnableTimeToFullDisplayTracing()     // Catch:{ all -> 0x035f }
            boolean r3 = readBool(r11, r13, r3, r4)     // Catch:{ all -> 0x035f }
            r12.setEnableTimeToFullDisplayTracing(r3)     // Catch:{ all -> 0x035f }
            java.lang.String r3 = "io.sentry.traces.idle-timeout"
            r4 = -1
            long r6 = readLong(r11, r13, r3, r4)     // Catch:{ all -> 0x035f }
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x0264
            java.lang.Long r3 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x035f }
            r12.setIdleTimeout(r3)     // Catch:{ all -> 0x035f }
        L_0x0264:
            java.util.List r3 = readList(r11, r13, r1)     // Catch:{ all -> 0x035f }
            boolean r4 = r11.containsKey(r1)     // Catch:{ all -> 0x035f }
            java.lang.String r5 = "io.sentry.traces.tracing-origins"
            if (r4 != 0) goto L_0x027c
            if (r3 == 0) goto L_0x0278
            boolean r4 = r3.isEmpty()     // Catch:{ all -> 0x035f }
            if (r4 == 0) goto L_0x027c
        L_0x0278:
            java.util.List r3 = readList(r11, r13, r5)     // Catch:{ all -> 0x035f }
        L_0x027c:
            boolean r1 = r11.containsKey(r1)     // Catch:{ all -> 0x035f }
            if (r1 != 0) goto L_0x0288
            boolean r1 = r11.containsKey(r5)     // Catch:{ all -> 0x035f }
            if (r1 == 0) goto L_0x0292
        L_0x0288:
            if (r3 != 0) goto L_0x0292
            java.util.List r1 = java.util.Collections.emptyList()     // Catch:{ all -> 0x035f }
            r12.setTracePropagationTargets(r1)     // Catch:{ all -> 0x035f }
            goto L_0x0297
        L_0x0292:
            if (r3 == 0) goto L_0x0297
            r12.setTracePropagationTargets(r3)     // Catch:{ all -> 0x035f }
        L_0x0297:
            java.lang.String r1 = "io.sentry.traces.frames-tracking"
            r3 = 1
            boolean r1 = readBool(r11, r13, r1, r3)     // Catch:{ all -> 0x035f }
            r12.setEnableFramesTracking(r1)     // Catch:{ all -> 0x035f }
            java.lang.String r1 = "io.sentry.proguard-uuid"
            java.lang.String r3 = r12.getProguardUuid()     // Catch:{ all -> 0x035f }
            java.lang.String r1 = readString(r11, r13, r1, r3)     // Catch:{ all -> 0x035f }
            r12.setProguardUuid(r1)     // Catch:{ all -> 0x035f }
            io.sentry.protocol.SdkVersion r1 = r12.getSdkVersion()     // Catch:{ all -> 0x035f }
            if (r1 != 0) goto L_0x02b9
            io.sentry.protocol.SdkVersion r1 = new io.sentry.protocol.SdkVersion     // Catch:{ all -> 0x035f }
            r1.<init>(r0, r0)     // Catch:{ all -> 0x035f }
        L_0x02b9:
            java.lang.String r0 = "io.sentry.sdk.name"
            java.lang.String r3 = r1.getName()     // Catch:{ all -> 0x035f }
            java.lang.String r0 = readStringNotNull(r11, r13, r0, r3)     // Catch:{ all -> 0x035f }
            r1.setName(r0)     // Catch:{ all -> 0x035f }
            java.lang.String r0 = "io.sentry.sdk.version"
            java.lang.String r3 = r1.getVersion()     // Catch:{ all -> 0x035f }
            java.lang.String r0 = readStringNotNull(r11, r13, r0, r3)     // Catch:{ all -> 0x035f }
            r1.setVersion(r0)     // Catch:{ all -> 0x035f }
            r12.setSdkVersion(r1)     // Catch:{ all -> 0x035f }
            java.lang.String r0 = "io.sentry.send-default-pii"
            boolean r1 = r12.isSendDefaultPii()     // Catch:{ all -> 0x035f }
            boolean r0 = readBool(r11, r13, r0, r1)     // Catch:{ all -> 0x035f }
            r12.setSendDefaultPii(r0)     // Catch:{ all -> 0x035f }
            java.lang.String r0 = "io.sentry.gradle-plugin-integrations"
            java.util.List r0 = readList(r11, r13, r0)     // Catch:{ all -> 0x035f }
            if (r0 == 0) goto L_0x0303
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x035f }
        L_0x02ef:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x035f }
            if (r1 == 0) goto L_0x0303
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x035f }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x035f }
            io.sentry.SentryIntegrationPackageStorage r3 = io.sentry.SentryIntegrationPackageStorage.getInstance()     // Catch:{ all -> 0x035f }
            r3.addIntegration(r1)     // Catch:{ all -> 0x035f }
            goto L_0x02ef
        L_0x0303:
            java.lang.String r0 = "io.sentry.enable-root-check"
            boolean r1 = r12.isEnableRootCheck()     // Catch:{ all -> 0x035f }
            boolean r0 = readBool(r11, r13, r0, r1)     // Catch:{ all -> 0x035f }
            r12.setEnableRootCheck(r0)     // Catch:{ all -> 0x035f }
            java.lang.String r0 = "io.sentry.send-modules"
            boolean r1 = r12.isSendModules()     // Catch:{ all -> 0x035f }
            boolean r0 = readBool(r11, r13, r0, r1)     // Catch:{ all -> 0x035f }
            r12.setSendModules(r0)     // Catch:{ all -> 0x035f }
            java.lang.String r0 = "io.sentry.performance-v2.enable"
            boolean r1 = r12.isEnablePerformanceV2()     // Catch:{ all -> 0x035f }
            boolean r0 = readBool(r11, r13, r0, r1)     // Catch:{ all -> 0x035f }
            r12.setEnablePerformanceV2(r0)     // Catch:{ all -> 0x035f }
            java.lang.String r0 = "io.sentry.profiling.enable-app-start"
            boolean r1 = r12.isEnableAppStartProfiling()     // Catch:{ all -> 0x035f }
            boolean r0 = readBool(r11, r13, r0, r1)     // Catch:{ all -> 0x035f }
            r12.setEnableAppStartProfiling(r0)     // Catch:{ all -> 0x035f }
            java.lang.String r0 = "io.sentry.enable-scope-persistence"
            boolean r1 = r12.isEnableScopePersistence()     // Catch:{ all -> 0x035f }
            boolean r0 = readBool(r11, r13, r0, r1)     // Catch:{ all -> 0x035f }
            r12.setEnableScopePersistence(r0)     // Catch:{ all -> 0x035f }
            java.lang.String r0 = "io.sentry.enable-metrics"
            boolean r1 = r12.isEnableMetrics()     // Catch:{ all -> 0x035f }
            boolean r11 = readBool(r11, r13, r0, r1)     // Catch:{ all -> 0x035f }
            r12.setEnableMetrics(r11)     // Catch:{ all -> 0x035f }
        L_0x0351:
            io.sentry.ILogger r11 = r12.getLogger()     // Catch:{ all -> 0x035f }
            io.sentry.SentryLevel r13 = io.sentry.SentryLevel.INFO     // Catch:{ all -> 0x035f }
            java.lang.String r0 = "Retrieving configuration from AndroidManifest.xml"
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ all -> 0x035f }
            r11.log((io.sentry.SentryLevel) r13, (java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ all -> 0x035f }
            goto L_0x036b
        L_0x035f:
            r11 = move-exception
            io.sentry.ILogger r12 = r12.getLogger()
            io.sentry.SentryLevel r13 = io.sentry.SentryLevel.ERROR
            java.lang.String r0 = "Failed to read configuration from android manifest metadata."
            r12.log((io.sentry.SentryLevel) r13, (java.lang.String) r0, (java.lang.Throwable) r11)
        L_0x036b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.ManifestMetadataReader.applyMetadata(android.content.Context, io.sentry.android.core.SentryAndroidOptions, io.sentry.android.core.BuildInfoProvider):void");
    }

    private static boolean readBool(Bundle bundle, ILogger iLogger, String str, boolean z) {
        boolean z2 = bundle.getBoolean(str, z);
        iLogger.log(SentryLevel.DEBUG, "%s read: %s", str, Boolean.valueOf(z2));
        return z2;
    }

    private static Boolean readBoolNullable(Bundle bundle, ILogger iLogger, String str, Boolean bool) {
        if (bundle.getSerializable(str) != null) {
            boolean z = bundle.getBoolean(str, bool != null);
            iLogger.log(SentryLevel.DEBUG, "%s read: %s", str, Boolean.valueOf(z));
            return Boolean.valueOf(z);
        }
        iLogger.log(SentryLevel.DEBUG, "%s used default %s", str, bool);
        return bool;
    }

    private static String readString(Bundle bundle, ILogger iLogger, String str, String str2) {
        String string = bundle.getString(str, str2);
        iLogger.log(SentryLevel.DEBUG, "%s read: %s", str, string);
        return string;
    }

    private static String readStringNotNull(Bundle bundle, ILogger iLogger, String str, String str2) {
        String string = bundle.getString(str, str2);
        iLogger.log(SentryLevel.DEBUG, "%s read: %s", str, string);
        return string;
    }

    private static List<String> readList(Bundle bundle, ILogger iLogger, String str) {
        String string = bundle.getString(str);
        iLogger.log(SentryLevel.DEBUG, "%s read: %s", str, string);
        if (string != null) {
            return Arrays.asList(string.split(",", -1));
        }
        return null;
    }

    private static Double readDouble(Bundle bundle, ILogger iLogger, String str) {
        Double valueOf = Double.valueOf(Float.valueOf(bundle.getFloat(str, -1.0f)).doubleValue());
        iLogger.log(SentryLevel.DEBUG, "%s read: %s", str, valueOf);
        return valueOf;
    }

    private static long readLong(Bundle bundle, ILogger iLogger, String str, long j) {
        long j2 = (long) bundle.getInt(str, (int) j);
        iLogger.log(SentryLevel.DEBUG, "%s read: %s", str, Long.valueOf(j2));
        return j2;
    }

    static boolean isAutoInit(Context context, ILogger iLogger) {
        Objects.requireNonNull(context, "The application context is required.");
        boolean z = true;
        try {
            Bundle metadata = getMetadata(context, iLogger, (BuildInfoProvider) null);
            if (metadata != null) {
                z = readBool(metadata, iLogger, AUTO_INIT, true);
            }
            iLogger.log(SentryLevel.INFO, "Retrieving auto-init from AndroidManifest.xml", new Object[0]);
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Failed to read auto-init from android manifest metadata.", th);
        }
        return z;
    }

    private static Bundle getMetadata(Context context, ILogger iLogger, BuildInfoProvider buildInfoProvider) throws PackageManager.NameNotFoundException {
        if (buildInfoProvider == null) {
            buildInfoProvider = new BuildInfoProvider(iLogger);
        }
        return ContextUtils.getApplicationInfo(context, 128, buildInfoProvider).metaData;
    }
}
