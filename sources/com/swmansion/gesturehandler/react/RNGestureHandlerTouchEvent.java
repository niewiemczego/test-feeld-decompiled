package com.swmansion.gesturehandler.react;

import android.view.View;
import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.swmansion.gesturehandler.core.GestureHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J%\u0010\u0010\u001a\u00020\n\"\u000e\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110\u00122\u0006\u0010\u0013\u001a\u0002H\u0011H\u0002¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerTouchEvent;", "Lcom/facebook/react/uimanager/events/Event;", "()V", "coalescingKey", "", "extraData", "Lcom/facebook/react/bridge/WritableMap;", "canCoalesce", "", "dispatch", "", "rctEventEmitter", "Lcom/facebook/react/uimanager/events/RCTEventEmitter;", "getCoalescingKey", "getEventName", "", "init", "T", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "handler", "(Lcom/swmansion/gesturehandler/core/GestureHandler;)V", "onDispose", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RNGestureHandlerTouchEvent.kt */
public final class RNGestureHandlerTouchEvent extends Event<RNGestureHandlerTouchEvent> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Pools.SynchronizedPool<RNGestureHandlerTouchEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(7);
    public static final String EVENT_NAME = "onGestureHandlerEvent";
    public static final int EVENT_TOUCH_CANCELLED = 4;
    public static final int EVENT_TOUCH_DOWN = 1;
    public static final int EVENT_TOUCH_MOVE = 2;
    public static final int EVENT_TOUCH_UP = 3;
    public static final int EVENT_UNDETERMINED = 0;
    private static final int TOUCH_EVENTS_POOL_SIZE = 7;
    private short coalescingKey;
    private WritableMap extraData;

    public /* synthetic */ RNGestureHandlerTouchEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public boolean canCoalesce() {
        return true;
    }

    public String getEventName() {
        return "onGestureHandlerEvent";
    }

    private RNGestureHandlerTouchEvent() {
    }

    /* access modifiers changed from: private */
    public final <T extends GestureHandler<T>> void init(T t) {
        View view = t.getView();
        Intrinsics.checkNotNull(view);
        super.init(view.getId());
        this.extraData = Companion.createEventData(t);
        this.coalescingKey = t.getEventCoalescingKey();
    }

    public void onDispose() {
        this.extraData = null;
        EVENTS_POOL.release(this);
    }

    public short getCoalescingKey() {
        return this.coalescingKey;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        Intrinsics.checkNotNullParameter(rCTEventEmitter, "rctEventEmitter");
        rCTEventEmitter.receiveEvent(getViewTag(), "onGestureHandlerEvent", this.extraData);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u000f\u001a\u00020\u0010\"\u000e\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110\u00122\u0006\u0010\u0013\u001a\u0002H\u0011¢\u0006\u0002\u0010\u0014J#\u0010\u0015\u001a\u00020\u0005\"\u000e\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110\u00122\u0006\u0010\u0013\u001a\u0002H\u0011¢\u0006\u0002\u0010\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerTouchEvent$Companion;", "", "()V", "EVENTS_POOL", "Landroidx/core/util/Pools$SynchronizedPool;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerTouchEvent;", "EVENT_NAME", "", "EVENT_TOUCH_CANCELLED", "", "EVENT_TOUCH_DOWN", "EVENT_TOUCH_MOVE", "EVENT_TOUCH_UP", "EVENT_UNDETERMINED", "TOUCH_EVENTS_POOL_SIZE", "createEventData", "Lcom/facebook/react/bridge/WritableMap;", "T", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "handler", "(Lcom/swmansion/gesturehandler/core/GestureHandler;)Lcom/facebook/react/bridge/WritableMap;", "obtain", "(Lcom/swmansion/gesturehandler/core/GestureHandler;)Lcom/swmansion/gesturehandler/react/RNGestureHandlerTouchEvent;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RNGestureHandlerTouchEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T extends GestureHandler<T>> RNGestureHandlerTouchEvent obtain(T t) {
            Intrinsics.checkNotNullParameter(t, "handler");
            RNGestureHandlerTouchEvent rNGestureHandlerTouchEvent = (RNGestureHandlerTouchEvent) RNGestureHandlerTouchEvent.EVENTS_POOL.acquire();
            if (rNGestureHandlerTouchEvent == null) {
                rNGestureHandlerTouchEvent = new RNGestureHandlerTouchEvent((DefaultConstructorMarker) null);
            }
            rNGestureHandlerTouchEvent.init(t);
            return rNGestureHandlerTouchEvent;
        }

        public final <T extends GestureHandler<T>> WritableMap createEventData(T t) {
            Intrinsics.checkNotNullParameter(t, "handler");
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("handlerTag", t.getTag());
            createMap.putInt("state", t.getState());
            createMap.putInt("numberOfTouches", t.getTrackedPointersCount());
            createMap.putInt("eventType", t.getTouchEventType());
            WritableArray consumeChangedTouchesPayload = t.consumeChangedTouchesPayload();
            if (consumeChangedTouchesPayload != null) {
                createMap.putArray(TouchesHelper.CHANGED_TOUCHES_KEY, consumeChangedTouchesPayload);
            }
            WritableArray consumeAllTouchesPayload = t.consumeAllTouchesPayload();
            if (consumeAllTouchesPayload != null) {
                createMap.putArray("allTouches", consumeAllTouchesPayload);
            }
            if (t.isAwaiting() && t.getState() == 4) {
                createMap.putInt("state", 2);
            }
            Intrinsics.checkNotNullExpressionValue(createMap, "createMap().apply {\n    …TATE_BEGAN)\n      }\n    }");
            return createMap;
        }
    }
}
