package zendesk.conversationkit.android.internal.integration;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.integration.IntegrationActionProcessor", f = "IntegrationActionProcessor.kt", i = {0}, l = {48}, m = "getConfig", n = {"this"}, s = {"L$0"})
/* compiled from: IntegrationActionProcessor.kt */
final class IntegrationActionProcessor$getConfig$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IntegrationActionProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IntegrationActionProcessor$getConfig$1(IntegrationActionProcessor integrationActionProcessor, Continuation<? super IntegrationActionProcessor$getConfig$1> continuation) {
        super(continuation);
        this.this$0 = integrationActionProcessor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getConfig(this);
    }
}
