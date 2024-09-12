package com.zoontek.rnpermissions;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class NativePermissionsModuleSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    @ReactMethod
    public abstract void check(String str, Promise promise);

    @ReactMethod
    public abstract void checkLocationAccuracy(Promise promise);

    @ReactMethod
    public abstract void checkMultiplePermissions(ReadableArray readableArray, Promise promise);

    @ReactMethod
    public abstract void checkNotifications(Promise promise);

    @ReactMethod
    public abstract void checkPermission(String str, Promise promise);

    /* access modifiers changed from: protected */
    public abstract Map<String, Object> getTypedExportedConstants();

    @ReactMethod
    public abstract void openLimitedPhotoLibraryPicker(Promise promise);

    @ReactMethod
    public abstract void openSettings(Promise promise);

    @ReactMethod
    public abstract void request(String str, Promise promise);

    @ReactMethod
    public abstract void requestLocationAccuracy(String str, Promise promise);

    @ReactMethod
    public abstract void requestMultiplePermissions(ReadableArray readableArray, Promise promise);

    @ReactMethod
    public abstract void requestNotifications(ReadableArray readableArray, Promise promise);

    @ReactMethod
    public abstract void requestPermission(String str, Promise promise);

    @ReactMethod
    public abstract void shouldShowRequestPermissionRationale(String str, Promise promise);

    public NativePermissionsModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Nullable
    public final Map<String, Object> getConstants() {
        return getTypedExportedConstants();
    }
}
