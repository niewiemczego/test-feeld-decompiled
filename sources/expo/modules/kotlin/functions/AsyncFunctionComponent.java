package expo.modules.kotlin.functions;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReadableArray;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.types.AnyType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BJ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012-\u0010\u0007\u001a)\u0012\u001d\u0012\u001b\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\f\b\n\u0012\b\b\u0002\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00010\t0\b¢\u0006\u0002\u0010\fJ\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0010¢\u0006\u0002\b\u0012J'\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0010¢\u0006\u0004\b\u0012\u0010\u0013R5\u0010\u0007\u001a)\u0012\u001d\u0012\u001b\u0012\b\b\u0001\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\f\b\n\u0012\b\b\u0002\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lexpo/modules/kotlin/functions/AsyncFunctionComponent;", "Lexpo/modules/kotlin/functions/AsyncFunction;", "name", "", "desiredArgsTypes", "", "Lexpo/modules/kotlin/types/AnyType;", "body", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "args", "(Ljava/lang/String;[Lexpo/modules/kotlin/types/AnyType;Lkotlin/jvm/functions/Function1;)V", "callUserImplementation", "", "Lcom/facebook/react/bridge/ReadableArray;", "promise", "Lexpo/modules/kotlin/Promise;", "callUserImplementation$expo_modules_core_release", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;)V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AsyncFunctionComponent.kt */
public final class AsyncFunctionComponent extends AsyncFunction {
    private final Function1<Object[], Object> body;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AsyncFunctionComponent(String str, AnyType[] anyTypeArr, Function1<? super Object[], ? extends Object> function1) {
        super(str, anyTypeArr);
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(anyTypeArr, "desiredArgsTypes");
        Intrinsics.checkNotNullParameter(function1, "body");
        this.body = function1;
    }

    public void callUserImplementation$expo_modules_core_release(ReadableArray readableArray, Promise promise) throws CodedException {
        Intrinsics.checkNotNullParameter(readableArray, StepData.ARGS);
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        promise.resolve(this.body.invoke(convertArgs(readableArray)));
    }

    public void callUserImplementation$expo_modules_core_release(Object[] objArr, Promise promise) {
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        promise.resolve(this.body.invoke(convertArgs(objArr)));
    }
}
