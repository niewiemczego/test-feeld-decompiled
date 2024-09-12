package com.braze.ui.inappmessage.listeners;

import android.animation.ValueAnimator;
import android.view.ViewGroup;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SwipeDismissTouchListener$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ SwipeDismissTouchListener f$0;
    public final /* synthetic */ ViewGroup.LayoutParams f$1;

    public /* synthetic */ SwipeDismissTouchListener$$ExternalSyntheticLambda0(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams) {
        this.f$0 = swipeDismissTouchListener;
        this.f$1 = layoutParams;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.m181lambda$performDismiss$0$combrazeuiinappmessagelistenersSwipeDismissTouchListener(this.f$1, valueAnimator);
    }
}
