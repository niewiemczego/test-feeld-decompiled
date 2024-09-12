package zendesk.conversationkit.android.internal.user;

import java.time.LocalDateTime;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.conversationkit.android.internal.Action;
import zendesk.conversationkit.android.model.Author;
import zendesk.conversationkit.android.model.Message;
import zendesk.conversationkit.android.model.MessageContent;
import zendesk.conversationkit.android.model.MessageStatus;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/conversationkit/android/model/Message;", "message", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserActionProcessor.kt */
final class UserActionProcessor$transformFailedMessage$2 extends Lambda implements Function1<Message, Message> {
    final /* synthetic */ Action.SendMessage $action;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserActionProcessor$transformFailedMessage$2(Action.SendMessage sendMessage) {
        super(1);
        this.$action = sendMessage;
    }

    public final Message invoke(Message message) {
        Message message2 = message;
        Intrinsics.checkNotNullParameter(message2, "message");
        if (!Intrinsics.areEqual((Object) message.getId(), (Object) this.$action.getMessage().getId())) {
            return message2;
        }
        return Message.copy$default(message, (String) null, (Author) null, MessageStatus.FAILED, (LocalDateTime) null, (LocalDateTime) null, 0.0d, (MessageContent) null, (Map) null, (String) null, (String) null, (String) null, 2043, (Object) null);
    }
}
