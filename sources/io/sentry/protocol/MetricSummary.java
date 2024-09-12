package io.sentry.protocol;

import io.sentry.ILogger;
import io.sentry.JsonDeserializer;
import io.sentry.JsonObjectReader;
import io.sentry.JsonSerializable;
import io.sentry.JsonUnknown;
import io.sentry.ObjectWriter;
import io.sentry.util.CollectionUtils;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class MetricSummary implements JsonUnknown, JsonSerializable {
    private int count;
    private double max;
    private double min;
    private double sum;
    /* access modifiers changed from: private */
    public Map<String, String> tags;
    private Map<String, Object> unknown;

    public static final class JsonKeys {
        public static final String COUNT = "count";
        public static final String MAX = "max";
        public static final String MIN = "min";
        public static final String SUM = "sum";
        public static final String TAGS = "tags";
    }

    public MetricSummary() {
    }

    public MetricSummary(double d, double d2, double d3, int i, Map<String, String> map) {
        this.tags = map;
        this.min = d;
        this.max = d2;
        this.count = i;
        this.sum = d3;
        this.unknown = null;
    }

    public void setTags(Map<String, String> map) {
        this.tags = map;
    }

    public void setMin(double d) {
        this.min = d;
    }

    public void setMax(double d) {
        this.max = d;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setSum(double d) {
        this.sum = d;
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

    public Map<String, String> getTags() {
        return this.tags;
    }

    public Map<String, Object> getUnknown() {
        return this.unknown;
    }

    public void setUnknown(Map<String, Object> map) {
        this.unknown = map;
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        objectWriter.name(JsonKeys.MIN).value(this.min);
        objectWriter.name(JsonKeys.MAX).value(this.max);
        objectWriter.name(JsonKeys.SUM).value(this.sum);
        objectWriter.name(JsonKeys.COUNT).value((long) this.count);
        if (this.tags != null) {
            objectWriter.name("tags");
            objectWriter.value(iLogger, this.tags);
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<MetricSummary> {
        public MetricSummary deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            MetricSummary metricSummary = new MetricSummary();
            jsonObjectReader.beginObject();
            ConcurrentHashMap concurrentHashMap = null;
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case 107876:
                        if (nextName.equals(JsonKeys.MAX)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 108114:
                        if (nextName.equals(JsonKeys.MIN)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 114251:
                        if (nextName.equals(JsonKeys.SUM)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 3552281:
                        if (nextName.equals("tags")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 94851343:
                        if (nextName.equals(JsonKeys.COUNT)) {
                            c = 4;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        metricSummary.setMax(jsonObjectReader.nextDouble());
                        break;
                    case 1:
                        metricSummary.setMin(jsonObjectReader.nextDouble());
                        break;
                    case 2:
                        metricSummary.setSum(jsonObjectReader.nextDouble());
                        break;
                    case 3:
                        Map unused = metricSummary.tags = CollectionUtils.newConcurrentHashMap((Map) jsonObjectReader.nextObjectOrNull());
                        break;
                    case 4:
                        metricSummary.setCount(jsonObjectReader.nextInt());
                        break;
                    default:
                        if (concurrentHashMap == null) {
                            concurrentHashMap = new ConcurrentHashMap();
                        }
                        jsonObjectReader.nextUnknown(iLogger, concurrentHashMap, nextName);
                        break;
                }
            }
            metricSummary.setUnknown(concurrentHashMap);
            jsonObjectReader.endObject();
            return metricSummary;
        }
    }
}
