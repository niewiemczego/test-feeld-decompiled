package com.swmansion.reanimated.keyboard;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WindowsInsetsManager$$ExternalSyntheticLambda2 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ WindowsInsetsManager f$0;

    public /* synthetic */ WindowsInsetsManager$$ExternalSyntheticLambda2(WindowsInsetsManager windowsInsetsManager) {
        this.f$0 = windowsInsetsManager;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return this.f$0.onApplyWindowInsetsListener(view, windowInsetsCompat);
    }
}
