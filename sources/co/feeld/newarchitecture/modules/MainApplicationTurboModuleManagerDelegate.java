package co.feeld.newarchitecture.modules;

import com.facebook.jni.HybridData;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.soloader.SoLoader;
import java.util.List;

public class MainApplicationTurboModuleManagerDelegate extends ReactPackageTurboModuleManagerDelegate {
    private static volatile boolean sIsSoLibraryLoaded;

    /* access modifiers changed from: package-private */
    public native boolean canCreateTurboModule(String str);

    /* access modifiers changed from: protected */
    public native HybridData initHybrid();

    protected MainApplicationTurboModuleManagerDelegate(ReactApplicationContext reactApplicationContext, List<ReactPackage> list) {
        super(reactApplicationContext, list);
    }

    public static class Builder extends ReactPackageTurboModuleManagerDelegate.Builder {
        /* access modifiers changed from: protected */
        public MainApplicationTurboModuleManagerDelegate build(ReactApplicationContext reactApplicationContext, List<ReactPackage> list) {
            return new MainApplicationTurboModuleManagerDelegate(reactApplicationContext, list);
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void maybeLoadOtherSoLibraries() {
        if (!sIsSoLibraryLoaded) {
            SoLoader.loadLibrary("feeld_appmodules");
            sIsSoLibraryLoaded = true;
        }
    }
}
