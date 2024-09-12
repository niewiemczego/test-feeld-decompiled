package zendesk.conversationkit.android.internal.integration;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import zendesk.conversationkit.android.internal.rest.model.ConfigResponseDto;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lzendesk/conversationkit/android/internal/rest/model/ConfigResponseDto;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.integration.IntegrationActionProcessor$getConfig$result$config$1", f = "IntegrationActionProcessor.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: IntegrationActionProcessor.kt */
final class IntegrationActionProcessor$getConfig$result$config$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ConfigResponseDto>, Object> {
    int label;
    final /* synthetic */ IntegrationActionProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntegrationActionProcessor$getConfig$result$config$1(IntegrationActionProcessor integrationActionProcessor, Continuation<? super IntegrationActionProcessor$getConfig$result$config$1> continuation) {
        super(2, continuation);
        this.this$0 = integrationActionProcessor;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IntegrationActionProcessor$getConfig$result$config$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ConfigResponseDto> continuation) {
        return ((IntegrationActionProcessor$getConfig$result$config$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.integrationRestClient.getConfig(this);
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
