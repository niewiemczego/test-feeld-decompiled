package expo.modules.kotlin.functions;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.react.bridge.ReadableArray;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.FunctionCallException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JavaScriptModuleObject;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.JSTypeConverter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BJ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012-\u0010\u0007\u001a)\u0012\u001d\u0012\u001b\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\f\b\n\u0012\b\b\u0002\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00010\t0\b¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0014J\u001d\u0010\u0013\u001a\u0004\u0018\u00010\t2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0002\u0010\u0015R5\u0010\u0007\u001a)\u0012\u001d\u0012\u001b\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\f\b\n\u0012\b\b\u0002\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "Lexpo/modules/kotlin/functions/AnyFunction;", "name", "", "desiredArgsTypes", "", "Lexpo/modules/kotlin/types/AnyType;", "body", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "args", "(Ljava/lang/String;[Lexpo/modules/kotlin/types/AnyType;Lkotlin/jvm/functions/Function1;)V", "attachToJSObject", "", "appContext", "Lexpo/modules/kotlin/AppContext;", "jsObject", "Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "call", "Lcom/facebook/react/bridge/ReadableArray;", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SyncFunctionComponent.kt */
public final class SyncFunctionComponent extends AnyFunction {
    private final Function1<Object[], Object> body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SyncFunctionComponent(String str, AnyType[] anyTypeArr, Function1<? super Object[], ? extends Object> function1) {
        super(str, anyTypeArr);
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(anyTypeArr, "desiredArgsTypes");
        Intrinsics.checkNotNullParameter(function1, "body");
        this.body = function1;
    }

    public final Object call(ReadableArray readableArray) throws CodedException {
        Intrinsics.checkNotNullParameter(readableArray, StepData.ARGS);
        return this.body.invoke(convertArgs(readableArray));
    }

    public final Object call(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        return this.body.invoke(convertArgs(objArr));
    }

    public void attachToJSObject(AppContext appContext, JavaScriptModuleObject javaScriptModuleObject) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(javaScriptModuleObject, "jsObject");
        String name = getName();
        int argsCount$expo_modules_core_release = getArgsCount$expo_modules_core_release();
        Object[] array = getCppRequiredTypes().toArray(new ExpectedType[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        javaScriptModuleObject.registerSyncFunction(name, argsCount$expo_modules_core_release, (ExpectedType[]) array, new SyncFunctionComponent$$ExternalSyntheticLambda0(this, javaScriptModuleObject));
    }

    /* access modifiers changed from: private */
    /* renamed from: attachToJSObject$lambda-2  reason: not valid java name */
    public static final Object m787attachToJSObject$lambda2(SyncFunctionComponent syncFunctionComponent, JavaScriptModuleObject javaScriptModuleObject, Object[] objArr) {
        Intrinsics.checkNotNullParameter(syncFunctionComponent, "this$0");
        Intrinsics.checkNotNullParameter(javaScriptModuleObject, "$jsObject");
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        try {
            return JSTypeConverter.convertToJSValue$default(JSTypeConverter.INSTANCE, syncFunctionComponent.call(objArr), (JSTypeConverter.ContainerProvider) null, 2, (Object) null);
        } catch (CodedException e) {
            throw new FunctionCallException(syncFunctionComponent.getName(), javaScriptModuleObject.getName(), e);
        } catch (expo.modules.core.errors.CodedException e2) {
            String code = e2.getCode();
            Intrinsics.checkNotNullExpressionValue(code, "e.code");
            throw new FunctionCallException(syncFunctionComponent.getName(), javaScriptModuleObject.getName(), new CodedException(code, e2.getMessage(), e2.getCause()));
        } catch (Throwable th) {
            throw new FunctionCallException(syncFunctionComponent.getName(), javaScriptModuleObject.getName(), new UnexpectedException(th));
        }
    }
}
