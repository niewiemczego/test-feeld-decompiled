package com.swmansion.reanimated;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

public abstract class NativeReanimatedModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "ReanimatedModule";

    @Nonnull
    public String getName() {
        return "ReanimatedModule";
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract boolean installTurboModule(String str);

    public NativeReanimatedModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }
}
