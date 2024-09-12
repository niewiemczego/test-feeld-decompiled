package com.swmansion.reanimated.nativeProxy;

import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class NoopEventHandler implements RCTEventEmitter {
    public void receiveEvent(int i, String str, WritableMap writableMap) {
    }

    public void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2) {
    }
}
