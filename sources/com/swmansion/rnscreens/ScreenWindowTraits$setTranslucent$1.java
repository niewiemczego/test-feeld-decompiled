package com.swmansion.rnscreens;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017¨\u0006\u0004"}, d2 = {"com/swmansion/rnscreens/ScreenWindowTraits$setTranslucent$1", "Lcom/facebook/react/bridge/GuardedRunnable;", "runGuarded", "", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ScreenWindowTraits.kt */
public final class ScreenWindowTraits$setTranslucent$1 extends GuardedRunnable {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ boolean $translucent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScreenWindowTraits$setTranslucent$1(ReactContext reactContext, Activity activity, boolean z) {
        super(reactContext);
        this.$activity = activity;
        this.$translucent = z;
    }

    public void runGuarded() {
        View decorView = this.$activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        if (this.$translucent) {
            ViewCompat.setOnApplyWindowInsetsListener(decorView, new ScreenWindowTraits$setTranslucent$1$$ExternalSyntheticLambda0());
        } else {
            ViewCompat.setOnApplyWindowInsetsListener(decorView, (OnApplyWindowInsetsListener) null);
        }
        ViewCompat.requestApplyInsets(decorView);
    }

    /* access modifiers changed from: private */
    /* renamed from: runGuarded$lambda-0  reason: not valid java name */
    public static final WindowInsetsCompat m659runGuarded$lambda0(View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(view, "v");
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "insets");
        WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
        Intrinsics.checkNotNullExpressionValue(onApplyWindowInsets, "onApplyWindowInsets(v, insets)");
        if (Build.VERSION.SDK_INT < 30) {
            return onApplyWindowInsets.replaceSystemWindowInsets(onApplyWindowInsets.getSystemWindowInsetLeft(), 0, onApplyWindowInsets.getSystemWindowInsetRight(), onApplyWindowInsets.getSystemWindowInsetBottom());
        }
        Insets insets = onApplyWindowInsets.getInsets(WindowInsetsCompat.Type.statusBars());
        Intrinsics.checkNotNullExpressionValue(insets, "defaultInsets.getInsets(…Compat.Type.statusBars())");
        return new WindowInsetsCompat.Builder().setInsets(WindowInsetsCompat.Type.statusBars(), Insets.of(insets.left, 0, insets.right, insets.bottom)).build();
    }
}
