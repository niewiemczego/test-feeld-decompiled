package io.sentry.metrics;

import io.sentry.IMetricsAggregator;
import io.sentry.ISpan;
import io.sentry.MeasurementUnit;
import io.sentry.metrics.MetricsApi;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public final class NoopMetricsAggregator implements IMetricsAggregator, MetricsApi.IMetricsInterface {
    private static final NoopMetricsAggregator instance = new NoopMetricsAggregator();

    public void close() throws IOException {
    }

    public void distribution(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map, long j, LocalMetricsAggregator localMetricsAggregator) {
    }

    public void flush(boolean z) {
    }

    public void gauge(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map, long j, LocalMetricsAggregator localMetricsAggregator) {
    }

    public LocalMetricsAggregator getLocalMetricsAggregator() {
        return null;
    }

    public IMetricsAggregator getMetricsAggregator() {
        return this;
    }

    public void increment(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map, long j, LocalMetricsAggregator localMetricsAggregator) {
    }

    public void set(String str, int i, MeasurementUnit measurementUnit, Map<String, String> map, long j, LocalMetricsAggregator localMetricsAggregator) {
    }

    public void set(String str, String str2, MeasurementUnit measurementUnit, Map<String, String> map, long j, LocalMetricsAggregator localMetricsAggregator) {
    }

    public ISpan startSpanForMetric(String str, String str2) {
        return null;
    }

    public static NoopMetricsAggregator getInstance() {
        return instance;
    }

    public void timing(String str, Runnable runnable, MeasurementUnit.Duration duration, Map<String, String> map, LocalMetricsAggregator localMetricsAggregator) {
        runnable.run();
    }

    public Map<String, String> getDefaultTagsForMetrics() {
        return Collections.emptyMap();
    }
}
