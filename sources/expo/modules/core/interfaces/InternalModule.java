package expo.modules.core.interfaces;

import java.util.List;

public interface InternalModule extends RegistryLifecycleListener {
    List<? extends Class> getExportedInterfaces();
}
