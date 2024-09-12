package com.facebook.reactnative.androidsdk;

import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Locale;

public class FBLoginButtonManager extends SimpleViewManager<RCTLoginButton> {
    public static final String REACT_CLASS = "RCTFBLoginButton";
    private final FBActivityEventListener mActivityEventListener;

    public String getName() {
        return REACT_CLASS;
    }

    public FBLoginButtonManager(ReactApplicationContext reactApplicationContext) {
        FBActivityEventListener fBActivityEventListener = new FBActivityEventListener();
        this.mActivityEventListener = fBActivityEventListener;
        reactApplicationContext.addActivityEventListener(fBActivityEventListener);
    }

    public RCTLoginButton createViewInstance(ThemedReactContext themedReactContext) {
        return new RCTLoginButton(themedReactContext, this.mActivityEventListener.getCallbackManager());
    }

    @ReactProp(name = "loginBehaviorAndroid")
    public void setLoginBehavior(RCTLoginButton rCTLoginButton, String str) {
        LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
        if (str != null) {
            loginBehavior = LoginBehavior.valueOf(str.toUpperCase(Locale.ROOT));
        }
        rCTLoginButton.setLoginBehavior(loginBehavior);
    }

    @ReactProp(name = "defaultAudience")
    public void setDefaultAudience(RCTLoginButton rCTLoginButton, String str) {
        DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
        if (str != null) {
            defaultAudience = DefaultAudience.valueOf(str.toUpperCase(Locale.ROOT));
        }
        rCTLoginButton.setDefaultAudience(defaultAudience);
    }

    @ReactProp(name = "permissions")
    public void setPermissions(RCTLoginButton rCTLoginButton, ReadableArray readableArray) {
        rCTLoginButton.setPermissions(Utility.reactArrayToStringList(readableArray));
    }
}
