package com.masteratul.exceptionhandler;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.lang.Thread;

public class ReactNativeExceptionHandlerModule extends ReactContextBaseJavaModule {
    /* access modifiers changed from: private */
    public static Class errorIntentTargetClass = DefaultErrorScreen.class;
    /* access modifiers changed from: private */
    public static NativeExceptionHandlerIfc nativeExceptionHandler;
    /* access modifiers changed from: private */
    public Activity activity;
    /* access modifiers changed from: private */
    public Callback callbackHolder;
    /* access modifiers changed from: private */
    public Thread.UncaughtExceptionHandler originalHandler;
    private ReactApplicationContext reactContext;

    public String getName() {
        return "ReactNativeExceptionHandler";
    }

    public ReactNativeExceptionHandlerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @ReactMethod
    public void setHandlerforNativeException(final boolean z, final boolean z2, Callback callback) {
        this.callbackHolder = callback;
        this.originalHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread thread, Throwable th) {
                String stackTraceString = Log.getStackTraceString(th);
                ReactNativeExceptionHandlerModule.this.callbackHolder.invoke(stackTraceString);
                if (ReactNativeExceptionHandlerModule.nativeExceptionHandler != null) {
                    ReactNativeExceptionHandlerModule.nativeExceptionHandler.handleNativeException(thread, th, ReactNativeExceptionHandlerModule.this.originalHandler);
                    return;
                }
                ReactNativeExceptionHandlerModule reactNativeExceptionHandlerModule = ReactNativeExceptionHandlerModule.this;
                Activity unused = reactNativeExceptionHandlerModule.activity = reactNativeExceptionHandlerModule.getCurrentActivity();
                Intent intent = new Intent();
                intent.setClass(ReactNativeExceptionHandlerModule.this.activity, ReactNativeExceptionHandlerModule.errorIntentTargetClass);
                intent.putExtra("stack_trace_string", stackTraceString);
                intent.setFlags(268435456);
                ReactNativeExceptionHandlerModule.this.activity.startActivity(intent);
                ReactNativeExceptionHandlerModule.this.activity.finish();
                if (z && ReactNativeExceptionHandlerModule.this.originalHandler != null) {
                    ReactNativeExceptionHandlerModule.this.originalHandler.uncaughtException(thread, th);
                }
                if (z2) {
                    System.exit(0);
                }
            }
        });
    }

    public static void replaceErrorScreenActivityClass(Class cls) {
        errorIntentTargetClass = cls;
    }

    public static void setNativeExceptionHandler(NativeExceptionHandlerIfc nativeExceptionHandlerIfc) {
        nativeExceptionHandler = nativeExceptionHandlerIfc;
    }
}
