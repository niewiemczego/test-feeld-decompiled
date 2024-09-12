package expo.modules.core.arguments;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapArguments implements ReadableArguments {
    private Map<String, Object> mMap;

    public MapArguments() {
        this.mMap = new HashMap();
    }

    public MapArguments(Map<String, Object> map) {
        this.mMap = map;
    }

    public Collection<String> keys() {
        return this.mMap.keySet();
    }

    public boolean containsKey(String str) {
        return this.mMap.containsKey(str);
    }

    public Object get(String str) {
        return this.mMap.get(str);
    }

    public boolean getBoolean(String str, boolean z) {
        Object obj = this.mMap.get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
    }

    public double getDouble(String str, double d) {
        Object obj = this.mMap.get(str);
        return obj instanceof Number ? ((Number) obj).doubleValue() : d;
    }

    public int getInt(String str, int i) {
        Object obj = this.mMap.get(str);
        return obj instanceof Number ? ((Number) obj).intValue() : i;
    }

    public String getString(String str, String str2) {
        Object obj = this.mMap.get(str);
        return obj instanceof String ? (String) obj : str2;
    }

    public List getList(String str, List list) {
        Object obj = this.mMap.get(str);
        return obj instanceof List ? (List) obj : list;
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
}
