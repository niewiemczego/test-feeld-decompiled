package com.swmansion.reanimated.keyboard;

import com.facebook.jni.HybridData;

public class KeyboardWorkletWrapper {
    private final HybridData mHybridData;

    public native void invoke(int i, int i2);

    private KeyboardWorkletWrapper(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
