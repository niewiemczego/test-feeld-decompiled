package io.sentry.config;

import io.sentry.util.StringUtils;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class EnvironmentVariablePropertiesProvider implements PropertiesProvider {
    private static final String PREFIX = "SENTRY";

    EnvironmentVariablePropertiesProvider() {
    }

    public String getProperty(String str) {
        return StringUtils.removeSurrounding(System.getenv(propertyToEnvironmentVariableName(str)), "\"");
    }

    public Map<String, String> getMap(String str) {
        String removeSurrounding;
        String str2 = propertyToEnvironmentVariableName(str) + "_";
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry next : System.getenv().entrySet()) {
            String str3 = (String) next.getKey();
            if (str3.startsWith(str2) && (removeSurrounding = StringUtils.removeSurrounding((String) next.getValue(), "\"")) != null) {
                concurrentHashMap.put(str3.substring(str2.length()).toLowerCase(Locale.ROOT), removeSurrounding);
            }
        }
        return concurrentHashMap;
    }

    private String propertyToEnvironmentVariableName(String str) {
        return "SENTRY_" + str.replace(".", "_").replace("-", "_").toUpperCase(Locale.ROOT);
    }
}
