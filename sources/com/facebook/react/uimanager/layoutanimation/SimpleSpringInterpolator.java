package com.facebook.react.uimanager.layoutanimation;

import android.view.animation.Interpolator;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;

class SimpleSpringInterpolator implements Interpolator {
    private static final float FACTOR = 0.5f;
    public static final String PARAM_SPRING_DAMPING = "springDamping";
    private final float mSpringDamping;

    public static float getSpringDamping(ReadableMap readableMap) {
        if (readableMap.getType(PARAM_SPRING_DAMPING).equals(ReadableType.Number)) {
            return (float) readableMap.getDouble(PARAM_SPRING_DAMPING);
        }
        return 0.5f;
    }

    public SimpleSpringInterpolator() {
        this.mSpringDamping = 0.5f;
    }

    public SimpleSpringInterpolator(float f) {
        this.mSpringDamping = f;
    }

    public float getInterpolation(float f) {
        double pow = Math.pow(2.0d, (double) (-10.0f * f));
        float f2 = this.mSpringDamping;
        return (float) ((pow * Math.sin(((((double) (f - (f2 / 4.0f))) * 3.141592653589793d) * 2.0d) / ((double) f2))) + 1.0d);
    }
}
