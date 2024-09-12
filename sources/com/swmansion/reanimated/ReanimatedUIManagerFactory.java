package com.swmansion.reanimated;

import android.os.Build;
import android.util.Log;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ReanimatedUIImplementation;
import com.facebook.react.uimanager.ReanimatedUIManager;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import java.lang.reflect.Field;
import java.util.List;

public class ReanimatedUIManagerFactory {
    static UIManagerModule create(ReactApplicationContext reactApplicationContext, List<ViewManager> list, int i) {
        ViewManagerRegistry viewManagerRegistry = new ViewManagerRegistry(list);
        ReanimatedUIManager reanimatedUIManager = new ReanimatedUIManager(reactApplicationContext, list, i);
        ReanimatedUIImplementation reanimatedUIImplementation = new ReanimatedUIImplementation(reactApplicationContext, viewManagerRegistry, reanimatedUIManager.getEventDispatcher(), i);
        Class<? super Object> superclass = reanimatedUIManager.getClass().getSuperclass();
        if (superclass == null) {
            Log.e("reanimated", "unable to resolve super class of ReanimatedUIManager");
            return reanimatedUIManager;
        }
        try {
            Field declaredField = superclass.getDeclaredField("mUIImplementation");
            declaredField.setAccessible(true);
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    Field declaredField2 = Field.class.getDeclaredField("accessFlags");
                    declaredField2.setAccessible(true);
                    declaredField2.setInt(declaredField, declaredField.getModifiers() & -17);
                } catch (IllegalAccessException | NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
            declaredField.set(reanimatedUIManager, reanimatedUIImplementation);
        } catch (IllegalAccessException | NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        return reanimatedUIManager;
    }
}
