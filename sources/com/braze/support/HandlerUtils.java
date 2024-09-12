package com.braze.support;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/braze/support/HandlerUtils;", "", "()V", "createHandler", "Landroid/os/Handler;", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HandlerUtils {
    public static final HandlerUtils INSTANCE = new HandlerUtils();

    private HandlerUtils() {
    }

    @JvmStatic
    public static final Handler createHandler() {
        return new Handler(Looper.getMainLooper());
    }
}
