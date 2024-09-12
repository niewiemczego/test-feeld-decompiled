package com.mkuczera;

import java.util.HashMap;
import java.util.Map;

public class VibrateFactory {
    static Map<String, Vibrate> vibrateMap;

    static {
        HashMap hashMap = new HashMap();
        vibrateMap = hashMap;
        hashMap.put("impactLight", new VibrateWithDuration(new long[]{0, 20}));
        vibrateMap.put("impactMedium", new VibrateWithDuration(new long[]{0, 40}));
        vibrateMap.put("impactHeavy", new VibrateWithDuration(new long[]{0, 60}));
        vibrateMap.put("notificationSuccess", new VibrateWithDuration(new long[]{0, 40, 60, 20}));
        vibrateMap.put("notificationWarning", new VibrateWithDuration(new long[]{0, 20, 60, 40}));
        vibrateMap.put("notificationError", new VibrateWithDuration(new long[]{0, 20, 40, 30, 40, 40}));
        vibrateMap.put("rigid", new VibrateWithDuration(new long[]{0, 30}));
        vibrateMap.put("soft", new VibrateWithDuration(new long[]{0, 10}));
        vibrateMap.put("clockTick", new VibrateWithHapticConstant(4));
        vibrateMap.put("contextClick", new VibrateWithHapticConstant(6));
        vibrateMap.put("keyboardPress", new VibrateWithHapticConstant(3));
        vibrateMap.put("keyboardRelease", new VibrateWithHapticConstant(7));
        vibrateMap.put("keyboardTap", new VibrateWithHapticConstant(3));
        vibrateMap.put("longPress", new VibrateWithHapticConstant(0));
        vibrateMap.put("textHandleMove", new VibrateWithHapticConstant(9));
        vibrateMap.put("virtualKey", new VibrateWithHapticConstant(1));
        vibrateMap.put("virtualKeyRelease", new VibrateWithHapticConstant(8));
        vibrateMap.put("effectClick", new VibrateWithCreatePredefined(0));
        vibrateMap.put("effectDoubleClick", new VibrateWithCreatePredefined(1));
        vibrateMap.put("effectHeavyClick", new VibrateWithCreatePredefined(5));
        vibrateMap.put("effectTick", new VibrateWithCreatePredefined(2));
    }

    public static Vibrate getVibration(String str) {
        return vibrateMap.get(str);
    }
}
