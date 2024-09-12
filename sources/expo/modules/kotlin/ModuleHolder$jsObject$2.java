package expo.modules.kotlin;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableNativeMap;
import expo.modules.kotlin.functions.AnyFunction;
import expo.modules.kotlin.jni.JavaScriptModuleObject;
import expo.modules.kotlin.objects.PropertyComponent;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ModuleHolder.kt */
final class ModuleHolder$jsObject$2 extends Lambda implements Function0<JavaScriptModuleObject> {
    final /* synthetic */ ModuleHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModuleHolder$jsObject$2(ModuleHolder moduleHolder) {
        super(0);
        this.this$0 = moduleHolder;
    }

    public final JavaScriptModuleObject invoke() {
        JavaScriptModuleObject javaScriptModuleObject = new JavaScriptModuleObject(this.this$0.getName());
        ModuleHolder moduleHolder = this.this$0;
        WritableNativeMap makeNativeMap = Arguments.makeNativeMap(moduleHolder.getDefinition().getConstantsProvider().invoke());
        Intrinsics.checkNotNullExpressionValue(makeNativeMap, "convertedConstants");
        javaScriptModuleObject.exportConstants(makeNativeMap);
        Iterator functions = moduleHolder.getDefinition().getFunctions();
        while (functions.hasNext()) {
            ((AnyFunction) functions.next()).attachToJSObject(moduleHolder.getModule().getAppContext(), javaScriptModuleObject);
        }
        for (Map.Entry<String, PropertyComponent> value : moduleHolder.getDefinition().getProperties().entrySet()) {
            ((PropertyComponent) value.getValue()).attachToJSObject(javaScriptModuleObject);
        }
        return javaScriptModuleObject;
    }
}
