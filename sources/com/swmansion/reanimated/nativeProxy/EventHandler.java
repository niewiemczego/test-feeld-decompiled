package com.swmansion.reanimated.nativeProxy;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class EventHandler implements RCTEventEmitter {
    UIManagerModule.CustomEventNamesResolver mCustomEventNamesResolver;
    private final HybridData mHybridData;

    public native void receiveEvent(String str, int i, WritableMap writableMap);

    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
    }

    private EventHandler(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public void receiveEvent(int i, String str, WritableMap writableMap) {
        receiveEvent(this.mCustomEventNamesResolver.resolveCustomEventName(str), i, writableMap);
    }
}
