package zendesk.messaging.android.internal.conversationscreen.delegates;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.ui.android.conversation.messagesdivider.MessagesDividerRendering;
import zendesk.ui.android.conversation.messagesdivider.MessagesDividerState;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/messagesdivider/MessagesDividerRendering;", "messagesDividerRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessagesDividerAdapterDelegate.kt */
final class MessagesDividerAdapterDelegate$ViewHolder$bind$1 extends Lambda implements Function1<MessagesDividerRendering, MessagesDividerRendering> {
    final /* synthetic */ MessagesDividerState $defaultState;
    final /* synthetic */ MessageLogEntry.MessagesDivider $item;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessagesDividerAdapterDelegate$ViewHolder$bind$1(MessageLogEntry.MessagesDivider messagesDivider, MessagesDividerState messagesDividerState) {
        super(1);
        this.$item = messagesDivider;
        this.$defaultState = messagesDividerState;
    }

    public final MessagesDividerRendering invoke(MessagesDividerRendering messagesDividerRendering) {
        Intrinsics.checkNotNullParameter(messagesDividerRendering, "messagesDividerRendering");
        MessagesDividerRendering.Builder builder = messagesDividerRendering.toBuilder();
        final MessageLogEntry.MessagesDivider messagesDivider = this.$item;
        final MessagesDividerState messagesDividerState = this.$defaultState;
        return builder.state(new Function1<MessagesDividerState, MessagesDividerState>() {
            public final MessagesDividerState invoke(MessagesDividerState messagesDividerState) {
                Intrinsics.checkNotNullParameter(messagesDividerState, "state");
                return messagesDividerState.copy(messagesDivider.getText(), messagesDividerState.getDividerColor(), messagesDividerState.getTextColor(), messagesDividerState.getTextStyle());
            }
        }).build();
    }
}
