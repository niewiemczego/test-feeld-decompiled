package zendesk.messaging.android.internal.conversationscreen.messagelog;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.conversationkit.android.model.Field;
import zendesk.messaging.android.internal.model.MessageLogEntry;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "Lzendesk/conversationkit/android/model/Field;", "<anonymous parameter 1>", "Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogListeners.kt */
final class MessageLogListenersKt$NOOP_ON_FORM_COMPLETED$1 extends Lambda implements Function2<List<? extends Field>, MessageLogEntry.MessageContainer, Unit> {
    public static final MessageLogListenersKt$NOOP_ON_FORM_COMPLETED$1 INSTANCE = new MessageLogListenersKt$NOOP_ON_FORM_COMPLETED$1();

    MessageLogListenersKt$NOOP_ON_FORM_COMPLETED$1() {
        super(2);
    }

    public final void invoke(List<? extends Field> list, MessageLogEntry.MessageContainer messageContainer) {
        Intrinsics.checkNotNullParameter(list, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(messageContainer, "<anonymous parameter 1>");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((List<? extends Field>) (List) obj, (MessageLogEntry.MessageContainer) obj2);
        return Unit.INSTANCE;
    }
}
