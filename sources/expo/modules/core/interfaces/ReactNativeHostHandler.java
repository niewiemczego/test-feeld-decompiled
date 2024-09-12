package expo.modules.core.interfaces;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.ReactApplicationContext;

public interface ReactNativeHostHandler {
    ReactInstanceManager createReactInstanceManager(boolean z) {
        return null;
    }

    String getBundleAssetName(boolean z) {
        return null;
    }

    Object getDevSupportManagerFactory() {
        return null;
    }

    String getJSBundleFile(boolean z) {
        return null;
    }

    JavaScriptExecutorFactory getJavaScriptExecutorFactory() {
        return null;
    }

    Boolean getUseDeveloperSupport() {
        return null;
    }

    void onDidCreateReactInstanceManager(ReactInstanceManager reactInstanceManager, boolean z) {
    }

    void onRegisterJSIModules(ReactApplicationContext reactApplicationContext, JavaScriptContextHolder javaScriptContextHolder, boolean z) {
    }

    void onWillCreateReactInstanceManager(boolean z) {
    }
}
