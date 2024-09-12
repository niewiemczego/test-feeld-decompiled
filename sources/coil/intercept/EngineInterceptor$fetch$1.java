package coil.intercept;

import coil.ComponentRegistry;
import coil.EventListener;
import coil.request.ImageRequest;
import coil.request.Options;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {165}, m = "fetch", n = {"this", "components", "request", "mappedData", "options", "eventListener", "fetcher", "searchIndex"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"})
/* compiled from: EngineInterceptor.kt */
final class EngineInterceptor$fetch$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EngineInterceptor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EngineInterceptor$fetch$1(EngineInterceptor engineInterceptor, Continuation<? super EngineInterceptor$fetch$1> continuation) {
        super(continuation);
        this.this$0 = engineInterceptor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetch((ComponentRegistry) null, (ImageRequest) null, (Object) null, (Options) null, (EventListener) null, this);
    }
}
