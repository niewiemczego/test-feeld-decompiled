package io.sentry.metrics;

import java.nio.charset.Charset;
import java.util.Map;

public final class EncodedMetrics {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private final Map<Long, Map<String, Metric>> buckets;

    public EncodedMetrics(Map<Long, Map<String, Metric>> map) {
        this.buckets = map;
    }

    public byte[] encodeToStatsd() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : this.buckets.entrySet()) {
            MetricsHelper.encodeMetrics(((Long) next.getKey()).longValue(), ((Map) next.getValue()).values(), sb);
        }
        return sb.toString().getBytes(UTF8);
    }

    /* access modifiers changed from: package-private */
    public Map<Long, Map<String, Metric>> getBuckets() {
        return this.buckets;
    }
}
