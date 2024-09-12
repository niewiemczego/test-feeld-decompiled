package com.swmansion.rnscreens;

import com.braze.Constants;
import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ViewManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/swmansion/rnscreens/RNScreensPackage;", "Lcom/facebook/react/TurboReactPackage;", "()V", "createViewManagers", "", "Lcom/facebook/react/uimanager/ViewManager;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "getModule", "Lcom/facebook/react/bridge/NativeModule;", "s", "", "reactApplicationContext", "getReactModuleInfoProvider", "Lcom/facebook/react/module/model/ReactModuleInfoProvider;", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RNScreensPackage.kt */
public final class RNScreensPackage extends TurboReactPackage {
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new RNScreensPackage$$ExternalSyntheticLambda0();
    }

    public List<ViewManager<?, ?>> createViewManagers(ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactContext");
        return CollectionsKt.listOf(new ScreenContainerViewManager(), new ScreenViewManager(), new ModalScreenViewManager(), new ScreenStackViewManager(), new ScreenStackHeaderConfigViewManager(), new ScreenStackHeaderSubviewManager(), new SearchBarManager());
    }

    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(str, Constants.BRAZE_PUSH_SUMMARY_TEXT_KEY);
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        if (Intrinsics.areEqual((Object) str, (Object) "RNSModule")) {
            return new ScreensModule(reactApplicationContext);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: getReactModuleInfoProvider$lambda-0  reason: not valid java name */
    public static final Map m648getReactModuleInfoProvider$lambda0() {
        Map hashMap = new HashMap();
        hashMap.put("RNSModule", new ReactModuleInfo("RNSModule", "RNSModule", false, false, true, false, false));
        return hashMap;
    }
}
