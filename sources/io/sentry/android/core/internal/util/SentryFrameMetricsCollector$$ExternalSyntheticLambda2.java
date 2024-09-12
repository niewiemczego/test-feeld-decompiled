package io.sentry.android.core.internal.util;

import android.view.FrameMetrics;
import android.view.Window;
import io.sentry.android.core.BuildInfoProvider;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryFrameMetricsCollector$$ExternalSyntheticLambda2 implements Window.OnFrameMetricsAvailableListener {
    public final /* synthetic */ SentryFrameMetricsCollector f$0;
    public final /* synthetic */ BuildInfoProvider f$1;

    public /* synthetic */ SentryFrameMetricsCollector$$ExternalSyntheticLambda2(SentryFrameMetricsCollector sentryFrameMetricsCollector, BuildInfoProvider buildInfoProvider) {
        this.f$0 = sentryFrameMetricsCollector;
        this.f$1 = buildInfoProvider;
    }

    public final void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
        this.f$0.m913lambda$new$2$iosentryandroidcoreinternalutilSentryFrameMetricsCollector(this.f$1, window, frameMetrics, i);
    }
}
