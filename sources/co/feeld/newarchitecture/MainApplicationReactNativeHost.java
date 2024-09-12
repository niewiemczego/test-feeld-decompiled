package co.feeld.newarchitecture;

import android.app.Application;
import co.feeld.newarchitecture.components.MainComponentsRegistry;
import co.feeld.newarchitecture.modules.MainApplicationTurboModuleManagerDelegate;
import com.facebook.react.PackageList;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.react.bridge.JSIModuleProvider;
import com.facebook.react.bridge.JSIModuleSpec;
import com.facebook.react.bridge.JSIModuleType;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.fabric.ComponentFactory;
import com.facebook.react.fabric.CoreComponentsRegistry;
import com.facebook.react.fabric.FabricJSIModuleProvider;
import com.facebook.react.fabric.ReactNativeConfig;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;

public class MainApplicationReactNativeHost extends ReactNativeHost {
    /* access modifiers changed from: protected */
    public String getJSMainModuleName() {
        return FirebaseAnalytics.Param.INDEX;
    }

    public boolean getUseDeveloperSupport() {
        return false;
    }

    public MainApplicationReactNativeHost(Application application) {
        super(application);
    }

    /* access modifiers changed from: protected */
    public List<ReactPackage> getPackages() {
        return new PackageList((ReactNativeHost) this).getPackages();
    }

    /* access modifiers changed from: protected */
    public ReactPackageTurboModuleManagerDelegate.Builder getReactPackageTurboModuleManagerDelegateBuilder() {
        return new MainApplicationTurboModuleManagerDelegate.Builder();
    }

    /* access modifiers changed from: protected */
    public JSIModulePackage getJSIModulePackage() {
        return new JSIModulePackage() {
            public List<JSIModuleSpec> getJSIModules(final ReactApplicationContext reactApplicationContext, JavaScriptContextHolder javaScriptContextHolder) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new JSIModuleSpec() {
                    public JSIModuleType getJSIModuleType() {
                        return JSIModuleType.UIManager;
                    }

                    public JSIModuleProvider<UIManager> getJSIModuleProvider() {
                        ComponentFactory componentFactory = new ComponentFactory();
                        CoreComponentsRegistry.register(componentFactory);
                        MainComponentsRegistry.register(componentFactory);
                        return new FabricJSIModuleProvider(reactApplicationContext, componentFactory, ReactNativeConfig.DEFAULT_CONFIG, new ViewManagerRegistry(MainApplicationReactNativeHost.this.getReactInstanceManager().getOrCreateViewManagers(reactApplicationContext)));
                    }
                });
                return arrayList;
            }
        };
    }
}
