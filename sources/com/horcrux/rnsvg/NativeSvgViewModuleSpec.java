package com.horcrux.rnsvg;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

public abstract class NativeSvgViewModuleSpec extends ReactContextBaseJavaModule {
    @ReactMethod
    public abstract void toDataURL(Double d, ReadableMap readableMap, Callback callback);

    public NativeSvgViewModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }
}
