package expo.modules.kotlin;

import android.view.View;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.util.JSStackTrace;
import expo.modules.kotlin.activityresult.AppContextActivityResultCaller;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventListener;
import expo.modules.kotlin.events.EventListenerWithPayload;
import expo.modules.kotlin.events.EventListenerWithSenderAndPayload;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.FunctionCallException;
import expo.modules.kotlin.exception.MethodNotFoundException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.functions.BaseAsyncFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.jni.JavaScriptModuleObject;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.views.ViewManagerDefinition;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u0016J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 J!\u0010\u001e\u001a\u00020\u0016\"\u0004\b\u0000\u0010!2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\"\u001a\u0002H!¢\u0006\u0002\u0010#J/\u0010\u001e\u001a\u00020\u0016\"\u0004\b\u0000\u0010$\"\u0004\b\u0001\u0010!2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010%\u001a\u0002H$2\u0006\u0010\"\u001a\u0002H!¢\u0006\u0002\u0010&J\u0006\u0010'\u001a\u00020\u0016J\u0010\u0010(\u001a\f\u0012\u0006\b\u0001\u0012\u00020*\u0018\u00010)R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8FX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006+"}, d2 = {"Lexpo/modules/kotlin/ModuleHolder;", "", "module", "Lexpo/modules/kotlin/modules/Module;", "(Lexpo/modules/kotlin/modules/Module;)V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "getDefinition", "()Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "jsObject", "Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "getJsObject", "()Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "jsObject$delegate", "Lkotlin/Lazy;", "getModule", "()Lexpo/modules/kotlin/modules/Module;", "name", "", "getName", "()Ljava/lang/String;", "call", "", "methodName", "args", "Lcom/facebook/react/bridge/ReadableArray;", "promise", "Lexpo/modules/kotlin/Promise;", "callSync", "cleanUp", "post", "eventName", "Lexpo/modules/kotlin/events/EventName;", "Payload", "payload", "(Lexpo/modules/kotlin/events/EventName;Ljava/lang/Object;)V", "Sender", "sender", "(Lexpo/modules/kotlin/events/EventName;Ljava/lang/Object;Ljava/lang/Object;)V", "registerContracts", "viewClass", "Lkotlin/reflect/KClass;", "Landroid/view/View;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ModuleHolder.kt */
public final class ModuleHolder {
    private final ModuleDefinitionData definition;
    private final Lazy jsObject$delegate = LazyKt.lazy(new ModuleHolder$jsObject$2(this));
    private final Module module;

    public ModuleHolder(Module module2) {
        Intrinsics.checkNotNullParameter(module2, "module");
        this.module = module2;
        this.definition = module2.definition();
    }

    public final Module getModule() {
        return this.module;
    }

    public final ModuleDefinitionData getDefinition() {
        return this.definition;
    }

    public final String getName() {
        return this.definition.getName();
    }

    public final JavaScriptModuleObject getJsObject() {
        return (JavaScriptModuleObject) this.jsObject$delegate.getValue();
    }

    public final void call(String str, ReadableArray readableArray, Promise promise) {
        Intrinsics.checkNotNullParameter(str, JSStackTrace.METHOD_NAME_KEY);
        Intrinsics.checkNotNullParameter(readableArray, StepData.ARGS);
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        try {
            BaseAsyncFunctionComponent baseAsyncFunctionComponent = this.definition.getAsyncFunctions().get(str);
            if (baseAsyncFunctionComponent != null) {
                baseAsyncFunctionComponent.call(this, readableArray, promise);
                Unit unit = Unit.INSTANCE;
                return;
            }
            throw new MethodNotFoundException();
        } catch (CodedException e) {
            throw new FunctionCallException(str, this.definition.getName(), e);
        } catch (expo.modules.core.errors.CodedException e2) {
            String code = e2.getCode();
            Intrinsics.checkNotNullExpressionValue(code, "e.code");
            throw new FunctionCallException(str, this.definition.getName(), new CodedException(code, e2.getMessage(), e2.getCause()));
        } catch (Throwable th) {
            throw new FunctionCallException(str, this.definition.getName(), new UnexpectedException(th));
        }
    }

    public final Object callSync(String str, ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(str, JSStackTrace.METHOD_NAME_KEY);
        Intrinsics.checkNotNullParameter(readableArray, StepData.ARGS);
        SyncFunctionComponent syncFunctionComponent = this.definition.getSyncFunctions().get(str);
        if (syncFunctionComponent != null) {
            return syncFunctionComponent.call(readableArray);
        }
        throw new MethodNotFoundException();
    }

    public final void post(EventName eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        EventListener eventListener = this.definition.getEventListeners().get(eventName);
        if (eventListener != null) {
            BasicEventListener basicEventListener = eventListener instanceof BasicEventListener ? (BasicEventListener) eventListener : null;
            if (basicEventListener != null) {
                basicEventListener.call();
            }
        }
    }

    public final <Payload> void post(EventName eventName, Payload payload) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        EventListener eventListener = this.definition.getEventListeners().get(eventName);
        if (eventListener != null) {
            EventListenerWithPayload eventListenerWithPayload = eventListener instanceof EventListenerWithPayload ? (EventListenerWithPayload) eventListener : null;
            if (eventListenerWithPayload != null) {
                eventListenerWithPayload.call(payload);
            }
        }
    }

    public final <Sender, Payload> void post(EventName eventName, Sender sender, Payload payload) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        EventListener eventListener = this.definition.getEventListeners().get(eventName);
        if (eventListener != null) {
            EventListenerWithSenderAndPayload eventListenerWithSenderAndPayload = eventListener instanceof EventListenerWithSenderAndPayload ? (EventListenerWithSenderAndPayload) eventListener : null;
            if (eventListenerWithSenderAndPayload != null) {
                eventListenerWithSenderAndPayload.call(sender, payload);
            }
        }
    }

    public final void registerContracts() {
        Function2<AppContextActivityResultCaller, Continuation<? super Unit>, Object> registerContracts = this.definition.getRegisterContracts();
        if (registerContracts != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.module.getAppContext().getMainQueue(), (CoroutineContext) null, (CoroutineStart) null, new ModuleHolder$registerContracts$1$1(registerContracts, this, (Continuation<? super ModuleHolder$registerContracts$1$1>) null), 3, (Object) null);
        }
    }

    public final void cleanUp() {
        this.module.cleanUp$expo_modules_core_release();
    }

    public final KClass<? extends View> viewClass() {
        Class<? extends View> viewType$expo_modules_core_release;
        ViewManagerDefinition viewManagerDefinition = this.definition.getViewManagerDefinition();
        if (viewManagerDefinition == null || (viewType$expo_modules_core_release = viewManagerDefinition.getViewType$expo_modules_core_release()) == null) {
            return null;
        }
        return JvmClassMappingKt.getKotlinClass(viewType$expo_modules_core_release);
    }
}
