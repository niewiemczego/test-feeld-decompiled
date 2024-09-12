package io.seon.androidsdk.service;

public class MathUtils {
    public static float lerp(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    public static float log(float f) {
        return (float) Math.log((double) f);
    }

    public static float norm(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    public static float sqrt(float f) {
        return (float) Math.sqrt((double) f);
    }
}
