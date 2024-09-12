package com.braze.ui.inappmessage;

import android.view.animation.Animation;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/braze/ui/inappmessage/DefaultInAppMessageViewWrapper$createAnimationListener$2", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DefaultInAppMessageViewWrapper.kt */
public final class DefaultInAppMessageViewWrapper$createAnimationListener$2 implements Animation.AnimationListener {
    final /* synthetic */ DefaultInAppMessageViewWrapper this$0;

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }

    DefaultInAppMessageViewWrapper$createAnimationListener$2(DefaultInAppMessageViewWrapper defaultInAppMessageViewWrapper) {
        this.this$0 = defaultInAppMessageViewWrapper;
    }

    public void onAnimationEnd(Animation animation) {
        this.this$0.getInAppMessageView().clearAnimation();
        this.this$0.getInAppMessageView().setVisibility(8);
        this.this$0.closeInAppMessageView();
    }
}
