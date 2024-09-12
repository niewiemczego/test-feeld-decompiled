package com.facebook.fresco.middleware;

import android.graphics.PointF;
import android.graphics.Rect;
import android.net.Uri;
import com.facebook.fresco.ui.common.ControllerListener2;
import java.util.Map;
import javax.annotation.Nullable;

public class MiddlewareUtils {
    public static ControllerListener2.Extras obtainExtras(Map<String, Object> map, Map<String, Object> map2, @Nullable Map<String, Object> map3, @Nullable Rect rect, @Nullable String str, @Nullable PointF pointF, @Nullable Map<String, Object> map4, @Nullable Object obj, @Nullable Uri uri) {
        ControllerListener2.Extras extras = new ControllerListener2.Extras();
        if (rect != null) {
            extras.viewportWidth = rect.width();
            extras.viewportHeight = rect.height();
        }
        extras.scaleType = str;
        if (pointF != null) {
            extras.focusX = pointF.x;
            extras.focusY = pointF.y;
        }
        extras.callerContext = obj;
        extras.mainUri = uri;
        extras.datasourceExtras = map3;
        extras.imageExtras = map4;
        extras.shortcutExtras = map2;
        extras.componentExtras = map;
        return extras;
    }
}
