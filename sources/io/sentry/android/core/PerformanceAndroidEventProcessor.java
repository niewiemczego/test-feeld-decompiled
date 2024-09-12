package io.sentry.android.core;

import android.os.Looper;
import io.sentry.EventProcessor;
import io.sentry.Hint;
import io.sentry.SentryEvent;
import io.sentry.SpanContext;
import io.sentry.SpanDataConvention;
import io.sentry.SpanId;
import io.sentry.SpanStatus;
import io.sentry.android.core.performance.ActivityLifecycleTimeSpan;
import io.sentry.android.core.performance.AppStartMetrics;
import io.sentry.android.core.performance.TimeSpan;
import io.sentry.protocol.MetricSummary;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentrySpan;
import io.sentry.protocol.SentryThread;
import io.sentry.protocol.SentryTransaction;
import io.sentry.util.Objects;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class PerformanceAndroidEventProcessor implements EventProcessor {
    private static final String APP_METRICS_ACTIVITIES_OP = "activity.load";
    private static final String APP_METRICS_APPLICATION_OP = "application.load";
    private static final String APP_METRICS_CONTENT_PROVIDER_OP = "contentprovider.load";
    private static final String APP_METRICS_ORIGIN = "auto.ui";
    private static final String APP_METRICS_PROCESS_INIT_OP = "process.load";
    private static final long MAX_PROCESS_INIT_APP_START_DIFF_MS = 10000;
    private final ActivityFramesTracker activityFramesTracker;
    private final SentryAndroidOptions options;
    private boolean sentStartMeasurement = false;

    public SentryEvent process(SentryEvent sentryEvent, Hint hint) {
        return sentryEvent;
    }

    PerformanceAndroidEventProcessor(SentryAndroidOptions sentryAndroidOptions, ActivityFramesTracker activityFramesTracker2) {
        this.options = (SentryAndroidOptions) Objects.requireNonNull(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.activityFramesTracker = (ActivityFramesTracker) Objects.requireNonNull(activityFramesTracker2, "ActivityFramesTracker is required");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0088, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized io.sentry.protocol.SentryTransaction process(io.sentry.protocol.SentryTransaction r5, io.sentry.Hint r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            io.sentry.android.core.SentryAndroidOptions r6 = r4.options     // Catch:{ all -> 0x0089 }
            boolean r6 = r6.isTracingEnabled()     // Catch:{ all -> 0x0089 }
            if (r6 != 0) goto L_0x000b
            monitor-exit(r4)
            return r5
        L_0x000b:
            boolean r6 = r4.sentStartMeasurement     // Catch:{ all -> 0x0089 }
            if (r6 != 0) goto L_0x005b
            boolean r6 = r4.hasAppStartSpan(r5)     // Catch:{ all -> 0x0089 }
            if (r6 == 0) goto L_0x005b
            io.sentry.android.core.performance.AppStartMetrics r6 = io.sentry.android.core.performance.AppStartMetrics.getInstance()     // Catch:{ all -> 0x0089 }
            io.sentry.android.core.SentryAndroidOptions r0 = r4.options     // Catch:{ all -> 0x0089 }
            io.sentry.android.core.performance.TimeSpan r6 = r6.getAppStartTimeSpanWithFallback(r0)     // Catch:{ all -> 0x0089 }
            long r0 = r6.getDurationMs()     // Catch:{ all -> 0x0089 }
            r2 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x005b
            io.sentry.protocol.MeasurementValue r6 = new io.sentry.protocol.MeasurementValue     // Catch:{ all -> 0x0089 }
            float r0 = (float) r0     // Catch:{ all -> 0x0089 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ all -> 0x0089 }
            io.sentry.MeasurementUnit$Duration r1 = io.sentry.MeasurementUnit.Duration.MILLISECOND     // Catch:{ all -> 0x0089 }
            java.lang.String r1 = r1.apiName()     // Catch:{ all -> 0x0089 }
            r6.<init>(r0, r1)     // Catch:{ all -> 0x0089 }
            io.sentry.android.core.performance.AppStartMetrics r0 = io.sentry.android.core.performance.AppStartMetrics.getInstance()     // Catch:{ all -> 0x0089 }
            io.sentry.android.core.performance.AppStartMetrics$AppStartType r0 = r0.getAppStartType()     // Catch:{ all -> 0x0089 }
            io.sentry.android.core.performance.AppStartMetrics$AppStartType r1 = io.sentry.android.core.performance.AppStartMetrics.AppStartType.COLD     // Catch:{ all -> 0x0089 }
            if (r0 != r1) goto L_0x0048
            java.lang.String r0 = "app_start_cold"
            goto L_0x004a
        L_0x0048:
            java.lang.String r0 = "app_start_warm"
        L_0x004a:
            java.util.Map r1 = r5.getMeasurements()     // Catch:{ all -> 0x0089 }
            r1.put(r0, r6)     // Catch:{ all -> 0x0089 }
            io.sentry.android.core.performance.AppStartMetrics r6 = io.sentry.android.core.performance.AppStartMetrics.getInstance()     // Catch:{ all -> 0x0089 }
            r4.attachColdAppStartSpans(r6, r5)     // Catch:{ all -> 0x0089 }
            r6 = 1
            r4.sentStartMeasurement = r6     // Catch:{ all -> 0x0089 }
        L_0x005b:
            io.sentry.protocol.SentryId r6 = r5.getEventId()     // Catch:{ all -> 0x0089 }
            io.sentry.protocol.Contexts r0 = r5.getContexts()     // Catch:{ all -> 0x0089 }
            io.sentry.SpanContext r0 = r0.getTrace()     // Catch:{ all -> 0x0089 }
            if (r6 == 0) goto L_0x0087
            if (r0 == 0) goto L_0x0087
            java.lang.String r0 = r0.getOperation()     // Catch:{ all -> 0x0089 }
            java.lang.String r1 = "ui.load"
            boolean r0 = r0.contentEquals(r1)     // Catch:{ all -> 0x0089 }
            if (r0 == 0) goto L_0x0087
            io.sentry.android.core.ActivityFramesTracker r0 = r4.activityFramesTracker     // Catch:{ all -> 0x0089 }
            java.util.Map r6 = r0.takeMetrics(r6)     // Catch:{ all -> 0x0089 }
            if (r6 == 0) goto L_0x0087
            java.util.Map r0 = r5.getMeasurements()     // Catch:{ all -> 0x0089 }
            r0.putAll(r6)     // Catch:{ all -> 0x0089 }
        L_0x0087:
            monitor-exit(r4)
            return r5
        L_0x0089:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.PerformanceAndroidEventProcessor.process(io.sentry.protocol.SentryTransaction, io.sentry.Hint):io.sentry.protocol.SentryTransaction");
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0013  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean hasAppStartSpan(io.sentry.protocol.SentryTransaction r7) {
        /*
            r6 = this;
            java.util.List r0 = r7.getSpans()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            java.lang.String r2 = "app.start.warm"
            r3 = 1
            java.lang.String r4 = "app.start.cold"
            if (r1 == 0) goto L_0x002e
            java.lang.Object r1 = r0.next()
            io.sentry.protocol.SentrySpan r1 = (io.sentry.protocol.SentrySpan) r1
            java.lang.String r5 = r1.getOp()
            boolean r4 = r5.contentEquals(r4)
            if (r4 != 0) goto L_0x002d
            java.lang.String r1 = r1.getOp()
            boolean r1 = r1.contentEquals(r2)
            if (r1 == 0) goto L_0x0008
        L_0x002d:
            return r3
        L_0x002e:
            io.sentry.protocol.Contexts r7 = r7.getContexts()
            io.sentry.SpanContext r7 = r7.getTrace()
            if (r7 == 0) goto L_0x004d
            java.lang.String r0 = r7.getOperation()
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x004e
            java.lang.String r7 = r7.getOperation()
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r3 = 0
        L_0x004e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.PerformanceAndroidEventProcessor.hasAppStartSpan(io.sentry.protocol.SentryTransaction):boolean");
    }

    private void attachColdAppStartSpans(AppStartMetrics appStartMetrics, SentryTransaction sentryTransaction) {
        SpanContext trace;
        if (appStartMetrics.getAppStartType() == AppStartMetrics.AppStartType.COLD && (trace = sentryTransaction.getContexts().getTrace()) != null) {
            SentryId traceId = trace.getTraceId();
            SpanId spanId = null;
            Iterator<SentrySpan> it = sentryTransaction.getSpans().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SentrySpan next = it.next();
                if (next.getOp().contentEquals("app.start.cold")) {
                    spanId = next.getSpanId();
                    break;
                }
            }
            long classLoadedUptimeMs = appStartMetrics.getClassLoadedUptimeMs();
            TimeSpan appStartTimeSpan = appStartMetrics.getAppStartTimeSpan();
            if (appStartTimeSpan.hasStarted() && Math.abs(classLoadedUptimeMs - appStartTimeSpan.getStartUptimeMs()) <= 10000) {
                TimeSpan timeSpan = new TimeSpan();
                timeSpan.setStartedAt(appStartTimeSpan.getStartUptimeMs());
                timeSpan.setStartUnixTimeMs(appStartTimeSpan.getStartTimestampMs());
                timeSpan.setStoppedAt(classLoadedUptimeMs);
                timeSpan.setDescription("Process Initialization");
                sentryTransaction.getSpans().add(timeSpanToSentrySpan(timeSpan, spanId, traceId, APP_METRICS_PROCESS_INIT_OP));
            }
            List<TimeSpan> contentProviderOnCreateTimeSpans = appStartMetrics.getContentProviderOnCreateTimeSpans();
            if (!contentProviderOnCreateTimeSpans.isEmpty()) {
                for (TimeSpan timeSpanToSentrySpan : contentProviderOnCreateTimeSpans) {
                    sentryTransaction.getSpans().add(timeSpanToSentrySpan(timeSpanToSentrySpan, spanId, traceId, APP_METRICS_CONTENT_PROVIDER_OP));
                }
            }
            TimeSpan applicationOnCreateTimeSpan = appStartMetrics.getApplicationOnCreateTimeSpan();
            if (applicationOnCreateTimeSpan.hasStopped()) {
                sentryTransaction.getSpans().add(timeSpanToSentrySpan(applicationOnCreateTimeSpan, spanId, traceId, APP_METRICS_APPLICATION_OP));
            }
            List<ActivityLifecycleTimeSpan> activityLifecycleTimeSpans = appStartMetrics.getActivityLifecycleTimeSpans();
            if (!activityLifecycleTimeSpans.isEmpty()) {
                for (ActivityLifecycleTimeSpan next2 : activityLifecycleTimeSpans) {
                    if (next2.getOnCreate().hasStarted() && next2.getOnCreate().hasStopped()) {
                        sentryTransaction.getSpans().add(timeSpanToSentrySpan(next2.getOnCreate(), spanId, traceId, APP_METRICS_ACTIVITIES_OP));
                    }
                    if (next2.getOnStart().hasStarted() && next2.getOnStart().hasStopped()) {
                        sentryTransaction.getSpans().add(timeSpanToSentrySpan(next2.getOnStart(), spanId, traceId, APP_METRICS_ACTIVITIES_OP));
                    }
                }
            }
        }
    }

    private static SentrySpan timeSpanToSentrySpan(TimeSpan timeSpan, SpanId spanId, SentryId sentryId, String str) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(SpanDataConvention.THREAD_ID, Long.valueOf(Looper.getMainLooper().getThread().getId()));
        hashMap.put(SpanDataConvention.THREAD_NAME, SentryThread.JsonKeys.MAIN);
        return new SentrySpan(Double.valueOf(timeSpan.getStartTimestampSecs()), Double.valueOf(timeSpan.getProjectedStopTimestampSecs()), sentryId, new SpanId(), spanId, str, timeSpan.getDescription(), SpanStatus.OK, APP_METRICS_ORIGIN, new ConcurrentHashMap(), new ConcurrentHashMap(), (Map<String, List<MetricSummary>>) null, hashMap);
    }
}
