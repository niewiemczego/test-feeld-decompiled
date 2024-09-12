package expo.modules;

import expo.modules.adapters.react.ReactAdapterPackage;
import expo.modules.application.ApplicationPackage;
import expo.modules.av.AVPackage;
import expo.modules.av.video.VideoViewModule;
import expo.modules.camera.CameraViewModule;
import expo.modules.constants.ConstantsModule;
import expo.modules.constants.ConstantsPackage;
import expo.modules.core.BasePackage;
import expo.modules.core.interfaces.Package;
import expo.modules.filesystem.FileSystemPackage;
import expo.modules.font.FontLoaderPackage;
import expo.modules.image.ExpoImageModule;
import expo.modules.keepawake.KeepAwakePackage;
import expo.modules.kotlin.ModulesProvider;
import expo.modules.kotlin.modules.Module;
import java.util.Arrays;
import java.util.List;

public class ExpoModulesPackageList implements ModulesProvider {

    private static class LazyHolder {
        static final List<Class<? extends Module>> modulesList = Arrays.asList(new Class[]{VideoViewModule.class, CameraViewModule.class, ConstantsModule.class, ExpoImageModule.class});
        static final List<Package> packagesList = Arrays.asList(new Package[]{new ReactAdapterPackage(), new ApplicationPackage(), new AVPackage(), new ConstantsPackage(), new BasePackage(), new FileSystemPackage(), new FontLoaderPackage(), new KeepAwakePackage()});

        private LazyHolder() {
        }
    }

    public static List<Package> getPackageList() {
        return LazyHolder.packagesList;
    }

    public List<Class<? extends Module>> getModulesList() {
        return LazyHolder.modulesList;
    }
}
