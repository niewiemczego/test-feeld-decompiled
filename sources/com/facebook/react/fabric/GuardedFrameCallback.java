package com.facebook.react.fabric;

import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.ChoreographerCompat;

public abstract class GuardedFrameCallback extends ChoreographerCompat.FrameCallback {
    private final JSExceptionHandler mExceptionHandler;

    /* access modifiers changed from: protected */
    public abstract void doFrameGuarded(long j);

    @Deprecated
    protected GuardedFrameCallback(ReactContext reactContext) {
        this(reactContext.getExceptionHandler());
    }

    protected GuardedFrameCallback(JSExceptionHandler jSExceptionHandler) {
        this.mExceptionHandler = jSExceptionHandler;
    }

    public final void doFrame(long j) {
        try {
            doFrameGuarded(j);
        } catch (RuntimeException e) {
            this.mExceptionHandler.handleException(e);
        }
    }
}
