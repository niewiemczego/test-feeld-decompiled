package com.facebook.reactnative.androidsdk;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import java.util.Set;

public class RCTLoginButton extends LoginButton {
    private final CallbackManager mCallbackManager;

    public RCTLoginButton(ThemedReactContext themedReactContext, CallbackManager callbackManager) {
        super(themedReactContext);
        setToolTipMode(LoginButton.ToolTipMode.NEVER_DISPLAY);
        this.mCallbackManager = callbackManager;
        init();
    }

    public void init() {
        new AccessTokenTracker() {
            /* access modifiers changed from: protected */
            public void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
                if (accessToken2 == null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("type", "logoutFinished");
                    ((RCTEventEmitter) ((ReactContext) RCTLoginButton.this.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(RCTLoginButton.this.getId(), "topChange", createMap);
                }
            }
        };
        registerCallback(this.mCallbackManager, new FacebookCallback<LoginResult>() {
            public void onSuccess(LoginResult loginResult) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("type", "loginFinished");
                createMap.putString("error", (String) null);
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putBoolean("isCancelled", false);
                createMap2.putArray("grantedPermissions", Arguments.fromJavaArgs(RCTLoginButton.this.setToStringArray(loginResult.getRecentlyGrantedPermissions())));
                createMap2.putArray(SDKConstants.PARAM_DECLINED_PERMISSIONS, Arguments.fromJavaArgs(RCTLoginButton.this.setToStringArray(loginResult.getRecentlyDeniedPermissions())));
                createMap.putMap("result", createMap2);
                ((RCTEventEmitter) ((ReactContext) RCTLoginButton.this.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(RCTLoginButton.this.getId(), "topChange", createMap);
            }

            public void onError(FacebookException facebookException) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("type", "loginFinished");
                createMap.putString("error", facebookException.toString());
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putBoolean("isCancelled", false);
                createMap.putMap("result", createMap2);
                ((RCTEventEmitter) ((ReactContext) RCTLoginButton.this.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(RCTLoginButton.this.getId(), "topChange", createMap);
            }

            public void onCancel() {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("type", "loginFinished");
                createMap.putString("error", (String) null);
                WritableMap createMap2 = Arguments.createMap();
                createMap2.putBoolean("isCancelled", true);
                createMap.putMap("result", createMap2);
                ((RCTEventEmitter) ((ReactContext) RCTLoginButton.this.getContext()).getJSModule(RCTEventEmitter.class)).receiveEvent(RCTLoginButton.this.getId(), "topChange", createMap);
            }
        });
    }

    /* access modifiers changed from: private */
    public String[] setToStringArray(Set<String> set) {
        String[] strArr = new String[set.size()];
        int i = 0;
        for (String str : set) {
            strArr[i] = str;
            i++;
        }
        return strArr;
    }
}
