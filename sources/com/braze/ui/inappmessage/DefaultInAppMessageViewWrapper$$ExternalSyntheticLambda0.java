package com.braze.ui.inappmessage;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultInAppMessageViewWrapper$$ExternalSyntheticLambda0 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ View f$0;
    public final /* synthetic */ DefaultInAppMessageViewWrapper f$1;

    public /* synthetic */ DefaultInAppMessageViewWrapper$$ExternalSyntheticLambda0(View view, DefaultInAppMessageViewWrapper defaultInAppMessageViewWrapper) {
        this.f$0 = view;
        this.f$1 = defaultInAppMessageViewWrapper;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return DefaultInAppMessageViewWrapper.addInAppMessageViewToViewGroup$lambda$0(this.f$0, this.f$1, view, windowInsetsCompat);
    }
}
