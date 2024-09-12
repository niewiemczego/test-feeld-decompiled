package io.sentry.metrics;

import io.sentry.MeasurementUnit;
import java.util.Map;

public abstract class Metric {
    private final String key;
    private final Map<String, String> tags;
    private final MetricType type;
    private final MeasurementUnit unit;

    public abstract void add(double d);

    public abstract int getWeight();

    public abstract Iterable<?> serialize();

    public Metric(MetricType metricType, String str, MeasurementUnit measurementUnit, Map<String, String> map) {
        this.type = metricType;
        this.key = str;
        this.unit = measurementUnit;
        this.tags = map;
    }

    public MetricType getType() {
        return this.type;
    }

    public String getKey() {
        return this.key;
    }

    public MeasurementUnit getUnit() {
        return this.unit;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }
}
