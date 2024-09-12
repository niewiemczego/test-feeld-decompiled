package co.feeld;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.braze.BrazeActivityLifecycleCallbackListener;
import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.defaults.DefaultReactNativeHost;
import com.facebook.soloader.SoLoader;
import com.google.firebase.analytics.FirebaseAnalytics;
import expo.modules.ApplicationLifecycleDispatcher;
import expo.modules.ReactNativeHostWrapper;
import java.util.ArrayList;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {
    private final ReactNativeHost mReactNativeHost = new ReactNativeHostWrapper(this, new DefaultReactNativeHost(this) {
        /* access modifiers changed from: protected */
        public String getJSMainModuleName() {
            return FirebaseAnalytics.Param.INDEX;
        }

        public boolean getUseDeveloperSupport() {
            return false;
        }

        /* access modifiers changed from: protected */
        public boolean isNewArchEnabled() {
            return false;
        }

        /* access modifiers changed from: protected */
        public List<ReactPackage> getPackages() {
            ArrayList<ReactPackage> packages = new PackageList((ReactNativeHost) this).getPackages();
            packages.add(new ChangeIconPackage());
            packages.add(new PreventScreenshotPackage());
            return packages;
        }

        /* access modifiers changed from: protected */
        public Boolean isHermesEnabled() {
            return true;
        }
    });

    private static void initializeFlipper(Context context, ReactInstanceManager reactInstanceManager) {
    }

    public ReactNativeHost getReactNativeHost() {
        return this.mReactNativeHost;
    }

    public void onCreate() {
        super.onCreate();
        SoLoader.init((Context) this, false);
        initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
        registerActivityLifecycleCallbacks(new BrazeActivityLifecycleCallbackListener());
        ApplicationLifecycleDispatcher.onApplicationCreate(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ApplicationLifecycleDispatcher.onConfigurationChanged(this, configuration);
    }
}
