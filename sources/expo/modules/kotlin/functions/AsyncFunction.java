package expo.modules.kotlin.functions;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReadableArray;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JavaScriptModuleObject;
import expo.modules.kotlin.jni.PromiseImpl;
import expo.modules.kotlin.types.AnyType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001d\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H ¢\u0006\u0002\b\u0016J'\u0010\u0015\u001a\u00020\t2\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00052\u0006\u0010\u0013\u001a\u00020\u0014H ¢\u0006\u0004\b\u0016\u0010\u0018¨\u0006\u0019"}, d2 = {"Lexpo/modules/kotlin/functions/AsyncFunction;", "Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;", "name", "", "desiredArgsTypes", "", "Lexpo/modules/kotlin/types/AnyType;", "(Ljava/lang/String;[Lexpo/modules/kotlin/types/AnyType;)V", "attachToJSObject", "", "appContext", "Lexpo/modules/kotlin/AppContext;", "jsObject", "Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "call", "holder", "Lexpo/modules/kotlin/ModuleHolder;", "args", "Lcom/facebook/react/bridge/ReadableArray;", "promise", "Lexpo/modules/kotlin/Promise;", "callUserImplementation", "callUserImplementation$expo_modules_core_release", "", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;)V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AsyncFunction.kt */
public abstract class AsyncFunction extends BaseAsyncFunctionComponent {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AsyncFunction.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Queues.values().length];
            iArr[Queues.MAIN.ordinal()] = 1;
            iArr[Queues.DEFAULT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public abstract void callUserImplementation$expo_modules_core_release(ReadableArray readableArray, Promise promise) throws CodedException;

    public abstract void callUserImplementation$expo_modules_core_release(Object[] objArr, Promise promise);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AsyncFunction(String str, AnyType[] anyTypeArr) {
        super(str, anyTypeArr);
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(anyTypeArr, "desiredArgsTypes");
    }

    public void call(ModuleHolder moduleHolder, ReadableArray readableArray, Promise promise) {
        CoroutineScope coroutineScope;
        Intrinsics.checkNotNullParameter(moduleHolder, "holder");
        Intrinsics.checkNotNullParameter(readableArray, StepData.ARGS);
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        int i = WhenMappings.$EnumSwitchMapping$0[getQueue().ordinal()];
        if (i == 1) {
            coroutineScope = moduleHolder.getModule().getAppContext().getMainQueue();
        } else if (i == 2) {
            coroutineScope = null;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        CoroutineScope coroutineScope2 = coroutineScope;
        if (coroutineScope2 == null) {
            callUserImplementation$expo_modules_core_release(readableArray, promise);
        } else {
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new AsyncFunction$call$1(promise, this, moduleHolder, readableArray, (Continuation<? super AsyncFunction$call$1>) null), 3, (Object) null);
        }
    }

    public void attachToJSObject(AppContext appContext, JavaScriptModuleObject javaScriptModuleObject) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(javaScriptModuleObject, "jsObject");
        String name = getName();
        int argsCount$expo_modules_core_release = getArgsCount$expo_modules_core_release();
        AnyType[] desiredArgsTypes = getDesiredArgsTypes();
        Collection arrayList = new ArrayList(desiredArgsTypes.length);
        for (AnyType cppRequiredTypes : desiredArgsTypes) {
            arrayList.add(cppRequiredTypes.getCppRequiredTypes());
        }
        Object[] array = ((List) arrayList).toArray(new ExpectedType[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        javaScriptModuleObject.registerAsyncFunction(name, argsCount$expo_modules_core_release, (ExpectedType[]) array, new AsyncFunction$$ExternalSyntheticLambda0(this, appContext, javaScriptModuleObject));
    }

    /* access modifiers changed from: private */
    /* renamed from: attachToJSObject$lambda-1  reason: not valid java name */
    public static final void m785attachToJSObject$lambda1(AsyncFunction asyncFunction, AppContext appContext, JavaScriptModuleObject javaScriptModuleObject, Object[] objArr, PromiseImpl promiseImpl) {
        CoroutineScope coroutineScope;
        Intrinsics.checkNotNullParameter(asyncFunction, "this$0");
        Intrinsics.checkNotNullParameter(appContext, "$appContext");
        Intrinsics.checkNotNullParameter(javaScriptModuleObject, "$jsObject");
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        Intrinsics.checkNotNullParameter(promiseImpl, "bridgePromise");
        int i = WhenMappings.$EnumSwitchMapping$0[asyncFunction.getQueue().ordinal()];
        if (i == 1) {
            coroutineScope = appContext.getMainQueue();
        } else if (i == 2) {
            coroutineScope = appContext.getModulesQueue();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AsyncFunction$attachToJSObject$2$1(promiseImpl, asyncFunction, javaScriptModuleObject, objArr, (Continuation<? super AsyncFunction$attachToJSObject$2$1>) null), 3, (Object) null);
    }
}
