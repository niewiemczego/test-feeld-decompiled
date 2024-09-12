package zendesk.conversationkit.android.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.ConversationKitStore", f = "ConversationKitStore.kt", i = {0, 1, 1}, l = {134, 144, 151}, m = "dispatch", n = {"this", "this", "effectResult"}, s = {"L$0", "L$0", "L$1"})
/* compiled from: ConversationKitStore.kt */
final class ConversationKitStore$dispatch$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationKitStore this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationKitStore$dispatch$1(ConversationKitStore conversationKitStore, Continuation<? super ConversationKitStore$dispatch$1> continuation) {
        super(continuation);
        this.this$0 = conversationKitStore;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.dispatch((Action) null, this);
    }
}
