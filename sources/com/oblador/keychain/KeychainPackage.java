package com.oblador.keychain;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Collections;
import java.util.List;

public class KeychainPackage implements ReactPackage {
    private final KeychainModuleBuilder builder;

    public KeychainPackage() {
        this(new KeychainModuleBuilder());
    }

    public KeychainPackage(KeychainModuleBuilder keychainModuleBuilder) {
        this.builder = keychainModuleBuilder;
    }

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Collections.singletonList(this.builder.withReactContext(reactApplicationContext).build());
    }

    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
