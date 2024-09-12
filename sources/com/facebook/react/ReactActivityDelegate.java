package com.facebook.react;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Callback;
import com.facebook.react.modules.core.PermissionListener;

public class ReactActivityDelegate {
    private final Activity mActivity;
    private boolean mConcurrentRootEnabled;
    private final String mMainComponentName;
    /* access modifiers changed from: private */
    public PermissionListener mPermissionListener;
    private Callback mPermissionsCallback;
    private ReactDelegate mReactDelegate;

    /* access modifiers changed from: protected */
    public Bundle getLaunchOptions() {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean isConcurrentRootEnabled() {
        return false;
    }

    @Deprecated
    public ReactActivityDelegate(Activity activity, String str) {
        this.mActivity = activity;
        this.mMainComponentName = str;
    }

    public ReactActivityDelegate(ReactActivity reactActivity, String str) {
        this.mActivity = reactActivity;
        this.mMainComponentName = str;
    }

    private Bundle composeLaunchOptions() {
        Bundle launchOptions = getLaunchOptions();
        if (isConcurrentRootEnabled()) {
            if (launchOptions == null) {
                launchOptions = new Bundle();
            }
            launchOptions.putBoolean("concurrentRoot", true);
        }
        return launchOptions;
    }

    /* access modifiers changed from: protected */
    public ReactRootView createRootView() {
        return new ReactRootView(getContext());
    }

    /* access modifiers changed from: protected */
    public ReactNativeHost getReactNativeHost() {
        return ((ReactApplication) getPlainActivity().getApplication()).getReactNativeHost();
    }

    public ReactInstanceManager getReactInstanceManager() {
        return this.mReactDelegate.getReactInstanceManager();
    }

    public String getMainComponentName() {
        return this.mMainComponentName;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String mainComponentName = getMainComponentName();
        this.mReactDelegate = new ReactDelegate(getPlainActivity(), getReactNativeHost(), mainComponentName, composeLaunchOptions()) {
            /* access modifiers changed from: protected */
            public ReactRootView createRootView() {
                return ReactActivityDelegate.this.createRootView();
            }
        };
        if (mainComponentName != null) {
            loadApp(mainComponentName);
        }
    }

    /* access modifiers changed from: protected */
    public void loadApp(String str) {
        this.mReactDelegate.loadApp(str);
        getPlainActivity().setContentView(this.mReactDelegate.getReactRootView());
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.mReactDelegate.onHostPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        this.mReactDelegate.onHostResume();
        Callback callback = this.mPermissionsCallback;
        if (callback != null) {
            callback.invoke(new Object[0]);
            this.mPermissionsCallback = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.mReactDelegate.onHostDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.mReactDelegate.onActivityResult(i, i2, intent, true);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!getReactNativeHost().hasInstance() || !getReactNativeHost().getUseDeveloperSupport() || i != 90) {
            return false;
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.mReactDelegate.shouldShowDevMenuOrReload(i, keyEvent);
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        if (!getReactNativeHost().hasInstance() || !getReactNativeHost().getUseDeveloperSupport() || i != 90) {
            return false;
        }
        getReactNativeHost().getReactInstanceManager().showDevOptionsDialog();
        return true;
    }

    public boolean onBackPressed() {
        return this.mReactDelegate.onBackPressed();
    }

    public boolean onNewIntent(Intent intent) {
        if (!getReactNativeHost().hasInstance()) {
            return false;
        }
        getReactNativeHost().getReactInstanceManager().onNewIntent(intent);
        return true;
    }

    public void onWindowFocusChanged(boolean z) {
        if (getReactNativeHost().hasInstance()) {
            getReactNativeHost().getReactInstanceManager().onWindowFocusChange(z);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (getReactNativeHost().hasInstance()) {
            getReactInstanceManager().onConfigurationChanged(getContext(), configuration);
        }
    }

    public void requestPermissions(String[] strArr, int i, PermissionListener permissionListener) {
        this.mPermissionListener = permissionListener;
        getPlainActivity().requestPermissions(strArr, i);
    }

    public void onRequestPermissionsResult(final int i, final String[] strArr, final int[] iArr) {
        this.mPermissionsCallback = new Callback() {
            public void invoke(Object... objArr) {
                if (ReactActivityDelegate.this.mPermissionListener != null && ReactActivityDelegate.this.mPermissionListener.onRequestPermissionsResult(i, strArr, iArr)) {
                    PermissionListener unused = ReactActivityDelegate.this.mPermissionListener = null;
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public Context getContext() {
        return (Context) Assertions.assertNotNull(this.mActivity);
    }

    /* access modifiers changed from: protected */
    public Activity getPlainActivity() {
        return (Activity) getContext();
    }
}
