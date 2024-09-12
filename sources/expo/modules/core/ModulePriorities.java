package expo.modules.core;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lexpo/modules/core/ModulePriorities;", "", "()V", "SUPPORTED_MODULES", "", "", "", "get", "packageName", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ModulePriorities.kt */
public final class ModulePriorities {
    public static final ModulePriorities INSTANCE = new ModulePriorities();
    private static final Map<String, Integer> SUPPORTED_MODULES = MapsKt.mapOf(TuplesKt.to("expo.modules.updates.UpdatesPackage", 10));

    private ModulePriorities() {
    }

    public final int get(String str) {
        Integer num;
        if (str == null || (num = SUPPORTED_MODULES.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }
}
