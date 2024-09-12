package com.facebook.react.fabric;

public class EmptyReactNativeConfig implements ReactNativeConfig {
    public boolean getBool(String str) {
        return false;
    }

    public double getDouble(String str) {
        return 0.0d;
    }

    public long getInt64(String str) {
        return 0;
    }

    public String getString(String str) {
        return "";
    }
}
