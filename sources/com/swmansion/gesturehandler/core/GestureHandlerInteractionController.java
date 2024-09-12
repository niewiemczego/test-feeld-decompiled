package com.swmansion.gesturehandler.core;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H&J \u0010\u0007\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H&J \u0010\b\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H&J \u0010\t\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H&¨\u0006\n"}, d2 = {"Lcom/swmansion/gesturehandler/core/GestureHandlerInteractionController;", "", "shouldHandlerBeCancelledBy", "", "handler", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "otherHandler", "shouldRecognizeSimultaneously", "shouldRequireHandlerToWaitForFailure", "shouldWaitForHandlerFailure", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GestureHandlerInteractionController.kt */
public interface GestureHandlerInteractionController {
    boolean shouldHandlerBeCancelledBy(GestureHandler<?> gestureHandler, GestureHandler<?> gestureHandler2);

    boolean shouldRecognizeSimultaneously(GestureHandler<?> gestureHandler, GestureHandler<?> gestureHandler2);

    boolean shouldRequireHandlerToWaitForFailure(GestureHandler<?> gestureHandler, GestureHandler<?> gestureHandler2);

    boolean shouldWaitForHandlerFailure(GestureHandler<?> gestureHandler, GestureHandler<?> gestureHandler2);
}
