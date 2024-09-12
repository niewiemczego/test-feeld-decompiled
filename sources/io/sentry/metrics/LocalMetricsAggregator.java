package io.sentry.metrics;

import io.sentry.MeasurementUnit;
import io.sentry.protocol.MetricSummary;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class LocalMetricsAggregator {
    private final Map<String, Map<String, GaugeMetric>> buckets = new HashMap();

    public void add(String str, MetricType metricType, String str2, double d, MeasurementUnit measurementUnit, Map<String, String> map, long j) {
        String exportKey = MetricsHelper.getExportKey(metricType, str2, measurementUnit);
        synchronized (this.buckets) {
            Map map2 = this.buckets.get(exportKey);
            if (map2 == null) {
                map2 = new HashMap();
                this.buckets.put(exportKey, map2);
            }
            GaugeMetric gaugeMetric = (GaugeMetric) map2.get(str);
            if (gaugeMetric == null) {
                map2.put(str, new GaugeMetric(str2, d, measurementUnit, map));
            } else {
                gaugeMetric.add(d);
            }
        }
    }

    public Map<String, List<MetricSummary>> getSummaries() {
        HashMap hashMap = new HashMap();
        synchronized (this.buckets) {
            for (Map.Entry next : this.buckets.entrySet()) {
                String str = (String) Objects.requireNonNull((String) next.getKey());
                ArrayList arrayList = new ArrayList();
                for (GaugeMetric gaugeMetric : ((Map) next.getValue()).values()) {
                    MetricSummary metricSummary = r8;
                    MetricSummary metricSummary2 = new MetricSummary(gaugeMetric.getMin(), gaugeMetric.getMax(), gaugeMetric.getSum(), gaugeMetric.getCount(), gaugeMetric.getTags());
                    arrayList.add(metricSummary);
                }
                hashMap.put(str, arrayList);
            }
        }
        return hashMap;
    }
}
