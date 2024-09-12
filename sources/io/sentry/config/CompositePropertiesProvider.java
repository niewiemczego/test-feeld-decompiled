package io.sentry.config;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class CompositePropertiesProvider implements PropertiesProvider {
    private final List<PropertiesProvider> providers;

    public CompositePropertiesProvider(List<PropertiesProvider> list) {
        this.providers = list;
    }

    public String getProperty(String str) {
        for (PropertiesProvider property : this.providers) {
            String property2 = property.getProperty(str);
            if (property2 != null) {
                return property2;
            }
        }
        return null;
    }

    public Map<String, String> getMap(String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (PropertiesProvider map : this.providers) {
            concurrentHashMap.putAll(map.getMap(str));
        }
        return concurrentHashMap;
    }
}
