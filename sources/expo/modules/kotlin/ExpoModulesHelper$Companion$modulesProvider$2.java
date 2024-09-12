package expo.modules.kotlin;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lexpo/modules/kotlin/ModulesProvider;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoModulesHelper.kt */
final class ExpoModulesHelper$Companion$modulesProvider$2 extends Lambda implements Function0<ModulesProvider> {
    public static final ExpoModulesHelper$Companion$modulesProvider$2 INSTANCE = new ExpoModulesHelper$Companion$modulesProvider$2();

    ExpoModulesHelper$Companion$modulesProvider$2() {
        super(0);
    }

    public final ModulesProvider invoke() {
        try {
            Object newInstance = Class.forName("expo.modules.ExpoModulesPackageList").newInstance();
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type expo.modules.kotlin.ModulesProvider");
            return (ModulesProvider) newInstance;
        } catch (Exception e) {
            Log.e("ExpoModulesHelper", "Couldn't get expo modules list.", e);
            ModulesProvider modulesProvider = null;
            return null;
        }
    }
}
