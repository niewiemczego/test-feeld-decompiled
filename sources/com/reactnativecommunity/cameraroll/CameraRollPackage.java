package com.reactnativecommunity.cameraroll;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.ViewManagerOnDemandReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CameraRollPackage extends TurboReactPackage implements ViewManagerOnDemandReactPackage {
    @Nullable
    public ViewManager createViewManager(ReactApplicationContext reactApplicationContext, String str) {
        return null;
    }

    public List<String> getViewManagerNames(ReactApplicationContext reactApplicationContext) {
        return null;
    }

    /* access modifiers changed from: protected */
    public List<ModuleSpec> getViewManagers(ReactApplicationContext reactApplicationContext) {
        return null;
    }

    public NativeModule getModule(String str, @Nonnull ReactApplicationContext reactApplicationContext) {
        str.hashCode();
        if (!str.equals(CameraRollModule.NAME)) {
            return null;
        }
        return new CameraRollModule(reactApplicationContext);
    }

    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        try {
            return (ReactModuleInfoProvider) Class.forName("com.reactnativecommunity.cameraroll.CameraRollPackage$$ReactModuleInfoProvider").newInstance();
        } catch (ClassNotFoundException unused) {
            return new ReactModuleInfoProvider() {
                public Map<String, ReactModuleInfo> getReactModuleInfos() {
                    HashMap hashMap = new HashMap();
                    Class[] clsArr = {CameraRollModule.class};
                    for (int i = 0; i < 1; i++) {
                        Class cls = clsArr[i];
                        ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
                        hashMap.put(reactModule.name(), new ReactModuleInfo(reactModule.name(), cls.getName(), reactModule.canOverrideExistingModule(), reactModule.needsEagerInit(), reactModule.hasConstants(), reactModule.isCxxModule(), TurboModule.class.isAssignableFrom(cls)));
                    }
                    return hashMap;
                }
            };
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException("No ReactModuleInfoProvider for com.reactnativecommunity.cameraroll.CameraRollPackage$$ReactModuleInfoProvider", e);
        }
    }

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new NativeModule[]{new CameraRollModule(reactApplicationContext)});
    }

    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
