package zendesk.okhttp;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.okhttp.HeaderInterceptor$intercept$headerValue$1", f = "HeaderInterceptor.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HeaderInterceptor.kt */
final class HeaderInterceptor$intercept$headerValue$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Function1<Continuation<? super String>, Object> $headerValueProvider;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HeaderInterceptor$intercept$headerValue$1(Function1<? super Continuation<? super String>, ? extends Object> function1, Continuation<? super HeaderInterceptor$intercept$headerValue$1> continuation) {
        super(2, continuation);
        this.$headerValueProvider = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HeaderInterceptor$intercept$headerValue$1(this.$headerValueProvider, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((HeaderInterceptor$intercept$headerValue$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super String>, Object> function1 = this.$headerValueProvider;
            this.label = 1;
            obj = function1.invoke(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
