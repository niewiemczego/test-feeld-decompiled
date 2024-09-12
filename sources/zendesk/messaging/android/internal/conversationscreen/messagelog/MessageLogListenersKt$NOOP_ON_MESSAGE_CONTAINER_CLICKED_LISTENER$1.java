package zendesk.messaging.android.internal.conversationscreen.messagelog;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.messaging.android.internal.model.MessageLogEntry;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogListeners.kt */
final class MessageLogListenersKt$NOOP_ON_MESSAGE_CONTAINER_CLICKED_LISTENER$1 extends Lambda implements Function1<MessageLogEntry.MessageContainer, Unit> {
    public static final MessageLogListenersKt$NOOP_ON_MESSAGE_CONTAINER_CLICKED_LISTENER$1 INSTANCE = new MessageLogListenersKt$NOOP_ON_MESSAGE_CONTAINER_CLICKED_LISTENER$1();

    MessageLogListenersKt$NOOP_ON_MESSAGE_CONTAINER_CLICKED_LISTENER$1() {
        super(1);
    }

    public final void invoke(MessageLogEntry.MessageContainer messageContainer) {
        Intrinsics.checkNotNullParameter(messageContainer, "<anonymous parameter 0>");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((MessageLogEntry.MessageContainer) obj);
        return Unit.INSTANCE;
    }
}
