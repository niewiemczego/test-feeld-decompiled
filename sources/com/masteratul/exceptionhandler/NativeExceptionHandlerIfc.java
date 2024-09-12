package com.masteratul.exceptionhandler;

import java.lang.Thread;

public interface NativeExceptionHandlerIfc {
    void handleNativeException(Thread thread, Throwable th, Thread.UncaughtExceptionHandler uncaughtExceptionHandler);
}
