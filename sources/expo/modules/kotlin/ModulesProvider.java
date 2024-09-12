package expo.modules.kotlin;

import expo.modules.kotlin.modules.Module;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0003H&¨\u0006\u0006"}, d2 = {"Lexpo/modules/kotlin/ModulesProvider;", "", "getModulesList", "", "Ljava/lang/Class;", "Lexpo/modules/kotlin/modules/Module;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ModulesProvider.kt */
public interface ModulesProvider {
    List<Class<? extends Module>> getModulesList();
}
