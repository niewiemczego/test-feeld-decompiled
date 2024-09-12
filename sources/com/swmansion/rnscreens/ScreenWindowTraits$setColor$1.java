package com.swmansion.rnscreens;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.Window;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/swmansion/rnscreens/ScreenWindowTraits$setColor$1", "Lcom/facebook/react/bridge/GuardedRunnable;", "runGuarded", "", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ScreenWindowTraits.kt */
public final class ScreenWindowTraits$setColor$1 extends GuardedRunnable {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ boolean $animated;
    final /* synthetic */ Integer $color;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScreenWindowTraits$setColor$1(ReactContext reactContext, Activity activity, Integer num, boolean z) {
        super(reactContext);
        this.$activity = activity;
        this.$color = num;
        this.$animated = z;
    }

    public void runGuarded() {
        Window window = this.$activity.getWindow();
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(window.getStatusBarColor()), this.$color});
        ofObject.addUpdateListener(new ScreenWindowTraits$setColor$1$$ExternalSyntheticLambda0(window));
        if (this.$animated) {
            ofObject.setDuration(300).setStartDelay(0);
        } else {
            ofObject.setDuration(0).setStartDelay(300);
        }
        ofObject.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: runGuarded$lambda-0  reason: not valid java name */
    public static final void m658runGuarded$lambda0(Window window, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        window.setStatusBarColor(((Integer) animatedValue).intValue());
    }
}
