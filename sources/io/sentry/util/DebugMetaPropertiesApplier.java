package io.sentry.util;

import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.util.List;
import java.util.Properties;

public final class DebugMetaPropertiesApplier {
    public static String DEBUG_META_PROPERTIES_FILENAME = "sentry-debug-meta.properties";

    public static void applyToOptions(SentryOptions sentryOptions, List<Properties> list) {
        if (list != null) {
            applyBundleIds(sentryOptions, list);
            applyProguardUuid(sentryOptions, list);
        }
    }

    private static void applyBundleIds(SentryOptions sentryOptions, List<Properties> list) {
        if (sentryOptions.getBundleIds().isEmpty()) {
            for (Properties property : list) {
                String property2 = property.getProperty("io.sentry.bundle-ids");
                sentryOptions.getLogger().log(SentryLevel.DEBUG, "Bundle IDs found: %s", property2);
                if (property2 != null) {
                    for (String addBundleId : property2.split(",", -1)) {
                        sentryOptions.addBundleId(addBundleId);
                    }
                }
            }
        }
    }

    private static void applyProguardUuid(SentryOptions sentryOptions, List<Properties> list) {
        if (sentryOptions.getProguardUuid() == null) {
            for (Properties proguardUuid : list) {
                String proguardUuid2 = getProguardUuid(proguardUuid);
                if (proguardUuid2 != null) {
                    sentryOptions.getLogger().log(SentryLevel.DEBUG, "Proguard UUID found: %s", proguardUuid2);
                    sentryOptions.setProguardUuid(proguardUuid2);
                    return;
                }
            }
        }
    }

    public static String getProguardUuid(Properties properties) {
        return properties.getProperty("io.sentry.ProguardUuids");
    }
}
