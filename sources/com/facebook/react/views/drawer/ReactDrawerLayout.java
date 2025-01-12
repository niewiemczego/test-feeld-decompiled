package com.facebook.react.views.drawer;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.events.NativeGestureUtil;

class ReactDrawerLayout extends DrawerLayout {
    public static final int DEFAULT_DRAWER_WIDTH = -1;
    private boolean mDragging = false;
    private int mDrawerPosition = GravityCompat.START;
    private int mDrawerWidth = -1;

    public ReactDrawerLayout(ReactContext reactContext) {
        super(reactContext);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            if (!super.onInterceptTouchEvent(motionEvent)) {
                return false;
            }
            NativeGestureUtil.notifyNativeGestureStarted(this, motionEvent);
            this.mDragging = true;
            return true;
        } catch (IllegalArgumentException e) {
            FLog.w(ReactConstants.TAG, "Error intercepting touch event.", (Throwable) e);
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1 && this.mDragging) {
            NativeGestureUtil.notifyNativeGestureEnded(this, motionEvent);
            this.mDragging = false;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: package-private */
    public void openDrawer() {
        openDrawer(this.mDrawerPosition);
    }

    /* access modifiers changed from: package-private */
    public void closeDrawer() {
        closeDrawer(this.mDrawerPosition);
    }

    /* access modifiers changed from: package-private */
    public void setDrawerPosition(int i) {
        this.mDrawerPosition = i;
        setDrawerProperties();
    }

    /* access modifiers changed from: package-private */
    public void setDrawerWidth(int i) {
        this.mDrawerWidth = i;
        setDrawerProperties();
    }

    /* access modifiers changed from: package-private */
    public void setDrawerProperties() {
        if (getChildCount() == 2) {
            View childAt = getChildAt(1);
            DrawerLayout.LayoutParams layoutParams = (DrawerLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.gravity = this.mDrawerPosition;
            layoutParams.width = this.mDrawerWidth;
            childAt.setLayoutParams(layoutParams);
            childAt.setClickable(true);
        }
    }
}
