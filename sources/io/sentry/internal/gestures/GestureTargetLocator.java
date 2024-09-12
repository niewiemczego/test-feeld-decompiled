package io.sentry.internal.gestures;

import io.sentry.internal.gestures.UiElement;

public interface GestureTargetLocator {
    UiElement locate(Object obj, float f, float f2, UiElement.Type type);
}
