package com.swmansion.gesturehandler.core;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, d2 = {"Lcom/swmansion/gesturehandler/core/GestureUtils;", "", "()V", "getLastPointerX", "", "event", "Landroid/view/MotionEvent;", "averageTouches", "", "getLastPointerY", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GestureUtils.kt */
public final class GestureUtils {
    public static final GestureUtils INSTANCE = new GestureUtils();

    private GestureUtils() {
    }

    public final float getLastPointerX(MotionEvent motionEvent, boolean z) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        int actionIndex = motionEvent.getActionMasked() == 6 ? motionEvent.getActionIndex() : -1;
        if (z) {
            float f = 0.0f;
            int pointerCount = motionEvent.getPointerCount();
            int i = 0;
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (i2 != actionIndex) {
                    f += motionEvent.getX(i2);
                    i++;
                }
            }
            return f / ((float) i);
        }
        int pointerCount2 = motionEvent.getPointerCount() - 1;
        if (pointerCount2 == actionIndex) {
            pointerCount2--;
        }
        return motionEvent.getX(pointerCount2);
    }

    public final float getLastPointerY(MotionEvent motionEvent, boolean z) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        int actionIndex = motionEvent.getActionMasked() == 6 ? motionEvent.getActionIndex() : -1;
        if (z) {
            float f = 0.0f;
            int pointerCount = motionEvent.getPointerCount();
            int i = 0;
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (i2 != actionIndex) {
                    f += motionEvent.getY(i2);
                    i++;
                }
            }
            return f / ((float) i);
        }
        int pointerCount2 = motionEvent.getPointerCount() - 1;
        if (pointerCount2 == actionIndex) {
            pointerCount2--;
        }
        return motionEvent.getY(pointerCount2);
    }
}
