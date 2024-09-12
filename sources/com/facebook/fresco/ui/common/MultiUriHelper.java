package com.facebook.fresco.ui.common;

import android.net.Uri;
import com.facebook.common.internal.Fn;
import javax.annotation.Nullable;

public abstract class MultiUriHelper {
    @Nullable
    public static <T> Uri getMainUri(@Nullable T t, @Nullable T t2, @Nullable T[] tArr, Fn<T, Uri> fn) {
        T t3;
        Uri apply;
        Uri apply2;
        if (t != null && (apply2 = fn.apply(t)) != null) {
            return apply2;
        }
        if (tArr != null && tArr.length > 0 && (t3 = tArr[0]) != null && (apply = fn.apply(t3)) != null) {
            return apply;
        }
        if (t2 != null) {
            return fn.apply(t2);
        }
        return null;
    }
}
