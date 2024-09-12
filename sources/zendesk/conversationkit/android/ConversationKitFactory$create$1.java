package zendesk.conversationkit.android;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import zendesk.conversationkit.android.model.Config;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.ConversationKitFactory", f = "ConversationKitFactory.kt", i = {0}, l = {47}, m = "create", n = {"conversationKit"}, s = {"L$0"})
/* compiled from: ConversationKitFactory.kt */
final class ConversationKitFactory$create$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationKitFactory this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationKitFactory$create$1(ConversationKitFactory conversationKitFactory, Continuation<? super ConversationKitFactory$create$1> continuation) {
        super(continuation);
        this.this$0 = conversationKitFactory;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.create((ConversationKitSettings) null, (Config) null, this);
    }
}
