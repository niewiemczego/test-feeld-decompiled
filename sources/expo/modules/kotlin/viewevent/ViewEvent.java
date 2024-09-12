package expo.modules.kotlin.viewevent;

import android.content.Context;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import expo.modules.adapters.react.NativeModulesProxy;
import expo.modules.kotlin.events.EventEmitter;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.types.JSTypeConverter;
import expo.modules.kotlin.types.JSTypeConverterHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BN\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012/\u0010\t\u001a+\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\u0003\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\nj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e¢\u0006\u0002\u0010\u000fJ\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001cR7\u0010\t\u001a+\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\u0003\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\nj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lexpo/modules/kotlin/viewevent/ViewEvent;", "T", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "name", "", "type", "Lkotlin/reflect/KType;", "view", "Landroid/view/View;", "coalescingKey", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "event", "", "Lexpo/modules/kotlin/viewevent/CoalescingKey;", "(Ljava/lang/String;Lkotlin/reflect/KType;Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "module", "Lexpo/modules/kotlin/modules/Module;", "getModule$expo_modules_core_release", "()Lexpo/modules/kotlin/modules/Module;", "setModule$expo_modules_core_release", "(Lexpo/modules/kotlin/modules/Module;)V", "convertEventBody", "Lcom/facebook/react/bridge/WritableMap;", "arg", "(Ljava/lang/Object;)Lcom/facebook/react/bridge/WritableMap;", "invoke", "", "(Ljava/lang/Object;)V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ViewEvent.kt */
public final class ViewEvent<T> implements ViewEventCallback<T> {
    private final Function1<T, Short> coalescingKey;
    public Module module;
    private final String name;
    private final KType type;
    private final View view;

    public ViewEvent(String str, KType kType, View view2, Function1<? super T, Short> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(kType, "type");
        Intrinsics.checkNotNullParameter(view2, ViewHierarchyConstants.VIEW_KEY);
        this.name = str;
        this.type = kType;
        this.view = view2;
        this.coalescingKey = function1;
    }

    public final Module getModule$expo_modules_core_release() {
        Module module2 = this.module;
        if (module2 != null) {
            return module2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("module");
        return null;
    }

    public final void setModule$expo_modules_core_release(Module module2) {
        Intrinsics.checkNotNullParameter(module2, "<set-?>");
        this.module = module2;
    }

    public void invoke(T t) {
        EventEmitter callbackInvoker$expo_modules_core_release;
        Context context = this.view.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        CatalystInstance catalystInstance = ((ReactContext) context).getCatalystInstance();
        Short sh = null;
        NativeModule nativeModule = catalystInstance != null ? catalystInstance.getNativeModule("NativeUnimoduleProxy") : null;
        NativeModulesProxy nativeModulesProxy = nativeModule instanceof NativeModulesProxy ? (NativeModulesProxy) nativeModule : null;
        if (nativeModulesProxy != null && (callbackInvoker$expo_modules_core_release = nativeModulesProxy.getKotlinInteropModuleRegistry().getAppContext$expo_modules_core_release().getCallbackInvoker$expo_modules_core_release()) != null) {
            int id = this.view.getId();
            String str = this.name;
            WritableMap convertEventBody = convertEventBody(t);
            Function1<T, Short> function1 = this.coalescingKey;
            if (function1 != null) {
                sh = function1.invoke(t);
            }
            callbackInvoker$expo_modules_core_release.emit(id, str, convertEventBody, sh);
        }
    }

    private final WritableMap convertEventBody(T t) {
        Object convertToJSValue$default = JSTypeConverter.convertToJSValue$default(JSTypeConverter.INSTANCE, t, (JSTypeConverter.ContainerProvider) null, 2, (Object) null);
        boolean z = true;
        if (!(convertToJSValue$default instanceof Unit) && convertToJSValue$default != null) {
            z = false;
        }
        if (z) {
            return null;
        }
        if (convertToJSValue$default instanceof WritableMap) {
            return (WritableMap) convertToJSValue$default;
        }
        WritableMap createMap = JSTypeConverter.DefaultContainerProvider.INSTANCE.createMap();
        JSTypeConverterHelperKt.putGeneric(createMap, "payload", convertToJSValue$default);
        return createMap;
    }
}
