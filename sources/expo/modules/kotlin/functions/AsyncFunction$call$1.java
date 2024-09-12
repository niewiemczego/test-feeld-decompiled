package expo.modules.kotlin.functions;

import com.facebook.react.bridge.ReadableArray;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.FunctionCallException;
import expo.modules.kotlin.exception.UnexpectedException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "expo.modules.kotlin.functions.AsyncFunction$call$1", f = "AsyncFunction.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AsyncFunction.kt */
final class AsyncFunction$call$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReadableArray $args;
    final /* synthetic */ ModuleHolder $holder;
    final /* synthetic */ Promise $promise;
    int label;
    final /* synthetic */ AsyncFunction this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AsyncFunction$call$1(Promise promise, AsyncFunction asyncFunction, ModuleHolder moduleHolder, ReadableArray readableArray, Continuation<? super AsyncFunction$call$1> continuation) {
        super(2, continuation);
        this.$promise = promise;
        this.this$0 = asyncFunction;
        this.$holder = moduleHolder;
        this.$args = readableArray;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AsyncFunction$call$1(this.$promise, this.this$0, this.$holder, this.$args, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AsyncFunction$call$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        AsyncFunction asyncFunction;
        ModuleHolder moduleHolder;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                asyncFunction = this.this$0;
                moduleHolder = this.$holder;
                asyncFunction.callUserImplementation$expo_modules_core_release(this.$args, this.$promise);
                Unit unit = Unit.INSTANCE;
            } catch (CodedException e) {
                throw new FunctionCallException(asyncFunction.getName(), moduleHolder.getName(), e);
            } catch (expo.modules.core.errors.CodedException e2) {
                String code = e2.getCode();
                Intrinsics.checkNotNullExpressionValue(code, "e.code");
                throw new FunctionCallException(asyncFunction.getName(), moduleHolder.getName(), new CodedException(code, e2.getMessage(), e2.getCause()));
            } catch (CodedException e3) {
                this.$promise.reject(e3);
            } catch (Throwable th) {
                this.$promise.reject(new UnexpectedException(th));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
