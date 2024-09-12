package expo.modules.core;

import expo.modules.core.interfaces.Arguments;
import java.util.List;
import java.util.Map;

public class MapHelper implements Arguments {
    private Map mMap;

    public MapHelper(Map map) {
        this.mMap = map;
    }

    public boolean containsKey(String str) {
        return this.mMap.containsKey(str);
    }

    public Object get(String str) {
        return this.mMap.get(str);
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public boolean getBoolean(String str, boolean z) {
        Object obj = this.mMap.get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
    }

    public double getDouble(String str) {
        return getDouble(str, 0.0d);
    }

    public double getDouble(String str, double d) {
        Object obj = this.mMap.get(str);
        return obj instanceof Number ? ((Number) obj).doubleValue() : d;
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public int getInt(String str, int i) {
        Object obj = this.mMap.get(str);
        return obj instanceof Number ? ((Number) obj).intValue() : i;
    }

    public long getLong(String str) {
        return getLong(str, 0);
    }

    public long getLong(String str, long j) {
        Object obj = this.mMap.get(str);
        return obj instanceof Number ? ((Number) obj).longValue() : j;
    }

    public String getString(String str) {
        return getString(str, (String) null);
    }

    public String getString(String str, String str2) {
        Object obj = this.mMap.get(str);
        return obj instanceof String ? (String) obj : str2;
    }

    public List getList(String str) {
        return getList(str, (List) null);
    }

    public List getList(String str, List list) {
        Object obj = this.mMap.get(str);
        return obj instanceof List ? (List) obj : list;
    }

    public Map getMap(String str) {
        return getMap(str, (Map) null);
    }

    public Map getMap(String str, Map map) {
        Object obj = this.mMap.get(str);
        return obj instanceof Map ? (Map) obj : map;
    }

    public boolean isEmpty() {
        return this.mMap.isEmpty();
    }

    public int size() {
        return this.mMap.size();
    }

    public Arguments getArguments(String str) {
        Map map = getMap(str);
        if (map != null) {
            return new MapHelper(map);
        }
        return null;
    }
}
