package zendesk.android.internal.frontendevents;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import zendesk.android.pageviewevents.PageView;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.android.internal.frontendevents.FrontendEventsRepository", f = "FrontendEventsRepository.kt", i = {0, 0, 1, 1, 1}, l = {34, 35, 52}, m = "sendPageViewEvent", n = {"this", "pageTitle", "this", "pageTitle", "suid"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
/* compiled from: FrontendEventsRepository.kt */
final class FrontendEventsRepository$sendPageViewEvent$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FrontendEventsRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FrontendEventsRepository$sendPageViewEvent$1(FrontendEventsRepository frontendEventsRepository, Continuation<? super FrontendEventsRepository$sendPageViewEvent$1> continuation) {
        super(continuation);
        this.this$0 = frontendEventsRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.sendPageViewEvent((PageView) null, this);
    }
}