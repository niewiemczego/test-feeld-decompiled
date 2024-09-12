package zendesk.messaging.android.internal.conversationscreen.messagelog;

import androidx.core.content.ContextCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.messaging.R;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.ui.android.conversation.textcell.TextCellRendering;
import zendesk.ui.android.conversation.textcell.TextCellState;
import zendesk.ui.android.conversation.textcell.TextCellView;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/textcell/TextCellRendering;", "textCellRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogCellFactory.kt */
final class MessageLogCellFactory$createUnsupportedCell$1$1 extends Lambda implements Function1<TextCellRendering, TextCellRendering> {
    final /* synthetic */ MessageLogEntry.MessageContainer $item;
    final /* synthetic */ TextCellView $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageLogCellFactory$createUnsupportedCell$1$1(TextCellView textCellView, MessageLogEntry.MessageContainer messageContainer) {
        super(1);
        this.$this_apply = textCellView;
        this.$item = messageContainer;
    }

    public final TextCellRendering invoke(TextCellRendering textCellRendering) {
        Intrinsics.checkNotNullParameter(textCellRendering, "textCellRendering");
        TextCellRendering.Builder builder = textCellRendering.toBuilder();
        final TextCellView textCellView = this.$this_apply;
        final MessageLogEntry.MessageContainer messageContainer = this.$item;
        return builder.state(new Function1<TextCellState, TextCellState>() {
            public final TextCellState invoke(TextCellState textCellState) {
                Intrinsics.checkNotNullParameter(textCellState, "state");
                String string = textCellView.getContext().getString(R.string.zma_conversation_message_label_cant_be_displayed);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…_label_cant_be_displayed)");
                return TextCellState.copy$default(textCellState, string, (List) null, Integer.valueOf(ContextCompat.getColor(textCellView.getContext(), R.color.zma_color_message_outbound_text)), Integer.valueOf(MessageLogCellFactory.adjustAlpha$zendesk_messaging_messaging_android$default(MessageLogCellFactory.INSTANCE, ContextCompat.getColor(textCellView.getContext(), R.color.zma_color_alert), 0.0f, 1, (Object) null)), Integer.valueOf(MessageLogCellFactory.INSTANCE.getCellDrawable(messageContainer.getShape(), messageContainer.getDirection())), (Integer) null, 34, (Object) null);
            }
        }).build();
    }
}
