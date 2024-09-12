package expo.modules;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import expo.modules.adapters.react.ModuleRegistryAdapter;
import expo.modules.core.interfaces.Package;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001e\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\r0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lexpo/modules/ExpoModulesPackage;", "Lcom/facebook/react/ReactPackage;", "()V", "moduleRegistryAdapter", "Lexpo/modules/adapters/react/ModuleRegistryAdapter;", "getModuleRegistryAdapter", "()Lexpo/modules/adapters/react/ModuleRegistryAdapter;", "createNativeModules", "", "Lcom/facebook/react/bridge/NativeModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "createViewManagers", "Lcom/facebook/react/uimanager/ViewManager;", "Companion", "expo_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoModulesPackage.kt */
public final class ExpoModulesPackage implements ReactPackage {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<List<Package>> packageList$delegate = LazyKt.lazy(ExpoModulesPackage$Companion$packageList$2.INSTANCE);
    private final ModuleRegistryAdapter moduleRegistryAdapter = new ModuleRegistryAdapter(Companion.getPackageList());

    public final ModuleRegistryAdapter getModuleRegistryAdapter() {
        return this.moduleRegistryAdapter;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048FX\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lexpo/modules/ExpoModulesPackage$Companion;", "", "()V", "packageList", "", "Lexpo/modules/core/interfaces/Package;", "getPackageList$annotations", "getPackageList", "()Ljava/util/List;", "packageList$delegate", "Lkotlin/Lazy;", "expo_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ExpoModulesPackage.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getPackageList$annotations() {
        }

        private Companion() {
        }

        public final List<Package> getPackageList() {
            return (List) ExpoModulesPackage.packageList$delegate.getValue();
        }
    }

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactContext");
        List<NativeModule> createNativeModules = this.moduleRegistryAdapter.createNativeModules(reactApplicationContext);
        Intrinsics.checkNotNullExpressionValue(createNativeModules, "moduleRegistryAdapter.cr…tiveModules(reactContext)");
        return createNativeModules;
    }

    public List<ViewManager<?, ?>> createViewManagers(ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactContext");
        List<ViewManager> createViewManagers = this.moduleRegistryAdapter.createViewManagers(reactApplicationContext);
        Intrinsics.checkNotNullExpressionValue(createViewManagers, "moduleRegistryAdapter.cr…iewManagers(reactContext)");
        return createViewManagers;
    }
}
