package zendesk.messaging.android.internal.conversationscreen.messagelog;

import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.messaging.R;
import zendesk.ui.android.conversation.typingindicatorcell.TypingIndicatorCellRendering;
import zendesk.ui.android.conversation.typingindicatorcell.TypingIndicatorCellState;
import zendesk.ui.android.conversation.typingindicatorcell.TypingIndicatorCellView;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/typingindicatorcell/TypingIndicatorCellRendering;", "typingIndicatorCellRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogCellFactory.kt */
final class MessageLogCellFactory$createTypingIndicatorCell$1$1 extends Lambda implements Function1<TypingIndicatorCellRendering, TypingIndicatorCellRendering> {
    final /* synthetic */ TypingIndicatorCellView $this_apply;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageLogCellFactory$createTypingIndicatorCell$1$1(TypingIndicatorCellView typingIndicatorCellView) {
        super(1);
        this.$this_apply = typingIndicatorCellView;
    }

    public final TypingIndicatorCellRendering invoke(TypingIndicatorCellRendering typingIndicatorCellRendering) {
        Intrinsics.checkNotNullParameter(typingIndicatorCellRendering, "typingIndicatorCellRendering");
        TypingIndicatorCellRendering.Builder builder = typingIndicatorCellRendering.toBuilder();
        final TypingIndicatorCellView typingIndicatorCellView = this.$this_apply;
        return builder.state(new Function1<TypingIndicatorCellState, TypingIndicatorCellState>() {
            public final TypingIndicatorCellState invoke(TypingIndicatorCellState typingIndicatorCellState) {
                Intrinsics.checkNotNullParameter(typingIndicatorCellState, "state");
                return typingIndicatorCellState.copy(Integer.valueOf(ContextCompat.getColor(typingIndicatorCellView.getContext(), R.color.zma_color_message_inbound_background)));
            }
        }).build();
    }
}
