package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import com.facebook.jni.HybridData;

public class WritableNativeArray extends ReadableNativeArray implements WritableArray {
    private static native HybridData initHybrid();

    private native void pushNativeArray(ReadableNativeArray readableNativeArray);

    private native void pushNativeMap(ReadableNativeMap readableNativeMap);

    public native void pushBoolean(boolean z);

    public native void pushDouble(double d);

    public native void pushInt(int i);

    public native void pushNull();

    public native void pushString(String str);

    static {
        ReactBridge.staticInit();
    }

    public WritableNativeArray() {
        super(initHybrid());
    }

    public void pushArray(ReadableArray readableArray) {
        Assertions.assertCondition(readableArray == null || (readableArray instanceof ReadableNativeArray), "Illegal type provided");
        pushNativeArray((ReadableNativeArray) readableArray);
    }

    public void pushMap(ReadableMap readableMap) {
        Assertions.assertCondition(readableMap == null || (readableMap instanceof ReadableNativeMap), "Illegal type provided");
        pushNativeMap((ReadableNativeMap) readableMap);
    }
}
