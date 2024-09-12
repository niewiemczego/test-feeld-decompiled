package com.swmansion.reanimated;

import android.view.View;
import com.facebook.react.views.scroll.ReactHorizontalScrollView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NativeMethodsHelper$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ View f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ NativeMethodsHelper$$ExternalSyntheticLambda0(View view, int i, int i2) {
        this.f$0 = view;
        this.f$1 = i;
        this.f$2 = i2;
    }

    public final void run() {
        ((ReactHorizontalScrollView) this.f$0).smoothScrollTo(this.f$1, this.f$2);
    }
}
