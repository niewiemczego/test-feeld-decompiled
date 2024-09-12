package io.sentry.util;

public final class SampleRateUtils {
    public static boolean isValidSampleRate(Double d) {
        return isValidRate(d, true);
    }

    public static boolean isValidTracesSampleRate(Double d) {
        return isValidTracesSampleRate(d, true);
    }

    public static boolean isValidTracesSampleRate(Double d, boolean z) {
        return isValidRate(d, z);
    }

    public static boolean isValidProfilesSampleRate(Double d) {
        return isValidRate(d, true);
    }

    private static boolean isValidRate(Double d, boolean z) {
        if (d == null) {
            return z;
        }
        return !d.isNaN() && d.doubleValue() >= 0.0d && d.doubleValue() <= 1.0d;
    }
}
