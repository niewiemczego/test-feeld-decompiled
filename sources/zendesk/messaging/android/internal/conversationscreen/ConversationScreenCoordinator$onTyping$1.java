package zendesk.messaging.android.internal.conversationscreen;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Function0;", "", "conversationId", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationScreenCoordinator.kt */
final class ConversationScreenCoordinator$onTyping$1 extends Lambda implements Function1<String, Function0<? extends Unit>> {
    final /* synthetic */ ConversationScreenCoordinator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationScreenCoordinator$onTyping$1(ConversationScreenCoordinator conversationScreenCoordinator) {
        super(1);
        this.this$0 = conversationScreenCoordinator;
    }

    public final Function0<Unit> invoke(final String str) {
        final ConversationScreenCoordinator conversationScreenCoordinator = this.this$0;
        return new Function0<Unit>() {
            public final void invoke() {
                if (str != null) {
                    conversationScreenCoordinator.conversationTypingEvents.onTyping(str);
                }
            }
        };
    }
}
