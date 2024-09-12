package zendesk.messaging.android.internal.conversationscreen;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.conversationkit.android.model.Conversation;
import zendesk.conversationkit.android.model.Message;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lzendesk/conversationkit/android/model/Message;", "quotedMessageId", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogEntryMapper.kt */
final class MessageLogEntryMapper$map$1$messagesToShow$2$1 extends Lambda implements Function1<String, Message> {
    final /* synthetic */ Conversation $conversation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageLogEntryMapper$map$1$messagesToShow$2$1(Conversation conversation) {
        super(1);
        this.$conversation = conversation;
    }

    public final Message invoke(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "quotedMessageId");
        Iterator it = this.$conversation.getMessages().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((Message) obj).getId(), (Object) str)) {
                break;
            }
        }
        return (Message) obj;
    }
}
