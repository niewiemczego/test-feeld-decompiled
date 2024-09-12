package com.facebook.react.jscexecutor;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.soloader.SoLoader;

public class JSCExecutor extends JavaScriptExecutor {
    private static native HybridData initHybrid(ReadableNativeMap readableNativeMap);

    public String getName() {
        return "JSCExecutor";
    }

    static {
        loadLibrary();
    }

    public static void loadLibrary() throws UnsatisfiedLinkError {
        SoLoader.loadLibrary("jscexecutor");
    }

    JSCExecutor(ReadableNativeMap readableNativeMap) {
        super(initHybrid(readableNativeMap));
    }
}
