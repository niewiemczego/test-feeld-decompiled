package zendesk.messaging.android.internal.conversationscreen;

import com.amplitude.reactnative.DatabaseConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.messaging.android.internal.conversationscreen.ConversationScreenAction;
import zendesk.messaging.android.internal.model.MessageLogEntry;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lkotlin/Function1;", "Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;", "", "store", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModel;", "conversationId", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationScreenCoordinator.kt */
final class ConversationScreenCoordinator$onFailedMessageClicked$1 extends Lambda implements Function2<ConversationScreenViewModel, String, Function1<? super MessageLogEntry.MessageContainer, ? extends Unit>> {
    public static final ConversationScreenCoordinator$onFailedMessageClicked$1 INSTANCE = new ConversationScreenCoordinator$onFailedMessageClicked$1();

    ConversationScreenCoordinator$onFailedMessageClicked$1() {
        super(2);
    }

    public final Function1<MessageLogEntry.MessageContainer, Unit> invoke(final ConversationScreenViewModel conversationScreenViewModel, final String str) {
        Intrinsics.checkNotNullParameter(conversationScreenViewModel, DatabaseConstants.STORE_TABLE_NAME);
        return new Function1<MessageLogEntry.MessageContainer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((MessageLogEntry.MessageContainer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(MessageLogEntry.MessageContainer messageContainer) {
                Intrinsics.checkNotNullParameter(messageContainer, "failedMessage");
                String str = str;
                if (str != null) {
                    conversationScreenViewModel.dispatchAction(new ConversationScreenAction.ResendFailedMessage(messageContainer, str));
                }
            }
        };
    }
}
