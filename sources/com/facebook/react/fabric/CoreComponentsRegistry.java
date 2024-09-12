package com.facebook.react.fabric;

import com.facebook.jni.HybridData;

public class CoreComponentsRegistry {
    private final HybridData mHybridData;

    private native HybridData initHybrid(ComponentFactory componentFactory);

    static {
        FabricSoLoader.staticInit();
    }

    private CoreComponentsRegistry(ComponentFactory componentFactory) {
        this.mHybridData = initHybrid(componentFactory);
    }

    public static CoreComponentsRegistry register(ComponentFactory componentFactory) {
        return new CoreComponentsRegistry(componentFactory);
    }
}
