package zendesk.conversationkit.android.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.ConversationKitStorage", f = "ConversationKitStorage.kt", i = {0}, l = {96}, m = "getVisitType", n = {"newVisit"}, s = {"L$0"})
/* compiled from: ConversationKitStorage.kt */
final class ConversationKitStorage$getVisitType$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationKitStorage this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationKitStorage$getVisitType$1(ConversationKitStorage conversationKitStorage, Continuation<? super ConversationKitStorage$getVisitType$1> continuation) {
        super(continuation);
        this.this$0 = conversationKitStorage;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getVisitType(this);
    }
}
