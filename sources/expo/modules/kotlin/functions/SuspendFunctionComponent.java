package expo.modules.kotlin.functions;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReadableArray;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.Promise;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001Bh\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012H\u0010\u0007\u001aD\b\u0001\u0012\u0004\u0012\u00020\t\u0012\u001d\u0012\u001b\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\u0005¢\u0006\f\b\u000b\u0012\b\b\u0002\u0012\u0004\b\b(\f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\r\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016RU\u0010\u0007\u001aD\b\u0001\u0012\u0004\u0012\u00020\t\u0012\u001d\u0012\u001b\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\u0005¢\u0006\f\b\u000b\u0012\b\b\u0002\u0012\u0004\b\b(\f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\r\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\u0002\b\u000eX\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;", "name", "", "desiredArgsTypes", "", "Lexpo/modules/kotlin/types/AnyType;", "body", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "", "Lkotlin/ParameterName;", "args", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;[Lexpo/modules/kotlin/types/AnyType;Lkotlin/jvm/functions/Function3;)V", "Lkotlin/jvm/functions/Function3;", "attachToJSObject", "", "appContext", "Lexpo/modules/kotlin/AppContext;", "jsObject", "Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "call", "holder", "Lexpo/modules/kotlin/ModuleHolder;", "Lcom/facebook/react/bridge/ReadableArray;", "promise", "Lexpo/modules/kotlin/Promise;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SuspendFunctionComponent.kt */
public final class SuspendFunctionComponent extends BaseAsyncFunctionComponent {
    /* access modifiers changed from: private */
    public final Function3<CoroutineScope, Object[], Continuation<Object>, Object> body;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SuspendFunctionComponent.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Queues.values().length];
            iArr[Queues.MAIN.ordinal()] = 1;
            iArr[Queues.DEFAULT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuspendFunctionComponent(String str, AnyType[] anyTypeArr, Function3<? super CoroutineScope, ? super Object[], ? super Continuation<Object>, ? extends Object> function3) {
        super(str, anyTypeArr);
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(anyTypeArr, "desiredArgsTypes");
        Intrinsics.checkNotNullParameter(function3, "body");
        this.body = function3;
    }

    public void call(ModuleHolder moduleHolder, ReadableArray readableArray, Promise promise) {
        CoroutineScope coroutineScope;
        Intrinsics.checkNotNullParameter(moduleHolder, "holder");
        Intrinsics.checkNotNullParameter(readableArray, StepData.ARGS);
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        AppContext appContext = moduleHolder.getModule().getAppContext();
        int i = WhenMappings.$EnumSwitchMapping$0[getQueue().ordinal()];
        if (i == 1) {
            coroutineScope = appContext.getMainQueue();
        } else if (i == 2) {
            coroutineScope = appContext.getModulesQueue();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new SuspendFunctionComponent$call$1(promise, this, moduleHolder, readableArray, (Continuation<? super SuspendFunctionComponent$call$1>) null), 3, (Object) null);
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
        javaScriptModuleObject.registerAsyncFunction(name, argsCount$expo_modules_core_release, (ExpectedType[]) array, new SuspendFunctionComponent$$ExternalSyntheticLambda0(this, appContext, javaScriptModuleObject));
    }

    /* access modifiers changed from: private */
    /* renamed from: attachToJSObject$lambda-1  reason: not valid java name */
    public static final void m786attachToJSObject$lambda1(SuspendFunctionComponent suspendFunctionComponent, AppContext appContext, JavaScriptModuleObject javaScriptModuleObject, Object[] objArr, PromiseImpl promiseImpl) {
        CoroutineScope coroutineScope;
        Intrinsics.checkNotNullParameter(suspendFunctionComponent, "this$0");
        Intrinsics.checkNotNullParameter(appContext, "$appContext");
        Intrinsics.checkNotNullParameter(javaScriptModuleObject, "$jsObject");
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        Intrinsics.checkNotNullParameter(promiseImpl, "bridgePromise");
        int i = WhenMappings.$EnumSwitchMapping$0[suspendFunctionComponent.getQueue().ordinal()];
        if (i == 1) {
            coroutineScope = appContext.getMainQueue();
        } else if (i == 2) {
            coroutineScope = appContext.getModulesQueue();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new SuspendFunctionComponent$attachToJSObject$2$1(promiseImpl, suspendFunctionComponent, javaScriptModuleObject, objArr, (Continuation<? super SuspendFunctionComponent$attachToJSObject$2$1>) null), 3, (Object) null);
    }
}
