package zendesk.conversationkit.android.internal.app;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import zendesk.conversationkit.android.internal.Action;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.app.AppActionProcessor", f = "AppActionProcessor.kt", i = {0, 0, 1, 1, 2, 2, 3, 4}, l = {144, 145, 149, 151, 156, 164}, m = "processLoginUser", n = {"this", "action", "this", "action", "this", "action", "this", "this"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0"})
/* compiled from: AppActionProcessor.kt */
final class AppActionProcessor$processLoginUser$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppActionProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppActionProcessor$processLoginUser$1(AppActionProcessor appActionProcessor, Continuation<? super AppActionProcessor$processLoginUser$1> continuation) {
        super(continuation);
        this.this$0 = appActionProcessor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.processLoginUser((Action.LoginUser) null, this);
    }
}
