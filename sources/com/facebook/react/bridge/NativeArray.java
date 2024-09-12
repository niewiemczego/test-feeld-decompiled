package com.facebook.react.bridge;

import com.facebook.jni.HybridData;

public abstract class NativeArray implements NativeArrayInterface {
    private HybridData mHybridData;

    public native String toString();

    static {
        ReactBridge.staticInit();
    }

    protected NativeArray(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
