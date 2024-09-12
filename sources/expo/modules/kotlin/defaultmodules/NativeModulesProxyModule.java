package expo.modules.kotlin.defaultmodules;

import com.facebook.react.bridge.ReadableArray;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.functions.AsyncFunction;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lexpo/modules/kotlin/defaultmodules/NativeModulesProxyModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NativeModulesProxyModule.kt */
public final class NativeModulesProxyModule extends Module {
    public ModuleDefinitionData definition() {
        AsyncFunction asyncFunction;
        ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(this);
        moduleDefinitionBuilder.Name(NativeModulesProxyModuleKt.NativeModulesProxyModuleName);
        moduleDefinitionBuilder.Constants((Function0<? extends Map<String, ? extends Object>>) new NativeModulesProxyModule$definition$1$1(this));
        ObjectDefinitionBuilder objectDefinitionBuilder = moduleDefinitionBuilder;
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Promise.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            asyncFunction = new AsyncFunctionWithPromiseComponent("callMethod", new AnyType[]{AnyTypeKt.toAnyType(Reflection.typeOf(String.class)), AnyTypeKt.toAnyType(Reflection.typeOf(String.class)), AnyTypeKt.toAnyType(Reflection.typeOf(ReadableArray.class))}, new NativeModulesProxyModule$definition$lambda1$$inlined$AsyncFunction$1(this));
        } else {
            asyncFunction = new AsyncFunctionComponent("callMethod", new AnyType[]{AnyTypeKt.toAnyType(Reflection.typeOf(String.class)), AnyTypeKt.toAnyType(Reflection.typeOf(String.class)), AnyTypeKt.toAnyType(Reflection.typeOf(ReadableArray.class)), AnyTypeKt.toAnyType(Reflection.typeOf(Promise.class))}, new NativeModulesProxyModule$definition$lambda1$$inlined$AsyncFunction$2(this));
        }
        objectDefinitionBuilder.getAsyncFunctions().put("callMethod", asyncFunction);
        return moduleDefinitionBuilder.buildModule();
    }
}
