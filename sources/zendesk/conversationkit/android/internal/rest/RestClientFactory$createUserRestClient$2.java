package zendesk.conversationkit.android.internal.rest;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.rest.RestClientFactory$createUserRestClient$2", f = "RestClientFactory.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: RestClientFactory.kt */
final class RestClientFactory$createUserRestClient$2 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ String $clientId;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RestClientFactory$createUserRestClient$2(String str, Continuation<? super RestClientFactory$createUserRestClient$2> continuation) {
        super(1, continuation);
        this.$clientId = str;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new RestClientFactory$createUserRestClient$2(this.$clientId, continuation);
    }

    public final Object invoke(Continuation<? super String> continuation) {
        return ((RestClientFactory$createUserRestClient$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.$clientId;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}