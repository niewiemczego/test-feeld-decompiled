package expo.modules.kotlin.functions;

import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.FunctionCallException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.JavaScriptModuleObject;
import expo.modules.kotlin.jni.PromiseImpl;
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
@DebugMetadata(c = "expo.modules.kotlin.functions.AsyncFunction$attachToJSObject$2$1", f = "AsyncFunction.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AsyncFunction.kt */
final class AsyncFunction$attachToJSObject$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object[] $args;
    final /* synthetic */ PromiseImpl $bridgePromise;
    final /* synthetic */ JavaScriptModuleObject $jsObject;
    int label;
    final /* synthetic */ AsyncFunction this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AsyncFunction$attachToJSObject$2$1(PromiseImpl promiseImpl, AsyncFunction asyncFunction, JavaScriptModuleObject javaScriptModuleObject, Object[] objArr, Continuation<? super AsyncFunction$attachToJSObject$2$1> continuation) {
        super(2, continuation);
        this.$bridgePromise = promiseImpl;
        this.this$0 = asyncFunction;
        this.$jsObject = javaScriptModuleObject;
        this.$args = objArr;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AsyncFunction$attachToJSObject$2$1(this.$bridgePromise, this.this$0, this.$jsObject, this.$args, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AsyncFunction$attachToJSObject$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        AsyncFunction asyncFunction;
        JavaScriptModuleObject javaScriptModuleObject;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                asyncFunction = this.this$0;
                javaScriptModuleObject = this.$jsObject;
                asyncFunction.callUserImplementation$expo_modules_core_release(this.$args, (Promise) this.$bridgePromise);
                Unit unit = Unit.INSTANCE;
            } catch (CodedException e) {
                throw new FunctionCallException(asyncFunction.getName(), javaScriptModuleObject.getName(), e);
            } catch (expo.modules.core.errors.CodedException e2) {
                String code = e2.getCode();
                Intrinsics.checkNotNullExpressionValue(code, "e.code");
                throw new FunctionCallException(asyncFunction.getName(), javaScriptModuleObject.getName(), new CodedException(code, e2.getMessage(), e2.getCause()));
            } catch (CodedException e3) {
                this.$bridgePromise.reject(e3);
            } catch (Throwable th) {
                this.$bridgePromise.reject(new UnexpectedException(th));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
