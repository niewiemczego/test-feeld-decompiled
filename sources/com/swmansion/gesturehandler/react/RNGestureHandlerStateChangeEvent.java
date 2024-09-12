package com.swmansion.gesturehandler.react;

import android.view.View;
import androidx.core.util.Pools;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.swmansion.gesturehandler.core.GestureHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016JE\u0010\u000f\u001a\u00020\b\"\u000e\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u00112\u0006\u0010\u0012\u001a\u0002H\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerStateChangeEvent;", "Lcom/facebook/react/uimanager/events/Event;", "()V", "extraData", "Lcom/facebook/react/bridge/WritableMap;", "canCoalesce", "", "dispatch", "", "rctEventEmitter", "Lcom/facebook/react/uimanager/events/RCTEventEmitter;", "getCoalescingKey", "", "getEventName", "", "init", "T", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "handler", "newState", "", "oldState", "dataExtractor", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerEventDataExtractor;", "(Lcom/swmansion/gesturehandler/core/GestureHandler;IILcom/swmansion/gesturehandler/react/RNGestureHandlerEventDataExtractor;)V", "onDispose", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RNGestureHandlerStateChangeEvent.kt */
public final class RNGestureHandlerStateChangeEvent extends Event<RNGestureHandlerStateChangeEvent> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Pools.SynchronizedPool<RNGestureHandlerStateChangeEvent> EVENTS_POOL = new Pools.SynchronizedPool<>(7);
    public static final String EVENT_NAME = "onGestureHandlerStateChange";
    private static final int TOUCH_EVENTS_POOL_SIZE = 7;
    private WritableMap extraData;

    public /* synthetic */ RNGestureHandlerStateChangeEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public boolean canCoalesce() {
        return false;
    }

    public short getCoalescingKey() {
        return 0;
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    private RNGestureHandlerStateChangeEvent() {
    }

    /* access modifiers changed from: private */
    public final <T extends GestureHandler<T>> void init(T t, int i, int i2, RNGestureHandlerEventDataExtractor<T> rNGestureHandlerEventDataExtractor) {
        View view = t.getView();
        Intrinsics.checkNotNull(view);
        super.init(view.getId());
        this.extraData = Companion.createEventData(t, rNGestureHandlerEventDataExtractor, i, i2);
    }

    public void onDispose() {
        this.extraData = null;
        EVENTS_POOL.release(this);
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        Intrinsics.checkNotNullParameter(rCTEventEmitter, "rctEventEmitter");
        rCTEventEmitter.receiveEvent(getViewTag(), EVENT_NAME, this.extraData);
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JC\u0010\n\u001a\u00020\u000b\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\r2\u0006\u0010\u000e\u001a\u0002H\f2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\f\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t¢\u0006\u0002\u0010\u0013JC\u0010\u0014\u001a\u00020\u0005\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\r2\u0006\u0010\u000e\u001a\u0002H\f2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\f\u0018\u00010\u0010¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerStateChangeEvent$Companion;", "", "()V", "EVENTS_POOL", "Landroidx/core/util/Pools$SynchronizedPool;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerStateChangeEvent;", "EVENT_NAME", "", "TOUCH_EVENTS_POOL_SIZE", "", "createEventData", "Lcom/facebook/react/bridge/WritableMap;", "T", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "handler", "dataExtractor", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerEventDataExtractor;", "newState", "oldState", "(Lcom/swmansion/gesturehandler/core/GestureHandler;Lcom/swmansion/gesturehandler/react/RNGestureHandlerEventDataExtractor;II)Lcom/facebook/react/bridge/WritableMap;", "obtain", "(Lcom/swmansion/gesturehandler/core/GestureHandler;IILcom/swmansion/gesturehandler/react/RNGestureHandlerEventDataExtractor;)Lcom/swmansion/gesturehandler/react/RNGestureHandlerStateChangeEvent;", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RNGestureHandlerStateChangeEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T extends GestureHandler<T>> RNGestureHandlerStateChangeEvent obtain(T t, int i, int i2, RNGestureHandlerEventDataExtractor<T> rNGestureHandlerEventDataExtractor) {
            Intrinsics.checkNotNullParameter(t, "handler");
            RNGestureHandlerStateChangeEvent rNGestureHandlerStateChangeEvent = (RNGestureHandlerStateChangeEvent) RNGestureHandlerStateChangeEvent.EVENTS_POOL.acquire();
            if (rNGestureHandlerStateChangeEvent == null) {
                rNGestureHandlerStateChangeEvent = new RNGestureHandlerStateChangeEvent((DefaultConstructorMarker) null);
            }
            rNGestureHandlerStateChangeEvent.init(t, i, i2, rNGestureHandlerEventDataExtractor);
            return rNGestureHandlerStateChangeEvent;
        }

        public final <T extends GestureHandler<T>> WritableMap createEventData(T t, RNGestureHandlerEventDataExtractor<T> rNGestureHandlerEventDataExtractor, int i, int i2) {
            Intrinsics.checkNotNullParameter(t, "handler");
            WritableMap createMap = Arguments.createMap();
            if (rNGestureHandlerEventDataExtractor != null) {
                Intrinsics.checkNotNullExpressionValue(createMap, "this");
                rNGestureHandlerEventDataExtractor.extractEventData(t, createMap);
            }
            createMap.putInt("handlerTag", t.getTag());
            createMap.putInt("state", i);
            createMap.putInt("oldState", i2);
            Intrinsics.checkNotNullExpressionValue(createMap, "createMap().apply {\n    …ldState\", oldState)\n    }");
            return createMap;
        }
    }
}
