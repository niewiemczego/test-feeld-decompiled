package com.facebook.react.views.common;

import android.content.ContextWrapper;

public class ContextUtils {
    public static <T> T findContextOfType(T t, Class<? extends T> cls) {
        T baseContext;
        while (!cls.isInstance(t)) {
            if (!(t instanceof ContextWrapper) || t == (baseContext = ((ContextWrapper) t).getBaseContext())) {
                return null;
            }
            t = baseContext;
        }
        return t;
    }
}
