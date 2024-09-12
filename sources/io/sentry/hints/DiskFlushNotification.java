package io.sentry.hints;

import io.sentry.protocol.SentryId;

public interface DiskFlushNotification {
    boolean isFlushable(SentryId sentryId);

    void markFlushed();

    void setFlushable(SentryId sentryId);
}
