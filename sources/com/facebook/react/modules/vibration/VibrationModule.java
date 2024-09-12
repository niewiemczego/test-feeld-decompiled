package com.facebook.react.modules.vibration;

import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.facebook.fbreact.specs.NativeVibrationSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "Vibration")
public class VibrationModule extends NativeVibrationSpec {
    public static final String NAME = "Vibration";

    public String getName() {
        return NAME;
    }

    public VibrationModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public void vibrate(double d) {
        int i = (int) d;
        Vibrator vibrator = (Vibrator) getReactApplicationContext().getSystemService("vibrator");
        if (vibrator != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(VibrationEffect.createOneShot((long) i, -1));
            } else {
                vibrator.vibrate((long) i);
            }
        }
    }

    public void vibrateByPattern(ReadableArray readableArray, double d) {
        int i = (int) d;
        Vibrator vibrator = (Vibrator) getReactApplicationContext().getSystemService("vibrator");
        if (vibrator != null) {
            long[] jArr = new long[readableArray.size()];
            for (int i2 = 0; i2 < readableArray.size(); i2++) {
                jArr[i2] = (long) readableArray.getInt(i2);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(VibrationEffect.createWaveform(jArr, i));
            } else {
                vibrator.vibrate(jArr, i);
            }
        }
    }

    public void cancel() {
        Vibrator vibrator = (Vibrator) getReactApplicationContext().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.cancel();
        }
    }
}
