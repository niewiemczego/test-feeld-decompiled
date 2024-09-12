package io.sentry.metrics;

import com.braze.Constants;
import com.facebook.internal.security.CertificateUtil;
import io.sentry.MeasurementUnit;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public final class MetricsHelper {
    public static final long FLUSHER_SLEEP_TIME_MS = 5000;
    private static long FLUSH_SHIFT_MS = ((long) (new Random().nextFloat() * 10000.0f));
    public static final int MAX_TOTAL_WEIGHT = 100000;
    private static final Pattern NAME_PATTERN = Pattern.compile("[^\\w\\-.]+");
    private static final int ROLLUP_IN_SECONDS = 10;
    private static final char TAGS_ESCAPE_CHAR = '\\';
    private static final char TAGS_KEY_VALUE_DELIMITER = '=';
    private static final char TAGS_PAIR_DELIMITER = ',';
    private static final Pattern TAG_KEY_PATTERN = Pattern.compile("[^\\w\\-./]+");
    private static final Pattern UNIT_PATTERN = Pattern.compile("\\W+");

    public static long getTimeBucketKey(long j) {
        long j2 = ((j / 1000) / 10) * 10;
        return j >= 0 ? j2 : j2 - 1;
    }

    public static long getCutoffTimestampMs(long j) {
        return (j - 10000) - FLUSH_SHIFT_MS;
    }

    public static String sanitizeUnit(String str) {
        return UNIT_PATTERN.matcher(str).replaceAll("");
    }

    public static String sanitizeName(String str) {
        return NAME_PATTERN.matcher(str).replaceAll("_");
    }

    public static String sanitizeTagKey(String str) {
        return TAG_KEY_PATTERN.matcher(str).replaceAll("");
    }

    public static String sanitizeTagValue(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == 10) {
                sb.append("\\n");
            } else if (charAt == 13) {
                sb.append("\\r");
            } else if (charAt == 9) {
                sb.append("\\t");
            } else if (charAt == '\\') {
                sb.append("\\\\");
            } else if (charAt == '|') {
                sb.append("\\u{7c}");
            } else if (charAt == ',') {
                sb.append("\\u{2c}");
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static String toStatsdType(MetricType metricType) {
        int i = AnonymousClass1.$SwitchMap$io$sentry$metrics$MetricType[metricType.ordinal()];
        if (i == 1) {
            return "c";
        }
        if (i == 2) {
            return "g";
        }
        if (i == 3) {
            return Constants.BRAZE_PUSH_NOTIFICATION_SOUND_DEFAULT_VALUE;
        }
        if (i == 4) {
            return Constants.BRAZE_PUSH_SUMMARY_TEXT_KEY;
        }
        throw new IllegalArgumentException("Invalid Metric Type: " + metricType.name());
    }

    public static String getMetricBucketKey(MetricType metricType, String str, MeasurementUnit measurementUnit, Map<String, String> map) {
        String statsdType = toStatsdType(metricType);
        String tagsKey = getTagsKey(map);
        return String.format("%s_%s_%s_%s", new Object[]{statsdType, str, getUnitName(measurementUnit), tagsKey});
    }

    private static String getUnitName(MeasurementUnit measurementUnit) {
        return measurementUnit != null ? measurementUnit.apiName() : "none";
    }

    private static String getTagsKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            String escapeString = escapeString((String) next.getKey());
            String escapeString2 = escapeString((String) next.getValue());
            if (sb.length() > 0) {
                sb.append(TAGS_PAIR_DELIMITER);
            }
            sb.append(escapeString).append(TAGS_KEY_VALUE_DELIMITER).append(escapeString2);
        }
        return sb.toString();
    }

    private static String escapeString(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == ',' || charAt == '=') {
                sb.append('\\');
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static String getExportKey(MetricType metricType, String str, MeasurementUnit measurementUnit) {
        return String.format("%s:%s@%s", new Object[]{toStatsdType(metricType), str, getUnitName(measurementUnit)});
    }

    /* renamed from: io.sentry.metrics.MetricsHelper$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$sentry$MeasurementUnit$Duration;
        static final /* synthetic */ int[] $SwitchMap$io$sentry$metrics$MetricType;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(29:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0085 */
        static {
            /*
                io.sentry.MeasurementUnit$Duration[] r0 = io.sentry.MeasurementUnit.Duration.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$sentry$MeasurementUnit$Duration = r0
                r1 = 1
                io.sentry.MeasurementUnit$Duration r2 = io.sentry.MeasurementUnit.Duration.NANOSECOND     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$io$sentry$MeasurementUnit$Duration     // Catch:{ NoSuchFieldError -> 0x001d }
                io.sentry.MeasurementUnit$Duration r3 = io.sentry.MeasurementUnit.Duration.MICROSECOND     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$io$sentry$MeasurementUnit$Duration     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.sentry.MeasurementUnit$Duration r4 = io.sentry.MeasurementUnit.Duration.MILLISECOND     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$io$sentry$MeasurementUnit$Duration     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.sentry.MeasurementUnit$Duration r5 = io.sentry.MeasurementUnit.Duration.SECOND     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r4 = $SwitchMap$io$sentry$MeasurementUnit$Duration     // Catch:{ NoSuchFieldError -> 0x003e }
                io.sentry.MeasurementUnit$Duration r5 = io.sentry.MeasurementUnit.Duration.MINUTE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r6 = 5
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r4 = $SwitchMap$io$sentry$MeasurementUnit$Duration     // Catch:{ NoSuchFieldError -> 0x0049 }
                io.sentry.MeasurementUnit$Duration r5 = io.sentry.MeasurementUnit.Duration.HOUR     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6 = 6
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r4 = $SwitchMap$io$sentry$MeasurementUnit$Duration     // Catch:{ NoSuchFieldError -> 0x0054 }
                io.sentry.MeasurementUnit$Duration r5 = io.sentry.MeasurementUnit.Duration.DAY     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r6 = 7
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r4 = $SwitchMap$io$sentry$MeasurementUnit$Duration     // Catch:{ NoSuchFieldError -> 0x0060 }
                io.sentry.MeasurementUnit$Duration r5 = io.sentry.MeasurementUnit.Duration.WEEK     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r6 = 8
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                io.sentry.metrics.MetricType[] r4 = io.sentry.metrics.MetricType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$io$sentry$metrics$MetricType = r4
                io.sentry.metrics.MetricType r5 = io.sentry.metrics.MetricType.Counter     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r1 = $SwitchMap$io$sentry$metrics$MetricType     // Catch:{ NoSuchFieldError -> 0x007b }
                io.sentry.metrics.MetricType r4 = io.sentry.metrics.MetricType.Gauge     // Catch:{ NoSuchFieldError -> 0x007b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                int[] r0 = $SwitchMap$io$sentry$metrics$MetricType     // Catch:{ NoSuchFieldError -> 0x0085 }
                io.sentry.metrics.MetricType r1 = io.sentry.metrics.MetricType.Distribution     // Catch:{ NoSuchFieldError -> 0x0085 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0085 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0085 }
            L_0x0085:
                int[] r0 = $SwitchMap$io$sentry$metrics$MetricType     // Catch:{ NoSuchFieldError -> 0x008f }
                io.sentry.metrics.MetricType r1 = io.sentry.metrics.MetricType.Set     // Catch:{ NoSuchFieldError -> 0x008f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.metrics.MetricsHelper.AnonymousClass1.<clinit>():void");
        }
    }

    public static double convertNanosTo(MeasurementUnit.Duration duration, long j) {
        switch (AnonymousClass1.$SwitchMap$io$sentry$MeasurementUnit$Duration[duration.ordinal()]) {
            case 1:
                return (double) j;
            case 2:
                return ((double) j) / 1000.0d;
            case 3:
                return ((double) j) / 1000000.0d;
            case 4:
                return ((double) j) / 1.0E9d;
            case 5:
                return ((double) j) / 6.0E10d;
            case 6:
                return ((double) j) / 3.6E12d;
            case 7:
                return ((double) j) / 8.64E13d;
            case 8:
                return (((double) j) / 8.64E13d) / 7.0d;
            default:
                throw new IllegalArgumentException("Unknown Duration unit: " + duration.name());
        }
    }

    public static void encodeMetrics(long j, Collection<Metric> collection, StringBuilder sb) {
        for (Metric next : collection) {
            sb.append(sanitizeName(next.getKey()));
            sb.append("@");
            sb.append(sanitizeUnit(getUnitName(next.getUnit())));
            for (Object next2 : next.serialize()) {
                sb.append(CertificateUtil.DELIMITER);
                sb.append(next2);
            }
            sb.append("|");
            sb.append(toStatsdType(next.getType()));
            Map<String, String> tags = next.getTags();
            if (tags != null) {
                sb.append("|#");
                boolean z = true;
                for (Map.Entry next3 : tags.entrySet()) {
                    String sanitizeTagKey = sanitizeTagKey((String) next3.getKey());
                    if (z) {
                        z = false;
                    } else {
                        sb.append(",");
                    }
                    sb.append(sanitizeTagKey);
                    sb.append(CertificateUtil.DELIMITER);
                    sb.append(sanitizeTagValue((String) next3.getValue()));
                }
            }
            sb.append("|T");
            sb.append(j);
            sb.append("\n");
        }
    }

    public static Map<String, String> mergeTags(Map<String, String> map, Map<String, String> map2) {
        if (map == null) {
            return Collections.unmodifiableMap(map2);
        }
        HashMap hashMap = new HashMap(map);
        for (Map.Entry next : map2.entrySet()) {
            String str = (String) next.getKey();
            if (!hashMap.containsKey(str)) {
                hashMap.put(str, (String) next.getValue());
            }
        }
        return hashMap;
    }

    public static void setFlushShiftMs(long j) {
        FLUSH_SHIFT_MS = j;
    }
}
