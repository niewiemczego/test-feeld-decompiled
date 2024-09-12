package org.greenrobot.eventbus.android;

import java.lang.reflect.InvocationTargetException;

public class AndroidDependenciesDetector {
    private static final String ANDROID_COMPONENTS_IMPLEMENTATION_CLASS_NAME = "org.greenrobot.eventbus.android.AndroidComponentsImpl";

    public static boolean isAndroidSDKAvailable() {
        try {
            if (Class.forName("android.os.Looper").getDeclaredMethod("getMainLooper", new Class[0]).invoke((Object) null, new Object[0]) != null) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    public static boolean areAndroidComponentsAvailable() {
        try {
            Class.forName(ANDROID_COMPONENTS_IMPLEMENTATION_CLASS_NAME);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static AndroidComponents instantiateAndroidComponents() {
        try {
            return (AndroidComponents) Class.forName(ANDROID_COMPONENTS_IMPLEMENTATION_CLASS_NAME).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }
}
