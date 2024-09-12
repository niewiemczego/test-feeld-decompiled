package expo.modules.constants;

import android.content.Context;
import expo.modules.core.BasePackage;
import expo.modules.core.interfaces.InternalModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lexpo/modules/constants/ConstantsPackage;", "Lexpo/modules/core/BasePackage;", "()V", "createInternalModules", "", "Lexpo/modules/core/interfaces/InternalModule;", "context", "Landroid/content/Context;", "expo-constants_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConstantsPackage.kt */
public final class ConstantsPackage extends BasePackage {
    public List<InternalModule> createInternalModules(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return CollectionsKt.listOf(new ConstantsService(context));
    }
}
