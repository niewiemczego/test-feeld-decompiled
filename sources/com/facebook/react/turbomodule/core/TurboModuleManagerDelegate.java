package com.facebook.react.turbomodule.core;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.CxxModuleWrapper;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.soloader.SoLoader;
import java.util.ArrayList;
import java.util.List;

public abstract class TurboModuleManagerDelegate {
    private static volatile boolean sIsSoLibraryLoaded;
    private final HybridData mHybridData = initHybrid();

    public abstract CxxModuleWrapper getLegacyCxxModule(String str);

    public abstract TurboModule getModule(String str);

    /* access modifiers changed from: protected */
    public abstract HybridData initHybrid();

    protected TurboModuleManagerDelegate() {
        maybeLoadOtherSoLibraries();
        maybeLoadSoLibrary();
    }

    public List<String> getEagerInitModuleNames() {
        return new ArrayList();
    }

    private static synchronized void maybeLoadSoLibrary() {
        synchronized (TurboModuleManagerDelegate.class) {
            if (!sIsSoLibraryLoaded) {
                SoLoader.loadLibrary("turbomodulejsijni");
                sIsSoLibraryLoaded = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void maybeLoadOtherSoLibraries() {
    }
}
