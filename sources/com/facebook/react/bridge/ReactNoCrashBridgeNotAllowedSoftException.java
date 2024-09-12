package com.facebook.react.bridge;

public class ReactNoCrashBridgeNotAllowedSoftException extends ReactNoCrashSoftException {
    public ReactNoCrashBridgeNotAllowedSoftException(String str) {
        super(str);
    }

    public ReactNoCrashBridgeNotAllowedSoftException(Throwable th) {
        super(th);
    }

    public ReactNoCrashBridgeNotAllowedSoftException(String str, Throwable th) {
        super(str, th);
    }
}
