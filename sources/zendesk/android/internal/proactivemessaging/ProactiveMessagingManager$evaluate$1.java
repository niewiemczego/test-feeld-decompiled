package zendesk.android.internal.proactivemessaging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import zendesk.android.pageviewevents.PageView;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.android.internal.proactivemessaging.ProactiveMessagingManager", f = "ProactiveMessagingManager.kt", i = {0, 0}, l = {93}, m = "evaluate$zendesk_zendesk_android", n = {"this", "event"}, s = {"L$0", "L$1"})
/* compiled from: ProactiveMessagingManager.kt */
final class ProactiveMessagingManager$evaluate$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProactiveMessagingManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProactiveMessagingManager$evaluate$1(ProactiveMessagingManager proactiveMessagingManager, Continuation<? super ProactiveMessagingManager$evaluate$1> continuation) {
        super(continuation);
        this.this$0 = proactiveMessagingManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.evaluate$zendesk_zendesk_android((PageView) null, this);
    }
}
