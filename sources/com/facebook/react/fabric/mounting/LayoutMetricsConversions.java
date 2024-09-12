package com.facebook.react.fabric.mounting;

import android.view.View;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.yoga.YogaMeasureMode;

public interface LayoutMetricsConversions {
    static float getMinSize(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return (float) size;
        }
        return 0.0f;
    }

    static float getMaxSize(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 0) {
            return Float.POSITIVE_INFINITY;
        }
        return (float) size;
    }

    static float getYogaSize(float f, float f2) {
        if (f == f2) {
            return PixelUtil.toPixelFromDIP(f2);
        }
        if (Float.isInfinite(f2)) {
            return Float.POSITIVE_INFINITY;
        }
        return PixelUtil.toPixelFromDIP(f2);
    }

    static YogaMeasureMode getYogaMeasureMode(float f, float f2) {
        if (f == f2) {
            return YogaMeasureMode.EXACTLY;
        }
        if (Float.isInfinite(f2)) {
            return YogaMeasureMode.UNDEFINED;
        }
        return YogaMeasureMode.AT_MOST;
    }
}
