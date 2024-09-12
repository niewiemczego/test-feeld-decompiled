package zendesk.android.internal.proactivemessaging;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import zendesk.logger.Logger;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.android.internal.proactivemessaging.ProactiveMessagingManager$resumeAllTimers$1$1$1", f = "ProactiveMessagingManager.kt", i = {}, l = {173, 175}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProactiveMessagingManager.kt */
final class ProactiveMessagingManager$resumeAllTimers$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EvaluationState $state;
    int label;
    final /* synthetic */ ProactiveMessagingManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProactiveMessagingManager$resumeAllTimers$1$1$1(EvaluationState evaluationState, ProactiveMessagingManager proactiveMessagingManager, Continuation<? super ProactiveMessagingManager$resumeAllTimers$1$1$1> continuation) {
        super(2, continuation);
        this.$state = evaluationState;
        this.this$0 = proactiveMessagingManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProactiveMessagingManager$resumeAllTimers$1$1$1(this.$state, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProactiveMessagingManager$resumeAllTimers$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(TimeUnit.SECONDS.toMillis(this.$state.getRemainingSeconds()), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Logger.d("PM-Manager", "From resumed Timer", new Object[0]);
        this.label = 2;
        if (this.this$0.reportToCts(this.$state.getEvaluationResults(), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
