package com.facebook.react.turbomodule.core;

import com.facebook.infer.annotation.Assertions;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.CxxModuleWrapper;
import com.facebook.react.bridge.JSIModule;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.react.turbomodule.core.interfaces.TurboModuleRegistry;
import com.facebook.soloader.SoLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TurboModuleManager implements JSIModule, TurboModuleRegistry {
    private static volatile boolean sIsSoLibraryLoaded;
    private final TurboModuleProvider mCxxModuleProvider;
    private final List<String> mEagerInitModuleNames;
    private final HybridData mHybridData;
    private final TurboModuleProvider mJavaModuleProvider;
    private final Object mTurboModuleCleanupLock = new Object();
    private boolean mTurboModuleCleanupStarted = false;
    private final Map<String, TurboModuleHolder> mTurboModuleHolders = new HashMap();

    private interface TurboModuleProvider {
        TurboModule getModule(String str);
    }

    private native HybridData initHybrid(RuntimeExecutor runtimeExecutor, CallInvokerHolderImpl callInvokerHolderImpl, CallInvokerHolderImpl callInvokerHolderImpl2, TurboModuleManagerDelegate turboModuleManagerDelegate, boolean z, boolean z2);

    private native void installJSIBindings();

    public void initialize() {
    }

    public TurboModuleManager(RuntimeExecutor runtimeExecutor, final TurboModuleManagerDelegate turboModuleManagerDelegate, CallInvokerHolder callInvokerHolder, CallInvokerHolder callInvokerHolder2) {
        maybeLoadSoLibrary();
        this.mHybridData = initHybrid(runtimeExecutor, (CallInvokerHolderImpl) callInvokerHolder, (CallInvokerHolderImpl) callInvokerHolder2, turboModuleManagerDelegate, ReactFeatureFlags.useGlobalCallbackCleanupScopeUsingRetainJSCallback, ReactFeatureFlags.useTurboModuleManagerCallbackCleanupScope);
        installJSIBindings();
        this.mEagerInitModuleNames = turboModuleManagerDelegate == null ? new ArrayList<>() : turboModuleManagerDelegate.getEagerInitModuleNames();
        this.mJavaModuleProvider = new TurboModuleProvider() {
            public TurboModule getModule(String str) {
                TurboModuleManagerDelegate turboModuleManagerDelegate = turboModuleManagerDelegate;
                if (turboModuleManagerDelegate == null) {
                    return null;
                }
                return turboModuleManagerDelegate.getModule(str);
            }
        };
        this.mCxxModuleProvider = new TurboModuleProvider() {
            public TurboModule getModule(String str) {
                CxxModuleWrapper legacyCxxModule;
                TurboModuleManagerDelegate turboModuleManagerDelegate = turboModuleManagerDelegate;
                if (turboModuleManagerDelegate == null || (legacyCxxModule = turboModuleManagerDelegate.getLegacyCxxModule(str)) == null) {
                    return null;
                }
                Assertions.assertCondition(legacyCxxModule instanceof TurboModule, "CxxModuleWrapper \"" + str + "\" is not a TurboModule");
                return (TurboModule) legacyCxxModule;
            }
        };
    }

    public List<String> getEagerInitModuleNames() {
        return this.mEagerInitModuleNames;
    }

    private CxxModuleWrapper getLegacyCxxModule(String str) {
        TurboModule module = getModule(str);
        if (!(module instanceof CxxModuleWrapper)) {
            return null;
        }
        return (CxxModuleWrapper) module;
    }

    private TurboModule getJavaModule(String str) {
        TurboModule module = getModule(str);
        if (module instanceof CxxModuleWrapper) {
            return null;
        }
        return module;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        com.facebook.react.turbomodule.core.TurboModulePerfLogger.moduleCreateStart(r4, r1.getModuleId());
        r0 = getModule(r4, r1, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        if (r0 == null) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        com.facebook.react.turbomodule.core.TurboModulePerfLogger.moduleCreateEnd(r4, r1.getModuleId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        com.facebook.react.turbomodule.core.TurboModulePerfLogger.moduleCreateFail(r4, r1.getModuleId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.react.turbomodule.core.interfaces.TurboModule getModule(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mTurboModuleCleanupLock
            monitor-enter(r0)
            boolean r1 = r3.mTurboModuleCleanupStarted     // Catch:{ all -> 0x0043 }
            if (r1 == 0) goto L_0x000a
            r4 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            return r4
        L_0x000a:
            java.util.Map<java.lang.String, com.facebook.react.turbomodule.core.TurboModuleManager$TurboModuleHolder> r1 = r3.mTurboModuleHolders     // Catch:{ all -> 0x0043 }
            boolean r1 = r1.containsKey(r4)     // Catch:{ all -> 0x0043 }
            if (r1 != 0) goto L_0x001c
            java.util.Map<java.lang.String, com.facebook.react.turbomodule.core.TurboModuleManager$TurboModuleHolder> r1 = r3.mTurboModuleHolders     // Catch:{ all -> 0x0043 }
            com.facebook.react.turbomodule.core.TurboModuleManager$TurboModuleHolder r2 = new com.facebook.react.turbomodule.core.TurboModuleManager$TurboModuleHolder     // Catch:{ all -> 0x0043 }
            r2.<init>()     // Catch:{ all -> 0x0043 }
            r1.put(r4, r2)     // Catch:{ all -> 0x0043 }
        L_0x001c:
            java.util.Map<java.lang.String, com.facebook.react.turbomodule.core.TurboModuleManager$TurboModuleHolder> r1 = r3.mTurboModuleHolders     // Catch:{ all -> 0x0043 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0043 }
            com.facebook.react.turbomodule.core.TurboModuleManager$TurboModuleHolder r1 = (com.facebook.react.turbomodule.core.TurboModuleManager.TurboModuleHolder) r1     // Catch:{ all -> 0x0043 }
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            int r0 = r1.getModuleId()
            com.facebook.react.turbomodule.core.TurboModulePerfLogger.moduleCreateStart(r4, r0)
            r0 = 1
            com.facebook.react.turbomodule.core.interfaces.TurboModule r0 = r3.getModule(r4, r1, r0)
            if (r0 == 0) goto L_0x003b
            int r1 = r1.getModuleId()
            com.facebook.react.turbomodule.core.TurboModulePerfLogger.moduleCreateEnd(r4, r1)
            goto L_0x0042
        L_0x003b:
            int r1 = r1.getModuleId()
            com.facebook.react.turbomodule.core.TurboModulePerfLogger.moduleCreateFail(r4, r1)
        L_0x0042:
            return r0
        L_0x0043:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.turbomodule.core.TurboModuleManager.getModule(java.lang.String):com.facebook.react.turbomodule.core.interfaces.TurboModule");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r5 == false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        com.facebook.react.turbomodule.core.TurboModulePerfLogger.moduleCreateConstructStart(r3, r4.getModuleId());
        r5 = r2.mJavaModuleProvider.getModule(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        if (r5 != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
        r5 = r2.mCxxModuleProvider.getModule(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
        com.facebook.react.turbomodule.core.TurboModulePerfLogger.moduleCreateConstructEnd(r3, r4.getModuleId());
        com.facebook.react.turbomodule.core.TurboModulePerfLogger.moduleCreateSetUpStart(r3, r4.getModuleId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
        if (r5 == null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r4.setModule(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0050, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0051, code lost:
        r5.initialize();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0058, code lost:
        com.facebook.react.turbomodule.core.TurboModulePerfLogger.moduleCreateSetUpEnd(r3, r4.getModuleId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005f, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r4.endCreatingModule();
        r4.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0066, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0067, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006b, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0070, code lost:
        if (r4.isCreatingModule() == false) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r4.wait();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0076, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0078, code lost:
        if (r1 == false) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0081, code lost:
        r3 = r4.getModule();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0085, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0086, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.react.turbomodule.core.interfaces.TurboModule getModule(java.lang.String r3, com.facebook.react.turbomodule.core.TurboModuleManager.TurboModuleHolder r4, boolean r5) {
        /*
            r2 = this;
            monitor-enter(r4)
            boolean r0 = r4.isDoneCreatingModule()     // Catch:{ all -> 0x008a }
            if (r0 == 0) goto L_0x0016
            if (r5 == 0) goto L_0x0010
            int r5 = r4.getModuleId()     // Catch:{ all -> 0x008a }
            com.facebook.react.turbomodule.core.TurboModulePerfLogger.moduleCreateCacheHit(r3, r5)     // Catch:{ all -> 0x008a }
        L_0x0010:
            com.facebook.react.turbomodule.core.interfaces.TurboModule r3 = r4.getModule()     // Catch:{ all -> 0x008a }
            monitor-exit(r4)     // Catch:{ all -> 0x008a }
            return r3
        L_0x0016:
            boolean r5 = r4.isCreatingModule()     // Catch:{ all -> 0x008a }
            r0 = 1
            r1 = 0
            if (r5 != 0) goto L_0x0023
            r4.startCreatingModule()     // Catch:{ all -> 0x008a }
            r5 = r0
            goto L_0x0024
        L_0x0023:
            r5 = r1
        L_0x0024:
            monitor-exit(r4)     // Catch:{ all -> 0x008a }
            if (r5 == 0) goto L_0x006b
            int r5 = r4.getModuleId()
            com.facebook.react.turbomodule.core.TurboModulePerfLogger.moduleCreateConstructStart(r3, r5)
            com.facebook.react.turbomodule.core.TurboModuleManager$TurboModuleProvider r5 = r2.mJavaModuleProvider
            com.facebook.react.turbomodule.core.interfaces.TurboModule r5 = r5.getModule(r3)
            if (r5 != 0) goto L_0x003c
            com.facebook.react.turbomodule.core.TurboModuleManager$TurboModuleProvider r5 = r2.mCxxModuleProvider
            com.facebook.react.turbomodule.core.interfaces.TurboModule r5 = r5.getModule(r3)
        L_0x003c:
            int r0 = r4.getModuleId()
            com.facebook.react.turbomodule.core.TurboModulePerfLogger.moduleCreateConstructEnd(r3, r0)
            int r0 = r4.getModuleId()
            com.facebook.react.turbomodule.core.TurboModulePerfLogger.moduleCreateSetUpStart(r3, r0)
            if (r5 == 0) goto L_0x0058
            monitor-enter(r4)
            r4.setModule(r5)     // Catch:{ all -> 0x0055 }
            monitor-exit(r4)     // Catch:{ all -> 0x0055 }
            r5.initialize()
            goto L_0x0058
        L_0x0055:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0055 }
            throw r3
        L_0x0058:
            int r0 = r4.getModuleId()
            com.facebook.react.turbomodule.core.TurboModulePerfLogger.moduleCreateSetUpEnd(r3, r0)
            monitor-enter(r4)
            r4.endCreatingModule()     // Catch:{ all -> 0x0068 }
            r4.notifyAll()     // Catch:{ all -> 0x0068 }
            monitor-exit(r4)     // Catch:{ all -> 0x0068 }
            return r5
        L_0x0068:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0068 }
            throw r3
        L_0x006b:
            monitor-enter(r4)
        L_0x006c:
            boolean r3 = r4.isCreatingModule()     // Catch:{ all -> 0x0087 }
            if (r3 == 0) goto L_0x0078
            r4.wait()     // Catch:{ InterruptedException -> 0x0076 }
            goto L_0x006c
        L_0x0076:
            r1 = r0
            goto L_0x006c
        L_0x0078:
            if (r1 == 0) goto L_0x0081
            java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0087 }
            r3.interrupt()     // Catch:{ all -> 0x0087 }
        L_0x0081:
            com.facebook.react.turbomodule.core.interfaces.TurboModule r3 = r4.getModule()     // Catch:{ all -> 0x0087 }
            monitor-exit(r4)     // Catch:{ all -> 0x0087 }
            return r3
        L_0x0087:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0087 }
            throw r3
        L_0x008a:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x008a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.turbomodule.core.TurboModuleManager.getModule(java.lang.String, com.facebook.react.turbomodule.core.TurboModuleManager$TurboModuleHolder, boolean):com.facebook.react.turbomodule.core.interfaces.TurboModule");
    }

    public Collection<TurboModule> getModules() {
        ArrayList<TurboModuleHolder> arrayList = new ArrayList<>();
        synchronized (this.mTurboModuleCleanupLock) {
            arrayList.addAll(this.mTurboModuleHolders.values());
        }
        ArrayList arrayList2 = new ArrayList();
        for (TurboModuleHolder turboModuleHolder : arrayList) {
            synchronized (turboModuleHolder) {
                if (turboModuleHolder.getModule() != null) {
                    arrayList2.add(turboModuleHolder.getModule());
                }
            }
        }
        return arrayList2;
    }

    public boolean hasModule(String str) {
        TurboModuleHolder turboModuleHolder;
        synchronized (this.mTurboModuleCleanupLock) {
            turboModuleHolder = this.mTurboModuleHolders.get(str);
        }
        if (turboModuleHolder == null) {
            return false;
        }
        synchronized (turboModuleHolder) {
            if (turboModuleHolder.getModule() != null) {
                return true;
            }
            return false;
        }
    }

    public void onCatalystInstanceDestroy() {
        synchronized (this.mTurboModuleCleanupLock) {
            this.mTurboModuleCleanupStarted = true;
        }
        for (Map.Entry next : this.mTurboModuleHolders.entrySet()) {
            TurboModule module = getModule((String) next.getKey(), (TurboModuleHolder) next.getValue(), false);
            if (module != null) {
                module.invalidate();
            }
        }
        this.mTurboModuleHolders.clear();
        this.mHybridData.resetNative();
    }

    private static synchronized void maybeLoadSoLibrary() {
        synchronized (TurboModuleManager.class) {
            if (!sIsSoLibraryLoaded) {
                SoLoader.loadLibrary("turbomodulejsijni");
                sIsSoLibraryLoaded = true;
            }
        }
    }

    private static class TurboModuleHolder {
        private static volatile int sHolderCount;
        private volatile boolean mIsDoneCreatingModule = false;
        private volatile boolean mIsTryingToCreate = false;
        private volatile TurboModule mModule = null;
        private volatile int mModuleId = sHolderCount;

        public TurboModuleHolder() {
            sHolderCount++;
        }

        /* access modifiers changed from: package-private */
        public int getModuleId() {
            return this.mModuleId;
        }

        /* access modifiers changed from: package-private */
        public void setModule(TurboModule turboModule) {
            this.mModule = turboModule;
        }

        /* access modifiers changed from: package-private */
        public TurboModule getModule() {
            return this.mModule;
        }

        /* access modifiers changed from: package-private */
        public void startCreatingModule() {
            this.mIsTryingToCreate = true;
        }

        /* access modifiers changed from: package-private */
        public void endCreatingModule() {
            this.mIsTryingToCreate = false;
            this.mIsDoneCreatingModule = true;
        }

        /* access modifiers changed from: package-private */
        public boolean isDoneCreatingModule() {
            return this.mIsDoneCreatingModule;
        }

        /* access modifiers changed from: package-private */
        public boolean isCreatingModule() {
            return this.mIsTryingToCreate;
        }
    }
}
