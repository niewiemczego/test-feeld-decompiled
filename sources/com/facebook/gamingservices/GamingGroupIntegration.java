package com.facebook.gamingservices;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import com.facebook.FacebookCallback;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import java.util.List;

public class GamingGroupIntegration extends FacebookDialogBase<Void, Result> {
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.GamingGroupIntegration.toRequestCode();
    private static final String ERROR_KEY = "error";

    public static class Result {
    }

    /* access modifiers changed from: protected */
    public AppCall createBaseAppCall() {
        return null;
    }

    /* access modifiers changed from: protected */
    public List<FacebookDialogBase<Void, Result>.ModeHandler> getOrderedModeHandlers() {
        return null;
    }

    public GamingGroupIntegration(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    public GamingGroupIntegration(Fragment fragment) {
        super(new FragmentWrapper(fragment), DEFAULT_REQUEST_CODE);
    }

    public GamingGroupIntegration(androidx.fragment.app.Fragment fragment) {
        super(new FragmentWrapper(fragment), DEFAULT_REQUEST_CODE);
    }

    public void show() {
        showImpl();
    }

    public void show(Void voidR) {
        showImpl();
    }

    /* access modifiers changed from: protected */
    public void showImpl() {
        startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse("https://fb.gg/me/community/" + FacebookSdk.getApplicationId())), getRequestCode());
    }

    /* access modifiers changed from: protected */
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, final FacebookCallback facebookCallback) {
        callbackManagerImpl.registerCallback(getRequestCode(), new CallbackManagerImpl.Callback() {
            public boolean onActivityResult(int i, Intent intent) {
                if (intent == null || !intent.hasExtra("error")) {
                    facebookCallback.onSuccess(new Result());
                    return true;
                }
                facebookCallback.onError(((FacebookRequestError) intent.getParcelableExtra("error")).getException());
                return true;
            }
        });
    }
}
