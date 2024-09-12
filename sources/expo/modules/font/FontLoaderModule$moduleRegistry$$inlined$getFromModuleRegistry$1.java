package expo.modules.font;

import androidx.exifinterface.media.ExifInterface;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.ModuleRegistryDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0006\u0010\u0000\u001a\n \u0002*\u0004\u0018\u0001H\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "T", "kotlin.jvm.PlatformType", "invoke", "()Ljava/lang/Object;", "expo/modules/core/ModuleRegistryDelegate$getFromModuleRegistry$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ModuleRegistryDelegate.kt */
public final class FontLoaderModule$moduleRegistry$$inlined$getFromModuleRegistry$1 extends Lambda implements Function0<T> {
    final /* synthetic */ ModuleRegistryDelegate this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FontLoaderModule$moduleRegistry$$inlined$getFromModuleRegistry$1(ModuleRegistryDelegate moduleRegistryDelegate) {
        super(0);
        this.this$0 = moduleRegistryDelegate;
    }

    public final T invoke() {
        ModuleRegistry moduleRegistry = this.this$0.getModuleRegistry();
        Intrinsics.checkNotNull(moduleRegistry);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<Object> cls = Object.class;
        Class cls2 = cls;
        return moduleRegistry.getModule(cls);
    }
}
