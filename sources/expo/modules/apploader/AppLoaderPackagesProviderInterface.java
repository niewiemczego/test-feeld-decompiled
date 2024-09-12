package expo.modules.apploader;

import expo.modules.core.interfaces.Package;
import java.util.List;

public interface AppLoaderPackagesProviderInterface<ReactPackageType> {
    List<Package> getExpoPackages();

    List<ReactPackageType> getPackages();
}
