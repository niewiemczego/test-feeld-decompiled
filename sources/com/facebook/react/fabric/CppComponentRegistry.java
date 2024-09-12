package com.facebook.react.fabric;

import com.facebook.jni.HybridData;

public class CppComponentRegistry {
    private final HybridData mHybridData;

    private static native HybridData initHybrid();

    static {
        FabricSoLoader.staticInit();
    }

    private CppComponentRegistry(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
