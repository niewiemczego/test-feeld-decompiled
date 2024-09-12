package com.swmansion.reanimated.keyboard;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.R;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.bridge.ReactApplicationContext;
import java.lang.ref.WeakReference;

public class WindowsInsetsManager {
    private boolean mIsStatusBarTranslucent = false;
    private final Keyboard mKeyboard;
    private final NotifyAboutKeyboardChangeFunction mNotifyAboutKeyboardChange;
    private final WeakReference<ReactApplicationContext> mReactContext;

    public WindowsInsetsManager(WeakReference<ReactApplicationContext> weakReference, Keyboard keyboard, NotifyAboutKeyboardChangeFunction notifyAboutKeyboardChangeFunction) {
        this.mReactContext = weakReference;
        this.mKeyboard = keyboard;
        this.mNotifyAboutKeyboardChange = notifyAboutKeyboardChangeFunction;
    }

    private Window getWindow() {
        return ((ReactApplicationContext) this.mReactContext.get()).getCurrentActivity().getWindow();
    }

    private View getRootView() {
        return getWindow().getDecorView();
    }

    public void startObservingChanges(KeyboardAnimationCallback keyboardAnimationCallback, boolean z) {
        this.mIsStatusBarTranslucent = z;
        updateWindowDecor(false);
        ViewCompat.setOnApplyWindowInsetsListener(getRootView(), new WindowsInsetsManager$$ExternalSyntheticLambda2(this));
        ViewCompat.setWindowInsetsAnimationCallback(getRootView(), keyboardAnimationCallback);
    }

    public void stopObservingChanges() {
        updateWindowDecor(!this.mIsStatusBarTranslucent);
        updateInsets(0, 0);
        View rootView = getRootView();
        ViewCompat.setWindowInsetsAnimationCallback(rootView, (WindowInsetsAnimationCompat.Callback) null);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (OnApplyWindowInsetsListener) null);
    }

    private void updateWindowDecor(boolean z) {
        new Handler(Looper.getMainLooper()).post(new WindowsInsetsManager$$ExternalSyntheticLambda1(this, z));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$updateWindowDecor$0$com-swmansion-reanimated-keyboard-WindowsInsetsManager  reason: not valid java name */
    public /* synthetic */ void m643lambda$updateWindowDecor$0$comswmansionreanimatedkeyboardWindowsInsetsManager(boolean z) {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), z);
    }

    /* access modifiers changed from: private */
    public WindowInsetsCompat onApplyWindowInsetsListener(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat onApplyWindowInsets = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
        if (this.mKeyboard.getState() == KeyboardState.OPEN) {
            this.mKeyboard.updateHeight(windowInsetsCompat);
            this.mNotifyAboutKeyboardChange.call();
        }
        setWindowInsets(onApplyWindowInsets);
        return onApplyWindowInsets;
    }

    private void setWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        int systemBars = WindowInsetsCompat.Type.systemBars();
        updateInsets(windowInsetsCompat.getInsets(systemBars).top, windowInsetsCompat.getInsets(systemBars).bottom);
    }

    private void updateInsets(int i, int i2) {
        new Handler(Looper.getMainLooper()).post(new WindowsInsetsManager$$ExternalSyntheticLambda0(this, i, i2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$updateInsets$1$com-swmansion-reanimated-keyboard-WindowsInsetsManager  reason: not valid java name */
    public /* synthetic */ void m642lambda$updateInsets$1$comswmansionreanimatedkeyboardWindowsInsetsManager(int i, int i2) {
        getRootView().findViewById(R.id.action_bar_root).setLayoutParams(getLayoutParams(i, i2));
    }

    private FrameLayout.LayoutParams getLayoutParams(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (this.mIsStatusBarTranslucent) {
            layoutParams.setMargins(0, 0, 0, i2);
        } else {
            layoutParams.setMargins(0, i, 0, i2);
        }
        return layoutParams;
    }
}
