package zendesk.messaging.android.internal.conversationscreen.messagelog;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.conversationkit.android.model.MessageAction;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lzendesk/conversationkit/android/model/MessageAction$Reply;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogListeners.kt */
final class MessageLogListenersKt$NOOP_ON_QUICK_REPLY_OPTION_SELECTED_LISTENER$1 extends Lambda implements Function1<MessageAction.Reply, Unit> {
    public static final MessageLogListenersKt$NOOP_ON_QUICK_REPLY_OPTION_SELECTED_LISTENER$1 INSTANCE = new MessageLogListenersKt$NOOP_ON_QUICK_REPLY_OPTION_SELECTED_LISTENER$1();

    MessageLogListenersKt$NOOP_ON_QUICK_REPLY_OPTION_SELECTED_LISTENER$1() {
        super(1);
    }

    public final void invoke(MessageAction.Reply reply) {
        Intrinsics.checkNotNullParameter(reply, "<anonymous parameter 0>");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((MessageAction.Reply) obj);
        return Unit.INSTANCE;
    }
}
