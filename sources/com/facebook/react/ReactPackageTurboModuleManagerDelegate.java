package com.facebook.react;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.CxxModuleWrapper;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.turbomodule.core.TurboModuleManagerDelegate;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ReactPackageTurboModuleManagerDelegate extends TurboModuleManagerDelegate {
    private final Map<TurboReactPackage, Map<String, ReactModuleInfo>> mPackageModuleInfos = new HashMap();
    private final List<TurboReactPackage> mPackages = new ArrayList();
    private final ReactApplicationContext mReactApplicationContext;

    protected ReactPackageTurboModuleManagerDelegate(ReactApplicationContext reactApplicationContext, List<ReactPackage> list) {
        this.mReactApplicationContext = reactApplicationContext;
        for (ReactPackage next : list) {
            if (next instanceof TurboReactPackage) {
                TurboReactPackage turboReactPackage = (TurboReactPackage) next;
                this.mPackages.add(turboReactPackage);
                this.mPackageModuleInfos.put(turboReactPackage, turboReactPackage.getReactModuleInfoProvider().getReactModuleInfos());
            }
        }
    }

    public TurboModule getModule(String str) {
        TurboModule resolveModule = resolveModule(str);
        if (resolveModule != null && !(resolveModule instanceof CxxModuleWrapper)) {
            return resolveModule;
        }
        return null;
    }

    public CxxModuleWrapper getLegacyCxxModule(String str) {
        TurboModule resolveModule = resolveModule(str);
        if (resolveModule != null && (resolveModule instanceof CxxModuleWrapper)) {
            return (CxxModuleWrapper) resolveModule;
        }
        return null;
    }

    private TurboModule resolveModule(String str) {
        NativeModule nativeModule = null;
        for (TurboReactPackage next : this.mPackages) {
            try {
                ReactModuleInfo reactModuleInfo = (ReactModuleInfo) this.mPackageModuleInfos.get(next).get(str);
                if (reactModuleInfo != null && reactModuleInfo.isTurboModule()) {
                    if (nativeModule == null || reactModuleInfo.canOverrideExistingModule()) {
                        NativeModule module = next.getModule(str, this.mReactApplicationContext);
                        if (module != null) {
                            nativeModule = module;
                        }
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        if (nativeModule instanceof TurboModule) {
            return (TurboModule) nativeModule;
        }
        return null;
    }

    public List<String> getEagerInitModuleNames() {
        ArrayList arrayList = new ArrayList();
        for (TurboReactPackage reactModuleInfoProvider : this.mPackages) {
            for (ReactModuleInfo next : reactModuleInfoProvider.getReactModuleInfoProvider().getReactModuleInfos().values()) {
                if (next.isTurboModule() && next.needsEagerInit()) {
                    arrayList.add(next.name());
                }
            }
        }
        return arrayList;
    }

    public static abstract class Builder {
        private ReactApplicationContext mContext;
        private List<ReactPackage> mPackages;

        /* access modifiers changed from: protected */
        public abstract ReactPackageTurboModuleManagerDelegate build(ReactApplicationContext reactApplicationContext, List<ReactPackage> list);

        public Builder setPackages(List<ReactPackage> list) {
            this.mPackages = new ArrayList(list);
            return this;
        }

        public Builder setReactApplicationContext(ReactApplicationContext reactApplicationContext) {
            this.mContext = reactApplicationContext;
            return this;
        }

        public ReactPackageTurboModuleManagerDelegate build() {
            Assertions.assertNotNull(this.mContext, "The ReactApplicationContext must be provided to create ReactPackageTurboModuleManagerDelegate");
            Assertions.assertNotNull(this.mPackages, "A set of ReactPackages must be provided to create ReactPackageTurboModuleManagerDelegate");
            return build(this.mContext, this.mPackages);
        }
    }
}
