package com.facebook.react.perflogger;

import com.facebook.jni.HybridData;
import com.facebook.soloader.SoLoader;

public abstract class NativeModulePerfLogger {
    private static volatile boolean sIsSoLibraryLoaded;
    private final HybridData mHybridData = initHybrid();

    /* access modifiers changed from: protected */
    public abstract HybridData initHybrid();

    public abstract void moduleCreateCacheHit(String str, int i);

    public abstract void moduleCreateConstructEnd(String str, int i);

    public abstract void moduleCreateConstructStart(String str, int i);

    public abstract void moduleCreateEnd(String str, int i);

    public abstract void moduleCreateFail(String str, int i);

    public abstract void moduleCreateSetUpEnd(String str, int i);

    public abstract void moduleCreateSetUpStart(String str, int i);

    public abstract void moduleCreateStart(String str, int i);

    public abstract void moduleDataCreateEnd(String str, int i);

    public abstract void moduleDataCreateStart(String str, int i);

    protected NativeModulePerfLogger() {
        maybeLoadOtherSoLibraries();
        maybeLoadSoLibrary();
    }

    private static synchronized void maybeLoadSoLibrary() {
        synchronized (NativeModulePerfLogger.class) {
            if (!sIsSoLibraryLoaded) {
                SoLoader.loadLibrary("reactperfloggerjni");
                sIsSoLibraryLoaded = true;
            }
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void maybeLoadOtherSoLibraries() {
    }
}
