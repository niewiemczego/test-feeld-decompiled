package expo.modules.interfaces.barcodescanner;

public enum BarCodeScannerSettingsKey {
    TYPES("barCodeTypes");
    
    private final String mName;

    private BarCodeScannerSettingsKey(String str) {
        this.mName = str;
    }

    public static BarCodeScannerSettingsKey fromStringName(String str) {
        for (BarCodeScannerSettingsKey barCodeScannerSettingsKey : values()) {
            if (barCodeScannerSettingsKey.getName().equalsIgnoreCase(str)) {
                return barCodeScannerSettingsKey;
            }
        }
        return null;
    }

    public String getName() {
        return this.mName;
    }
}
