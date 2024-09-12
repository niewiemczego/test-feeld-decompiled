package com.swmansion.gesturehandler.core;

import android.view.MotionEvent;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/swmansion/gesturehandler/core/NativeViewGestureHandler$Companion$defaultHook$1", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$NativeViewGestureHandlerHook;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NativeViewGestureHandler.kt */
public final class NativeViewGestureHandler$Companion$defaultHook$1 implements NativeViewGestureHandler.NativeViewGestureHandlerHook {
    NativeViewGestureHandler$Companion$defaultHook$1() {
    }

    public void afterGestureEnd(MotionEvent motionEvent) {
        NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.afterGestureEnd(this, motionEvent);
    }

    public boolean canBegin() {
        return NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.canBegin(this);
    }

    public void handleEventBeforeActivation(MotionEvent motionEvent) {
        NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.handleEventBeforeActivation(this, motionEvent);
    }

    public boolean shouldCancelRootViewGestureHandlerIfNecessary() {
        return NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.shouldCancelRootViewGestureHandlerIfNecessary(this);
    }

    public boolean shouldRecognizeSimultaneously(GestureHandler<?> gestureHandler) {
        return NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.shouldRecognizeSimultaneously(this, gestureHandler);
    }

    public boolean wantsToHandleEventBeforeActivation() {
        return NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.wantsToHandleEventBeforeActivation(this);
    }
}
