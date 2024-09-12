package com.swmansion.gesturehandler;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¨\u0006\u0005"}, d2 = {"dispatchEvent", "", "Lcom/facebook/react/bridge/ReactContext;", "event", "Lcom/facebook/react/uimanager/events/Event;", "react-native-gesture-handler_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ReactContextExtensions.kt */
public final class ReactContextExtensionsKt {
    public static final void dispatchEvent(ReactContext reactContext, Event<?> event) {
        Intrinsics.checkNotNullParameter(reactContext, "<this>");
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            NativeModule nativeModule = reactContext.getNativeModule(UIManagerModule.class);
            Intrinsics.checkNotNull(nativeModule);
            ((UIManagerModule) nativeModule).getEventDispatcher().dispatchEvent(event);
        } catch (NullPointerException e) {
            throw new Exception("Couldn't get an instance of UIManagerModule. Gesture Handler is unable to send an event.", e);
        }
    }
}
