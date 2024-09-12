package com.swmansion.gesturehandler.react;

import com.facebook.react.bridge.WritableMap;
import com.swmansion.gesturehandler.core.GestureHandler;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\bH&¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerEventDataExtractor;", "T", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "", "extractEventData", "", "handler", "eventData", "Lcom/facebook/react/bridge/WritableMap;", "(Lcom/swmansion/gesturehandler/core/GestureHandler;Lcom/facebook/react/bridge/WritableMap;)V", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RNGestureHandlerEventDataExtractor.kt */
public interface RNGestureHandlerEventDataExtractor<T extends GestureHandler<T>> {
    void extractEventData(T t, WritableMap writableMap);
}
