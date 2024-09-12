package com.facebook.react.devsupport;

import android.app.Activity;
import android.app.Dialog;
import android.view.KeyEvent;
import com.facebook.common.logging.FLog;
import com.facebook.react.R;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.SurfaceDelegate;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;

public class RedBoxDialogSurfaceDelegate implements SurfaceDelegate {
    /* access modifiers changed from: private */
    public final DevSupportManager mDevSupportManager;
    private Dialog mDialog;
    /* access modifiers changed from: private */
    public final DoubleTapReloadRecognizer mDoubleTapReloadRecognizer = new DoubleTapReloadRecognizer();
    private RedBoxContentView mRedBoxContentView;

    public RedBoxDialogSurfaceDelegate(DevSupportManager devSupportManager) {
        this.mDevSupportManager = devSupportManager;
    }

    public void createContentView(String str) {
        RedBoxHandler redBoxHandler = this.mDevSupportManager.getRedBoxHandler();
        Activity currentActivity = this.mDevSupportManager.getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing()) {
            String lastErrorTitle = this.mDevSupportManager.getLastErrorTitle();
            StringBuilder append = new StringBuilder().append("Unable to launch redbox because react activity is not available, here is the error that redbox would've displayed: ");
            if (lastErrorTitle == null) {
                lastErrorTitle = "N/A";
            }
            FLog.e(ReactConstants.TAG, append.append(lastErrorTitle).toString());
            return;
        }
        RedBoxContentView redBoxContentView = new RedBoxContentView(currentActivity);
        this.mRedBoxContentView = redBoxContentView;
        redBoxContentView.setDevSupportManager(this.mDevSupportManager).setRedBoxHandler(redBoxHandler).init();
    }

    public boolean isContentViewReady() {
        return this.mRedBoxContentView != null;
    }

    public void destroyContentView() {
        this.mRedBoxContentView = null;
    }

    public void show() {
        String lastErrorTitle = this.mDevSupportManager.getLastErrorTitle();
        Activity currentActivity = this.mDevSupportManager.getCurrentActivity();
        if (currentActivity == null || currentActivity.isFinishing()) {
            StringBuilder append = new StringBuilder().append("Unable to launch redbox because react activity is not available, here is the error that redbox would've displayed: ");
            if (lastErrorTitle == null) {
                lastErrorTitle = "N/A";
            }
            FLog.e(ReactConstants.TAG, append.append(lastErrorTitle).toString());
            return;
        }
        RedBoxContentView redBoxContentView = this.mRedBoxContentView;
        if (redBoxContentView == null || redBoxContentView.getContext() != currentActivity) {
            createContentView("RedBox");
        }
        this.mRedBoxContentView.refreshContentView();
        if (this.mDialog == null) {
            AnonymousClass1 r0 = new Dialog(currentActivity, R.style.Theme_Catalyst_RedBox) {
                public boolean onKeyUp(int i, KeyEvent keyEvent) {
                    if (i == 82) {
                        RedBoxDialogSurfaceDelegate.this.mDevSupportManager.showDevOptionsDialog();
                        return true;
                    }
                    if (RedBoxDialogSurfaceDelegate.this.mDoubleTapReloadRecognizer.didDoubleTapR(i, getCurrentFocus())) {
                        RedBoxDialogSurfaceDelegate.this.mDevSupportManager.handleReloadJS();
                    }
                    return super.onKeyUp(i, keyEvent);
                }
            };
            this.mDialog = r0;
            r0.requestWindowFeature(1);
            this.mDialog.setContentView(this.mRedBoxContentView);
        }
        this.mDialog.show();
    }

    public void hide() {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.dismiss();
            destroyContentView();
            this.mDialog = null;
        }
    }

    public boolean isShowing() {
        Dialog dialog = this.mDialog;
        return dialog != null && dialog.isShowing();
    }
}
