package zendesk.conversationkit.android.internal.app;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.app.AppActionProcessor", f = "AppActionProcessor.kt", i = {}, l = {78}, m = "processGetVisitTypeReceived", n = {}, s = {})
/* compiled from: AppActionProcessor.kt */
final class AppActionProcessor$processGetVisitTypeReceived$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppActionProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppActionProcessor$processGetVisitTypeReceived$1(AppActionProcessor appActionProcessor, Continuation<? super AppActionProcessor$processGetVisitTypeReceived$1> continuation) {
        super(continuation);
        this.this$0 = appActionProcessor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.processGetVisitTypeReceived(this);
    }
}
