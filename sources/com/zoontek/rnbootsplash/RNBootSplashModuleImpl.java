package com.zoontek.rnbootsplash;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.window.SplashScreen;
import android.window.SplashScreenView;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.PixelUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class RNBootSplashModuleImpl {
    public static final String NAME = "RNBootSplash";
    /* access modifiers changed from: private */
    public static RNBootSplashDialog mFadeOutDialog = null;
    /* access modifiers changed from: private */
    public static RNBootSplashDialog mInitialDialog = null;
    private static final RNBootSplashQueue<Promise> mPromiseQueue = new RNBootSplashQueue<>();
    /* access modifiers changed from: private */
    public static Status mStatus = Status.HIDDEN;
    /* access modifiers changed from: private */
    public static int mThemeResId = -1;

    private enum Status {
        HIDDEN,
        HIDING,
        INITIALIZING,
        VISIBLE
    }

    protected static void init(final Activity activity, int i) {
        int i2;
        if (mThemeResId != -1) {
            FLog.w(ReactConstants.TAG, "RNBootSplash: Ignored initialization, module is already initialized.");
            return;
        }
        mThemeResId = i;
        if (activity == null) {
            FLog.w(ReactConstants.TAG, "RNBootSplash: Ignored initialization, current activity is null.");
            return;
        }
        TypedValue typedValue = new TypedValue();
        if (activity.getTheme().resolveAttribute(R.attr.postBootSplashTheme, typedValue, true) && (i2 = typedValue.resourceId) != 0) {
            activity.setTheme(i2);
        }
        final View findViewById = activity.findViewById(16908290);
        mStatus = Status.INITIALIZING;
        findViewById.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                if (RNBootSplashModuleImpl.mStatus == Status.INITIALIZING) {
                    return false;
                }
                findViewById.getViewTreeObserver().removeOnPreDrawListener(this);
                return true;
            }
        });
        if (Build.VERSION.SDK_INT >= 31) {
            activity.getSplashScreen().setOnExitAnimationListener(new SplashScreen.OnExitAnimationListener() {
                public void onSplashScreenExit(SplashScreenView splashScreenView) {
                    splashScreenView.remove();
                    activity.getSplashScreen().clearOnExitAnimationListener();
                }
            });
        }
        mInitialDialog = new RNBootSplashDialog(activity, mThemeResId, false);
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                RNBootSplashModuleImpl.mInitialDialog.show(new Runnable() {
                    public void run() {
                        Status unused = RNBootSplashModuleImpl.mStatus = Status.VISIBLE;
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public static void clearPromiseQueue() {
        while (true) {
            RNBootSplashQueue<Promise> rNBootSplashQueue = mPromiseQueue;
            if (!rNBootSplashQueue.isEmpty()) {
                Promise shift = rNBootSplashQueue.shift();
                if (shift != null) {
                    shift.resolve(true);
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public static void hideAndClearPromiseQueue(final ReactApplicationContext reactApplicationContext, final boolean z) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Activity currentActivity = ReactApplicationContext.this.getCurrentActivity();
                if (RNBootSplashModuleImpl.mStatus == Status.INITIALIZING || currentActivity == null || currentActivity.isFinishing() || currentActivity.isDestroyed()) {
                    final Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        public void run() {
                            timer.cancel();
                            RNBootSplashModuleImpl.hideAndClearPromiseQueue(ReactApplicationContext.this, z);
                        }
                    }, 100);
                } else if (RNBootSplashModuleImpl.mStatus != Status.HIDING) {
                    if (RNBootSplashModuleImpl.mInitialDialog == null || RNBootSplashModuleImpl.mStatus == Status.HIDDEN) {
                        RNBootSplashModuleImpl.clearPromiseQueue();
                        return;
                    }
                    Status unused = RNBootSplashModuleImpl.mStatus = Status.HIDING;
                    if (!z) {
                        RNBootSplashModuleImpl.mInitialDialog.dismiss(new Runnable() {
                            public void run() {
                                Status unused = RNBootSplashModuleImpl.mStatus = Status.HIDDEN;
                                RNBootSplashDialog unused2 = RNBootSplashModuleImpl.mInitialDialog = null;
                                RNBootSplashModuleImpl.clearPromiseQueue();
                            }
                        });
                        return;
                    }
                    RNBootSplashDialog unused2 = RNBootSplashModuleImpl.mFadeOutDialog = new RNBootSplashDialog(currentActivity, RNBootSplashModuleImpl.mThemeResId, true);
                    RNBootSplashModuleImpl.mFadeOutDialog.show(new Runnable() {
                        public void run() {
                            RNBootSplashModuleImpl.mInitialDialog.dismiss(new Runnable() {
                                public void run() {
                                    RNBootSplashModuleImpl.mFadeOutDialog.dismiss(new Runnable() {
                                        public void run() {
                                            Status unused = RNBootSplashModuleImpl.mStatus = Status.HIDDEN;
                                            RNBootSplashDialog unused2 = RNBootSplashModuleImpl.mInitialDialog = null;
                                            RNBootSplashDialog unused3 = RNBootSplashModuleImpl.mFadeOutDialog = null;
                                            RNBootSplashModuleImpl.clearPromiseQueue();
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    public static boolean isSamsungOneUI4() {
        try {
            if ((Build.VERSION.class.getDeclaredField("SEM_PLATFORM_INT").getInt((Object) null) - 90000) / 10000 == 4) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    protected static void onHostDestroy() {
        mStatus = Status.HIDDEN;
        mThemeResId = -1;
        clearPromiseQueue();
        RNBootSplashDialog rNBootSplashDialog = mInitialDialog;
        if (rNBootSplashDialog != null) {
            rNBootSplashDialog.dismiss();
            mInitialDialog = null;
        }
        RNBootSplashDialog rNBootSplashDialog2 = mFadeOutDialog;
        if (rNBootSplashDialog2 != null) {
            rNBootSplashDialog2.dismiss();
            mFadeOutDialog = null;
        }
    }

    public static Map<String, Object> getConstants(ReactApplicationContext reactApplicationContext) {
        Resources resources = reactApplicationContext.getResources();
        HashMap hashMap = new HashMap();
        int i = reactApplicationContext.getResources().getConfiguration().uiMode & 48;
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        int identifier2 = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        float f = 0.0f;
        float dIPFromPixel = identifier > 0 ? PixelUtil.toDIPFromPixel((float) resources.getDimensionPixelSize(identifier)) : 0.0f;
        if (identifier2 > 0 && !ViewConfiguration.get(reactApplicationContext).hasPermanentMenuKey()) {
            f = PixelUtil.toDIPFromPixel((float) resources.getDimensionPixelSize(identifier2));
        }
        hashMap.put("darkModeEnabled", Boolean.valueOf(i == 32));
        hashMap.put("logoSizeRatio", Double.valueOf(isSamsungOneUI4() ? 0.5d : 1.0d));
        hashMap.put("navigationBarHeight", Float.valueOf(f));
        hashMap.put("statusBarHeight", Float.valueOf(dIPFromPixel));
        return hashMap;
    }

    public static void hide(ReactApplicationContext reactApplicationContext, boolean z, Promise promise) {
        mPromiseQueue.push(promise);
        hideAndClearPromiseQueue(reactApplicationContext, z);
    }

    public static void isVisible(Promise promise) {
        promise.resolve(Boolean.valueOf(mStatus != Status.HIDDEN));
    }
}
