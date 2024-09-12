package com.swmansion.reanimated.nativeProxy;

import com.facebook.jni.HybridData;
import com.swmansion.reanimated.NodesManager;

public class AnimationFrameCallback implements NodesManager.OnAnimationFrame {
    private final HybridData mHybridData;

    public native void onAnimationFrame(double d);

    private AnimationFrameCallback(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
