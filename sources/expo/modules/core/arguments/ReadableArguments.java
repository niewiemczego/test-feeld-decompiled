package expo.modules.core.arguments;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface ReadableArguments {
    boolean containsKey(String str);

    Object get(String str);

    boolean getBoolean(String str, boolean z);

    double getDouble(String str, double d);

    int getInt(String str, int i);

    List getList(String str, List list);

    Map getMap(String str, Map map);

    String getString(String str, String str2);

    boolean isEmpty();

    Collection<String> keys();

    int size();

    boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    double getDouble(String str) {
        return getDouble(str, 0.0d);
    }

    int getInt(String str) {
        return getInt(str, 0);
    }

    String getString(String str) {
        return getString(str, (String) null);
    }

    List getList(String str) {
        return getList(str, (List) null);
    }

    Map getMap(String str) {
        return getMap(str, (Map) null);
    }

    ReadableArguments getArguments(String str) {
        Object obj = get(str);
        if (obj instanceof Map) {
            return new MapArguments((Map) obj);
        }
        return null;
    }

    Bundle toBundle() {
        Bundle bundle = new Bundle();
        for (String next : keys()) {
            Object obj = get(next);
            if (obj == null) {
                bundle.putString(next, (String) null);
            } else if (obj instanceof String) {
                bundle.putString(next, (String) obj);
            } else if (obj instanceof Integer) {
                bundle.putInt(next, ((Integer) obj).intValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(next, ((Double) obj).doubleValue());
            } else if (obj instanceof Long) {
                bundle.putLong(next, ((Long) obj).longValue());
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(next, ((Boolean) obj).booleanValue());
            } else if (obj instanceof ArrayList) {
                bundle.putParcelableArrayList(next, (ArrayList) obj);
            } else if (obj instanceof Map) {
                bundle.putBundle(next, new MapArguments((Map) obj).toBundle());
            } else if (obj instanceof Bundle) {
                bundle.putBundle(next, (Bundle) obj);
            } else {
                throw new UnsupportedOperationException("Could not put a value of " + obj.getClass() + " to bundle.");
            }
        }
        return bundle;
    }
}
