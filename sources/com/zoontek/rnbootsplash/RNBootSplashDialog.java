package com.zoontek.rnbootsplash;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Window;

public class RNBootSplashDialog extends Dialog {
    private final boolean mFade;

    public RNBootSplashDialog(Activity activity, int i, boolean z) {
        super(activity, i);
        this.mFade = z;
        setOwnerActivity(activity);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    public void onBackPressed() {
        Activity ownerActivity = getOwnerActivity();
        if (ownerActivity != null) {
            ownerActivity.moveTaskToBack(true);
        }
    }

    public void dismiss() {
        if (isShowing()) {
            try {
                super.dismiss();
            } catch (Exception unused) {
            }
        }
    }

    public void dismiss(final Runnable runnable) {
        if (!isShowing()) {
            runnable.run();
            return;
        }
        setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                runnable.run();
            }
        });
        try {
            super.dismiss();
        } catch (Exception unused) {
            runnable.run();
        }
    }

    public void show() {
        if (!isShowing()) {
            try {
                super.show();
            } catch (Exception unused) {
            }
        }
    }

    public void show(final Runnable runnable) {
        if (isShowing()) {
            runnable.run();
            return;
        }
        setOnShowListener(new DialogInterface.OnShowListener() {
            public void onShow(DialogInterface dialogInterface) {
                runnable.run();
            }
        });
        try {
            super.show();
        } catch (Exception unused) {
            runnable.run();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        int i;
        Window window = getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
            if (this.mFade) {
                i = R.style.BootSplashFadeOutAnimation;
            } else {
                i = R.style.BootSplashNoAnimation;
            }
            window.setWindowAnimations(i);
            if (RNBootSplashModuleImpl.isSamsungOneUI4()) {
                window.setBackgroundDrawableResource(R.drawable.compat_splash_screen_oneui_4);
            }
        }
        super.onCreate(bundle);
    }
}
