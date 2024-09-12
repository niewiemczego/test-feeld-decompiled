package io.sentry.metrics;

import io.sentry.protocol.SentryId;

public interface IMetricsClient {
    SentryId captureMetrics(EncodedMetrics encodedMetrics);
}
