package expo.modules.adapters.react;

import com.facebook.react.ReactPackage;
import expo.modules.core.interfaces.InternalModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ReactPackagesProvider implements InternalModule {
    private Collection<ReactPackage> mReactPackages = new ArrayList();

    public List<? extends Class> getExportedInterfaces() {
        return Collections.singletonList(ReactPackagesProvider.class);
    }

    public void addPackage(ReactPackage reactPackage) {
        this.mReactPackages.add(reactPackage);
    }

    public Collection<ReactPackage> getReactPackages() {
        return this.mReactPackages;
    }
}
