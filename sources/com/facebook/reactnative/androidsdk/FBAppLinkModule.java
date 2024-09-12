package com.facebook.reactnative.androidsdk;

import com.facebook.applinks.AppLinkData;
import com.facebook.internal.Utility;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = "FBAppLink")
public class FBAppLinkModule extends ReactContextBaseJavaModule {
    public static final String NAME = "FBAppLink";
    private final ReactApplicationContext mReactContext;

    public String getName() {
        return NAME;
    }

    public FBAppLinkModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mReactContext = reactApplicationContext;
    }

    private AppLinkData.CompletionHandler createCompletionHandler(final Promise promise) {
        return new AppLinkData.CompletionHandler() {
            public void onDeferredAppLinkDataFetched(AppLinkData appLinkData) {
                if (appLinkData == null) {
                    promise.resolve((Object) null);
                } else {
                    promise.resolve(appLinkData.getTargetUri().toString());
                }
            }
        };
    }

    @ReactMethod
    public void fetchDeferredAppLink(Promise promise) {
        try {
            AppLinkData.fetchDeferredAppLinkData(this.mReactContext.getApplicationContext(), createCompletionHandler(promise));
        } catch (Exception e) {
            promise.resolve((Object) null);
            Utility.logd(getName(), "Received error while fetching deferred app link", e);
        }
    }
}
