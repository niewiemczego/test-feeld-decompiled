package com.braze.reactbridge;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/braze/reactbridge/BrazeReactBridgePackage;", "Lcom/facebook/react/TurboReactPackage;", "()V", "getModule", "Lcom/facebook/react/bridge/NativeModule;", "name", "", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "getReactModuleInfoProvider", "Lcom/facebook/react/module/model/ReactModuleInfoProvider;", "braze_react-native-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BrazeReactBridgePackage.kt */
public final class BrazeReactBridgePackage extends TurboReactPackage {
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new BrazeReactBridgePackage$$ExternalSyntheticLambda0();
    }

    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactContext");
        if (Intrinsics.areEqual((Object) str, (Object) BrazeReactBridgeImpl.NAME)) {
            return new BrazeReactBridge(reactApplicationContext);
        }
        NativeModule nativeModule = null;
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: getReactModuleInfoProvider$lambda-0  reason: not valid java name */
    public static final Map m164getReactModuleInfoProvider$lambda0() {
        Map hashMap = new HashMap();
        hashMap.put(BrazeReactBridgeImpl.NAME, new ReactModuleInfo(BrazeReactBridgeImpl.NAME, BrazeReactBridgeImpl.NAME, false, false, true, false, false));
        return hashMap;
    }
}
