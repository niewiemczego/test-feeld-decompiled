package expo.modules.keepawake;

import android.content.Context;
import expo.modules.core.ExportedModule;
import expo.modules.core.ModuleRegistryDelegate;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.Package;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lexpo/modules/keepawake/KeepAwakePackage;", "Lexpo/modules/core/interfaces/Package;", "()V", "createExportedModules", "", "Lexpo/modules/core/ExportedModule;", "context", "Landroid/content/Context;", "createInternalModules", "Lexpo/modules/core/interfaces/InternalModule;", "expo-keep-awake_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: KeepAwakePackage.kt */
public final class KeepAwakePackage implements Package {
    public List<ExportedModule> createExportedModules(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return CollectionsKt.listOf(new KeepAwakeModule(context, (ModuleRegistryDelegate) null, 2, (DefaultConstructorMarker) null));
    }

    public List<InternalModule> createInternalModules(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return CollectionsKt.listOf(new ExpoKeepAwakeManager((ModuleRegistryDelegate) null, 1, (DefaultConstructorMarker) null));
    }
}
