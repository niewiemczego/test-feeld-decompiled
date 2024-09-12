package com.facebook.react.modules.common;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.ReactConstants;

public class ModuleDataCleaner {

    public interface Cleanable {
        void clearSensitiveData();
    }

    public static void cleanDataFromModules(CatalystInstance catalystInstance) {
        for (NativeModule next : catalystInstance.getNativeModules()) {
            if (next instanceof Cleanable) {
                FLog.d(ReactConstants.TAG, "Cleaning data from " + next.getName());
                ((Cleanable) next).clearSensitiveData();
            }
        }
    }

    public static void cleanDataFromModules(ReactContext reactContext) {
        for (NativeModule next : reactContext.getNativeModules()) {
            if (next instanceof Cleanable) {
                FLog.d(ReactConstants.TAG, "Cleaning data from " + next.getName());
                ((Cleanable) next).clearSensitiveData();
            }
        }
    }
}
