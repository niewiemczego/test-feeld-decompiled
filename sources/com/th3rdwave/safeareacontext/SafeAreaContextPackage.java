package com.th3rdwave.safeareacontext;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ViewManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/th3rdwave/safeareacontext/SafeAreaContextPackage;", "Lcom/facebook/react/TurboReactPackage;", "()V", "createViewManagers", "", "Lcom/facebook/react/uimanager/ViewManager;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "getModule", "Lcom/facebook/react/bridge/NativeModule;", "name", "", "getReactModuleInfoProvider", "Lcom/facebook/react/module/model/ReactModuleInfoProvider;", "react-native-safe-area-context_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SafeAreaContextPackage.kt */
public final class SafeAreaContextPackage extends TurboReactPackage {
    /* access modifiers changed from: private */
    /* renamed from: getReactModuleInfoProvider$lambda-0  reason: not valid java name */
    public static final Map m667getReactModuleInfoProvider$lambda0(Map map) {
        Intrinsics.checkNotNullParameter(map, "$reactModuleInfoMap");
        return map;
    }

    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactContext");
        if (Intrinsics.areEqual((Object) str, (Object) SafeAreaContextModule.NAME)) {
            return new SafeAreaContextModule(reactApplicationContext);
        }
        return null;
    }

    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        Class[] clsArr = {SafeAreaContextModule.class};
        Map hashMap = new HashMap();
        for (int i = 0; i < 1; i++) {
            Class cls = clsArr[i];
            ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
            if (reactModule != null) {
                hashMap.put(reactModule.name(), new ReactModuleInfo(reactModule.name(), cls.getName(), true, reactModule.needsEagerInit(), reactModule.hasConstants(), reactModule.isCxxModule(), false));
            }
        }
        return new SafeAreaContextPackage$$ExternalSyntheticLambda0(hashMap);
    }

    public List<ViewManager<?, ?>> createViewManagers(ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactContext");
        return CollectionsKt.listOf(new SafeAreaProviderManager(), new SafeAreaViewManager());
    }
}
