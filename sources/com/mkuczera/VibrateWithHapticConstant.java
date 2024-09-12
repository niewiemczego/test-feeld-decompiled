package com.mkuczera;

import android.os.Vibrator;

public class VibrateWithHapticConstant implements Vibrate {
    int hapticConstant;

    public VibrateWithHapticConstant(int i) {
        this.hapticConstant = i;
    }

    public void apply(Vibrator vibrator) {
        try {
            if (vibrator.hasVibrator()) {
                vibrator.vibrate((long) this.hapticConstant);
            }
        } catch (Exception unused) {
        }
    }
}
