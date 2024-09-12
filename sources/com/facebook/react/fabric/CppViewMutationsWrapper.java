package com.facebook.react.fabric;

import com.facebook.jni.HybridData;

public class CppViewMutationsWrapper {
    private final HybridData mHybridData = initHybrid();

    private static native HybridData initHybrid();

    public native void runCppViewMutations();

    static {
        FabricSoLoader.staticInit();
    }

    private CppViewMutationsWrapper() {
    }

    public synchronized void destroy() {
        HybridData hybridData = this.mHybridData;
        if (hybridData != null) {
            hybridData.resetNative();
        }
    }

    private boolean isValid() {
        HybridData hybridData = this.mHybridData;
        if (hybridData != null) {
            return hybridData.isValid();
        }
        return false;
    }
}
