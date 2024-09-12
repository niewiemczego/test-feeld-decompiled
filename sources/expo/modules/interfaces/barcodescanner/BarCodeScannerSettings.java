package expo.modules.interfaces.barcodescanner;

import java.util.HashMap;
import java.util.Map;

public class BarCodeScannerSettings extends HashMap<BarCodeScannerSettingsKey, Object> {
    public BarCodeScannerSettings() {
    }

    public BarCodeScannerSettings(Map<String, Object> map) {
        for (Map.Entry next : map.entrySet()) {
            BarCodeScannerSettingsKey fromStringName = BarCodeScannerSettingsKey.fromStringName((String) next.getKey());
            if (fromStringName != null) {
                put(fromStringName, next.getValue());
            }
        }
    }

    public void putTypes(Object obj) {
        put(BarCodeScannerSettingsKey.TYPES, obj);
    }

    public Object getTypes() {
        return get(BarCodeScannerSettingsKey.TYPES);
    }
}
