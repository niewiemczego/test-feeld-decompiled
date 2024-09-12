package io.sentry.android.core.internal.util;

public class ClassUtil {
    public static String getClassName(Object obj) {
        if (obj == null) {
            return null;
        }
        String canonicalName = obj.getClass().getCanonicalName();
        if (canonicalName != null) {
            return canonicalName;
        }
        return obj.getClass().getSimpleName();
    }
}
