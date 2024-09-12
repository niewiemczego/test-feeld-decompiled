package com.google.firebase.concurrent;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public enum UiExecutor implements Executor {
    INSTANCE;
    
    private static final Handler HANDLER = null;

    static {
        HANDLER = new Handler(Looper.getMainLooper());
    }

    public void execute(Runnable runnable) {
        HANDLER.post(runnable);
    }
}
