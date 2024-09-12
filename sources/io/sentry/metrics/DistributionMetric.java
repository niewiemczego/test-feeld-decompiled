package io.sentry.metrics;

import io.sentry.MeasurementUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DistributionMetric extends Metric {
    private final List<Double> values;

    public DistributionMetric(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map) {
        super(MetricType.Distribution, str, measurementUnit, map);
        ArrayList arrayList = new ArrayList();
        this.values = arrayList;
        arrayList.add(Double.valueOf(d));
    }

    public void add(double d) {
        this.values.add(Double.valueOf(d));
    }

    public int getWeight() {
        return this.values.size();
    }

    public Iterable<?> serialize() {
        return this.values;
    }
}
