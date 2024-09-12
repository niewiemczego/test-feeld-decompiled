package com.launchdarkly.sdk.internal.events;

import com.launchdarkly.sdk.LDContext;

public interface EventContextDeduplicator {
    void flush();

    Long getFlushInterval();

    boolean processContext(LDContext lDContext);
}
