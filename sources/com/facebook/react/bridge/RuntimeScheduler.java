package com.facebook.react.bridge;

import com.facebook.jni.HybridData;

public class RuntimeScheduler {
    private HybridData mHybridData;

    public RuntimeScheduler(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
