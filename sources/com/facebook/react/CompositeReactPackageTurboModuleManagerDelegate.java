package com.facebook.react;

import com.facebook.jni.HybridData;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.turbomodule.core.TurboModuleManagerDelegate;
import com.facebook.soloader.SoLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompositeReactPackageTurboModuleManagerDelegate extends ReactPackageTurboModuleManagerDelegate {
    private static volatile boolean sIsSoLibraryLoaded;
    private final List<TurboModuleManagerDelegate> mDelegates;

    private native void addTurboModuleManagerDelegate(TurboModuleManagerDelegate turboModuleManagerDelegate);

    /* access modifiers changed from: protected */
    public native HybridData initHybrid();

    private CompositeReactPackageTurboModuleManagerDelegate(ReactApplicationContext reactApplicationContext, List<ReactPackage> list, List<TurboModuleManagerDelegate> list2) {
        super(reactApplicationContext, list);
        this.mDelegates = list2;
        for (TurboModuleManagerDelegate addTurboModuleManagerDelegate : list2) {
            addTurboModuleManagerDelegate(addTurboModuleManagerDelegate);
        }
    }

    public static class Builder extends ReactPackageTurboModuleManagerDelegate.Builder {
        private final List<ReactPackageTurboModuleManagerDelegate.Builder> mDelegatesBuilder;

        public Builder(List<ReactPackageTurboModuleManagerDelegate.Builder> list) {
            this.mDelegatesBuilder = list;
        }

        /* access modifiers changed from: protected */
        public ReactPackageTurboModuleManagerDelegate build(ReactApplicationContext reactApplicationContext, List<ReactPackage> list) {
            ArrayList arrayList = new ArrayList();
            for (ReactPackageTurboModuleManagerDelegate.Builder build : this.mDelegatesBuilder) {
                arrayList.add(build.build(reactApplicationContext, Collections.emptyList()));
            }
            return new CompositeReactPackageTurboModuleManagerDelegate(reactApplicationContext, list, arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void maybeLoadOtherSoLibraries() {
        if (!sIsSoLibraryLoaded) {
            SoLoader.loadLibrary("turbomodulejsijni");
            sIsSoLibraryLoaded = true;
        }
    }
}
