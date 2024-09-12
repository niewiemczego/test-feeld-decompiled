package io.sentry.android.core.internal.util;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FirstDrawDoneListener$$ExternalSyntheticLambda0 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ FirstDrawDoneListener f$0;
    public final /* synthetic */ View f$1;

    public /* synthetic */ FirstDrawDoneListener$$ExternalSyntheticLambda0(FirstDrawDoneListener firstDrawDoneListener, View view) {
        this.f$0 = firstDrawDoneListener;
        this.f$1 = view;
    }

    public final void onGlobalLayout() {
        this.f$0.m911lambda$onDraw$1$iosentryandroidcoreinternalutilFirstDrawDoneListener(this.f$1);
    }
}
