package io.sentry.util;

import io.sentry.ILogger;
import io.sentry.util.HintUtils;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HintUtils$$ExternalSyntheticLambda3 implements HintUtils.SentryHintFallback {
    public final /* synthetic */ ILogger f$0;

    public /* synthetic */ HintUtils$$ExternalSyntheticLambda3(ILogger iLogger) {
        this.f$0 = iLogger;
    }

    public final void accept(Object obj, Class cls) {
        LogUtils.logNotInstanceOf(cls, obj, this.f$0);
    }
}
