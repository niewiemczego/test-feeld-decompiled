package io.sentry.util;

public final class ClassLoaderUtils {
    public static ClassLoader classLoaderOrDefault(ClassLoader classLoader) {
        return classLoader == null ? ClassLoader.getSystemClassLoader() : classLoader;
    }
}
