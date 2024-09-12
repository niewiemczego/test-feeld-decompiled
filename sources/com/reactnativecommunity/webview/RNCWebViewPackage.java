package com.reactnativecommunity.webview;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RNCWebViewPackage extends TurboReactPackage {
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RNCWebViewManager());
        return arrayList;
    }

    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new RNCWebViewPackage$$ExternalSyntheticLambda0();
    }

    static /* synthetic */ Map lambda$getReactModuleInfoProvider$0() {
        HashMap hashMap = new HashMap();
        hashMap.put("RNCWebView", new ReactModuleInfo("RNCWebView", "RNCWebView", false, false, true, false, false));
        return hashMap;
    }

    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals("RNCWebView")) {
            return new RNCWebViewModule(reactApplicationContext);
        }
        return null;
    }
}
