package com.mkuczera;

import android.os.Vibrator;
import android.provider.Settings;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

public class RNReactNativeHapticFeedbackModule extends ReactContextBaseJavaModule {
    ReactApplicationContext reactContext;

    public String getName() {
        return "RNReactNativeHapticFeedback";
    }

    public RNReactNativeHapticFeedbackModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @ReactMethod
    public void trigger(String str, ReadableMap readableMap) {
        boolean z = readableMap.getBoolean("ignoreAndroidSystemSettings");
        int i = Settings.System.getInt(this.reactContext.getContentResolver(), "haptic_feedback_enabled", 0);
        if (z || i != 0) {
            Vibrator vibrator = (Vibrator) this.reactContext.getSystemService("vibrator");
            Vibrate vibration = VibrateFactory.getVibration(str);
            if (vibrator != null && vibration != null) {
                vibration.apply(vibrator);
            }
        }
    }
}
