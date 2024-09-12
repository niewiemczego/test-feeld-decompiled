package com.facebook.react.views.image;

import android.graphics.Shader;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;

public class ImageResizeMode {
    private static final String RESIZE_MODE_CENTER = "center";
    private static final String RESIZE_MODE_CONTAIN = "contain";
    private static final String RESIZE_MODE_COVER = "cover";
    private static final String RESIZE_MODE_REPEAT = "repeat";
    private static final String RESIZE_MODE_STRETCH = "stretch";

    public static ScalingUtils.ScaleType toScaleType(String str) {
        if (RESIZE_MODE_CONTAIN.equals(str)) {
            return ScalingUtils.ScaleType.FIT_CENTER;
        }
        if (RESIZE_MODE_COVER.equals(str)) {
            return ScalingUtils.ScaleType.CENTER_CROP;
        }
        if (RESIZE_MODE_STRETCH.equals(str)) {
            return ScalingUtils.ScaleType.FIT_XY;
        }
        if ("center".equals(str)) {
            return ScalingUtils.ScaleType.CENTER_INSIDE;
        }
        if (RESIZE_MODE_REPEAT.equals(str)) {
            return ScaleTypeStartInside.INSTANCE;
        }
        if (str == null) {
            return defaultValue();
        }
        throw new JSApplicationIllegalArgumentException("Invalid resize mode: '" + str + "'");
    }

    public static Shader.TileMode toTileMode(String str) {
        if (RESIZE_MODE_CONTAIN.equals(str) || RESIZE_MODE_COVER.equals(str) || RESIZE_MODE_STRETCH.equals(str) || "center".equals(str)) {
            return Shader.TileMode.CLAMP;
        }
        if (RESIZE_MODE_REPEAT.equals(str)) {
            return Shader.TileMode.REPEAT;
        }
        if (str == null) {
            return defaultTileMode();
        }
        throw new JSApplicationIllegalArgumentException("Invalid resize mode: '" + str + "'");
    }

    public static ScalingUtils.ScaleType defaultValue() {
        return ScalingUtils.ScaleType.CENTER_CROP;
    }

    public static Shader.TileMode defaultTileMode() {
        return Shader.TileMode.CLAMP;
    }
}
