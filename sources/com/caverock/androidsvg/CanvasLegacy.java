package com.caverock.androidsvg;

import android.graphics.Canvas;
import com.braze.Constants;
import java.lang.reflect.Method;

class CanvasLegacy {
    static final int MATRIX_SAVE_FLAG;
    private static final Method SAVE;

    CanvasLegacy() {
    }

    static {
        try {
            MATRIX_SAVE_FLAG = ((Integer) Canvas.class.getField("MATRIX_SAVE_FLAG").get((Object) null)).intValue();
            SAVE = Canvas.class.getMethod("save", new Class[]{Integer.TYPE});
        } catch (Throwable th) {
            throw sneakyThrow(th);
        }
    }

    static void save(Canvas canvas, int i) {
        try {
            SAVE.invoke(canvas, new Object[]{Integer.valueOf(i)});
        } catch (Throwable th) {
            throw sneakyThrow(th);
        }
    }

    private static RuntimeException sneakyThrow(Throwable th) {
        if (th != null) {
            return (RuntimeException) sneakyThrow0(th);
        }
        throw new NullPointerException(Constants.BRAZE_PUSH_TITLE_KEY);
    }

    private static <T extends Throwable> T sneakyThrow0(Throwable th) throws Throwable {
        throw th;
    }
}
