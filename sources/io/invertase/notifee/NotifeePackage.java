package io.invertase.notifee;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;

public class NotifeePackage implements ReactPackage {
    @Nonnull
    public List<NativeModule> createNativeModules(@Nonnull ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new NotifeeApiModule(reactApplicationContext));
        return arrayList;
    }

    @Nonnull
    public List<ViewManager> createViewManagers(@Nonnull ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}
