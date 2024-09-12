package com.facebook.react;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.modules.appregistry.AppRegistry;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.JSPointerDispatcher;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactClippingProhibitedView;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.ReactRootViewTagGenerator;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewUtil;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.systrace.Systrace;
import java.util.concurrent.atomic.AtomicInteger;

public class ReactRootView extends FrameLayout implements RootView, ReactRoot {
    private static final String TAG = "ReactRootView";
    private final ReactAndroidHWInputDeviceHelper mAndroidHWInputDeviceHelper = new ReactAndroidHWInputDeviceHelper(this);
    private Bundle mAppProperties;
    private CustomGlobalLayoutListener mCustomGlobalLayoutListener;
    private int mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
    private String mInitialUITemplate;
    /* access modifiers changed from: private */
    public boolean mIsAttachedToInstance;
    private String mJSModuleName;
    private JSPointerDispatcher mJSPointerDispatcher;
    private JSTouchDispatcher mJSTouchDispatcher;
    /* access modifiers changed from: private */
    public int mLastHeight = 0;
    private int mLastOffsetX = Integer.MIN_VALUE;
    private int mLastOffsetY = Integer.MIN_VALUE;
    private int mLastWidth = 0;
    /* access modifiers changed from: private */
    public ReactInstanceManager mReactInstanceManager;
    private ReactRootViewEventListener mRootViewEventListener;
    private int mRootViewTag = 0;
    private boolean mShouldLogContentAppeared;
    private final AtomicInteger mState = new AtomicInteger(0);
    private int mUIManagerType = 1;
    private boolean mWasMeasured = false;
    private int mWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);

    public interface ReactRootViewEventListener {
        void onAttachedToReactInstance(ReactRootView reactRootView);
    }

    public ViewGroup getRootViewGroup() {
        return this;
    }

    public boolean shouldDispatchJSTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public ReactRootView(Context context) {
        super(context);
        init();
    }

    public ReactRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ReactRootView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setRootViewTag(ReactRootViewTagGenerator.getNextRootViewTag());
        setClipChildren(false);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0026 A[Catch:{ all -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036 A[Catch:{ all -> 0x00b6 }, LOOP:0: B:15:0x0030->B:17:0x0036, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a A[Catch:{ all -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0069 A[Catch:{ all -> 0x00b6 }, LOOP:1: B:24:0x0063->B:26:0x0069, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0094 A[Catch:{ all -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0098 A[ADDED_TO_REGION, Catch:{ all -> 0x00b6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r11, int r12) {
        /*
            r10 = this;
            r0 = 0
            java.lang.String r2 = "ReactRootView.onMeasure"
            com.facebook.systrace.Systrace.beginSection(r0, r2)
            com.facebook.react.bridge.ReactMarkerConstants r2 = com.facebook.react.bridge.ReactMarkerConstants.ROOT_VIEW_ON_MEASURE_START
            com.facebook.react.bridge.ReactMarker.logMarker((com.facebook.react.bridge.ReactMarkerConstants) r2)
            int r2 = r10.mWidthMeasureSpec     // Catch:{ all -> 0x00b6 }
            r3 = 0
            r4 = 1
            if (r11 != r2) goto L_0x0019
            int r2 = r10.mHeightMeasureSpec     // Catch:{ all -> 0x00b6 }
            if (r12 == r2) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r2 = r3
            goto L_0x001a
        L_0x0019:
            r2 = r4
        L_0x001a:
            r10.mWidthMeasureSpec = r11     // Catch:{ all -> 0x00b6 }
            r10.mHeightMeasureSpec = r12     // Catch:{ all -> 0x00b6 }
            int r5 = android.view.View.MeasureSpec.getMode(r11)     // Catch:{ all -> 0x00b6 }
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x002e
            if (r5 != 0) goto L_0x0029
            goto L_0x002e
        L_0x0029:
            int r11 = android.view.View.MeasureSpec.getSize(r11)     // Catch:{ all -> 0x00b6 }
            goto L_0x0054
        L_0x002e:
            r11 = r3
            r5 = r11
        L_0x0030:
            int r7 = r10.getChildCount()     // Catch:{ all -> 0x00b6 }
            if (r5 >= r7) goto L_0x0054
            android.view.View r7 = r10.getChildAt(r5)     // Catch:{ all -> 0x00b6 }
            int r8 = r7.getLeft()     // Catch:{ all -> 0x00b6 }
            int r9 = r7.getMeasuredWidth()     // Catch:{ all -> 0x00b6 }
            int r8 = r8 + r9
            int r9 = r7.getPaddingLeft()     // Catch:{ all -> 0x00b6 }
            int r8 = r8 + r9
            int r7 = r7.getPaddingRight()     // Catch:{ all -> 0x00b6 }
            int r8 = r8 + r7
            int r11 = java.lang.Math.max(r11, r8)     // Catch:{ all -> 0x00b6 }
            int r5 = r5 + 1
            goto L_0x0030
        L_0x0054:
            int r5 = android.view.View.MeasureSpec.getMode(r12)     // Catch:{ all -> 0x00b6 }
            if (r5 == r6) goto L_0x0062
            if (r5 != 0) goto L_0x005d
            goto L_0x0062
        L_0x005d:
            int r12 = android.view.View.MeasureSpec.getSize(r12)     // Catch:{ all -> 0x00b6 }
            goto L_0x0087
        L_0x0062:
            r12 = r3
        L_0x0063:
            int r5 = r10.getChildCount()     // Catch:{ all -> 0x00b6 }
            if (r3 >= r5) goto L_0x0087
            android.view.View r5 = r10.getChildAt(r3)     // Catch:{ all -> 0x00b6 }
            int r6 = r5.getTop()     // Catch:{ all -> 0x00b6 }
            int r7 = r5.getMeasuredHeight()     // Catch:{ all -> 0x00b6 }
            int r6 = r6 + r7
            int r7 = r5.getPaddingTop()     // Catch:{ all -> 0x00b6 }
            int r6 = r6 + r7
            int r5 = r5.getPaddingBottom()     // Catch:{ all -> 0x00b6 }
            int r6 = r6 + r5
            int r12 = java.lang.Math.max(r12, r6)     // Catch:{ all -> 0x00b6 }
            int r3 = r3 + 1
            goto L_0x0063
        L_0x0087:
            r10.setMeasuredDimension(r11, r12)     // Catch:{ all -> 0x00b6 }
            r10.mWasMeasured = r4     // Catch:{ all -> 0x00b6 }
            com.facebook.react.ReactInstanceManager r3 = r10.mReactInstanceManager     // Catch:{ all -> 0x00b6 }
            if (r3 == 0) goto L_0x0098
            boolean r3 = r10.mIsAttachedToInstance     // Catch:{ all -> 0x00b6 }
            if (r3 != 0) goto L_0x0098
            r10.attachToReactInstanceManager()     // Catch:{ all -> 0x00b6 }
            goto L_0x00a9
        L_0x0098:
            if (r2 != 0) goto L_0x00a2
            int r2 = r10.mLastWidth     // Catch:{ all -> 0x00b6 }
            if (r2 != r11) goto L_0x00a2
            int r2 = r10.mLastHeight     // Catch:{ all -> 0x00b6 }
            if (r2 == r12) goto L_0x00a9
        L_0x00a2:
            int r2 = r10.mWidthMeasureSpec     // Catch:{ all -> 0x00b6 }
            int r3 = r10.mHeightMeasureSpec     // Catch:{ all -> 0x00b6 }
            r10.updateRootLayoutSpecs(r4, r2, r3)     // Catch:{ all -> 0x00b6 }
        L_0x00a9:
            r10.mLastWidth = r11     // Catch:{ all -> 0x00b6 }
            r10.mLastHeight = r12     // Catch:{ all -> 0x00b6 }
            com.facebook.react.bridge.ReactMarkerConstants r11 = com.facebook.react.bridge.ReactMarkerConstants.ROOT_VIEW_ON_MEASURE_END
            com.facebook.react.bridge.ReactMarker.logMarker((com.facebook.react.bridge.ReactMarkerConstants) r11)
            com.facebook.systrace.Systrace.endSection(r0)
            return
        L_0x00b6:
            r11 = move-exception
            com.facebook.react.bridge.ReactMarkerConstants r12 = com.facebook.react.bridge.ReactMarkerConstants.ROOT_VIEW_ON_MEASURE_END
            com.facebook.react.bridge.ReactMarker.logMarker((com.facebook.react.bridge.ReactMarkerConstants) r12)
            com.facebook.systrace.Systrace.endSection(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.ReactRootView.onMeasure(int, int):void");
    }

    public void onChildStartedNativeGesture(MotionEvent motionEvent) {
        onChildStartedNativeGesture((View) null, motionEvent);
    }

    public void onChildStartedNativeGesture(View view, MotionEvent motionEvent) {
        UIManager uIManager;
        JSPointerDispatcher jSPointerDispatcher;
        if (isDispatcherReady() && (uIManager = UIManagerHelper.getUIManager(this.mReactInstanceManager.getCurrentReactContext(), getUIManagerType())) != null) {
            EventDispatcher eventDispatcher = (EventDispatcher) uIManager.getEventDispatcher();
            this.mJSTouchDispatcher.onChildStartedNativeGesture(motionEvent, eventDispatcher);
            if (view != null && (jSPointerDispatcher = this.mJSPointerDispatcher) != null) {
                jSPointerDispatcher.onChildStartedNativeGesture(view, motionEvent, eventDispatcher);
            }
        }
    }

    public void onChildEndedNativeGesture(View view, MotionEvent motionEvent) {
        UIManager uIManager;
        if (isDispatcherReady() && (uIManager = UIManagerHelper.getUIManager(this.mReactInstanceManager.getCurrentReactContext(), getUIManagerType())) != null) {
            this.mJSTouchDispatcher.onChildEndedNativeGesture(motionEvent, (EventDispatcher) uIManager.getEventDispatcher());
            JSPointerDispatcher jSPointerDispatcher = this.mJSPointerDispatcher;
            if (jSPointerDispatcher != null) {
                jSPointerDispatcher.onChildEndedNativeGesture();
            }
        }
    }

    private boolean isDispatcherReady() {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || !this.mIsAttachedToInstance || reactInstanceManager.getCurrentReactContext() == null) {
            FLog.w(TAG, "Unable to dispatch touch to JS as the catalyst instance has not been attached");
            return false;
        } else if (this.mJSTouchDispatcher == null) {
            FLog.w(TAG, "Unable to dispatch touch to JS before the dispatcher is available");
            return false;
        } else if (!ReactFeatureFlags.dispatchPointerEvents || this.mJSPointerDispatcher != null) {
            return true;
        } else {
            FLog.w(TAG, "Unable to dispatch pointer events to JS before the dispatcher is available");
            return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (shouldDispatchJSTouchEvent(motionEvent)) {
            dispatchJSTouchEvent(motionEvent);
        }
        dispatchJSPointerEvent(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onInterceptHoverEvent(MotionEvent motionEvent) {
        dispatchJSPointerEvent(motionEvent);
        return super.onInterceptHoverEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (shouldDispatchJSTouchEvent(motionEvent)) {
            dispatchJSTouchEvent(motionEvent);
        }
        dispatchJSPointerEvent(motionEvent);
        super.onTouchEvent(motionEvent);
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        dispatchJSPointerEvent(motionEvent);
        return super.onHoverEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (StackOverflowError e) {
            handleException(e);
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || !this.mIsAttachedToInstance || reactInstanceManager.getCurrentReactContext() == null) {
            FLog.w(TAG, "Unable to handle key event as the catalyst instance has not been attached");
            return super.dispatchKeyEvent(keyEvent);
        }
        this.mAndroidHWInputDeviceHelper.handleKeyEvent(keyEvent);
        return super.dispatchKeyEvent(keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || !this.mIsAttachedToInstance || reactInstanceManager.getCurrentReactContext() == null) {
            FLog.w(TAG, "Unable to handle focus changed event as the catalyst instance has not been attached");
            super.onFocusChanged(z, i, rect);
            return;
        }
        this.mAndroidHWInputDeviceHelper.clearFocus();
        super.onFocusChanged(z, i, rect);
    }

    public void requestChildFocus(View view, View view2) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || !this.mIsAttachedToInstance || reactInstanceManager.getCurrentReactContext() == null) {
            FLog.w(TAG, "Unable to handle child focus changed event as the catalyst instance has not been attached");
            super.requestChildFocus(view, view2);
            return;
        }
        this.mAndroidHWInputDeviceHelper.onFocusChanged(view2);
        super.requestChildFocus(view, view2);
    }

    /* access modifiers changed from: protected */
    public void dispatchJSPointerEvent(MotionEvent motionEvent) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || !this.mIsAttachedToInstance || reactInstanceManager.getCurrentReactContext() == null) {
            FLog.w(TAG, "Unable to dispatch touch to JS as the catalyst instance has not been attached");
        } else if (this.mJSPointerDispatcher != null) {
            UIManager uIManager = UIManagerHelper.getUIManager(this.mReactInstanceManager.getCurrentReactContext(), getUIManagerType());
            if (uIManager != null) {
                this.mJSPointerDispatcher.handleMotionEvent(motionEvent, (EventDispatcher) uIManager.getEventDispatcher());
            }
        } else if (ReactFeatureFlags.dispatchPointerEvents) {
            FLog.w(TAG, "Unable to dispatch pointer events to JS before the dispatcher is available");
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchJSTouchEvent(MotionEvent motionEvent) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || !this.mIsAttachedToInstance || reactInstanceManager.getCurrentReactContext() == null) {
            FLog.w(TAG, "Unable to dispatch touch to JS as the catalyst instance has not been attached");
        } else if (this.mJSTouchDispatcher == null) {
            FLog.w(TAG, "Unable to dispatch touch to JS before the dispatcher is available");
        } else {
            UIManager uIManager = UIManagerHelper.getUIManager(this.mReactInstanceManager.getCurrentReactContext(), getUIManagerType());
            if (uIManager != null) {
                this.mJSTouchDispatcher.handleTouchEvent(motionEvent, (EventDispatcher) uIManager.getEventDispatcher());
            }
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mWasMeasured && isFabric()) {
            updateRootLayoutSpecs(false, this.mWidthMeasureSpec, this.mHeightMeasureSpec);
        }
    }

    private boolean isFabric() {
        return getUIManagerType() == 2;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mIsAttachedToInstance) {
            removeOnGlobalLayoutListener();
            getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mIsAttachedToInstance) {
            removeOnGlobalLayoutListener();
        }
    }

    private void removeOnGlobalLayoutListener() {
        getViewTreeObserver().removeOnGlobalLayoutListener(getCustomGlobalLayoutListener());
    }

    public void onViewAdded(final View view) {
        super.onViewAdded(view);
        if (view instanceof ReactClippingProhibitedView) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    if (!view.isShown()) {
                        ReactSoftExceptionLogger.logSoftException(ReactRootView.TAG, new ReactNoCrashSoftException("A view was illegally added as a child of a ReactRootView. This View should not be a direct child of a ReactRootView, because it is not visible and will never be reachable. Child: " + view.getClass().getCanonicalName().toString() + " child ID: " + view.getId()));
                    }
                }
            });
        }
        if (this.mShouldLogContentAppeared) {
            this.mShouldLogContentAppeared = false;
            if (this.mJSModuleName != null) {
                ReactMarker.logMarker(ReactMarkerConstants.CONTENT_APPEARED, this.mJSModuleName, this.mRootViewTag);
            }
        }
    }

    public void startReactApplication(ReactInstanceManager reactInstanceManager, String str) {
        startReactApplication(reactInstanceManager, str, (Bundle) null);
    }

    public void startReactApplication(ReactInstanceManager reactInstanceManager, String str, Bundle bundle) {
        startReactApplication(reactInstanceManager, str, bundle, (String) null);
    }

    public void startReactApplication(ReactInstanceManager reactInstanceManager, String str, Bundle bundle, String str2) {
        Systrace.beginSection(0, "startReactApplication");
        try {
            UiThreadUtil.assertOnUiThread();
            Assertions.assertCondition(this.mReactInstanceManager == null, "This root view has already been attached to a catalyst instance manager");
            this.mReactInstanceManager = reactInstanceManager;
            this.mJSModuleName = str;
            this.mAppProperties = bundle;
            this.mInitialUITemplate = str2;
            reactInstanceManager.createReactContextInBackground();
            if (ReactFeatureFlags.enableEagerRootViewAttachment) {
                if (!this.mWasMeasured) {
                    setSurfaceConstraintsToScreenSize();
                }
                attachToReactInstanceManager();
            }
        } finally {
            Systrace.endSection(0);
        }
    }

    private void setSurfaceConstraintsToScreenSize() {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.mWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, Integer.MIN_VALUE);
        this.mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, Integer.MIN_VALUE);
    }

    public int getWidthMeasureSpec() {
        return this.mWidthMeasureSpec;
    }

    public int getHeightMeasureSpec() {
        return this.mHeightMeasureSpec;
    }

    public void setShouldLogContentAppeared(boolean z) {
        this.mShouldLogContentAppeared = z;
    }

    public String getSurfaceID() {
        Bundle appProperties = getAppProperties();
        if (appProperties != null) {
            return appProperties.getString("surfaceID");
        }
        return null;
    }

    public AtomicInteger getState() {
        return this.mState;
    }

    private void updateRootLayoutSpecs(boolean z, int i, int i2) {
        UIManager uIManager;
        int i3;
        ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_UPDATE_LAYOUT_SPECS_START);
        if (this.mReactInstanceManager == null) {
            ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_UPDATE_LAYOUT_SPECS_END);
            FLog.w(TAG, "Unable to update root layout specs for uninitialized ReactInstanceManager");
            return;
        }
        boolean isFabric = isFabric();
        if (!isFabric || isRootViewTagSet()) {
            ReactContext currentReactContext = this.mReactInstanceManager.getCurrentReactContext();
            if (!(currentReactContext == null || (uIManager = UIManagerHelper.getUIManager(currentReactContext, getUIManagerType())) == null)) {
                int i4 = 0;
                if (isFabric) {
                    Point viewportOffset = RootViewUtil.getViewportOffset(this);
                    i4 = viewportOffset.x;
                    i3 = viewportOffset.y;
                } else {
                    i3 = 0;
                }
                if (!(!z && i4 == this.mLastOffsetX && i3 == this.mLastOffsetY)) {
                    uIManager.updateRootLayoutSpecs(getRootViewTag(), i, i2, i4, i3);
                }
                this.mLastOffsetX = i4;
                this.mLastOffsetY = i3;
            }
            ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_UPDATE_LAYOUT_SPECS_END);
            return;
        }
        ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_UPDATE_LAYOUT_SPECS_END);
        FLog.e(TAG, "Unable to update root layout specs for ReactRootView: no rootViewTag set yet");
    }

    public void unmountReactApplication() {
        ReactContext currentReactContext;
        UIManager uIManager;
        UiThreadUtil.assertOnUiThread();
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (!(reactInstanceManager == null || (currentReactContext = reactInstanceManager.getCurrentReactContext()) == null || !isFabric() || (uIManager = UIManagerHelper.getUIManager(currentReactContext, getUIManagerType())) == null)) {
            int id = getId();
            setId(-1);
            removeAllViews();
            if (id == -1) {
                ReactSoftExceptionLogger.logSoftException(TAG, new RuntimeException("unmountReactApplication called on ReactRootView with invalid id"));
            } else {
                uIManager.stopSurface(id);
            }
        }
        ReactInstanceManager reactInstanceManager2 = this.mReactInstanceManager;
        if (reactInstanceManager2 != null && this.mIsAttachedToInstance) {
            reactInstanceManager2.detachRootView(this);
            this.mIsAttachedToInstance = false;
        }
        this.mReactInstanceManager = null;
        this.mShouldLogContentAppeared = false;
    }

    public void onStage(int i) {
        if (i == 101) {
            onAttachedToReactInstance();
        }
    }

    public void onAttachedToReactInstance() {
        this.mJSTouchDispatcher = new JSTouchDispatcher(this);
        if (ReactFeatureFlags.dispatchPointerEvents) {
            this.mJSPointerDispatcher = new JSPointerDispatcher(this);
        }
        ReactRootViewEventListener reactRootViewEventListener = this.mRootViewEventListener;
        if (reactRootViewEventListener != null) {
            reactRootViewEventListener.onAttachedToReactInstance(this);
        }
    }

    public void setEventListener(ReactRootViewEventListener reactRootViewEventListener) {
        this.mRootViewEventListener = reactRootViewEventListener;
    }

    public String getJSModuleName() {
        return (String) Assertions.assertNotNull(this.mJSModuleName);
    }

    public Bundle getAppProperties() {
        return this.mAppProperties;
    }

    public String getInitialUITemplate() {
        return this.mInitialUITemplate;
    }

    public void setAppProperties(Bundle bundle) {
        UiThreadUtil.assertOnUiThread();
        this.mAppProperties = bundle;
        if (isRootViewTagSet()) {
            runApplication();
        }
    }

    public void runApplication() {
        Systrace.beginSection(0, "ReactRootView.runApplication");
        try {
            ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
            if (reactInstanceManager != null) {
                if (this.mIsAttachedToInstance) {
                    ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
                    if (currentReactContext == null) {
                        Systrace.endSection(0);
                        return;
                    }
                    CatalystInstance catalystInstance = currentReactContext.getCatalystInstance();
                    String jSModuleName = getJSModuleName();
                    if (this.mWasMeasured) {
                        updateRootLayoutSpecs(true, this.mWidthMeasureSpec, this.mHeightMeasureSpec);
                    }
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    writableNativeMap.putDouble("rootTag", (double) getRootViewTag());
                    Bundle appProperties = getAppProperties();
                    if (appProperties != null) {
                        writableNativeMap.putMap("initialProps", Arguments.fromBundle(appProperties));
                    }
                    this.mShouldLogContentAppeared = true;
                    ((AppRegistry) catalystInstance.getJSModule(AppRegistry.class)).runApplication(jSModuleName, writableNativeMap);
                    Systrace.endSection(0);
                }
            }
        } finally {
            Systrace.endSection(0);
        }
    }

    /* access modifiers changed from: package-private */
    public void simulateAttachForTesting() {
        this.mIsAttachedToInstance = true;
        this.mJSTouchDispatcher = new JSTouchDispatcher(this);
        if (ReactFeatureFlags.dispatchPointerEvents) {
            this.mJSPointerDispatcher = new JSPointerDispatcher(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void simulateCheckForKeyboardForTesting() {
        if (Build.VERSION.SDK_INT >= 30) {
            getCustomGlobalLayoutListener().checkForKeyboardEvents();
        } else {
            getCustomGlobalLayoutListener().checkForKeyboardEventsLegacy();
        }
    }

    private CustomGlobalLayoutListener getCustomGlobalLayoutListener() {
        if (this.mCustomGlobalLayoutListener == null) {
            this.mCustomGlobalLayoutListener = new CustomGlobalLayoutListener();
        }
        return this.mCustomGlobalLayoutListener;
    }

    private void attachToReactInstanceManager() {
        Systrace.beginSection(0, "attachToReactInstanceManager");
        ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_ATTACH_TO_REACT_INSTANCE_MANAGER_START);
        if (getId() != -1) {
            ReactSoftExceptionLogger.logSoftException(TAG, new IllegalViewOperationException("Trying to attach a ReactRootView with an explicit id already set to [" + getId() + "]. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID."));
        }
        try {
            if (!this.mIsAttachedToInstance) {
                this.mIsAttachedToInstance = true;
                ((ReactInstanceManager) Assertions.assertNotNull(this.mReactInstanceManager)).attachRootView(this);
                getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
                ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_ATTACH_TO_REACT_INSTANCE_MANAGER_END);
                Systrace.endSection(0);
            }
        } finally {
            ReactMarker.logMarker(ReactMarkerConstants.ROOT_VIEW_ATTACH_TO_REACT_INSTANCE_MANAGER_END);
            Systrace.endSection(0);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        Assertions.assertCondition(!this.mIsAttachedToInstance, "The application this ReactRootView was rendering was not unmounted before the ReactRootView was garbage collected. This usually means that your application is leaking large amounts of memory. To solve this, make sure to call ReactRootView#unmountReactApplication in the onDestroy() of your hosting Activity or in the onDestroyView() of your hosting Fragment.");
    }

    public int getRootViewTag() {
        return this.mRootViewTag;
    }

    private boolean isRootViewTagSet() {
        int i = this.mRootViewTag;
        return (i == 0 || i == -1) ? false : true;
    }

    public void setRootViewTag(int i) {
        this.mRootViewTag = i;
    }

    public void handleException(Throwable th) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || reactInstanceManager.getCurrentReactContext() == null) {
            throw new RuntimeException(th);
        }
        this.mReactInstanceManager.getCurrentReactContext().handleException(new IllegalViewOperationException(th.getMessage(), this, th));
    }

    public void setIsFabric(boolean z) {
        this.mUIManagerType = z ? 2 : 1;
    }

    public int getUIManagerType() {
        return this.mUIManagerType;
    }

    public ReactInstanceManager getReactInstanceManager() {
        return this.mReactInstanceManager;
    }

    /* access modifiers changed from: package-private */
    public void sendEvent(String str, WritableMap writableMap) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager != null) {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactInstanceManager.getCurrentReactContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
        }
    }

    private class CustomGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private int mDeviceRotation = 0;
        private int mKeyboardHeight = 0;
        private boolean mKeyboardIsVisible = false;
        private final int mMinKeyboardHeightDetected;
        private final Rect mVisibleViewArea;

        CustomGlobalLayoutListener() {
            DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(ReactRootView.this.getContext().getApplicationContext());
            this.mVisibleViewArea = new Rect();
            this.mMinKeyboardHeightDetected = (int) PixelUtil.toPixelFromDIP(60.0f);
        }

        public void onGlobalLayout() {
            if (ReactRootView.this.mReactInstanceManager != null && ReactRootView.this.mIsAttachedToInstance && ReactRootView.this.mReactInstanceManager.getCurrentReactContext() != null) {
                if (Build.VERSION.SDK_INT >= 30) {
                    checkForKeyboardEvents();
                } else {
                    checkForKeyboardEventsLegacy();
                }
                checkForDeviceOrientationChanges();
                checkForDeviceDimensionsChanges();
            }
        }

        private WindowManager.LayoutParams getWindowLayoutParams() {
            View view = ReactRootView.this;
            if (view.getLayoutParams() instanceof WindowManager.LayoutParams) {
                return (WindowManager.LayoutParams) view.getLayoutParams();
            }
            while (view.getParent() instanceof View) {
                view = (View) view.getParent();
                if (view.getLayoutParams() instanceof WindowManager.LayoutParams) {
                    return (WindowManager.LayoutParams) view.getLayoutParams();
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public void checkForKeyboardEvents() {
            boolean isVisible;
            int i;
            ReactRootView.this.getRootView().getWindowVisibleDisplayFrame(this.mVisibleViewArea);
            WindowInsets rootWindowInsets = ReactRootView.this.getRootView().getRootWindowInsets();
            if (rootWindowInsets != null && (isVisible = rootWindowInsets.isVisible(WindowInsets.Type.ime())) != this.mKeyboardIsVisible) {
                this.mKeyboardIsVisible = isVisible;
                if (isVisible) {
                    int i2 = rootWindowInsets.getInsets(WindowInsets.Type.ime()).bottom - rootWindowInsets.getInsets(WindowInsets.Type.systemBars()).bottom;
                    WindowManager.LayoutParams windowLayoutParams = getWindowLayoutParams();
                    if (windowLayoutParams != null) {
                        if (windowLayoutParams.softInputMode == 48) {
                            i = this.mVisibleViewArea.bottom - i2;
                        } else {
                            i = this.mVisibleViewArea.bottom;
                        }
                        ReactRootView.this.sendEvent("keyboardDidShow", createKeyboardEventPayload((double) PixelUtil.toDIPFromPixel((float) i), (double) PixelUtil.toDIPFromPixel((float) this.mVisibleViewArea.left), (double) PixelUtil.toDIPFromPixel((float) this.mVisibleViewArea.width()), (double) PixelUtil.toDIPFromPixel((float) i2)));
                        return;
                    }
                    return;
                }
                ReactRootView reactRootView = ReactRootView.this;
                reactRootView.sendEvent("keyboardDidHide", createKeyboardEventPayload((double) PixelUtil.toDIPFromPixel((float) reactRootView.mLastHeight), 0.0d, (double) PixelUtil.toDIPFromPixel((float) this.mVisibleViewArea.width()), 0.0d));
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x001e, code lost:
            r0 = (r0 = r11.this$0.getRootView().getRootWindowInsets()).getDisplayCutout();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void checkForKeyboardEventsLegacy() {
            /*
                r11 = this;
                com.facebook.react.ReactRootView r0 = com.facebook.react.ReactRootView.this
                android.view.View r0 = r0.getRootView()
                android.graphics.Rect r1 = r11.mVisibleViewArea
                r0.getWindowVisibleDisplayFrame(r1)
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 0
                r2 = 28
                if (r0 < r2) goto L_0x0029
                com.facebook.react.ReactRootView r0 = com.facebook.react.ReactRootView.this
                android.view.View r0 = r0.getRootView()
                android.view.WindowInsets r0 = r0.getRootWindowInsets()
                if (r0 == 0) goto L_0x0029
                android.view.DisplayCutout r0 = r0.getDisplayCutout()
                if (r0 == 0) goto L_0x0029
                int r0 = r0.getSafeInsetTop()
                goto L_0x002a
            L_0x0029:
                r0 = r1
            L_0x002a:
                android.util.DisplayMetrics r2 = com.facebook.react.uimanager.DisplayMetricsHolder.getWindowDisplayMetrics()
                int r2 = r2.heightPixels
                android.graphics.Rect r3 = r11.mVisibleViewArea
                int r3 = r3.bottom
                int r2 = r2 - r3
                int r2 = r2 + r0
                int r0 = r11.mKeyboardHeight
                r3 = 1
                if (r0 == r2) goto L_0x0041
                int r4 = r11.mMinKeyboardHeightDetected
                if (r2 <= r4) goto L_0x0041
                r4 = r3
                goto L_0x0042
            L_0x0041:
                r4 = r1
            L_0x0042:
                if (r4 == 0) goto L_0x007d
                r11.mKeyboardHeight = r2
                r11.mKeyboardIsVisible = r3
                com.facebook.react.ReactRootView r0 = com.facebook.react.ReactRootView.this
                android.graphics.Rect r1 = r11.mVisibleViewArea
                int r1 = r1.bottom
                float r1 = (float) r1
                float r1 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r1)
                double r3 = (double) r1
                android.graphics.Rect r1 = r11.mVisibleViewArea
                int r1 = r1.left
                float r1 = (float) r1
                float r1 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r1)
                double r5 = (double) r1
                android.graphics.Rect r1 = r11.mVisibleViewArea
                int r1 = r1.width()
                float r1 = (float) r1
                float r1 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r1)
                double r7 = (double) r1
                int r1 = r11.mKeyboardHeight
                float r1 = (float) r1
                float r1 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r1)
                double r9 = (double) r1
                r2 = r11
                com.facebook.react.bridge.WritableMap r1 = r2.createKeyboardEventPayload(r3, r5, r7, r9)
                java.lang.String r2 = "keyboardDidShow"
                r0.sendEvent(r2, r1)
                return
            L_0x007d:
                if (r0 == 0) goto L_0x0084
                int r0 = r11.mMinKeyboardHeightDetected
                if (r2 > r0) goto L_0x0084
                goto L_0x0085
            L_0x0084:
                r3 = r1
            L_0x0085:
                if (r3 == 0) goto L_0x00b1
                r11.mKeyboardHeight = r1
                r11.mKeyboardIsVisible = r1
                com.facebook.react.ReactRootView r0 = com.facebook.react.ReactRootView.this
                int r1 = r0.mLastHeight
                float r1 = (float) r1
                float r1 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r1)
                double r3 = (double) r1
                r5 = 0
                android.graphics.Rect r1 = r11.mVisibleViewArea
                int r1 = r1.width()
                float r1 = (float) r1
                float r1 = com.facebook.react.uimanager.PixelUtil.toDIPFromPixel(r1)
                double r7 = (double) r1
                r9 = 0
                r2 = r11
                com.facebook.react.bridge.WritableMap r1 = r2.createKeyboardEventPayload(r3, r5, r7, r9)
                java.lang.String r2 = "keyboardDidHide"
                r0.sendEvent(r2, r1)
            L_0x00b1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.ReactRootView.CustomGlobalLayoutListener.checkForKeyboardEventsLegacy():void");
        }

        private void checkForDeviceOrientationChanges() {
            int rotation = ((WindowManager) ReactRootView.this.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
            if (this.mDeviceRotation != rotation) {
                this.mDeviceRotation = rotation;
                DisplayMetricsHolder.initDisplayMetrics(ReactRootView.this.getContext().getApplicationContext());
                emitOrientationChanged(rotation);
            }
        }

        private void checkForDeviceDimensionsChanges() {
            emitUpdateDimensionsEvent();
        }

        private void emitOrientationChanged(int i) {
            String str;
            double d;
            double d2;
            boolean z = true;
            if (i != 0) {
                if (i == 1) {
                    d = -90.0d;
                    str = "landscape-primary";
                } else if (i == 2) {
                    d2 = 180.0d;
                    str = "portrait-secondary";
                } else if (i == 3) {
                    d = 90.0d;
                    str = "landscape-secondary";
                } else {
                    return;
                }
                WritableMap createMap = Arguments.createMap();
                createMap.putString("name", str);
                createMap.putDouble("rotationDegrees", d);
                createMap.putBoolean("isLandscape", z);
                ReactRootView.this.sendEvent("namedOrientationDidChange", createMap);
            }
            d2 = 0.0d;
            str = "portrait-primary";
            z = false;
            d = d2;
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putString("name", str);
            createMap2.putDouble("rotationDegrees", d);
            createMap2.putBoolean("isLandscape", z);
            ReactRootView.this.sendEvent("namedOrientationDidChange", createMap2);
        }

        private void emitUpdateDimensionsEvent() {
            DeviceInfoModule deviceInfoModule = (DeviceInfoModule) ReactRootView.this.mReactInstanceManager.getCurrentReactContext().getNativeModule(DeviceInfoModule.class);
            if (deviceInfoModule != null) {
                deviceInfoModule.emitUpdateDimensionsEvent();
            }
        }

        private WritableMap createKeyboardEventPayload(double d, double d2, double d3, double d4) {
            WritableMap createMap = Arguments.createMap();
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putDouble("height", d4);
            createMap2.putDouble("screenX", d2);
            createMap2.putDouble("width", d3);
            createMap2.putDouble("screenY", d);
            createMap.putMap("endCoordinates", createMap2);
            createMap.putString("easing", "keyboard");
            createMap.putDouble("duration", 0.0d);
            return createMap;
        }
    }
}
