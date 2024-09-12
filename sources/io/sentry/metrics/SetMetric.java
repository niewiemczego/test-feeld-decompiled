package io.sentry.metrics;

import io.sentry.MeasurementUnit;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class SetMetric extends Metric {
    private final Set<Integer> values = new HashSet();

    public SetMetric(String str, MeasurementUnit measurementUnit, Map<String, String> map) {
        super(MetricType.Set, str, measurementUnit, map);
    }

    public void add(double d) {
        this.values.add(Integer.valueOf((int) d));
    }

    public int getWeight() {
        return this.values.size();
    }

    public Iterable<?> serialize() {
        return this.values;
    }
}
