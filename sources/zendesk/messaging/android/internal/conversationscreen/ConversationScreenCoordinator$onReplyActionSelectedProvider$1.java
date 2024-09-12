package zendesk.messaging.android.internal.conversationscreen;

import com.amplitude.reactnative.DatabaseConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.conversationkit.android.model.MessageAction;
import zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lkotlin/Function1;", "Lzendesk/conversationkit/android/model/MessageAction$Reply;", "", "store", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModel;", "conversationId", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationScreenCoordinator.kt */
final class ConversationScreenCoordinator$onReplyActionSelectedProvider$1 extends Lambda implements Function2<ConversationScreenViewModel, String, Function1<? super MessageAction.Reply, ? extends Unit>> {
    public static final ConversationScreenCoordinator$onReplyActionSelectedProvider$1 INSTANCE = new ConversationScreenCoordinator$onReplyActionSelectedProvider$1();

    ConversationScreenCoordinator$onReplyActionSelectedProvider$1() {
        super(2);
    }

    public final Function1<MessageAction.Reply, Unit> invoke(final ConversationScreenViewModel conversationScreenViewModel, final String str) {
        Intrinsics.checkNotNullParameter(conversationScreenViewModel, DatabaseConstants.STORE_TABLE_NAME);
        return new Function1<MessageAction.Reply, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((MessageAction.Reply) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(MessageAction.Reply reply) {
                Intrinsics.checkNotNullParameter(reply, "replyAction");
                String str = str;
                if (str != null) {
                    conversationScreenViewModel.dispatchAction(new ConversationScreenAction.SendTextMessage(reply.getText(), reply.getPayload(), reply.getMetadata(), str));
                }
            }
        };
    }
}
