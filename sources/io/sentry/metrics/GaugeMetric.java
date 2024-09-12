package io.sentry.metrics;

import io.sentry.MeasurementUnit;
import java.util.Arrays;
import java.util.Map;

public final class GaugeMetric extends Metric {
    private int count = 1;
    private double last;
    private double max;
    private double min;
    private double sum;

    public int getWeight() {
        return 5;
    }

    public GaugeMetric(String str, double d, MeasurementUnit measurementUnit, Map<String, String> map) {
        super(MetricType.Gauge, str, measurementUnit, map);
        this.last = d;
        this.min = d;
        this.max = d;
        this.sum = d;
    }

    public void add(double d) {
        this.last = d;
        this.min = Math.min(this.min, d);
        this.max = Math.max(this.max, d);
        this.sum += d;
        this.count++;
    }

    public double getLast() {
        return this.last;
    }

    public double getMin() {
        return this.min;
    }

    public double getMax() {
        return this.max;
    }

    public double getSum() {
        return this.sum;
    }

    public int getCount() {
        return this.count;
    }

    public Iterable<?> serialize() {
        return Arrays.asList(new Number[]{Double.valueOf(this.last), Double.valueOf(this.min), Double.valueOf(this.max), Double.valueOf(this.sum), Integer.valueOf(this.count)});
    }
}
