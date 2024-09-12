package com.facebook.gamingservices;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class FriendFinderDialog extends FacebookDialogBase<Void, Result> {
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.GamingFriendFinder.toRequestCode();
    /* access modifiers changed from: private */
    public FacebookCallback mCallback;

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

    public FriendFinderDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    public FriendFinderDialog(Fragment fragment) {
        super(new FragmentWrapper(fragment), DEFAULT_REQUEST_CODE);
    }

    public FriendFinderDialog(androidx.fragment.app.Fragment fragment) {
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
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.isExpired()) {
            throw new FacebookException("Attempted to open GamingServices FriendFinder with an invalid access token");
        }
        String applicationId = currentAccessToken.getApplicationId();
        if (CloudGameLoginHandler.isRunningInCloud()) {
            Activity activityContext = getActivityContext();
            AnonymousClass1 r2 = new DaemonRequest.Callback() {
                public void onCompleted(GraphResponse graphResponse) {
                    if (FriendFinderDialog.this.mCallback == null) {
                        return;
                    }
                    if (graphResponse.getError() != null) {
                        FriendFinderDialog.this.mCallback.onError(new FacebookException(graphResponse.getError().getErrorMessage()));
                    } else {
                        FriendFinderDialog.this.mCallback.onSuccess(new Result());
                    }
                }
            };
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", (Object) applicationId);
                jSONObject.put(SDKConstants.PARAM_DEEP_LINK, (Object) "FRIEND_FINDER");
                DaemonRequest.executeAsync((Context) activityContext, jSONObject, (DaemonRequest.Callback) r2, SDKMessageEnum.OPEN_GAMING_SERVICES_DEEP_LINK);
            } catch (JSONException unused) {
                FacebookCallback facebookCallback = this.mCallback;
                if (facebookCallback != null) {
                    facebookCallback.onError(new FacebookException("Couldn't prepare Friend Finder Dialog"));
                }
            }
        } else {
            startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse("https://fb.gg/me/friendfinder/" + applicationId)), getRequestCode());
        }
    }

    /* access modifiers changed from: protected */
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, final FacebookCallback facebookCallback) {
        this.mCallback = facebookCallback;
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
