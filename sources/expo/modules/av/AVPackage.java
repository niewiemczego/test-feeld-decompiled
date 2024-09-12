package expo.modules.av;

import android.content.Context;
import expo.modules.av.player.datasource.SharedCookiesDataSourceFactoryProvider;
import expo.modules.core.BasePackage;
import expo.modules.core.ExportedModule;
import expo.modules.core.ViewManager;
import expo.modules.core.interfaces.InternalModule;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AVPackage extends BasePackage {
    public List<InternalModule> createInternalModules(Context context) {
        return Arrays.asList(new InternalModule[]{new AVManager(context), new SharedCookiesDataSourceFactoryProvider()});
    }

    public List<ExportedModule> createExportedModules(Context context) {
        return Arrays.asList(new ExportedModule[]{new AVModule(context)});
    }

    public List<ViewManager> createViewManagers(Context context) {
        return Collections.emptyList();
    }
}
