package com.mkuczera;

import android.os.Vibrator;

public class VibrateWithDuration implements Vibrate {
    long[] durations;

    public VibrateWithDuration(long[] jArr) {
        this.durations = jArr;
    }

    public void apply(Vibrator vibrator) {
        try {
            if (vibrator.hasVibrator()) {
                vibrator.vibrate(this.durations, -1);
            }
        } catch (Exception unused) {
        }
    }
}
