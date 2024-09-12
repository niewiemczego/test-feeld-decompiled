package com.facebook.react.views.view;

import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

public class CanvasUtil {
    @Nullable
    private static Method mInorderBarrierMethod = null;
    private static boolean mOrderMethodsFetched = false;
    @Nullable
    private static Method mReorderBarrierMethod;

    private CanvasUtil() {
    }

    public static void enableZ(Canvas canvas, boolean z) {
        Method method;
        if (Build.VERSION.SDK_INT >= 21) {
            if (Build.VERSION.SDK_INT < 29) {
                fetchOrderMethods();
                if (z) {
                    try {
                        Method method2 = mReorderBarrierMethod;
                        if (method2 != null) {
                            method2.invoke(canvas, new Object[0]);
                        }
                    } catch (IllegalAccessException | InvocationTargetException unused) {
                        return;
                    }
                }
                if (!z && (method = mInorderBarrierMethod) != null) {
                    method.invoke(canvas, new Object[0]);
                }
            } else if (z) {
                canvas.enableZ();
            } else {
                canvas.disableZ();
            }
        }
    }

    private static void fetchOrderMethods() {
        if (!mOrderMethodsFetched) {
            try {
                if (Build.VERSION.SDK_INT == 28) {
                    Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class});
                    mReorderBarrierMethod = (Method) declaredMethod.invoke(Canvas.class, new Object[]{"insertReorderBarrier", new Class[0]});
                    mInorderBarrierMethod = (Method) declaredMethod.invoke(Canvas.class, new Object[]{"insertInorderBarrier", new Class[0]});
                } else {
                    mReorderBarrierMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                    mInorderBarrierMethod = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                }
                Method method = mReorderBarrierMethod;
                if (method == null) {
                    return;
                }
                if (mInorderBarrierMethod != null) {
                    method.setAccessible(true);
                    mInorderBarrierMethod.setAccessible(true);
                    mOrderMethodsFetched = true;
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
    }
}
