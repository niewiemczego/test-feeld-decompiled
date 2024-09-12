package expo.modules.core.interfaces;

import expo.modules.core.ModuleRegistry;

public interface RegistryLifecycleListener {
    void onCreate(ModuleRegistry moduleRegistry) {
    }

    void onDestroy() {
    }
}
