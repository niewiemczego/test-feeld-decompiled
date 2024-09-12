package io.sentry.android.core.performance;

import android.view.Window;
import io.sentry.android.core.internal.gestures.WindowCallbackAdapter;

public class WindowContentChangedCallback extends WindowCallbackAdapter {
    private final Runnable callback;

    public WindowContentChangedCallback(Window.Callback callback2, Runnable runnable) {
        super(callback2);
        this.callback = runnable;
    }

    public void onContentChanged() {
        super.onContentChanged();
        this.callback.run();
    }
}
