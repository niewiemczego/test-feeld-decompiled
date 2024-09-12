package expo.modules.core;

import android.content.Context;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.Package;
import expo.modules.core.interfaces.SingletonModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ModuleRegistryProvider {
    private List<Package> mPackages;

    public ModuleRegistryProvider(List<Package> list) {
        this.mPackages = list;
    }

    /* access modifiers changed from: protected */
    public List<Package> getPackages() {
        return this.mPackages;
    }

    public ModuleRegistry get(Context context) {
        return new ModuleRegistry(createInternalModules(context), createExportedModules(context), createViewManagers(context), createSingletonModules(context));
    }

    public Collection<InternalModule> createInternalModules(Context context) {
        ArrayList arrayList = new ArrayList();
        for (Package createInternalModules : getPackages()) {
            arrayList.addAll(createInternalModules.createInternalModules(context));
        }
        return arrayList;
    }

    public Collection<ExportedModule> createExportedModules(Context context) {
        ArrayList arrayList = new ArrayList();
        for (Package createExportedModules : getPackages()) {
            arrayList.addAll(createExportedModules.createExportedModules(context));
        }
        return arrayList;
    }

    public Collection<ViewManager> createViewManagers(Context context) {
        ArrayList arrayList = new ArrayList();
        for (Package createViewManagers : getPackages()) {
            arrayList.addAll(createViewManagers.createViewManagers(context));
        }
        return arrayList;
    }

    public Collection<SingletonModule> createSingletonModules(Context context) {
        ArrayList arrayList = new ArrayList();
        for (Package createSingletonModules : getPackages()) {
            arrayList.addAll(createSingletonModules.createSingletonModules(context));
        }
        return arrayList;
    }
}
