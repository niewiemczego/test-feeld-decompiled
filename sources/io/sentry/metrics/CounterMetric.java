package io.sentry.metrics;

import io.sentry.MeasurementUnit;
import java.util.Collections;
import java.util.Map;

public final class CounterMetric extends Metric {
    private double value;

    public int getWeight() {
        return 1;
    }

    public CounterMetric(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map) {
        super(MetricType.Counter, str, measurementUnit, map);
        this.value = d;
    }

    public double getValue() {
        return this.value;
    }

    public void add(double d) {
        this.value += d;
    }

    public Iterable<?> serialize() {
        return Collections.singletonList(Double.valueOf(this.value));
    }
}
