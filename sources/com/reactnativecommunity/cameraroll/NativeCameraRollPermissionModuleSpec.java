package com.reactnativecommunity.cameraroll;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;

public abstract class NativeCameraRollPermissionModuleSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    @ReactMethod
    public abstract void addListener(String str);

    @ReactMethod
    public abstract void checkPermission(String str, Promise promise);

    @ReactMethod
    public abstract void refreshPhotoSelection(Promise promise);

    @ReactMethod
    public abstract void removeListeners(double d);

    @ReactMethod
    public abstract void requestAddOnlyPermission(Promise promise);

    @ReactMethod
    public abstract void requestReadWritePermission(Promise promise);

    public NativeCameraRollPermissionModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }
}
