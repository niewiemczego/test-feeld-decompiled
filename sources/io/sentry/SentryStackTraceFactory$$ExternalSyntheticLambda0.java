package io.sentry;

import io.sentry.protocol.SentryStackFrame;
import io.sentry.util.CollectionUtils;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentryStackTraceFactory$$ExternalSyntheticLambda0 implements CollectionUtils.Predicate {
    public final boolean test(Object obj) {
        return Boolean.TRUE.equals(((SentryStackFrame) obj).isInApp());
    }
}
