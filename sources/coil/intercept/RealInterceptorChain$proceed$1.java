package coil.intercept;

import coil.request.ImageRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "coil.intercept.RealInterceptorChain", f = "RealInterceptorChain.kt", i = {0, 0}, l = {25}, m = "proceed", n = {"this", "interceptor"}, s = {"L$0", "L$1"})
/* compiled from: RealInterceptorChain.kt */
final class RealInterceptorChain$proceed$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealInterceptorChain this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RealInterceptorChain$proceed$1(RealInterceptorChain realInterceptorChain, Continuation<? super RealInterceptorChain$proceed$1> continuation) {
        super(continuation);
        this.this$0 = realInterceptorChain;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.proceed((ImageRequest) null, this);
    }
}
