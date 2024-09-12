package com.swmansion.gesturehandler.react;

import android.view.MotionEvent;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.OnTouchEventListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u00020\u0003\"\u000e\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\tJ5\u0010\n\u001a\u00020\u0003\"\u000e\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u0002H\u00042\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u00020\u0003\"\u000e\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u0006\u0010\u0006\u001a\u0002H\u0004H\u0016¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"com/swmansion/gesturehandler/react/RNGestureHandlerModule$eventListener$1", "Lcom/swmansion/gesturehandler/core/OnTouchEventListener;", "onHandlerUpdate", "", "T", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "handler", "event", "Landroid/view/MotionEvent;", "(Lcom/swmansion/gesturehandler/core/GestureHandler;Landroid/view/MotionEvent;)V", "onStateChange", "newState", "", "oldState", "(Lcom/swmansion/gesturehandler/core/GestureHandler;II)V", "onTouchEvent", "(Lcom/swmansion/gesturehandler/core/GestureHandler;)V", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RNGestureHandlerModule.kt */
public final class RNGestureHandlerModule$eventListener$1 implements OnTouchEventListener {
    final /* synthetic */ RNGestureHandlerModule this$0;

    RNGestureHandlerModule$eventListener$1(RNGestureHandlerModule rNGestureHandlerModule) {
        this.this$0 = rNGestureHandlerModule;
    }

    public <T extends GestureHandler<T>> void onHandlerUpdate(T t, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(t, "handler");
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        this.this$0.onHandlerUpdate(t);
    }

    public <T extends GestureHandler<T>> void onStateChange(T t, int i, int i2) {
        Intrinsics.checkNotNullParameter(t, "handler");
        this.this$0.onStateChange(t, i, i2);
    }

    public <T extends GestureHandler<T>> void onTouchEvent(T t) {
        Intrinsics.checkNotNullParameter(t, "handler");
        this.this$0.onTouchEvent(t);
    }
}
