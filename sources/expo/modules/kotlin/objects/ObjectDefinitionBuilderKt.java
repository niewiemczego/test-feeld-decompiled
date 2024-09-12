package expo.modules.kotlin.objects;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableNativeMap;
import expo.modules.kotlin.functions.AnyFunction;
import expo.modules.kotlin.jni.JavaScriptModuleObject;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\bø\u0001\u0000\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\b2\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\t"}, d2 = {"Object", "Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "Lexpo/modules/kotlin/modules/Module;", "block", "Lkotlin/Function1;", "Lexpo/modules/kotlin/objects/ObjectDefinitionBuilder;", "", "Lkotlin/ExtensionFunctionType;", "Lexpo/modules/kotlin/modules/ModuleDefinitionBuilder;", "expo-modules-core_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class ObjectDefinitionBuilderKt {
    public static final JavaScriptModuleObject Object(ModuleDefinitionBuilder moduleDefinitionBuilder, Function1<? super ObjectDefinitionBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(moduleDefinitionBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        Module module = moduleDefinitionBuilder.getModule();
        Intrinsics.checkNotNull(module);
        ObjectDefinitionBuilder objectDefinitionBuilder = new ObjectDefinitionBuilder();
        function1.invoke(objectDefinitionBuilder);
        ObjectDefinitionData buildObject = objectDefinitionBuilder.buildObject();
        JavaScriptModuleObject javaScriptModuleObject = new JavaScriptModuleObject("[Anonymous Object]");
        WritableNativeMap makeNativeMap = Arguments.makeNativeMap(buildObject.getConstantsProvider().invoke());
        Intrinsics.checkNotNullExpressionValue(makeNativeMap, "convertedConstants");
        javaScriptModuleObject.exportConstants(makeNativeMap);
        Iterator functions = buildObject.getFunctions();
        while (functions.hasNext()) {
            ((AnyFunction) functions.next()).attachToJSObject(module.getAppContext(), javaScriptModuleObject);
        }
        for (Map.Entry<String, PropertyComponent> value : buildObject.getProperties().entrySet()) {
            ((PropertyComponent) value.getValue()).attachToJSObject(javaScriptModuleObject);
        }
        return javaScriptModuleObject;
    }

    public static final JavaScriptModuleObject Object(Module module, Function1<? super ObjectDefinitionBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        ObjectDefinitionBuilder objectDefinitionBuilder = new ObjectDefinitionBuilder();
        function1.invoke(objectDefinitionBuilder);
        ObjectDefinitionData buildObject = objectDefinitionBuilder.buildObject();
        JavaScriptModuleObject javaScriptModuleObject = new JavaScriptModuleObject("[Anonymous Object]");
        WritableNativeMap makeNativeMap = Arguments.makeNativeMap(buildObject.getConstantsProvider().invoke());
        Intrinsics.checkNotNullExpressionValue(makeNativeMap, "convertedConstants");
        javaScriptModuleObject.exportConstants(makeNativeMap);
        Iterator functions = buildObject.getFunctions();
        while (functions.hasNext()) {
            ((AnyFunction) functions.next()).attachToJSObject(module.getAppContext(), javaScriptModuleObject);
        }
        for (Map.Entry<String, PropertyComponent> value : buildObject.getProperties().entrySet()) {
            ((PropertyComponent) value.getValue()).attachToJSObject(javaScriptModuleObject);
        }
        return javaScriptModuleObject;
    }
}
