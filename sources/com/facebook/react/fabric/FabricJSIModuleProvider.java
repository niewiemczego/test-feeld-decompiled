package com.facebook.react.fabric;

import com.facebook.react.bridge.JSIModuleProvider;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.fabric.events.EventBeatManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.systrace.Systrace;

public class FabricJSIModuleProvider implements JSIModuleProvider<UIManager> {
    private final ComponentFactory mComponentFactory;
    private final ReactNativeConfig mConfig;
    private final CppComponentRegistry mCppComponentRegistry;
    private final ReactApplicationContext mReactApplicationContext;
    private final ViewManagerRegistry mViewManagerRegistry;

    public FabricJSIModuleProvider(ReactApplicationContext reactApplicationContext, ComponentFactory componentFactory, ReactNativeConfig reactNativeConfig, ViewManagerRegistry viewManagerRegistry) {
        this(reactApplicationContext, componentFactory, reactNativeConfig, viewManagerRegistry, (CppComponentRegistry) null);
    }

    public FabricJSIModuleProvider(ReactApplicationContext reactApplicationContext, ComponentFactory componentFactory, ReactNativeConfig reactNativeConfig, ViewManagerRegistry viewManagerRegistry, CppComponentRegistry cppComponentRegistry) {
        this.mReactApplicationContext = reactApplicationContext;
        this.mComponentFactory = componentFactory;
        this.mConfig = reactNativeConfig;
        this.mViewManagerRegistry = viewManagerRegistry;
        this.mCppComponentRegistry = cppComponentRegistry;
    }

    public UIManager get() {
        Systrace.beginSection(0, "FabricJSIModuleProvider.get");
        EventBeatManager eventBeatManager = new EventBeatManager(this.mReactApplicationContext);
        FabricUIManager createUIManager = createUIManager(eventBeatManager);
        Systrace.beginSection(0, "FabricJSIModuleProvider.registerBinding");
        new Binding().register(this.mReactApplicationContext.getCatalystInstance().getRuntimeExecutor(), this.mReactApplicationContext.getCatalystInstance().getRuntimeScheduler(), createUIManager, eventBeatManager, this.mComponentFactory, this.mConfig, this.mCppComponentRegistry);
        Systrace.endSection(0);
        Systrace.endSection(0);
        return createUIManager;
    }

    private FabricUIManager createUIManager(EventBeatManager eventBeatManager) {
        Systrace.beginSection(0, "FabricJSIModuleProvider.createUIManager");
        FabricUIManager fabricUIManager = new FabricUIManager(this.mReactApplicationContext, this.mViewManagerRegistry, eventBeatManager);
        Systrace.endSection(0);
        return fabricUIManager;
    }
}
