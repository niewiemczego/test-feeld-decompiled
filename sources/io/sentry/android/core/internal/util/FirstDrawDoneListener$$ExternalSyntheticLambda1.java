package io.sentry.android.core.internal.util;

import android.view.Window;
import io.sentry.android.core.BuildInfoProvider;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FirstDrawDoneListener$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ Window f$0;
    public final /* synthetic */ Window.Callback f$1;
    public final /* synthetic */ Runnable f$2;
    public final /* synthetic */ BuildInfoProvider f$3;

    public /* synthetic */ FirstDrawDoneListener$$ExternalSyntheticLambda1(Window window, Window.Callback callback, Runnable runnable, BuildInfoProvider buildInfoProvider) {
        this.f$0 = window;
        this.f$1 = callback;
        this.f$2 = runnable;
        this.f$3 = buildInfoProvider;
    }

    public final void run() {
        FirstDrawDoneListener.lambda$registerForNextDraw$0(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
