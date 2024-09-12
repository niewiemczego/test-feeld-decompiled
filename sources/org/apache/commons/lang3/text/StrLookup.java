package org.apache.commons.lang3.text;

import java.util.Map;

public abstract class StrLookup<V> {
    private static final StrLookup<String> NONE_LOOKUP = new MapStrLookup((Map) null);
    private static final StrLookup<String> SYSTEM_PROPERTIES_LOOKUP;

    public abstract String lookup(String str);

    static {
        StrLookup<String> strLookup;
        try {
            strLookup = new MapStrLookup<>(System.getProperties());
        } catch (SecurityException unused) {
            strLookup = NONE_LOOKUP;
        }
        SYSTEM_PROPERTIES_LOOKUP = strLookup;
    }

    public static StrLookup<?> noneLookup() {
        return NONE_LOOKUP;
    }

    public static StrLookup<String> systemPropertiesLookup() {
        return SYSTEM_PROPERTIES_LOOKUP;
    }

    public static <V> StrLookup<V> mapLookup(Map<String, V> map) {
        return new MapStrLookup(map);
    }

    protected StrLookup() {
    }

    static class MapStrLookup<V> extends StrLookup<V> {
        private final Map<String, V> map;

        MapStrLookup(Map<String, V> map2) {
            this.map = map2;
        }

        public String lookup(String str) {
            V v;
            Map<String, V> map2 = this.map;
            if (map2 == null || (v = map2.get(str)) == null) {
                return null;
            }
            return v.toString();
        }
    }
}
