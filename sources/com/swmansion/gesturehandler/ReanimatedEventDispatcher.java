package com.swmansion.gesturehandler;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.events.Event;
import com.swmansion.reanimated.NodesManager;
import com.swmansion.reanimated.ReanimatedModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\u0005\u001a\u00020\u0006\"\u000e\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\b2\u0006\u0010\t\u001a\u0002H\u00072\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/swmansion/gesturehandler/ReanimatedEventDispatcher;", "", "()V", "reanimatedModule", "Lcom/swmansion/reanimated/ReanimatedModule;", "sendEvent", "", "T", "Lcom/facebook/react/uimanager/events/Event;", "event", "reactApplicationContext", "Lcom/facebook/react/bridge/ReactContext;", "(Lcom/facebook/react/uimanager/events/Event;Lcom/facebook/react/bridge/ReactContext;)V", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ReanimatedEventDispatcher.kt */
public final class ReanimatedEventDispatcher {
    private ReanimatedModule reanimatedModule;

    public final <T extends Event<T>> void sendEvent(T t, ReactContext reactContext) {
        NodesManager nodesManager;
        Intrinsics.checkNotNullParameter(t, "event");
        Intrinsics.checkNotNullParameter(reactContext, "reactApplicationContext");
        if (this.reanimatedModule == null) {
            this.reanimatedModule = (ReanimatedModule) reactContext.getNativeModule(ReanimatedModule.class);
        }
        ReanimatedModule reanimatedModule2 = this.reanimatedModule;
        if (reanimatedModule2 != null && (nodesManager = reanimatedModule2.getNodesManager()) != null) {
            nodesManager.onEventDispatch(t);
        }
    }
}
