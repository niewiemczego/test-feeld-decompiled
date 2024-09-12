package zendesk.conversationkit.android.internal.app;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.app.AppActionProcessor", f = "AppActionProcessor.kt", i = {0, 1, 2, 2, 3, 3, 3}, l = {101, 102, 109, 113, 133}, m = "createUser", n = {"this", "this", "this", "client", "this", "client", "user"}, s = {"L$0", "L$0", "L$0", "L$1", "L$0", "L$1", "L$2"})
/* compiled from: AppActionProcessor.kt */
final class AppActionProcessor$createUser$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppActionProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppActionProcessor$createUser$1(AppActionProcessor appActionProcessor, Continuation<? super AppActionProcessor$createUser$1> continuation) {
        super(continuation);
        this.this$0 = appActionProcessor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.createUser(this);
    }
}
