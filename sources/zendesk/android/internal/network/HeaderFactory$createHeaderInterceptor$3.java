package zendesk.android.internal.network;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.android.internal.network.HeaderFactory$createHeaderInterceptor$3", f = "HeaderFactory.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HeaderFactory.kt */
final class HeaderFactory$createHeaderInterceptor$3 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    int label;
    final /* synthetic */ HeaderFactory this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HeaderFactory$createHeaderInterceptor$3(HeaderFactory headerFactory, Continuation<? super HeaderFactory$createHeaderInterceptor$3> continuation) {
        super(1, continuation);
        this.this$0 = headerFactory;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new HeaderFactory$createHeaderInterceptor$3(this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super String> continuation) {
        return ((HeaderFactory$createHeaderInterceptor$3) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.networkData.languageTag();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}