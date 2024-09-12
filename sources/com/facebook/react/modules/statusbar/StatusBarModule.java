package com.facebook.react.modules.statusbar;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import androidx.core.view.ViewCompat;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeStatusBarManagerAndroidSpec;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import java.util.Map;

@ReactModule(name = "StatusBarManager")
public class StatusBarModule extends NativeStatusBarManagerAndroidSpec {
    private static final String DEFAULT_BACKGROUND_COLOR_KEY = "DEFAULT_BACKGROUND_COLOR";
    private static final String HEIGHT_KEY = "HEIGHT";
    public static final String NAME = "StatusBarManager";

    public String getName() {
        return NAME;
    }

    public StatusBarModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public Map<String, Object> getTypedExportedConstants() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Activity currentActivity = getCurrentActivity();
        int identifier = reactApplicationContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return MapBuilder.of(HEIGHT_KEY, Float.valueOf(identifier > 0 ? PixelUtil.toDIPFromPixel((float) reactApplicationContext.getResources().getDimensionPixelSize(identifier)) : 0.0f), DEFAULT_BACKGROUND_COLOR_KEY, currentActivity != null ? String.format("#%06X", new Object[]{Integer.valueOf(currentActivity.getWindow().getStatusBarColor() & ViewCompat.MEASURED_SIZE_MASK)}) : "black");
    }

    public void setColor(double d, boolean z) {
        final int i = (int) d;
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.w(ReactConstants.TAG, "StatusBarModule: Ignored status bar change, current activity is null.");
            return;
        }
        final boolean z2 = z;
        UiThreadUtil.runOnUiThread(new GuardedRunnable(getReactApplicationContext()) {
            public void runGuarded() {
                currentActivity.getWindow().addFlags(Integer.MIN_VALUE);
                if (z2) {
                    int statusBarColor = currentActivity.getWindow().getStatusBarColor();
                    ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(statusBarColor), Integer.valueOf(i)});
                    ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            currentActivity.getWindow().setStatusBarColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofObject.setDuration(300).setStartDelay(0);
                    ofObject.start();
                    return;
                }
                currentActivity.getWindow().setStatusBarColor(i);
            }
        });
    }

    public void setTranslucent(final boolean z) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.w(ReactConstants.TAG, "StatusBarModule: Ignored status bar change, current activity is null.");
        } else {
            UiThreadUtil.runOnUiThread(new GuardedRunnable(getReactApplicationContext()) {
                public void runGuarded() {
                    View decorView = currentActivity.getWindow().getDecorView();
                    if (z) {
                        decorView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
                                return onApplyWindowInsets.replaceSystemWindowInsets(onApplyWindowInsets.getSystemWindowInsetLeft(), 0, onApplyWindowInsets.getSystemWindowInsetRight(), onApplyWindowInsets.getSystemWindowInsetBottom());
                            }
                        });
                    } else {
                        decorView.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) null);
                    }
                    ViewCompat.requestApplyInsets(decorView);
                }
            });
        }
    }

    public void setHidden(final boolean z) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.w(ReactConstants.TAG, "StatusBarModule: Ignored status bar change, current activity is null.");
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    if (z) {
                        currentActivity.getWindow().addFlags(1024);
                        currentActivity.getWindow().clearFlags(2048);
                        return;
                    }
                    currentActivity.getWindow().addFlags(2048);
                    currentActivity.getWindow().clearFlags(1024);
                }
            });
        }
    }

    public void setStyle(final String str) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.w(ReactConstants.TAG, "StatusBarModule: Ignored status bar change, current activity is null.");
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    if (Build.VERSION.SDK_INT > 30) {
                        WindowInsetsController insetsController = currentActivity.getWindow().getInsetsController();
                        if ("dark-content".equals(str)) {
                            insetsController.setSystemBarsAppearance(8, 8);
                        } else {
                            insetsController.setSystemBarsAppearance(0, 8);
                        }
                    } else if (Build.VERSION.SDK_INT >= 23) {
                        View decorView = currentActivity.getWindow().getDecorView();
                        int systemUiVisibility = decorView.getSystemUiVisibility();
                        decorView.setSystemUiVisibility("dark-content".equals(str) ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
                    }
                }
            });
        }
    }
}
