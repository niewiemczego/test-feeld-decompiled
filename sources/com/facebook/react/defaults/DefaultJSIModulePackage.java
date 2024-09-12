package com.facebook.react.defaults;

import com.facebook.react.ReactNativeHost;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.react.bridge.JSIModuleProvider;
import com.facebook.react.bridge.JSIModuleSpec;
import com.facebook.react.bridge.JSIModuleType;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.fabric.ComponentFactory;
import com.facebook.react.fabric.FabricJSIModuleProvider;
import com.facebook.react.fabric.ReactNativeConfig;
import com.facebook.react.uimanager.ViewManagerRegistry;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/react/defaults/DefaultJSIModulePackage;", "Lcom/facebook/react/bridge/JSIModulePackage;", "reactNativeHost", "Lcom/facebook/react/ReactNativeHost;", "(Lcom/facebook/react/ReactNativeHost;)V", "getJSIModules", "", "Lcom/facebook/react/bridge/JSIModuleSpec;", "Lcom/facebook/react/bridge/UIManager;", "reactApplicationContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "jsContext", "Lcom/facebook/react/bridge/JavaScriptContextHolder;", "JSIModuleForFabric", "ReactAndroid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultJSIModulePackage.kt */
public final class DefaultJSIModulePackage implements JSIModulePackage {
    private final ReactNativeHost reactNativeHost;

    public DefaultJSIModulePackage(ReactNativeHost reactNativeHost2) {
        Intrinsics.checkNotNullParameter(reactNativeHost2, "reactNativeHost");
        this.reactNativeHost = reactNativeHost2;
    }

    public List<JSIModuleSpec<UIManager>> getJSIModules(ReactApplicationContext reactApplicationContext, JavaScriptContextHolder javaScriptContextHolder) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        Intrinsics.checkNotNullParameter(javaScriptContextHolder, "jsContext");
        return CollectionsKt.listOf(new JSIModuleForFabric(this, reactApplicationContext, this.reactNativeHost));
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/react/defaults/DefaultJSIModulePackage$JSIModuleForFabric;", "Lcom/facebook/react/bridge/JSIModuleSpec;", "Lcom/facebook/react/bridge/UIManager;", "reactApplicationContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "reactNativeHost", "Lcom/facebook/react/ReactNativeHost;", "(Lcom/facebook/react/defaults/DefaultJSIModulePackage;Lcom/facebook/react/bridge/ReactApplicationContext;Lcom/facebook/react/ReactNativeHost;)V", "getJSIModuleProvider", "Lcom/facebook/react/bridge/JSIModuleProvider;", "getJSIModuleType", "Lcom/facebook/react/bridge/JSIModuleType;", "ReactAndroid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultJSIModulePackage.kt */
    private final class JSIModuleForFabric implements JSIModuleSpec<UIManager> {
        private final ReactApplicationContext reactApplicationContext;
        private final ReactNativeHost reactNativeHost;
        final /* synthetic */ DefaultJSIModulePackage this$0;

        public JSIModuleForFabric(DefaultJSIModulePackage defaultJSIModulePackage, ReactApplicationContext reactApplicationContext2, ReactNativeHost reactNativeHost2) {
            Intrinsics.checkNotNullParameter(defaultJSIModulePackage, "this$0");
            Intrinsics.checkNotNullParameter(reactApplicationContext2, "reactApplicationContext");
            Intrinsics.checkNotNullParameter(reactNativeHost2, "reactNativeHost");
            this.this$0 = defaultJSIModulePackage;
            this.reactApplicationContext = reactApplicationContext2;
            this.reactNativeHost = reactNativeHost2;
        }

        public JSIModuleType getJSIModuleType() {
            return JSIModuleType.UIManager;
        }

        public JSIModuleProvider<UIManager> getJSIModuleProvider() {
            ComponentFactory componentFactory = new ComponentFactory();
            DefaultComponentsRegistry.Companion.register(componentFactory);
            return new FabricJSIModuleProvider(this.reactApplicationContext, componentFactory, ReactNativeConfig.DEFAULT_CONFIG, new ViewManagerRegistry(this.reactNativeHost.getReactInstanceManager().getOrCreateViewManagers(this.reactApplicationContext)));
        }
    }
}
