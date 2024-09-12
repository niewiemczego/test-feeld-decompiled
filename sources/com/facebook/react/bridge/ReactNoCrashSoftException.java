package com.facebook.react.bridge;

public class ReactNoCrashSoftException extends RuntimeException {
    public ReactNoCrashSoftException(String str) {
        super(str);
    }

    public ReactNoCrashSoftException(Throwable th) {
        super(th);
    }

    public ReactNoCrashSoftException(String str, Throwable th) {
        super(str, th);
    }
}
