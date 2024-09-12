package expo.modules.core;

import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.RegistryLifecycleListener;
import expo.modules.core.interfaces.SingletonModule;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModuleRegistry {
    private final Map<Class, ExportedModule> mExportedModulesByClassMap = new HashMap();
    private final Map<String, ExportedModule> mExportedModulesMap = new HashMap();
    private final List<WeakReference<RegistryLifecycleListener>> mExtraRegistryLifecycleListeners = new ArrayList();
    private final Map<Class, InternalModule> mInternalModulesMap = new HashMap();
    private volatile boolean mIsInitialized = false;
    private final Map<String, SingletonModule> mSingletonModulesMap = new HashMap();
    private final Map<String, ViewManager> mViewManagersMap = new HashMap();

    public ModuleRegistry(Collection<InternalModule> collection, Collection<ExportedModule> collection2, Collection<ViewManager> collection3, Collection<SingletonModule> collection4) {
        for (InternalModule registerInternalModule : collection) {
            registerInternalModule(registerInternalModule);
        }
        for (ExportedModule registerExportedModule : collection2) {
            registerExportedModule(registerExportedModule);
        }
        for (ViewManager registerViewManager : collection3) {
            registerViewManager(registerViewManager);
        }
        for (SingletonModule registerSingletonModule : collection4) {
            registerSingletonModule(registerSingletonModule);
        }
    }

    public <T> T getModule(Class<T> cls) {
        return this.mInternalModulesMap.get(cls);
    }

    public ExportedModule getExportedModule(String str) {
        return this.mExportedModulesMap.get(str);
    }

    public ExportedModule getExportedModuleOfClass(Class cls) {
        return this.mExportedModulesByClassMap.get(cls);
    }

    public Collection<ViewManager> getAllViewManagers() {
        return this.mViewManagersMap.values();
    }

    public Collection<ExportedModule> getAllExportedModules() {
        return this.mExportedModulesMap.values();
    }

    public <T> T getSingletonModule(String str, Class<T> cls) {
        return this.mSingletonModulesMap.get(str);
    }

    public void registerInternalModule(InternalModule internalModule) {
        for (Class put : internalModule.getExportedInterfaces()) {
            this.mInternalModulesMap.put(put, internalModule);
        }
    }

    public InternalModule unregisterInternalModule(Class cls) {
        return this.mInternalModulesMap.remove(cls);
    }

    public void registerExportedModule(ExportedModule exportedModule) {
        this.mExportedModulesMap.put(exportedModule.getName(), exportedModule);
        this.mExportedModulesByClassMap.put(exportedModule.getClass(), exportedModule);
    }

    public void registerViewManager(ViewManager viewManager) {
        this.mViewManagersMap.put(viewManager.getName(), viewManager);
    }

    public void registerSingletonModule(SingletonModule singletonModule) {
        this.mSingletonModulesMap.put(singletonModule.getName(), singletonModule);
    }

    public void registerExtraListener(RegistryLifecycleListener registryLifecycleListener) {
        this.mExtraRegistryLifecycleListeners.add(new WeakReference(registryLifecycleListener));
    }

    public synchronized void ensureIsInitialized() {
        if (!this.mIsInitialized) {
            initialize();
            this.mIsInitialized = true;
        }
    }

    public void initialize() {
        ArrayList<RegistryLifecycleListener> arrayList = new ArrayList<>();
        arrayList.addAll(this.mExportedModulesMap.values());
        arrayList.addAll(this.mInternalModulesMap.values());
        arrayList.addAll(this.mViewManagersMap.values());
        for (WeakReference next : this.mExtraRegistryLifecycleListeners) {
            if (next.get() != null) {
                arrayList.add((RegistryLifecycleListener) next.get());
            }
        }
        for (RegistryLifecycleListener onCreate : arrayList) {
            onCreate.onCreate(this);
        }
    }

    public void onDestroy() {
        ArrayList<RegistryLifecycleListener> arrayList = new ArrayList<>();
        arrayList.addAll(this.mExportedModulesMap.values());
        arrayList.addAll(this.mInternalModulesMap.values());
        arrayList.addAll(this.mViewManagersMap.values());
        for (WeakReference next : this.mExtraRegistryLifecycleListeners) {
            if (next.get() != null) {
                arrayList.add((RegistryLifecycleListener) next.get());
            }
        }
        for (RegistryLifecycleListener onDestroy : arrayList) {
            onDestroy.onDestroy();
        }
    }
}
