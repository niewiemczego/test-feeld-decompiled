package expo.modules.core.interfaces;

import android.content.Context;
import expo.modules.core.ExportedModule;
import expo.modules.core.ViewManager;
import java.util.Collections;
import java.util.List;

public interface Package {
    List<? extends InternalModule> createInternalModules(Context context) {
        return Collections.emptyList();
    }

    List<? extends ExportedModule> createExportedModules(Context context) {
        return Collections.emptyList();
    }

    List<? extends ViewManager> createViewManagers(Context context) {
        return Collections.emptyList();
    }

    List<? extends SingletonModule> createSingletonModules(Context context) {
        return Collections.emptyList();
    }

    List<? extends ApplicationLifecycleListener> createApplicationLifecycleListeners(Context context) {
        return Collections.emptyList();
    }

    List<? extends ReactNativeHostHandler> createReactNativeHostHandlers(Context context) {
        return Collections.emptyList();
    }

    List<? extends ReactActivityLifecycleListener> createReactActivityLifecycleListeners(Context context) {
        return Collections.emptyList();
    }

    List<? extends ReactActivityHandler> createReactActivityHandlers(Context context) {
        return Collections.emptyList();
    }
}
