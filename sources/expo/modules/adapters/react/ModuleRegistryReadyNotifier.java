package expo.modules.adapters.react;

import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.core.ModuleRegistry;

public class ModuleRegistryReadyNotifier extends BaseJavaModule {
    private ModuleRegistry mModuleRegistry;

    public String getName() {
        return null;
    }

    public ModuleRegistryReadyNotifier(ModuleRegistry moduleRegistry) {
        this.mModuleRegistry = moduleRegistry;
    }

    public void initialize() {
        this.mModuleRegistry.ensureIsInitialized();
    }
}
