package com.mkuczera;

import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

public class VibrateWithCreatePredefined implements Vibrate {
    int hapticConstant;

    VibrateWithCreatePredefined(int i) {
        this.hapticConstant = i;
    }

    public void apply(Vibrator vibrator) {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                if (vibrator.hasVibrator()) {
                    vibrator.vibrate(VibrationEffect.createPredefined(this.hapticConstant));
                }
            } catch (Exception unused) {
            }
        }
    }
}
