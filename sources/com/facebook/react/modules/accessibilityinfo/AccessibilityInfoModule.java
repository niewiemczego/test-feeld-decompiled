package com.facebook.react.modules.accessibilityinfo;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.facebook.fbreact.specs.NativeAccessibilityInfoSpec;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;

@ReactModule(name = "AccessibilityInfo")
public class AccessibilityInfoModule extends NativeAccessibilityInfoSpec implements LifecycleEventListener {
    private static final String ACCESSIBILITY_SERVICE_EVENT_NAME = "accessibilityServiceDidChange";
    public static final String NAME = "AccessibilityInfo";
    private static final String REDUCE_MOTION_EVENT_NAME = "reduceMotionDidChange";
    private static final String TOUCH_EXPLORATION_EVENT_NAME = "touchExplorationDidChange";
    private final ContentObserver animationScaleObserver = new ContentObserver(new Handler(Looper.getMainLooper())) {
        public void onChange(boolean z) {
            onChange(z, (Uri) null);
        }

        public void onChange(boolean z, Uri uri) {
            if (AccessibilityInfoModule.this.getReactApplicationContext().hasActiveReactInstance()) {
                AccessibilityInfoModule.this.updateAndSendReduceMotionChangeEvent();
            }
        }
    };
    private AccessibilityManager mAccessibilityManager;
    private ReactAccessibilityServiceChangeListener mAccessibilityServiceChangeListener;
    private boolean mAccessibilityServiceEnabled = false;
    private final ContentResolver mContentResolver;
    private int mRecommendedTimeout;
    private boolean mReduceMotionEnabled = false;
    private boolean mTouchExplorationEnabled = false;
    private ReactTouchExplorationStateChangeListener mTouchExplorationStateChangeListener;

    public String getName() {
        return NAME;
    }

    public void onHostDestroy() {
    }

    public void setAccessibilityFocus(double d) {
    }

    private class ReactTouchExplorationStateChangeListener implements AccessibilityManager.TouchExplorationStateChangeListener {
        private ReactTouchExplorationStateChangeListener() {
        }

        public void onTouchExplorationStateChanged(boolean z) {
            AccessibilityInfoModule.this.updateAndSendTouchExplorationChangeEvent(z);
        }
    }

    private class ReactAccessibilityServiceChangeListener implements AccessibilityManager.AccessibilityStateChangeListener {
        private ReactAccessibilityServiceChangeListener() {
        }

        public void onAccessibilityStateChanged(boolean z) {
            AccessibilityInfoModule.this.updateAndSendAccessibilityServiceChangeEvent(z);
        }
    }

    public AccessibilityInfoModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mAccessibilityManager = (AccessibilityManager) reactApplicationContext.getApplicationContext().getSystemService("accessibility");
        this.mContentResolver = getReactApplicationContext().getContentResolver();
        this.mTouchExplorationEnabled = this.mAccessibilityManager.isTouchExplorationEnabled();
        this.mAccessibilityServiceEnabled = this.mAccessibilityManager.isEnabled();
        this.mReduceMotionEnabled = getIsReduceMotionEnabledValue();
        this.mTouchExplorationStateChangeListener = new ReactTouchExplorationStateChangeListener();
        this.mAccessibilityServiceChangeListener = new ReactAccessibilityServiceChangeListener();
    }

    private boolean getIsReduceMotionEnabledValue() {
        String string = Settings.Global.getString(this.mContentResolver, "transition_animation_scale");
        return string != null && string.equals("0.0");
    }

    public void isReduceMotionEnabled(Callback callback) {
        callback.invoke(Boolean.valueOf(this.mReduceMotionEnabled));
    }

    public void isTouchExplorationEnabled(Callback callback) {
        callback.invoke(Boolean.valueOf(this.mTouchExplorationEnabled));
    }

    public void isAccessibilityServiceEnabled(Callback callback) {
        callback.invoke(Boolean.valueOf(this.mAccessibilityServiceEnabled));
    }

    /* access modifiers changed from: private */
    public void updateAndSendReduceMotionChangeEvent() {
        boolean isReduceMotionEnabledValue = getIsReduceMotionEnabledValue();
        if (this.mReduceMotionEnabled != isReduceMotionEnabledValue) {
            this.mReduceMotionEnabled = isReduceMotionEnabledValue;
            ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
            if (reactApplicationContextIfActiveOrWarn != null) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContextIfActiveOrWarn.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(REDUCE_MOTION_EVENT_NAME, Boolean.valueOf(this.mReduceMotionEnabled));
            }
        }
    }

    /* access modifiers changed from: private */
    public void updateAndSendTouchExplorationChangeEvent(boolean z) {
        if (this.mTouchExplorationEnabled != z) {
            this.mTouchExplorationEnabled = z;
            if (getReactApplicationContextIfActiveOrWarn() != null) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(TOUCH_EXPLORATION_EVENT_NAME, Boolean.valueOf(this.mTouchExplorationEnabled));
            }
        }
    }

    /* access modifiers changed from: private */
    public void updateAndSendAccessibilityServiceChangeEvent(boolean z) {
        if (this.mAccessibilityServiceEnabled != z) {
            this.mAccessibilityServiceEnabled = z;
            if (getReactApplicationContextIfActiveOrWarn() != null) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ACCESSIBILITY_SERVICE_EVENT_NAME, Boolean.valueOf(this.mAccessibilityServiceEnabled));
            }
        }
    }

    public void onHostResume() {
        this.mAccessibilityManager.addTouchExplorationStateChangeListener(this.mTouchExplorationStateChangeListener);
        this.mAccessibilityManager.addAccessibilityStateChangeListener(this.mAccessibilityServiceChangeListener);
        this.mContentResolver.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, this.animationScaleObserver);
        updateAndSendTouchExplorationChangeEvent(this.mAccessibilityManager.isTouchExplorationEnabled());
        updateAndSendAccessibilityServiceChangeEvent(this.mAccessibilityManager.isEnabled());
        updateAndSendReduceMotionChangeEvent();
    }

    public void onHostPause() {
        this.mAccessibilityManager.removeTouchExplorationStateChangeListener(this.mTouchExplorationStateChangeListener);
        this.mAccessibilityManager.removeAccessibilityStateChangeListener(this.mAccessibilityServiceChangeListener);
        this.mContentResolver.unregisterContentObserver(this.animationScaleObserver);
    }

    public void initialize() {
        getReactApplicationContext().addLifecycleEventListener(this);
        updateAndSendTouchExplorationChangeEvent(this.mAccessibilityManager.isTouchExplorationEnabled());
        updateAndSendAccessibilityServiceChangeEvent(this.mAccessibilityManager.isEnabled());
        updateAndSendReduceMotionChangeEvent();
    }

    public void invalidate() {
        super.invalidate();
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            reactApplicationContextIfActiveOrWarn.removeLifecycleEventListener(this);
        }
    }

    public void announceForAccessibility(String str) {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(16384);
            obtain.getText().add(str);
            obtain.setClassName(AccessibilityInfoModule.class.getName());
            obtain.setPackageName(getReactApplicationContext().getPackageName());
            this.mAccessibilityManager.sendAccessibilityEvent(obtain);
        }
    }

    public void getRecommendedTimeoutMillis(double d, Callback callback) {
        if (Build.VERSION.SDK_INT < 29) {
            callback.invoke(Integer.valueOf((int) d));
            return;
        }
        int recommendedTimeoutMillis = this.mAccessibilityManager.getRecommendedTimeoutMillis((int) d, 4);
        this.mRecommendedTimeout = recommendedTimeoutMillis;
        callback.invoke(Integer.valueOf(recommendedTimeoutMillis));
    }
}
