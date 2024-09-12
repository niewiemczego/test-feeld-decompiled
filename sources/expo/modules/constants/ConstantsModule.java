package expo.modules.constants;

import expo.modules.kotlin.functions.AsyncFunction;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lexpo/modules/constants/ConstantsModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-constants_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConstantsModule.kt */
public final class ConstantsModule extends Module {
    public ModuleDefinitionData definition() {
        ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(this);
        moduleDefinitionBuilder.Name("ExponentConstants");
        moduleDefinitionBuilder.Constants((Function0<? extends Map<String, ? extends Object>>) new ConstantsModule$definition$1$1(this));
        AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent("getWebViewUserAgentAsync", new AnyType[0], new ConstantsModule$definition$lambda1$$inlined$AsyncFunctionWithoutArgs$1());
        moduleDefinitionBuilder.getAsyncFunctions().put("getWebViewUserAgentAsync", asyncFunctionComponent);
        AsyncFunction asyncFunction = asyncFunctionComponent;
        return moduleDefinitionBuilder.buildModule();
    }
}
