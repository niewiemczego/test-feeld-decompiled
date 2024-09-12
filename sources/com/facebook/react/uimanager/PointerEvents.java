package com.facebook.react.uimanager;

import java.util.Locale;

public enum PointerEvents {
    NONE,
    BOX_NONE,
    BOX_ONLY,
    AUTO;

    public static PointerEvents parsePointerEvents(String str) {
        if (str == null) {
            return AUTO;
        }
        return valueOf(str.toUpperCase(Locale.US).replace("-", "_"));
    }

    public static boolean canBeTouchTarget(PointerEvents pointerEvents) {
        return pointerEvents == AUTO || pointerEvents == BOX_ONLY;
    }

    public static boolean canChildrenBeTouchTarget(PointerEvents pointerEvents) {
        return pointerEvents == AUTO || pointerEvents == BOX_NONE;
    }
}
