package com.zoontek.rnbootsplash;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import java.util.Map;

@ReactModule(name = "RNBootSplash")
public class RNBootSplashModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    public String getName() {
        return RNBootSplashModuleImpl.NAME;
    }

    public void onHostPause() {
    }

    public void onHostResume() {
    }

    public RNBootSplashModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addLifecycleEventListener(this);
    }

    public void onHostDestroy() {
        RNBootSplashModuleImpl.onHostDestroy();
    }

    public Map<String, Object> getConstants() {
        return RNBootSplashModuleImpl.getConstants(getReactApplicationContext());
    }

    @ReactMethod
    public void hide(boolean z, Promise promise) {
        RNBootSplashModuleImpl.hide(getReactApplicationContext(), z, promise);
    }

    @ReactMethod
    public void isVisible(Promise promise) {
        RNBootSplashModuleImpl.isVisible(promise);
    }
}
