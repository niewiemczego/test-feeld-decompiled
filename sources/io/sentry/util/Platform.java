package io.sentry.util;

public final class Platform {
    static boolean isAndroid;
    static boolean isJavaNinePlus;

    static {
        try {
            isAndroid = "The Android Project".equals(System.getProperty("java.vendor"));
        } catch (Throwable unused) {
            isAndroid = false;
        }
        try {
            String property = System.getProperty("java.specification.version");
            if (property != null) {
                isJavaNinePlus = Double.valueOf(property).doubleValue() >= 9.0d;
            } else {
                isJavaNinePlus = false;
            }
        } catch (Throwable unused2) {
            isJavaNinePlus = false;
        }
    }

    public static boolean isAndroid() {
        return isAndroid;
    }

    public static boolean isJvm() {
        return !isAndroid;
    }

    public static boolean isJavaNinePlus() {
        return isJavaNinePlus;
    }
}
