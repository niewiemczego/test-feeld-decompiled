package com.facebook.gamingservices;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.webkit.internal.AssetHelper;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.gamingservices.cloudgaming.CloudGameLoginHandler;
import com.facebook.gamingservices.cloudgaming.DaemonRequest;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKMessageEnum;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CustomTabUtils;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Validate;
import com.facebook.share.internal.GameRequestValidation;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareConstants;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.GameRequestContent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GameRequestDialog extends FacebookDialogBase<GameRequestContent, Result> {
    private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.GameRequest.toRequestCode();
    private static final String GAME_REQUEST_DIALOG = "apprequests";
    /* access modifiers changed from: private */
    public FacebookCallback mCallback;

    public static boolean canShow() {
        return true;
    }

    public static final class Result {
        String requestId;
        List<String> to;

        private Result(Bundle bundle) {
            this.requestId = bundle.getString("request");
            this.to = new ArrayList();
            while (true) {
                if (bundle.containsKey(String.format(ShareConstants.WEB_DIALOG_RESULT_PARAM_TO_ARRAY_MEMBER, new Object[]{Integer.valueOf(this.to.size())}))) {
                    List<String> list = this.to;
                    list.add(bundle.getString(String.format(ShareConstants.WEB_DIALOG_RESULT_PARAM_TO_ARRAY_MEMBER, new Object[]{Integer.valueOf(list.size())})));
                } else {
                    return;
                }
            }
        }

        private Result(GraphResponse graphResponse) {
            try {
                JSONObject jSONObject = graphResponse.getJSONObject();
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                jSONObject = optJSONObject != null ? optJSONObject : jSONObject;
                this.requestId = jSONObject.getString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID);
                this.to = new ArrayList();
                JSONArray jSONArray = jSONObject.getJSONArray("to");
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.to.add(jSONArray.getString(i));
                }
            } catch (JSONException unused) {
                this.requestId = null;
                this.to = new ArrayList();
            }
        }

        public String getRequestId() {
            return this.requestId;
        }

        public List<String> getRequestRecipients() {
            return this.to;
        }
    }

    public static void show(Activity activity, GameRequestContent gameRequestContent) {
        new GameRequestDialog(activity).show(gameRequestContent);
    }

    public static void show(Fragment fragment, GameRequestContent gameRequestContent) {
        show(new FragmentWrapper(fragment), gameRequestContent);
    }

    public static void show(android.app.Fragment fragment, GameRequestContent gameRequestContent) {
        show(new FragmentWrapper(fragment), gameRequestContent);
    }

    private static void show(FragmentWrapper fragmentWrapper, GameRequestContent gameRequestContent) {
        new GameRequestDialog(fragmentWrapper).show(gameRequestContent);
    }

    public GameRequestDialog(Activity activity) {
        super(activity, DEFAULT_REQUEST_CODE);
    }

    public GameRequestDialog(Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    public GameRequestDialog(android.app.Fragment fragment) {
        this(new FragmentWrapper(fragment));
    }

    private GameRequestDialog(FragmentWrapper fragmentWrapper) {
        super(fragmentWrapper, DEFAULT_REQUEST_CODE);
    }

    /* access modifiers changed from: protected */
    public void registerCallbackImpl(CallbackManagerImpl callbackManagerImpl, final FacebookCallback<Result> facebookCallback) {
        final AnonymousClass1 r4;
        this.mCallback = facebookCallback;
        if (facebookCallback == null) {
            r4 = null;
        } else {
            r4 = new ResultProcessor(facebookCallback) {
                public void onSuccess(AppCall appCall, Bundle bundle) {
                    if (bundle != null) {
                        facebookCallback.onSuccess(new Result(bundle));
                    } else {
                        onCancel(appCall);
                    }
                }
            };
        }
        callbackManagerImpl.registerCallback(getRequestCode(), new CallbackManagerImpl.Callback() {
            public boolean onActivityResult(int i, Intent intent) {
                return ShareInternalUtility.handleActivityResult(GameRequestDialog.this.getRequestCode(), i, intent, r4);
            }
        });
    }

    /* access modifiers changed from: protected */
    public AppCall createBaseAppCall() {
        return new AppCall(getRequestCode());
    }

    /* access modifiers changed from: protected */
    public List<FacebookDialogBase<GameRequestContent, Result>.ModeHandler> getOrderedModeHandlers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FacebookAppHandler());
        arrayList.add(new ChromeCustomTabHandler());
        arrayList.add(new WebHandler());
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void showImpl(GameRequestContent gameRequestContent, Object obj) {
        if (CloudGameLoginHandler.isRunningInCloud()) {
            showForCloud(gameRequestContent, obj);
        } else {
            super.showImpl(gameRequestContent, obj);
        }
    }

    private void showForCloud(GameRequestContent gameRequestContent, Object obj) {
        Activity activityContext = getActivityContext();
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.isExpired()) {
            throw new FacebookException("Attempted to open GameRequestDialog with an invalid access token");
        }
        AnonymousClass3 r1 = new DaemonRequest.Callback() {
            public void onCompleted(GraphResponse graphResponse) {
                if (GameRequestDialog.this.mCallback == null) {
                    return;
                }
                if (graphResponse.getError() != null) {
                    GameRequestDialog.this.mCallback.onError(new FacebookException(graphResponse.getError().getErrorMessage()));
                } else {
                    GameRequestDialog.this.mCallback.onSuccess(new Result(graphResponse));
                }
            }
        };
        String applicationId = currentAccessToken.getApplicationId();
        String name = gameRequestContent.getActionType() != null ? gameRequestContent.getActionType().name() : null;
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            jSONObject.put(SDKConstants.PARAM_APP_ID, (Object) applicationId);
            jSONObject.put(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, (Object) name);
            jSONObject.put("message", (Object) gameRequestContent.getMessage());
            jSONObject.put(SDKConstants.PARAM_GAME_REQUESTS_CTA, (Object) gameRequestContent.getCta());
            jSONObject.put("title", (Object) gameRequestContent.getTitle());
            jSONObject.put("data", (Object) gameRequestContent.getData());
            jSONObject.put(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, (Object) gameRequestContent.getFilters());
            if (gameRequestContent.getRecipients() != null) {
                for (String put : gameRequestContent.getRecipients()) {
                    jSONArray.put((Object) put);
                }
            }
            jSONObject.put("to", (Object) jSONArray);
            DaemonRequest.executeAsync((Context) activityContext, jSONObject, (DaemonRequest.Callback) r1, SDKMessageEnum.OPEN_GAME_REQUESTS_DIALOG);
        } catch (JSONException unused) {
            FacebookCallback facebookCallback = this.mCallback;
            if (facebookCallback != null) {
                facebookCallback.onError(new FacebookException("Couldn't prepare Game Request Dialog"));
            }
        }
    }

    private class ChromeCustomTabHandler extends FacebookDialogBase<GameRequestContent, Result>.ModeHandler {
        private ChromeCustomTabHandler() {
            super(GameRequestDialog.this);
        }

        public boolean canShow(GameRequestContent gameRequestContent, boolean z) {
            return CustomTabUtils.getChromePackage() != null && Validate.hasCustomTabRedirectActivity(GameRequestDialog.this.getActivityContext(), CustomTabUtils.getDefaultRedirectURI());
        }

        public AppCall createAppCall(GameRequestContent gameRequestContent) {
            GameRequestValidation.validate(gameRequestContent);
            AppCall createBaseAppCall = GameRequestDialog.this.createBaseAppCall();
            Bundle create = WebDialogParameters.create(gameRequestContent);
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            if (currentAccessToken != null) {
                create.putString("app_id", currentAccessToken.getApplicationId());
            } else {
                create.putString("app_id", FacebookSdk.getApplicationId());
            }
            create.putString(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, CustomTabUtils.getDefaultRedirectURI());
            DialogPresenter.setupAppCallForCustomTabDialog(createBaseAppCall, GameRequestDialog.GAME_REQUEST_DIALOG, create);
            return createBaseAppCall;
        }
    }

    private class WebHandler extends FacebookDialogBase<GameRequestContent, Result>.ModeHandler {
        public boolean canShow(GameRequestContent gameRequestContent, boolean z) {
            return true;
        }

        private WebHandler() {
            super(GameRequestDialog.this);
        }

        public AppCall createAppCall(GameRequestContent gameRequestContent) {
            GameRequestValidation.validate(gameRequestContent);
            AppCall createBaseAppCall = GameRequestDialog.this.createBaseAppCall();
            DialogPresenter.setupAppCallForWebDialog(createBaseAppCall, GameRequestDialog.GAME_REQUEST_DIALOG, WebDialogParameters.create(gameRequestContent));
            return createBaseAppCall;
        }
    }

    private class FacebookAppHandler extends FacebookDialogBase<GameRequestContent, Result>.ModeHandler {
        private FacebookAppHandler() {
            super(GameRequestDialog.this);
        }

        public boolean canShow(GameRequestContent gameRequestContent, boolean z) {
            PackageManager packageManager = GameRequestDialog.this.getActivityContext().getPackageManager();
            Intent intent = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
            boolean z2 = intent.resolveActivity(packageManager) != null;
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            boolean z3 = (currentAccessToken == null || currentAccessToken.getGraphDomain() == null || !FacebookSdk.GAMING.equals(currentAccessToken.getGraphDomain())) ? false : true;
            if (!z2 || !z3) {
                return false;
            }
            return true;
        }

        public AppCall createAppCall(GameRequestContent gameRequestContent) {
            AppCall createBaseAppCall = GameRequestDialog.this.createBaseAppCall();
            Intent intent = new Intent("com.facebook.games.gaming_services.DEEPLINK");
            intent.setType(AssetHelper.DEFAULT_MIME_TYPE);
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            Bundle bundle = new Bundle();
            bundle.putString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, "GAME_REQUESTS");
            if (currentAccessToken != null) {
                bundle.putString("app_id", currentAccessToken.getApplicationId());
            } else {
                bundle.putString("app_id", FacebookSdk.getApplicationId());
            }
            bundle.putString(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, gameRequestContent.getActionType() != null ? gameRequestContent.getActionType().name() : null);
            bundle.putString("message", gameRequestContent.getMessage());
            bundle.putString("title", gameRequestContent.getTitle());
            bundle.putString("data", gameRequestContent.getData());
            bundle.putString(SDKConstants.PARAM_GAME_REQUESTS_CTA, gameRequestContent.getCta());
            gameRequestContent.getRecipients();
            JSONArray jSONArray = new JSONArray();
            if (gameRequestContent.getRecipients() != null) {
                for (String put : gameRequestContent.getRecipients()) {
                    jSONArray.put((Object) put);
                }
            }
            bundle.putString("to", jSONArray.toString());
            NativeProtocol.setupProtocolRequestIntent(intent, createBaseAppCall.getCallId().toString(), "", NativeProtocol.getLatestKnownVersion(), bundle);
            createBaseAppCall.setRequestIntent(intent);
            return createBaseAppCall;
        }
    }
}
