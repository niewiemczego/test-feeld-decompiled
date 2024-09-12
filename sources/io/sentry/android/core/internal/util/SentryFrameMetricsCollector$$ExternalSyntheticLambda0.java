package io.sentry.android.core.internal.util;

import io.sentry.ILogger;
import io.sentry.SentryLevel;
import java.lang.Thread;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryFrameMetricsCollector$$ExternalSyntheticLambda0 implements Thread.UncaughtExceptionHandler {
    public final /* synthetic */ ILogger f$0;

    public /* synthetic */ SentryFrameMetricsCollector$$ExternalSyntheticLambda0(ILogger iLogger) {
        this.f$0 = iLogger;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        this.f$0.log(SentryLevel.ERROR, "Error during frames measurements.", th);
    }
}
