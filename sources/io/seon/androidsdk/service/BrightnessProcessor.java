package io.seon.androidsdk.service;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import io.seon.androidsdk.logger.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class BrightnessProcessor {
    private static final float A = 0.17883277f;
    private static final float B = 0.28466892f;
    private static final float C = 0.5599107f;
    private static int GAMMA_SPACE_MAX = 0;
    private static final int GAMMA_SPACE_MIN = 0;
    private static final float R = 0.5f;

    public BrightnessProcessor() {
        GAMMA_SPACE_MAX = Build.VERSION.SDK_INT < 30 ? AnalyticsListener.EVENT_DRM_KEYS_LOADED : 65535;
    }

    private int convertLinearToGammaFloat(float f, float f2, float f3) {
        float norm = MathUtils.norm(f2, f3, f) * 12.0f;
        return Math.round(MathUtils.lerp(0.0f, (float) GAMMA_SPACE_MAX, norm <= 1.0f ? MathUtils.sqrt(norm) * 0.5f : (MathUtils.log(norm - B) * A) + C));
    }

    private double getPercentage(double d) {
        int i = GAMMA_SPACE_MAX;
        if (d > ((double) i)) {
            return 1.0d;
        }
        double d2 = (double) 0;
        if (d < d2) {
            return 0.0d;
        }
        return (d - d2) / ((double) (i - 0));
    }

    public double convertBrightnessValue(float f, float f2, float f3) {
        return getPercentage((double) ((float) convertLinearToGammaFloat(f, f2, f3)));
    }

    public float getMaxScreenBrightness(Context context, Logger logger) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return 255.0f;
        }
        Method[] declaredMethods = powerManager.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i = 0;
        int i2 = 0;
        while (i2 < length) {
            Method method = declaredMethods[i2];
            if (method.getName().equals("getMaximumScreenBrightnessSetting")) {
                method.setAccessible(true);
                try {
                    return (float) ((Integer) method.invoke(powerManager, new Object[0])).intValue();
                } catch (Exception e) {
                    logger.withCause(e);
                }
            } else {
                i2++;
            }
        }
        Field[] declaredFields = powerManager.getClass().getDeclaredFields();
        int length2 = declaredFields.length;
        while (i < length2) {
            Field field = declaredFields[i];
            if (field.getName().equals("BRIGHTNESS_ON")) {
                field.setAccessible(true);
                try {
                    return field.getFloat(powerManager);
                } catch (IllegalAccessException e2) {
                    logger.withCause(e2);
                }
            } else {
                i++;
            }
        }
        return 255.0f;
    }
}
