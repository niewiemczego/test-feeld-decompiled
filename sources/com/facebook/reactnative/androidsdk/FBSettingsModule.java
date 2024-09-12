package com.facebook.reactnative.androidsdk;

import com.facebook.FacebookSdk;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "FBSettings")
public class FBSettingsModule extends BaseJavaModule {
    public static final String NAME = "FBSettings";

    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void setDataProcessingOptions(ReadableArray readableArray, int i, int i2) {
        FacebookSdk.setDataProcessingOptions((String[]) Utility.reactArrayToStringList(readableArray).toArray(new String[0]), i, i2);
    }

    @ReactMethod
    public static void initializeSDK() {
        FacebookSdk.fullyInitialize();
    }

    @ReactMethod
    public static void setAppID(String str) {
        FacebookSdk.setApplicationId(str);
    }

    @ReactMethod
    public static void setAppName(String str) {
        FacebookSdk.setApplicationName(str);
    }

    @ReactMethod
    public static void setGraphAPIVersion(String str) {
        FacebookSdk.setGraphApiVersion(str);
    }

    @ReactMethod
    public static void setAutoLogAppEventsEnabled(Boolean bool) {
        FacebookSdk.setAutoLogAppEventsEnabled(bool.booleanValue());
    }

    @ReactMethod
    public static void setAdvertiserIDCollectionEnabled(Boolean bool) {
        FacebookSdk.setAdvertiserIDCollectionEnabled(bool.booleanValue());
    }
}
