package com.facebook.react.fabric;

public interface ReactNativeConfig {
    public static final ReactNativeConfig DEFAULT_CONFIG = new EmptyReactNativeConfig();

    boolean getBool(String str);

    double getDouble(String str);

    long getInt64(String str);

    String getString(String str);
}
