package com.facebook.reactnative.androidsdk;

import com.facebook.gamingservices.GameRequestDialog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.share.model.GameRequestContent;

@ReactModule(name = "FBGameRequestDialog")
public class FBGameRequestDialogModule extends FBSDKCallbackManagerBaseJavaModule {
    public static final String NAME = "FBGameRequestDialog";

    public String getName() {
        return NAME;
    }

    private class GameRequestDialogCallback extends ReactNativeFacebookSDKCallback<GameRequestDialog.Result> {
        public GameRequestDialogCallback(Promise promise) {
            super(promise);
        }

        public void onSuccess(GameRequestDialog.Result result) {
            if (this.mPromise != null) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("requestId", result.getRequestId());
                createMap.putArray("to", Utility.listToReactArray(result.getRequestRecipients()));
                this.mPromise.resolve(createMap);
                this.mPromise = null;
            }
        }
    }

    public FBGameRequestDialogModule(ReactApplicationContext reactApplicationContext, FBActivityEventListener fBActivityEventListener) {
        super(reactApplicationContext, fBActivityEventListener);
    }

    @ReactMethod
    public void canShow(Promise promise) {
        promise.resolve(Boolean.valueOf(GameRequestDialog.canShow()));
    }

    @ReactMethod
    public void show(ReadableMap readableMap, Promise promise) {
        if (getCurrentActivity() != null) {
            GameRequestDialog gameRequestDialog = new GameRequestDialog(getCurrentActivity());
            GameRequestContent buildGameRequestContent = Utility.buildGameRequestContent(readableMap);
            gameRequestDialog.registerCallback(getCallbackManager(), new GameRequestDialogCallback(promise));
            gameRequestDialog.show(buildGameRequestContent);
            return;
        }
        promise.reject("No current activity.");
    }
}
