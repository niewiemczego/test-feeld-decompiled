package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.Sharer;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.ShareContent;

public abstract class ShareButtonBase extends FacebookButtonBase {
    private CallbackManager callbackManager;
    private boolean enabledExplicitlySet = false;
    private int requestCode = 0;
    private ShareContent shareContent;

    /* access modifiers changed from: protected */
    public abstract ShareDialog getDialog();

    protected ShareButtonBase(Context context, AttributeSet attributeSet, int i, String str, String str2) {
        super(context, attributeSet, i, 0, str, str2);
        this.requestCode = isInEditMode() ? 0 : getDefaultRequestCode();
        internalSetEnabled(false);
    }

    public ShareContent getShareContent() {
        return this.shareContent;
    }

    public void setShareContent(ShareContent shareContent2) {
        this.shareContent = shareContent2;
        if (!this.enabledExplicitlySet) {
            internalSetEnabled(canShare());
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.enabledExplicitlySet = true;
    }

    public int getRequestCode() {
        return this.requestCode;
    }

    /* access modifiers changed from: protected */
    public void setRequestCode(int i) {
        if (!FacebookSdk.isFacebookRequestCode(i)) {
            this.requestCode = i;
            return;
        }
        throw new IllegalArgumentException("Request code " + i + " cannot be within the range reserved by the Facebook SDK.");
    }

    public void registerCallback(CallbackManager callbackManager2, FacebookCallback<Sharer.Result> facebookCallback) {
        memorizeCallbackManager(callbackManager2);
        ShareInternalUtility.registerSharerCallback(getRequestCode(), callbackManager2, facebookCallback);
    }

    public void registerCallback(CallbackManager callbackManager2, FacebookCallback<Sharer.Result> facebookCallback, int i) {
        setRequestCode(i);
        registerCallback(callbackManager2, facebookCallback);
    }

    /* access modifiers changed from: protected */
    public void configureButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super.configureButton(context, attributeSet, i, i2);
        setInternalOnClickListener(getShareOnClickListener());
    }

    /* access modifiers changed from: protected */
    public boolean canShare() {
        return getDialog().canShow(getShareContent());
    }

    /* access modifiers changed from: protected */
    public View.OnClickListener getShareOnClickListener() {
        return new View.OnClickListener() {
            public void onClick(View view) {
                if (!CrashShieldHandler.isObjectCrashing(this)) {
                    try {
                        ShareButtonBase.this.callExternalOnClickListener(view);
                        ShareButtonBase.this.getDialog().show(ShareButtonBase.this.getShareContent());
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            }
        };
    }

    private void internalSetEnabled(boolean z) {
        setEnabled(z);
        this.enabledExplicitlySet = false;
    }

    private void memorizeCallbackManager(CallbackManager callbackManager2) {
        CallbackManager callbackManager3 = this.callbackManager;
        if (callbackManager3 == null) {
            this.callbackManager = callbackManager2;
        } else if (callbackManager3 != callbackManager2) {
            Log.w(ShareButtonBase.class.toString(), "You're registering a callback on a Facebook Share Button with two different callback managers. It's almost wrong and may cause unexpected results. Only the first callback manager will be used for handling activity result with androidx.");
        }
    }

    /* access modifiers changed from: protected */
    public CallbackManager getCallbackManager() {
        return this.callbackManager;
    }
}
