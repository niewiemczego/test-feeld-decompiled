package com.ReactNativeBlobUtil;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.HashMap;
import java.util.Map;

public class ReactNativeBlobUtilPackage extends TurboReactPackage {
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals(ReactNativeBlobUtilImpl.NAME)) {
            return new ReactNativeBlobUtil(reactApplicationContext);
        }
        return null;
    }

    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactNativeBlobUtilPackage$$ExternalSyntheticLambda0();
    }

    static /* synthetic */ Map lambda$getReactModuleInfoProvider$0() {
        HashMap hashMap = new HashMap();
        hashMap.put(ReactNativeBlobUtilImpl.NAME, new ReactModuleInfo(ReactNativeBlobUtilImpl.NAME, ReactNativeBlobUtilImpl.NAME, false, false, true, false, false));
        return hashMap;
    }
}
