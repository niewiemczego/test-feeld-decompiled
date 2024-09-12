package expo.modules;

import android.util.Log;
import expo.modules.core.interfaces.Package;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lexpo/modules/core/interfaces/Package;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoModulesPackage.kt */
final class ExpoModulesPackage$Companion$packageList$2 extends Lambda implements Function0<List<? extends Package>> {
    public static final ExpoModulesPackage$Companion$packageList$2 INSTANCE = new ExpoModulesPackage$Companion$packageList$2();

    ExpoModulesPackage$Companion$packageList$2() {
        super(0);
    }

    public final List<Package> invoke() {
        try {
            Object invoke = Class.forName("expo.modules.ExpoModulesPackageList").getMethod("getPackageList", new Class[0]).invoke((Object) null, new Object[0]);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.collections.List<expo.modules.core.interfaces.Package>");
            return CollectionsKt.sortedWith((List) invoke, new ExpoModulesPackage$Companion$packageList$2$invoke$$inlined$sortedByDescending$1());
        } catch (Exception e) {
            Log.e("ExpoModulesPackage", "Couldn't get expo package list.", e);
            return CollectionsKt.emptyList();
        }
    }
}
