package expo.modules.kotlin.modules;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\b"}, d2 = {"ModuleDefinition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "Lexpo/modules/kotlin/modules/Module;", "block", "Lkotlin/Function1;", "Lexpo/modules/kotlin/modules/ModuleDefinitionBuilder;", "", "Lkotlin/ExtensionFunctionType;", "expo-modules-core_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Module.kt */
public final class ModuleKt {
    public static final ModuleDefinitionData ModuleDefinition(Module module, Function1<? super ModuleDefinitionBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(module);
        function1.invoke(moduleDefinitionBuilder);
        return moduleDefinitionBuilder.buildModule();
    }
}
